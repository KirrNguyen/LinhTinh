/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamewalking;

import static gamewalking.KPanel.PanelHeight;
import static gamewalking.KPanel.PanelWidth;
import static gamewalking.KPanel.map;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author KirrNguyen
 */
public class Player {
    double x,y;
    double dx,dy;
    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;
    
    private boolean topLeft;
    private boolean topRight;
    private boolean botLeft;
    private boolean botRight;
    int width,height;
    int tx,ty;
    double maxSpeed = 3; // tốc độ chạy
    //////// jumping
    double maxFallingSpeed = 12; //tốc độ rơi tối đa
    double jumpStart = -11; // độ cao tối đa
    double gravity = 0.64; // hãm
    boolean jumping,falling;
    ///////////
    
    public Player(int x,int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height= height;
    }
    public void render(Graphics g){
        g.setColor(Color.red);
        //g.fillRect((int) x - width/2,(int) y - height/2, width, height);
        // draw theo map
        tx = map.xMap;
        ty = map.yMap;
        g.fillRect(
                (int) (tx+x-width/2),
                (int) (ty+y-height/2), 
                width, height);
    }
    // bound
    public void render2(Graphics g){
        g.setColor(Color.red);
        //g.fillRect((int) x - width/2,(int) y - height/2, width, height);
        // draw theo map
        tx = map.xMap;
        ty = map.yMap;
        g.drawRect(
                (int) (tx+x-width/2),
                (int) (ty+y-height/2), 
                width, height);
    }
    
    public void calculate(double x,double y){
        int leftTile = map.getColTile((int) (x - width/2));
        int rightTile = map.getColTile((int) (x + width/2)-1);
        int topTile = map.getRowTile((int) (y - height/2));
        int botTile = map.getRowTile((int) (y + height/2)-1);
        
        topLeft = map.getTile(topTile, leftTile) == 1 ;
        topRight = map.getTile(topTile, rightTile) == 1 ;
        botLeft = map.getTile(botTile, leftTile) == 1 ;
        botRight = map.getTile(botTile, rightTile) == 1 ;
    }
    
    public void update(){
        // di chuyển
        if(right)
            dx = maxSpeed;
        else if(left)
            dx = -maxSpeed;
        else if(up)
            dy = -maxSpeed;
        else if(down)
            dy = maxSpeed;
        

        else {
            dy = 0;
            dx = 0;
        }
        
        
        
        //////////kiem tra va cham map
        
        int currCol = map.getColTile((int) x);
        int currRow = map.getRowTile((int) y);
        
        double tox = x + dx;
        double toy = y + dy;
        
        double tempx = x;
        double tempy = y;
        // tính toán va chạm y
        calculate(x, toy);
        
        if(dy < 0){
            if(topLeft || topRight){
                dy = 0;
                tempy = currRow * map.size + height/2;
            }
            else {
                tempy += dy;
            }
        }
        if(dy > 0){
            if(botLeft || botRight){
                dy = 0;
                tempy =(currRow + 1) * map.size - height/2;
            }
            else {
                tempy += dy;
            }
        }
        /////////////////
        //tính toán va chạm x
        calculate(tox, y);
        
        if(dx < 0){
            if(topLeft || botLeft){
                dx = 0;
                tempx = currCol * map.size + width/2;
            }
            else{
                tempx +=dx;
            }
        }
        
        if(dx>0){
            if(topRight || botRight){
                dx=0;
                tempx = (currCol + 1) * map.size - width/2;
            }
            else {
                tempx +=dx;
            }
        }
        //////////////////
        
        
        
        // set di chuyển
        x = tempx;
        y = tempy;
        ///////////////
        
        // camera
        map.setxMap((int) (PanelWidth/2 - x));
        map.setyMap((int) (PanelHeight/2 - y));
        ////////////
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
    
}
