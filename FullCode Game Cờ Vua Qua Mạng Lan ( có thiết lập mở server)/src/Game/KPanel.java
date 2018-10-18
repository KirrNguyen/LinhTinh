/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static Game.KFrame.WINDOW_HEIGHT;
import static Game.KFrame.WINDOW_WIDTH;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author KirrNguyen
 */
public class KPanel extends JPanel{
    
    public BufferedImage image;
    private Image image2;
    private Graphics2D g,g2;
    public static Map m = new Map();
    public KPanel(){
        
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
        m.Update();
    }
    public void render(){
        g2.setColor(Color.white);
        g2.fillRect(0, 0, 1000, 600);
        
        
//        g2.setColor(Color.red);
//        g2.fillRect(100, 100, 50, 50);
        
        m.draw(g2);
    }
    public JPanel getpanel(){
        return this;
    }
}
