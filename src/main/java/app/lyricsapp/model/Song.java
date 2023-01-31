package app.lyricsapp.model;

public class Song {

        String title;
        String author;
        String lyric;

        public Song ( String title, String author, String lyric){
            this.title = title;
            this.author = author;
            this.lyric = lyric;
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
}

