package co.edu.uniquindio.poo.aplicaciontienda.viewController;

import co.edu.uniquindio.poo.aplicaciontienda.app.TiendaApp;
import co.edu.uniquindio.poo.aplicaciontienda.controller.GestionClientesController;
import co.edu.uniquindio.poo.aplicaciontienda.model.ClienteDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.Collection;

public class GestionClientesViewController {

    private final ObservableList<ClienteDTO> listaClientes = FXCollections.observableArrayList();
    private ClienteDTO selectedCliente;
    private GestionClientesController gestionClientesController;

    @FXML
    private TableColumn<ClienteDTO, String> colNombreCliente;

    @FXML
    private TableView<ClienteDTO> tableClientes;

    @FXML
    private TextField txtfieldNombreCliente;

    @FXML
    private TableColumn<ClienteDTO, String> colIdCliente;

    @FXML
    private TextField txtfieldIdCliente;

    @FXML
    void onEliminarCliente() {
        if (selectedCliente != null) {
            gestionClientesController.eliminarCliente(selectedCliente.getId());
            limpiarCampos();
            cargarClientes();
        } else {
            mostrarAlerta("Error", "Debe seleccionar un cliente para eliminar");
        }
    }

    @FXML
    void onRegresar() {
        TiendaApp.openHomeView();
    }

    @FXML
    void onEditarCliente() {
        if (selectedCliente != null) {
            gestionClientesController.actualizarCliente(
                    selectedCliente.getId(),
                    new ClienteDTO(txtfieldNombreCliente.getText(), txtfieldIdCliente.getText())
            );
            limpiarCampos();
            cargarClientes();
        } else {
            mostrarAlerta("Error", "Debe seleccionar un cliente para editar");
        }
    }

    @FXML
    void onCrearCliente() {
        String nombre = txtfieldNombreCliente.getText();
        String id = txtfieldIdCliente.getText();

        if (nombre.isEmpty() || id.isEmpty()) {
            mostrarAlerta("Error", "Debe completar todos los campos");
            return;
        }

        gestionClientesController.agregarCliente(new ClienteDTO(nombre, id));
        limpiarCampos();
        cargarClientes();
    }

    @FXML
    void initialize() {
        gestionClientesController = new GestionClientesController(TiendaApp.tienda);
        configurarTabla();
        cargarClientes();
        listenerSelection();
    }

    private void configurarTabla() {
        colIdCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tableClientes.setItems(listaClientes);
    }

    private void cargarClientes() {
        Collection<ClienteDTO> clientes = TiendaApp.tienda.getClientes();
        listaClientes.setAll(clientes);
    }

    private void listenerSelection() {
        tableClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCliente = newSelection;
            if (newSelection != null) {
                txtfieldNombreCliente.setText(selectedCliente.getNombre());
                txtfieldIdCliente.setText(selectedCliente.getId());
            } else {
                limpiarCampos();
            }
        });
    }

    private void limpiarCampos() {
        txtfieldNombreCliente.clear();
        txtfieldIdCliente.clear();
        selectedCliente = null;
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
