package com.example.database;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Driver extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setScene(Scenes.Login(primaryStage));
        primaryStage.show();
    }

    public static void main(String[] args) throws SQLException {
        launch();
    }
}