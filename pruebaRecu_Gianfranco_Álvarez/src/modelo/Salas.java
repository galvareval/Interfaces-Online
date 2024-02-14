/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author gianf
 */
public class Salas {
    private String nombreSala;
    private int Aforo;
    private float precio;
    private String localidad;

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public int getAforo() {
        return Aforo;
    }

    public void setAforo(int Aforo) {
        this.Aforo = Aforo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Salas(String nombreSala, int Aforo, float precio, String localidad) {
        this.nombreSala = nombreSala;
        this.Aforo = Aforo;
        this.precio = precio;
        this.localidad = localidad;
    }
    
    
}
