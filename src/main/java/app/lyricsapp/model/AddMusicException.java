package app.lyricsapp.model;

public class AddMusicException extends Exception {
    private String artist;
    private String title;

    public AddMusicException(String title, String artist){
        this.title = title;
        this.artist = artist;
    }

    public String getMessage(){
        return "Cette chanson '" + title + " de " + artist + " est déjà dans la playlist.";
    }
}
