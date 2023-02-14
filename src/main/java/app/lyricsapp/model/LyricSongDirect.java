package app.lyricsapp.model;

import java.util.Objects;

public class LyricSongDirect {
    private String LyricSong;
    private String LyricArtist;
    private String Lyric;

    public LyricSongDirect(String lyricSong, String lyricArtist, String lyric) {
        LyricSong = lyricSong;
        LyricArtist = lyricArtist;
        Lyric = lyric;
    }
    public String getLyricSong() {
        return LyricSong;
    }
    public String getLyricArtist() {
        return LyricArtist;
    }
    public String getLyric() {
        return Lyric;
    }
    @Override
    public String toString() {
        return  "\nLyricSong: " + getLyricSong() +
                "\nLyricArtist: " + getLyricArtist() +
                "\nLyric: " + getLyric() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LyricSongDirect that = (LyricSongDirect) o;
        return Objects.equals(LyricSong, that.LyricSong) &&
               Objects.equals(LyricArtist, that.LyricArtist) &&
               Objects.equals(Lyric, that.Lyric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LyricSong, LyricArtist, Lyric);
    }
}

