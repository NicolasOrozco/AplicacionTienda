package co.edu.uniquindio.poo.aplicaciontienda.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TiendaApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
        Scene scene = new Scene(root);

        // Enlazar el archivo CSS
        scene.getStylesheets().add(getClass().getResource("/styles/tablestyle.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Gestor de Pedidos");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
