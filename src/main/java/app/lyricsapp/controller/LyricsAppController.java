package app.lyricsapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LyricsAppController implements Initializable {

    @FXML private AnchorPane rootPane;

    //  @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {}

    public void searchByArtistAndTitle(javafx.event.ActionEvent actionEvent) throws IOException {
        VBox pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/app/lyricsapp/view/searchByArtistAndTitle.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    public void searchByLyrics(javafx.event.ActionEvent actionEvent) throws IOException {
        VBox pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/app/lyricsapp/view/searchByLyrics.fxml")));
        rootPane.getChildren().setAll(pane);
    }

}