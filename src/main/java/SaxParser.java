import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser {
    public static void main(String[] args) {

        try {
            File inputFile = new File("organizaton.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserHandler extends DefaultHandler {

    //boolean empId = false;
    boolean empName = false;
    boolean age = false;
    boolean salary = false;
    boolean email = false;
    boolean occupation = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            String empId = attributes.getValue("id");
            System.out.println("EmpID : " + empId);
        } else if (qName.equalsIgnoreCase("name")) {
            empName = true;
        } else if (qName.equalsIgnoreCase("age")) {
           age = true;
        } else if (qName.equalsIgnoreCase("salary")) {
            salary = true;
        } else if (qName.equalsIgnoreCase("email")) {
            email = true;
        } else if (qName.equalsIgnoreCase("occupation")) {
            occupation = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (empName) {
            System.out.println("Employee Name: " + new String(ch, start, length));
            empName = false;
        } else if (age) {
            System.out.println("Age: " + new String(ch, start, length));
            age = false;
        } else if (salary) {
            System.out.println("Salary: " + new String(ch, start, length));
            salary = false;
        } else if (email) {
            System.out.println("Email: " + new String(ch, start, length));
            email = false;
        }else if (occupation) {
            System.out.println("Occupation: " + new String(ch, start, length));
            occupation = false;
        }
    }
}

