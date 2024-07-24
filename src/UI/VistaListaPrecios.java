/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package UI;

import Logica.Tarifa;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public interface VistaListaPrecios {

    public void nombreParking(String nombre);

    public void ActualizarTabla(ArrayList<Tarifa> tarifas);

    public void ManejoErrores(String message);
}
