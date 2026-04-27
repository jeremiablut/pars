package com.parser.pars;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;

public class Controller {
    @FXML
    private Label bit;

    @FXML
    private void initialize() {
    }

    public void setupKeyHandler() {
        bit.getScene().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                bit.setText("1");
            }
            if (event.getCode() == KeyCode.V) {
                bit.setText("0");
            }
        });
    }
}
