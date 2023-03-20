package app.lyricsapp.controller;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.geometry.Insets;
import app.lyricsapp.model.*;
import javafx.fxml.*;
import javafx.scene.Scene;
import javax.xml.transform.TransformerException;
import java.util.ResourceBundle;

public class LyricsAppController implements Initializable {
    @FXML private Button helpButton;
    @FXML private Label LyricsTitle;
    @FXML private Button myFavButton;
    @FXML private Button searchLyricDirectButton;
    @FXML private Button searchLyricTextButton;
    @FXML private Spinner<Integer> numberOfResults;
    @FXML private TextField inputTitle;
    @FXML private TextField inputArtist;
    @FXML private TextField inputLyrics;
    @FXML private GridPane gridPane;


    Playlist favorites = new Playlist("favorites");

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 25, 1);
        numberOfResults.setValueFactory(valueFactory);

        CornerRadii buttonCornerRadii = new CornerRadii(50, 50, 50, 50, false);
        BackgroundFill buttonBackgroundFill = new BackgroundFill(new Color(0.1765, 0.7176, 0.2039, 1.0), buttonCornerRadii, null);
        Background buttBackground = new Background(buttonBackgroundFill);

        myFavButton.setBackground(buttBackground);
        searchLyricTextButton.setBackground(buttBackground);
        searchLyricDirectButton.setBackground(buttBackground);
        helpButton.setBackground(buttBackground);

        myFavButton.setTextFill(Color.WHITE);
        searchLyricTextButton.setTextFill(Color.WHITE);
        searchLyricDirectButton.setTextFill(Color.WHITE);
        helpButton.setTextFill(Color.WHITE);

        biggerButton(myFavButton);biggerButton(searchLyricDirectButton);biggerButton(searchLyricTextButton);biggerButton(helpButton);

        LyricsTitle.setStyle("-fx-background-color: #2DB734; -fx-text-fill: white");

        searchLyricDirectButton.setOnAction(event -> {
            gridPane.getChildren().clear();

            String titre = inputTitle.getText();
            String artiste = inputArtist.getText();

            Search search = new Search();
            try {
                search.searchLyricDirect(artiste, titre);
            } catch (IOException | ParserConfigurationException | SAXException e) {
                throw new RuntimeException(e);
            }
            Song song = search.getToPrint().get(0);
            String toVerify = null;
            try {
                toVerify = search.lyricToVerify(artiste, titre);
            } catch (ParserConfigurationException | IOException | SAXException e) {
                throw new RuntimeException(e);
            }
            if(toVerify.equals("http://www.chartlyrics.com")){
                imageToDisplayWhenError(gridPane);
            }else {
                Button songButton = new Button();
                songButton.setText(song.getAuthor() + " - " + song.getTitle());
                songButton.setPadding(new Insets(0, 20, 0, 20));
                songButton.setPrefWidth(700);
                songButton.setPrefHeight(70);
                songButton.setTooltip(new Tooltip("Click to Display Lyrics of " + song.getAuthor() + " - " + song.getTitle()));

                gridPane.add(songButton, 0, 0);
                gridPane.setPadding(new Insets(0, 100, 250, 100));
                songButton.setOnAction(event1 -> {
                    try {
                        resultWindow(song);
                    } catch (IOException | ParserConfigurationException | SAXException e) {
                        throw new RuntimeException(e);
                    }
                });

                boolean bool = song.isFavorite();

                Button addFav = new Button("\u2661");
                Tooltip tooltip = new Tooltip("Click to Add " + song.getAuthor() + " - " + song.getTitle() + " To Your Favorites");
                tooltip.setStyle("-fx-font-size: 12;");
                addFav.setTooltip(tooltip);
                if (favorites.getSongs().contains(song)) {
                    addFav.setStyle("-fx-text-fill: red;-fx-font-size: 30px;");
                } else {
                    addFav.setStyle("-fx-text-fill: black;-fx-font-size: 30px;");
                }
                addFav.setPrefSize(70, 70);
                gridPane.add(addFav, 1, 0);

                CornerRadii songButtonCornerRadii = new CornerRadii(50, 0, 0, 50, false);
                BackgroundFill songButtonBackgroundFill = new BackgroundFill(new Color(0.1765, 0.7176, 0.2039, 1.0), songButtonCornerRadii, null);
                Background songButtonBackground = new Background(songButtonBackgroundFill);

                CornerRadii addFavCornerRadii = new CornerRadii(0, 50, 50, 0, false);
                BackgroundFill addFavBackgroundFill = new BackgroundFill(new Color(0.1765, 0.7176, 0.2039, 1.0), addFavCornerRadii, null);
                Background addFavBackground = new Background(addFavBackgroundFill);

                songButton.setBackground(songButtonBackground);
                addFav.setBackground(addFavBackground);

                songButton.setTextFill(Color.WHITE);
                addFav.setTextFill(Color.WHITE);

                addFav.setOnAction(event1 -> {
                    if (!bool) {
                        addFav.setStyle("-fx-text-fill: red; -fx-font-size: 30px;");
                        song.setFavorite(true);
                        try {
                            favorites.addMusic(song);
                            SaveFavoritesXML.createDocument(favorites);
                        } catch (AddMusicException | ParserConfigurationException | TransformerException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (bool) {
                        addFav.setStyle("-fx-text-fill: black; -fx-font-size: 30px;");
                        song.setFavorite(false);
                        if (favorites.getSongs().contains(song)) {
                            favorites.getSongs().remove(song);
                        }
                    }
                });

                songButton.setOnMouseEntered(event1 -> {
                    songButton.setScaleX(1.1);
                    songButton.setScaleY(1.1);
                    addFav.setScaleX(1.1);
                    addFav.setScaleY(1.1);
                });
                songButton.setOnMouseExited(event1 -> {
                    songButton.setScaleX(1.0);
                    songButton.setScaleY(1.0);
                    addFav.setScaleX(1.0);
                    addFav.setScaleY(1.0);
                });

                addFav.setOnMouseEntered(event1 -> {
                    addFav.setScaleX(1.1);
                    addFav.setScaleY(1.1);
                    songButton.setScaleX(1.1);
                    songButton.setScaleY(1.1);
                });

                addFav.setOnMouseExited(event1 -> {
                    addFav.setScaleX(1.0);
                    addFav.setScaleY(1.0);
                    songButton.setScaleX(1.0);
                    songButton.setScaleY(1.0);
                });
            }
        });

        searchLyricTextButton.setOnAction(event -> {
            gridPane.getChildren().clear();

            int numberOfResult = valueFactory.getValue();
            String lyrics = inputLyrics.getText();
            Search search = new Search();

            try {
                search.searchLyricText(lyrics, numberOfResult);
            } catch (IOException | SAXException | ParserConfigurationException e) {
                throw new RuntimeException(e);
            }

            for (int i = 1; i <= numberOfResult; i++) {
                Song song = search.getToPrint().get(i - 1);
                if (song.getTitle() == null && song.getAuthor() == null) {
                    imageToDisplayWhenError(gridPane);
                } else {
                    Button songButton = new Button();
                    songButton.setText(song.getAuthor() + " - " + song.getTitle());
                    songButton.setPadding(new Insets(0.0, 20, 0.0, 20));
                    songButton.setPrefWidth(700);
                    songButton.setPrefHeight(70);
                    songButton.setTooltip(new Tooltip("Click to Display Lyrics of " + song.getAuthor() + " - " + song.getTitle()));

                    gridPane.add(songButton, 0, i);
                    gridPane.setPadding(new Insets(20, 100, 250, 100));
                    songButton.setOnAction(event1 -> {
                        try {
                            resultWindow(song);
                        } catch (IOException | ParserConfigurationException | SAXException e) {
                            throw new RuntimeException(e);
                        }
                    });

                    Button addFav = new Button("\u2661");
                    Tooltip tooltip = new Tooltip("Click to Add " + song.getAuthor() + " - " + song.getTitle() + " To Your Favorites");
                    tooltip.setStyle("-fx-font-size: 12;");
                    addFav.setTooltip(tooltip);

                    if (favorites.getSongs().contains(song)) {
                        addFav.setStyle("-fx-text-fill: red;-fx-font-size: 30px;");
                    } else {
                        addFav.setStyle("-fx-text-fill: black;-fx-font-size: 30px;");
                    }
                    addFav.setPrefSize(70, 70);
                    gridPane.add(addFav, 1, i);
                    gridPane.setVgap(15);

                    CornerRadii songButtonCornerRadii = new CornerRadii(50, 0, 0, 50, false);
                    BackgroundFill songButtonBackgroundFill = new BackgroundFill(new Color(0.1765, 0.7176, 0.2039, 1.0), songButtonCornerRadii, null);
                    Background songButtonBackground = new Background(songButtonBackgroundFill);

                    CornerRadii addFavCornerRadii = new CornerRadii(0, 50, 50, 0, false);
                    BackgroundFill addFavBackgroundFill = new BackgroundFill(new Color(0.1765, 0.7176, 0.2039, 1.0), addFavCornerRadii, null);
                    Background addFavBackground = new Background(addFavBackgroundFill);

                    songButton.setBackground(songButtonBackground);
                    addFav.setBackground(addFavBackground);

                    songButton.setTextFill(Color.WHITE);
                    addFav.setTextFill(Color.WHITE);

                    boolean bool = song.isFavorite();

                    addFav.setOnAction(event1 -> {
                        if (!bool) {
                            addFav.setStyle("-fx-text-fill: red; -fx-font-size: 30px;");
                            song.setFavorite(true);
                            if (!favorites.getSongs().contains(song)) {
                                try {
                                    favorites.addMusic(song);
                                    SaveFavoritesXML.createDocument(favorites);
                                } catch (AddMusicException | ParserConfigurationException | TransformerException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                        if (bool) {
                            addFav.setStyle("-fx-text-fill: black; -fx-font-size: 30px;");
                            song.setFavorite(false);
                            if (favorites.getSongs().contains(song)) {
                                favorites.getSongs().remove(song);
                            }
                        }
                    });

                    songButton.setOnMouseEntered(event1 -> {
                        songButton.setScaleX(1.1);
                        songButton.setScaleY(1.1);
                        addFav.setScaleX(1.1);
                        addFav.setScaleY(1.1);
                    });
                    songButton.setOnMouseExited(event1 -> {
                        songButton.setScaleX(1.0);
                        songButton.setScaleY(1.0);
                        addFav.setScaleX(1.0);
                        addFav.setScaleY(1.0);
                    });

                    addFav.setOnMouseEntered(event1 -> {
                        addFav.setScaleX(1.1);
                        addFav.setScaleY(1.1);
                        songButton.setScaleX(1.1);
                        songButton.setScaleY(1.1);
                    });

                    addFav.setOnMouseExited(event1 -> {
                        addFav.setScaleX(1.0);
                        addFav.setScaleY(1.0);
                        songButton.setScaleX(1.0);
                        songButton.setScaleY(1.0);
                    });
                }
            }
        });

        myFavButton.setOnAction(event -> {

            gridPane.getChildren().clear();

            for (int i = 0; i <= favorites.getSongs().size() - 1; i++) {

                Song song = favorites.getSongs().get(i);
                Button songButton = new Button();
                songButton.setText(song.getAuthor() + " - " +  song.getTitle());
                songButton.setPadding(new Insets(0.0, 20, 0.0, 20));
                songButton.setPrefWidth(700);
                songButton.setPrefHeight(70);
                songButton.setTooltip(new Tooltip("Click to Display Lyrics of " +  song.getAuthor() + " - " + song.getTitle()));

                gridPane.add(songButton, 0, i + 2);
                gridPane.setPadding(new Insets(0,100,250,100));
                songButton.setOnAction(event1 -> {
                    try {
                        resultWindow(song);
                    } catch (IOException | ParserConfigurationException | SAXException e) {
                        throw new RuntimeException(e);
                    }
                });

                Button addFav = new Button("\u2661");
                Tooltip tooltip = new Tooltip("Click To Remove " +  song.getAuthor() + " - " + song.getTitle() + " From Your Favorites");
                tooltip.setStyle("-fx-font-size: 12;");
                addFav.setTooltip(tooltip);

                addFav.setStyle("-fx-text-fill: red;-fx-font-size: 30px;");
                addFav.setPrefSize(70, 70);
                gridPane.add(addFav, 1, i + 2);
                gridPane.setVgap(15);

                CornerRadii songButtonCornerRadii = new CornerRadii(50, 0, 0, 50, false);
                BackgroundFill songButtonBackgroundFill = new BackgroundFill(new Color(0.1765, 0.7176, 0.2039, 1.0), songButtonCornerRadii, null);
                Background songButtonBackground = new Background(songButtonBackgroundFill);

                CornerRadii addFavCornerRadii = new CornerRadii(0, 50, 50, 0, false);
                BackgroundFill addFavBackgroundFill = new BackgroundFill(new Color(0.1765, 0.7176, 0.2039, 1.0), addFavCornerRadii, null);
                Background addFavBackground = new Background(addFavBackgroundFill);

                songButton.setBackground(songButtonBackground);
                addFav.setBackground(addFavBackground);

                songButton.setTextFill(Color.WHITE);
                addFav.setTextFill(Color.WHITE);

                int finalI = i;
                addFav.setOnAction(event1 -> {
                    addFav.setStyle("-fx-text-fill: black; -fx-font-size: 30px;");
                    song.setFavorite(false);
                    favorites.deleteMusic(finalI);
                    gridPane.getChildren().remove(addFav);
                    gridPane.getChildren().remove(songButton);
                });

                songButton.setOnMouseEntered(event1 -> {
                    songButton.setScaleX(1.1);
                    songButton.setScaleY(1.1);
                    addFav.setScaleX(1.1);
                    addFav.setScaleY(1.1);
                });
                songButton.setOnMouseExited(event1 -> {
                    songButton.setScaleX(1.0);
                    songButton.setScaleY(1.0);
                    addFav.setScaleX(1.0);
                    addFav.setScaleY(1.0);
                });

                addFav.setOnMouseEntered(event1 -> {
                    addFav.setScaleX(1.1);
                    addFav.setScaleY(1.1);
                    songButton.setScaleX(1.1);
                    songButton.setScaleY(1.1);
                });

                addFav.setOnMouseExited(event1 -> {
                    addFav.setScaleX(1.0);
                    addFav.setScaleY(1.0);
                    songButton.setScaleX(1.0);
                    songButton.setScaleY(1.0);
                });
            }
        });

        helpButton.setOnAction(event -> {
            TextArea textArea= new TextArea();
            textArea.setPrefSize(600, 300);
            textArea.setText("      Lyrics App is an application designed for music research and \nthese lyrics and we have the " +
                    "possibility to display one of \nthese some lyrics which will give us as a result the songs \nthat " +
                    "contains the name of his song which will give us his \nlyrics, or by knowing it offers two research " +
                    "methods either \nby knowing the artist and songs.");
            textArea.setStyle("-fx-font-size: 20px;");
            Stage stage=new Stage();
            stage.setTitle("LyricsApp - Help");
            stage.setScene(new Scene(textArea));
            stage.show();

        });
    }

    public void resultWindow(Song song) throws IOException, ParserConfigurationException, SAXException {
        BorderPane root = new BorderPane();

        String imageUrl = new Search().showCovert(song.getAuthor(), song.getTitle());
        Image image = null;
        if (imageUrl == null || imageUrl.isEmpty()) {
            image = new Image(new File("src/main/resources/cover.jpg").toURI().toString());
        } else {
            image = new Image(imageUrl);
            if(image.isError()){
                image = new Image(new File("src/main/resources/cover.jpg").toURI().toString());
            }

        }
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(190);
        imageView.setFitWidth(190);
        root.setLeft(imageView);


        TextArea textArea = new TextArea();
        textArea.setPrefSize(500, 720);
        String Lyric = new Search().searchLyricDirect(song.getAuthor(), song.getTitle()).getLyric();
        if(Lyric == null || Lyric.equals("")){
            Lyric = "No Lyrics Founded";
        }
        textArea.setText(Lyric);
        root.setCenter(textArea);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Lyrics of " + song.getAuthor() + " - " + song.getTitle());
        stage.setScene(scene);
        stage.show();
    }

    public void biggerButton(Button button){
        button.setOnMouseEntered(event1 -> {
            button.setScaleX(1.1);
            button.setScaleY(1.1);
        });
        button.setOnMouseExited(event1 -> {
            button.setScaleX(1.0);
            button.setScaleY(1.0);
        });
    }
    public void imageToDisplayWhenError(GridPane gridPane){
        Image image = new Image(new File("src/main/resources/noMusic.jpg").toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(220);
        imageView.setFitHeight(220);
        GridPane.setConstraints(imageView, 0, 0);
        GridPane.setHalignment(imageView, HPos.CENTER);
        GridPane.setValignment(imageView, VPos.CENTER);
        gridPane.getChildren().add(imageView);
    }
}
