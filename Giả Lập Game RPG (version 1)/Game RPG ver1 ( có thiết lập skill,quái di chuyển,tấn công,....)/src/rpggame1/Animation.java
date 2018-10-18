/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame1;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static rpggame1.KPanel.map;
import static rpggame1.KPanel.mon1;
import static rpggame1.PMain.DELTA_TIME;

/**
 *
 * @author KirrNguyen
 */
public class Animation {
    
    
    ArrayList<Image> atkup = new ArrayList<Image>();
    ArrayList<Image> atkdown = new ArrayList<Image>();
    ArrayList<Image> atkleft = new ArrayList<Image>();
    ArrayList<Image> atkright = new ArrayList<Image>();
    
    ArrayList<Image> monst21 = new ArrayList<Image>();
    ArrayList<Image> monst22 = new ArrayList<Image>();
    
    ArrayList<Image> heart = new ArrayList<Image>();
    ArrayList<Image> Skill1 = new ArrayList<Image>();
    ArrayList<Image> Skill2 = new ArrayList<Image>();
    ArrayList<Image> Skill31 = new ArrayList<Image>();
    ArrayList<Image> Skill32 = new ArrayList<Image>();
    
    ArrayList<Image> Skill4 = new ArrayList<Image>();
    
    public static int x1,y1,numb; // attack
    public static int x2,y2; // bị tấn công
    public static int x3,x4,y3,y4; //mon1
    public static int i1,i2,i3,i4,i5,i6,i71,i72,i8,i9;
    
    public static long deltaattack = 0; // update animation
    public static long deltaskill1 = 0; // update animation
    public static long deltaskill2 = 0; // update animation
    public static long deltaskill31 = 0; // update animation
    public static long deltaskill32 = 0; // update animation
    public static long deltaskill4 = 0; // update animation monster2
    public static long deltaskill5 = 0; // update animation
    
    
    public Animation(){
        atkup.add(getImageIcon("i11"));
        atkup.add(getImageIcon("i12"));
        atkup.add(getImageIcon("i13"));
        atkup.add(getImageIcon("i14"));
        atkup.add(getImageIcon("i15"));
        
        atkdown.add(getImageIcon("i31"));
        atkdown.add(getImageIcon("i32"));
        atkdown.add(getImageIcon("i33"));
        atkdown.add(getImageIcon("i34"));
        atkdown.add(getImageIcon("i35"));
        
        atkleft.add(getImageIcon("i21"));
        atkleft.add(getImageIcon("i22"));
        atkleft.add(getImageIcon("i23"));
        atkleft.add(getImageIcon("i24"));
        atkleft.add(getImageIcon("i25"));
        
        atkright.add(getImageIcon("i41"));
        atkright.add(getImageIcon("i42"));
        atkright.add(getImageIcon("i43"));
        atkright.add(getImageIcon("i44"));
        atkright.add(getImageIcon("i45"));
        
        heart.add(getImageIcon("sp0"));
        heart.add(getImageIcon("sp1"));
        heart.add(getImageIcon("sp2"));
        
        Skill1.add(getImageIcon("a0"));
        Skill1.add(getImageIcon("a1"));
        Skill1.add(getImageIcon("a2"));
        Skill1.add(getImageIcon("a3"));
        Skill1.add(getImageIcon("a4"));
        
        
        Skill2.add(getImageIcon("w1"));
        Skill2.add(getImageIcon("w2"));
        Skill2.add(getImageIcon("w3"));
        Skill2.add(getImageIcon("w4"));
        Skill2.add(getImageIcon("w5"));
        Skill2.add(getImageIcon("w1"));
        Skill2.add(getImageIcon("w2"));
        Skill2.add(getImageIcon("w3"));
        Skill2.add(getImageIcon("w4"));
        Skill2.add(getImageIcon("w5"));
        
        Skill31.add(getImageIcon("f1"));
        Skill31.add(getImageIcon("f2"));
        Skill31.add(getImageIcon("f3"));
        Skill31.add(getImageIcon("f1"));
        Skill31.add(getImageIcon("f2"));
        Skill31.add(getImageIcon("f3"));
        Skill31.add(getImageIcon("f1"));
        
        
        Skill32.add(getImageIcon("frozen"));
        Skill32.add(getImageIcon("frozen"));
        
        monst21.add(getImageIcon("m900"));
        monst21.add(getImageIcon("m901"));
        monst21.add(getImageIcon("m900"));
        monst21.add(getImageIcon("m901"));
        monst22.add(getImageIcon("m910"));
        monst22.add(getImageIcon("m911"));
        monst22.add(getImageIcon("m910"));
        monst22.add(getImageIcon("m911"));
        
        Skill4.add(getImageIcon("lava1"));
        Skill4.add(getImageIcon("lava2"));
        Skill4.add(getImageIcon("lava3"));
        Skill4.add(getImageIcon("lava4"));
        Skill4.add(getImageIcon("lava5"));
    }
    
