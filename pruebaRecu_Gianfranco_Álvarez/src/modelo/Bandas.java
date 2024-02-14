/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author gianf
 */
public class Bandas {
    private String nombreBanda;
    private String nombreSala;
    private String estilo;
    private Date fechaForm;
    private float cache;

    public Bandas(String nombreBanda, String nombreSala, String estilo, Date fechaForm, float cache) {
        this.nombreBanda = nombreBanda;
        this.nombreSala = nombreSala;
        this.estilo = estilo;
        this.fechaForm = fechaForm;
        this.cache = cache;
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Date getFechaForm() {
        return fechaForm;
    }

    public void setFechaForm(Date fechaForm) {
        this.fechaForm = fechaForm;
    }

    public float getCache() {
        return cache;
    }

    public void setCache(float cache) {
        this.cache = cache;
    }
    
}
