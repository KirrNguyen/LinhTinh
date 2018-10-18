/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import sun.print.ServiceDialog;

/**
 *
 * @author KirrNguyen
 */
public class Server extends JFrame{
    static DataInputStream dis;
    static DataOutputStream dos;
    static Socket socket;
    public Hashtable<String, ThreadSever> listUser;
    JLabel label = new JLabel();
    JLabel label2 = new JLabel();
    public Server(){
        
        setBounds(0, 0, 400, 200);
        setVisible(true);
        setLayout(null);
        label.setBounds(100, 50, 200, 25);
        label.setText("Server Runninggggg ^^ !!!");
        
        label2.setBounds(100, 80, 200, 25);
        label2.setText(" Đừng tắt khi chơi =.=");
        
        add(label);
        add(label2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            
            System.out.println("server");
            ServerSocket serverSocket = new ServerSocket(3393);
           
            listUser = new Hashtable<String, ThreadSever>();
            while(true){
                Socket socket = serverSocket.accept();
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                new ThreadSever(this,socket);
                                
            }
            //System.out.println(""+dis.readUTF());
        }catch(Exception ex){
            
        }
    }
    public void sendAll(String msg){
		Enumeration e = listUser.keys();
		String name=null;
		while(e.hasMoreElements()){
			name=(String) e.nextElement();
                        listUser.get(name).sendMSG("3",msg);
//                        System.out.println("name = "+name+",msg "+msg);
		}
	}
	

	public String getAllName(){
		Enumeration e = listUser.keys();
		String name="";
		while(e. hasMoreElements()){
			name+=(String) e.nextElement()+"\n";
		}
		return name;
	} 
    
    public static void main(String[] args) {
        new Server();
    }
    
    
}
