/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.LoginForm;
import GUI.MainForm;

/**
 *
 * @author KirrNguyen
 */
public class RegisterControl {
    public void Back(){
        try{
            MainForm.PanelMain.removeAll();
        }catch(Exception ex){}
        LoginForm loginform = new LoginForm();
        loginform.setBounds(5, 5, 780, 480);
        MainForm.PanelMain.add(loginform);
        MainForm.PanelMain.repaint();
        loginform.start();
    }
}
