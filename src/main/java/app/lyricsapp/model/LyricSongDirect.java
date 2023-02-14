package app.lyricsapp.model;

import java.util.Objects;

public class LyricSongDirect {
    private int TrackId;
    private String LyricChecksum;
    private int LyricId;
    private String LyricSong;
    private String LyricArtist;
    private String LyricUrl;
    private String LyricCovertArtUrl;
    private int LyricRank;
    private String LyricCorrectUrl;
    private String Lyric;

    public LyricSongDirect(int trackId, String lyricChecksum, int lyricId, String lyricSong, String lyricArtist, String lyricUrl, String lyricCovertArtUrl, int lyricRank, String lyricCorrectUrl, String lyric) {
        TrackId = trackId;
        LyricChecksum = lyricChecksum;
        LyricId = lyricId;
        LyricSong = lyricSong;
        LyricArtist = lyricArtist;
        LyricUrl = lyricUrl;
        LyricCovertArtUrl = lyricCovertArtUrl;
        LyricRank = lyricRank;
        LyricCorrectUrl = lyricCorrectUrl;
        Lyric = lyric;
    }

    public int getTrackId() {
        return TrackId;
    }
    public String getLyricChecksum() {
        return LyricChecksum;
    }
    public int getLyricId() {
        return LyricId;
    }
    public String getLyricSong() {
        return LyricSong;
    }
    public String getLyricArtist() {
        return LyricArtist;
    }
    public String getLyricUrl() {
        return LyricUrl;
    }
    public String getLyricCovertArtUrl() {
        return LyricCovertArtUrl;
    }
    public int getLyricRank() {
        return LyricRank;
    }
    public String getLyricCorrectUrl() {
        return LyricCorrectUrl;
    }
    public String getLyric() {
        return Lyric;
    }
    @Override
    public String toString() {
        return  "\nLyricSong: " + LyricSong +
                "\nLyricArtist: " + LyricArtist +
                "\nLyric: " + Lyric + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LyricSongDirect that = (LyricSongDirect) o;
        return TrackId == that.TrackId && LyricId == that.LyricId && LyricRank == that.LyricRank && Objects.equals(LyricChecksum, that.LyricChecksum) && Objects.equals(LyricSong, that.LyricSong) && Objects.equals(LyricArtist, that.LyricArtist) && Objects.equals(LyricUrl, that.LyricUrl) && Objects.equals(LyricCovertArtUrl, that.LyricCovertArtUrl) && Objects.equals(LyricCorrectUrl, that.LyricCorrectUrl) && Objects.equals(Lyric, that.Lyric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TrackId, LyricChecksum, LyricId, LyricSong, LyricArtist, LyricUrl, LyricCovertArtUrl, LyricRank, LyricCorrectUrl, Lyric);
    }
}

