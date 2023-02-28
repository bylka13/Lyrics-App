package app.lyricsapp.model;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;


public class Search {

    ArrayList<Song> toPrint;

    public Search() {
        this.toPrint = new ArrayList<>();
    }

    public ArrayList<Song> getToPrint() {
        return toPrint;
    }

    public void searchLyricText(String lyrics, int numberOfResults) throws IOException, SAXException, ParserConfigurationException {

        String Artist = null;
        String Song = null;
        String SongUrl = null;

        String lien = "http://api.chartlyrics.com/apiv1.asmx/SearchLyricText?lyricText=" + lyrics;

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(lien);

        NodeList booksList = document.getElementsByTagName("ArrayOfSearchLyricResult");

        Node node = booksList.item(0);

        NodeList nodeList = node.getChildNodes();

        for(int i = 1; i < nodeList.getLength(); i++) {

            Node newNode = nodeList.item(i);
            NodeList newNodeList = newNode.getChildNodes();
            for(int j = 1; j < newNodeList.getLength(); j++) {

                Node nodeToCheck = newNodeList.item(j);
                if (nodeToCheck.getNodeName().equals("SongUrl")) {
                    SongUrl = newNodeList.item(j).getTextContent();
                }
                if (nodeToCheck.getNodeName().equals("Artist")) {
                    Artist = newNodeList.item(j).getTextContent();
                }
                if (nodeToCheck.getNodeName().equals("Song")) {
                    Song = newNodeList.item(j).getTextContent();
                }
            }

            Song music = new Song(Song, Artist,SongUrl);
            if(!toPrint.contains(music)){
                toPrint.add(music);
            }
        }
        if(numberOfResults < 1 || numberOfResults > 24){
            System.out.println("Veuillez saisir un nombre compris entre 1 et 24 inclus.");
        }
        for(int i = 1; i <= numberOfResults; i++){
            System.out.println(i + ". " + toPrint.get(i));
        }
    }

    public static Song searchLyricDirect(String artist, String title) throws IOException, ParserConfigurationException, SAXException {

        String lien = "http://api.chartlyrics.com/apiv1.asmx/SearchLyricDirect?artist=" + artist + "&song=" + title;

        String LyricArtist = null;
        String LyricSong = null;
        String Lyric = null;

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(lien);

        NodeList booksList = document.getElementsByTagName("GetLyricResult");

        Node node = booksList.item(0);

        NodeList nodeList = node.getChildNodes();

        for(int i = 0; i < nodeList.getLength(); i++) {

            Node newNode = nodeList.item(i);

            if (newNode.getNodeName().equals("LyricSong")) {
                LyricSong = newNode.getTextContent();
            }
            if (newNode.getNodeName().equals("LyricArtist")){
                LyricArtist = newNode.getTextContent();
            }
            if (newNode.getNodeName().equals("Lyric")) {
                Lyric = newNode.getTextContent();
            }
        }
        return new Song(LyricSong, LyricArtist,Lyric);

    }
}