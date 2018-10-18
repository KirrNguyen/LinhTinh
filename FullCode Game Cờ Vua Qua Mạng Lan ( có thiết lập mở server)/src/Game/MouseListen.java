/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static Client.Client.dos;
import static Client.Client.frame;
import java.awt.Graphics;
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
    int cachebutton = 0; // quân hiện tại
    int fromx,fromy,tox,toy; // biến tính lịch sử
    boolean checksend = false; // thêm quân
    Graphics g2;
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
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        try{
            xM = e.getX();
            yM = e.getY() - 24;
            fromx = xM/50;
            fromy = yM/50;
            if(fromx < 8 && fromy < 8){
                if(frame.kpanel.m.map[fromy][fromx] != 0){
                    cachebutton = frame.kpanel.m.map[fromy][fromx]; // lấy quân hiện tại
                    frame.kpanel.m.xH = fromx*50;
                    frame.kpanel.m.yH = fromy*50;
                    //frame.kpanel.m.map[fromy][fromx] = 0; // set vị trí lấy quân = 0
                    //frame.kpanel.m.button = cachebutton;  // di chuyển quân
                }
            }
            
            if(fromx == 12 && frame.kpanel.m.minimap[fromy] != 0){
                cachebutton = frame.kpanel.m.minimap[fromy]; // lấy quân hiện tại
                checksend = true;
                //frame.kpanel.m.button = cachebutton;  // di chuyển quân
            }
            if(fromx == 14 && frame.kpanel.m.minimap2[fromy] != 0){
                cachebutton = frame.kpanel.m.minimap2[fromy]; // lấy quân hiện tại
                checksend = true;
                //frame.kpanel.m.button = cachebutton;  // di chuyển quân
            }
            frame.kpanel.m.drag = true;
            frame.kpanel.m.xdraw = xM - 25;
            frame.kpanel.m.ydraw = yM - 25; 
        }catch(Exception ex){
            
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        try{
            xM = e.getX();
            yM = e.getY() - 24;
            tox = xM/50;
            toy = yM/50;
            if(tox < 8 && toy < 8){
                frame.kpanel.m.map[toy][tox] = cachebutton;
                send2();
                cachebutton = 0;
                frame.kpanel.m.xH = -100;
                frame.kpanel.m.yH = -100;
            }else{
                frame.kpanel.m.map[fromy][fromx] = cachebutton;
            }
            
            frame.kpanel.m.xdraw = -50;
            frame.kpanel.m.ydraw = -50;   
            
            
        }catch(Exception ex){
            
        }
        sending();// di chuyển 
        
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
            xM = e.getX();
            yM = e.getY() - 24;
            frame.kpanel.m.drag = true;
            frame.kpanel.m.button = cachebutton;
            frame.kpanel.m.xdraw = xM - 25;
            frame.kpanel.m.ydraw = yM - 25;            
        }catch(Exception ex){
            
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    public void sending(){
        String s = "";
        s += fromx;
        s += tox;
        s += fromy;
        s += toy;
        try{
            if(Integer.parseInt(s)<10000){
                dos.writeUTF("1");
                dos.flush();
                dos.writeUTF(s);
                dos.flush();
            }
        }catch(Exception ex){
            
        }
        //System.out.println(""+s);
    }
    public void send2(){
        if(checksend){
            String s = "";
            s += cachebutton;
            s += "11";
            s += tox;
            s += toy;
            try{
                dos.writeUTF("1");
                dos.flush();
                dos.writeUTF(s);
                dos.flush();
            }catch(Exception ex){

            }
            checksend = false;
        }
        
        //System.out.println(""+s);
    }
}
