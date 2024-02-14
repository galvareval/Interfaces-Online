/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
//import javafx.scene.control.DatePicker;//Añadir date picker a mano En netbeans 12.5 funciona
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gianf
 */
public class VisPantallaPrincipalController implements Initializable {
    @FXML
    private Button ButtonNuevaRserva;
    @FXML
    private MenuBar MenuBarReservas;
    @FXML
    private Menu MenuReservas;
    @FXML
    private MenuItem MenuItemNuevaReserva;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nuevaReserva(ActionEvent event) {
        
        try 
        {
            //Abrir la nueva ventana
            //
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/visNuevaReservafx.fxml"));
            //Referencia al padre,cargarlo
            Parent root = (Parent) loader.load();
            //Cargar el controlador de la vista
            VisNuevaReservafxController  controlador = loader.getController();
            //PruebaController  controlador = loader.getController();
            //Crear la escena
            Scene scenaNuevaReserva = new Scene(root);
            Stage stageNuevaReserva = new Stage();
            //Hacerla modal
            stageNuevaReserva.initModality(Modality.APPLICATION_MODAL);
            //Seleccionarla
            stageNuevaReserva.setScene(scenaNuevaReserva);
            //Para que no se pueda modifcar el tamaño de la ventana
            stageNuevaReserva.setResizable(false);
            stageNuevaReserva.showAndWait();
        } catch (IOException ex) 
        {
            Logger.getLogger(VisPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
