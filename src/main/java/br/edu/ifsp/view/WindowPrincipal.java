package br.edu.ifsp.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WindowPrincipal extends Application  {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane graph = FXMLLoader.load(getClass().getResource("WindowPrincipal.fxml"));
        Scene scene = new Scene(graph, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
