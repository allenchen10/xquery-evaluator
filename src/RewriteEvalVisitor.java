import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RewriteEvalVisitor extends RewriteBaseVisitor<String> {

    private Map<String, String> equal;
    private Map<String, Map<String, List<String>>> joins;
    private Map<String, String> roots;
    private List<String> joined;
    private List<String> nonJoined;

    @Override
    public String visitXq(RewriteParser.XqContext ctx) {
        Map<String, List<String>> desc = new HashMap<>();
        Map<String, List<String>> dependents = new HashMap<>();
        Map<String, String> binding = new HashMap<>();
        equal = new HashMap<>();
        joins = new HashMap<>();
        roots = new HashMap<>();
        joined = new ArrayList<>();
        nonJoined = new ArrayList<>();
        List<RewriteParser.VarContext> vars = ctx.var();
        List<RewriteParser.PathContext> paths = ctx.path();
        for (int i = 0; i < vars.size(); i++) {
            binding.put(vars.get(i).varName.getText(), visitPath(paths.get(i)));
            if (paths.get(i).fileName != null) {
                nonJoined.add(vars.get(i).varName.getText());
                List<String> descList = new ArrayList<>();
                descList.add(vars.get(i).varName.getText());
                desc.put(vars.get(i).varName.getText(), descList);
            } else {
                if (dependents.containsKey(paths.get(i).var().varName.getText())) {
                    dependents.get(paths.get(i).var().varName.getText()).add(vars.get(i).varName.getText());
                } else {
                    List<String> dependList = new ArrayList<>();
                    dependList.add(vars.get(i).varName.getText());
                    dependents.put(paths.get(i).var().varName.getText(), dependList);
                }
            }
        }
        for (String root:
             desc.keySet()) {
            List<String> curr = new ArrayList<>();
            curr.add(root);
            roots.put(root, root);
            while (!curr.isEmpty()) {
                String node = curr.remove(0);
                if (dependents.containsKey(node)) {
                    List<String> children = dependents.get(node);
                    desc.get(root).addAll(children);
                    curr.addAll(children);
                    for (String child:
                         children) {
                        roots.put(child, root);
                    }
                }
            }
        }
        visitCond(ctx.cond());
        StringBuilder result = new StringBuilder();
        StringBuilder forStr = new StringBuilder();
        StringBuilder whereStr = new StringBuilder();
        StringBuilder returnStr = new StringBuilder();
        Map<String, List<String>> joinMap = joins.get(joined.get(0));
        for (String var:
             desc.get(joined.get(0))) {
            if (forStr.length() > 0) {
                forStr.append(",\n");
            }
            forStr.append("$").append(var).append(" in ").append(binding.get(var));
            if (equal.containsKey(var)) {
                if (whereStr.length() == 0) {
                    whereStr.append("\nwhere ");
                } else {
                    whereStr.append(" and ");
                }
                whereStr.append("$").append(var).append(" eq ").append(equal.get(var));
            }
            if (returnStr.length() > 0) {
                returnStr.append(",\n");
            }
            returnStr.append("<").append(var).append(">{$").append(var).append("}</").append(var).append(">");
        }
        for (String root:
             nonJoined) {
            for (String var:
                    desc.get(root)) {
                forStr.append(",\n$").append(var).append(" in ").append(binding.get(var));
                if (equal.containsKey(var)) {
                    if (whereStr.length() == 0) {
                        whereStr.append("\nwhere ");
                    } else {
                        whereStr.append(" and ");
                    }
                    whereStr.append("$").append(var).append(" eq ").append(equal.get(var));
                }
                returnStr.append(",\n<").append(var).append(">{$").append(var).append("}</").append(var).append(">");
            }
        }
        result.append("for ").append(forStr).append(whereStr).append("\nreturn <tuple>{\n").append(returnStr).append("\n}</tuple>");
        while (!joinMap.isEmpty()) {
            for (String toJoin:
                 joinMap.keySet()) {
                forStr = new StringBuilder();
                whereStr = new StringBuilder();
                returnStr = new StringBuilder();
                StringBuilder attr1 = new StringBuilder();
                StringBuilder attr2 = new StringBuilder();
                for (String var:
                    desc.get(toJoin)) {
                    if (forStr.length() > 0) {
                        forStr.append(",\n");
                    }
                    forStr.append("$").append(var).append(" in ").append(binding.get(var));
                    if (equal.containsKey(var)) {
                        if (whereStr.length() == 0) {
                            whereStr.append("\nwhere ");
                        } else {
                            whereStr.append(" and ");
                        }
                        whereStr.append("$").append(var).append(" eq ").append(equal.get(var));
                    }
                    if (returnStr.length() > 0) {
                        returnStr.append(",\n");
                    }
                    returnStr.append("<").append(var).append(">{$").append(var).append("}</").append(var).append(">");
                }
                for (String var1:
                     joinMap.get(toJoin)) {
                    if (attr1.length() == 0) {
                        attr1.append("[");
                    } else {
                        attr1.append(", ");
                    }
                    attr1.append(var1);
                }
                attr1.append("]");
                for (String var2:
                     joins.get(toJoin).get(joined.get(0))) {
                    if (attr2.length() == 0) {
                        attr2.append("[");
                    } else {
                        attr2.append(", ");
                    }
                    attr2.append(var2);
                }
                attr2.append("]");
                result = new StringBuilder("join (\n" + result + ",\n" + "for " + forStr + whereStr + "\nreturn <tuple>{\n"
                        + returnStr + "\n}</tuple>,\n" + attr1 + ", " + attr2 + "\n)");
                joinMap.remove(toJoin);
                for (String joinNext:
                     joins.get(toJoin).keySet()) {
                    if (!joinNext.equals(joined.get(0))) {
                        if (joinMap.containsKey(joinNext)) {
                            joinMap.get(joinNext).addAll(joins.get(toJoin).get(joinNext));
                            joins.get(joinNext).get(joined.get(0)).addAll(joins.get(joinNext).get(toJoin));
                        } else {
                            joinMap.put(joinNext, joins.get(toJoin).get(joinNext));
                            joins.get(joinNext).put(joined.get(0), joins.get(joinNext).get(toJoin));
                        }
                        joins.get(joinNext).remove(toJoin);
                    }
                }
                break;
            }
        }
        result = new StringBuilder("for $tuple in " + result + "\n" + visitRet(ctx.ret()));
        return result.toString();
    }

    @Override
    public String visitVar(RewriteParser.VarContext ctx) {
        return "$" + ctx.varName.getText();
    }

    @Override
    public String visitPath(RewriteParser.PathContext ctx) {
        StringBuilder str = new StringBuilder();
        if (ctx.fileName != null) {
            str.append("doc(").append(ctx.fileName.getText()).append(")");
        } else {
            str.append(visitVar(ctx.var()));
        }
        List<RewriteParser.SepContext> seps = ctx.sep();
        for (int i = 0; i < seps.size() - 1; i++) {
            str.append(visitSep(ctx.sep(i)));
            str.append(ctx.ID(i));
        }
        str.append(visitSep(ctx.sep(seps.size() - 1)));
        if (ctx.tagName != null) {
            str.append(ctx.tagName.getText());
        } else {
            str.append("text()");
        }
        return str.toString();
    }

    @Override
    public String visitSep(RewriteParser.SepContext ctx) {
        return ctx.op.getText();
    }

    @Override
    public String visitRet(RewriteParser.RetContext ctx) {
        if (ctx.var() != null) {
            return "$tuple/" + ctx.var().varName.getText() + "/*";
        }
        if (ctx.path() != null) {
            String path = visitPath(ctx.path());
            return "$tuple/" + path.substring(1, path.indexOf("/")) + "/*" + path.substring(path.indexOf("/"));
        }
        if (ctx.ret().size() == 2) {
            return visitRet(ctx.ret(0)) + ", " + visitRet(ctx.ret(1));
        }
        return "return <" + ctx.tagName.getText() + ">{\n" + visitRet(ctx.ret(0)) + "\n}</" + ctx.tagName.getText() + ">";
    }

    @Override
    public String visitCond(RewriteParser.CondContext ctx) {
        if (ctx.cond(0) != null) {
            visitCond(ctx.cond(0));
            visitCond(ctx.cond(1));
        } else {
            List<RewriteParser.VarContext> vars = ctx.var();
            if (vars.size() == 1) {
                equal.put(vars.get(0).varName.getText(), ctx.constant.getText());
            } else {
                String var1 = vars.get(0).varName.getText();
                String var2 = vars.get(1).varName.getText();
                String root1 = roots.get(var1);
                String root2 = roots.get(var2);
                if (joins.containsKey(root1)) {
                    if (joins.get(root1).containsKey(root2)) {
                        joins.get(root1).get(root2).add(var1);
                    } else {
                        List<String> joinList = new ArrayList<>();
                        joinList.add(var1);
                        joins.get(root1).put(root2, joinList);
                    }
                } else {
                    nonJoined.remove(root1);
                    joined.add(root1);
                    Map<String, List<String>> joinMap = new HashMap<>();
                    List<String> joinList = new ArrayList<>();
                    joinList.add(var1);
                    joinMap.put(root2, joinList);
                    joins.put(root1, joinMap);
                }
                if (joins.containsKey(root2)) {
                    if (joins.get(root2).containsKey(root1)) {
                        joins.get(root2).get(root1).add(var2);
                    } else {
                        List<String> joinList = new ArrayList<>();
                        joinList.add(var2);
                        joins.get(root2).put(root1, joinList);
                    }
                } else {
                    nonJoined.remove(root2);
                    joined.add(root2);
                    Map<String, List<String>> joinMap = new HashMap<>();
                    List<String> joinList = new ArrayList<>();
                    joinList.add(var2);
                    joinMap.put(root1, joinList);
                    joins.put(root2, joinMap);
                }
            }
        }
        return "";
    }
}
