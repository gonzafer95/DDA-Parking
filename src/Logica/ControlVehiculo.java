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
public class ControlVehiculo {

    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public void agregar(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

}
