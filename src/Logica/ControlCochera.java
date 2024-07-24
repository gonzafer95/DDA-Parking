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
public class ControlCochera {

    private ArrayList<Cochera> cocheras = new ArrayList<>();

    public void agregar(Cochera cochera) {
        cocheras.add(cochera);
    }

    public ArrayList<Cochera> getCocheras() {
        return cocheras;
    }

}
