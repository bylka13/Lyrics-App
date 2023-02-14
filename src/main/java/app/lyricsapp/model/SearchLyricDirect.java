package app.lyricsapp.model;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;



public class SearchLyricDirect{
    public static void searchLyricDirect(String artist, String title) throws IOException, ParserConfigurationException, SAXException {

        String lien = "http://api.chartlyrics.com/apiv1.asmx/SearchLyricDirect?artist=" + artist + "&song=" + title;

        int TrackId = 0;
        String LyricChecksum = null;
        int LyricId = 0;
        String LyricArtist = null;
        String LyricSong = null;
        String LyricUrl = null;
        String LyricCovertArtUrl = null;
        String LyricCorrectUrl = null ;
        String Lyric = null;
        int LyricRank = 0;

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(lien);

        NodeList booksList = document.getElementsByTagName("GetLyricResult");

        Node node = booksList.item(0);

        NodeList nodeList = node.getChildNodes();

        for(int i = 0; i < nodeList.getLength(); i++) {

            Node newNode = nodeList.item(i);
            if (newNode.getNodeName().equals("TrackId")) {
                TrackId = Integer.parseInt(newNode.getTextContent());
            }
            if (newNode.getNodeName().equals("LyricChecksum")) {
                LyricChecksum = newNode.getTextContent();
            }
            if (newNode.getNodeName().equals("LyricId")) {
                LyricId = Integer.parseInt(newNode.getTextContent());
            }
            if (newNode.getNodeName().equals("LyricSong")) {
                LyricSong = newNode.getTextContent();
            }
            if (newNode.getNodeName().equals("LyricArtist")){
                LyricArtist = new String(newNode.getTextContent());
            }
            if (newNode.getNodeName().equals("LyricUrl")) {
                LyricUrl = newNode.getTextContent();
            }
            if (newNode.getNodeName().equals("LyricCovertArtUrl")) {
                LyricCovertArtUrl = newNode.getTextContent();
            }
            if (newNode.getNodeName().equals("LyricRank")) {
                LyricRank = Integer.parseInt(newNode.getTextContent());
            }
            if (newNode.getNodeName().equals("LyricCorrectUrl")) {
                LyricCorrectUrl = newNode.getTextContent();
            }
            if (newNode.getNodeName().equals("Lyric")) {
                Lyric = newNode.getTextContent();
            }
        }
        System.out.println(new LyricSongDirect(TrackId, LyricChecksum, LyricId, LyricSong, LyricArtist, LyricUrl, LyricCovertArtUrl, LyricRank, LyricCorrectUrl, Lyric));

    }

}
