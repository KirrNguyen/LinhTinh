/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author KirrNguyen
 */
public class Map {
    Image i11,i12,i13,i14,i15,i16,i21,i22,i23,i24,i25,i26;
    boolean drag = false;
    int xdraw,ydraw,button;
    public static int in = 0;
    public static int in2 = 0;
    int xH = -100,yH = -100;
    ArrayList<Integer> fromx = new ArrayList<>();
    ArrayList<Integer> tox = new ArrayList<>();
    ArrayList<Integer> fromy = new ArrayList<>();
    ArrayList<Integer> toy = new ArrayList<>();
    int[][] reset = {{11,12,13,14,15,13,12,11},
                    {16,16,16,16,16,16,16,16},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {26,26,26,26,26,26,26,26},
                    {21,22,23,24,25,23,22,21}};
    int[][] map = {{11,12,13,14,15,13,12,11},
                    {16,16,16,16,16,16,16,16},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {26,26,26,26,26,26,26,26},
                    {21,22,23,24,25,23,22,21}};
    
    int[] minimap = {11,12,13,14,15,16};
    int[] minimap2 = {21,22,23,24,25,26};
    
    public Map(){
        getImage();
    }
    public void Update(){
        try{
//            in =Integer.parseInt(dis.readUTF());
        
        
        if(in != 0){
            int toy = in%10;
            int fromy = in/10 % 10;
            int tox = in/100 % 10;
            int fromx = in/1000;
            if(fromx != tox || fromy != toy){
                map[toy][tox] = map[fromy][fromx];
                map[fromy][fromx] = 0; 
            }
            //System.out.println("in = "+in);
            in = 0;
        }
        if(in2 != 0){
            int fromy = in2%10;
            System.out.println(""+fromy);
            int fromx = in2/10 % 10;
            System.out.println(""+fromx);
            int button = in2/10000;
            System.out.println(""+button);
            map[fromy][fromx] = button; 
            //System.out.println("in = "+in);
            in2 = 0;
        }
        
        }catch(Exception ex){
            
        }
    }
    public void setIn(int i){
        in = i;
    }
    public void draw(Graphics g2){
        khung(g2);
        quan(g2);
        dichuyen(g2);
        vequanphu(g2);
        g2.setColor(Color.red);
        g2.drawOval(xH, yH, 50, 50);
    
    }
    public void vequanphu(Graphics g2){
        // quân phụ
        for(int i = 0;i<6;i++){
            g2.setColor(Color.red);
            if(minimap[i] == 11){
                g2.drawImage(i11, 600, i*50, null);
            }else if(minimap[i] == 12){
                g2.drawImage(i12, 600, i*50,null);
            }else if(minimap[i] == 13){
                g2.drawImage(i13, 600, i*50, null);
            }else if(minimap[i] == 14){
                g2.drawImage(i14, 600, i*50, null);
            }else if(minimap[i] == 15){
                g2.drawImage(i15, 600, i*50, null);
            }else if(minimap[i] == 16){
                g2.drawImage(i16, 600, i*50, null);
            }
            g2.drawRect(600, i*50, 50, 50);
        }
        for(int i = 0;i<6;i++){
            g2.setColor(Color.red);
            if(minimap2[i] == 21){
                g2.drawImage(i21, 700, i*50, null);
            }else if(minimap2[i] == 22){
                g2.drawImage(i22, 700, i*50,null);
            }else if(minimap2[i] == 23){
                g2.drawImage(i23, 700, i*50, null);
            }else if(minimap2[i] == 24){
                g2.drawImage(i24, 700, i*50, null);
            }else if(minimap2[i] == 25){
                g2.drawImage(i25, 700, i*50, null);
            }else if(minimap2[i] == 26){
                g2.drawImage(i26, 700, i*50, null);
            }
            g2.drawRect(700, i*50, 50, 50);
        }
    }
    public void dichuyen(Graphics g2){
        // di chuyển
        
        if(drag){
            if(button == 11){
                g2.drawImage(i11, xdraw, ydraw, null);
            }else if(button == 12){
                g2.drawImage(i12, xdraw, ydraw, null);
            }else if(button == 13){
                g2.drawImage(i13, xdraw, ydraw, null);
            }else if(button == 14){
                g2.drawImage(i14, xdraw, ydraw, null);
            }else if(button == 15){
                g2.drawImage(i15, xdraw, ydraw, null);
            }else if(button == 16){
                g2.drawImage(i16, xdraw, ydraw, null);
            }else if(button == 21){
                g2.drawImage(i21, xdraw, ydraw, null);
            }else if(button == 22){
                g2.drawImage(i22, xdraw, ydraw, null);
            }else if(button == 23){
                g2.drawImage(i23, xdraw, ydraw, null);
            }else if(button == 24){
                g2.drawImage(i24, xdraw, ydraw, null);
            }else if(button == 25){
                g2.drawImage(i25, xdraw, ydraw, null);
            }else if(button == 26){
                g2.drawImage(i26, xdraw, ydraw, null);
            }
            
        }
    }
    public void quan(Graphics g2){
        // quân
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                if(map[j][i] == 11){
                    g2.drawImage(i11, i*50, j*50, null);
                }else if(map[j][i] == 12){
                    g2.drawImage(i12, i*50, j*50, null);
                }else if(map[j][i] == 13){
                    g2.drawImage(i13, i*50, j*50, null);
                }else if(map[j][i] == 14){
                    g2.drawImage(i14, i*50, j*50, null);
                }else if(map[j][i] == 15){
                    g2.drawImage(i15, i*50, j*50, null);
                }else if(map[j][i] == 16){
                    g2.drawImage(i16, i*50, j*50, null);
                }else if(map[j][i] == 21){
                    g2.drawImage(i21, i*50, j*50, null);
                }else if(map[j][i] == 22){
                    g2.drawImage(i22, i*50, j*50, null);
                }else if(map[j][i] == 23){
                    g2.drawImage(i23, i*50, j*50, null);
                }else if(map[j][i] == 24){
                    g2.drawImage(i24, i*50, j*50, null);
                }else if(map[j][i] == 25){
                    g2.drawImage(i25, i*50, j*50, null);
                }else if(map[j][i] == 26){
                    g2.drawImage(i26, i*50, j*50, null);
                }
            }
        }
    }
    public void khung(Graphics g2){
        // ô
        int mau = 0;
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                if(mau % 2 == 0){
                    g2.setColor(Color.white);
                }else{
                    g2.setColor(Color.gray);
                }
                g2.fillRect(i*50 + 1, j*50 + 1, 49, 49);
                mau++;
            }
            mau++;
        }
        // khung
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                g2.setColor(Color.red);
                g2.drawRect(i*50, j*50, 50, 50);
            }
        }
    }
    
    public void getImage(){
        i11 = getImageIcon("Black R");
        i12 = getImageIcon("Black N");
        i13 = getImageIcon("Black B");
        i14 = getImageIcon("Black Q");
        i15 = getImageIcon("Black K");
        i16 = getImageIcon("Black P");
        
        i21 = getImageIcon("White R");
        i22 = getImageIcon("White N");
        i23 = getImageIcon("White B");
        i24 = getImageIcon("White Q");
        i25 = getImageIcon("White K");
        i26 = getImageIcon("White P");
    }
    private Image getImageIcon(String name) {
        Image image = new ImageIcon(getClass().getResource(
                "/Image/" + name + ".png")).getImage();
        Icon icon = new ImageIcon(image);
        return image;
    }

    public void reset(){
        for(int i = 0 ;i<8;i++){
            for(int j = 0;j<8;j++){
                map[j][i] = reset[j][i];
            }
        }
    }
    public Map getMap(){
        return this;
    }
}
