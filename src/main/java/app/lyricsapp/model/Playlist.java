package app.lyricsapp.model;

import java.util.ArrayList;

public class Playlist {
    private String playlistName;
    private ArrayList<ArrayList<String>> listOfMusics;
    public Playlist (String playlistName){
        this.playlistName = playlistName;
        this.listOfMusics = new ArrayList<>();
    }

}