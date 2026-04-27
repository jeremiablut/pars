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
                    System.out.println("SPACE");
                    TCPServer.setValue(1);
                    int i = 0;
                    while (!TCPServer.queue) {
                        try {
                            System.out.println("restarted");
                            Thread.sleep(1);
                            i++;
                            if (i == 1000) break;
                        } catch (InterruptedException e) {}
                    }
                    bit.setText(Reader.answer);
                    System.out.println("finished");
                }

                if (event.getCode() == KeyCode.V) {
                    System.out.println("V");
                    TCPServer.setValue(0);
                    int i = 0;
                    while (!TCPServer.queue) {
                        try {
                            System.out.println("restarted");
                            Thread.sleep(1);
                            i++;
                            if (i == 1000) break;
                        } catch (InterruptedException e) {}
                    }
                    bit.setText(Reader.answer);
                    System.out.println("finished");
                }
            });
    }
}
