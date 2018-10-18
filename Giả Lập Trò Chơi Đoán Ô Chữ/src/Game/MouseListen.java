/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static Game.OpenGame.stt;
import static Game.OpenGame.vitri;
import static Game.StartGame.opengame;
import static Game.Window.control;
import static Game.Window.panelmain;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author KirrNguyen
 */
public class MouseListen implements MouseListener,MouseMotionListener{
    int x,y;
    event1 evt1 = new event1();
    public static NewGame Newgame = new NewGame();
    public static StartGame startgame = new StartGame();
    // hỗ trợ kiểm tra va chạm
    public Rectangle getClick(){
        Rectangle bound = new Rectangle();
        bound.x = x - 1;
        bound.y = y - 1;
        bound.width = 2;
        bound.height = 2;
        return bound;
    }
    // hỗ trợ điều chỉnh vị trí
    public Rectangle getClick(int x,int y, int size){
        Rectangle bound = new Rectangle();
        bound.x = x;
        bound.y = y;
        bound.width = (int) size*24 - 24;
        bound.height = (int) 2;
        return bound;
    }
    // lấy bound hàng ngang của FINAL QUESTION
    public Rectangle getCol(){
        Rectangle bound = new Rectangle();
        bound.x = 24;
        bound.y = 24*3;
        bound.width = 24*20;
        bound.height = 24;
        return bound;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(control.equals("panelmain")){
                if(getClick().intersects(panelmain.getBoundstart())){
                    System.out.println("start");
                    evt1.Startgame();
                }else if(getClick().intersects(panelmain.getBoundnew())){
                    System.out.println("new");
                    evt1.newgame();
                }
        }else if(control.equals("newgame")){
            Newgame.click = false;
            Newgame.x = e.getX()/24 * 24;
            Newgame.y = e.getY()/24 * 24 - 24;
            for(int i=0;i<Newgame.Ochu.size();i++){
                if(Newgame.Ochu.get(i).y == Newgame.y){
                    Newgame.click = true;
                    Newgame.RectClick = i;  
                    Newgame.Input.setText(String.valueOf(Newgame.Ochu.get(i).size));
                    Newgame.InputString.setText(Newgame.Ochu.get(i).s);
                    Newgame.Ques1.setText(Newgame.Ochu.get(i).ques1);
                    Newgame.Ques2.setText(Newgame.Ochu.get(i).ques2);
                    Newgame.Ques3.setText(Newgame.Ochu.get(i).ques3);
                }
            }
            if(getClick().intersects(getCol())){
                Newgame.colunm = x/24;
            }
            Newgame.repaint();
            Newgame.Line.setText(String.valueOf(Newgame.Ochu.size()));
        }else if(control.equals("opengame")){
            opengame.click = false;
            opengame.x = e.getX()/24 * 24;
            opengame.y = e.getY()/24 * 24 - 24;
            // kiem cha va cham
            for(int i=0;i<vitri.size();i++){
            if((24*5 + (stt.get(i) - 1)*24) == opengame.y){
                opengame.click = true;
                opengame.RectClick = i;  
            } 
        }
        opengame.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(control.equals("newgame")){
            Newgame.drag = false;
            Newgame.Line.setText(String.valueOf(Newgame.Ochu.size()));
        }else if(control.equals("opengame")){
            opengame.drag = false;
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
        if(control.equals("newgame")){
            Newgame.x = e.getX()/24 * 24;
            Newgame.y = e.getY()/24 * 24 - 24;
            Newgame.drag = true;
            for(int i=0;i<Newgame.Ochu.size();i++){
                if(getClick(e.getX(), e.getY(),Newgame.row).intersects(Newgame.Ochu.get(i).getBound())) {
                    if(Newgame.x < 24){
                        Newgame.Ochu.get(i).x = 24;
                    }else if(Newgame.x > 24*21 - 24*Newgame.Ochu.get(i).size){
                        Newgame.Ochu.get(i).x = 24*21 - 24*Newgame.Ochu.get(i).size;
                    }else{
                        Newgame.Ochu.get(i).x = Newgame.x;
                        Newgame.Input.setText(String.valueOf(Newgame.Ochu.get(i).size));
                        Newgame.InputString.setText(Newgame.Ochu.get(i).s);
                        Newgame.Ques1.setText(Newgame.Ochu.get(i).ques1);
                        Newgame.Ques2.setText(Newgame.Ochu.get(i).ques2);
                        Newgame.Ques3.setText(Newgame.Ochu.get(i).ques3);
                    }
                    Newgame.RectClick = i; 
                }  
            }
            Newgame.repaint();
            Newgame.Line.setText(String.valueOf(Newgame.Ochu.size()));
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        
        if(control.equals("panelmain")){
            if(getClick().intersects(panelmain.getBoundstart())){
                panelmain.X = 37;
                panelmain.Y = 137;
            }else if(getClick().intersects(panelmain.getBoundnew())){
                panelmain.X = 37;
                panelmain.Y = 187;
            }
        }
        panelmain.repaint();
    }
    
}
