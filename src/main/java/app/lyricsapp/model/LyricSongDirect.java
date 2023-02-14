package app.lyricsapp.model;

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
        return "\nTrackId: " + TrackId +
                "\nLyricChecksum: " + LyricChecksum +
                "\nLyricId: " + LyricId +
                "\nLyricSong: " + LyricSong +
                "\nLyricArtist: " + LyricArtist +
                "\nLyricUrl: " + LyricUrl +
                "\nLyricCovertArtUrl: " + LyricCovertArtUrl +
                "\nLyricRank: " + LyricRank +
                "\nLyricCorrectUrl: " + LyricCorrectUrl +
                "\nLyric: " + Lyric + "\n";
    }
}
