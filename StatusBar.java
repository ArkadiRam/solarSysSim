package com.pluralight;

import javax.swing.*;
import java.awt.*;

import static com.pluralight.EnvironmentGenerator.list2D;

public class StatusBar extends JComponent {
    /**
     * Płyta zawierająca dane o przebiegu symulacji takie jat czas, prędkość komiety.
     */
    private final long startTime = System.currentTimeMillis();
    /**
     *przypisujemy czas startu symulacji
     */
     public StatusBar(Window window) {
        repaint();
        window.add(this);
    }

    @Override
    public void paint(Graphics a) {
        Graphics2D b = (Graphics2D) a;
        b.setColor(Color.magenta);
        b.drawString("Comet  trajectory  tracking         " + "Time:  " + ((System.currentTimeMillis() - startTime) / 1000), 24, 15);
        b.drawString("Comet's velocity is " + (int) Math.sqrt(Math.pow(list2D[0].velocityX, 2) + Math.pow(list2D[0].velocityY, 2)) / 2 + " km/s", 24, 30);
    }

    @Override
    public String toString() { /**
     * Used specifically to write down system's current condition from StatusBar
     */
        String a = "Simulation finished after " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds.\n";
        String b = "Comet left the bounds with v = " + (int) Math.sqrt(Math.pow(list2D[0].velocityX, 2) + Math.pow(list2D[0].velocityY, 2)) / 2 + " km/s";
        return a + b;
    }
}
