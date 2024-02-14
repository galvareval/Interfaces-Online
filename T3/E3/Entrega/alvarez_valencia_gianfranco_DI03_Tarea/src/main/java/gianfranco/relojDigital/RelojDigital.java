/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gianfranco.relojDigital;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author gianf
 */
public class RelojDigital extends JLabel implements Serializable {

    //Atributo formato del reloj
    private boolean formato24;
    //Alarma
    private Alarma alarma;//Crear clase alarma y un panel para selecionar la alarma
    //Formateo de la fecha
    private SimpleDateFormat sDformato24h = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat sDformato12h = new SimpleDateFormat("hh:mm:ss a");
    
    //Sonar la alarma
    private AlarmaListener alarmaListener;

    public RelojDigital()//constructor sin parámetros
    {
        Timer timer = new Timer();//hora
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Date hora = new Date();//obtener hora actual
                if (formato24)//Formatear en 24h
                {
                    setText(sDformato24h.format(hora));
                } else//Formatear en 12h
                {
                    setText(sDformato12h.format(hora));
                }
                //caso existe alarma
                if (alarma != null) {
                    //Si la alarma esta activa y coincide con la hora actual--Hacer algo
                    if (alarma.isActiva() && alarmaIgualHoraActual(hora, alarma.getHoraAlarma())) {
                        alarmaListener.sonarAlarma();
                        System.out.println("Alarma ejecutada correctamente");
                        //Desactivar la alarma. de lo contrario se repetira el minuto entero hasta que cambie la hora
                        alarma.setActiva(false);
                        System.out.println("Alarma desactivada");
                    }
                }
            }
        }, 0, 1000);//Actualizar cada segundo la hora actual
    }

    //Generar getter y setter
    public boolean isFormato24() {
        return formato24;
    }

    public void setFormato24(boolean formato24) {
        this.formato24 = formato24;
    }

    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }

    /**
     * Lo que hace la alarma al sonar
     *
     * @param alarmaListener
     */
    public void addAlarmaListener(AlarmaListener alarmaListener) {
        this.alarmaListener = alarmaListener;
    }


    /**
     * Convertir la fecha tipo Date a LocalDateTime con formato hh:mm para compararlos y luego devolverlos como string
     *
     * @param dateToConvert Date a convertir
     * @return String Fecha formateada
     */
    public String convertToLocalDateTimeViaInstant(Date dateToConvert) 
    {
        //Formato
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return (dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()).format(formatter);
    }
    /**
     * Método que compara si dos fechas son iguales
     * @param horaActual fecha a comaparar 1
     * @param horaAlarma fecha a comparar 2
     * @return Devuelve booleano con el resultado de la comparación
     */
    private boolean alarmaIgualHoraActual(Date horaActual, Date horaAlarma) {
        //Comaprar si las fechas son iguales;cambiar tipo objeto para comparar más facil; se compararn string formateados de la fecha
        System.out.println("FactualHM: " + convertToLocalDateTimeViaInstant(horaActual) + " FechaAlarmaHM: " + convertToLocalDateTimeViaInstant(horaAlarma) );
        if ((convertToLocalDateTimeViaInstant(horaActual)).equals(convertToLocalDateTimeViaInstant(horaAlarma)))
        {
            System.out.println("Hora y alarma iguales");
            return true;
        } else 
        {
            //System.out.println("Hora y alarma diferentes");
            return false;
        }
    }

}