/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.time.LocalDateTime;

/**
 *
 * @author gonza
 */
public class Anomalia {

    private Estadia estadia;
    private LocalDateTime fecha;
    private String codigoError;

    public Anomalia(String codigoError) {
        this.codigoError = codigoError;
    }

    public Estadia getEstadia() {
        return estadia;
    }

    public void setEstadia(Estadia estadia) {
        this.estadia = estadia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }

    public Anomalia(Estadia estadia, LocalDateTime fecha, String codigoError) {
        this.estadia = estadia;
        this.fecha = fecha;
        this.codigoError = codigoError;
    }

}
