/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static Client.Client.frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author KirrNguyen
 */
public class KeyListen implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_R){
            frame.kpanel.m.reset();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}
