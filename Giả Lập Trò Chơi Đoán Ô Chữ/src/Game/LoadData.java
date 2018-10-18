/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static Game.OpenGame.cot;
import static Game.OpenGame.dapan;
import static Game.OpenGame.ques1;
import static Game.OpenGame.ques2;
import static Game.OpenGame.ques3;
import static Game.OpenGame.stt;
import static Game.OpenGame.vitri;
import static Game.StartGame.namegame;
import static Main.Connecting.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author KirrNguyen
 */
public class LoadData {
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ptmt = null;
    public int LoadGame(){
        int sum = 0;
        try {    
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from TableName ");
            while(rs.next()){
                namegame.add(rs.getString(1));
                sum++;
            }
        } catch (SQLException ex) {
            System.out.println("update");
        }
        return sum;
    }
    public void opendata(String s){
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from "+s);
            while (rs.next()) {
                stt.add(rs.getInt(1));
                vitri.add(rs.getInt(2));
                cot.add(rs.getInt(3));
                dapan.add(rs.getString(4));
                ques1.add(rs.getString(5));
                ques2.add(rs.getString(6));
                ques3.add(rs.getString(7));
            }
        }catch(Exception ex){
            System.out.println("opendata");
        }
    }
}
