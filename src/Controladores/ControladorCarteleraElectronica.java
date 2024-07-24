/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Logica.Parking;
import Observer.Observable;
import Observer.Observador;
import UI.VistaCarteleraElectronica;

/**
 *
 * @author gonza
 */
public class ControladorCarteleraElectronica implements Observador{
    private VistaCarteleraElectronica vista;
    private Parking p;
    
    public ControladorCarteleraElectronica(VistaCarteleraElectronica vista,Parking p){
         this.vista=vista;
         this.p=p;
         agregarObservadorParkings();
         inicializarVista();
         
    }
    public void agregarObservadorParkings(){
        p.agregar(this);
    }
    public void inicializarVista(){
        nombreParking();
        ActualizarTabla();
        ActualizarTabla2();
        disponibilidadParking();
       }
     public void nombreParking(){
     this.vista.nombreParking(p.getNombre());
     }
     public void ActualizarTabla(){
     this.vista.ActualizarTabla(p.getTarifas());
     }
     public void ActualizarTabla2(){
     this.vista.ActualizarTabla2(p);
     }
     public void disponibilidadParking(){
     this.vista.disponibilidadParking(p.getCantLibres());
     }
    @Override
    public void actualizar(Object evento, Object origen) {
        if(((Observable.Evento) evento).equals(Observable.Evento.INGRESAR_EGRESAR_ESTADIA)) {
            inicializarVista();
        }
         if(((Observable.Evento) evento).equals(Observable.Evento.CAMBIO_PRECIO)) {
            inicializarVista();
        }
    }
}
