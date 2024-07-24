/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author bruno
 */
public class TendenciaNegativa extends Tendencia {

    public TendenciaNegativa(String nombre) {
        super(nombre);
    }

    @Override
    public double AjustarFactorDemanda(Parking p, int ut) {
        double factorDemanda;

        if (p.getDemanda() > 1) {
            factorDemanda = 1;
        } else {
            factorDemanda = Math.max(0.25, p.getDemanda() - 0.05 * ut);
        }

        return factorDemanda;
    }

    @Override
    public void verificarTendencia(Parking p) {
        int diferencia = p.getIngresos() - p.getEgresos();
        if (diferencia < 0) {
            if (diferencia <= 0.1 * p.getCapacidad()) {
                p.setTendencia(this);
            }
        }

    }

}
