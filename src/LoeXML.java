import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Taavi Tilk on 12.12.2015.
 */
public class LoeXML {
    public ObservableList getAndmed(){
        ObservableList<Person> andmed = FXCollections.observableArrayList();

        try {
            File XMLFail = new File("file2.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(XMLFail);
            doc.getDocumentElement().normalize();
            NodeList toide = doc.getElementsByTagName("Toit");


            for (int i = 0; i < toide.getLength(); i++) {

                Node nNode = toide.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String person1 = eElement.getElementsByTagName("Toiduliik").item(0).getTextContent();
                    String person2 = eElement.getElementsByTagName("Kogus").item(0).getTextContent();
                    String person3 = eElement.getElementsByTagName("Yhik").item(0).getTextContent();

                    //System.out.println(person1+" "+person2+" "+person3);



                    andmed.add(new Person(person1,person2,person3));


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return andmed;
    }
}
