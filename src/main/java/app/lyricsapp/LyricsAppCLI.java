package app.lyricsapp;

import app.lyricsapp.model.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class LyricsAppCLI {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        System.out.println("Welcome to the lyrics app");
        while (true) {
            System.out.println("\nInput your command: ");
            System.out.println("Menu: " +
                    "\nRecherche de chansons: " +
                    "\n1/ Par Artiste et par Titre " +
                    "\n2/ Par Paroles " +
                    "\n0/ Pour quitter");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
        }
    }
}
