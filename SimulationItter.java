/**
 * Glówna klasa.
 * @version 1.0
 * @author Arkadzi Zaleuski i Yan Machulski
 */
package com.pluralight;

import javax.swing.*;
import java.awt.event.*;

import static com.pluralight.Comet.OutofBounds;
import static com.pluralight.EnvironmentGenerator.list2D;
import static com.pluralight.EnvironmentGenerator.planetList;


public class SimulationItter {

    public Timer timer;


    public static void main(String[] args) throws Exception {
        SimulationItter sim = new SimulationItter();
        final long startTime = System.currentTimeMillis();
        Summary CurrentSummary = new Summary();

        Background background = new Background();

        EnvironmentGenerator world = new EnvironmentGenerator();

        Window window = new Window();

        StatusBar bar = new StatusBar(window);
        window.setVisible(true);

        for (int i = 0; i < list2D.length; i++) {

            window.add(list2D[i]);
            window.setVisible(true);
        }

        CurrentSummary.addString("Comet starting velocity: Vx = " + list2D[0].velocityX + ", Vy = " + list2D[0].velocityY + "\n");


        ActionListener action = new ActionListener() {
            Path path;
            /**
             * n - numer itteracji
             * k - punk trajekorji
             */
            int n = 0
             , k = 0;

            Calculator calc = new Calculator(world.planetList, list2D);

            @Override
            /**
             * Działanie, które zostaje wykonane przez jedną iterację timer'a.
             */
            public void actionPerformed(ActionEvent e) {
                    if (n % 10 == 0) {
                        path = new Path((int) list2D[0].x, (int) list2D[0].y);
                        k++;
                    }

                window.add(path);
                window.setVisible(true);
                n++;

                for (int i = 0; i < list2D.length; i++) {

                    list2D[i].velocityX += calc.getAccelerationX(i);
                    list2D[i].velocityY += calc.getAccelerationY(i);
                    list2D[i].x += list2D[i].velocityX * 0.004;
                    list2D[i].y += list2D[i].velocityY * 0.004;

                    window.add(new Path());
                }
                if (OutofBounds(list2D[0]) || ((System.currentTimeMillis() - startTime) / 1000)>90) {
                    sim.timer.stop();
                    CurrentSummary.addString("\n Final coordinates: \n");
                    for(int i = 0;i<planetList.length;i++) {
                        CurrentSummary.addString(((i + 1) + ") Planet's mass is " + planetList[i].getMass()+"  "));
                        CurrentSummary.addString(("Ox:" + list2D[i].x + " Oy: " + list2D[i].y + " \n "));
                    }
                    CurrentSummary.addString(bar.toString());

                    window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));


                    try {
                        Thread.sleep(3000);
                    } catch (Exception exc) {
                        System.out.println(exc.getMessage());
                    }
                } else {
                    window.repaint();
                }
                window.add(background);
                window.setVisible(true);
            }
        };

        /**
         * W tym momencie symulacja zostaje uruchomiona.
         */
        sim.timer = new Timer(1000 / 120, action);
        sim.timer.start();

        CurrentSummary.Generate();
        if (CurrentSummary != null)
            System.out.println("Summary was successfully generated at " + CurrentSummary.path);
    }

}

