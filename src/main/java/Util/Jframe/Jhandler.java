package Util.Jframe;

import java.awt.Color;

import javax.swing.JFrame;

import Util.Planet;

@SuppressWarnings("serial")
public class Jhandler extends JFrame{
    private int gameWIDTH = 700, gameHEIGHT = 700;
    private Panel panel;
    
    public Jhandler(Planet[] p){
        setSize(gameWIDTH, gameHEIGHT);
        setTitle("Ping Pong");
        setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new Panel(p);
        add(panel);
    }

    public Panel getPanel(){
        return panel;
    }
    
   
}