package app.lyricsapp.model;

import java.util.Objects;

public class Song {

    private String song;
    private String author;
    private String title;


    public Song(String songUrl, String author, String title) {
        this.song = songUrl;
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
            return author;
        }
    public String getTitle() {
            return title;
        }
    public String getSong() {
            return song;
        }


    @Override
    public String toString(){

        return "\nArtist: " + getAuthor() +
               "\nTitre: " + getTitle() +
               "\nLyric: " + getSong() +
               "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song that = (Song) o;
        return Objects.equals(song, that.song) && Objects.equals(author, that.author) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(song, author, title);
    }
}

