/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author gianf
 */
public class VisPantallaPrincipalController implements Initializable {

    @FXML
    private MenuBar MenuBarReservas;
    @FXML
    private Menu MenuReservas;
    @FXML
    private MenuItem MenuItemNuevaReserva;
    @FXML
    private Button ButtonNuevaRserva;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nuevaReserva(ActionEvent event) {
    }
    
}
