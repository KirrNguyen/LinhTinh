/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ns_1_2_map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static ns_1_2_map.KPanel.arr;
import static ns_1_2_map.KPanel.send;
import static ns_1_2_map.KPanel.x;
import static ns_1_2_map.KPanel.y;

/**
 *
 * @author KirrNguyen
 */
public class Draw {
    Image i;
    int x,y;
    Image i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,
            i20,i21,i22,i23,i24,i25,i26;
    public Draw(){
        setup();
    }
    public void update(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void renderx(Graphics g2){
        for(int i = 0;i<50;i++){
                for(int j = 0; j < 29 ; j++){
                    if(arr[j][i] == 100){
                        g2.drawImage(i26, i*24, j*24, null);
                    }else if(arr[j][i] == 99){
                        g2.drawImage(i26, i*24, j*24, null);
                    }
                }
        }
    }
    public void render(Graphics g2){
        for(int i = 0;i<50;i++){
                for(int j = 0; j < 29 ; j++){
                    if(arr[j][i] == 0){
                        g2.drawImage(i1, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i1.getWidth(null), i1.getHeight(null));
                    }
                }
            }
        
    }
    public void render2(Graphics g2){
        for(int i = 0;i<50;i++){
            for(int j = 0; j < 29 ; j++){
                if(arr[j][i] == 6){
                    g2.drawImage(i4,i*24,j*24, null);
                }else if(arr[j][i] == 4){
                    g2.drawImage(i3,i*24,j*24, null);
                }else if(arr[j][i] == 8){
                        g2.drawImage(i5, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i5.getWidth(null), i5.getHeight(null));
                    }else if(arr[j][i] == 10){
                        g2.drawImage(i7, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i7.getWidth(null), i7.getHeight(null));
                    }else if(arr[j][i] == 14){
                        g2.drawImage(i9, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i9.getWidth(null), i9.getHeight(null));
                    }else if(arr[j][i] == 16){
                        g2.drawImage(i10, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i10.getWidth(null), i10.getHeight(null));
                    }else if(arr[j][i] == 18){
                        g2.drawImage(i11, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i11.getWidth(null), i11.getHeight(null));
                    }else if(arr[j][i] == 20){
                        g2.drawImage(i12, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i12.getWidth(null), i12.getHeight(null));
                    }else if(arr[j][i] == 22){
                        g2.drawImage(i13, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i13.getWidth(null), i13.getHeight(null));
                    }else if(arr[j][i] == 24){
                        g2.drawImage(i20, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i20.getWidth(null), i20.getHeight(null));
                    }else if(arr[j][i] == 26){
                        g2.drawImage(i21, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i21.getWidth(null), i21.getHeight(null));
                    }else if(arr[j][i] == 28){
                        g2.drawImage(i22, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i22.getWidth(null), i22.getHeight(null));
                    }else if(arr[j][i] == 30){
                        g2.drawImage(i23, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i23.getWidth(null), i23.getHeight(null));
                    }else if(arr[j][i] == 32){
                        g2.drawImage(i24, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i24.getWidth(null), i24.getHeight(null));
                    }else if(arr[j][i] == 34){
                        g2.drawImage(i25, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i25.getWidth(null), i25.getHeight(null));
                    }
            }
        }
    }
    public void render3(Graphics g2){
        //+ 12 - i3.getWidth(null)/2,  + 24 - i3.getHeight(null)
        for(int i = 0;i<50;i++){
                for(int j = 0; j < 29 ; j++){
                    if(arr[j][i] == 1){
                        g2.drawImage(i6, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i6.getWidth(null), i6.getHeight(null));
                        
                    }else if(arr[j][i] == 6){
                        g2.drawImage(i4, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i4.getWidth(null), i4.getHeight(null));
                    }else if(arr[j][i] == 3){
                        g2.drawImage(i14, i*24 + 12 - i14.getWidth(null)/2, j*24 + 24 - i14.getHeight(null), null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect( i*24 + 12 - i14.getWidth(null)/2, j*24 + 24 - i14.getHeight(null), i14.getWidth(null), i14.getHeight(null));
                
                    }else if(arr[j][i] == 5){
                        g2.drawImage(i15, i*24 + 12 - i15.getWidth(null)/2, j*24 + 24 - i15.getHeight(null), null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24 + 12 - i15.getWidth(null)/2, j*24 + 24 - i15.getHeight(null), i15.getWidth(null), i15.getHeight(null));
                    }else if(arr[j][i] == 7){
                        g2.drawImage(i16, i*24+ 12 - i16.getWidth(null)/2, j*24 + 24 - i16.getHeight(null), null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24+ 12 - i16.getWidth(null)/2, j*24 + 24 - i16.getHeight(null), i16.getWidth(null), i16.getHeight(null));
                    }else if(arr[j][i] == 9){
                        g2.drawImage(i17, i*24+ 12 - i17.getWidth(null)/2, j*24 + 24 - i17.getHeight(null), null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24+ 12 - i17.getWidth(null)/2, j*24 + 24 - i17.getHeight(null), i17.getWidth(null), i17.getHeight(null));
                    }else if(arr[j][i] == 11){
                        g2.drawImage(i18, i*24+ 12 - i18.getWidth(null)/2, j*24 + 24 - i18.getHeight(null), null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24+ 12 - i18.getWidth(null)/2, j*24 + 24 - i18.getHeight(null), i18.getWidth(null), i18.getHeight(null));
                    }else if(arr[j][i] == 12){
                        g2.drawImage(i8, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i8.getWidth(null), i8.getHeight(null));
                    }else if(arr[j][i] == 13){
                        g2.drawImage(i19, i*24+ 12 - i19.getWidth(null)/2, j*24 + 24 - i19.getHeight(null), null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24+ 12 - i19.getWidth(null)/2, j*24 + 24 - i19.getHeight(null), i19.getWidth(null), i19.getHeight(null));
                    }else if(arr[j][i] == 2){
                        g2.drawImage(i2, i*24, j*24, null);
                        g2.setColor(Color.BLACK);
                        g2.drawRect(i*24, j*24, i2.getWidth(null), i2.getHeight(null));
                    }else if(arr[j][i] == 99){
                        g2.setColor(Color.red);
                        g2.drawRect(i*24, j*24, 24, 24);
                    }
                }
        }
    }
    private Image getImageIcon(String name) {
        Image image = new ImageIcon(getClass().getResource(
                "/Image/" + name + ".png")).getImage();
        Icon icon = new ImageIcon(image);
        return image;
    }
    public void setup(){
        i1 = getImageIcon("f00");
        i2 = getImageIcon("f01");
        i3 = getImageIcon("f02");
        i4 = getImageIcon("f03");
        i5 = getImageIcon("f04");
        i6 = getImageIcon("f05");
        i7 = getImageIcon("f06");
        i8 = getImageIcon("f07");
        i9 = getImageIcon("f08");
        i10 = getImageIcon("f09");
        i11 = getImageIcon("f10");
        i12 = getImageIcon("f11");
        i13 = getImageIcon("f12");
        i14 = getImageIcon("f13");
        i15 = getImageIcon("f14");
        i16 = getImageIcon("f15");
        i17 = getImageIcon("f16");
        i18 = getImageIcon("f17");
        i19 = getImageIcon("f18");
        i20 = getImageIcon("f19");
        i21 = getImageIcon("f20");
        i22 = getImageIcon("f21");
        i23 = getImageIcon("f22");
        i24 = getImageIcon("f23");
        i25 = getImageIcon("f24");
        i26 = getImageIcon("block");
        
    }
}
