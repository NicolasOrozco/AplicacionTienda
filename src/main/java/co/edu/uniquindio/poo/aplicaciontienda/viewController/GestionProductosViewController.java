package co.edu.uniquindio.poo.aplicaciontienda.viewController;

import co.edu.uniquindio.poo.aplicaciontienda.app.TiendaApp;
import co.edu.uniquindio.poo.aplicaciontienda.controller.GestionProductosController;
import co.edu.uniquindio.poo.aplicaciontienda.model.ProductoRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.LinkedList;

public class GestionProductosViewController {

    private final ObservableList<ProductoRecord> listaProductos = FXCollections.observableArrayList();

    private TiendaApp tiendaApp;
    private GestionProductosController gestionProductosController;
    private ProductoRecord selectedProducto;

    @FXML
    private TableColumn<ProductoRecord, String> colNombreProducto;

    @FXML
    private TableColumn<ProductoRecord, String> colPrecioProducto;

    @FXML
    private TextField txtfieldNombreProducto;

    @FXML
    private TextField txtfieldPrecioProducto;

    @FXML
    private TableView<ProductoRecord> tableProductos;

    @FXML
    private Button btnEliminarProducto;

    @FXML
    private Button btnCrearProducto;

    public void setTiendaApp(TiendaApp tiendaApp) {
        this.tiendaApp = tiendaApp;
        this.gestionProductosController = new GestionProductosController(tiendaApp.tienda);
        cargarProductos();
    }

    @FXML
    public void initialize() {
        listenerSelection();
    }

    @FXML
    void onCrearProducto(ActionEvent event) {
        if (txtfieldNombreProducto.getText().isEmpty() || txtfieldPrecioProducto.getText().isEmpty()) {
            mostrarAlerta("Error", "Debe llenar todos los campos.");
            return;
        }

        try {
            double precio = Double.parseDouble(txtfieldPrecioProducto.getText());
            ProductoRecord productoRecord = new ProductoRecord(txtfieldNombreProducto.getText(), precio);
            gestionProductosController.agregarProducto(productoRecord);
            cargarProductos();
            limpiarCampos();
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El precio debe ser un número válido.");
        }
    }

    @FXML
    void onEliminarProducto() {
        if (selectedProducto == null) {
            mostrarAlerta("Error", "Debe seleccionar un producto.");
            return;
        }

        gestionProductosController.eliminarProducto(selectedProducto.nombre());
        cargarProductos();
        limpiarCampos();
    }

    @FXML
    void onRegresar(){

    TiendaApp.openHomeView();}

    public void cargarProductos() {
        LinkedList<ProductoRecord> productos = gestionProductosController.obtenerProductos();
        listaProductos.setAll(productos);
        tableProductos.setItems(listaProductos);
    }

    private void listenerSelection() {
        tableProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedProducto = newSelection;
                txtfieldNombreProducto.setText(newSelection.nombre());
                txtfieldPrecioProducto.setText(Double.toString(newSelection.precio()));
            }
        });
    }

    private void limpiarCampos() {
        txtfieldNombreProducto.clear();
        txtfieldPrecioProducto.clear();
        selectedProducto = null;
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    public void setApp(TiendaApp tiendaApp){
        this.tiendaApp = tiendaApp;
    }
}
