package com.example.zavod;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public Main() {
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root, 700.0D, 400.0D));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
