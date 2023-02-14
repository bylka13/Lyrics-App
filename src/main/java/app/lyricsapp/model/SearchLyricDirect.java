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
    }
}
