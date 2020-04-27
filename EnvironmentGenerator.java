package com.pluralight;


public class EnvironmentGenerator{
/**
    *Klasa do tworzenia układu planet.
 * Najpierw generujemy komietę i ustawiamy jej parametry.
 * Następnie generujemy planety o losowych współrzędnych
 */
    protected static Planet2D list2D[] = new Planet2D[10];
    protected static Planet planetList[] = new Planet[10];

    public EnvironmentGenerator() {
        Parameters opt = new Parameters();
        opt.set();

        Comet comet = new Comet(10, 3E10);
        planetList[0] = comet;
        list2D[0] = new Planet2D((int) planetList[0].getRadius());
        list2D[0].velocityX = opt.velX;
        list2D[0].velocityY = opt.velY;
        list2D[0].setPos(planetList[0].pos[0], planetList[0].pos[1]);



        for (int i = 1; i < list2D.length; i++) {
            planetList[i] = new Planet();
            list2D[i] = new Planet2D((int) planetList[i].getRadius());
            list2D[i].setPos(planetList[i].pos[0], planetList[i].pos[1]);
        }
        for (int i = 0; i < list2D.length; i++)
        {
            System.out.println(i + 1 + ") Planet's mass is " + planetList[i].getMass());
            System.out.println("Ox:" + planetList[i].pos[0] + " Oy: " + planetList[i].pos[1]);
        }
    }

}