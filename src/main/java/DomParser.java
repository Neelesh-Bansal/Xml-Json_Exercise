import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParser {

    public static void main(String[] args) {

        try {
            File inputFile = new File("organizaton.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("employee");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Employee ID : "
                            + eElement.getAttribute("id"));
                    System.out.println("Employee Name : "
                            + eElement
                            .getElementsByTagName("name")
                            .item(0)
                            .getTextContent());
                    System.out.println("Age : "
                            + eElement
                            .getElementsByTagName("age")
                            .item(0)
                            .getTextContent());
                    System.out.println("Salary : "
                            + eElement
                            .getElementsByTagName("salary")
                            .item(0)
                            .getTextContent());
                    System.out.println("Email : "
                            + eElement
                            .getElementsByTagName("email")
                            .item(0)
                            .getTextContent());
                    System.out.println("Occupation : "
                            + eElement
                            .getElementsByTagName("occupation")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}