package app.lyricsapp.model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SaveFavoritesXML {

    public static void createDocument(Playlist favorites) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("Playlist");
        doc.appendChild(rootElement);
        for (Song song : favorites.getSongs()) {
            Element songElement = doc.createElement("Song");
            rootElement.appendChild(songElement);

            Element title = doc.createElement("Title");
            title.setTextContent(song.getTitle());
            songElement.appendChild(title);

            Element artist = doc.createElement("Artist");
            artist.setTextContent(song.getAuthor());
            songElement.appendChild(artist);

            Element lyric = doc.createElement("Lyric");
            lyric.setTextContent(song.getLyric());
            songElement.appendChild(lyric);

        }
        try (FileOutputStream output =
                     new FileOutputStream("src/main/resources/fichiers xml/favorites.xml")) {
            writeXml(doc, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeXml(Document doc, OutputStream output) throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }
}
