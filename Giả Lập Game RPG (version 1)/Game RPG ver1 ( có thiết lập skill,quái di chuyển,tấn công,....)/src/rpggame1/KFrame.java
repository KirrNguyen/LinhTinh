/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author KirrNguyen
 */
public class KFrame extends JFrame{
    public int SCREEN_WIDTH;
    public int SCREEN_HEIGHT;
    public static int WINDOW_WIDTH = 1000;
    public static int WINDOW_HEIGHT = 600;
    public static PMain pMain;
    public static KPanel kpanel = new KPanel();
    KeyListen key;
    MouseListen mouse;
    public KFrame(){
        
        key = new KeyListen();
        mouse = new MouseListen();
        getSizeWindow(); // lấy size của màn hình máy tính
        this.setBounds((SCREEN_WIDTH - WINDOW_WIDTH)/2, (SCREEN_HEIGHT - WINDOW_HEIGHT)/2,
                WINDOW_WIDTH, WINDOW_HEIGHT); // set vị trí và kích thước hiển thị
        this.setLayout(null); // set layout =  tùy chỉnh
        this.setVisible(true); //set hiển thị 
        this.setResizable(false); // set thay đổi kích thước JFrame
        
        setUpPanel();
        add(pMain);
        
        addKeyListener(key);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }
    
    public void getSizeWindow(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit tk = this.getToolkit(); 
        Dimension dm = tk.getScreenSize();
        SCREEN_WIDTH = dm.width;
        SCREEN_HEIGHT = dm.height;
    }
    public void setUpPanel(){
        pMain = new PMain();
        pMain.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        pMain.setLayout(null);
        
        kpanel.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        pMain.add(kpanel);
    }
}
