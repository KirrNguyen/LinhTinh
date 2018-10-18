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
public class UpdateInformation {
    //Connecting cn = new Connecting();
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ptmt = null;
    public void Update(String password,String name,String phone,String email,String cmnd,String username){
        //cn.Connected();
        String Update = "update rguser set password = ?, name = ?,phone = ?,email = ?,cmnd = ? where username = ?";
        try {    
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser where username = '"+username+"'");
            while(rs.next()){
                    int conlai = rs.getInt(3) - 1;
                    System.out.println(""+conlai);
                    ptmt = conn.prepareStatement(Update);
                    ptmt.setString(1,password);
                    ptmt.setString(2, name);
                    ptmt.setString(3, phone);
                    ptmt.setString(4, email);
                    ptmt.setString(5, cmnd);
                    ptmt.setString(6, username);
                    int kt = ptmt.executeUpdate();
                    if(kt != 0){
                        JOptionPane.showMessageDialog(null, "update thành công");
                    }
                    ptmt.close();
            }
        
        } catch (SQLException ex) {
            System.out.println("Update");
        }
//        try {
//            cn.Close();
//        } catch (SQLException ex) {}
    }
    public String getPassword(String username){
        //cn.Connected();
        String password = "";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser where username like '"+username+"'");
            while(rs.next()){
                    if(rs.getString(1).equals(username))
                        password = rs.getString(2);
                }
        } catch (SQLException ex) {
            System.out.println("getPassword");
        }
//        try {
//            cn.Close();
//        } catch (SQLException ex) {}
        return password;
    }
    public String getName(String username){
        //cn.Connected();
        String name = "";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser where username like '"+username+"'");
            while(rs.next()){
                    if(rs.getString(1).equals(username))
                        name = rs.getString(3);
                }
        } catch (SQLException ex) {
            System.out.println("getName");
        }
//        try {
//            cn.Close();
//        } catch (SQLException ex) {}
        return name;
    }
    public String getPhone(String username){
        //cn.Connected();
        String phone = "";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser where username like '"+username+"'");
            while(rs.next()){
                    if(rs.getString(1).equals(username))
                        phone = rs.getString(4);
                }
        } catch (SQLException ex) {
            System.out.println("getPhone");
        }
//        try {
//            cn.Close();
//        } catch (SQLException ex) {}
        return phone;
    }
    public String getEmail(String username){
        //cn.Connected();
        String email = "";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser where username like '"+username+"'");
            while(rs.next()){
                    if(rs.getString(1).equals(username))
                        email = rs.getString(5);
                }
        } catch (SQLException ex) {
            System.out.println("getEmail");
        }
//        try {
//            cn.Close();
//        } catch (SQLException ex) {}
        return email;
    }
    public String getCmnd(String username){
        //cn.Connected();
        System.out.println(""+username);
        String cmnd = "";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser where username like '"+username+"'");
            while(rs.next()){
                    if(rs.getString(1).equals(username))
                        cmnd = rs.getString(6);
                }
        } catch (SQLException ex) {
            System.out.println("getCmnd");
        }
//        try {
//            cn.Close();
//        } catch (SQLException ex) {}
        return cmnd;
    }
}
