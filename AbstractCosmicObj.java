package com.pluralight;

public abstract class AbstractCosmicObj {
    final static double G = 6.6674 * Math.pow(10, -11);
    public int[] pos= {0,0};
    protected double radius;
    protected double mass;
    public double getMass() {
        return this.mass;
    }

    public double getRadius() {
        return radius;
    }

}
