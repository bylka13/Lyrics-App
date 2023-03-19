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
        List<Song> playlistSongs = new ArrayList<>();
        playlistSongs.add(song2);
        playlist.addMusic(song1);
        playlist.addMusic(song2);
        playlist.deleteMusic(0);
        assertThat(playlist.getSongs()).isEqualTo(playlistSongs);
    }

    @Test
    public void testGetPlaylistName(){
        assertThat(playlist.getPlaylistName()).isEqualTo("rap");
    }

    @Test
    public void testContains(){
        playlist.addMusic(song2);
        assertThat(playlist.contains(song1)).isFalse();
        assertThat(playlist.contains(song2)).isTrue();
    }

    @Test
    public void testGetASong(){
        ArrayList<Song> playlistSongs = new ArrayList<>();
        playlistSongs.add(song2);
        playlistSongs.add(song1);
        playlist.addAllMusics(playlistSongs);
        assertThat(playlist.getASong(0)).isEqualTo(song2);
        assertThat(playlist.getASong(1)).isEqualTo(song1);
    }
}
