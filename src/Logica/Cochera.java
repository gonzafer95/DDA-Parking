package Logica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Logica.Etiqueta;
import java.util.ArrayList;
import simuladortransito.Estacionable;

/**
 *
 * @author gonza
 */
public class Cochera implements Estacionable {

    private String codigo;
    private boolean ocupada;
    private ArrayList<Etiqueta> etiquetas;
    private Estadia ultimaEstadia;

    public Cochera(String codigo) {
        this.codigo = codigo;
        this.ocupada = false;
        this.etiquetas = new ArrayList<Etiqueta>();
    }

    public Estadia getUltimaEstadia() {
        return ultimaEstadia;
    }

    public void setUltimaEstadia(Estadia ultimaEstadia) {
        this.ultimaEstadia = ultimaEstadia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
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
        return "C" + codigo + " - Ocupada: " + (ocupada ? "SI" : "NO") + " - " + cargarEtiquetas();
    }

    public String cargarEtiquetas() {
        String res = "";
        for (Etiqueta e : etiquetas) {
            res += e.getNombre();
        }
        return res;
    }
}
