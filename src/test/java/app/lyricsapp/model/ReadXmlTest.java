package app.lyricsapp.model;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadXmlTest {

    @Test
    public void testReadXml(){
        ReadXml read = new ReadXml();

        try{
            SaveFavoritesXML.createDocument(new Playlist("rap"));
            assertThat(read.readXml("src/main/resources/fichiers xml/favorites.xml").isEmpty());
        } catch (IOException | SAXException | ParserConfigurationException | TransformerException | AddMusicException e){
            throw new RuntimeException(e);
        }
    }
}
