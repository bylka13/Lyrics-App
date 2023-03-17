package app.lyricsapp.controller;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.net.URL;
import app.lyricsapp.model.*;
import javafx.fxml.*;
import java.util.ResourceBundle;

public class LyricsAppController implements Initializable {
    @FXML
    private Button helpButton;
    @FXML
    private Label LyricsTitle;
    @FXML
    private Button myFavButton;
    @FXML
    private Button searchLyricDirectButton;
    @FXML
    private Button searchLyricTextButton;
    @FXML
    private Spinner<Integer> numberOfResults;
    @FXML
    private TextField inputTitle;
    @FXML
    private TextField inputArtist;
    @FXML
    private TextField inputLyrics;
    @FXML
    private GridPane gridPane;


    Playlist favorites = new Playlist("favorites");

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 25, 1);
        numberOfResults.setValueFactory(valueFactory);

        CornerRadii buttonCornerRadii = new CornerRadii(50, 50, 50, 50, false);
        BackgroundFill buttonBackgroundFill = new BackgroundFill(Color.GREEN, buttonCornerRadii, null);
        Background buttBackground = new Background(buttonBackgroundFill);

        myFavButton.setBackground(buttBackground);
        searchLyricTextButton.setBackground(buttBackground);
        searchLyricDirectButton.setBackground(buttBackground);
        helpButton.setBackground(buttBackground);

        myFavButton.setTextFill(Color.WHITE);
        searchLyricTextButton.setTextFill(Color.WHITE);
        searchLyricDirectButton.setTextFill(Color.WHITE);
        helpButton.setTextFill(Color.WHITE);


        LyricsTitle.setStyle("-fx-background-color: green; -fx-text-fill: white");


    }
}