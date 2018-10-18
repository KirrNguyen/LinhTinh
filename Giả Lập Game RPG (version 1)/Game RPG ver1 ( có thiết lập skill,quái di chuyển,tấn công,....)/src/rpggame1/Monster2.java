/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static rpggame1.KPanel.animation;
import static rpggame1.KPanel.map;
import static rpggame1.KPanel.mon1;
import static rpggame1.PMain.DELTA_TIME;

/**
 *
 * @author KirrNguyen
 */
public class Monster2 {
    double speed = 0.3; // tốc độ
    int size = 24;// kích thước
    int maxmove = 150; 
    int id;
    int HP = 500; // máu tối đa
    int hp = HP; // máu còn lại
    double move = 0; // biến tính khoảng cách
    int timeback = 2; // thời gian nghỉ khi đổi chiều di chuyển
    double x,y;
    boolean alive = true; // còn sống ?
    boolean heart = false; // bị tấn công ?
    boolean frozen = false; // bị đóng băng
    public static long notheart;
    int timeHeart = 3; // thời gian chảy máu / 10
    Image i1,i2;
    
    public static int spawnEnemy = 60; // thời gian refrest quái 
    public static long timespawn; // delta thời gian refrest quái
    long deltafrozen = 0; // biến delta tính thời gian đóng băng
    int timefrozen = 50; // thời gian đóng băng = 1/10 giây
    
    
    public Monster2(int x,int y,int maxmove,int id){
        this.x = x*24;
        this.y = y*24;
        this.maxmove = maxmove;
        this.id = id;
        i1 = getImageIcon("m400");
        i2 = getImageIcon("m410");
    }
    private Image getImageIcon(String name) {
        Image image = new ImageIcon(getClass().getResource(
                "/Image/" + name + ".png")).getImage();
        Icon icon = new ImageIcon(image);
        return image;
    }
    public void update(){
        // di chuyển sang phải, trái phải
        if(move >= maxmove || move <= -maxmove){
            sumoftime++;
                if(sumoftime == timeback * 100){
                    sumoftime=0;
                    speed *= -1;
                    move = 0;
                }      
        }else{
            if(id == 0)
                x += speed;
            else y += speed;    
                move += speed;
        }
        if(hp <= 0){
            alive = false;
        }
        if(DELTA_TIME - notheart >= timeHeart * 100){
            heart = false;
        }
        checkFrozen();
        downhpFrozen();
        if(speed > 0){
            animation.updateMonst1(5);
        }else{
            //animation.updateMonst2(5);
        }
    }
    // thoát khỏi đóng băng
    public void outFrozen(){
        maxmove = 150;
        deltafrozen = 0;
        frozen = false;
    }
    // tự thoát đóng băng sau 1 khoảng thời gian
    public void checkFrozen(){
        if(frozen){
            if(deltafrozen != 0 && DELTA_TIME - deltafrozen >= timefrozen*100){
                outFrozen();
            }
        }
    }
    
    // trừ máu theo thời gian
    int timeline = 0;
    int sumoftime = 0;
    public void downhpFrozen(){
         if(frozen){
                sumoftime++;
                if(sumoftime == 100){
                    timeline++;
                    sumoftime=0;
                    hp-=5;
                    //System.out.println(timeline+"s");
            }
         }
    }
    public void setHeart(int i){
        heart = true;
        animation.settingHeart((int) mon1.get(i).x + map.xMap, (int) mon1.get(i).y + map.xMap);
        notheart = System.currentTimeMillis();
    }
    public int percenHP(int Hp,int hp){
        double percel = (double) (10000 / Hp  * hp) /400;
        return (int) percel;
    }
    public void render(Graphics g){
        /// draw hp
        g.setColor(Color.black);
        g.fillRect((int) x + map.xMap,(int) y + map.yMap - 7, size , 5);
        g.setColor(Color.green);
        g.fillRect((int) x + map.xMap,(int) y + map.yMap - 7, percenHP(HP, hp) , 5);
        ///
        
        
        ///////////////////////////////
        g.setColor(Color.BLACK);
        //g.fillRect((int) x + map.xMap,(int) y + map.yMap, size, size);
                // draw tại tâm đáy ( x + 12,y + 24)
                // code x va y : 
                //   xMap+k*size + 12 - i3.getWidth(null)/2, yMap+j*size + 24 - i3.getHeight(null)
        animation.settingHeart((int) x + map.xMap, (int) y + map.yMap);
        if(speed > 0){
            animation.renderMonst1(g);
        }else{
            animation.renderMonst2(g);
        }
        ///////////////////////////////
        
        
        
        /////////////////////////
        if(heart){
           animation.renderHeart(g);
        }
        if(frozen){ // 2 giây đóng băng
            maxmove = 0;
            animation.renderFrozen(g);
        }
        //////////////////////////
    }
    public Rectangle getBound(){
        Rectangle bound = new Rectangle();
        bound.x =(int) x + map.xMap;
        bound.y =(int) y + map.yMap;
        bound.width = 24;
        bound.height = 24;
        return bound;
    }
}
