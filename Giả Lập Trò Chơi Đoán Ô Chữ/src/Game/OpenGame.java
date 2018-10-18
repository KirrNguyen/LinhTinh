/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static Game.MouseListen.Newgame;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import static Game.StartGame.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author KirrNguyen
 */
public class OpenGame extends JPanel{
    public static String NameOfGame = "";
    public static ArrayList<Integer> stt = new ArrayList<>();
    public static ArrayList<Integer> vitri = new ArrayList<>();
    public static ArrayList<Integer> cot = new ArrayList<>();
    public static ArrayList<String> dapan = new ArrayList<>();
    public static ArrayList<String> ques1 = new ArrayList<>();
    public static ArrayList<String> ques2 = new ArrayList<>();
    public static ArrayList<String> ques3 = new ArrayList<>();
    
    JTextField input = new JTextField();
    JButton check = new JButton();
    public static String checkdapan;
    checkGame checkgame = new checkGame();
    
    boolean drag = false;
    int RectClick = 0; // khung Click
    boolean click = false;
    int x,y;
    
    public OpenGame(String game){
        this.NameOfGame = game;
        loaddata.opendata(game);
        
        input.setBounds(50, 50, 96, 24);
        
        check.setBounds(150, 50, 72, 24);
        check.setText("Check");
        
        add(check);
        add(input);
        
        repaint();
        AddAction();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        check.repaint();
        input.repaint();
        g.setColor(Color.red);
        g.drawRect(24*8, 24*5, 24*11, 24*11);
        // vẽ các cột
        g.setColor(Color.BLACK);
        for(int i = 0;i<stt.size();i++){
            for(int j=0;j<cot.get(i);j++){
                g.drawRect(24*8 + vitri.get(i)*24 + j*24, 24*5 + i*24, 24, 24);
            }
        }
        
        try{
                if(click){
                    g.setColor(Color.red);
                    g.drawRect(24*8 + vitri.get(RectClick)*24, y, cot.get(RectClick) * 24, 24);
                    g.drawRect(24*8 + vitri.get(RectClick)*24-1, y-1, cot.get(RectClick) * 24 + 2, 26);
                    g.drawRect(24*8 + vitri.get(RectClick)*24-2, y-2, cot.get(RectClick) * 24 + 4, 28);
                }else System.out.println("false");
            }catch(Exception ex){
               
            } 
    }
    public void AddAction(){
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkdapan = input.getText();
                checkgame.check(checkdapan,RectClick+1);
                System.out.println(""+RectClick+1);
                repaint();
            }
        });
        
    }
}
