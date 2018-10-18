/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Main.Connecting;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author KirrNguyen
 */
public class Window extends JFrame{
    
    public int SCREEN_WIDTH;
    public int SCREEN_HEIGHT;
    public static int WINDOW_WIDTH = 1000;
    public static int WINDOW_HEIGHT = 600;
    public static Connecting cn = new Connecting();
    public static String control;
    public static PanelMain panelmain = new PanelMain();
    public static JPanel pMain;
    MouseListen mouse;
    
    public Window(){
        cn.Connected();
        mouse  = new MouseListen();
        getSizeWindow(); // lấy size của màn hình máy tính
        this.setBounds((SCREEN_WIDTH - WINDOW_WIDTH)/2, (SCREEN_HEIGHT - WINDOW_HEIGHT)/2,
                WINDOW_WIDTH, WINDOW_HEIGHT); // set vị trí và kích thước hiển thị
        this.setLayout(null); // set layout =  tùy chỉnh
        this.setVisible(true); //set hiển thị 
        this.setResizable(false); // set thay đổi kích thước JFrame
        
        control = new String();
        
        setUpPanel();
        add(pMain);
        
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
        pMain = new JPanel();
        pMain.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        pMain.setLayout(null);
        
        panelmain.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        panelmain.setControl();
        pMain.add(panelmain);
    }
    
}
