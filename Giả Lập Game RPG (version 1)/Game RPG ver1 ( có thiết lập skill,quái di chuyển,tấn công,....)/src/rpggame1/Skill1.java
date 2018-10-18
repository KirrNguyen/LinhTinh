/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame1;

import java.awt.Graphics;
import java.awt.Rectangle;
import static rpggame1.KPanel.animation;
import static rpggame1.KPanel.atk;
import static rpggame1.KPanel.map;
import static rpggame1.KPanel.mon1;
import static rpggame1.KPanel.p;
import static rpggame1.PMain.DELTA_TIME;

/**
 *
 * @author KirrNguyen
 */
public class Skill1 {
    int x,y;
    long t1;
    boolean attack = true; // có thể tấn công hay không ?
    double timeskill1 = 1; // thoi gian delay skill
    double cooldown = 50; // giam thoi gian danh %
    double realtime ; // thời gian cooldown thực tế
    public static boolean atking1; // bấm nút tấn công
    int mana = 0;
    int delta;
    public Skill1(){
        
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
        realtime = timeskill1 - (cooldown / 100 * timeskill1);
        
        if(atking1){
            // 50 là time delay
            animation.updateSkill1(5);
        }
        animation.updateHeart();
    }
    

    
    public void render(Graphics g2){
//        g2.setColor(Color.blue);
//            g2.fillRect((int) p.x - 12 - 48 + map.xMap,(int)  p.y - 12 - 48 + map.yMap, 120, 120);
            
                // sau khoảng delta = 5 thì mới tiếp tục render ảnh ,, tránh render liên tục
        
        if(atking1){
                x = (int) p.x - 12 - 48 + map.xMap;
                y = (int) p.y - 12 - 48 + map.yMap;
                animation.setting(x, y, 0);
                animation.renderSkill1(g2);
        }
    }
    
    public void Akting(){
        for(int i = 0;i<mon1.size();i++){
            if(getBound((int) p.x - 12 - 48 + map.xMap,
                            (int)  p.y - 12 - 48 + map.yMap, 120, 120).intersects(mon1.get(i).getBound())){
                if(mon1.get(i).frozen){
                    mon1.get(i).hp -= 70; 
                    mon1.get(i).outFrozen();
                }else{
                    mon1.get(i).hp -= 20;   
                }
                        ////// setting 
                atk.MonAtking = i;
                mon1.get(i).setHeart(i);
                animation.settingHeart(mon1.get(i).getBound().x, mon1.get(i).getBound().y);
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
