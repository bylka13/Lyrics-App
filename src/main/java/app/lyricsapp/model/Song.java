package app.lyricsapp.model;

import java.util.Objects;

public class Song {

    private String songUrl;
    private String author;
    private String title;


    public Song(String songUrl, String author, String title) {
        this.songUrl = songUrl;
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
            return author;
        }
    public String getTitle() {
            return title;
        }

    public String getSongUrl() {
            return songUrl;
        }


    @Override
    public String toString(){

        return "\nTitre: " + getTitle() +
               "\nArtist: " + getAuthor() +
               "\nLyric: " + getSongUrl() +
               "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song that = (Song) o;
        return Objects.equals(songUrl, that.songUrl) && Objects.equals(author, that.author) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songUrl, author, title);
    }
}

