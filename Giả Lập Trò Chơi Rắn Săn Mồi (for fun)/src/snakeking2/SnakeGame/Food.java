/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeking2.SnakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import static snakeking2.SnakeGame.GamePanel2.snake;
import static snakeking2.SnakeGame.Snake.map;

/**
 *
 * @author KirrNguyen
 */
public class Food {
    // random food
    public Point FoodNew(){
        int x;
        int y;
        do{
            x = getFood(1, 34);
            y = getFood(1, 19);
        }while(CheckFood(x, y));
        return new Point(x, y);
    }
    // kiểm tra thức ăn có random trên thân rắn ?
    public boolean CheckFood(int x1,int y1){
        for(int i = 0;i<snake.Long;i++)
            if(snake.x[i] == x1 && snake.y[i] == y1) return true;
            return false;
    }
    
    // lấy ngẫu nhiên trong khoảng
    public int getFood(int min, int max){
        Random r = new Random();
        return min+r.nextInt(max-min);
    }
    
    public void Update(){
        // kiểm tra thức ăn
        if(map[snake.x[0]][snake.y[0]] == 1){
                // tăng độ dài
                snake.Long++;
                map[snake.x[0]][snake.y[0]] = 0;
                map[FoodNew().x][FoodNew().y] = 1;
                
            }
    }
    public void Draw(Graphics g){
        for(int i = 0;i<35;i++){
            for(int j = 0;j<20;j++){
                if(snake.map[i][j] == 1){
                    g.setColor(Color.red);
                    g.fillRect(i*20, j*20, 18, 18);
                }
            }
        }
    }
}
