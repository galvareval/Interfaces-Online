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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gianf
 */
public class VistaPantallaPrincipalController implements Initializable {

    @FXML
    private ImageView imgSalas;
    @FXML
    private ImageView imgBandas;
    @FXML
    private Label labelTitulo;
    @FXML
    private Label labelSalas;
    @FXML
    private Label labelBandas;
    @FXML
    private ImageView imgMiembros;
    @FXML
    private Label labelMiembros;
    @FXML
    private Button buttonCerrarSesion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gerstionarSalas(MouseEvent event) {
        try {
                //Abrir la nueva ventana
                //
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaGestionSalas.fxml"));
                //Referencia al padre,cargarlo
                Parent root = (Parent) loader.load();
                //Cargar el controlador de la vista
                VistaGestionSalasController controlador = loader.getController();
                //PruebaController  controlador = loader.getController();
                //Crear la escena
                Scene scenaGestionSalas = new Scene(root);
                Stage stageGestionSalas = new Stage();
                //css
                scenaGestionSalas.getStylesheets().add(getClass().getResource("/vista/estilo.css").toExternalForm());
                //Hacerla modal
                stageGestionSalas.initModality(Modality.APPLICATION_MODAL);
                //Seleccionarla
                stageGestionSalas.setScene(scenaGestionSalas);
                //Para que no se pueda modifcar el tamaño de la ventana
                stageGestionSalas.setResizable(false);
                stageGestionSalas.showAndWait();
            } catch (IOException ex) {
                Logger.getLogger(VistaLoginInicioController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void gerstionarBandas(MouseEvent event) {
        try {
                //Abrir la nueva ventana
                //
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaGestionBandas.fxml"));
                //Referencia al padre,cargarlo
                Parent root = (Parent) loader.load();
                //Cargar el controlador de la vista
                VistaGestionBandasController controlador = loader.getController();
                //PruebaController  controlador = loader.getController();
                //Crear la escena
                Scene scenaGestionBandas = new Scene(root);
                Stage stageGestionBandas = new Stage();
                //css
                scenaGestionBandas.getStylesheets().add(getClass().getResource("/vista/estilo.css").toExternalForm());
                //Hacerla modal
                stageGestionBandas.initModality(Modality.APPLICATION_MODAL);
                //Seleccionarla
                stageGestionBandas.setScene(scenaGestionBandas);
                //Para que no se pueda modifcar el tamaño de la ventana
                stageGestionBandas.setResizable(false);
                stageGestionBandas.showAndWait();
            } catch (IOException ex) {
                Logger.getLogger(VistaLoginInicioController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void gerstionarMiembros(MouseEvent event) {
        try {
                //Abrir la nueva ventana
                //
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaGestionMiembros.fxml"));
                //Referencia al padre,cargarlo
                Parent root = (Parent) loader.load();
                //Cargar el controlador de la vista
                VistaGestionMiembrosController controlador = loader.getController();
                //PruebaController  controlador = loader.getController();
                //Crear la escena
                Scene scenaGestionMiembros = new Scene(root);
                Stage stageGestionMiembros = new Stage();
                //css
                scenaGestionMiembros.getStylesheets().add(getClass().getResource("/vista/estilo.css").toExternalForm());
                //Hacerla modal
                stageGestionMiembros.initModality(Modality.APPLICATION_MODAL);
                //Seleccionarla
                stageGestionMiembros.setScene(scenaGestionMiembros);
                //Para que no se pueda modifcar el tamaño de la ventana
                stageGestionMiembros.setResizable(false);
                stageGestionMiembros.showAndWait();
            } catch (IOException ex) {
                Logger.getLogger(VistaLoginInicioController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void cerrarSesion(ActionEvent event) {
        //cerar ventana
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        //mostrar login
        VistaLoginInicioController.mostrarLogin();
    }
    
    @FXML
    private void selecSalas(MouseEvent event) {
        labelSalas.getStyleClass().add("imgFontSelected");
    }

    @FXML
    private void selecBandas(MouseEvent event) {
        labelBandas.getStyleClass().add("imgFontSelected");
    }

    @FXML
    private void selecMiembros(MouseEvent event) {
        labelMiembros.getStyleClass().add("imgFontSelected");
    }

    @FXML
    private void celarSelec(MouseEvent event) {
        labelSalas.getStyleClass().clear();
        labelBandas.getStyleClass().clear();
        labelMiembros.getStyleClass().clear();
    }
    
}
