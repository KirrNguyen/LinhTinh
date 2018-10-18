/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Connecting;
import GUI.InformationForm;
import GUI.LoginForm;
import GUI.MainForm;
import GUI.UserBorrowForm;
import java.sql.SQLException;

/**
 *
 * @author KirrNguyen
 */
public class UserControl {
    Connecting cn = new Connecting();
    public void Borrow(){
    try{
            MainForm.PanelMain.removeAll();
        }catch(Exception ex){}
        UserBorrowForm userborrowform = new UserBorrowForm();
        userborrowform.setBounds(5, 5, 780, 480);
        userborrowform.View();
        MainForm.PanelMain.add(userborrowform);
        MainForm.PanelMain.repaint();
        userborrowform.start();
    }
    public void Logout(){
        try{
            MainForm.PanelMain.removeAll();
        }catch(Exception ex){}
        finally{
            try {
                cn.Close();
            } catch (SQLException ex) {}
        }
        LoginForm loginform = new LoginForm();
        loginform.setBounds(5, 5, 780, 480);
        MainForm.PanelMain.add(loginform);
        MainForm.PanelMain.repaint();
        loginform.start();
    }
    public void Infor(){
        try{
            MainForm.PanelMain.removeAll();
        }catch(Exception ex){}
        InformationForm informationform = new InformationForm();
        informationform.setBounds(5, 5, 780, 480);
        MainForm.PanelMain.add(informationform);
        MainForm.PanelMain.repaint();
        informationform.start();
    }
}
