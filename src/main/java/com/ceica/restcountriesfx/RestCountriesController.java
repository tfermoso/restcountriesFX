package com.ceica.restcountriesfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RestCountriesController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}