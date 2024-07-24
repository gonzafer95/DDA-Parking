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
public class ControlTendencia {

    private ArrayList<Tendencia> tendencias = new ArrayList<>();

    public void agregar(Tendencia tendencia) {
        tendencias.add(tendencia);
    }

    public ArrayList<Tendencia> getTendencias() {
        return tendencias;
    }

    void verificarTendencia(Parking p) {
        for (Tendencia t : tendencias) {
            t.verificarTendencia(p);
        }
    }
}
