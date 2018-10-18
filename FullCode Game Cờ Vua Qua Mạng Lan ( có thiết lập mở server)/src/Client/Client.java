/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Game.KFrame;
import static Game.KPanel.m;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author KirrNguyen
 */
public class Client{
    static  Socket socket;
    public static  DataInputStream dis;
    public static  DataOutputStream dos;
    ThreadClien dataStream;
    int i = 0;
    public static KFrame frame;
    String nick;
    String IP;
    public Client(String IP,String nick){
        this.IP = IP;
        this.nick = nick;
        try{
            socket = new Socket(IP, 3393);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            
            add();
        }catch(Exception ex){
            
        }
        
    }
    public void add(){
        Scanner sn = new Scanner(System.in);
        try {
            
            if(checkLogin(nick)){
                dataStream = new ThreadClien(this, dis);
                frame = new KFrame();
            }
//            while (true) {
//                System.out.print("");
//                String message = sn.nextLine();
//                sendMSG("1");
//                sendMSG(message);
//            }
        } catch (Exception e) {
        }
    }
    private boolean checkLogin(String nick){
		if(nick.compareTo("")==0)
			return false;
		else if(nick.compareTo("0")==0){
			return false;
		}
		else{
			sendMSG(nick);
			int sst = Integer.parseInt(getMSG());
			if(sst==0)
				 return false;
			else return true;
		}
	}
    public void getMSG(String msg1, String msg2){
		int stt = Integer.parseInt(msg1);
		switch (stt) {
		// tin nhắn của những người khác
		case 3:
                    
                    i = Integer.parseInt(msg2);
                    System.out.println("print "+i);
                    if(i<10000){
                        m.in = i;
                    }else{
                        m.in2 = i;
                    }
                    
                    //m.setIn(Integer.parseInt(msg2)); 
                    //System.out.println(""+msg2);
		break;

		}
	}
    private void sendMSG(String data){
		try {
			dos.writeUTF(data);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private String getMSG(){
		String data=null;
		try {
			data=dis.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
        public int getI(){
            return i;
        }
    
}
