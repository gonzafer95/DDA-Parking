/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author gonza
 */
public class EtiquetaEmpleado extends Etiqueta {

    public EtiquetaEmpleado(String nombre) {
        super(nombre);
    }

    @Override
    public Double calculoMulta(double precioBase, double ut) {
        return (ut / 10) * 1;
    }

}
