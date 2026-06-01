package org.example.proba;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Launcher extends Application {

    private final Random random = new Random();
    private int randomSzam;

    @Override
    public void start(Stage stage) {

        randomSzam = random.nextInt(100) + 1;

        Label cimLabel = new Label("Milyen számra gondoltam?");

        TextField tippField = new TextField();
        tippField.setMaxWidth(200);

        Label eredmenyLabel = new Label("");

        Button tippButton = new Button("OK");

        tippButton.setOnAction(e -> {

            try {
                int tipp = Integer.parseInt(tippField.getText());

                if (tipp < randomSzam) {
                    eredmenyLabel.setText("A tipped kevesebb.");
                }
                else if (tipp > randomSzam) {
                    eredmenyLabel.setText("A tipped több.");
                }
                else {
                    eredmenyLabel.setText("Eltaláltad!");

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Gratulálok!");
                    alert.setHeaderText(null);
                    alert.setContentText("A tipped helyes!");
                    alert.showAndWait();

                    randomSzam = random.nextInt(100) + 1;

                    tippField.clear();
                    eredmenyLabel.setText("Új számot generáltam!");
                }

            } catch (NumberFormatException ex) {
                eredmenyLabel.setText("Érvényes számot adj meg!");
            }
        });

        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(
                cimLabel,
                tippField,
                eredmenyLabel,
                tippButton
        );

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Számkitaláló játék");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
