package co.edu.uniquindio.poo.aplicaciontienda.viewController;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.aplicaciontienda.app.TiendaApp;
import co.edu.uniquindio.poo.aplicaciontienda.controller.PedidosTotalesController;
import co.edu.uniquindio.poo.aplicaciontienda.model.Estado;
import co.edu.uniquindio.poo.aplicaciontienda.model.PedidoDTO;
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
        //PedidoDTO pedidoDTO = pedidosTotalesController.buscarPedido(txtfieldIdpedido.getText());

    }

    @FXML
    void onEliminarPedido() {
        pedidosTotalesController.eliminarPedido(txtfieldIdpedido.getText());
    }


    @FXML
    void onEditarPedido() {

    }

    @FXML
    void onRegresar() {

    }

    @FXML
    void initialize() {


    }
}
