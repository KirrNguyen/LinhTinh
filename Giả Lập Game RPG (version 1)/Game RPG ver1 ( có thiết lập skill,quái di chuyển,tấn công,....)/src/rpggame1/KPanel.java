/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;
import static rpggame1.KFrame.WINDOW_HEIGHT;
import static rpggame1.KFrame.WINDOW_WIDTH;
import static rpggame1.Monster1.spawnEnemy;
import static rpggame1.Monster1.timespawn;
import static rpggame1.PMain.DELTA_TIME;

/**
 *
 * @author KirrNguyen
 */
public class KPanel extends JPanel{
    
    public BufferedImage image;
    private Image image2;
    private Graphics2D g,g2;
    public static Map map;
    public static Player p;
    public static Attack1 atk = new Attack1();
    public static Skill1 skill1 = new Skill1();
    
    public static Skill2 skill2 = new Skill2();
    public static Skill3 skill3 = new Skill3();
    public static Skill4 skill4 = new Skill4();
    
    public static Animation animation;
    public static ArrayList<Monster1> mon1 = new ArrayList<Monster1>();
    //public static ArrayList<Monster1> smon1 = new ArrayList<Monster1>();
    
    public static ArrayList<Monster2> mon2 = new ArrayList<Monster2>();
    //public static ArrayList<Monster1> smon1 = new ArrayList<Monster1>();
    
    public static int PanelHeight = WINDOW_HEIGHT-29;
    public static int PanelWidth = WINDOW_WIDTH-6;
    
    SetUp setup = new SetUp();
    public KPanel(){
        
    }
    
    public void init(){
        image = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
        g2 = (Graphics2D) image.getGraphics();
        
        map = new Map();
        p = new Player(96*2, 96*2 , 24, 24);
        animation = new Animation();
        
    }
        public void reload(){
        //respawn all 
      
        // reload attack
        atk.reload();
        skill1.reload();
        skill2.reload();
        skill3.reload();
        skill4.reload();
        
        // làm mới quái
        if(DELTA_TIME - timespawn >= spawnEnemy*1000){
            setup.refresh();
            timespawn = DELTA_TIME;
        }
            
    }
    public void draw(){
        g = (Graphics2D) getGraphics();
        if(g!=null){
            g.drawImage(image, 0, 0, null);
            g.dispose();
        }
    }
    public void update(){
        p.update();
        atk.update();
        skill1.update();
        skill2.update();
        skill3.update();
        skill4.update();
        
        for(int i = 0;i<mon1.size();i++){
            mon1.get(i).update();
            if(mon1.get(i).alive == false){
                mon1.remove(i);
            }
        }
        for(int i = 0;i<mon2.size();i++){
            mon2.get(i).update();
            if(mon2.get(i).alive == false){
                mon2.remove(i);
            }
        }
    }
    public void render(){
        g2.setColor(Color.white);
        g2.fillRect(0, 0, 1000, 600);
        
        map.renderx(g2);
        map.render(g2);
        map.render2(g2);
        
        
        for(int i = 0;i<mon1.size();i++){ // quái vật
            mon1.get(i).render(g2);
        }
        for(int i = 0;i<mon2.size();i++){ // quái vật
            mon2.get(i).render(g2);
        }
        
        skill1.render(g2);
        skill2.render(g2);
        skill3.render(g2);
        skill4.render(g2);
        
        p.render(g2);
        atk.render(g2);
        map.render3(g2);
        
        
        ///////////// reload enemy
        g2.setColor(Color.black);
        g2.fillRect(600, 550, 100, 10);
        double percel = 100 / spawnEnemy  * (DELTA_TIME - timespawn) / 1000;
        g2.setColor(Color.GREEN);
        g2.fillRect(600, 550,(int) percel, 10);
        
        //////////// relaod attack
        g2.setColor(Color.black);
        g2.fillRect(600, 530, 100, 10);
        
        double percel2 = 100 / atk.realtime  * (DELTA_TIME - atk.t1) / 1000;
        if(percel2 > 100) percel2 = 100;
        g2.setColor(Color.GREEN);
        g2.fillRect(600, 530,(int) percel2, 10);
        
    }
}
