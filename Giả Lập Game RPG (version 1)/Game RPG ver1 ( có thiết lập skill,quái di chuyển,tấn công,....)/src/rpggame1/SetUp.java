/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame1;

import static rpggame1.KPanel.mon1;
import static rpggame1.KPanel.mon2;


/**
 *
 * @author KirrNguyen
 */
public class SetUp {
    public SetUp(){
        
        Monster1 m1 = new Monster1(18, 5, 150,0);
        Monster1 m2 = new Monster1(16, 7, 180,0);
        Monster1 m3 = new Monster1(14, 9, 130,1);
        Monster1 m4 = new Monster1(30, 9, 0,0);
        Monster1 m5 = new Monster1(30, 10, 0,0);
        Monster1 m6 = new Monster1(30, 11, 0,0);
        Monster1 m7 = new Monster1(30, 12, 0,0);
        Monster1 m8 = new Monster1(42, 9, 0,0);
        Monster1 m9 = new Monster1(41, 10, 0,0);
        Monster1 m10 = new Monster1(43, 10, 0,0);
        Monster1 m11 = new Monster1(40, 11, 0,0);
        Monster1 m12 = new Monster1(44, 11, 0,0);
        Monster1 m13 = new Monster1(41, 12, 0,0);
        Monster1 m14 = new Monster1(43, 12, 0,0);
        Monster1 m15 = new Monster1(42, 13, 0,0);
        
        
        
        mon1.add(m1);
        mon1.add(m2);
        mon1.add(m3);
        mon1.add(m4);
        mon1.add(m5);
        mon1.add(m6);
        mon1.add(m7);
        mon1.add(m8);
        mon1.add(m9);
        mon1.add(m10);
        mon1.add(m11);
        mon1.add(m12);
        mon1.add(m13);
        mon1.add(m14);
        mon1.add(m15);
        
        Monster2 m16 = new Monster2(20, 17, 150,0);
        Monster2 m17 = new Monster2(18, 15, 150,1);
        mon2.add(m16);
        mon2.add(m17);
    }
    public void refresh(){
        mon1.clear();
        mon2.clear();
        new SetUp();
    }
}
