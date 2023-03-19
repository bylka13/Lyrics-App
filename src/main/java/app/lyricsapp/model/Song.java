package app.lyricsapp.model;

import java.util.Objects;

public class Song {

    private String lyric;
    private String author;
    private String title;
    private boolean isFavorite;


    public Song(String lyric, String author, String title) {
        this.lyric = lyric;
        this.author = author;
        this.title = title;
        this.isFavorite = false;
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

    public boolean isFavorite() {return isFavorite;}
    public void setFavorite(boolean bool){ this.isFavorite = bool;}

    @Override
    public String toString(){

        return "\nArtist: " + getAuthor() +
               "\nTitre: " + getTitle() +
               "\nLyric: " + getLyric() +
               "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song that = (Song) o;
        return Objects.equals(author, that.author) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lyric, author, title);
    }
}

