/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatoriodiseño;

import Logica.Vehiculo;
import Logica.Propietario;
import Logica.TipodeVehiculo;
import Logica.Fachada;
import Logica.Cochera;
import Logica.Etiqueta;
import Logica.EtiquetaDiscapacitado;
import Logica.EtiquetaElectrico;
import Logica.EtiquetaEmpleado;
import Logica.Parking;
import Logica.Tarifa;
import Logica.Tendencia;
import Logica.TendenciaEstable;
import Logica.TendenciaNegativa;
import Logica.TendenciaPositiva;
import java.util.ArrayList;
import java.util.Random;
import simuladortransito.Estacionable;
import simuladortransito.Transitable;

/**
 *
 * @author bruno
 */
public class DatosDePrueba {

    private static final Random random = new Random();
    private static final Fachada fachada = Fachada.getInstancia();

    public static void cargar() {
        cargarTarifas();
        cargarCocherasYParkings();
        cargarTendencias();
        cargarPropietariosYVehiculos();
    }

    private static void cargarTarifas() {
        TipodeVehiculo tipoVehiculo1 = new TipodeVehiculo("Motocicleta");
        TipodeVehiculo tipoVehiculo2 = new TipodeVehiculo("Carga");
        TipodeVehiculo tipoVehiculo3 = new TipodeVehiculo("Standar");
        TipodeVehiculo tipoVehiculo4 = new TipodeVehiculo("Pasajeros");

        Tarifa tarifaMoto = new Tarifa(0.05, tipoVehiculo1);
        Tarifa tarifaGeneral = new Tarifa(0.1, tipoVehiculo2);
        Tarifa tarifaStandar = new Tarifa(0.1, tipoVehiculo3);
        Tarifa tarifaPasajeros = new Tarifa(0.1, tipoVehiculo4);

        fachada.agregarTarifa(tarifaMoto);
        fachada.agregarTarifa(tarifaGeneral);
        fachada.agregarTarifa(tarifaStandar);
        fachada.agregarTarifa(tarifaPasajeros);
    }

    private static void cargarCocherasYParkings() {
        Parking parkingCentro = new Parking("Parking Centro", "Calle Mayor 1", fachada.getTarifas(), 100);
        Parking parkingNorte = new Parking("Parking Norte", "Avenida de la Paz 123", fachada.getTarifas(), 100);

        for (int i = 0; i < 100; i++) {
            Cochera cocheraCentro = new Cochera(String.valueOf(i + 1));
            Cochera cocheraNorte = new Cochera(String.valueOf(i + 101));

            asignarEtiquetasAleatorias(cocheraCentro);
            asignarEtiquetasAleatorias(cocheraNorte);

            fachada.agregarCochera(cocheraCentro);
            fachada.agregarCochera(cocheraNorte);

            parkingCentro.agregarCochera(cocheraCentro);
            parkingNorte.agregarCochera(cocheraNorte);
        }

        fachada.agregarParking(parkingCentro);
        fachada.agregarParking(parkingNorte);
    }

    private static void asignarEtiquetasAleatorias(Cochera cochera) {
        Etiqueta etiquetaDiscapacitado = new EtiquetaDiscapacitado("Discapacitado");
        Etiqueta etiquetaElectrico = new EtiquetaElectrico("Eléctrico");
        Etiqueta etiquetaEmpleado = new EtiquetaEmpleado("Empleado");

        if (random.nextDouble() < 0.2) {
            switch (random.nextInt(3)) {
                case 0:
                    cochera.agregarEtiqueta(etiquetaDiscapacitado);
                    break;
                case 1:
                    cochera.agregarEtiqueta(etiquetaElectrico);
                    break;
                case 2:
                    cochera.agregarEtiqueta(etiquetaEmpleado);
                    break;
            }
        }
    }

    private static void cargarTendencias() {
        Tendencia tendenciaEstable = new TendenciaEstable("Estable");
        Tendencia tendenciaPositiva = new TendenciaPositiva("Positiva");
        Tendencia tendenciaNegativa = new TendenciaNegativa("Negativa");

        fachada.agregarTendencia(tendenciaEstable);
        fachada.agregarTendencia(tendenciaPositiva);
        fachada.agregarTendencia(tendenciaNegativa);
    }

    private static void cargarPropietariosYVehiculos() {
        for (int i = 0; i < 50; i++) {
            String nombre = "Propietario " + (i + 1);
            String cedula = String.valueOf(1000 + i);
            double saldo = random.nextDouble() * 110 - 10;
            Propietario propietario = new Propietario(nombre, cedula, saldo);

            for (int j = 0; j < 4; j++) {
                TipodeVehiculo tipoVehiculo;
                switch (j) {
                    case 0:
                        tipoVehiculo = new TipodeVehiculo("Motocicleta");
                        break;
                    case 1:
                        tipoVehiculo = new TipodeVehiculo("Carga");
                        break;
                    case 2:
                        tipoVehiculo = new TipodeVehiculo("Standard");
                        break;
                    case 3:
                        tipoVehiculo = new TipodeVehiculo("Pasajeros");
                        break;
                    default:
                        tipoVehiculo = new TipodeVehiculo("Motocicleta");
                        break;
                }
                Vehiculo vehiculo = new Vehiculo(String.valueOf(i * 10 + j), tipoVehiculo, propietario);
                asignarEtiquetasAleatorias(vehiculo);
                fachada.agregarVehiculo(vehiculo);
            }
        }
    }

    private static void asignarEtiquetasAleatorias(Vehiculo vehiculo) {
        if (random.nextDouble() < 0.2) {
            switch (random.nextInt(3)) {
                case 0:
                    vehiculo.agregarEtiqueta(new EtiquetaDiscapacitado("Discapacitado"));
                    break;
                case 1:
                    vehiculo.agregarEtiqueta(new EtiquetaElectrico("Eléctrico"));
                    break;
                case 2:
                    vehiculo.agregarEtiqueta(new EtiquetaEmpleado("Empleado"));
                    break;
            }
        }
    }

    public static ArrayList<Estacionable> getCocheras(int cuantos) {
        ArrayList<Estacionable> lista = new ArrayList<>();
        ArrayList<Cochera> cocheras = fachada.getCocheras();

        for (int x = 0; x < cuantos; x++) {
            lista.add(cocheras.get(x));
        }

        return lista;
    }

    public static ArrayList<Transitable> getVehiculos(int cuantos) {
        ArrayList<Transitable> lista = new ArrayList<>();
        ArrayList<Vehiculo> vehiculos = fachada.getVehiculos();

        for (int x = 0; x < cuantos; x++) {
            lista.add(vehiculos.get(x));
        }

        return lista;
    }
}
