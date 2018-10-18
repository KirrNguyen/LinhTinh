/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static Game.MouseListen.*;
import static Game.Window.*;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author KirrNguyen
 */
public class event1 {
    JLabel choice = new JLabel();
    public event1(){
        
    }
    private Icon getIcon(String name) {
        Image image = new ImageIcon(getClass().getResource(
                "/Image/" + name + ".png")).getImage();
        Icon icon = new ImageIcon(image);
        return icon;
    }
//    public void fillchoice(int x,int y){
//        choice.setBounds(x, y, 235, 35);
//        choice.setIcon(getIcon("choice"));
//        panelmain.add(choice);
//        choice.repaint();
//    }
    public void newgame(){
        try{
            pMain.removeAll();
        }catch(Exception ex){}
            //NewGame Newgame = new NewGame();
            
            Newgame.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            control = "newgame";
            pMain.add(Newgame);
            pMain.repaint();
    }
    public void Startgame(){
        try{
            pMain.removeAll();
        }catch(Exception ex){}
            //NewGame Newgame = new NewGame();
            
            startgame.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            control = "startgame";
            pMain.add(startgame);
            pMain.repaint();
    }
    
}
