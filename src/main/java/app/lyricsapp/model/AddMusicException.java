package app.lyricsapp.model;

import java.util.ArrayList;

public class AddMusicException extends Exception {
    private String artist;
    private String title;

    public AddMusicException(ArrayList<String> music){
        this.artist = music.get(0);
        this.artist = music.get(1);
    }

    public String getMessage(){
        return "Cette chanson '" + title + "' de " + artist + " est déjà dans la playlist.";
    }
}
