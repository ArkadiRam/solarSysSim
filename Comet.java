package com.pluralight;

public class Comet extends Planet {
    public Comet(double radius, double mass) {
        super(radius, mass);
    }


    public static boolean OutofBounds(Planet2D a){
        if(a.x > 900 || a.y > 900 || a.x < 0 || a.y < 0)
            return true;
        else return false;
    }
}