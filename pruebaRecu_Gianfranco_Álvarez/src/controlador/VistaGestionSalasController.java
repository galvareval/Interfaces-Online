/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.ConexionesBBDD;
import modelo.GenerarPdf;

/**
 * FXML Controller class
 *
 * @author gianf
 */
public class VistaGestionSalasController implements Initializable {

    @FXML
    private Label labeNuevaSala;
    @FXML
    private Label labelNombreSala;
    @FXML
    private TextField textFieldNombreSala;
    @FXML
    private TextField textFieldAforo;
    @FXML
    private Label labelAforo;
    @FXML
    private Label labelPrecio;
    @FXML
    private TextField textFieldLocalidad;
    @FXML
    private Label labelLocalidad;
    @FXML
    private Button buttonregistrar;
    @FXML
    private Button buttonVolver;
    @FXML
    private TextField textFieldPrecio;
    @FXML
    private Button buttonListarPdf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void registrarSala(ActionEvent event) {
        if (ConexionesBBDD.addSala(textFieldNombreSala.getText(), textFieldAforo.getText(), textFieldPrecio.getText(), textFieldLocalidad.getText()) == true) {
            volverSala(event);
        }
    }

    @FXML
    private void volverSala(Event event) {
        //cerar ventana
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void registrarEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (ConexionesBBDD.addSala(textFieldNombreSala.getText(), textFieldAforo.getText(), textFieldPrecio.getText(), textFieldLocalidad.getText()) == true) {
                volverSala(event);
            }
        }
    }

    @FXML
    private void listarPDFSalas(ActionEvent event) {
        if(GenerarPdf.writePDFSalas() == true)
            JOptionPane.showMessageDialog(null, "PDF generado", "", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Error al generar el PDF", "", JOptionPane.ERROR_MESSAGE);
    }

}
