/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gianfranco.relojDigital;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author gianf
 */
public class AlarmaPropertyEditorSupport extends PropertyEditorSupport
{
    //Crear un panel para pasarlo
    private AlarmaPanel alarmaPanel = new AlarmaPanel(); 

    @Override
    public boolean supportsCustomEditor() {
        return true; //True = si hay propiedades definidas que no serán las de"fabrica"
    }

    @Override
    public Component getCustomEditor() {
        return alarmaPanel;//Pasar el panel para elegir la alarma.
    }

    @Override
    public String getJavaInitializationString() {
        //Tiene que devolver un string a partir del cual se creara el objeto
        //Obtener la hoara que se introdijo en el panel de selección de alarma y si esta activa
             
        return "new gianfranco.relojDigital.Alarma(new java.util.Date(" + alarmaPanel.getSelectedValue().getHoraAlarma().getTime() + "l)," + alarmaPanel.getSelectedValue().isActiva() + ")"; //Devovler el valor que tendra setAlarma para que funcione en ejecución
    }

    @Override
    public Object getValue() {
        return alarmaPanel.getSelectedValue(); //Devolver el valor del panel
    }
    
}
