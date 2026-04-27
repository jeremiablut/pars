package com.parser.pars;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ParsarApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        TCPServer.startServer();
        Thread readerThread = new Thread(() -> Reader.main(null));
        readerThread.setDaemon(true);
        readerThread.start();
        FXMLLoader fxmlLoader = new FXMLLoader(ParsarApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 562);
        Controller controller = fxmlLoader.getController();
        controller.setupKeyHandler();
        stage.setTitle("PARSAR XY");
        stage.setScene(scene);
        stage.show();
        scene.getRoot().requestFocus();
    }
}
