package app.lyricsapp;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class LyricsApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/app/lyricsapp/view/lyricsapp.fxml")));
        primaryStage.setTitle("LyricsApp");

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
    public static void main(String[] args) { launch(args); }
}
