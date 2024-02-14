/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.ConexionesBBDD;
import modelo.ImportarExelMiembros;
import modelo.Miembros;

/**
 * FXML Controller class
 *
 * @author gianf
 */
public class VistaGestionMiembrosController implements Initializable {

    @FXML
    private Label labeNuevaBanda;
    @FXML
    private Label labelNombreBanda;
    @FXML
    private Label labelEstilo;
    @FXML
    private Button buttonVolver;
    @FXML
    private Button buttonregistrar;
    @FXML
    private TextField textFieldDniMiembro;
    @FXML
    private Label labelDniMiembro;
    @FXML
    private ComboBox<String> comboBandaNuevoMiembro;
    @FXML
    private TextField textFieldDir;
    @FXML
    private TextField textFieldInstrumento;
    @FXML
    private Label labelInstrumento;
    @FXML
    private Label labelEdad;
    @FXML
    private TextField textFieldEdad;
    @FXML
    private Button buttonVolver1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //rellenar combo con las bandas registradas
        for (String item : ConexionesBBDD.nombresBandas()) {
            comboBandaNuevoMiembro.getItems().add(item);
        }
    }

    @FXML
    private void volverMiembro(Event event) {
        //cerar ventana
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void registrarMiembro(ActionEvent event) {
        registrarMiembroAccion(event);
    }

    //accion de registro ultimo campo enter
    @FXML
    private void registrarMiembroEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            registrarMiembroAccion(event);
        }
    }

    //accion de registrar
    private void registrarMiembroAccion(Event event) {
        if (comboBandaNuevoMiembro.getValue() != null) {
            if (ConexionesBBDD.addMiembro(textFieldDniMiembro.getText(), comboBandaNuevoMiembro.getValue().toString(), textFieldDir.getText(), textFieldEdad.getText(), textFieldInstrumento.getText()) == true) {
                volverMiembro(event);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hay campos vacios", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void addVariosMiembros(ActionEvent event) {
        
        registrarVariosMiembros(event);
        
    }
    
    private void registrarVariosMiembros(Event event)
    {
        ArrayList<Miembros> miebrosAinsertar = new ArrayList<Miembros>();
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Elegir archivo Miembros");
        fileChooser.getExtensionFilters().addAll(
         new ExtensionFilter("Exel", "*.xls"));
         File selectedFile = fileChooser.showOpenDialog(stage);
               
        miebrosAinsertar = ImportarExelMiembros.miembrosAinsertarDeExel(selectedFile);//hacer file chooser para file al darle a boton subir varios
        boolean insertarVariosOK = false;
        for (Miembros miembro : miebrosAinsertar) {
            String nombreBanda = miembro.getNombreBanda();
            String dni = miembro.getDni();
            String dir = miembro.getDir();
            int edad = miembro.getEdad();
            String instrumento = miembro.getInstrumento();
            insertarVariosOK = ConexionesBBDD.addMiembro(dni, nombreBanda, dir, String.valueOf(edad), instrumento);
        }
        if (insertarVariosOK == true)
            {
                JOptionPane.showMessageDialog(null, "Registros insertados correctamente", "", JOptionPane.INFORMATION_MESSAGE);
                volverMiembro(event);
            }
        else
            {
                JOptionPane.showMessageDialog(null, "Ha habido algun fallo en la inserccion", "", JOptionPane.ERROR_MESSAGE);
                volverMiembro(event);
            }

    }
}
