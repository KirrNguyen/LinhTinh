/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ns_1_2_map;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static ns_1_2_map.KPanel.*;

/**
 *
 * @author KirrNguyen
 */
public class MouseListen implements MouseListener,MouseMotionListener{
    int xM;
    int yM;
    int x,y;
    public static boolean delete = false;
    public Rectangle getClick(int x,int y){
        Rectangle bound = new Rectangle();
            bound.x = x;
            bound.y = y;
            bound.width = 2;
            bound.height = 2;
        return bound;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
//        xM = e.getX();
//        yM = e.getY() - 24;
//        x = xM/24 * 24;
//        y = yM/24 * 24;

//        if(delete == true){
//            arr[y/24][x/24] = 100;
//        }else{
//            draw.update(x,y);
//            arr[y/24][x/24] = key1;
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        xM = e.getX();
        yM = e.getY() - 24;
        x = xM/24 * 24;
        y = yM/24 * 24;
        if(delete == true){
            arr[y/24][x/24] = 100;
        }else{
            draw.update(x,y);
            arr[y/24][x/24] = key1;
        }   
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
        xM = e.getX();
        yM = e.getY() - 24;
        x = xM/24 * 24;
        y = yM/24 * 24;
        if(delete == true){
            arr[y/24][x/24] = 100;
        }else{
            draw.update(x,y);
            arr[y/24][x/24] = key1;
        }   
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        xM = e.getX();
        yM = e.getY() - 24;
        x = xM/24 * 24;
        y = yM/24 * 24;
    }
    
}
