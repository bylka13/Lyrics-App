package app.lyricsapp;

import app.lyricsapp.model.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class LyricsAppCLI {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        SearchLyricText mySearch = new SearchLyricText();

        System.out.println("Welcome to the lyrics app");
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

            switch(input) {
                case "1":
                    System.out.println("Veuillez entrer le nom de l'artiste :");
                    Scanner scanner1 = new Scanner(System.in);
                    String artist = scanner1.nextLine();
                    System.out.println("Veuillez entrer le titre de votre chanson :");
                    Scanner scanner2 = new Scanner(System.in);
                    String titre = scanner2.nextLine();
                    SearchLyricDirect.searchLyricDirect(artist, titre);
                    break;

                case "2" :
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
                        String artiste = mySearch.getToPrint().get(numberOfTheSong).getAuthor();
                        String title = mySearch.getToPrint().get(numberOfTheSong).getTitle();
                        SearchLyricDirect.searchLyricDirect(artiste, title);
                    break;

                case "3" :
                        //ReadXml.readXml("src/main/resources/fichiers xml/query1.xml");
                    break;

                case "0" :

                    break;
            }
        }
    }
}