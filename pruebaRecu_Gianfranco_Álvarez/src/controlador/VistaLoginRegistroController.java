/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.ConexionesBBDD;

/**
 * FXML Controller class
 *
 * @author gianf
 */
public class VistaLoginRegistroController implements Initializable {

    @FXML
    private PasswordField passwordFieldPsw;
    @FXML
    private Label labelContrasena;
    @FXML
    private TextField textFieldUsuario;
    @FXML
    private Label labelUsuario;
    @FXML
    private Button buttonRegistrar;
    @FXML
    private Button buttonVolver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void registrarUsuario(ActionEvent event) {
        if(ConexionesBBDD.addUsuario(textFieldUsuario.getText().toString(), passwordFieldPsw.getText().toString()) == true)
            volver(event); 
        else
            limpiarLogin();
    }

    @FXML
    private void volver(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    private void limpiarLogin() {
        textFieldUsuario.setText("");
        passwordFieldPsw.setText("");
    }

}
