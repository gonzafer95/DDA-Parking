/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Excepciones.ListaPreciosExcepciones;

/**
 *
 * @author gonza
 */
public class Tarifa implements Cloneable {

    public double precio;
    public TipodeVehiculo tipodeVehiculo;

    public Tarifa(double precio, TipodeVehiculo tipodeVehiculo) {
        this.precio = precio;
        this.tipodeVehiculo = tipodeVehiculo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipodeVehiculo getTipodeVehiculo() {
        return tipodeVehiculo;
    }

    public void setTipodeVehiculo(TipodeVehiculo tipodeVehiculo) {
        this.tipodeVehiculo = tipodeVehiculo;
    }

    public void actualizarTarifa(double montoDouble, double promedio) throws ListaPreciosExcepciones {
        if (montoDouble < 0) {

            throw new ListaPreciosExcepciones("Valor inválido. El precio debe ser igual o mayor a cero.");
        }
        if (montoDouble >= 2 * promedio) {
            throw new ListaPreciosExcepciones("Valor demasiado alto. El sistema no permite dispersión de precios por encima del 100%. Ingrese un valor menor a " + (2 * promedio) + ".");
        }

        this.precio = montoDouble;
    }

    @Override
    public Tarifa clone() {
        try {
            return (Tarifa) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
