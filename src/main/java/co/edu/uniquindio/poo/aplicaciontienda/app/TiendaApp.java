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
        ClienteDTO cliente = new ClienteDTO("raul","100");
        ClienteDTO cliente2 = new ClienteDTO("novia de raul","200");
        tienda.agregarPedido(new PedidoDTO("001",cliente,new DireccionRecord("armenia","630001","15-14")));
        tienda.agregarPedido(new PedidoDTO("002",cliente2,new DireccionRecord("armenia","630001","15-14")));
        openHomeView();
    }


    public static void openHomeView() {
        try {
            FXMLLoader loader = new FXMLLoader(TiendaApp.class.getResource("/views/HomeView.fxml"));


            Parent root = loader.load();

            Scene scene = new Scene(root);

            var buttonCss = TiendaApp.class.getResource("/styles/buttonstyle.css");
            var tableCss = TiendaApp.class.getResource("/styles/tablestyle.css");

            primaryStage.setTitle("Menú Principal");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openGestorClientes() {
        try {
            FXMLLoader loader = new FXMLLoader(TiendaApp.class.getResource("/views/GestionClientesView.fxml"));
            Parent root = loader.load();

            var buttonCss = TiendaApp.class.getResource("/styles/buttonstyle.css");
            var tableCss = TiendaApp.class.getResource("/styles/tablestyle.css");
            var fieldCss = TiendaApp.class.getResource("/styles/textfieldstyle.css");

            primaryStage.setTitle("Gestión de Clientes");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openGestorPedidos() {
        try {
            FXMLLoader loader = new FXMLLoader(TiendaApp.class.getResource("/views/GestionPedidosView.fxml"));
            Parent root = loader.load();

            var buttonCss = TiendaApp.class.getResource("/styles/buttonstyle.css");
            var tableCss = TiendaApp.class.getResource("/styles/tablestyle.css");
            var fieldCss = TiendaApp.class.getResource("/styles/textfieldstyle.css");

            primaryStage.setTitle("Gestión de Pedidos");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openGestorProductos() {
        try {
            FXMLLoader loader = new FXMLLoader(TiendaApp.class.getResource("/views/GestionProductosView.fxml"));
            Parent root = loader.load();

            var buttonCss = TiendaApp.class.getResource("/styles/buttonstyle.css");
            var tableCss = TiendaApp.class.getResource("/styles/tablestyle.css");
            var fieldCss = TiendaApp.class.getResource("/styles/textfieldstyle.css");

            primaryStage.setTitle("Gestión de Productos");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openPedidosTotales() {
        try {
            FXMLLoader loader = new FXMLLoader(TiendaApp.class.getResource("/views/PedidosTotalesView.fxml"));
            Parent root = loader.load();

            var buttonCss = TiendaApp.class.getResource("/styles/buttonstyle.css");
            var tableCss = TiendaApp.class.getResource("/styles/tablestyle.css");
            var fieldCss = TiendaApp.class.getResource("/styles/textfieldstyle.css");

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