package co.edu.uniquindio.poo.aplicaciontienda.viewController;

import co.edu.uniquindio.poo.aplicaciontienda.app.TiendaApp;
import co.edu.uniquindio.poo.aplicaciontienda.controller.GestionProductosController;
import co.edu.uniquindio.poo.aplicaciontienda.controller.HistorialPedidosController;
import co.edu.uniquindio.poo.aplicaciontienda.model.ClienteDTO;
import co.edu.uniquindio.poo.aplicaciontienda.model.ProductoRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class GestionProductosViewController{

    private  final ObservableList<ProductoRecord> listaProductos = FXCollections.observableArrayList();

    public TiendaApp tiendaApp;
    public GestionProductosController gestionProductosController;
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
    void onEliminarProducto(){
        ProductoRecord productoSeleccionado = selectedProducto;
        if(productoSeleccionado != null){
            gestionProductosController.eliminarProducto(productoSeleccionado.nombre());
            cargarProductos();
        }
    }

    @FXML
    void onCrearProducto(ActionEvent event) {
        ProductoRecord productoRecord = new ProductoRecord(txtfieldNombreProducto.getText(), Double.parseDouble(txtfieldPrecioProducto.getText()));
        gestionProductosController.agregarProducto(productoRecord);
        cargarProductos();
    }


    public void cargarProductos(){
        LinkedList<ProductoRecord> productos = gestionProductosController.obtenerProductos();
        listaProductos.setAll(productos);
    }

    @FXML
    void onRegresar(ActionEvent event) {
        TiendaApp.openHomeView();
    }

    public ProductoRecord buildProducto(){
        return new ProductoRecord(txtfieldNombreProducto.getText(), Double.parseDouble(txtfieldPrecioProducto.getText()));
    }

    private void listenerSelection(){
        tableProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if( newSelection != null){
                selectedProducto = newSelection;
                txtfieldNombreProducto.setText(newSelection.nombre());
                txtfieldPrecioProducto.setText(Double.toString(newSelection.precio()));
            }
        });
    }

}
