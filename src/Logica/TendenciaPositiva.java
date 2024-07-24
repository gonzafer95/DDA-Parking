/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author bruno
 */
public class TendenciaPositiva extends Tendencia {

    public TendenciaPositiva(String nombre) {
        super(nombre);
    }

    @Override
    public double AjustarFactorDemanda(Parking p, int ut) {
        double factordemanda = p.getDemanda();
        if (p.getCantOcupadas() < 0.33 * p.getCantOcupadas()) {
            factordemanda = Math.min(10, p.getDemanda() + 0.05 * ut);
        }
        if (p.getCantOcupadas() > 0.66 * p.getCantOcupadas()) {
            factordemanda = Math.min(10, p.getCantOcupadas() + 0.15 * ut);
        }
        if ((p.getCantOcupadas() >= 0.33 * p.getCantOcupadas()) && (p.getCantOcupadas() <= 0.66 * p.getCantOcupadas())) {
            factordemanda = Math.min(10, p.getCantOcupadas() + 0.1 * ut);
        }

        return factordemanda;
    }

    @Override
    public void verificarTendencia(Parking p) {
        int diferencia = p.getIngresos() - p.getEgresos();
        if (diferencia > 0.1 * p.getCapacidad()) {
            p.setTendencia(this);
        }

    }

}
