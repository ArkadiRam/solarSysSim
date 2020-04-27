package com.pluralight;

import javax.swing.*;
import java.awt.*;

public class Planet2D extends JComponent {
    public double x = 0;
    public double y = 0;
    private Color color = Color.BLACK;
    public double velocityY;
    public double velocityX;
    private int r = 0;


    public Planet2D(int r) {
        color = Color.getHSBColor((int) (Math.random() * 256 + 1), (int) (Math.random() * 256 + 1), (int) (Math.random() * 256 + 1));
        this.r = r;
        repaint();
    }
    public Planet2D(int x,int y ){
        this.x=x;
        this.y=y;
        repaint();
    }

    public void setPos(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public void paint(Graphics a) {

        Graphics2D g1 = (Graphics2D) a;
        g1.setColor(color);
        g1.fillOval((int)x, (int)y, r, r);

    }
    public void setColor(Color col){
        this.color = col;
    }
}
