/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package UI;

import Logica.Parking;
import Logica.Tarifa;
import java.util.ArrayList;

/**
 *
 * @author gonza
 */
public interface VistaCarteleraElectronica {

    public void nombreParking(String nombre);

    public void ActualizarTabla(ArrayList<Tarifa> tarifas);

    public void ActualizarTabla2(Parking p);

    public void disponibilidadParking(int cantidad);
}
