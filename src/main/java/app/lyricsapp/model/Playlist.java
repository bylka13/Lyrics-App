package app.lyricsapp.model;

import java.util.ArrayList;
public class Playlist {
    private String playlistName;
    private ArrayList<ArrayList<String>> listOfMusics;
    public Playlist (String playlistName){
        this.playlistName = playlistName;
        this.listOfMusics = new ArrayList<>();
    }
    public void addMusic (ArrayList<String> Music) throws AddMusicException {
        if (listOfMusics.contains(Music)){
            throw new AddMusicException;
        }
        listOfMusics.add(Music);
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
