package com.parser.pars;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ParsarApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ParsarApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Controller controller = fxmlLoader.getController();
        controller.setupKeyHandler();
        stage.setTitle("PARSAR");
        stage.setScene(scene);
        stage.show();
        scene.getRoot().requestFocus();
    }
}
