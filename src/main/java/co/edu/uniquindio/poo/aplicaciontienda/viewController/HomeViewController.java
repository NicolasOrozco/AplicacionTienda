package co.edu.uniquindio.poo.aplicaciontienda.viewController;
//view hecha
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.aplicaciontienda.app.TiendaApp;
import co.edu.uniquindio.poo.aplicaciontienda.model.PedidoDTO;
import co.edu.uniquindio.poo.aplicaciontienda.model.Tienda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HomeViewController{

    private Tienda tienda = TiendaApp.tienda;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<PedidoDTO, String> colDireccionPedido;

    @FXML
    private TableColumn<PedidoDTO,String> colPedidoId;

    @FXML
    private TableView<PedidoDTO> tablePedidosActivos;

    @FXML
    private TableColumn<PedidoDTO, String> colClientePedido;

    @FXML
    void onGestionarPedidos(ActionEvent event) {
        TiendaApp.openGestorPedidos();
    }

    @FXML
    void onGestionarClientes(ActionEvent event) {
        TiendaApp.openGestorClientes();

    }

    @FXML
    void onGestionarProductos(ActionEvent event) {
        TiendaApp.openGestorProductos();

    }

    @FXML
    void onSalir(ActionEvent event) {
        TiendaApp.cerrarApp();
    }

    @FXML
    public void initialize() {
        colPedidoId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colClientePedido.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colDireccionPedido.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        cargarPedidos();
    }


    public void cargarPedidos(){
        if (tienda!=null){
            ObservableList<PedidoDTO> pedidos = FXCollections.observableArrayList(tienda.getPedidos());
            tablePedidosActivos.setItems(pedidos);
        }
    }
}
