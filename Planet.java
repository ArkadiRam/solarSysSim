package com.pluralight;

public class Planet extends AbstractCosmicObj {

    public Planet(double radius, double mass) {
        this.radius = radius;
        this.mass = mass;
        this.pos[0] =10;
        this.pos[1] =20 ;
    }

    public Planet()  {

        this.mass = (int) (Math.random() * 19 + 9);
        this.radius = (int)(1.5*mass);
        this.mass*=Math.pow(10,12);
        this.pos[0] = (int) (Math.random() * 600 + 120);
        this.pos[1] = (int) (Math.random() * 600 + 120);
    }

}
