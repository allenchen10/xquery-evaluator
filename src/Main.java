import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            CharStream charStream = CharStreams.fromFileName(args[0]);
            RewriteLexer rewriteLexer = new RewriteLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(rewriteLexer);
            RewriteParser rewriteParser = new RewriteParser(commonTokenStream);
            ParseTree parseTree = rewriteParser.xq();
            RewriteEvalVisitor rewriteEvalVisitor = new RewriteEvalVisitor();
            String rewrite = rewriteEvalVisitor.visit(parseTree);
            System.out.println(rewrite);

//            CharStream query = CharStreams.fromString(rewrite);
//            XPathLexer lexer = new XPathLexer(query);
//            CommonTokenStream tokens = new CommonTokenStream(lexer);
//            XPathParser parser = new XPathParser(tokens);
//            ParseTree tree = parser.xq();
//            XPathEvalVisitor visitor = new XPathEvalVisitor();
//            Map<String, List<Node>> dict = visitor.visit(tree);
//            List<Node> nodes = dict.get("");
//
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document doc = builder.newDocument();
//
//            if (nodes.size() == 1 && nodes.get(0).getNodeType() == Node.ELEMENT_NODE) {
//                doc.appendChild(doc.adoptNode(nodes.get(0).cloneNode(true)));
//            } else {
//                Node result = doc.createElement("result");
//                doc.appendChild(result);
//
//                for (Node node :
//                        nodes) {
//                    if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
//                        result.appendChild(doc.createTextNode(node.getTextContent()));
//                    }
//                    if (node.getNodeType() == Node.ELEMENT_NODE || node.getNodeType() == Node.TEXT_NODE) {
//                        result.appendChild(doc.adoptNode(node.cloneNode(true)));
//                    }
//                }
//            }
//
//            // Use a Transformer for output
//            TransformerFactory tFactory =
//                    TransformerFactory.newInstance();
//            Transformer transformer =
//                    tFactory.newTransformer();
//            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//
//            DOMSource source = new DOMSource(doc);
//            File f = new File("output.xml");
//            StreamResult streamResult = new StreamResult(f);
//            transformer.transform(source, streamResult);

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
