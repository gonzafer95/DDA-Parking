/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class ControlEstadia {

    private ArrayList<Estadia> estadias = new ArrayList<>();
    private ArrayList<Anomalia> anomalias = new ArrayList<>();

    public void agregar(Estadia estadia) {
        estadias.add(estadia);
    }

    public ArrayList<Estadia> getEstadias() {
        return estadias;
    }

    public void actualizarEstadia(Estadia estadiaAnterior) {

        for (int i = 0; i < estadias.size(); i++) {
            Estadia estadia = estadias.get(i);
            if (estadia.getCochera().equals(estadiaAnterior.getCochera()) && estadia.getVehiculo().equals(estadiaAnterior.getVehiculo()) && estadia.getFechaEntrada().equals(estadiaAnterior.getFechaEntrada())) {
                estadias.set(i, estadiaAnterior);
                break;
            }
        }

    }

    public int obtenerCantEstadias() {
        return estadias.size();
    }

    public double obtenerTotalFacturado() {

        return estadias.stream().mapToDouble(Estadia::getPrecioFactura).sum();

    }

}
