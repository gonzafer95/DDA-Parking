/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author bruno
 */
public abstract class Observable {

    public Collection<Observador> observadores = new ArrayList<>();

    public enum Evento {
        INGRESAR_ANOMALIA,
        INGRESAR_EGRESAR_ESTADIA,
        CAMBIO_PRECIO
    }

    public void agregar(Observador observador) {
        observadores.add(observador);
    }

    public boolean quitar(Observador observador) {
        return observadores.remove(observador);
    }

    protected void avisar(Object evento, Object origen) {
        for (Observador o : observadores) {
            o.actualizar(evento, origen);
        }
    }

}
