package app.lyricsapp.model;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXml {
    public static void readXml(String path){
        try{
            // Constructeur de fichier
            File xmlFile = new File(path);
            //Instancier factory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // Analyse du fichier XML
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);
            doc.getDocumentElement().normalize();
            //root node ArrayOfSearchLyricResult
            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("*********");
            NodeList list = doc.getElementsByTagName("Song");
            for (int i = 0; i < list.getLength() - 1; i++){
                Node node = list.item(i);
                //Pour verifier que c'est un noeud
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    //cast pour utiliser les méthodes de la classe Element sur node
                    Element element = (Element) node;
                    String title = element.getElementsByTagName("Title").item(0).getTextContent();
                    String artist = element.getElementsByTagName("Artist").item(0).getTextContent();
                    String lyric = element.getElementsByTagName("Lyric").item(0).getTextContent();
                    System.out.println("\nCurrent Element  : " + node.getNodeName());

                    Song music = new Song(title, artist, lyric);
                    System.out.println(music);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
