package co.edu.uniquindio.poo.aplicaciontienda.viewController;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.aplicaciontienda.app.TiendaApp;
import co.edu.uniquindio.poo.aplicaciontienda.controller.PedidosTotalesController;
import co.edu.uniquindio.poo.aplicaciontienda.model.DireccionRecord;
import co.edu.uniquindio.poo.aplicaciontienda.model.Estado;
import co.edu.uniquindio.poo.aplicaciontienda.model.PedidoDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class PedidosTotalesViewController implements Initializable {
    private PedidosTotalesController pedidosTotalesController;
    private TiendaApp tiendaApp;
    private PedidoDTO selectedPedido;
    private final ObservableList<PedidoDTO> pedidosTotales = FXCollections.observableArrayList();

    @FXML
    private TableColumn<PedidoDTO, String> colDireccionPedido, colEstadoPedido, colClientePedido, colIdPedido;
    @FXML
    private TextField txtfieldCodigoPostal, txtfieldCalle, txtfieldIdCliente, txtfieldCiudad, txtfieldIdpedido;
    @FXML
    private ComboBox<Estado> comboEstado;
    @FXML
    private TableView<PedidoDTO> tableTotalPedidos;

    public void setTiendaApp(TiendaApp tiendaApp) {
        this.tiendaApp = tiendaApp;
        this.pedidosTotalesController = new PedidosTotalesController(tiendaApp.tienda);
        initView();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboEstado.setItems(FXCollections.observableArrayList(Estado.values()));
    }

    private void initView() {
        initDataBinding();
        cargarPedidos();
        listenerSelection();
    }

    private void initDataBinding() {
        colClientePedido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().toString()));
        colDireccionPedido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion().toString()));
        colEstadoPedido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado().toString()));
        colIdPedido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
    }

    private void cargarPedidos() {
        pedidosTotales.setAll(tiendaApp.tienda.getPedidos());
        tableTotalPedidos.setItems(pedidosTotales);
    }

    private void listenerSelection() {
        tableTotalPedidos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedPedido = newValue;
                txtfieldIdCliente.setText(selectedPedido.getCliente().getId());
                txtfieldIdpedido.setText(selectedPedido.getId());
                txtfieldCalle.setText(selectedPedido.getDireccion().calle());
                txtfieldCiudad.setText(selectedPedido.getDireccion().ciudad());
                txtfieldCodigoPostal.setText(selectedPedido.getDireccion().codigoPostal());
                comboEstado.setValue(selectedPedido.getEstado());
            }
        });
    }

    @FXML
    void onBuscarPedido() {
        PedidoDTO pedido = pedidosTotalesController.buscarPedido(txtfieldIdpedido.getText());
        if (pedido != null) {
            selectedPedido = pedido;
            txtfieldIdCliente.setText(pedido.getCliente().getId());
            txtfieldCalle.setText(pedido.getDireccion().calle());
            txtfieldCiudad.setText(pedido.getDireccion().ciudad());
            txtfieldCodigoPostal.setText(pedido.getDireccion().codigoPostal());
            comboEstado.setValue(pedido.getEstado());
        } else {
            mostrarAlerta("Error", "Pedido no encontrado");
        }
    }

    @FXML
    void onEliminarPedido() {
        if (selectedPedido != null) {
            pedidosTotalesController.eliminarPedido(selectedPedido.getId());
            cargarPedidos();
            limpiarCampos();
        } else {
            mostrarAlerta("Error", "Seleccione un pedido para eliminar");
        }
    }

    @FXML
    void onEditarPedido() {
        if (selectedPedido != null) {
            selectedPedido.setDireccion(new DireccionRecord(txtfieldCiudad.getText(), txtfieldCodigoPostal.getText(), txtfieldCalle.getText()));
            selectedPedido.setEstado(comboEstado.getValue());
            pedidosTotalesController.editarPedido(selectedPedido.getId(), selectedPedido);
            cargarPedidos();
        } else {
            mostrarAlerta("Error", "Seleccione un pedido para editar");
        }
    }

    private void limpiarCampos() {
        txtfieldIdpedido.clear();
        txtfieldIdCliente.clear();
        txtfieldCalle.clear();
        txtfieldCiudad.clear();
        txtfieldCodigoPostal.clear();
        comboEstado.setValue(null);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
