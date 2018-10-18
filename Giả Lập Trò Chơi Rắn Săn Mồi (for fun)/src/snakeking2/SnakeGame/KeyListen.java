/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeking2.SnakeGame;

import java.awt.event.KeyEvent;
import static snakeking2.SnakeGame.GamePanel2.snake;

/**
 *
 * @author KirrNguyen
 */
public class KeyListen {
    
    public KeyListen(){
        
    }
    public void KeyInputPress(int code){
        if(code == KeyEvent.VK_LEFT && snake.isCanLEFT()){
            snake.setLEFT(true);
            
            snake.setDOWN(false);
            snake.setUP(false);
            snake.setRIGHT(false);
            
            snake.setCanRIGHT(false);
            snake.setCanUP(true);
            snake.setCanDOWN(true);
        }else if(code == KeyEvent.VK_RIGHT && snake.isCanRIGHT()){
            snake.setRIGHT(true);
            
            snake.setDOWN(false);
            snake.setUP(false);
            snake.setLEFT(false);
            
            snake.setCanLEFT(false);
            snake.setCanUP(true);
            snake.setCanDOWN(true);
        }else if(code == KeyEvent.VK_UP && snake.isCanUP()){
            snake.setUP(true);
            
            snake.setDOWN(false);
            snake.setLEFT(false);
            snake.setRIGHT(false);
            
            snake.setCanDOWN(false);
            snake.setCanLEFT(true);
            snake.setCanRIGHT(true);
        }else if(code == KeyEvent.VK_DOWN && snake.isCanDOWN()){
            snake.setDOWN(true);
            
            snake.setUP(false);
            snake.setLEFT(false);
            snake.setRIGHT(false);
            
            snake.setCanUP(false);
            snake.setCanLEFT(true);
            snake.setCanRIGHT(true);
        }else if(code == KeyEvent.VK_R){
            
        }
    }
    public void KeyInputRelease(int code){
        
    }
}
