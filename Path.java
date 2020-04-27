package com.pluralight;

import javax.swing.*;
import java.awt.*;

public class Path extends JComponent  {
    private Planet2D planet;
    private int x;
    private int y;

    public Path(int x,int y){
        this.x =x;
        this.y=y;
        repaint();
    }
    public Path(){
        repaint();
    }

    public void  paint(Graphics a){
        Graphics2D DC = (Graphics2D) a;
        DC.setColor(Color.RED);
        DC.fillOval(x,y,3,3);
    }
}
