/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author bruno
 */
public class ControlParking {

    private ArrayList<Parking> parkings = new ArrayList<>();

    public void agregar(Parking parking) {
        parkings.add(parking);
    }

    public ArrayList<Parking> getParkings() {
        return parkings;
    }

    public Parking obtenerParking(Cochera c) {
        return parkings.stream().filter(parking -> parking.getCocheras().stream().anyMatch(cochera -> cochera.equals(c))).findFirst().orElse(null);
    }

    public double calcularPromedioTarifa(int pos) {
        List<Double> tarifasEnPos = parkings.stream()
                .map(parking -> {
                    List<Tarifa> tarifas = parking.getTarifas();

                    if (pos < tarifas.size()) {
                        return tarifas.get(pos).getPrecio();
                    } else {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        // Calcular el promedio
        return tarifasEnPos.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

}
