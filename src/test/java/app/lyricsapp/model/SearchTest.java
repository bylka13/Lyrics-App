package app.lyricsapp.model;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest {

    @Test
    public void testGetToPrint(){
        Search search = new Search();
        assertThat(search.getToPrint()).isEqualTo(new ArrayList<Song>());
    }

    @Test
    public void testSearchLyricDirect (){
        Song song = new Song("The taxman's taken all my dough\n" +
                "And left me in my stately home\n" +
                "Lazing on a sunny afternoon\n" +
                "And I can't sail my yacht\n" +
                "He's taken everything I've got\n" +
                "All I've got's this sunny afternoon\n" +
                "Save me, save me, save me from this squeeze\n" +
                "I've got a big fat momma trying to break me\n" +
                "And I love to live so pleasantly\n" +
                "Live this life of luxury\n" +
                "Lazin' on a sunny afternoon\n" +
                "In the summertime\n" +
                "In the summertime\n" +
                "In the summertime\n" +
                "My girlfriend's run off with my car\n" +
                "And gone back to her ma and pa\n" +
                "Tellin' tales of drunkenness and cruelty\n" +
                "Now I'm sittin' here\n" +
                "Sippin' at my ice-cool beer\n" +
                "Lazin on a sunny afternoon\n" +
                "Help me, help me, help me sail away\n" +
                "Or give me two good reasons why I oughta stay\n" +
                "'Cause I love to live so pleasantly\n" +
                "Live this life of luxury\n" +
                "Lazin' on a sunny afternoon\n" +
                "In the summertime\n" +
                "In the summertime\n" +
                "In the summertime\n" +
                "Save me, save me, save me from this squeeze\n" +
                "I got a big fat momma trying to break me\n" +
                "And I love to live so pleasantly\n" +
                "Live this life of luxury\n" +
                "Lazin' on a sunny afternoon\n" +
                "In the summertime\n" +
                "In the summertime\n" +
                "In the summertime\n" +
                "In the summertime\n" +
                "In the summertime","The Kinks","Sunny Afternoon");
        try {
            assertThat(Search.searchLyricDirect("The Kinks","Sunny Afternoon")).isEqualTo(song);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
