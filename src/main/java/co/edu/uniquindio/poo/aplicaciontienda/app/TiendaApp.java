package co.edu.uniquindio.poo.aplicaciontienda.app;

import co.edu.uniquindio.poo.aplicaciontienda.model.ClienteDTO;
import co.edu.uniquindio.poo.aplicaciontienda.model.DireccionRecord;
import co.edu.uniquindio.poo.aplicaciontienda.model.PedidoDTO;
import co.edu.uniquindio.poo.aplicaciontienda.model.Tienda;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TiendaApp extends Application {
    public static Tienda tienda = new Tienda();
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        //pedidos de prueba
        tienda.agregarPedido(new PedidoDTO("001",new ClienteDTO("raul","100"),new DireccionRecord("armenia","630001","15-14")));
        tienda.agregarPedido(new PedidoDTO("002",new ClienteDTO("novia de raul","200"),new DireccionRecord("armenia","630001","15-14")));

        openHomeView();
    }


    public static void openHomeView() {
        try {
            FXMLLoader loader = new FXMLLoader(TiendaApp.class.getResource("/view/HomeView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            scene.getStylesheets().add(TiendaApp.class.getResource("/styles/tablestyles.css").toExternalForm());

            primaryStage.setTitle("Menú Principal");
            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openGestorClientes() {
        try {
            FXMLLoader loader = new FXMLLoader(TiendaApp.class.getResource("/view/GestionClientesView.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("Gestión de Clientes");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openGestorPedidos() {
        try {
            FXMLLoader loader = new FXMLLoader(TiendaApp.class.getResource("/view/GestionPedidosView.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("Gestión de Pedidos");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openGestorProductos() {
        try {
            FXMLLoader loader = new FXMLLoader(TiendaApp.class.getResource("/view/GestionProductosView.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("Gestión de Productos");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openPedidosTotales() {
        try {
            FXMLLoader loader = new FXMLLoader(TiendaApp.class.getResource("/view/PedidosTotalesView.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("Todos los Pedidos");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cerrarApp() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}