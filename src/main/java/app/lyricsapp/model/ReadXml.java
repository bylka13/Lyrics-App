package app.lyricsapp.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXml {
    public static void main(String argv[]){
        try{
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
            NodeList list = doc.getElementsByTagName("SearchLyricResult");
            for (int i = 0; i < list.getLength() - 1; i++){
                Node node = list.item(i);
                //Pour verifier que c'est un noeud
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    //cast pour utiliser les méthodes de la classe Element sur node
                    Element element = (Element) node;
                    String songUrl = element.getElementsByTagName("SongUrl").item(0).getTextContent();
                    String artist = element.getElementsByTagName("Artist").item(0).getTextContent();
                    String song = element.getElementsByTagName("Song").item(0).getTextContent();
                    int trackId = Integer.parseInt(element.getElementsByTagName("TrackId").item(0).getTextContent());
                    String lyricChecksum = element.getElementsByTagName("LyricChecksum").item(0).getTextContent();
                    int lyricId = Integer.parseInt(element.getElementsByTagName("LyricId").item(0).getTextContent());
                    String artistUrl = element.getElementsByTagName("ArtistUrl").item(0).getTextContent();
                    int songRank = Integer.parseInt(element.getElementsByTagName("SongRank").item(0).getTextContent());
                    System.out.println("\nCurrent Element  : " + node.getNodeName());

                    LyricSongText music = new LyricSongText(trackId, lyricChecksum, lyricId, songUrl, artistUrl, artist, song, songRank);
                    System.out.println(music);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
