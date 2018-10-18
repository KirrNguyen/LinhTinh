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
public class RegisterUser {
    //Connecting cn = new Connecting();
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ptmt = null;
    public void Register(String username,String password,String name,
                        String phone,String email,String cmnd){
        //cn.Connected();
        String insert = "insert into rguser values(?,?,?,?,?,?,?,?)";
        try {
                ptmt = conn.prepareStatement(insert);
                ptmt.setString(1, username);
                ptmt.setString(2, password);
                ptmt.setString(3, name);
                ptmt.setString(4, phone);
                ptmt.setString(5, email);
                ptmt.setString(6, cmnd);
                ptmt.setInt(7, 5);
                ptmt.setString(8, "chưa là thành viên");
                int kt = ptmt.executeUpdate();
                if(kt != 0){
                    JOptionPane.showMessageDialog(null, "đã gửi đăng kí");
                }else System.out.println("them khong thanh cong");
                ptmt.close();
            } catch (SQLException ex) {}
//        try {
//            cn.Close();
//        } catch (SQLException ex) {}
    }
    public void sendRegister(String username,String password,String name,
                        String phone,String email,String cmnd){
        //cn.Connected();
        if(username.equals("")) 
            JOptionPane.showMessageDialog(null, "Nhập username");
        else if (password.equals(""))
            JOptionPane.showMessageDialog(null, "Nhập password");
        else if (password.equals(""))
            JOptionPane.showMessageDialog(null, "Nhập Họ và Tên");
        else if (password.equals(""))
            JOptionPane.showMessageDialog(null, "Nhập Số Điện Thoại");
        else if (password.equals(""))
            JOptionPane.showMessageDialog(null, "Nhập Email");
        else if (password.equals(""))
            JOptionPane.showMessageDialog(null, "Nhập Số cmnd");
        else if(check(username)){
            Register(username, password,name,phone,email,cmnd);
        }
//        try {
//            cn.Close();
//        } catch (SQLException ex) {}
    }
    public boolean check(String username){
        //cn.Connected();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser");
            while (rs.next()) {
                    String name1 = rs.getString(1);
                    if(username.equals(name1)) {
                        JOptionPane.showMessageDialog(null, "Tên đã tồn tại");
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
