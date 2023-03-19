package app.lyricsapp.model;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class SongTest {
    Song song = new Song("http://www.chartlyrics.com/nz21F2NcCUqlk93kYI4NuQ/Sunny+Afternoon.aspx%3C/SongUrl","The Kinks","Sunny Afternoon");

    @Test
    public void testGetAuthor(){
        assertThat(song.getAuthor()).isEqualTo("The Kinks");
    }

    @Test
    public void testGetTitle(){
        assertThat(song.getTitle()).isEqualTo("Sunny Afternoon");
    }

    @Test
    public void testGetSong(){
        assertThat(song.getSong()).isEqualTo("http://www.chartlyrics.com/nz21F2NcCUqlk93kYI4NuQ/Sunny+Afternoon.aspx%3C/SongUrl");
    }

    @Test
    public void testToString(){
        assertThat(song.toString()).isEqualTo("\nArtist: The Kinks\nTitre: Sunny Afternoon\nLyric: http://www.chartlyrics.com/nz21F2NcCUqlk93kYI4NuQ/Sunny+Afternoon.aspx%3C/SongUrl\n");
    }
}
