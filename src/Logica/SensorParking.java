/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import simuladortransito.Estacionable;
import simuladortransito.Sensor;
import simuladortransito.Transitable;
import java.time.LocalDateTime;

/**
 *
 * @author gonza
 */
public class SensorParking implements Sensor {

    private Fachada fachada;

    public SensorParking() {
        this.fachada = Fachada.getInstancia();
    }

    @Override
    public void ingreso(Transitable transitable, Estacionable estacionable) {
        Vehiculo v = (Vehiculo) transitable;
        Cochera c = (Cochera) estacionable;
        LocalDateTime fecha = LocalDateTime.now();
        Parking p = fachada.obtenerParking(c);

        //posible refactor de resolver dentro de parking
        manejarEstadiaAnterior(c, fachada, p);

        Estadia nuevaEstadia = new Estadia(fecha, c, v);
        if (p != null) {
            p.agregarEstadia(nuevaEstadia);
        }

        fachada.agregarEstadia(nuevaEstadia);
        c.setUltimaEstadia(nuevaEstadia);
        v.setEstacionado(true);
        c.setOcupada(true);
        p.avisarIngresoOEgreso();
        p.aumentarIngreso();
    }

    private void manejarEstadiaAnterior(Cochera c, Fachada f, Parking p) {
        if (c.isOcupada()) {
            Estadia estadiaAnterior = c.getUltimaEstadia();
            if (estadiaAnterior != null) {
                estadiaAnterior.setFechaSalida(null);
                estadiaAnterior.setPrecioFactura(0);
                Anomalia anomalia = new Anomalia("HOUDINI");
                estadiaAnterior.setAnomalia(anomalia);
                f.actualizarEstadia(estadiaAnterior);
                p.avisarAnomalia(estadiaAnterior);
            }
        }
    }

    @Override
    public void egreso(Transitable transitable, Estacionable estacionable) {
        Vehiculo v = (Vehiculo) transitable;
        Cochera c = (Cochera) estacionable;
        LocalDateTime fecha = LocalDateTime.now();
        Estadia e = c.getUltimaEstadia();
        Parking p = fachada.obtenerParking(c);

        if (!c.isOcupada()) {
            manejarAnomalia(c, v, fecha, fachada, p);
        } else if (!e.getVehiculo().getPatente().equals(v.getPatente())) {
            manejarAnomaliaTransportador(c, v, fecha, e, fachada, p);
        } else {
            e.AjusatarFactorDemanda(p);
            p.AjustarFactorDemanda(e);
            procesarEgreso(v, c, e, fachada);
            p.avisarIngresoOEgreso();
            p.aumentarIngreso();

        }
    }

    private void manejarAnomalia(Cochera c, Vehiculo v, LocalDateTime fecha, Fachada f, Parking p) {
        Estadia nuevaEstadia = new Estadia(fecha, c, v);
        nuevaEstadia.setFechaSalida(fecha);
        Anomalia anomalia = new Anomalia("MISTERY");
        nuevaEstadia.setAnomalia(anomalia);
        f.agregarEstadia(nuevaEstadia);
        p.avisarAnomalia(nuevaEstadia);
    }

    private void manejarAnomaliaTransportador(Cochera c, Vehiculo v, LocalDateTime fecha, Estadia e, Fachada f, Parking p) {
        Anomalia anomalia1 = new Anomalia("TRANSPORTADOR1");
        e.setPrecioFactura(0);
        e.setAnomalia(anomalia1);
        f.actualizarEstadia(e);

        Estadia nuevaEstadia = new Estadia(fecha, c, v);
        nuevaEstadia.setFechaSalida(fecha);
        nuevaEstadia.setPrecioFactura(0);
        Anomalia anomalia2 = new Anomalia("TRANSPORTADOR2");
        nuevaEstadia.setAnomalia(anomalia2);
        f.agregarEstadia(nuevaEstadia);
        p.avisarAnomalia(nuevaEstadia);
    }

    private void procesarEgreso(Vehiculo v, Cochera c, Estadia e, Fachada f) {
        Propietario p = v.getPropietario();
        e.detenerTiempo();
        e.cerrarPrecio();
        double saldo = p.getSaldo();
        double monto = e.getPrecioFactura();
        p.setSaldo(saldo - monto);
        v.setEstacionado(false);
        c.setOcupada(false);

    }

}
