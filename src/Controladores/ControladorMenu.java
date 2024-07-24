/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Logica.SensorParking;
import obligatoriodiseño.DatosDePrueba;
import UI.TableroDeControl;
import UI.VistaMenu;
import java.util.ArrayList;
import simuladortransito.Estacionable;
import simuladortransito.Transitable;
import simuladorIU.SimuladorIU;

/**
 *
 * @author bruno
 */
public class ControladorMenu {
      private VistaMenu vista; 
   
    public ControladorMenu(VistaMenu vista){
        this.vista = vista;
    }
    
    public void SimuladorUIdep(){
        SensorParking sensor= new SensorParking();
        ArrayList<Estacionable> cocheras = DatosDePrueba.getCocheras(100);
        ArrayList<Transitable> vehiculos = DatosDePrueba.getVehiculos(50);
        new SimuladorIU(null, false, sensor, cocheras, vehiculos).setVisible(true);

    }
      public void TableroDeControldep(){
        new TableroDeControl().setVisible(true);

    }
    
 
    
}
