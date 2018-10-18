/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static rpggame1.KPanel.atk;
import static rpggame1.Animation.*;
import static rpggame1.KPanel.animation;
import static rpggame1.KPanel.map;
import static rpggame1.KPanel.p;
import static rpggame1.KPanel.skill1;
import static rpggame1.KPanel.skill2;
import static rpggame1.KPanel.skill3;
import static rpggame1.KPanel.skill4;

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
            case KeyEvent.VK_LEFT:
                p.setLeft(true);
                p.vector = 2;
                break;
            case KeyEvent.VK_RIGHT:
                p.setRight(true);
                p.vector = 3;
                break;
            case KeyEvent.VK_UP:
                p.setUp(true);
                p.vector = 0;
                break;
            case KeyEvent.VK_DOWN:
                p.setDown(true);
                p.vector = 1;
                break;
            case KeyEvent.VK_A:
                    atk.atking = true;
                    if(atk.attack){
                        deltaattack = System.currentTimeMillis();
                        atk.t1 = System.currentTimeMillis();
                        atk.Akting();
                        atk.attack = false;
                        animation.i1 = 0;
                    }
                break;
            case KeyEvent.VK_S:
                if(p.mp >= skill1.mana){
                    p.mp -= skill1.mana;
                    skill1.atking1 = true;
                    if(skill1.attack){
                        deltaskill1 = System.currentTimeMillis();
                        skill1.t1 = System.currentTimeMillis();
                        skill1.Akting();
                        skill1.attack = false;
                        animation.i5 = 0;  // load animation
                    }
                }
                    
                break;
            case KeyEvent.VK_D:
                if(p.mp >= skill2.mana){
                    p.mp -= skill2.mana;
                    skill2.atking2 = true;
                    if(skill2.attack){
                        deltaskill2 = System.currentTimeMillis();
                        skill2.t1 = System.currentTimeMillis();
                        skill2.Akting();
                        skill2.attack = false;
                        animation.i6 = 0;
                        animation.Skill2x = (int) p.x - 36 + map.xMap;
                        animation.Skill2y = (int) p.y - 36 + map.yMap;
                        animation.move = 0;
                    }
                }
                break;
            case KeyEvent.VK_Q:
                    if(p.mp >= skill3.mana){
                        p.mp -= skill3.mana;
                        skill3.atking3 = true;
                        if(skill3.attack){
                            deltaskill31 = System.currentTimeMillis();
                            skill3.t1 = System.currentTimeMillis();
                            skill3.Akting();
                            skill3.attack = false;
                            animation.i71 = 0;
                        }
                    }
                break;
            case KeyEvent.VK_W:
                    if(p.mp >= skill4.mana){
                        p.mp -= skill4.mana;
                        skill4.atking4 = true;
                        if(skill4.attack){
                            deltaskill5 = System.currentTimeMillis();
                            skill4.t1 = System.currentTimeMillis();
                            skill4.Akting();
                            skill4.attack = false;
                            animation.i9 = 0;
                        }
                    }
                break;
            case KeyEvent.VK_R:
                    p.mp = p.MP;
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
            if(key == KeyEvent.VK_UP){
                p.setUp(false);
            }else if(key == KeyEvent.VK_DOWN){
                p.setDown(false);
            }else if(key == KeyEvent.VK_LEFT){
                p.setLeft(false);
            }else if(key == KeyEvent.VK_RIGHT){
                p.setRight(false);
            }
//            else if(key == KeyEvent.VK_A){
//                deltaattack = 0;
//                atk.atking = false;
//            }else if(key == KeyEvent.VK_S){
//                deltaskill1 = 0;
//                skill1.atking1 = false;
//            }
            p.x =(int) p.x/12 * 12;
            p.y =(int) p.y/12 * 12;
    }
    
}
