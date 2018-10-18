/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import static Entity.Connecting.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author KirrNguyen
 */
public class BorrowList extends Connecting{
    //Connecting cn = new Connecting();
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ptmt = null;
    public boolean update(String name){
        //cn.Connected();
        String Updatebook = "update book set conlai = ? where bookname = ?";
        try {    
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from book where bookname = '"+name+"'");
            while(rs.next()){
                if(rs.getString(1).equals(name)){
                    if(rs.getInt(4) == 0){
                        JOptionPane.showMessageDialog(null, "hết sách");
                        return false;
                    }else {
                        int conlai = rs.getInt(4) - 1;
                        ptmt = conn.prepareStatement(Updatebook);
                        ptmt.setInt(1, conlai);
                        ptmt.setString(2, name);
                        int kt = ptmt.executeUpdate();
                        if(kt != 0){
                            //JOptionPane.showMessageDialog(null, "thêm thành công");
                        }
                        ptmt.close();
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("update");
        }
//        try {
//            cn.Close();
//        } catch (SQLException ex) {}
        return true;
    }
    public void accept(String username,String namebook){
        //cn.Connected();
        String insert = "insert into borrowbook values(?,?)";
        try {
                ptmt = conn.prepareStatement(insert);
                ptmt.setString(1, username);
                ptmt.setString(2, namebook);
                int kt = ptmt.executeUpdate();
                if(kt != 0){
                    JOptionPane.showMessageDialog(null, "Đã Chấp Nhận Đăng Kí");
                }
                ptmt.close();
            } catch (SQLException ex) {
                System.out.println("accept");
            }
//        try {
//            cn.Close();
//        } catch (SQLException ex) {}
    }
    public void delete(String username,String bookname){
        //cn.Connected();
        String delete = "delete from registerbook where username = ? and bookname = ?";
        try {
            ptmt = conn.prepareStatement(delete); // hàm xóa 
            ptmt.setString(1,username);  // cột 0 trong bảng ứng cột 1 trong data
            ptmt.setString(2,bookname);
            ptmt.execute();
            int kt = ptmt.executeUpdate();
                if(kt != 0){
                    JOptionPane.showMessageDialog(null, "Đã Xóa Đăng Kí");
                }
        } catch (SQLException ex) {
            System.out.println("delete");
        }
//        try {
//            cn.Close();
//        } catch (SQLException ex) {}
    }
    public boolean check(String username,String namebook){
        //cn.Connected();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from borrowbook");
            while (rs.next()) {
                    String name1 = rs.getString(1);
                    String name2 = rs.getString(2);
                    if(username.equals(name1) && namebook.equals(name2)) {
                        JOptionPane.showMessageDialog(null, "Người dùng đã đăng kí,không thể đăng kí thêm");
                        return false;
                    }
            }
        } catch (SQLException ex) {
            System.out.println("check");
        }
//        try {
//            cn.Close();
//        } catch (SQLException ex) {}
        return true;
    }
}
