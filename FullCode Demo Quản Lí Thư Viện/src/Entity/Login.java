/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import static Entity.Connecting.conn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author KirrNguyen
 */
public class Login {
    
    public static String USERNAME;
    Statement stmt = null;
    ResultSet rs = null;
    public boolean LoginAdmin(String username,String password){
            if(username.equals("admin") && password.equals("admin")){
                return true;
        } 
        return false;
    }
    public boolean LoginUser(String username,String password){
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser");
            while (rs.next()) {
                    String name1 = rs.getString(1);  
                    String name2 = rs.getString(2);
                    if(username.equals(name1) && password.equals(name2)) {
                        USERNAME = name1;
                        return true;
                    }
                } 
            } catch (SQLException ex) {}
        return false;
    }
}
