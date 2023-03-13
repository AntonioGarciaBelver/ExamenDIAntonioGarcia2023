
package com.mycompany.practicadesayunosjfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author anton
 */
public class PrimaryController implements Initializable {


    @FXML
    private MenuItem mEstadisticas;
    @FXML
    private MenuItem mCerrar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private Button btnAñadir;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnBorrar;
    @FXML
    private Label info;
    @FXML
    private TableView<?> tabla;
    @FXML
    private TableColumn<?, ?> cFecha;
    @FXML
    private TableColumn<?, ?> cCliente;
    @FXML
    private TableColumn<?, ?> cProducto;
    @FXML
    private TableColumn<?, ?> cEstado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void abrirEstadisticas(ActionEvent event) {
    }

    @FXML
    private void abrirCarta(ActionEvent event) {
    }

    @FXML
    private void abrirPedidos(ActionEvent event) {
    }

    @FXML
    private void cerrarAplicacion(ActionEvent event) {
    }

    @FXML
    private void abrirPedidosHoy(ActionEvent event) {
    }

    @FXML
    private void abrirPedidosDeHoy(ActionEvent event) {
    }

    @FXML
    private void añadirPedido(ActionEvent event) {
    }

    @FXML
    private void actualizarPedido(ActionEvent event) {
    }

    @FXML
    private void borrarPedido(ActionEvent event) {
    }

    @FXML
    private void mostrarPedido(MouseEvent event) {
    }

}
