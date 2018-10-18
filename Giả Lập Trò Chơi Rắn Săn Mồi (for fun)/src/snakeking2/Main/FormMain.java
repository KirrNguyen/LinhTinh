/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeking2.Main;

import snakeking2.SnakeGame.KeyListen;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author KirrNguyen
 */

public class FormMain extends JFrame implements KeyListener{
    
    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 500;
    int SIZE_WIDTH;
    int SIZE_HEIGHT;
    KeyListen keylistener = new KeyListen();
    MainPanel panelmain;
    
    public FormMain(){
        getSizeWindow();
        setBounds((SIZE_WIDTH - SCREEN_WIDTH)/2, (SIZE_HEIGHT - SCREEN_HEIGHT)/2,
                    SCREEN_WIDTH, SCREEN_HEIGHT);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        
        panelmain = new MainPanel();
        add(panelmain);

    }
    public void getSizeWindow(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit tk = this.getToolkit(); 
        Dimension dm = tk.getScreenSize();
        SIZE_WIDTH = dm.width;
        SIZE_HEIGHT = dm.height;
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        keylistener.KeyInputPress(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
