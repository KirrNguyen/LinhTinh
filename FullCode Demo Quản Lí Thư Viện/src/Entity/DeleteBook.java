/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import static Entity.Connecting.conn;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author KirrNguyen
 */
public class DeleteBook {
    //Connecting cn = new Connecting();
    PreparedStatement ptmt = null;
    public void DeleteBook(String del){
        //cn.Connected();
        String delete = "delete from book where bookname = ?";
        try {
            ptmt = conn.prepareStatement(delete);
            ptmt.setString(1,del); 
            ptmt.execute();
        } catch (SQLException ex) {
            System.out.println("error");
        }
//        try {
//            cn.Close();
//        } catch (SQLException ex) {}
    }
}
