/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gianfranco.relojDigital;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que modela la alarma, establace la hora y si esta activa o no
 * @author gianf
 */
public class Alarma implements Serializable
{
    //Hora de la alarma
    private Date horaAlarma;
    //Estado alarma
    private boolean activa;
    /**
     * Constructor
     * @param horaAlarma
     * @param activa 
     */
    public Alarma(Date horaAlarma, boolean  activa)
    {
        this.horaAlarma = horaAlarma;
        this.activa = activa;
    }

    public Date getHoraAlarma() {
        return horaAlarma;
    }

    public void setHoraAlarma(Date horaAlarma) {
        this.horaAlarma = horaAlarma;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}
