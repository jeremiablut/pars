package com.parser.pars;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import static com.parser.pars.Parsar.bits;

public class Controller {
    @FXML
    private Label bit;

    @FXML
    private Label delay;

    @FXML
    private Label translated;

    @FXML
    private Label script;

    @FXML
    private TextField bin;

    @FXML
    public void sendBinary() {
        Parsar.binary = bin.getText();
        translated.setText("Send");
    }

    @FXML
    public void setupKeyHandler() {
            bin.getScene().setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.SPACE) {
                    System.out.println("1");
                    TCPServer.setValue(1);
                    int i = 0;
                    while (!TCPServer.queue) {
                        try {
                            System.out.println("queued");
                            Thread.sleep(1);
                            i++;
                            if (i == 1000) break;
                        } catch (InterruptedException e) {}
                    }

                    System.out.println(i + "ms");
                    delay.setText(i + "ms");
                    bit.setText(Reader.answer);
                    bits.add(1);
                    Parsar.binaryBuilder();
                    script.setText(Parsar.binary);
                    System.out.println("finished");
                }

                if (event.getCode() == KeyCode.V) {
                    System.out.println("0");
                    TCPServer.setValue(0);
                    int i = 0;
                    while (!TCPServer.queue) {
                        try {
                            System.out.println("queued");
                            Thread.sleep(1);
                            i++;
                            if (i == 1000) break;
                        } catch (InterruptedException e) {System.out.println("failed");}
                    }
                    System.out.println(i + "ms");
                    delay.setText(i + "ms");
                    bit.setText(Reader.answer);
                    bits.add(0);
                    Parsar.binaryBuilder();
                    script.setText(Parsar.binary);
                    System.out.println("finished");
                }

                if (event.getCode() == KeyCode.DIGIT1) {
                    Parsar.binaryBuilder();
                    Integer i = Parsar.parsingInt();
                    translated.setText(i.toString());
                }

                if (event.getCode() == KeyCode.DIGIT2) {
                    Parsar.binaryBuilder();
                    String s = Parsar.parsingString();
                    translated.setText(s);
                }

                if (event.getCode() == KeyCode.DIGIT0) {
                    bits.clear();
                    Parsar.binary = "";
                    script.setText("");
                }
            });
    }
}
