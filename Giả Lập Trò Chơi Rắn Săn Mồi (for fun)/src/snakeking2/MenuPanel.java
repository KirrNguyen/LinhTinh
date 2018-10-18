/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeking2;

import snakeking2.Main.FormMain;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author KirrNguyen
 */
public class MenuPanel extends JPanel{
    
    JLabel menu = new JLabel();
    JLabel left = new JLabel();
    JLabel right = new JLabel();
    
    public MenuPanel(){
        setLayout(null);
        setBackground(Color.red);
        
        menu.setBounds((FormMain.SCREEN_WIDTH - 200)/2, (FormMain.SCREEN_HEIGHT - 100)/2, 200, 100);
        left.setBounds((FormMain.SCREEN_WIDTH - 100)/4, (FormMain.SCREEN_HEIGHT - 50)/4, 100, 50);
        right.setBounds((FormMain.SCREEN_WIDTH - 100)/4*3, (FormMain.SCREEN_HEIGHT - 50)/4, 100, 50);
        
        setIcon();
        
        add(menu);
        add(left);
        add(right);
        
        repaint();
    }
    public void setIcon(){
        menu.setText("start");
        left.setText("<");
        right.setText(">");
    }
    private Icon getIcon(String name) {
        Image image = new ImageIcon(getClass().getResource(
                "/Image/" + name + ".png")).getImage();
        Icon icon = new ImageIcon(image);
        return icon;
    }
}
