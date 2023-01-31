package app.lyricsapp.model;

import java.util.ArrayList;
public class Playlist {
    private String playlistName;
    private ArrayList<ArrayList<String>> listOfMusics;
    // un morceau est une arraylist de trois elements dans cet ordre precis : Titre, Artiste, Paroles;
    // new Arraylist <"barbamama", "barbapapa", "barbibouille", ...>
    public Playlist (String playlistName){
        this.playlistName = playlistName;
        this.listOfMusics = new ArrayList<>();
    }
    public void addMusic (String title, String author, String lyrics) throws AddMusicException {
        ArrayList<String> Music = new ArrayList<>();
        Music.add(title);
        Music.add(author);
        Music.add(lyrics);

        if (listOfMusics.contains(Music)){
            throw new AddMusicException;
        }
        else {
        listOfMusics.add(Music);
        }
    }
    public void deleteMusic (int pos){
        listOfMusics.remove(pos);
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public ArrayList<ArrayList<String>> getListOfMusics() {
        return listOfMusics;
    }
}
