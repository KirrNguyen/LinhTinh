/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import static rpggame1.KPanel.PanelHeight;
import static  rpggame1.KPanel.PanelWidth;
import static rpggame1.KPanel.map;
import static rpggame1.KPanel.mon1;

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
    int vector = 0;
    int width,height;
    int tx,ty;
    double maxSpeed = 3; // tốc độ chạy
    //////// jumping
    double maxFallingSpeed = 12; //tốc độ rơi tối đa
    double jumpStart = -11; // độ cao tối đa
    double gravity = 0.64; // hãm
    boolean jumping,falling;
    ///////////
    int size = 24;
    int HP = 100;
    int hp = HP;
    int MP = 200;
    int mp = MP;
    int manapersecond = 1;
    
    public Player(int x,int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height= height;
    }
    public int percenHP(int Hp,int hp){
        double percel = (double) (10000 / Hp  * hp) /100;
        return (int) percel;
    }
    public void render(Graphics g2){
        g2.setColor(Color.red);
        //g.fillRect((int) x - width/2,(int) y - height/2, width, height);
        // draw theo map
        tx = map.xMap;
        ty = map.yMap;
        g2.drawRect(
                (int) (tx+x-width/2),
                (int) (ty+y-height/2), 
                width, height);
        // thanh mana
        g2.setColor(Color.black);
        g2.fillRect(720, 530, 100 , 10);
        g2.setColor(Color.blue);
        g2.fillRect(720, 530, percenHP(MP, mp) , 10);
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
        //// hồi mana mỗi giây
        remana();
        checkAttack();
    }
    int timeline = 0;
    int sumoftime = 0;
    public void remana(){
                sumoftime++;
                if(sumoftime == 100){
                    timeline++;
                    sumoftime=0;
                    mp+=manapersecond;
                    
            }
    }
    public void checkAttack(){
        for(int i =0;i<mon1.size();i++){
            if(mon1.get(i).getBoundAttack().intersects(getBoundPlayer())){
                mon1.get(i).atk = true;
                mon1.get(i).move1 = false;
            }else mon1.get(i).atk = false;
        }
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
    public Rectangle getBoundPlayer(){
        Rectangle bound = new Rectangle();
        bound.x =(int) (x + map.xMap - 24/2);
        bound.y =(int) (y + map.yMap - 24/2);
        bound.width = 24;
        bound.height = 24;
        return bound;
    }
}
