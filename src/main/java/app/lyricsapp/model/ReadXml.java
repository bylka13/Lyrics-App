package app.lyricsapp.model;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXml {
    public static void main(String argv[]) {
        try {
            // Constructeur de fichier
            File xmlFile = new File("src/main/resources/fichiers xml/query1.xml");
            //Instancier factory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // Analyse du fichier XML
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);
            doc.getDocumentElement().normalize();
            //root node ArrayOfSearchLyricResult
            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("*********");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
