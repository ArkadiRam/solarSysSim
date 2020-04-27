
package com.pluralight;

import java.util.Scanner;

public class Parameters {
    double velX;
    double velY;

    public void set(){
        Scanner stream = new Scanner(System.in);
        boolean f = true;
        do {
            System.out.println("Type velocity's Ox axis component"); //Ustawienie prędkości przez użytownika
            this.velX = stream.nextInt();
            System.out.println("Type velocity's Oy axis component");
            this.velY = stream.nextInt();
            /**
             *Ograniczenie dla bardziej informacyjnego przebiegu symulacji. Zaduża prędkość nie będie miała czas się zmienic,
             *Natomiast z ujęmną prędkością kometa wylecia poza granicy ekranu i symulacja się skończy
             */
            if(velX <120 && velY<120 && velY >0 && velY>0){
                f=false;
            }
            else System.out.println("Velocity is too high, trajectory wan't change much");
        }while(f);
    }
}
