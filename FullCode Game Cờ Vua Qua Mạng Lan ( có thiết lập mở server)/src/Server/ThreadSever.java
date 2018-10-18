/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author binkyo
 */
public class ThreadSever extends Thread{
        public Socket socket;
	public Server server;
	private String nickName;
	private DataOutputStream dos;
	private DataInputStream dis;
	private boolean run;
        

	public ThreadSever(Server server, Socket client){
		try {
			this.server=server;
			this.socket=client;
			dos= new DataOutputStream(client.getOutputStream());
			dis= new DataInputStream(client.getInputStream());
			run=true;
			this.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
        @Override
	public void run(){
		// xữ lý đăng nhập
	String msg=null;
	while(run){
            nickName=getMSG();
            System.out.println("Nick Name: "+  nickName);

            server.listUser.put(nickName, this);
            sendMSG("1");
            while(run){
                int stt = Integer.parseInt(getMSG());
                switch(stt){
                    case 1:
                    msg = getMSG();
                    server.sendAll(msg);
                    break;
                }
            }

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
	public void sendMSG(String msg1,String msg2){
		sendMSG(msg1);
		sendMSG(msg2);
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
        
}
