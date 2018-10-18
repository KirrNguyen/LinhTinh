/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import static rpggame1.Attack1.MonAtking;
import static rpggame1.KPanel.animation;
import static rpggame1.KPanel.map;
import static rpggame1.KPanel.mon1;
import static rpggame1.KPanel.p;
import static rpggame1.PMain.DELTA_TIME;

/**
 *
 * @author KirrNguyen
 */
public class Skill4 {
    int x,y;
    long t1;
    boolean attack = true; // có thể tấn công hay không ?
    double timeskill2 = 1; // thoi gian delay skill
    double cooldown = 50; // giam thoi gian danh %
    double realtime ; // thời gian cooldown thực tế
    public static boolean atking4; // bấm nút tấn công
    int mana = 0;
    int delta;
    int vector;
    public Skill4(){
        
    }

    
    public void reload(){
        if(DELTA_TIME - t1 >=  realtime * 1000){
            attack = true;
        }
    }
    public void update(){
        
        // tính delta đòn đánh
        if(attack){
            delta = 0;
        }    
        
        // tính cooldown skill
        realtime = timeskill2 - (cooldown / 100 * timeskill2);
        
        if(atking4){
            // 50 là time delay
            animation.updateSkill4(5);
            //animation.updateFrozen(100);
        }
        animation.updateHeart();
    }
    

    
    public void render(Graphics g2){
//        g2.setColor(Color.blue);
//            g2.fillRect((int) p.x - 12  - 48+ map.xMap,
//                            (int)  p.y - 12 - 48 + map.yMap, 120, 120);
            
                // sau khoảng delta = 5 thì mới tiếp tục render ảnh ,, tránh render liên tục
        
        if(atking4){
                x = (int) p.x - 24 + map.xMap;
                y = (int) p.y - 24 + map.yMap;
                animation.setting(x, y, 0);
                animation.renderSkill4(g2);
            }
        
    }
    
    public void Akting(){
        for(int i = 0;i<mon1.size();i++){
            if(getBound((int) p.x - 12 - 48 + map.xMap,
                            (int)  p.y - 12 - 48 + map.yMap, 120, 120).intersects(mon1.get(i).getBound())){
                        mon1.get(i).hp -= 10;
                        MonAtking = i;    
                        mon1.get(i).fire = true; // animation
                        mon1.get(i).deltafire = System.currentTimeMillis();
                        
                        mon1.get(i).fireing = true;
                        mon1.get(i).deltafireing = System.currentTimeMillis();
                        ////// setting
                        mon1.get(i).setHeart(i);
                        animation.settingHeart(mon1.get(i).getBound().x + 12, mon1.get(i).getBound().y + 12);
                        
            }
        }
    }
    public Rectangle getBound(int x,int y,int width,int height){
        Rectangle bound = new Rectangle();
        bound.x = x;
        bound.y = y;
        bound.width = width;
        bound.height = height;
        return bound;
    }
}
