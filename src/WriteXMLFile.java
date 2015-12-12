import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javafx.collections.ObservableList;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXMLFile {

    public static void write(ObservableList<Person> data) {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();





            // root elements
            Document doc = docBuilder.newDocument();


            Element rootElement = doc.createElement("Persons");
            doc.appendChild(rootElement);


            for (int i = 0; i <data.size(); i++) {
                // staff elements
                Element staff = doc.createElement("Person");
                rootElement.appendChild(staff);

                String a = "" + i;
                // set attribute to staff element
                Attr attr = doc.createAttribute("id");
                attr.setValue(a);
                staff.setAttributeNode(attr);

                // shorten way
                // staff.setAttribute("id", "1");

                // firstname elements
                Element toit = doc.createElement("Toiduliik");
                toit.appendChild(doc.createTextNode(data.get(i).getToit()));
                staff.appendChild(toit);


            }

/*
            Element staff2 = doc.createElement("Person");
            rootElement.appendChild(staff2);
            //String a=""+i+1;
            // set attribute to staff element
            Attr attr1 = doc.createAttribute("id");
            attr1.setValue("2");
            staff2.setAttributeNode(attr1);

            // shorten way
            // staff.setAttribute("id", "1");

            // firstname elements
            Element firstname3 = doc.createElement("Toiduliik");
            firstname3.appendChild(doc.createTextNode(data.get(2).getFirstName()));
            staff2.appendChild(firstname3);
*/

            //}
            // lastname elements


            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            //StreamResult result =  new StreamResult(System.out);
            StreamResult result = new StreamResult(new File("/Users/Taavi Tilk/IdeaProjects/InsuliiniKogus/file2.xml"));




            transformer.transform(source, result);

            System.out.println("File saved!");

        }

        catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}