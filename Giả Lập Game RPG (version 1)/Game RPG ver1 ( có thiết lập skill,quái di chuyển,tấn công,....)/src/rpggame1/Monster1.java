/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static rpggame1.KPanel.animation;
import static rpggame1.KPanel.map;
import static rpggame1.KPanel.mon1;
import static rpggame1.KPanel.p;
import static rpggame1.PMain.DELTA_TIME;

/**
 *
 * @author KirrNguyen
 */
public class Monster1 {
    double SPEED = 0.3; // tốc độ chuẩn
    double speed = SPEED; // tốc độ biến thiên
    int size = 24;// kích thước
    int maxmove = 150; 
    int HP = 100; // máu tối đa
    int hp = HP; // máu còn lại
    double move = 0; // biến tính khoảng cách
    int timeback = 2; // thời gian nghỉ khi đổi chiều di chuyển
    double x,y,X,Y; // X Y là tọa độ chuẩn ban đầu
    int vector = 1; // hướng di chuyển
    boolean atk = false; // kiểm tra có đang trong phạm vi tấn công
    boolean move1 = true; // kiểm tra xem có ở trong vị trí ban đầu không
    
    boolean alive = true; // còn sống ?
    boolean heart = false; // bị tấn công ?
    boolean frozen = false; // bị đóng băng
    boolean fire = false; // animation
    boolean  fireing = false; //đang bị hiệu ứng cháy
    
    public static long notheart;
    int timeHeart = 3; // thời gian bị tấn công / 10 
    
    
    Image i1,i2,i3;
    int id; // 0 = ngang,1 = dọc     
    public static int spawnEnemy = 60; // thời gian refrest quái 
    public static long timespawn; // delta thời gian refrest quái
    public static int downhptime = 5; // mất máu theo thời gian
    
