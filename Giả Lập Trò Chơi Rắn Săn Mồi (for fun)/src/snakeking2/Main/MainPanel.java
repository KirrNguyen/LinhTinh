/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeking2.Main;

import snakeking2.SnakeGame.GamePanel2;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import snakeking2.MenuPanel;

/**
 *
 * @author KirrNguyen
 */
public class MainPanel extends JPanel{
    
    public MainPanel(){
        setLayout(null);
        setBounds(0, 0, FormMain.SCREEN_WIDTH, FormMain.SCREEN_HEIGHT);
        
        addGamePanel2();
    }
    
    public void addGamePanel2(){
        try{
            removeAll();
        }catch(Exception ex){}
        GamePanel2 snakegame = new GamePanel2();
        snakegame.setBounds(0, 0, 800, 500);
        add(snakegame);
        repaint();
    }
    
    
    @Override
    public void paint(Graphics g){

    }
    
}
