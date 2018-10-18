/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeking2.SnakeGame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author KirrNguyen
 */
public class Snake {
    // 1000 = 1s;
    int speed = 100;
    int Long = 3;
    int[] x;
    int[] y;
    
    static int map[][] = new int[40][25];
    
    long t1 = 0;
    
    boolean UP = false;
    boolean DOWN = false;
    boolean LEFT = false;
    boolean RIGHT = false;
    boolean CanUP = true;
    boolean CanDOWN = true;
    boolean CanLEFT = true;
    boolean CanRIGHT = true;
    
    public Snake(){
        x = new int[250];
        y = new int[250];
        
        x[0] = 5;
        y[0] = 4;
        
        x[0] = 5;
        y[0] = 3;
        
        x[0] = 5;
        y[0] = 2;
        
        map[10][10] = 1;
    }
    public void Update(){
        if(System.currentTimeMillis() - t1 > speed){
            
            // ghi nhớ tọa độ di chuyển
            for(int i = Long-1;i>0;i--){
                x[i] = x[i-1];
                y[i] = y[i-1];
            }
            
            if(UP) y[0]--;
            if(DOWN) y[0]++;
            if(LEFT) x[0]--;
            if(RIGHT) x[0]++;
            t1 = System.currentTimeMillis();
        }
    }
    public void Draw(Graphics g){
        g.setColor(Color.GREEN);
        for(int i = 0; i < Long;i++){
            g.fillRect(x[i]*20 , y[i]*20 , 18, 18);
        }
    }

    public boolean isUP() {
        return UP;
    }

    public void setUP(boolean UP) {
        this.UP = UP;
    }

    public boolean isDOWN() {
        return DOWN;
    }

    public void setDOWN(boolean DOWN) {
        this.DOWN = DOWN;
    }

    public boolean isLEFT() {
        return LEFT;
    }

    public void setLEFT(boolean LEFT) {
        this.LEFT = LEFT;
    }

    public boolean isRIGHT() {
        return RIGHT;
    }

    public void setRIGHT(boolean RIGHT) {
        this.RIGHT = RIGHT;
    }

    public boolean isCanUP() {
        return CanUP;
    }

    public void setCanUP(boolean CanUP) {
        this.CanUP = CanUP;
    }

    public boolean isCanDOWN() {
        return CanDOWN;
    }

    public void setCanDOWN(boolean CanDOWN) {
        this.CanDOWN = CanDOWN;
    }

    public boolean isCanLEFT() {
        return CanLEFT;
    }

    public void setCanLEFT(boolean CanLEFT) {
        this.CanLEFT = CanLEFT;
    }

    public boolean isCanRIGHT() {
        return CanRIGHT;
    }

    public void setCanRIGHT(boolean CanRIGHT) {
        this.CanRIGHT = CanRIGHT;
    }
    
    
}