    ////////////////////////
    public void setting(int x,int y,int numb){
        this.x1 = x;
        this.y1 = y;
        this.numb = numb;
    }
    
    
    public void update(double delaytime){

            if(deltaattack != 0 && DELTA_TIME - deltaattack >= delaytime*10){
                if(i1 == atkup.size() ){
                //i1 = 0;
                }else{
                    i1++;
                    deltaattack = DELTA_TIME;
                }
            }
        
        
    }
    public void render(Graphics g){
        try{
            if(numb == 0){
                g.drawImage(atkup.get(i1), x1, y1, null);
            }else if(numb == 1){
                g.drawImage(atkdown.get(i1), x1, y1, null);
            }else if(numb == 2){
                g.drawImage(atkleft.get(i1), x1, y1, null);
            }else{
                g.drawImage(atkright.get(i1), x1, y1, null);
            }
        }catch(Exception ex){
            
        }
    }
    
    ////////////////////////////

    public void updateSkill1(double delaytime){// liên tục - lấy 1 lần
//        delta = System.currentTimeMillis();
        if(deltaskill1 != 0 && DELTA_TIME - deltaskill1 >= delaytime*10){
            if(i5 == Skill1.size()){
                
            }else{
                i5++;
                deltaskill1 = DELTA_TIME;
            }
        }
        
    }
    public void renderSkill1(Graphics g){
        try{
            g.drawImage(Skill1.get(i5), x1, y1, null);
        }catch(Exception ex){
            
        }
    }
    //////////////////////////
    int Skill2x;
    int Skill2y;
    int move = 0;
    public void updateSkill2(double delaytime){// liên tục - lấy 1 lần
        
        if(deltaskill2 != 0 && DELTA_TIME - deltaskill2 >= delaytime*10){
            i6++;
            deltaskill2 = DELTA_TIME;
        }
    }
    public void renderSkill2(Graphics g){
        
        try{
            g.drawImage(Skill2.get(i6), Skill2x, Skill2y, null);
        }catch(Exception ex){
            
        }
    }
    
    
    public void updateSkill31(double delaytime){// liên tục - lấy 1 lần
        
        if(deltaskill31 != 0 && DELTA_TIME - deltaskill31 >= delaytime*10){
            if(i71 == Skill31.size()){
                
            }else{
                i71++;
                deltaskill31 = DELTA_TIME;
            }if(deltaskill31 != 0 && DELTA_TIME - deltaskill31 >= delaytime*10){
            if(i72 == Skill32.size()){
                
            }else{
                i72++;
                deltaskill31 = DELTA_TIME;
            }
        }
        }
        
    }
    public void renderSkill31(Graphics g){
        
        try{
            g.drawImage(Skill31.get(i71), x1, y1, null);
            
        }catch(Exception ex){
            
        }
    }
    public void renderFrozen(Graphics g){
        try{
            for(int i = 0 ;i<mon1.size();i++){
                if(mon1.get(i).frozen)
                    g.drawImage(Skill32.get(0),(int) mon1.get(i).x + map.xMap, (int) mon1.get(i).y + map.yMap, null);
            }
        }catch(Exception ex){
            
        }
    }
    
    public void updateSkill4(double delaytime){// liên tục - lấy 1 lần
        
        if(deltaskill5 != 0 && DELTA_TIME - deltaskill5 >= delaytime*10){
            if(i9 == Skill4.size()){
                
            }else{
                i9++;
                deltaskill5 = DELTA_TIME;
            }if(deltaskill5 != 0 && DELTA_TIME - deltaskill5 >= delaytime*10){
            if(i9 == Skill4.size()){
                
            }else{
                i9++;
                deltaskill5 = DELTA_TIME;
            }
        }
        }
        
    }
    public void renderSkill4(Graphics g){
        try{
            for(int i = 0 ;i<mon1.size();i++){
                if(mon1.get(i).fire)
                    g.drawImage(Skill4.get(i9),(int) mon1.get(i).x + map.xMap, 
                            (int) mon1.get(i).y + map.yMap - 24, null);
                   
            }
        }catch(Exception ex){
            
        }
    }
    
    
    public void updateMonst1(double delaytime){
        if(deltaskill4 != 0 && DELTA_TIME - deltaskill4 >= delaytime*10){
            if(i8 == monst21.size()-1){
                i8 = 0;
            }else i8++;
        }
    }
    public void renderMonst1(Graphics g){
        g.drawImage(monst21.get(i8), x2, y2, null);
    }
    public void updateMonst2(double delaytime){
        if(deltaskill4 != 0 && DELTA_TIME - deltaskill4 >= delaytime*10){
            if(i8 == monst22.size()-1){
                i8 = 0;
            }else i8++;
        }
    }
    public void renderMonst2(Graphics g){
        g.drawImage(monst22.get(i8), x2, y2, null);
    }
    
    public void settingHeart(int x,int y){
        this.x2 = x;
        this.y2 = y;
    }
    public void updateHeart(){
        if(i2 == heart.size()-1){
            i2 = 0;
        }else i2++;
    }
    public void renderHeart(Graphics g){
        g.drawImage(heart.get(i2), x2, y2, null);
    }
    /////////////////////////////
    
    
    
    ///////////////////////////
    
    ///////////////////////////////////
    
    private Icon getIcon(String name) {
        Image image = new ImageIcon(getClass().getResource(
                "/Image/" + name + ".png")).getImage();
        Icon icon = new ImageIcon(image);
        return icon;
    }
    private Image getImageIcon(String name) {
        Image image = new ImageIcon(getClass().getResource(
                "/Image/" + name + ".png")).getImage();
        Icon icon = new ImageIcon(image);
        return image;
    }
}
