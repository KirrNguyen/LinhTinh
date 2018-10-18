/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamewalking;

import static gamewalking.KPanel.p;
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
    int demo = 0;
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_A:
                p.setLeft(true);
                break;
            case KeyEvent.VK_D:
                p.setRight(true);
                break;
            case KeyEvent.VK_W:
                p.setUp(true);
                break;
            case KeyEvent.VK_S:
                p.setDown(true);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
            if(key == KeyEvent.VK_W){
                p.setUp(false);
            }else if(key == KeyEvent.VK_S){
                p.setDown(false);
            }else if(key == KeyEvent.VK_A){
                p.setLeft(false);
            }else if(key == KeyEvent.VK_D){
                p.setRight(false);
            }
    }
    
}
