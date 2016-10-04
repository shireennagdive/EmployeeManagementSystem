package com.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	ServerSocket serversocket = null;
	Socket socket=null;
	InputStream inputStream=null;
	OutputStream outputStream=null;
	Scanner scan=null;
	public void createSocket(){
		try{
		serversocket = new ServerSocket(3339);	
		socket = serversocket.accept();//gives us socket //implicitly creating a socket
		
		inputStream = socket.getInputStream();
		outputStream = socket.getOutputStream();
		System.out.println("conected!!");
		readThread();
		writeThread();
		}catch(IOException io){
			
		}
		
	}
public void readThread(){
	
}

public void writeThread(){
	Thread wthread = new Thread(){
		public void run(){
		scan= new Scanner(System.in);
		try{
			System.out.println("Enter message to send : ");
			message=scan.ne
		}catch(IOException){}
		}
	};
}

}
