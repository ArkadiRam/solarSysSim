package com.pluralight;

import java.io.File;
import java.io.FileOutputStream;
import static com.pluralight.EnvironmentGenerator.planetList;

public class Summary {
    /**
    *Klasa do generowania podsumowania przebiegu symulacji
    *
     **/
    File summary;
    FileOutputStream stream;
    String path = "C:\\Users\\Public\\SimulationSummary.doc";

    Summary(String filePath){
        this.path = filePath;
        try {
            new Summary();
        }catch(Exception e){System.out.println(e.getMessage());}

    }

    Summary() throws  java.io.IOException{
        boolean f = true;
        this.summary = new File(path);
        do {
            try {
                f=false;
                this.stream = new FileOutputStream(path);
            } catch (Exception e) {
                System.out.println("Please, close SimulationSummary.doc and read in any letter");
                System.in.read();
                f=true;
            }
        }while(f);
        return;
    }

    public void Generate() throws Exception{
        stream.write(("Simulation summary: \n Starting condition").getBytes());
        for(int i = 0;i<planetList.length;i++) {
            stream.write(((i + 1) + ") Planet's mass is " + planetList[i].getMass()+"  ").getBytes());
            stream.write(("Ox:" + planetList[i].pos[0] + " Oy: " + planetList[i].pos[1] + " \n ").getBytes());
        }
    }
    /**
     *   Metoda do zapisywania informacji do pliku
     */

    public void addString(String a) {
        try{
        stream.write(a.getBytes());}
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
