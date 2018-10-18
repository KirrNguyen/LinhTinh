/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Connecting;
import GUI.BookManageForm;
import GUI.BorrowManageForm;
import GUI.LoginForm;
import GUI.MainForm;
import GUI.ReturnManageForm;
import GUI.UserManageForm;
import java.sql.SQLException;

/**
 *
 * @author KirrNguyen
 */
public class ManageControl {
    Connecting cn = new Connecting();
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
    public void BookManage(){
        try{
            MainForm.PanelMain.removeAll();
        }catch(Exception ex){}
            BookManageForm bookmanageform = new BookManageForm();
            bookmanageform.setBounds(5, 5, 780, 480);
            bookmanageform.View();
            MainForm.PanelMain.add(bookmanageform);
            MainForm.PanelMain.repaint();
            bookmanageform.start();
    }
    public void UserManage(){
        try{
            MainForm.PanelMain.removeAll();
        }catch(Exception ex){}
            UserManageForm usermanageform = new UserManageForm();
            usermanageform.setBounds(5, 5, 780, 480);
            usermanageform.View();
            MainForm.PanelMain.add(usermanageform);
            MainForm.PanelMain.repaint();
            usermanageform.start();
    }
    public void BorrowManage(){
        try{
            MainForm.PanelMain.removeAll();
        }catch(Exception ex){}
            BorrowManageForm borrowmanageform = new BorrowManageForm();
            borrowmanageform.setBounds(5, 5, 780, 480);
            borrowmanageform.View();
            MainForm.PanelMain.add(borrowmanageform);
            MainForm.PanelMain.repaint();
            borrowmanageform.start();
    }
    public void ReturnManage(){
        try{
            MainForm.PanelMain.removeAll();
        }catch(Exception ex){}
            ReturnManageForm returnmanageform = new ReturnManageForm();
            returnmanageform.setBounds(5, 5, 780, 480);
            returnmanageform.View();
            MainForm.PanelMain.add(returnmanageform);
            MainForm.PanelMain.repaint();
            returnmanageform.start();
    }
}
