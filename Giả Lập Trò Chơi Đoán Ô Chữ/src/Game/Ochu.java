/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author KirrNguyen
 */
public class Ochu {
    int x,y,size;
    String s,ques1,ques2,ques3;
    public Ochu(int x,int y,int size,String s,String ques1,String ques2,String ques3){
        this.x = x;
        this.y = y;
        this.size = size;
        this.s = s;
        this.ques1 = ques1;
        this.ques2 = ques2;
        this.ques3 = ques3;
    }
    
    public void draw(Graphics g){
        for(int i = 0;i<size;i++){
            g.setColor(Color.black);
            g.drawRect(x + i*24, y, 24, 24);
            char[] arr = s.toCharArray();
            try{
                String string = Character.toString(arr[i]);
                g.drawString(string, x + i*24 + 6, y + 12 + 6);
            }catch(Exception ex){}
        }
        
    }
    public Rectangle getBound(){
        Rectangle bound = new Rectangle();
        bound.x = x;
        bound.y = y + 24;
        bound.width = (int) size*24;
        bound.height = (int) 24;
        return bound;
    }
}
