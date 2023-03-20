package app.lyricsapp.model;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaylistTest {
    Playlist playlist = new Playlist("rap");
    Song song1 = new Song("http://www.chartlyrics.com/nz21F2NcCUqlk93kYI4NuQ/Sunny+Afternoon.aspx%3C/SongUrl","The Kinks","Sunny Afternoon");
    Song song2 = new Song("http://www.chartlyrics.com/28h-8gWvNk-Rbj1X-R7PXg/Bad.aspx","Michael Jackson","bad");

    @Test
    public void testGetSongs(){

        try {
            List<Song> playlistSongs = new ArrayList<>();
            playlistSongs.add(song2);
            playlist.addMusic(song1);
            playlist.addMusic(song2);
            playlist.deleteMusic(0);
            assertThat(playlist.getSongs()).isEqualTo(playlistSongs);
        } catch (AddMusicException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetPlaylistName(){
        assertThat(playlist.getPlaylistName()).isEqualTo("rap");
    }

    @Test
    public void testContains(){
        try {
            playlist.addMusic(song2);
            assertThat(playlist.getSongs().contains(song1)).isFalse();
            assertThat(playlist.getSongs().contains(song2)).isTrue();
        } catch (AddMusicException e) {
            throw new RuntimeException(e);
        }
    }

}
