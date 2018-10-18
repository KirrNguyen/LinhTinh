/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamewalking;

import static gamewalking.KFrame.WINDOW_HEIGHT;
import static gamewalking.KFrame.WINDOW_WIDTH;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author KirrNguyen
 */
public class KPanel extends JPanel implements Runnable{
//    public static final int SCREEN_WIDTH = WINDOW_WIDTH;
//    public static final int SCREEN_HEIGHT = WINDOW_HEIGHT;
    private int FPS = 100;
    private int Time = 1000/FPS;
    public BufferedImage image,background;
    private Graphics2D g,g2;
    
    public static Map map;
    public static Player p;

    Thread thread;
    public static int PanelHeight = WINDOW_HEIGHT-29;
    public static int PanelWidth = WINDOW_WIDTH-6;
    public KPanel(){
        setLayout(null);
//        super();
//        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
//        setFocusable(true);
//        requestFocus();
//        
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        long time1,time2,time3;
        init();
        while(true){
            time1 = System.nanoTime();
    
            update();
            render();
            draw();
            
            time2 = (System.nanoTime() - time1)/1000000;
            time3 = Time - time2;
            try {
                if(time3 > 0)
                            Thread.sleep(time3);
                    else Thread.sleep(Time);
            } catch (InterruptedException ex) {
                System.out.println("sleep");       
            }
        }
    }
    public void init(){
        image = new BufferedImage(PanelWidth, PanelHeight, BufferedImage.TYPE_INT_RGB);
        g2 = (Graphics2D) image.getGraphics();
        
        map = new Map();
        p = new Player(72, 72 , 24, 24);
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
        
    }
    public void render(){
        g2.setColor(Color.white);
        g2.fillRect(0, 0, 1000, 600);
        
        map.render(g2);
        p.render(g2);
        map.render2(g2);
        p.render2(g2);
        
        
    }
}
