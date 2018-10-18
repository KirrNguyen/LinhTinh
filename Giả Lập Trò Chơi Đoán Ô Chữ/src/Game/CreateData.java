/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static Game.MouseListen.Newgame;
import static Main.Connecting.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author KirrNguyen
 */
public class CreateData {
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ptmt = null;
    public boolean CheckTable(String s){
        int i = 0;
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from tablename");
            while(rs.next()){
                if(rs.getString(1).equals(s)){
                    i++;
                    return false;
                }
            }
        }catch(Exception ex){
            System.out.println("opendata");
        }
        return true;
//        if(i == 0){
//            System.out.println("true");
//            return true;
//        }else{
//            //JOptionPane.showMessageDialog(null, "Tên Đã Tồn Tại");
//            return false;
//        }
    }
    public void CreateTable(String s){
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE ["+s+"](\n" +
                        "  [stt] INT(15), \n" +
                        "  [vitri] INT(15), \n" +
                        "  [cot] INT(15), \n" +
                        "  [dapan] VARCHAR(45), \n" +
                        "  [ques1] VARCHAR(45), \n" +
                        "  [ques2] VARCHAR(45), \n" +
                        "  [ques3] VARCHAR(45));";
            stmt.executeUpdate(sql);
            
            String insert = "insert into tablename values(?)";
            ptmt = conn.prepareStatement(insert);
            ptmt.setString(1, s);
            int kt = ptmt.executeUpdate();
                if(kt != 0){
                    JOptionPane.showMessageDialog(null, "Đã thêm");
            }else System.out.println("them khong thanh cong");
            ptmt.close();
            
        } catch (SQLException ex) {
            System.out.println("CreateTable");
        }
    }
    public void CreateNewData(String s,Ochu ochu){
        String insert = "insert into "+s+" values(?,?,?,?,?,?,?)";
            try {
                    ptmt = conn.prepareStatement(insert);
                    for(int i = 0;i<ochu.size;i++){
                        ptmt.setInt(1, i++);
                        ptmt.setInt(2, ochu.x / 24);
                        ptmt.setInt(3, ochu.size);
                        ptmt.setString(4, ochu.s);
                        ptmt.setString(5, ochu.ques1);
                        ptmt.setString(6, ochu.ques2);
                        ptmt.setString(7, ochu.ques3);
                    }
                    
                    int kt = ptmt.executeUpdate();
                    if(kt != 0){
                        //JOptionPane.showMessageDialog(null, "Đã thêm");
                    }else System.out.println("them khong thanh cong");
                    ptmt.close();
                } catch (SQLException ex) {
                        System.out.println("CreateNewData");
                }
    }
    public void CreateColumn(String s){
        String insert = "insert into "+s+" values(?,?,?,?,?,?,?)";
            try {
                    ptmt = conn.prepareStatement(insert);
                        ptmt.setInt(1, 0);
                        ptmt.setInt(2, Newgame.colunm);
                        ptmt.setInt(3, Newgame.Ochu.size());
                        ptmt.setString(4, Newgame.getColString(Newgame.colunm));
                        ptmt.setString(5, "");
                        ptmt.setString(6, "");
                        ptmt.setString(7, "");
                    
                    
                    int kt = ptmt.executeUpdate();
                    if(kt != 0){
                        
                    }else System.out.println("them khong thanh cong");
                    ptmt.close();
                } catch (SQLException ex) {
                        System.out.println("CreateNewData");
            }
    }
    
}
