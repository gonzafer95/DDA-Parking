/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Logica.Estadia;
import Logica.Fachada;
import Logica.Parking;
import Observer.Observable;
import Observer.Observador;
import UI.CarteleraElectronica;
import UI.ListaDePrecios;
import UI.VistaTableroDeControl;
import java.util.ArrayList;

/**
 *
 * @author gonza
 */
public class ControladorTableroDeControl implements Observador {
  private  VistaTableroDeControl vista;
  private Fachada fachada;
  private ArrayList<Estadia> estadias = new ArrayList<>();
  private ArrayList<Parking> parkings = new ArrayList<>();
   
    public ControladorTableroDeControl(VistaTableroDeControl vista){
       this.fachada = Fachada.getInstancia();
       this.vista=vista;
       this.parkings= fachada.getParkings();
       agregarObservadorParkings();
       inicializarVista();
    }
    public void inicializarVista(){
        
        obtenerEstadias();
        obtenerTotalFacturado();
        obtenerparkings();
        obtenerEstadiasAnomalas();

    }
    public void agregarObservadorParkings(){
        for (Parking p : parkings) {
            p.agregar(this);
        }
    }
    public void obtenerEstadias(){
      this.vista.actualizarlblEstadias(fachada.obtenerCantEstadias());

    }
    public void obtenerTotalFacturado(){
          this.vista.actualizarlblFacturacion(fachada.obtenerTotalFacturado());

    }
     public void obtenerparkings(){
          this.vista.actualizarTablaParking(parkings);
    }
    public void obtenerEstadiasAnomalas(){
        this.vista.actualizarTablaAnomalias(estadias);
    }
     public boolean estadoCheckbox(){
        return this.vista.estadoCheckbox();
    }

    @Override
    public void actualizar(Object evento, Object origen) {
        if(((Observable.Evento) evento).equals(Observable.Evento.INGRESAR_ANOMALIA)){
           
            if(estadoCheckbox()){estadias.add((Estadia) origen);
            obtenerEstadiasAnomalas();}
        }
        if(((Observable.Evento) evento).equals(Observable.Evento.INGRESAR_EGRESAR_ESTADIA)) {
            inicializarVista();
        }
    }

    public void vistaPrecios(int posparking) {
        Parking p =parkings.get(posparking);
        new ListaDePrecios(p).setVisible(true);
    }
    public void vistaCartelera(int posparking) {
        Parking p =parkings.get(posparking);
        new CarteleraElectronica(p).setVisible(true);
    }
    
}
