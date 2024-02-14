/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.ConexionesBBDD;

/**
 * FXML Controller class
 *
 * @author gianf
 */
public class VistaLoginInicioController implements Initializable {
    
    @FXML
    private Label labelUsuario;
    @FXML
    private TextField textFieldUsuario;
    @FXML
    private Label labelContrasena;
    @FXML
    private Button buttonIniciarSesion;
    @FXML
    private PasswordField passwordFieldPsw;
    @FXML
    private Button buttonRgistrarse;
    @FXML
    private ImageView imgviewFondologin;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void iniciarSesion(ActionEvent event) {
        if (ConexionesBBDD.loginUsuario(textFieldUsuario.getText(), passwordFieldPsw.getText()) == true) {
            try {
                //Abrir la nueva ventana
                //
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaPantallaPrincipal.fxml"));
                //Referencia al padre,cargarlo
                Parent root = (Parent) loader.load();
                //Cargar el controlador de la vista
                VistaPantallaPrincipalController controlador = loader.getController();
                //PruebaController  controlador = loader.getController();
                //Crear la escena
                Scene scenaPantallaPrincipal = new Scene(root);
                Stage stagePantallaPrincipal = new Stage();
                //css
                scenaPantallaPrincipal.getStylesheets().add(getClass().getResource("/vista/estilo.css").toExternalForm());
                //Hacerla modal
                stagePantallaPrincipal.initModality(Modality.APPLICATION_MODAL);
                //Seleccionarla
                stagePantallaPrincipal.setScene(scenaPantallaPrincipal);
                //ocultar login
                source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();
                //Para que no se pueda modifcar el tamaño de la ventana
                stagePantallaPrincipal.setResizable(false);
                stagePantallaPrincipal.showAndWait();
            } catch (IOException ex) {
                Logger.getLogger(VistaLoginInicioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        limpiarLogin();

    }
    private static Node source = null;
    
    private void limpiarLogin() {
        textFieldUsuario.setText("");
        passwordFieldPsw.setText("");
    }

    @FXML
    private void regristrarse(ActionEvent event) {
        try {
            //Abrir la nueva ventana
            //
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaLoginRegistro.fxml"));
            //Referencia al padre,cargarlo
            Parent root = (Parent) loader.load();
            //Cargar el controlador de la vista
            VistaLoginRegistroController controlador = loader.getController();
            //PruebaController  controlador = loader.getController();
            //Crear la escena
            Scene scenaNuevoRegistro = new Scene(root);
            Stage stageNuevoRegistro = new Stage();
            //Hacerla modal
            stageNuevoRegistro.initModality(Modality.APPLICATION_MODAL);
            //Seleccionarla
            stageNuevoRegistro.setScene(scenaNuevoRegistro);
            //Para que no se pueda modifcar el tamaño de la ventana
            stageNuevoRegistro.setResizable(false);
            stageNuevoRegistro.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(VistaLoginInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void mostrarLogin() 
    {
        Stage stage = (Stage) source.getScene().getWindow();
        stage.show();
                
    }
    //Al hacer enter en el ultimo campo entrar
    @FXML
    private void entrar(KeyEvent event) {
        ActionEvent ev = new ActionEvent();
        if (event.getCode() == KeyCode.ENTER)
        {
            if (ConexionesBBDD.loginUsuario(textFieldUsuario.getText(), passwordFieldPsw.getText()) == true) {
            try {
                //Abrir la nueva ventana
                //
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaPantallaPrincipal.fxml"));
                //Referencia al padre,cargarlo
                Parent root = (Parent) loader.load();
                //Cargar el controlador de la vista
                VistaPantallaPrincipalController controlador = loader.getController();
                //PruebaController  controlador = loader.getController();
                //Crear la escena
                Scene scenaPantallaPrincipal = new Scene(root);
                Stage stagePantallaPrincipal = new Stage();
                //css
                scenaPantallaPrincipal.getStylesheets().add(getClass().getResource("/vista/estilo.css").toExternalForm());
                //Hacerla modal
                stagePantallaPrincipal.initModality(Modality.APPLICATION_MODAL);
                //Seleccionarla
                stagePantallaPrincipal.setScene(scenaPantallaPrincipal);
                //ocultar login
                source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();
                //Para que no se pueda modifcar el tamaño de la ventana
                stagePantallaPrincipal.setResizable(false);
                stagePantallaPrincipal.showAndWait();
            } catch (IOException ex) {
                Logger.getLogger(VistaLoginInicioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        limpiarLogin();
        }
    }

}
