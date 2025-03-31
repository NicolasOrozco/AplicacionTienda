package co.edu.uniquindio.poo.aplicaciontienda.viewController;
//VIEW CONTROLLER Y CONTROLLER HECHOS
import co.edu.uniquindio.poo.aplicaciontienda.app.TiendaApp;
import co.edu.uniquindio.poo.aplicaciontienda.controller.GestionClientesController;
import co.edu.uniquindio.poo.aplicaciontienda.model.ClienteDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.Collection;

public class GestionClientesViewController {

    private  final ObservableList<ClienteDTO> listaCLientes = FXCollections.observableArrayList();
    private  ClienteDTO selectedCliente;
    public GestionClientesController gestionClientesController;

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
        if (selectedCliente != null){
            gestionClientesController.eliminarCliente(selectedCliente.getId());
            cargarClientes();
        }
    }

    @FXML
    void onRegresar() {
        TiendaApp.openHomeView();
    }

    @FXML
    void onEditarCliente() {
        if (selectedCliente != null) {
            gestionClientesController.actualizarCliente(selectedCliente.getId(), new ClienteDTO(txtfieldNombreCliente.getText(),txtfieldIdCliente.getText()));
            cargarClientes();
        }
    }

    @FXML
    void onCrearCliente() {
        gestionClientesController.agregarCliente(new ClienteDTO(txtfieldNombreCliente.getText(), selectedCliente.getId()));
        cargarClientes();
    }
    void initialize() {
        gestionClientesController = new GestionClientesController(TiendaApp.tienda);
        configurarTabla();
        cargarClientes();
        listenerSelection();
        initView();
    }
    private void initView() {
        configurarTabla();
        cargarClientes();
        listenerSelection();
    }
    private void configurarTabla() {
        colIdCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tableClientes.setItems(listaCLientes);
    }
    private void cargarClientes() {
        Collection<ClienteDTO> clientes = TiendaApp.tienda.getClientes();
        listaCLientes.setAll(clientes);
    }
    private void listenerSelection(){
        tableClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                selectedCliente = newSelection;
                txtfieldNombreCliente.setText(selectedCliente.getNombre());
                txtfieldIdCliente.setText(String.valueOf(selectedCliente.getId()));
            }
        });
    }


}
