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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PedidosTotalesViewController {
    PedidosTotalesController pedidosTotalesController;
    TiendaApp tiendaApp;
    PedidoDTO selectedPedido;
    private final ObservableList<PedidoDTO> pedidosTotales = FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<PedidoDTO, String> colDireccionPedido;

    @FXML
    private TableColumn<PedidoDTO, String> colEstadoPedido;

    @FXML
    private TextField txtfieldCodigoPostal;

    @FXML
    private TableColumn<PedidoDTO, String> colClientePedido;

    @FXML
    private ComboBox<Estado> comboEstado;

    @FXML
    private TextField txtfieldCalle;

    @FXML
    private TextField txtfieldIdCliente;

    @FXML
    private TextField txtfieldCiudad;

    @FXML
    private TextField txtfieldIdpedido;

    @FXML
    private TableView<PedidoDTO> tableTotalPedidos;

    @FXML
    private TableColumn<PedidoDTO, String> colIdPedido;



    @FXML
    void onBuscarPedido() {
        pedidosTotalesController.buscarPedido(txtfieldIdpedido.getText());

    }

    @FXML
    void onEliminarPedido() {
        pedidosTotalesController.eliminarPedido(txtfieldIdpedido.getText());
    }


    @FXML
    void onEditarPedido() {
        pedidosTotalesController.editarPedido(txtfieldIdpedido.getText(), new PedidoDTO(txtfieldIdpedido.getText(), tiendaApp.tienda.buscarCliente(txtfieldIdCliente.getText()), new DireccionRecord(txtfieldCiudad.getText(), txtfieldCodigoPostal.getText(), txtfieldCalle.getText())));
    }

    @FXML
    void onRegresar() {

    }

    @FXML
    void initialize() {
        pedidosTotalesController = new PedidosTotalesController(tiendaApp.tienda);
        initView();
    }

    public void initView(){
        initDataBinding();
        cargarPedidos();
        listenerSelection();
    }

    public  void initDataBinding(){
        colClientePedido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().toString()));
        colDireccionPedido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion().toString()));
        colEstadoPedido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado().toString()));
        colIdPedido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
    }
    public void cargarPedidos(){
        Collection<PedidoDTO> pedidos = tiendaApp.tienda.getPedidos();
        pedidosTotales.setAll(pedidos);
    }
    public void  listenerSelection(){
        tableTotalPedidos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedPedido = (PedidoDTO)  newValue;
            txtfieldIdCliente.setText(selectedPedido.getCliente().getId());
            txtfieldIdpedido.setText(selectedPedido.getId());
            txtfieldCalle.setText(selectedPedido.getDireccion().calle());
            txtfieldCiudad.setText(selectedPedido.getDireccion().ciudad());
            txtfieldCodigoPostal.setText(selectedPedido.getDireccion().codigoPostal());
        });
    }
}
