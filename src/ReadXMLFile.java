/**
 * Created by Taavi Tilk on 4.12.2015.
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFile {

    public static void main(String argv[]) {

        try {

            File fXmlFile = new File("/Users/Taavi Tilk/IdeaProjects/InsuliiniKogus/staff.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("toit");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Toit id: " + eElement.getAttribute("id"));
                    System.out.println("Toidunimi : " + eElement.getElementsByTagName("toidunimi").item(0).getTextContent());
                    System.out.println("Süsivesikuid ühikus : " + eElement.getElementsByTagName("sysivesikuid").item(0).getTextContent());
                    System.out.println("Ühik : " + eElement.getElementsByTagName("yhik").item(0).getTextContent());
                                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
