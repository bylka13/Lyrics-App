package app.lyricsapp.model;

import java.util.Objects;

public class LyricSongText {

    private int trackId;
    private String lyricChecksum;
    private int lyricId;
    private String lyric;
    private String artistUrl;
    private String author;
    private String title;
    private int songRank;

    public LyricSongText(int trackId, String lyricChecksum, int lyricId, String lyric, String artistUrl, String author, String title, int songRank) {
        this.trackId = trackId;
        this.lyricChecksum = lyricChecksum;
        this.lyricId = lyricId;
        this.lyric = lyric;
        this.artistUrl = artistUrl;
        this.author = author;
        this.title = title;
        this.songRank = songRank;
    }

    public String getAuthor() {
            return author;
        }
    public String getTitle() {
            return title;
        }

    public String getLyric() {
            return lyric;
        }

    public int getTrackId() {
        return trackId;
    }

    public String getLyricChecksum() {
        return lyricChecksum;
    }

    public int getLyricId() {
        return lyricId;
    }

    public String getArtistUrl() {
        return artistUrl;
    }

    public int getSongRank() {
        return songRank;
    }

    @Override
    public String toString(){

        return "\nTrackId: " + getTrackId() +
               "\nLyricChecksum: " + getLyricChecksum() +
               "\nLyricId: " + getLyricId() +
               "\nSongUrl: " + getLyric() +
               "\nArtistUrl: " + getArtistUrl() +
               "\nArtist: " + getAuthor() +
               "\nTitre: " + getTitle() +
               "\nSongRank: " + getSongRank() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LyricSongText that = (LyricSongText) o;
        return trackId == that.trackId && lyricId == that.lyricId && songRank == that.songRank && Objects.equals(lyricChecksum, that.lyricChecksum) && Objects.equals(lyric, that.lyric) && Objects.equals(artistUrl, that.artistUrl) && Objects.equals(author, that.author) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackId, lyricChecksum, lyricId, lyric, artistUrl, author, title, songRank);
    }
}

