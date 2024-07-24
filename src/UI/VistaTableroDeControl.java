/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package UI;

import Logica.Estadia;
import Logica.Parking;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public interface VistaTableroDeControl {

    public void actualizarlblEstadias(int cantEstadias);

    public void actualizarlblFacturacion(double totalFacturado);

    public void actualizarTablaParking(ArrayList<Parking> parkings);

    public void actualizarTablaAnomalias(ArrayList<Estadia> estadias);

    public boolean estadoCheckbox();

}
