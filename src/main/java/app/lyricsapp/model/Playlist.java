package app.lyricsapp.model;

import java.util.ArrayList;
public class Playlist {
    private String playlistName;

    private ArrayList<String> titles;
    private ArrayList<String> authors;
    private ArrayList<String> lyrics;
    public Playlist (String playlistName){
        this.playlistName = playlistName;
        this.titles = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.lyrics = new ArrayList<>();

    }
    public void addMusic (String lyricsparm) throws AddMusicException {

        if (titles.contains(title)){
            int indexOfTitle = titles.indexOf(title);
            if (authors.get(indexOfTitle).equals(author)){
                if (lyrics.get(indexOfTitle).equals(lyricsparm)){
                    throw new AddMusicException(title, author);
                }
            }

        }
        else {
        titles.add(title);
        }
    }
    public void deleteMusic (int pos){
        titles.remove(pos);
        authors.remove(pos);
        lyrics.remove(pos);
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public ArrayList<String> getLyrics() {
        return lyrics;
    }

    public ArrayList<String> getTitles() {
        return titles;
    }
}
