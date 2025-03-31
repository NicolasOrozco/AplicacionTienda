package co.edu.uniquindio.poo.aplicaciontienda.viewController;

import co.edu.uniquindio.poo.aplicaciontienda.app.TiendaApp;
import co.edu.uniquindio.poo.aplicaciontienda.controller.GestionPedidosController;
import co.edu.uniquindio.poo.aplicaciontienda.controller.HistorialPedidosController;
import co.edu.uniquindio.poo.aplicaciontienda.model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.Collection;
import java.util.LinkedList;

public class GestionPedidosViewController {

    GestionPedidosController gestionPedidosController;
    private final ObservableList<ProductoRecord> productos = FXCollections.observableArrayList();
    public ProductoRecord selectedProducto;

    LinkedList<ProductoRecord> carrito;

    @FXML
    private TextField txtfieldPedido;

    @FXML
    private TextField txtfieldCodigoPostal;

    @FXML
    private TableColumn<ProductoRecord, String> colNombreProducto;

    @FXML
    private TableColumn<ProductoRecord, String> colPrecioProducto;

    @FXML
    private TextField txtfieldCalle;

    @FXML
    private TextField txtfieldIdCliente;

    @FXML
    private TextField txtfieldIdPedido;

    @FXML
    private TextField txtfieldCiudad;

    @FXML
    private TableView<ProductoRecord> tableProductos;

    @FXML
    void onAgregarProductoAPedido(ActionEvent event) {
        carrito.add(selectedProducto);
    }

    @FXML
    void onCrearPedido(ActionEvent event) {
        String idCliente = txtfieldIdCliente.getText();
        ClienteDTO clientePedido = TiendaApp.tienda.buscarCliente(idCliente);
        DireccionRecord direccion = new DireccionRecord(txtfieldCiudad.getText(), txtfieldCodigoPostal.getText(), txtfieldCalle.getText());

        PedidoDTO pedidoDTO = new PedidoDTO(txtfieldIdPedido. getText(), clientePedido, direccion);
        pedidoDTO.setProductos(carrito);

        gestionPedidosController.agregarPedido(pedidoDTO);
        carrito.clear();
        cargarProductos();
    }

    @FXML
    void onVerTodosLosPedidos(ActionEvent event) {
        TiendaApp.openPedidosTotales();
    }

    @FXML
    void onRegresar(ActionEvent event) {
        TiendaApp.openHomeView();
    }


    void initialize() {
        HistorialPedidosController historialPedidosController = new HistorialPedidosController(TiendaApp.tienda);
        iniView();
    }

    private void iniView() {
        initDataBinding();
        cargarProductos();
        listenerSelection();
    }
    public void initDataBinding() {
        colNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        colPrecioProducto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().precio()).asString());
    }
    public void cargarProductos() {
        Collection<ProductoRecord> productosR = TiendaApp.tienda.getProductos();
        productos.setAll(productosR);
    }
    public void listenerSelection(){
        tableProductos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                selectedProducto = (ProductoRecord) newValue;
            }
        });
    }

}

