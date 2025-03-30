package co.edu.uniquindio.poo.aplicaciontienda.app;

import co.edu.uniquindio.poo.aplicaciontienda.model.PedidoDTO;
import co.edu.uniquindio.poo.aplicaciontienda.model.Tienda;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class TiendaApp extends Application {
    public static Tienda tienda = new Tienda();
    @Override
    public void start(Stage stage) throws Exception {
        Tienda tienda = new Tienda();
        //pedidos de prueba


    }

    public static void main(String[] args) {
        launch(args);
    }
}

/**
 *
Parent root = FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
Scene scene = new Scene(root);

// Enlazar el archivo CSS
        scene.getStylesheets().add(getClass().getResource("/styles/tablestyle.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Gestor de Pedidos");
        stage.show();

 */