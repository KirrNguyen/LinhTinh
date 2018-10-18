/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamewalking;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author KirrNguyen
 */
public class Map {
    public static int xMap=0;
    public static int yMap=0;
    public static int size = 24;
    
    private int minx;
    private int miny;
    private int maxx =0;
    private int maxy =0;
    
    public static int map1[][];
    
    int sizeheight; // số hàng
    int sizewidth; //số cột
    Image i1,i2,i3,i0;
    public Map(){
        LoadingMap("src/Map/map21.txt");
        minx = KPanel.PanelWidth - sizewidth * size;
        miny = KPanel.PanelHeight - sizeheight * size;
        getImage();
    }
    public void getImage(){
        i1 = getImageIcon("1");
        i2 = getImageIcon("2");
        i3 = getImageIcon("3");
        i0 = getImageIcon("0");
    }
    private Image getImageIcon(String name) {
        Image image = new ImageIcon(getClass().getResource(
                "/Image/" + name + ".png")).getImage();
        Icon icon = new ImageIcon(image);
        return image;
    }
    public void LoadingMap(String s){
        try{
            BufferedReader  br = new BufferedReader(new FileReader(s));
            
            sizewidth = Integer.parseInt(br.readLine());
            sizeheight = Integer.parseInt(br.readLine());
            map1 = new int[sizeheight][sizewidth];
            
            String delimiter = "\\s+";
            for(int row = 0;row < sizeheight;row++){
                String line = br.readLine();
                String[] tokens = line.split(delimiter);
                for(int col=0;col < sizewidth;col++){
                    map1[row][col] = Integer.parseInt(tokens[col]);
                }
            }
        }
        catch(Exception e){
            System.out.println("not data");
        }
    }
    public void render(Graphics g){
        g.setColor(Color.black);
        for(int j = 0;j<sizeheight;j++){
            for(int k = 0;k<sizewidth;k++){
                if(map1[j][k] == 0) {
                    //g.drawImage(i0, xMap+k*size, yMap+j*size, null);
                    g.setColor(Color.white);
                    g.fillRect(xMap+k*size, yMap+j*size,size-1, size-1);
                }else if(map1[j][k] == 1) 
                    g.drawImage(i1, xMap+k*size, yMap+j*size, null);
                    //g.fillRect(xMap+k*size, yMap+j*size,size-1, size-1);
                else if(map1[j][k] == 2) 
                    g.drawImage(i2, xMap+k*size, yMap+j*size, null);
                    //g.fillRect(xMap+k*size, yMap+j*size,size-1, size-1);
                else if(map1[j][k] == 3) 
                    g.drawImage(i3, xMap+k*size, yMap+j*size, null);
                    //g.fillRect(xMap+k*size, yMap+j*size,size-1, size-1);
            }
        }
    }
     public void render2(Graphics g){
        for(int j = 0;j<sizeheight;j++){
            for(int k = 0;k<sizewidth;k++){
                if(map1[j][k] == 2) {
                    g.setColor(Color.black);
                    g.fillRect(xMap+k*size, yMap+j*size, 24, 24);
                }
            }
        }
    }
    public void setxMap(int i) {
        xMap = i;
        if(xMap < minx) xMap = minx;
        if(xMap > maxx) xMap = maxx;
    }
    public void setyMap(int i) {
        yMap = i;
        if(yMap < miny) yMap = miny;
        if(yMap > maxy) yMap = maxy;
    }
    public int getColTile(int x){
        return x/size;
    }
    public int getRowTile(int y){
        return y/size;
    }
    // sử lí bitmap , map = 1 là không thể di chuyển qua
    public int binary(int a){
        return Integer.parseInt(Integer.toBinaryString(a))%10;
   }
    public int getTile(int x,int y){
        return binary(map1[x][y]);
    }
}
