/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author gonza
 */
public class EtiquetaElectrico extends Etiqueta {

    public EtiquetaElectrico(String nombre) {
        super(nombre);
    }

    @Override
    public Double calculoMulta(double precioBase, double ut) {
        return precioBase * 0.5;
    }

}
