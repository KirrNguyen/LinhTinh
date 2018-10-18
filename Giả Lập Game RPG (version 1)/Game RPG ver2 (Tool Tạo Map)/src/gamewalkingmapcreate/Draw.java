/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamewalkingmapcreate;

import static gamewalkingmapcreate.KPanel.*;
import static gamewalkingmapcreate.KPanel.arr;
import static gamewalkingmapcreate.KPanel.x;
import static gamewalkingmapcreate.KPanel.xMap;
import static gamewalkingmapcreate.KPanel.y;
import static gamewalkingmapcreate.KPanel.yMap;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author KirrNguyen
 */
public class Draw {
    Image i;
    int x1,y1;
    
    public Draw(){
        
    }
    public void update(int x,int y){
        this.x1 = x;
        this.y1 = y;
    }
    
    public void render(Graphics g2){
        for(int i = 0;i<Mwidth;i++){
                for(int j = 0; j < Mheight ; j++){
                    if(arr[j][i] == 0){
                        //g2.drawImage(i1, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(x + xMap + i*24, y + yMap +  j*24, 24, 24);
                    }
                }
            }
    }
    //  x + xMap, y + yMap
    public void render2(Graphics g2){
        for(int i = 0;i<Mwidth;i++){
            for(int j = 0; j < Mheight ; j++){
                if(arr[j][i] == 0){
                    g2.setColor(Color.black);
                    g2.drawRect(x + xMap + i*24, y + yMap + j*24, 24, 24);
                }else if(arr[j][i] == 1){
                    g2.setColor(Color.red);
                    g2.fillRect(x + xMap + i*24, y + yMap + j*24, 24, 24);
                }else if(arr[j][i] == 2){
                    g2.setColor(Color.black);
                    g2.fillRect(x + xMap + i*24, y + yMap + j*24, 24, 24);
                }
            }
        }
    }
}
