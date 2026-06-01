package org.example.proba;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class GTNController {

    @FXML
    private TextField tippField;

    @FXML
    private Label eredmenyLabel;

    private final Random random = new Random();
    private int randomSzam = random.nextInt(100) + 1;

    @FXML
    private void ellenoriz() {

        try {
            int tipp = Integer.parseInt(tippField.getText());

            if (tipp < randomSzam) {
                eredmenyLabel.setText("A tipped kevesebb.");
            }
            else if (tipp > randomSzam) {
                eredmenyLabel.setText("A tipped több.");
            }
            else {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Gratulálok!");
                alert.setHeaderText(null);
                alert.setContentText("A tipped helyes!");
                alert.showAndWait();

                randomSzam = random.nextInt(100) + 1;

                eredmenyLabel.setText("Új számot generáltam.");
                tippField.clear();
            }

        } catch (NumberFormatException e) {
            eredmenyLabel.setText("Csak számot adhatsz meg!");
        }
    }
}
