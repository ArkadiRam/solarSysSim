/**
 * Clasa, objekt której jest rysowany na backgroundzie
 */
package com.pluralight;

import javax.swing.*;
import java.awt.*;

public class Background extends JComponent {


    public Background(){
        repaint();
    }

    public void  paint(Graphics a){
        Graphics2D background = (Graphics2D)a;
        background.setColor(Color.BLACK);
        background.fillRect(0,0,900,900);
    }
}
