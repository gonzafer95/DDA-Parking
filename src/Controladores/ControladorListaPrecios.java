/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Excepciones.ListaPreciosExcepciones;
import Logica.Fachada;
import Logica.Parking;
import UI.VistaListaPrecios;

/**
 *
 * @author bruno
 */
public class ControladorListaPrecios {
    private VistaListaPrecios vista;
    private Parking p;
    private Fachada f;
    
       
    public ControladorListaPrecios(VistaListaPrecios vista,Parking p){
         this.vista=vista;
         this.p=p;
         this.f=Fachada.getInstancia();
         inicializarVista();
        }
     public void inicializarVista(){
        nombreParking();
        ActualizarTabla();
       }
     public void nombreParking(){
     this.vista.nombreParking(p.getNombre());
     }
     public void ActualizarTabla(){
     this.vista.ActualizarTabla(p.getTarifas());
     }

 public void actualizarDatos(int pos, double montoDouble)throws ListaPreciosExcepciones {
    try {
        double promedioTipo=f.calcularPromedioTarifa(pos); 
        p.actualizarTarifa(pos, montoDouble,promedioTipo);
        ActualizarTabla();
        p.avisarCambioPrecio();
    } catch (ListaPreciosExcepciones ex) {
        this.vista.ManejoErrores(ex.getMessage());
    }
}
    
}
