import org.antlr.v4.runtime.tree.TerminalNode;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XPathEvalVisitor extends XPathBaseVisitor<Map<String, List<Node>>> {

    private Document doc;

    @Override
    public Map<String, List<Node>> visitXq(XPathParser.XqContext ctx) {
        Map<String, List<Node>> dict = new HashMap<>();
        dict.put("", null);
        return visitXq(ctx, dict);
    }

    private Map<String, List<Node>> visitForClause(XPathParser.XqContext ctx, Map<String, List<Node>> dict, int applied) {
        // for
        XPathParser.ForClauseContext forCtx = ctx.forClause();
        List<XPathParser.VarContext> vars = forCtx.var();
        if (vars.size() - applied > 0) {
            String varName = vars.get(applied).varName.getText();
            List<Node> nodes = visitXq(forCtx.xq(applied), dict).get("");
            List<Node> curr = new ArrayList<>();
            List<Node> result = new ArrayList<>();
            for (Node node :
                    nodes) {
                curr.clear();
                curr.add(node);
                if (dict.containsKey(varName)) {
                    dict.replace(varName, curr);
                } else {
                    dict.put(varName, curr);
                }
                result.addAll(visitForClause(ctx, dict, applied + 1).get(""));
            }
            dict.replace("", result);
            return dict;
        }
        if (ctx.letClause() != null) {
            return visitLetClause(ctx, dict, 0);
        }
        return visitWhereClause(ctx, dict);
    }

    private Map<String, List<Node>> visitLetClause(XPathParser.XqContext ctx, Map<String, List<Node>> dict, int applied) {
        XPathParser.LetClauseContext letCtx = ctx.letClause();
        List<XPathParser.VarContext> vars = letCtx.var();
        if (vars.size() - applied > 0) {
            String varName = vars.get(applied).varName.getText();
            List<Node> nodes = visitXq(letCtx.xq(applied), dict).get("");
            dict.replace(varName, nodes);
            return visitLetClause(ctx, dict, applied + 1);
        }
        if (ctx.whereClause() != null) {
            return visitWhereClause(ctx, dict);
        }
        return visitXq(ctx.xq(0));
    }

    private Map<String, List<Node>> visitWhereClause(XPathParser.XqContext ctx, Map<String, List<Node>> dict) {
        if (ctx.whereClause() != null) {
            XPathParser.CondContext cndCtx = ctx.whereClause().cond();
            if (!visitCond(cndCtx, dict, 0)) {
                dict.replace("", new ArrayList<>());
                return dict;
            }
        }
        // return
        XPathParser.ReturnClauseContext retCtx = ctx.returnClause();
        return visitXq(retCtx.xq(), dict);
    }

    public boolean visitCond(XPathParser.CondContext ctx, Map<String, List<Node>> dict, int applied) {
        switch (ctx.op.getText()) {
            case "=":
            case "eq":
                List<Node> leftNodes = visitXq(ctx.xq(0), dict).get("");
                List<Node> rightNodes = visitXq(ctx.xq(1), dict).get("");
                boolean same = false;
                for (Node left :
                        leftNodes) {
                    for (Node right :
                            rightNodes) {
                        if (left.isEqualNode(right)) {
                            same = true;
                            break;
                        }
                    }
                }
                return same;
            case "==":
            case "is":
                leftNodes = visitXq(ctx.xq(0), dict).get("");
                rightNodes = visitXq(ctx.xq(1), dict).get("");
                leftNodes.retainAll(rightNodes);
                return !leftNodes.isEmpty();
            case "empty":
                List<Node> nodes = visitXq(ctx.xq(0), dict).get("");
                return nodes.isEmpty();
            case "some":
                List<XPathParser.VarContext> vars = ctx.var();
                if (vars.size() - applied > 0) {
                    String varName = vars.get(applied).varName.getText();
                    nodes = visitXq(ctx.xq(applied), dict).get("");
                    List<Node> curr = new ArrayList<>();
                    boolean result = false;
                    for (Node node :
                            nodes) {
                        curr.clear();
                        curr.add(node);
                        if (dict.containsKey(varName)) {
                            dict.replace(varName, curr);
                        } else {
                            dict.put(varName, curr);
                        }
                        if (visitCond(ctx, dict, applied + 1)) {
                            result = true;
                            break;
                        }
                    }
                    return result;
                }
                return visitCond(ctx.cond(0), dict, 0);
            case "(":
                return visitCond(ctx.cond(0), dict, 0);
            case "and":
                return visitCond(ctx.cond(0), dict, 0) && visitCond(ctx.cond(1), dict, 0);
            case "or":
                return visitCond(ctx.cond(0), dict, 0) || visitCond(ctx.cond(1), dict, 0);
            case "not":
                return !visitCond(ctx.cond(0), dict, 0);
        }
        return false;
    }

    public Map<String, List<Node>> visitXq(XPathParser.XqContext ctx, Map<String, List<Node>> dict) {
        if (ctx.op == null) {
            if (ctx.var() != null) {
                dict.replace("", dict.get(ctx.var().varName.getText()));
                return dict;
            }
            if (ctx.ap() != null) {
                return visitAp(ctx.ap());
            }
            if (ctx.text != null) {
                String str = ctx.text.getText();
                str = str.substring(1, str.length() - 1);
                Node text = makeText(str);
                dict.replace("", new ArrayList<>());
                dict.get("").add(text);
                return dict;
            }
            if (ctx.forClause() != null) {
                return visitForClause(ctx, dict, 0);
            }
        }
        switch (ctx.op.getText()) {
            case "(":
                return visitXq(ctx.xq(0), dict);
            case ",":
                dict = visitXq(ctx.xq(0), dict);
                List<Node> current = dict.get("");
                current.addAll(visitXq(ctx.xq(1), dict).get(""));
                dict.replace("", current);
                return dict;
            case "/":
                dict = visitXq(ctx.xq(0), dict);
                current = visitRp(ctx.rp(), dict.get(""));
                List<Node> result = new ArrayList<>();
                for (Node node :
                        current) {
                    if (!result.contains(node)) {
                        result.add(node);
                    }
                }
                dict.replace("", result);
                return dict;
            case "//":
                current = visitXq(ctx.xq(0), dict).get("");
                List<Node> descendants = new ArrayList<>();
                for (Node node :
                        current) {
                    descendants.addAll(descendantNodes(node));
                }
                current = visitRp(ctx.rp(), descendants);
                result = new ArrayList<>();
                for (Node node :
                        current) {
                    if (!result.contains(node)) {
                        result.add(node);
                    }
                }
                dict.replace("", result);
                return dict;
            case "<":
                Node elem = makeElem(ctx.tagName.getText(), visitXq(ctx.xq(0), dict).get(""));
                dict.replace("", new ArrayList<>());
                dict.get("").add(elem);
                return dict;
            case "join":
                XPathParser.AttrContext attr1 = ctx.attr(0);
                XPathParser.AttrContext attr2 = ctx.attr(1);
                List<String> keyList = new ArrayList<>();
                result = new ArrayList<>();
                for (TerminalNode keyName :
                        attr1.ID()) {
                    keyList.add(keyName.getText());
                }
                List<Node> tuples = visitXq(ctx.xq(0), dict).get("");
                Map<String, List<Node>> joinMap = new HashMap<>();
                for (Node tuple1 :
                        tuples) {
                    Node child = tuple1.getFirstChild();
                    StringBuilder key = new StringBuilder();
                    while (child != null) {
                        if (keyList.contains(child.getNodeName())) {
                            key.append(child.getTextContent().hashCode());
                        }
                        child = child.getNextSibling();
                    }
                    if (joinMap.containsKey(key.toString())) {
                        joinMap.get(key.toString()).add(tuple1);
                    } else {
                        List<Node> nodeList = new ArrayList<>();
                        nodeList.add(tuple1);
                        joinMap.put(key.toString(), nodeList);
                    }
                }
                tuples = visitXq(ctx.xq(1), dict).get("");
                keyList = new ArrayList<>();
                for (TerminalNode keyName :
                        attr2.ID()) {
                    keyList.add(keyName.getText());
                }
                for (Node tuple2 :
                        tuples) {
                    Node child = tuple2.getFirstChild();
                    StringBuilder key = new StringBuilder();
                    while (child != null) {
                        if (keyList.contains(child.getNodeName())) {
                            key.append(child.getTextContent().hashCode());
                        }
                        child = child.getNextSibling();
                    }
                    if (joinMap.containsKey(key.toString())) {
                        List<Node> nodeList = joinMap.get(key.toString());
                        for (Node tuple1 :
                                nodeList) {
                            Node tuple = doc.createElement("tuple");
                            child = tuple1.getFirstChild();
                            while (child != null) {
                                tuple.appendChild(doc.adoptNode(child.cloneNode(true)));
                                child = child.getNextSibling();
                            }
                            child = tuple2.getFirstChild();
                            while (child != null) {
                                tuple.appendChild(doc.adoptNode(child.cloneNode(true)));
                                child = child.getNextSibling();
                            }
                            result.add(tuple);
                        }
                    }
                }
                dict.replace("", result);
                return dict;
        }
        return dict;
    }

    private Node makeText(String text) {
        return doc.createTextNode(text);
    }

    private Node makeElem(String tagName, List<Node> nodes) {
        Node root = doc.createElement(tagName);
        for (Node node :
                nodes) {
            root.appendChild(doc.adoptNode(node.cloneNode(true)));
        }
        return root;
    }

    @Override
    public Map<String, List<Node>> visitAp(XPathParser.ApContext ctx) {
        String fileNameText = ctx.STRING().getText();
        fileNameText = fileNameText.substring(1, fileNameText.length() - 1);
        try {
            File inputFile = new File(fileNameText);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Node> nodes = new ArrayList<>();
        if (ctx.op.getText().equals("//")) {
            nodes.addAll(descendantNodes(doc.getDocumentElement().getParentNode()));
        } else {
            nodes.add(doc.getDocumentElement().getParentNode());
        }
        Map<String, List<Node>> dict = new HashMap<>();
        dict.put("", visitRp(ctx.rp(), nodes));
        return dict;
    }

    private List<Node> descendantNodes(Node node) {
        List<Node> descendants = new ArrayList<>();
        descendants.add(node);
        Node child = node.getFirstChild();
        while (child != null) {
            descendants.addAll(descendantNodes(child));
            child = child.getNextSibling();
        }
        return descendants;
    }

    private List<Node> visitRp(XPathParser.RpContext ctx, List<Node> nodes) {
        List<Node> result = new ArrayList<>();
        if (ctx.op == null) {
            for (Node node :
                    nodes) {
                Node child = node.getFirstChild();
                while (child != null) {
                    if (child.getNodeName().equals(ctx.tagName.getText())) {
                        result.add(child);
                    }
                    child = child.getNextSibling();
                }
            }
            return result;
        }
        switch (ctx.op.getText()) {
            case "*":
                for (Node node :
                        nodes) {
                    Node child = node.getFirstChild();
                    while (child != null) {
                        result.add(child);
                        child = child.getNextSibling();
                    }
                }
                break;
            case ".":
                result.addAll(nodes);
                break;
            case "..":
                for (Node node :
                        nodes) {
                    Node parent = node.getParentNode();
                    if (parent != null) {
                        result.add(parent);
                    }
                }
                break;
            case "text()":
                for (Node node :
                        nodes) {
                    Node child = node.getFirstChild();
                    while (child != null) {
                        if (child.getNodeType() == Node.TEXT_NODE) {
                            result.add(child);
                        }
                        child = child.getNextSibling();
                    }
                }
                break;
            case "@":
                for (Node node :
                        nodes) {
                    if (node.hasAttributes()) {
                        Node att = node.getAttributes().getNamedItem(ctx.attName.getText());
                        if (att != null) {
                            result.add(att);
                        }
                    }
                }
                break;
            case "(":
                result.addAll(visitRp(ctx.rp(0), nodes));
                break;
            case "/":
                List<Node> current = visitRp(ctx.rp(0), nodes);
                current = visitRp(ctx.rp(1), current);
                for (Node node :
                        current) {
                    if (!result.contains(node)) {
                        result.add(node);
                    }
                }
                break;
            case "//":
                current = visitRp(ctx.rp(0), nodes);
                List<Node> descendants = new ArrayList<>();
                for (Node node :
                        current) {
                    descendants.addAll(descendantNodes(node));
                }
                current = visitRp(ctx.rp(1), descendants);
                for (Node node :
                        current) {
                    if (!result.contains(node)) {
                        result.add(node);
                    }
                }
                break;
            case "[":
                current = visitRp(ctx.rp(0), nodes);
                result.addAll(visitF(ctx.f(), current));
                break;
            case ",":
                result.addAll(visitRp(ctx.rp(0), nodes));
                result.addAll(visitRp(ctx.rp(1), nodes));
                break;
        }
        return result;
    }

    private List<Node> visitF(XPathParser.FContext ctx, List<Node> nodes) {
        List<Node> result = new ArrayList<>();
        if (ctx.op == null) {
            List<Node> current = new ArrayList<>();
            for (Node node :
                    nodes) {
                current.clear();
                current.add(node);
                if (!visitRp(ctx.rp(0), current).isEmpty()) {
                    result.add(node);
                }
            }
            return result;
        }
        switch (ctx.op.getText()) {
            case "=":
                if (ctx.STRING() != null) {
                    String str = ctx.STRING().getText();
                    str = str.substring(1, str.length() - 1);
                    List<Node> current = new ArrayList<>();
                    for (Node node :
                            nodes) {
                        current.clear();
                        current.add(node);
                        current = visitRp(ctx.rp(0), current);
                        for (Node currentNode :
                                current) {
                            if (currentNode.getTextContent().equals(str)) {
                                result.add(node);
                            }
                        }
                    }
                    break;
                }
            case "eq":
                List<Node> current = new ArrayList<>();
                for (Node node :
                        nodes) {
                    current.clear();
                    current.add(node);
                    List<Node> leftNodes = visitRp(ctx.rp(0), current);
                    List<Node> rightNodes = visitRp(ctx.rp(1), current);
                    boolean same = false;
                    for (Node left :
                            leftNodes) {
                        for (Node right :
                                rightNodes) {
                            if (left.isEqualNode(right)) {
                                same = true;
                                break;
                            }
                        }
                        if (same) {
                            break;
                        }
                    }
                    if (same) {
                        result.add(node);
                    }
                }
                break;
            case "==":
            case "is":
                current = new ArrayList<>();
                for (Node node :
                        nodes) {
                    current.clear();
                    current.add(node);
                    List<Node> left = visitRp(ctx.rp(0), current);
                    left.retainAll(visitRp(ctx.rp(1), current));
                    if (!left.isEmpty()) {
                        result.add(node);
                    }
                }
                break;
            case "(":
                return visitF(ctx.f(0), nodes);
            case "and":
                current = visitF(ctx.f(0), nodes);
                return visitF(ctx.f(1), current);
            case "or":
                current = new ArrayList<>();
                for (Node node :
                        nodes) {
                    current.clear();
                    current.add(node);
                    if (visitF(ctx.f(0), nodes).isEmpty() && visitF(ctx.f(1), nodes).isEmpty()) {
                        break;
                    }
                    result.add(node);
                }
                break;
            case "not":
                current = new ArrayList<>();
                for (Node node :
                        nodes) {
                    current.clear();
                    current.add(node);
                    if (visitF(ctx.f(0), nodes).isEmpty()) {
                        result.add(node);
                    }
                }
                break;
        }
        return result;
    }
}
