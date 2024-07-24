/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Logica.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Fachada {

    private static final Fachada instancia = new Fachada();

    private ControlVehiculo controlVehiculo = new ControlVehiculo();
    private ControlCochera controlCochera = new ControlCochera();
    private ControlEstadia controlEstadia = new ControlEstadia();
    private ControlParking controlParking = new ControlParking();
    private ControlTendencia controlTendencia = new ControlTendencia();
    private ArrayList<Tarifa> tarifas = new ArrayList<>();

    public static Fachada getInstancia() {
        return instancia;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return controlVehiculo.getVehiculos();
    }

    public ArrayList<Cochera> getCocheras() {
        return controlCochera.getCocheras();
    }

    public void agregarCochera(Cochera cochera) {
        controlCochera.agregar(cochera);
    }

    public ArrayList<Tarifa> getTarifas() {
        return tarifas;
    }

    public void agregarTarifa(Tarifa tarifa) {
        tarifas.add(tarifa);
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        controlVehiculo.agregar(vehiculo);
    }

    public ArrayList<Estadia> getEstadias() {
        return controlEstadia.getEstadias();
    }

    public void agregarEstadia(Estadia estadia) {
        controlEstadia.agregar(estadia);
    }

    public void agregarTendencia(Tendencia tendencia) {
        controlTendencia.agregar(tendencia);
    }

    public ArrayList<Tendencia> getTendencias() {
        return controlTendencia.getTendencias();
    }

    void actualizarEstadia(Estadia estadiaAnterior) {
        controlEstadia.actualizarEstadia(estadiaAnterior);
    }

    public ArrayList<Parking> getParkings() {
        return controlParking.getParkings();
    }

    public void agregarParking(Parking parking) {
        controlParking.agregar(parking);
    }

    public int obtenerCantEstadias() {
        return controlEstadia.obtenerCantEstadias();
    }

    public double obtenerTotalFacturado() {
        return controlEstadia.obtenerTotalFacturado();
    }

    public Parking obtenerParking(Cochera c) {
        return controlParking.obtenerParking(c);
    }

    public void verificarTendencia(Parking p) {
        controlTendencia.verificarTendencia(p);
    }

    public double calcularPromedioTarifa(int pos) {
        return controlParking.calcularPromedioTarifa(pos);
    }

}
