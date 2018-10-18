/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ns_1_2_map;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static ns_1_2_map.KPanel.*;
import static ns_1_2_map.MouseListen.*;

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
        if(key == KeyEvent.VK_0){
            i++;
            if(i%2 == 0){
                delete = true;
            }else delete = false;
        }else if(key == KeyEvent.VK_1){
            send = "f00";
            key1 = 1 - 1;
        }else if(key == KeyEvent.VK_2){
            send = "f01";
            key1 = 2 - 1;
        }else if(key == KeyEvent.VK_3){
            send = "f02";
            key1 = 3 - 1;
        }else if(key == KeyEvent.VK_4){
            send = "f03";
            key1 = 4 - 1;
        }else if(key == KeyEvent.VK_5){
            send = "f04";
            key1 = 5 - 1;
        }else if(key == KeyEvent.VK_6){
            send = "f05";
            key1 = 6 - 1;
        }else if(key == KeyEvent.VK_7){
            send = "f06";
            key1 = 7 - 1;
        }else if(key == KeyEvent.VK_8){
            send = "f07";
            key1 = 8 - 1;
        }else if(key == KeyEvent.VK_9){
            send = "f08";
            key1 = 9 - 1;
        }else if(key == KeyEvent.VK_Q){
            send = "f09";
            key1 = 10 - 1;
        }else if(key == KeyEvent.VK_W){
            send = "f10";
            key1 = 11 - 1;
        }else if(key == KeyEvent.VK_E){
            send = "f11";
            key1 = 12 - 1;
        }else if(key == KeyEvent.VK_R){
            send = "f12";
            key1 = 13 - 1;
        }else if(key == KeyEvent.VK_T){
            send = "f13";
            key1 = 14 - 1;
        }else if(key == KeyEvent.VK_Y){
            send = "f14";
            key1 = 16 - 2;
        }else if(key == KeyEvent.VK_U){
            send = "f15";
            key1 = 18 - 2;
        }else if(key == KeyEvent.VK_I){
            send = "f16";
            key1 = 20 - 2;
        }else if(key == KeyEvent.VK_O){
            send = "f17";
            key1 = 22 - 2;
        }else if(key == KeyEvent.VK_P){
            send = "f18";
            key1 = 24 - 2;
        }else if(key == KeyEvent.VK_A){
            send = "f19";
            key1 = 26 - 2;
        }else if(key == KeyEvent.VK_S){
            send = "f20";
            key1 = 28 - 2;
        }else if(key == KeyEvent.VK_D){
            send = "f21";
            key1 = 30 - 2;
        }else if(key == KeyEvent.VK_F){
            send = "f22";
            key1 = 32 - 2;
        }else if(key == KeyEvent.VK_G){
            send = "f23";
            key1 = 34 - 2;
        }else if(key == KeyEvent.VK_H){
            send = "f24";
            key1 = 36 - 2;
        }else if(key == KeyEvent.VK_J){
            send = "town21";
            key1 = 100;
        }else if(key == KeyEvent.VK_K){
            send = "town22";
            key1 = 40 - 2;
        }else if(key == KeyEvent.VK_L){
            send = "town23";
            key1 = 42 - 2;
        }else if(key == KeyEvent.VK_Z){
            send = "town24";
            key1 = 44 - 2;
        }else if(key == KeyEvent.VK_X){
            send = "town25";
            key1 = 46 - 2;
        }else if(key == KeyEvent.VK_C){
            send = "town26";
            key1 = 48 - 2;
        }else if(key == KeyEvent.VK_V){
            send = "town27";
            key1 = 50 - 2;
        }else if(key == KeyEvent.VK_B){
            send = "town28";
            key1 = 52 - 2;
        }else if(key == KeyEvent.VK_N){
            send = "town29";
            key1 = 54 - 2;
        }else if(key == KeyEvent.VK_M){
            send = "town30";
            key1 = 56 - 2;
        }else if(key == KeyEvent.VK_LEFT){
            send = "town31";
            key1 = 58 - 2;
        }else if(key == KeyEvent.VK_DOWN){
            key1 = 99;
        }else if(key == KeyEvent.VK_RIGHT){
            send = "town32";
            key1 = 60 - 1;
        }else if(key == KeyEvent.VK_UP){
            for(int i = 0;i<29;i++){
                for(int j = 0;j<50;j++){
                    System.out.print(" "+arr[i][j]);
                }
                System.out.println("");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}
