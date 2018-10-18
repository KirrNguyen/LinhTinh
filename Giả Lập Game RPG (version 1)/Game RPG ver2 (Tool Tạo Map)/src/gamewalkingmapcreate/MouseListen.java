/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamewalkingmapcreate;

import static gamewalkingmapcreate.KPanel.arr;
import static gamewalkingmapcreate.KPanel.draw;
import static gamewalkingmapcreate.KPanel.key1;
import static gamewalkingmapcreate.KPanel.x;
import static gamewalkingmapcreate.KPanel.xMap;
import static gamewalkingmapcreate.KPanel.y;
import static gamewalkingmapcreate.KPanel.yMap;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author KirrNguyen
 */
public class MouseListen implements MouseListener,MouseMotionListener{
    int xM;
    int yM;
    int x1,y1;
    
    int xm1,ym1;
    public static boolean move = false;
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
        try{
            if(move){
                xM = e.getX();
                yM = e.getY() - 24;            
            }else{
                xm1 = e.getX() - x;
                ym1 = e.getY() - 24 - y;
                x1 = xm1/24 * 24;
                y1 = ym1/24 * 24;

                draw.update(x1,y1);
                arr[y1/24][x1/24] = key1;
                System.out.println("x "+x1);
                System.out.println("y "+y1);
            }  
            
        }catch(Exception ex){
            
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        try{
            if(move){
                x += xMap/24 *24;
                y += yMap/24 *24;
                xMap = 0;
                yMap = 0;
            }            
        }catch(Exception ex){
            
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        try{
            if(move){
                xMap = (e.getX() - xM) ;
                yMap = (e.getY() - 24 - yM);
            }else{
                xm1 = e.getX() - x;
                ym1 = e.getY() - 24 - y;
                x1 = xm1/24 * 24;
                y1 = ym1/24 * 24;

                draw.update(x1,y1);
                arr[y1/24][x1/24] = key1;
                System.out.println("x "+x1);
                System.out.println("y "+y1);

            }            
        }catch(Exception ex){
            
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        try{
            if(!move){
                xm1 = e.getX() - x;
                ym1 = e.getY() - 24 - y;
                x1 = xm1/24 * 24;
                y1 = ym1/24 * 24;
            }
        }catch(Exception ex){
            
        }
        
        
    }
}
