package Util.Jframe;

import java.awt.Color;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Pong extends JFrame{
    private int gameWIDTH = 700, gameHEIGHT = 700;
    private PongPanel panel;
    
    public Pong(){
        setSize(gameWIDTH, gameHEIGHT);
        setTitle("Ping Pong");
        setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new PongPanel(this);
        add(panel);
    }

    public PongPanel getPanel(){
        return panel;
    }
    
   
}