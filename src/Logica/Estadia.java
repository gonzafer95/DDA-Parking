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
public class Estadia {

    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private Cochera cochera;
    private double precioFactura;
    private double multas;
    private Anomalia anomalia;
    private Vehiculo vehiculo;
    private UT ut;
    private double factorDemanda;
    private double precioBase;

    public Estadia(LocalDateTime fechaEntrada, Cochera cochera, Vehiculo vehiculo) {
        this.fechaEntrada = fechaEntrada;
        this.cochera = cochera;
        this.vehiculo = vehiculo;
        this.multas = 0;
        this.anomalia = null;
        this.ut = new UT();
        this.ut.iniciar();
        precioBase();
        verificarmultas();
    }

    public double getFactorDemanda() {
        return factorDemanda;
    }

    public void setFactorDemanda(double factorDemanda) {
        this.factorDemanda = factorDemanda;
    }

    public double getMultas() {
        return multas;
    }

    public void setMultas(double multas) {
        this.multas = multas;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Anomalia getAnomalia() {
        return anomalia;
    }

    public void setAnomalia(Anomalia anomalia) {
        this.anomalia = anomalia;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Cochera getCochera() {
        return cochera;
    }

    public void setCochera(Cochera cochera) {
        this.cochera = cochera;
    }

    public double getPrecioFactura() {
        return precioFactura;
    }

    public void setPrecioFactura(double precioFactura) {
        this.precioFactura = precioFactura;
    }

    public void precioBase() {
        Parking p = Fachada.getInstancia().obtenerParking(cochera);
        this.precioBase = p.actualizarPrecioBase(this.vehiculo.getTipodevehiculo());
    }

    public void cerrarPrecio() {
        this.precioFactura = (this.precioBase * this.ut.getUT() * this.factorDemanda) + this.multas;
    }

    public void AjusatarFactorDemanda(Parking p) {
        this.factorDemanda = p.getTendencia().AjustarFactorDemanda(p, this.ut.getUT());
    }

    public void verificarmultas() {
        if (this.cochera.getEtiquetas().equals(vehiculo.getEtiquetas())) {

            this.multas = 0;
        } else if (this.cochera.esDiscapacitado() && !this.vehiculo.esDiscapacitado()) {
            this.multas = new EtiquetaDiscapacitado("Discapacitado").calculoMulta(0, 0);

        } else if (this.cochera.esElectrico() && !this.vehiculo.esElectrico()) {
            this.multas = new EtiquetaElectrico("Electrico").calculoMulta(this.precioBase, 0);

        } else if (this.cochera.esEmpleado() && !this.vehiculo.esEmpleado()) {
            double aux = ut.getUT();

            this.multas = new EtiquetaEmpleado("Empleado").calculoMulta(this.precioBase, aux);
        }
    }

    void detenerTiempo() {
        this.ut.detener();
    }

    public UT getUt() {
        return ut;
    }

    public void setUt(UT ut) {
        this.ut = ut;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

}
