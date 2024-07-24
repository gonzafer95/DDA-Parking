/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author gonza
 */
public class EtiquetaDiscapacitado extends Etiqueta {

    public EtiquetaDiscapacitado(String nombre) {
        super(nombre);
    }

    @Override
    public Double calculoMulta(double precioBase, double ut) {
        return 250.0;
    }

}
