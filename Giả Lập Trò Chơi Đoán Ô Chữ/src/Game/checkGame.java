/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static Main.Connecting.conn;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author KirrNguyen
 */
public class checkGame {
    Statement stmt = null;
    ResultSet rs = null;
    public void check(String s,int vitri){
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from datagame");
            int i = 0;
            for(int j = 0;j<vitri;j++){
                rs.next();
            }
            //String dapan = rs.getString(4);
                if(rs.getString(4).equals(s)){
                    i++;
                }
//            while (rs.next()) {
//                String dapan = rs.getString(4);
//                if(dapan.equals(s)){
//                    i++;
//                }
//            }
            if(i == 0){
                System.out.println("dap an sai");
            }else {
                System.out.println("dap an dung");
            }
        }catch(Exception ex){
            System.out.println("opendata");
        }
    }
}
