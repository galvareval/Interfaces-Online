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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.ConexionesBBDD;

/**
 * FXML Controller class
 *
 * @author gianf
 */
public class VistaGestionBandasController implements Initializable {

    @FXML
    private Label labeNuevaBanda;
    @FXML
    private TextField textFieldNombreBanda;
    @FXML
    private Label labelNombreBanda;
    @FXML
    private Label labelNombreSala;
    @FXML
    private Label labelEstilo;
    @FXML
    private TextField textFieldEstilo;
    @FXML
    private Label labelAnoFomracion;
    @FXML
    private DatePicker datePickerBanda;
    @FXML
    private TextField textFieldCache;
    @FXML
    private Label labelCache;
    @FXML
    private Button buttonVolver;
    @FXML
    private Button buttonregistrar;
    @FXML
    private ComboBox<String> comboNuevaBanda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for (String item : ConexionesBBDD.nombresSalas()) {
            comboNuevaBanda.getItems().add(item);
        }
    }

    @FXML
    private void volverBanda(Event event) {
        //cerar ventana
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    //al clickar boton registrar
    @FXML
    private void registrarBanda(ActionEvent event) {
        regsitrarBandaAccion(event);
    }
    //al hacer enter en el ultimo campo
    @FXML
    private void registrarEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) 
        {
            regsitrarBandaAccion(event);
        }
    }
    
    private void regsitrarBandaAccion(Event event)
    {
        if (datePickerBanda.getValue() != null && comboNuevaBanda.getValue() != null) {
            if (ConexionesBBDD.addBanda(textFieldNombreBanda.getText(), comboNuevaBanda.getValue().toString(), textFieldEstilo.getText(), datePickerBanda.getValue().toString(), textFieldCache.getText()) == true) {
                volverBanda(event);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Hay campos vacios", "", JOptionPane.ERROR_MESSAGE);
    }

}