    long deltafrozen = 0; // biến delta tính thời gian đóng băng
    int timefrozen = 20; // thời gian đóng băng = 1/10 giây
    long deltafire = 0; // biến delta tính thời gian fire
    int timefire = 10; // thời gian fire = 1/10 giây
    long deltafireing = 0; // biến delta tính thời gian thiêu đốt
    int timefireing = 50; // thời gian thiêu đốt = 1/10 giây
    
    
    public Monster1(int x,int y,int maxmove,int id){
        this.x = x*24;
        this.y = y*24;
        this.X = x;
        this.Y = y;
        this.maxmove = maxmove;
        this.id = id;
        i1 = getImageIcon("m400");
        i2 = getImageIcon("m410");
        i3 = getImageIcon("thieudot"); // hiệu ứng phụ
    }
    private Image getImageIcon(String name) {
        Image image = new ImageIcon(getClass().getResource(
                "/Image/" + name + ".png")).getImage();
        Icon icon = new ImageIcon(image);
        return image;
    }
    public void update(){
        // di chuyển sang phải, trái phải
        if(!atk){
            if(move1){
                if(move >= maxmove || move <= -maxmove){
                    sumoftime++;
                    if(sumoftime == timeback * 100){
                        sumoftime=0;
                        speed *= -1;
                        vector *= -1;
                        move = 0;
                    }      
                }else{
                    if(id == 0)
                        x += speed;
                    else
                        y += speed;
                    move += speed;
                }
            }else{
                // di chuyển về tọa độ chuẩn ban đầu
                if((int)  x + map.xMap < X*24 + map.xMap){
                    if(speed < 0) speed *= -1;
                    if(vector < 0) vector *= -1;
                    x += speed * 2;
                }
                if((int)  x + map.xMap > X*24  + map.xMap){
                    if(speed > 0) speed *= -1;
                    if(vector > 0) vector *= -1;
                    x -= speed* 2;
                }
                if((int)  y + map.yMap < Y*24  + map.yMap){
                    if(speed < 0) speed *= -1;
                    y += speed* 2;
                }
                if((int)  y + map.yMap > Y*24  + map.yMap){
                    if(speed > 0) speed *= -1;
                    y -= speed* 2;
                }
                
                if((int) x >= X*24 && (int) y >= Y*24){
                    move1 = true;
                    if(speed < 0) speed *= -1;
                }
            }
            
        }else{
            // nếu thấy trong phạm vi tấn công thì di chuyển
            if(speed < 0) speed *= -1; // đéo hiểu dòng này để làm cl gì 
            if(x + map.xMap <= p.x + map.xMap - 24/2){
                if(speed < 0) speed *= -1;
                if(vector < 0) vector *= -1;
                x += speed*2;
            }
            if(x + map.xMap >= p.x + map.xMap - 24/2){
                if(speed > 0) speed *= -1;
                if(vector > 0) vector *= -1;
                x += speed*2;
            }
            if(y + map.yMap <= p.y + map.yMap - 24/2){
                if(speed < 0) speed *= -1;
                y += speed*2;
            }
            if(y + map.yMap >= p.y + map.yMap - 24/2){
                if(speed > 0) speed *= -1;
                y += speed*2;
            }
        }
        
        if(hp <= 0){
            alive = false;
        }
        if(DELTA_TIME - notheart >= timeHeart * 100){
            heart = false;
        }
        checkFire();
        checkFireing();
        checkFrozen();
        downhpFireing();
    }
    // thoát khỏi đóng băng
    public void outFrozen(){
        maxmove = 150;
        speed = SPEED;
        deltafrozen = 0;
        frozen = false;
    }
    // tự thoát đóng băng sau 1 khoảng thời gian
    public void checkFrozen(){
        if(frozen){
            if(deltafrozen != 0 && DELTA_TIME - deltafrozen >= timefrozen*100){
                outFrozen();
            }
        }
    }
    // kiểm tra animation
    public void checkFire(){
        if(fire){
            if(deltafire != 0 && DELTA_TIME - deltafire >= timefire*100){
                deltafire = 0;
                fire = false;
            }
        }
    }
    // loại bỏ hiệu ứng ngay lập tức
    public void outFireing(){
        deltafireing = 0;
        fireing = false;
    }
    // hiệu ứng thiêu đốt theo thời gian
    public void checkFireing(){
        if(fireing){
            if(deltafireing != 0 && DELTA_TIME - deltafireing >= timefireing*100){
                outFireing();
            }
        }
    }
    // trừ máu theo thời gian
    int timeline = 0;
    int sumoftime = 0;
    public void downhpFireing(){
         if(fireing){
                sumoftime++;
                if(sumoftime == 100){
                    timeline++;
                    sumoftime=0;
                    hp-=downhptime;
                    //System.out.println(timeline+"s");
            }
         }
    }
    public void setHeart(int i){
        heart = true;
        animation.settingHeart((int) mon1.get(i).x + map.xMap, (int) mon1.get(i).y + map.xMap);
        notheart = System.currentTimeMillis();
    }
    public int percenHP(int Hp,int hp){
        double percel = (double) (10000 / Hp  * hp) /400;
        return (int) percel;
    }
    public void render(Graphics g){
        /// draw hp
        g.setColor(Color.black);
        g.fillRect((int) x + map.xMap,(int) y + map.yMap - 7, size , 5);
        g.setColor(Color.green);
        g.fillRect((int) x + map.xMap,(int) y + map.yMap - 7, percenHP(HP, hp) , 5);
        ///
        
        ///  hiệu ứng thiêu đốt
        if(fireing){
            g.drawImage(i3, (int) x + map.xMap - 12,(int) y + map.yMap - 7, null);
            animation.renderHeart(g);
        }
            
        
        ///////////////////////////////
        g.setColor(Color.BLACK);
        //g.fillRect((int) x + map.xMap,(int) y + map.yMap, size, size);
                // draw tại tâm đáy ( x + 12,y + 24)
                // code x va y : 
                //   xMap+k*size + 12 - i3.getWidth(null)/2, yMap+j*size + 24 - i3.getHeight(null)
        if(vector > 0){
            g.drawImage(i1,(int) (x + map.xMap + 12 - i1.getWidth(null)/2),
                    (int) (y + map.yMap + 24 - i1.getHeight(null)), null);
        }else{
            g.drawImage(i2,(int) (x + map.xMap + 12 - i2.getWidth(null)/2),
                    (int) (y + map.yMap + 24 - i2.getHeight(null)), null);
        }
        ///////////////////////////////
        
        
        
        /////////////////////////
        for(int i = 0;i<mon1.size();i++){
            if(mon1.get(i).heart){
               animation.renderHeart(g);
            }
        }
        if(frozen){ // 2 giây đóng băng
            speed = 0;
            animation.renderFrozen(g);
        }
        //////////////////////////
        
        /////////////////////////
        //phạm vi tấn công
        g.setColor(Color.red);
        g.drawRect((int)x + map.xMap - 24 * 4 + i1.getWidth(null)/2,
                (int) y + map.yMap - 24 * 4 + i1.getHeight(null)/2
                , 24 * 8, 24 * 8);
        
    }
    public Rectangle getBound(){
        Rectangle bound = new Rectangle();
        bound.x =(int) x + map.xMap;
        bound.y =(int) y + map.yMap;
        bound.width = 24;
        bound.height = 24;
        return bound;
    }
    public Rectangle getBoundAttack(){
        Rectangle bound = new Rectangle();
        bound.x =(int) (x + map.xMap - 24 * 4 + i1.getWidth(null)/2);
        bound.y =(int) (y + map.yMap - 24 * 4 + i1.getHeight(null)/2);
        bound.width = 24 * 8;
        bound.height = 24 * 8;
        return bound;
    }
}
