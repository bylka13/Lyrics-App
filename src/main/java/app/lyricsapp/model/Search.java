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
import java.util.Arrays;
import java.util.List;


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
        String Title = null;
        String Lyric = null;

        String lien = "http://api.chartlyrics.com/apiv1.asmx/SearchLyricText?lyricText=" + removeStopWords(lyrics);

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
                    Lyric = newNodeList.item(j).getTextContent();
                }
                if (nodeToCheck.getNodeName().equals("Artist")) {
                    Artist = newNodeList.item(j).getTextContent();
                }
                if (nodeToCheck.getNodeName().equals("Song")) {
                    Title = newNodeList.item(j).getTextContent();
                }
            }

            Song music = new Song(Lyric, Artist, Title);
            if(!toPrint.contains(music)){
                toPrint.add(music);
            }
        }
        if(numberOfResults < 1 || numberOfResults > 24){
            System.out.println("Veuillez saisir un nombre compris entre 1 et 24 inclus.");
        }
        for(int i = 0; i < numberOfResults; i++){
            System.out.println(i + 1 + ". " + toPrint.get(i));
        }
    }

    public Song searchLyricDirect(String artist, String title) throws IOException, ParserConfigurationException, SAXException {

        String lien = "http://api.chartlyrics.com/apiv1.asmx/SearchLyricDirect?artist=" + removeStopWords(artist) + "&song=" +
                removeStopWords(title);

        String Artist = null;
        String Title = null;
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
                Title = newNode.getTextContent();
            }
            if (newNode.getNodeName().equals("LyricArtist")){
                Artist = newNode.getTextContent();
            }
            if (newNode.getNodeName().equals("Lyric")) {
                Lyric = newNode.getTextContent();
            }
        }
        Song song = new Song(Lyric, Artist, Title);
        toPrint.add(song);
        return song;
    }

    public String removeStopWords(String input) {
        final List<String> NOT_ALLOWED_WORDS = Arrays.asList(
            "about", "after", "all", "also", "an", "and", "another", "any", "are", "as", "at", "be", "because", "been",
            "before", "being", "between", "both", "but", "by", "came", "can", "come", "could", "did", "do", "does", "each",
            "else", "for", "from", "get", "got", "had", "has", "have", "he", "her", "here", "him", "himself", "his", "how", "if",
            "in", "into", "is", "it", "its", "just", "like", "make", "many", "me", "might", "more", "most", "much", "must",
            "my", "never", "no", "now", "of", "on", "only", "or", "other", "our", "out", "over", "re", "said", "same",
            "see", "should", "since", "so", "some", "still", "such", "take", "than", "that", "the", "their", "them", "then",
            "there", "these", "they", "this", "those", "through", "to", "too", "under", "up", "use", "very",
            "want", "was", "way", "we", "well", "were", "what", "when", "where", "which", "while", "who", "will", "with",
            "would", "you", "your", "(", ")", "[", "]", "'", "!", ".", ":", ";", "\"", "|", "~", "?", "!"
        );

        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!NOT_ALLOWED_WORDS.contains(word)) {
                result.append(word).append((" "));
            }
        }
        return result.toString().trim();
    }

    public String showCovert(String artist, String title) throws ParserConfigurationException, IOException, SAXException {
        String lien = "http://api.chartlyrics.com/apiv1.asmx/SearchLyricDirect?artist=" + removeStopWords(artist) + "&song=" +
                removeStopWords(title);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(lien);

        NodeList booksList = document.getElementsByTagName("GetLyricResult");

        Node node = booksList.item(0);

        NodeList nodeList = node.getChildNodes();

        for(int i = 0; i < nodeList.getLength(); i++) {

            Node newNode = nodeList.item(i);

            if (newNode.getNodeName().equals("LyricCovertArtUrl")) {
                return newNode.getTextContent();
            }
        }
        return null;
    }

    public String lyricToVerify(String artist, String title) throws ParserConfigurationException, IOException, SAXException {
        String lien = "http://api.chartlyrics.com/apiv1.asmx/SearchLyricDirect?artist=" + removeStopWords(artist) + "&song=" +
                removeStopWords(title);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(lien);

        NodeList booksList = document.getElementsByTagName("GetLyricResult");

        Node node = booksList.item(0);

        NodeList nodeList = node.getChildNodes();

        for(int i = 0; i < nodeList.getLength(); i++) {

            Node newNode = nodeList.item(i);

            if (newNode.getNodeName().equals("LyricUrl")) {
                return newNode.getTextContent();
            }
        }
        return null;
    }
}
