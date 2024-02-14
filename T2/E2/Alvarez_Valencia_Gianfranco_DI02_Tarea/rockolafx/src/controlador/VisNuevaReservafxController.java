/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
//import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gianf
 */
public class VisNuevaReservafxController implements Initializable {
    @FXML
    private Pane paneNuevaReserva;
    @FXML
    private Label labelNuevaRserva;
    @FXML
    private Separator separatorNuevaReserva;
    @FXML
    private Label labelNombre;
    @FXML
    private TextField texFieldNombre;
    @FXML
    private TextField texFieldApellidos;
    @FXML
    private Label labelApellidos;
    @FXML
    private TextField texFieldTelefono;
    @FXML
    private Label labelTelefono;
    @FXML
    private Separator separatorNuevaReserva2;
    @FXML
    private Label labelFechaEvento;
    @FXML
    private TitledPane TitledPaneDatosFestival;
    @FXML
    private Label labelNumeroDias;
    @FXML
    private TextField textFieldNumeroDias;
    @FXML
    private Label labelRequierePulsera;
    @FXML
    private CheckBox checkBoxPulsera;
    @FXML
    private Label labelNumeroPersonas;
    @FXML
    private TextField texFieldNumeroPersonas;
    @FXML
    private Label labelTipoSala;
    @FXML
    private ComboBox<String> comboBoxTiposala;//Para inciarlizar  el combobox
    @FXML
    private ComboBox<String> comboBoxTipoevento;//Para incializar el combobox
    @FXML
    private Label labellTipoEvento;
    @FXML
    private Button buttonReservar;
    @FXML
    private AnchorPane anchorPaneTipoFestival;
    @FXML
    private DatePicker DatePickerFechaEvento;
    @FXML
    private Tooltip toolTipeNombre;
    @FXML
    private Tooltip toolTipApellidos;
    @FXML
    private Tooltip toolTipTelefono;
    @FXML
    private Tooltip toolTipeFechaEvento;
    @FXML
    private Tooltip toolTipNumDias;
    @FXML
    private Tooltip toolTipPulsera;
    @FXML
    private Tooltip toolTipNumPersonas;
    @FXML
    private Tooltip toolTipeTipoSala;
    @FXML
    private Tooltip toolTipeTipoEvento;
    @FXML
    private Tooltip toolTipReservar;
    @FXML
    private ImageView imageRock;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializar combobox tipo evento
        comboBoxTipoevento.getItems().removeAll(comboBoxTipoevento.getItems());
        comboBoxTipoevento.getItems().addAll("Local ensayo", "Concierto", "Festival");
        // Inicializar comboxo tipo Sala
        comboBoxTiposala.getItems().removeAll(comboBoxTiposala.getItems());
        comboBoxTiposala.getItems().addAll("Sala pequeña", "Gran sala", "Evento en patio");
        //Ocultar si no es festival desde el principio
        TitledPaneDatosFestival.setVisible(false);
        
    }    

    @FXML
    private void tipoEvento(ActionEvent event) {
        String tipoEvento;
        tipoEvento = comboBoxTipoevento.getValue();
        if (tipoEvento.equals("Festival"))
            TitledPaneDatosFestival.setVisible(true);
        else
            TitledPaneDatosFestival.setVisible(false);
           
    }

    @FXML
    private void reservar(ActionEvent event) {
        // Al clickar cerrar la ventana
        Stage stageNuevaReserva = (Stage) this.buttonReservar.getScene().getWindow();
        stageNuevaReserva.close();
    }
    
}
