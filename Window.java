package com.pluralight;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    /**
    *Clasa tworząca okienko dla wizualizowania symulacji
     */
    public Window(){
            setBackground(Color.BLACK);
            setBounds(900, 0, 900, 900);
          setTitle("Solar system simualtion");
            setResizable(true);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

