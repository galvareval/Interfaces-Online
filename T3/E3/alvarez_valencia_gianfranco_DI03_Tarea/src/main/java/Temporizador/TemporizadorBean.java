/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Temporizador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.EventListener;
import javax.swing.JLabel;
import javax.swing.Timer;
/**
 *
 * @author usuario
 */
public class TemporizadorBean extends JLabel implements ActionListener,Serializable 
{

    /**
     *
     * @author usuario
     */
    public class FinCuentaAtrasEvent extends java.util.EventObject
    {
        // constructor
        public FinCuentaAtrasEvent(Object source)
        {
            super(source);
        }
    }

    //Define la interfaz para el nuevo tipo de evento
    public interface FinCuentaAtrasListener extends EventListener
    {
        void capturarFinCuentaAtras(FinCuentaAtrasEvent ev);
    }
    protected int tiempo;
    public static final String PROP_TIEMPO = "tiempo";
    private FinCuentaAtrasListener receptor;
    /**
     * Get the value of tiempo
     *
     * @return the value of tiempo
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * Set the value of tiempo
     *
     * @param tiempo new value of tiempo
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
        setText(Integer.toString(tiempo));
        repaint();
    }

    private Timer t;

    //Activo es en si mismo una propiedad (sin atributo subyacente)
    //Gestiona si el temporizador está funcionado o no.
    public final void setActivo(boolean valor) {
        if (valor == true)
            t.start();
        else
            t.stop();
    }
    public boolean getActivo() {
        return t.isRunning();
    }

    //Constructor sin argumentos. Se establece como tiempo por defecto 5 segundos.
    public TemporizadorBean() {
        //propertySupport = new PropertyChangeSupport(this);
        tiempo = 5;
        t = new Timer (1000, this);
        setText(Integer.toString(tiempo));
        setActivo(true);
    }

    //Accion que se realiza cada vez que se cumplen los 1000 milisegudos establecidos
    //para t. se modifica el valor del texto de la etiqueta, se repinta y se disminuye
    //en un segundo el tiempo restante.
    //Cuando el tiempo llega a cero se para el Timer y se lanza un evento de finalización
    //de cuenta atrás.
    public void actionPerformed(ActionEvent e)
    {
        // Aquí el código que queramos ejecutar.
        setText(Integer.toString(tiempo));
        repaint();
        tiempo--;
        if(tiempo == 0){
            setActivo(false);
            receptor.capturarFinCuentaAtras( new FinCuentaAtrasEvent(this));
        }
    }


    public void addFinCuentaAtrasListener(FinCuentaAtrasListener receptor)
    {
        this.receptor = receptor;
    }

    public void removeFinCuentaAtrasListener(FinCuentaAtrasListener receptor)
    {
        this.receptor=null;
    }
    }
