package app.lyricsapp;

import app.lyricsapp.model.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class LyricsAppCLI {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, AddMusicException, TransformerException {
        Search mySearch = new Search();
        Playlist favorites = new Playlist("favorites");
        File file = new File("src/main/resources/fichiers xml/favoritesCLI.xml");
        if (file.exists()) {
            favorites.addAllMusics(new ReadXml().readXml("src/main/resources/fichiers xml/favoritesCLI.xml"));
            System.out.println("Le fichier favoris a été chargé \n");
        }
        System.out.println("Welcome to the lyrics app \n");
        while (true) {
            System.out.println("Input your command: ");
            System.out.println("Menu: \n" +
                               "Recherche de chansons: \n" +
                               "1/ Par Artiste et par Titre \n" +
                               "2/ Par Paroles \n" +
                               "3/ Accéder aux favoris \n" +
                               "0/ Pour quitter");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if(Objects.equals(input, "1")){
                System.out.println("Veuillez entrer le nom de l'artiste :");
                Scanner scanner1 = new Scanner(System.in);
                String artist = scanner1.nextLine();
                System.out.println("Veuillez entrer le titre de votre chanson :");
                Scanner scanner2 = new Scanner(System.in);
                String titre = scanner2.nextLine();
                Song song = mySearch.searchLyricDirect(artist, titre);
                String toVerify = mySearch.lyricToVerify(artist, titre);
                if(toVerify.equals("http://www.chartlyrics.com")) {
                    System.out.println("Song Non Available\n");
                } else {
                    System.out.println(song);
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Voulez-vous ajouter ce son dans la liste des favoris ?");
                    System.out.println("1/ Oui \n" +
                            "2/ Non");
                    if (Objects.equals(scanner3.nextLine(), "1")) {
                        if (!favorites.contains(song)) {
                            favorites.addMusic(song);
                            SaveFavoritesXML.createDocumentCLI(favorites);
                            song.setFavorite(true);
                            System.out.println("La chanson a bien été ajoutée.");
                        } else {
                            System.out.println("Cette chanson '" + song.getTitle() + " de " + song.getAuthor() + " est déjà dans la playlist.");
                        }
                    }
                }
            }

            if(Objects.equals(input, "2")) {
                System.out.println("Veuillez entrer vos paroles :");
                Scanner scanner3 = new Scanner(System.in);
                String paroles = scanner3.nextLine();
                System.out.println("Veuillez entrer le nombre de chansons que vous voulez :");
                Scanner scanner4 = new Scanner(System.in);
                int numberOfResults = Integer.parseInt(scanner4.nextLine());
                while (numberOfResults < 1 || numberOfResults > 24) {
                    System.out.println("Veuillez entrer un nombre compris entre 1 et 24 inclus :");
                    Scanner scanner5 = new Scanner(System.in);
                    numberOfResults = Integer.parseInt(scanner5.nextLine());
                }
                mySearch.searchLyricText(paroles, numberOfResults);
                System.out.println("Veuillez entrer le numéro de la chanson que vous voulez afficher:");
                Scanner scanner6 = new Scanner(System.in);
                int numberOfTheSong = Integer.parseInt(scanner6.nextLine());
                int number = numberOfResults;
                while (numberOfTheSong < 1 || numberOfTheSong > numberOfResults) {
                    System.out.println("Veuillez entrer un nombre compris entre 1 et " + number + " inclus :");
                    Scanner scanner7 = new Scanner(System.in);
                    numberOfTheSong = Integer.parseInt(scanner7.nextLine());
                }
                String artiste = mySearch.getToPrint().get(numberOfTheSong - 1).getAuthor();
                String title = mySearch.getToPrint().get(numberOfTheSong - 1).getTitle();
                Song song = mySearch.searchLyricDirect(artiste, title);
                System.out.println(song);
                System.out.println("Voulez-vous ajouter ce son dans la liste des favoris ?");
                System.out.println("1/ Oui \n" +
                        "2/ Non");
                if(Objects.equals(scanner3.nextLine(), "1")){
                    if (! favorites.contains(song)) {
                        favorites.addMusic(song);
                        SaveFavoritesXML.createDocumentCLI(favorites);
                        song.setFavorite(true);
                        System.out.println("La chanson a bien été ajoutée. \n");
                    }
                    else {
                        System.out.println("Cette chanson '" + song.getTitle() + " de " + song.getAuthor() + " est déjà dans la playlist. \n");
                    }
                }
            }

            if(Objects.equals(input, "3")) {
                favorites.display();
                System.out.println("Entrez votre commande: ");
                System.out.println("1/ Afficher une chanson \n" +
                                   "2/ Supprimer une chanson \n" +
                                   "0/ Pour retourner au menu principal \n");
                Scanner scanner9 = new Scanner(System.in);
                String input2 = scanner9.nextLine();
                if (Objects.equals(input2, "1")){
                    System.out.println("Selectionnez la chanson à afficher en détails (entrez un nombre): \n");
                    Scanner scanner10 = new Scanner(System.in);
                    int indexOfMusic = Integer.parseInt(scanner10.nextLine());
                    System.out.println(favorites.getSongs().get(indexOfMusic - 1));
                }

                if (Objects.equals(input2, "2")){
                    System.out.println("Selectionnez la chanson à supprimer (entrez un nombre) : \n");
                    Scanner scanner11 = new Scanner(System.in);
                    int indexOfMusic2 = Integer.parseInt(scanner11.nextLine());
                    favorites.getSongs().get(indexOfMusic2 - 1).setFavorite(false);
                    favorites.deleteMusic(indexOfMusic2 - 1);
                    SaveFavoritesXML.createDocumentCLI(favorites);
                    System.out.println("La chanson a été supprimée");
                }

                else {
                    continue;
                }
            }

            if(Objects.equals(input, "0")) {
                SaveFavoritesXML.createDocumentCLI(favorites);
                break;
            }
        }
    }
}
