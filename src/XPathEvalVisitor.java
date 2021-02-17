import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XPathEvalVisitor extends XPathBaseVisitor<List<Node>> {

    private Document doc;

    @Override
    public List<Node> visitAp(XPathParser.ApContext ctx) {
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
        return visitRp(ctx.rp(), nodes);
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
