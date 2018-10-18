/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame1;

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
public class Skill2 {
    int x,y;
    long t1;
    boolean attack = true; // có thể tấn công hay không ?
    double timeskill2 = 1; // thoi gian delay skill
    double cooldown = 50; // giam thoi gian danh %
    double realtime ; // thời gian cooldown thực tế
    public static boolean atking2; // bấm nút tấn công
    int mana = 0;
    int delta;
    int vector;
    public Skill2(){
        
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
        try{
            if(p.vector == 0){
                if(animation.move <= 150){
                    animation.Skill2y -= 5;
                    animation.move += 5;
                }
            }else if(p.vector == 1){
                if(animation.move <= 150){
                    animation.Skill2y += 5;
                    animation.move += 5;
                }
            }else if(p.vector == 2){
                if(animation.move <= 150){
                    animation.Skill2x -= 5;
                    animation.move += 5;
                }
            }else {
                if(animation.move <= 150){
                    animation.Skill2x += 5;
                    animation.move += 5;
                }
            }
        }catch(Exception ex){
            
        }
        if(atking2){
            // 50 là time delay
            animation.updateSkill2(5);
        }
        animation.updateHeart();
    }
    

    
    public void render(Graphics g2){
//        g2.setColor(Color.blue);
//            g2.fillRect((int) p.x - 12 + map.xMap,(int)  p.y - 12 - 120 + map.yMap, 24, 120);
//            g2.fillRect((int) p.x - 12 + map.xMap,(int)  p.y + 12 + map.yMap, 24, 120);
//            g2.fillRect((int) p.x - 12 - 120 + map.xMap,(int)  p.y - 12 + map.yMap, 120, 24);
//            g2.fillRect((int) p.x + 12 + map.xMap,(int)  p.y - 12 + map.yMap, 120, 24);
//            
                // sau khoảng delta = 5 thì mới tiếp tục render ảnh ,, tránh render liên tục
        
        if(atking2){
                x = (int) p.x - 36 + map.xMap;
                y = (int) p.y - 36 + map.yMap;
                animation.setting(x, y, 0);
                animation.renderSkill2(g2);
            }
        
    }
    
    public void Akting(){
        for(int i = 0;i<mon1.size();i++){
            switch (p.vector) {
                case 0:
                    if(getBound((int) p.x - 12 + map.xMap,
                            (int)  p.y - 12 - 120 + map.yMap, 24, 120).intersects(mon1.get(i).getBound())){
                        if(mon1.get(i).frozen){
                            mon1.get(i).hp -= 50; 
                            mon1.get(i).outFrozen();
                        }else if(mon1.get(i).fireing){
                            mon1.get(i).hp -= 50; 
                            mon1.get(i).outFireing();
                        }else{
                            mon1.get(i).hp -= 10;   
                        }
                        ////// setting
                        MonAtking = i;
                        mon1.get(i).setHeart(i);
                        animation.settingHeart(mon1.get(i).getBound().x, mon1.get(i).getBound().y);
                    }
                        
                    break;
                case 1:
                    if(getBound((int) p.x - 12 + map.xMap,
                            (int)  p.y + 12 + map.yMap, 24, 120).intersects(mon1.get(i).getBound())){
                        if(mon1.get(i).frozen){
                            mon1.get(i).hp -= 50; 
                            mon1.get(i).outFrozen();
                        }else if(mon1.get(i).fireing){
                            mon1.get(i).hp -= 50; 
                            mon1.get(i).outFireing();
                        }else{
                            mon1.get(i).hp -= 10;   
                        }
                        ////// setting 
                        MonAtking = i;
                        mon1.get(i).setHeart(i);
                        animation.settingHeart(mon1.get(i).getBound().x, mon1.get(i).getBound().y);
                    }
                        
                    break;
                case 2:
                    if(getBound((int) p.x - 12 - 120 + map.xMap,
                            (int)  p.y - 12 + map.yMap, 120, 24).intersects(mon1.get(i).getBound())){
                        if(mon1.get(i).frozen){
                            mon1.get(i).hp -= 50; 
                            mon1.get(i).outFrozen();
                        }else if(mon1.get(i).fireing){
                            mon1.get(i).hp -= 50; 
                            mon1.get(i).outFireing();
                        }else{
                            mon1.get(i).hp -= 10;   
                        }  
                        ////// setting
                        MonAtking = i;  
                        mon1.get(i).setHeart(i);
                        animation.settingHeart(mon1.get(i).getBound().x, mon1.get(i).getBound().y);

                    }
                        
                    break;
                default:
                    if(getBound((int) p.x + 12 + map.xMap,
                            (int)  p.y - 12 + map.yMap, 120, 24).intersects(mon1.get(i).getBound())){
                        if(mon1.get(i).frozen){
                            mon1.get(i).hp -= 50; 
                            mon1.get(i).outFrozen();
                        }else if(mon1.get(i).fireing){
                            mon1.get(i).hp -= 50; 
                            mon1.get(i).outFireing();
                        }else{
                            mon1.get(i).hp -= 10;   
                        }  
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
