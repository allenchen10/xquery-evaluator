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
                // for
                XPathParser.ForClauseContext forCtx = ctx.forClause();
                List<XPathParser.VarContext> vars = forCtx.var();
                for (int i = 0; i < vars.size(); i++) {
                    String varName = vars.get(i).varName.getText();
                    if (dict.containsKey(varName)) {
                        dict.replace(varName, visitXq(forCtx.xq(i), dict).get(""));
                    } else {
                        dict.put(varName, visitXq(forCtx.xq(i), dict).get(""));
                    }
                }
                // let
                // where
                if (ctx.whereClause() != null) {
                    XPathParser.CondContext cndCtx = ctx.whereClause().cond();
                    switch (cndCtx.op.getText()) {
                        case "=":
                        case "eq":
                            List<Node> nodes = dict.get("");
                            List<Node> result = new ArrayList<>();
                            Map<String, List<Node>> currentDict = new HashMap<>(dict);
                            List<Node> current = new ArrayList<>();
                            for (Node node:
                                    nodes) {
                                current.clear();
                                current.add(node);
                                currentDict.replace("", current);
                                List<Node> leftNodes = visitXq(cndCtx.xq(0), currentDict).get("");
                                List<Node> rightNodes = visitXq(cndCtx.xq(1), currentDict).get("");
                                boolean same = false;
                                for (Node left:
                                        leftNodes) {
                                    for (Node right:
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
                            dict.replace("", result);
                            break;
                        case "==":
                        case "is":
                            nodes = dict.get("");
                            result = new ArrayList<>();
                            currentDict = new HashMap<>(dict);
                            for (Node node:
                                    nodes) {
                                currentDict.replace("", new ArrayList<>());
                                currentDict.get("").add(node);
                                List<Node> left = visitXq(cndCtx.xq(0), currentDict).get("");
                                left.retainAll(visitXq(cndCtx.xq(1), currentDict).get(""));
                                if (!left.isEmpty()) {
                                    result.add(node);
                                }
                            }
                            dict.replace("", result);
                            break;
                        case "empty":
                        case "some":
                        case "(":
                        case "and":
                        case "or":
                        case "not":
                    }
                }
                // return
                XPathParser.ReturnClauseContext retCtx = ctx.returnClause();
                return visitXq(retCtx.xq(), dict);
            }
        }
        switch (ctx.op.getText()) {
            case "(":
                return visitXq(ctx, dict);
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
                for (Node node:
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
                for (Node node:
                        current) {
                    descendants.addAll(descendantNodes(node));
                }
                current = visitRp(ctx.rp(), descendants);
                result = new ArrayList<>();
                for (Node node:
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
        }
        return dict;
    }

    private Node makeText(String text) {
        return doc.createTextNode(text);
    }

    private Node makeElem(String tagName, List<Node> nodes) {
        Node root = doc.createElement(tagName);
        for (Node node:
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
            for (Node node:
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
                for (Node node:
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
                for (Node node:
                     nodes) {
                    Node parent = node.getParentNode();
                    if (parent != null) {
                        result.add(parent);
                    }
                }
                break;
            case "text()":
                for (Node node:
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
                for (Node node:
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
                for (Node node:
                     current) {
                    if (!result.contains(node)) {
                        result.add(node);
                    }
                }
                break;
            case "//":
                current = visitRp(ctx.rp(0), nodes);
                List<Node> descendants = new ArrayList<>();
                for (Node node:
                     current) {
                    descendants.addAll(descendantNodes(node));
                }
                current = visitRp(ctx.rp(1), descendants);
                for (Node node:
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
            for (Node node:
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
                    for (Node node:
                            nodes) {
                        current.clear();
                        current.add(node);
                        current = visitRp(ctx.rp(0), current);
                        for (Node currentNode:
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
                for (Node node:
                        nodes) {
                    current.clear();
                    current.add(node);
                    List<Node> leftNodes = visitRp(ctx.rp(0), current);
                    List<Node> rightNodes = visitRp(ctx.rp(1), current);
                    boolean same = false;
                    for (Node left:
                            leftNodes) {
                        for (Node right:
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
                for (Node node:
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
                for (Node node:
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
                for (Node node:
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
