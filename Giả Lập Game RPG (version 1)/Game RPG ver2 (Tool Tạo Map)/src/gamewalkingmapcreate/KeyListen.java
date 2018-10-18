/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamewalkingmapcreate;

import static gamewalkingmapcreate.KPanel.*;
import static gamewalkingmapcreate.MouseListen.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author KirrNguyen
 */
public class KeyListen implements KeyListener{
    int i = 0;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_1){
            key1 = 1 - 1;
        }else if(key == KeyEvent.VK_2){
            key1 = 2 - 1;
        }else if(key == KeyEvent.VK_3){
            key1 = 3 - 1;
        }else if(key == KeyEvent.VK_E){
            move = true;
        }else if(key == KeyEvent.VK_UP){
//            System.out.println(""+Mwidth);
//            System.out.println(""+Mheight);
//            for(int i = 0;i<Mheight;i++){
//                for(int j = 0;j<Mwidth;j++){
//                    System.out.print(arr[i][j]+" ");
//                }
//                System.out.println("");
//            }
            try{
                FileWriter write = new FileWriter("D:\\map.txt");
                BufferedWriter bw = new BufferedWriter(write);
                
                bw.write(""+Mwidth);
                bw.newLine();
                bw.write(""+Mheight);
                bw.newLine();
                for(int i = 0;i<Mheight;i++){
                    for(int j = 0;j<Mwidth;j++){
                        bw.write(arr[i][j]+" ");
                    }
                    bw.newLine();
                }
                bw.close();
                System.out.println("done");
            }catch(Exception ex){
                
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_E){
            move = false;
        }
    }
    
}
