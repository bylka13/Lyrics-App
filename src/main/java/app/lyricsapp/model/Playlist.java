package app.lyricsapp.model;

import java.util.ArrayList;
public class Playlist {
    private String playlistName;
    private ArrayList<Song> songs;
    public Playlist (String playlistName){
        this.playlistName = playlistName;
        this.songs = new ArrayList<Song>();

    }
    public void addMusic (String title, String author, String lyricsparm) throws AddMusicException {

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
        songs.remove(pos);
    }
    public String getPlaylistName() {
        return playlistName;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
