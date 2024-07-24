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
public class Propietario {
   private String cedula;
   private String nombre;
   private ArrayList<Vehiculo> vehiculos;
   private double saldo;

    public Propietario(String nombre,String cedula, double saldo) {
        this.cedula=cedula;
        this.nombre = nombre;
        this.vehiculos=new ArrayList<>();
        this.saldo= saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double Saldo) {
        this.saldo = Saldo;
    }
    

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
