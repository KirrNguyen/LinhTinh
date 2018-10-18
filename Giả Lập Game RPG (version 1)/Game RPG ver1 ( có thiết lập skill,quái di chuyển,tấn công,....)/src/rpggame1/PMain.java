/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame1;

import javax.swing.JPanel;
import static rpggame1.KFrame.WINDOW_HEIGHT;
import static rpggame1.KFrame.WINDOW_WIDTH;
import static rpggame1.KFrame.kpanel;

/**
 *
 * @author KirrNguyen
 */
public class PMain extends JPanel implements Runnable{
    
    private int FPS = 100;
    private int Time = 1000/FPS;
    
    
    public static long DELTA_TIME; // lấy thời gian delta liên tục để update
    Thread thread;
    
    public PMain(){
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run(){
        long time1,time2,time3;
        kpanel.init();
        while(true){
            time1 = System.nanoTime();
            
            DELTA_TIME = System.currentTimeMillis();
            
            kpanel.update();
            kpanel.render();
            kpanel.draw();
            kpanel.reload();
            //repaint();
            time2 = (System.nanoTime() - time1)/1000000;
            time3 = Time - time2;
            try {
                if(time3 > 0)
                            Thread.sleep(time3);
                    else Thread.sleep(Time);
            } catch (InterruptedException ex) {
                System.out.println("sleep");       
            }
        }
    }
}
