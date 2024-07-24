/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author bruno
 */
public class UT {

    private Timer timer;
    private int UT;

    public UT() {
        this.UT = 0;
    }

    public int getUT() {
        return UT;
    }

    public void iniciar() {
        if (timer == null) {
            timer = new Timer(true);
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    UT++;
                }
            }, 0, 1000);
        }
    }

    public void detener() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void reiniciar() {
        detener();
        this.UT = 0;
    }
}
