/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ns_1_2_map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import static ns_1_2_map.KFrame.WINDOW_HEIGHT;
import static ns_1_2_map.KFrame.WINDOW_WIDTH;

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
    public static int arr[][] = new int[29][50];
    public static String send = "";
    public static int key1;
    public static Draw draw = new Draw();
    Thread thread;
    public static int x,y;
    public KPanel(){
        setLayout(null);
        setBackground(Color.white);
        thread = new Thread(this);
        thread.start();
        for(int i = 0;i<50;i++){
            for(int j = 0; j < 29 ; j++){
                arr[j][i] = 100;
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
        x = draw.x;
        y = draw.y;
    }
    public void render(){
        g2.setColor(Color.white);
        g2.fillRect(0, 0, 1200, 700);
        draw.renderx(g2);
        draw.render(g2);
        draw.render2(g2);
        draw.render3(g2);
    }
}
