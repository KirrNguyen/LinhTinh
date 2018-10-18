/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamewalkingmapcreate;

import static gamewalkingmapcreate.KFrame.WINDOW_HEIGHT;
import static gamewalkingmapcreate.KFrame.WINDOW_WIDTH;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author KirrNguyen
 */
public class KPanel extends JPanel implements Runnable{
    
    public BufferedImage image;
    private Image image2;
    private Graphics2D g,g2;
    private int FPS = 100;
    private int Time = 1000/FPS;
    public static int Mwidth = 100;
    public static int Mheight = 58;
    public static int arr[][] = new int[Mheight][Mwidth];
    public static String send = "";
    public static int key1;
    public static Draw draw = new Draw();
    Thread thread;
    public static int x1,y1;
    public static int xMap = 0,yMap = 0,x = 0,y = 0;
    public KPanel(){
        setLayout(null);
        setBackground(Color.white);
        thread = new Thread(this);
        thread.start();
        for(int i = 0;i<Mwidth;i++){
            for(int j = 0; j < Mheight ; j++){
                arr[j][i] = 0;
            }
        }
    }
    
    private Image getImageIcon(String name) {
        Image image = new ImageIcon(getClass().getResource(
                "/Image/" + name + ".png")).getImage();
        Icon icon = new ImageIcon(image);
        return image;
    }
    @Override
    public void run(){
        long time1,time2,time3;
        init();
        while(true){
            time1 = System.nanoTime();
            update();
            render();
            draw();
            //repaint();
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
        image = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
        g2 = (Graphics2D) image.getGraphics();
    }
    public void draw(){
        g = (Graphics2D) getGraphics();
        if(g!=null){
            g.drawImage(image, 0, 0, null);
            g.dispose();
        }
    }
    public void update(){
        x1 = draw.x1;
        y1 = draw.y1;
    }
    public void render(){
        g2.setColor(Color.white);
        g2.fillRect(0, 0, 1200, 700);
        draw.render(g2);
        draw.render2(g2);
    }
}
