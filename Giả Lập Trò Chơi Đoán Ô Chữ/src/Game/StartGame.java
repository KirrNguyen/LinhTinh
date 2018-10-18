/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static Game.Window.WINDOW_HEIGHT;
import static Game.Window.WINDOW_WIDTH;
import static Game.Window.control;
import static Game.Window.pMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author KirrNguyen
 */
public class StartGame extends JPanel{
    //JList<String> game = new JList();
    JList<String> game;
    public static LoadData loaddata = new LoadData();
    public static OpenGame opengame ;
    JButton Select = new JButton("Chọn Game");
    public static ArrayList<String> namegame = new ArrayList<String>();
    public StartGame(){
        setLayout(null);
        setBounds(0, 0, 995, 570);
        
        loaddata.LoadGame();
        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        for(int i = 0;i<namegame.size();i++){
            defaultListModel.addElement(namegame.get(i));
        }
        game = new JList<>(defaultListModel);
        game.setBounds(50, 50, 100, 400);
        
        Select.setBounds(175, 200, 24*6, 24);
        
        add(game);
        add(Select);
        AddAction();
    }

    public void AddAction(){
        Select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(namegame.get(game.getSelectedIndex()));
                try{
                    pMain.removeAll();
                    opengame = new OpenGame(namegame.get(game.getSelectedIndex()));
                    opengame.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
                control = "opengame";
                pMain.add(opengame);
                pMain.repaint();
                    repaint();
                }catch(Exception ex){}
            }
        });
    }    
}
