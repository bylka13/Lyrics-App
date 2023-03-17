package app.lyricsapp.model;

import java.util.ArrayList;
public class Playlist {
    private String playlistName;
    private ArrayList<Song> songs;
    public Playlist (String playlistName){
        this.playlistName = playlistName;
        this.songs = new ArrayList<>();

    }
    public void addMusic (Song song){
        songs.add(song);
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

    public void display(){
        int num = 1;
        for (Song song : songs){
            System.out.println(num + " "+ song.getTitle() + ", "+ song.getAuthor());
            num++;
        }
    }

    public boolean contains(Song song){
        for(Song element : songs) {
            if (song.getTitle() == element.getTitle() && song.getAuthor() == element.getAuthor() && song.getSong() == element.getSong()){
                return false;
            }
        }
        return true;
    }
    public Song getASong(int index){
        return getSongs().get(index);
    }

    public void addAllMusics(ArrayList<Song> songs){
        this.songs.addAll(songs);
    }
}
