/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Excepciones.ListaPreciosExcepciones;
import Logica.Cochera;
import Logica.Tarifa;
import Observer.Observable;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Parking extends Observable {

    private String nombre;
    private String direccion;
    private ArrayList<Tarifa> tarifas;
    private ArrayList<Cochera> cocheras;//Posible map
    private ArrayList<Estadia> estadias;
    private double demanda;
    private Tendencia tendencia;
    private int capacidad;
    private int ingresos;
    private int egresos;

    public Parking(String nombre, String direccion, ArrayList<Tarifa> tarifas, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tarifas = crearTarifas(tarifas);
        this.cocheras = new ArrayList<Cochera>();
        this.estadias = new ArrayList<Estadia>();
        this.demanda = 1.0;
        this.tendencia = new TendenciaEstable("Estable");
        this.capacidad = capacidad;
    }

    public ArrayList<Estadia> getEstadias() {
        return estadias;
    }

    public int getIngresos() {
        return ingresos;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    public int getEgresos() {
        return egresos;
    }

    public void setEgresos(int egresos) {
        this.egresos = egresos;
    }

    public void setEstadias(ArrayList<Estadia> estadias) {
        this.estadias = estadias;
    }

    public double getDemanda() {
        return demanda;
    }

    public void setDemanda(double demanda) {
        this.demanda = demanda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Tarifa> getTarifas() {
        return tarifas;
    }

    public void setTarifas(ArrayList<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }

    public ArrayList<Cochera> getCocheras() {
        return cocheras;
    }

    public void setCocheras(ArrayList<Cochera> cocheras) {
        this.cocheras = cocheras;
    }

    public void agregarCochera(Cochera c) {

        if (c != null) {
            cocheras.add(c);
        }
    }

    public int getCantOcupadas() {
        return (int) cocheras.stream().filter(Cochera::isOcupada).count();
    }

    public int getCantLibres() {
        return (int) cocheras.stream().filter(cochera -> !cochera.isOcupada()).count();
    }

    public int getCantEstadias() {
        return estadias.size();
    }

    public double getSubtotalMultas() {
        return estadias.stream().mapToDouble(Estadia::getMultas).sum();
    }

    public double getSubtotal() {
        return estadias.stream().mapToDouble(Estadia::getPrecioFactura).sum();

    }

    public void agregarEstadia(Estadia e) {
        if (e != null) {
            estadias.add(e);
        }

    }

    public void avisarAnomalia(Estadia e) {
        this.avisar(Observable.Evento.INGRESAR_ANOMALIA, e);
    }

    public void avisarIngresoOEgreso() {
        Fachada.getInstancia().verificarTendencia(this);
        this.avisar(Observable.Evento.INGRESAR_EGRESAR_ESTADIA, this);
    }

    void aumentarIngreso() {
        this.ingresos++;
    }

    void aumentarEgreso() {
        this.egresos++;
    }

    public Tendencia getTendencia() {
        return tendencia;
    }

    public void setTendencia(Tendencia tendencia) {
        this.tendencia = tendencia;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void actualizarTarifa(int pos, double montoDouble, double promedio) throws ListaPreciosExcepciones {
        this.tarifas.get(pos).actualizarTarifa(montoDouble, promedio);
    }

    public ArrayList<Tarifa> crearTarifas(ArrayList<Tarifa> tarifas) {
        ArrayList<Tarifa> t = new ArrayList<>();
        for (Tarifa tarifa : tarifas) {
            t.add(tarifa.clone());
        }
        return t;
    }

    public int getCantDiscapacitados() {
        return (int) this.cocheras.stream().filter(cochera -> cochera.esDiscapacitado() && !cochera.isOcupada()).count();
    }

    public int getCantElectricos() {
        return (int) this.cocheras.stream().filter(cochera -> cochera.esElectrico() && !cochera.isOcupada()).count();
    }

    public int getCantEmpleados() {
        return (int) this.cocheras.stream().filter(cochera -> cochera.esEmpleado() && !cochera.isOcupada()).count();
    }

    public void AjustarFactorDemanda(Estadia e) {
        this.demanda = this.getTendencia().AjustarFactorDemanda(this, e.getUt().getUT());
    }

    public double actualizarPrecioBase(TipodeVehiculo tipodevehiculo) {
        Tarifa tarifa = tarifas.stream()
                .filter(t -> t.getTipodeVehiculo().getNombre().equals(tipodevehiculo.getNombre()))
                .findFirst().orElse(null);
        if (tarifa != null) {
            return tarifa.getPrecio();
        }
        return 0;
    }

    public void avisarCambioPrecio() {
        this.avisar(Observable.Evento.CAMBIO_PRECIO, this);
    }

}
