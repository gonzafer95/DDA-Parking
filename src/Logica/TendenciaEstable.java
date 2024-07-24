/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author bruno
 */
public class TendenciaEstable extends Tendencia {

    public TendenciaEstable(String nombre) {
        super(nombre);
    }

    @Override
    public double AjustarFactorDemanda(Parking p, int ut) {
        return Math.max(0.25, p.getDemanda() - 0.01 * ut);
    }

    @Override
    public void verificarTendencia(Parking p) {
        int diferencia = Math.abs(p.getIngresos() - p.getEgresos());
        if (diferencia <= 0.1 * p.getCapacidad()) {
            p.setTendencia(this);
        }

    }

}
