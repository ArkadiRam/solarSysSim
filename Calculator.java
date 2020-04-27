package com.pluralight;

import static com.pluralight.AbstractCosmicObj.G;

public class Calculator
/**
 * Clasa do przeprowadzenia obliczeń, wyznaczających ruch ciał w symulacji.
 */
{
    private Planet2D list2D[] = new Planet2D[10];
    private Planet planetList[] = new Planet[10];

    public Calculator(Planet[] a, Planet2D[] b) {
        this.list2D = b;
        this.planetList = a;
    }


    private double getDistLength(int i, int n) {
        return Math.sqrt(Math.pow(list2D[i].x - list2D[n].x, 2) + Math.pow(list2D[i].y - list2D[n].y, 2));
    }

    private double getVersOx(int n, int i)
    /**
     * Metoda do bliczanie kierunku wektora przyspieszenia wzdłuż Ox
     */
    {

        return (list2D[n].x - list2D[i].x);
    }

    private double getVersOy(int n, int i)
    /**
     * Metoda do bliczanie kierunku wektora przyspieszenia wzdłuż Oy
     */
    {
        return (list2D[n].y - list2D[i].y);
    }



    public double getAccelerationX(int n)
    /**
     * Metoda do wartości przyspieszenia.
     * Obliczne jest przez sumowanie przyspieszeń dla planety n względem innych planet wzdłuż Ox
     */
    {
        double accel = 0;
        double d = 0;
        for (int i = 0; i < n; i++) {
            d = getDistLength(i, n);
            if (d - 15 < 0) {
                accel += 0;
            } else {
                accel +=  (planetList[i].getMass() * G * getVersOx(i, n) / Math.pow(d, 3));
            }
        }
        /**
         * pomijamy planetę n
         */
        for (int i = n + 1; i < planetList.length; i++) {
            d = getDistLength(i, n);
            if (d - 15 < 0) {
                accel += 0;
            } else {
                accel +=  (planetList[i].getMass() * G * getVersOx(i, n) / Math.pow(d, 3));
            }
        }
        return accel;
    }

    public double getAccelerationY(int n)
    /**
     * Metoda do wartości przyspieszenia.
     * Obliczne jest przez sumowanie przyspieszeń dla planety n względem innych planet wzdłuż Ox
     */{
        double accel = 0;
        double d = 0;
        for (int i = 0; i < n; i++) {
            d = getDistLength(i, n);
            if (d - 15 < 0) {
                accel += 0;
            } else {
                accel += (planetList[i].getMass() * G * getVersOy(i, n) / Math.pow(d, 3));
            }
        }
        /**
         * pomijamy planetę n
         */
        for (int i = n + 1; i < planetList.length; i++) {
            d = getDistLength(i, n);
            if (d - 15 < 0) {
                accel += 0;
            } else {
                accel += (planetList[i].getMass() * G * getVersOy(i, n) / Math.pow(d, 3));
            }
        }
        return accel;
    }

}
