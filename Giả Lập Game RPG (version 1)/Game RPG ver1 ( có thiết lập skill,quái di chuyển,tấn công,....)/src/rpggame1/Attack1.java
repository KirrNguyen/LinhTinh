/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame1;

import java.awt.Color;
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
public class Attack1 {
    int x,y;
    long t1;
    boolean attack = true; // có thể tấn công hay không ?
    double timeskill1 = 1; // thoi gian delay skill
    double cooldown = 50; // giam thoi gian danh %
    double realtime ; // thời gian cooldown thực tế
    public static int MonAtking = 0; // vị trí quái vật bị tấn công
    public static boolean atking; // bấm nút tấn công
    int delta;
    public Attack1(){
        
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
        
        if(atking){
            animation.update(2);
        }
        animation.updateHeart();
    }
    
    public void render(Graphics g){
//        g.setColor(Color.red);
//            if(p.vector == 0){
//                g.fillRect((int) p.x - 12 - 12 + map.xMap,(int)  p.y - 12 - 12 + map.yMap, 48, 24);
//            }else if(p.vector == 1){
//                g.fillRect((int) p.x - 12 - 12 + map.xMap,(int)  p.y + 12 - 12 + map.yMap, 48, 24);
//            }else if(p.vector == 2){
//                g.fillRect((int) p.x - 12 - 12 + map.xMap,(int)  p.y - 12- 12 + map.yMap, 24, 48);
//            }else{
//                g.fillRect((int) p.x + 12 - 12 + map.xMap,(int)  p.y - 12 - 12 + map.yMap, 24, 48);
//            }
                // sau khoảng delta = 5 thì mới tiếp tục render ảnh ,, tránh render liên tục
        if(delta <= 5 && atking){
            if(p.vector == 0){
                x = (int) p.x - 12 - 12 + map.xMap;
                y = (int) p.y - 12 - 12 + map.yMap;
                animation.setting(x, y, 0);
                delta++;
                animation.render(g);
            }else if(p.vector == 1){
                x = (int) p.x - 12 - 12 + map.xMap;
                y = (int) p.y + 12 - 12 + map.yMap;
                animation.setting(x, y, 1);
                delta++;
                animation.render(g);
            }else if(p.vector == 2){
                x = (int) p.x - 12 - 12 + map.xMap;
                y = (int) p.y - 12 - 12 + map.yMap;
                animation.setting(x, y, 2);
                delta++;
                animation.render(g);
            }else {
                x = (int) p.x + 12 - 12 + map.xMap;
                y = (int) p.y - 12 - 12 + map.yMap;
                animation.setting(x, y, 3);
                delta++;
                animation.render(g);
            }
        }
        
    }
    
    public void Akting(){
        for(int i = 0;i<mon1.size();i++){
            switch (p.vector) {
                case 0:
                    if(getBound((int) p.x - 12 - 12 + map.xMap,
                            (int)  p.y - 12 - 12 + map.yMap, 48, 24).intersects(mon1.get(i).getBound())){
                        mon1.get(i).hp -= 10;   
                        ////// setting
                        MonAtking = i;
                        mon1.get(i).setHeart(i);
                        animation.settingHeart(mon1.get(i).getBound().x, mon1.get(i).getBound().y);
                    }
                        
                    break;
                case 1:
                    if(getBound((int) p.x - 12 - 12 + map.xMap,
                            (int)  p.y + 12 - 12 + map.yMap, 48, 24).intersects(mon1.get(i).getBound())){
                        mon1.get(i).hp -= 10; 
                        ////// setting 
                        MonAtking = i;
                        mon1.get(i).setHeart(i);
                        animation.settingHeart(mon1.get(i).getBound().x, mon1.get(i).getBound().y);
                    }
                        
                    break;
                case 2:
                    if(getBound((int) p.x - 12 - 12 + map.xMap,
                            (int)  p.y - 12 - 12 + map.yMap, 24, 48).intersects(mon1.get(i).getBound())){
                        mon1.get(i).hp -= 10;  
                        ////// setting
                        MonAtking = i;  
                        mon1.get(i).setHeart(i);
                        animation.settingHeart(mon1.get(i).getBound().x, mon1.get(i).getBound().y);

                    }
                        
                    break;
                default:
                    if(getBound((int) p.x + 12 - 12 + map.xMap,
                            (int)  p.y - 12 - 12 + map.yMap, 24, 48).intersects(mon1.get(i).getBound())){
                        mon1.get(i).hp -= 10;  
                        ////// setting
                        MonAtking = i;   
                        mon1.get(i).setHeart(i);
                        animation.settingHeart(mon1.get(i).getBound().x, mon1.get(i).getBound().y);

                    }
                        
                    break;
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
