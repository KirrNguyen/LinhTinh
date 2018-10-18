/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeking2.SnakeGame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import snakeking2.Main.FormMain;

/**
 *
 * @author KirrNguyen
 */
public class GamePanel2 extends JPanel implements Runnable{
    Thread thread;
    boolean isRunning = true;
    public static Snake snake = new Snake();
    Food food = new Food();
    public GamePanel2(){
        setLayout(null);
        thread = new Thread(this);
        thread.start();
        
    }
    @Override
    public void run(){
        while(isRunning){
            Update();
            repaint();
            try{
                thread.sleep(20);
            }catch(Exception ex){
            }
        }
    }
    public void Update(){
        snake.Update();
        food.Update();
    }
    public void drawMap(Graphics g){
        for(int i = 0;i<35;i++){
            for(int j = 0;j<20;j++){
                g.setColor(Color.black);
                g.fillRect(i*20, j*20, 18, 18);
            }
        }
    }
    @Override
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, FormMain.SCREEN_WIDTH, FormMain.SCREEN_HEIGHT);
        drawMap(g);
        snake.Draw(g);
        food.Draw(g);
    }
}
