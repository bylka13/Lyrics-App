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
        File file = new File("src/main/resources/fichiers xml/favorites.xml");
        if (file.exists()) {
            favorites.addAllMusics(ReadXml.readXml("src/main/resources/fichiers xml/favorites.xml"));
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
                               "0/ Pour quitter \n");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if(Objects.equals(input, "1")){
                System.out.println("Veuillez entrer le nom de l'artiste : \n");
                Scanner scanner1 = new Scanner(System.in);
                String artist = scanner1.nextLine();
                System.out.println("Veuillez entrer le titre de votre chanson : \n");
                Scanner scanner2 = new Scanner(System.in);
                String titre = scanner2.nextLine();
                Song song = Search.searchLyricDirect(artist,titre);
                System.out.println(song);
                Scanner scanner3 = new Scanner(System.in);
                System.out.println("Voulez-vous ajouter ce son dans la liste des favoris ? \n");
                System.out.println("1/ Oui \n" +
                                   "2/ Non");
                if(Objects.equals(scanner3.nextLine(), "1")){
                    favorites.addMusic(song);
                    SaveFavoritesXML.createDocument(favorites);
                }
                else {
                    continue;
                }

            }

            if(Objects.equals(input, "2")) {
                System.out.println("Veuillez entrer vos paroles : \n");
                Scanner scanner3 = new Scanner(System.in);
                String paroles = scanner3.nextLine();
                System.out.println("Veuillez entrer le nombre de chansons que vous voulez : \n");
                Scanner scanner4 = new Scanner(System.in);
                int numberOfResults = Integer.parseInt(scanner4.nextLine());
                while (numberOfResults < 1 || numberOfResults > 24) {
                    System.out.println("Veuillez entrer un nombre compris entre 1 et 24 inclus : \n");
                    Scanner scanner5 = new Scanner(System.in);
                    numberOfResults = Integer.parseInt(scanner5.nextLine());
                }
                mySearch.searchLyricText(paroles, numberOfResults);
                System.out.println("Veuillez entrer le numéro de la chanson que vous voulez afficher: \n");
                Scanner scanner6 = new Scanner(System.in);
                int numberOfTheSong = Integer.parseInt(scanner6.nextLine());
                int number = numberOfResults;
                while (numberOfTheSong < 1 || numberOfTheSong > numberOfResults) {
                    System.out.println("Veuillez entrer un nombre compris entre 1 et " + number + " inclus : \n");
                    Scanner scanner7 = new Scanner(System.in);
                    numberOfTheSong = Integer.parseInt(scanner7.nextLine());
                }
                String artiste = mySearch.getToPrint().get(numberOfTheSong).getAuthor();
                String title = mySearch.getToPrint().get(numberOfTheSong).getTitle();
                Song song2 = Search.searchLyricDirect(artiste, title);
                System.out.println(song2);
                System.out.println("Voulez-vous ajouter ce son dans la liste des favoris ? \n");
                System.out.println("1/ Oui \n" +
                                   "2/ Non \n");
                Scanner scanner8 = new Scanner(System.in);
                int indexOfMusic = Integer.parseInt(scanner8.nextLine());
                if (indexOfMusic == 1){
                    favorites.addMusic(song2);
                    SaveFavoritesXML.createDocument(favorites);
                    System.out.println("La chanson a bien été ajoutée. \n");
                }
                else {
                    continue;
                }

            }

            if(Objects.equals(input, "3")) {
                favorites.display();
                System.out.println("Input your command: ");
                System.out.println("Menu: \n" +
                        "Recherche de chansons: \n" +
                        "1/ Afficher une chanson \n" +
                        "2/ Supprimer une chanson \n" +
                        "0/ Pour retourner au menu principal \n");
                Scanner scanner9 = new Scanner(System.in);
                String input2 = scanner9.nextLine();
                if (Objects.equals(input2, "1")){
                    System.out.println("Selectionnez la chanson à afficher en détails (entrez un nombre): \n");
                    Scanner scanner10 = new Scanner(System.in);
                    int indexOfMusic = Integer.parseInt(scanner10.nextLine());
                    System.out.println(favorites.getASong(indexOfMusic - 1));
                }

                if (Objects.equals(input2, "2")){
                    System.out.println("Selectionnez la chanson à supprimer (entrez un nombre) : \n");
                    Scanner scanner11 = new Scanner(System.in);
                    int indexOfMusic2 = Integer.parseInt(scanner11.nextLine());
                    favorites.deleteASong(indexOfMusic2 - 1);
                }

                else {
                    continue;
                }
            }



            if(Objects.equals(input, "0")) {
                SaveFavoritesXML.createDocument(favorites);
                break;
            }
        }
    }
}