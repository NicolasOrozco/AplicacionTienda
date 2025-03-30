package co.edu.uniquindio.poo.aplicaciontienda.viewController;

import co.edu.uniquindio.poo.aplicaciontienda.app.TiendaApp;
import co.edu.uniquindio.poo.aplicaciontienda.controller.HistorialPedidosController;
import co.edu.uniquindio.poo.aplicaciontienda.model.PedidoDTO;
import co.edu.uniquindio.poo.aplicaciontienda.model.ProductoRecord;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.Collection;

public class PedidosTotalesViewController {
    private final ObservableList<ProductoRecord> productos = FXCollections.observableArrayList();
    private PedidoDTO SelectedPedido;

    public TiendaApp tiendaApp;
    HistorialPedidosController historialPedidosController;
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
    private TextField txtfieldCiudad;

    @FXML
    private TableView<ProductoRecord> tableProductos;

    @FXML
    void onAgregarProductoAPedido(ActionEvent event) {

    }

    @FXML
    void onCrearPedido(ActionEvent event) {

    }

    @FXML
    void onVerTodosLosPedidos(ActionEvent event) {

    }

    @FXML
    void onRegresar(ActionEvent event) {

    }
    void initialize() {
        historialPedidosController = new HistorialPedidosController(tiendaApp.tienda);
        iniView();
    }
    private void iniView() {
        initDataBinding();
        cargarProductos();
        listenerSelection();
    }
    public void initDataBinding() {
        colNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colPrecioProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrecio()));
    }
    public void cargarProductos() {
        Collection<ProductoRecord> productosR =tiendaApp.tienda.getProductos();
        productos.setAll(productosR);
    }




}


