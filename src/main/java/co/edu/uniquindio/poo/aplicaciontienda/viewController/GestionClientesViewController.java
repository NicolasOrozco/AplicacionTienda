package co.edu.uniquindio.poo.aplicaciontienda.viewController;

import co.edu.uniquindio.poo.aplicaciontienda.app.TiendaApp;
import co.edu.uniquindio.poo.aplicaciontienda.controller.GestionClientesController;
import co.edu.uniquindio.poo.aplicaciontienda.model.ClienteDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.Collection;

public class GestionClientesViewController {
    private  final ObservableList<ClienteDTO> listaCLientes = FXCollections.observableArrayList();
    private  ClienteDTO selectedCliente;

    public TiendaApp tiendaApp;
    public GestionClientesController gestionClientesController;

    @FXML
    private TableColumn<ClienteDTO, String> colNombreCliente;

    @FXML
    private TableView<ClienteDTO> tableClientes;

    @FXML
    private Button btnEditarCliente;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private TextField txtfieldNombreCliente;

    @FXML
    private TableColumn<ClienteDTO, String> colIdCliente;

    @FXML
    private TextField txtfieldIdCliente;

    @FXML
    private Button btnCrearCliente;


    @FXML
    void onEliminarCliente(ActionEvent event) {
        gestionClientesController.eliminarCliente(txtfieldIdCliente.getText());
    }

    @FXML
    void onRegresar(ActionEvent event) {


    }

    @FXML
    void onEditarCliente(ActionEvent event) {
        gestionClientesController.actualizar(txtfieldIdCliente.getText(), new ClienteDTO(txtfieldNombreCliente.getText(), selectedCliente.getId()));
    }

    @FXML
    void onCrearCliente(ActionEvent event) {
        gestionClientesController.agregarCliente(new ClienteDTO(txtfieldNombreCliente.getText(), selectedCliente.getId()));
    }
    void initialize() {
        gestionClientesController = new GestionClientesController(tiendaApp.tienda);
        initView();
    }
    private void initView() {
        initDataBinding();
        cargarClientes();
        listenerSelection();
    }
    private void initDataBinding() {
        colIdCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
    }
    private void cargarClientes() {
        Collection<ClienteDTO> clientes = tiendaApp.tienda.getClientes();
        listaCLientes.setAll(clientes);
    }
    private void listenerSelection(){
        tableClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                selectedCliente = (ClienteDTO) newSelection;
                txtfieldNombreCliente.setText(selectedCliente.getNombre());
                txtfieldIdCliente.setText(String.valueOf(selectedCliente.getId()));
            }
        });
    }



}

