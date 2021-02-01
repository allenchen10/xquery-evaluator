import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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

public class Main {
    public static void main(String[] args) {
        try {
            CharStream query = CharStreams.fromFileName(args[0]);
            XPathLexer lexer = new XPathLexer(query);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            XPathParser parser = new XPathParser(tokens);
            ParseTree tree = parser.ap();
            XPathEvalVisitor visitor = new XPathEvalVisitor();
            List<Node> nodes = visitor.visit(tree);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Node result = doc.createElement("result");
            doc.appendChild(result);

            for (Node node:
                 nodes) {
                if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
                    result.appendChild(doc.createTextNode(node.getTextContent()));
                } else {
                    result.appendChild(doc.adoptNode(node.cloneNode(true)));
                }
            }

            // Use a Transformer for output
            TransformerFactory tFactory =
                    TransformerFactory.newInstance();
            Transformer transformer =
                    tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            File f = new File("output.xml");
            StreamResult streamResult = new StreamResult(f);
            transformer.transform(source, streamResult);

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
