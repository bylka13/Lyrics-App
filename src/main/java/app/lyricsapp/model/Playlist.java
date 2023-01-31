package app.lyricsapp.model;

import java.util.ArrayList;
import java.util.Set;

public class Playlist {
    private String playlistName;
    private ArrayList<ArrayList<String>> listOfMusics;
    public Playlist (String playlistName){
        this.playlistName = playlistName;
        this.listOfMusics = new ArrayList<>();
    }
    public void addMusic(ArrayList<String> Music){
        if (listOfMusics.contains(Music)){

        }
        listOfMusics.add(Music);
    }
    public void deleteMusic(int pos){
        listOfMusics.remove(pos);
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public ArrayList<ArrayList<String>> getListOfMusics() {
        return listOfMusics;
    }
}
