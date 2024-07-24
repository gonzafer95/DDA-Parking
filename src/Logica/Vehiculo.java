/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import simuladortransito.Transitable;

/**
 *
 * @author gonza
 */
public class Vehiculo implements Transitable {

    private String patente;
    private TipodeVehiculo tipodevehiculo;
    private ArrayList<Etiqueta> etiquetas;
    private Propietario propietario;
    private boolean estacionado;

    public Vehiculo(String patente, TipodeVehiculo tipodevehiculo, Propietario propietario) {
        this.patente = patente;
        this.tipodevehiculo = tipodevehiculo;
        this.etiquetas = new ArrayList<Etiqueta>();
        this.propietario = propietario;
        this.estacionado = false;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public TipodeVehiculo getTipodevehiculo() {
        return tipodevehiculo;
    }

    public void setTipodevehiculo(TipodeVehiculo tipodevehiculo) {
        this.tipodevehiculo = tipodevehiculo;
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public boolean isEstacionado() {
        return estacionado;
    }

    public void setEstacionado(boolean estacionado) {
        this.estacionado = estacionado;
    }

    public void agregarEtiqueta(Etiqueta e) {
        this.etiquetas.add(e);
    }

    @Override
    public boolean esDiscapacitado() {
        for (Etiqueta etiqueta : etiquetas) {
            if (etiqueta.getNombre().equalsIgnoreCase("Discapacitado")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean esElectrico() {
        for (Etiqueta etiqueta : etiquetas) {
            if (etiqueta.getNombre().equalsIgnoreCase("Eléctrico")) {
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean esEmpleado() {
        for (Etiqueta etiqueta : etiquetas) {
            if (etiqueta.getNombre().equalsIgnoreCase("Empleado")) {
                return true;
            }
        }
        return false;

    }

    @Override
    public String toString() {
        return "V" + patente + " - Tipo: " + tipodevehiculo.getNombre() + " Estacionado: " + (estacionado ? "SI" : "NO") + " - " + cargarEtiquetas();
    }

    public String cargarEtiquetas() {
        String res = "";
        for (Etiqueta e : etiquetas) {
            res += e.getNombre();
        }
        return res;
    }

}
