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
public class AddNewBook {
        //Connecting cn = new Connecting();
        PreparedStatement ptmt = null;
        Statement stmt = null;
        ResultSet rs = null;
    public void SendRegister(String namebook,String writer,String soluong){
        //cn.Connected();
        if (namebook.equals(""))
            JOptionPane.showMessageDialog(null, "Nhập Tên Sách");
        else if (writer.equals(""))
            JOptionPane.showMessageDialog(null, "Nhập Tên Tác Giả");
        else if (soluong.equals(""))
            JOptionPane.showMessageDialog(null, "Nhập Số Lượng");
        else RegisterBook(namebook, writer, soluong);
//        try {
//                cn.Close();
//            } catch (SQLException ex) {}
    }
    public void RegisterBook(String namebook,String writer,String soluong){
        //cn.Connected();
        if(check(namebook)){
            String insert = "insert into book values(?,?,?,?)";
            try {
                    ptmt = conn.prepareStatement(insert);
                    ptmt.setString(1, namebook);
                    ptmt.setString(2, writer);
                    ptmt.setInt(3, Integer.parseInt(soluong));
                    ptmt.setInt(4, Integer.parseInt(soluong));
                    int kt = ptmt.executeUpdate();
                    if(kt != 0){
                        JOptionPane.showMessageDialog(null, "Đã thêm");
                    }else System.out.println("them khong thanh cong");
                    ptmt.close();
                } catch (SQLException ex) {}
        }
//            try {
//                cn.Close();
//            } catch (SQLException ex) {}
    }
    public boolean check(String namebook){
       // cn.Connected();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from book");
            while (rs.next()) {
                    String name1 = rs.getString(1);  
                    if(namebook.equals(name1)) {
                        JOptionPane.showMessageDialog(null, "Sách Đã Tồn Tại");
                        return false;
                    }
            }
        } catch (SQLException ex) {
            System.out.println("fail");
        }
//        try {
//                cn.Close();
//            } catch (SQLException ex) {}
        return true;
            
    }
}
