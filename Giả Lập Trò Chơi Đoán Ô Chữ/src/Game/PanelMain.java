/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static Game.Window.control;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author KirrNguyen
 */
public class PanelMain extends JPanel{
    JLabel start = new JLabel();
    JLabel newgame = new JLabel();
    JLabel Main = new JLabel();
    int X = 1000,Y = 1000;
    public PanelMain(){
        setLayout(null);
        
        Main.setBounds(0, 0, 1000, 600);
        Main.setIcon(getIcon("Main"));
        
        start.setBounds(50, 150, 227, 27);
        start.setIcon(getIcon("start"));
        
        newgame.setBounds(50, 200, 200, 26);
        newgame.setIcon(getIcon("new"));
        
        add(start);
        add(newgame);
        add(Main);
     
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.red);
        try{
            g.drawRect(X, Y, 250, 50);
            g.drawRect(X-1, Y-1, 252, 52);
            g.drawRect(X-2, Y-2, 254, 54);
            g.drawRect(X-3, Y-3, 256, 56);
        }catch(Exception ex){}
    }
    public void setControl(){
        control = "panelmain";
    }
    private Icon getIcon(String name) {
        Image image = new ImageIcon(getClass().getResource(
                "/Image/" + name + ".png")).getImage();
        Icon icon = new ImageIcon(image);
        return icon;
    }
    public Rectangle getBoundstart(){
        Rectangle bound = new Rectangle();
                bound.x = start.getX();
                bound.y = start.getY() + 24;
                bound.width = start.getWidth();
                bound.height = start.getHeight();
        return bound;
    }
    public Rectangle getBoundnew(){
        Rectangle bound = new Rectangle();
                bound.x = newgame.getX();
                bound.y = newgame.getY() + 24;
                bound.width = newgame.getWidth();
                bound.height = newgame.getHeight();
        return bound;
    }
    
}
