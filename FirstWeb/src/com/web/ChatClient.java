package com.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Scanner;

public class ChatClient {
	private Socket socket = null;
	private InputStream inStream = null;
	private OutputStream outStream = null;
	Scanner scan = null;
	String message;
	public void createSocket() throws UnknownHostException, IOException{
		//exclicit socket creation
		socket = new Socket("10.102.49.139", 2000);
		inStream = socket.getInputStream();
		outStream = socket.getOutputStream();
		createReadThread();
		createWriteThread();
	}

	private void createWriteThread() {
		scan = new Scanner(System.in);
		Thread writeThread = new Thread(){
			public void run(){
				while(socket.isConnected()){
					try{
					System.out.println("Enter message : ");
					message=scan.nextLine();
					if(message!=null && message.length()>0){
						synchronized (message) {
							outStream.write(message.getBytes("UTF-8"));
						}
					}
					}catch(IOException io){}
					//catch(){}
				}
			}
		};
		writeThread.setPriority(Thread.MAX_PRIORITY);
		writeThread.start();
		
	}

	private void createReadThread() {
		Thread t = new Thread(){
			public void run(){
				while(socket.isConnected()){
					try{
					byte bytearr[] = new byte[200];
					int n =inStream.read(bytearr);
					if(n>0){
						byte[] arrayBytes = new byte[n];
						System.arraycopy(bytearr, 0, arrayBytes, 0, n);
						String recvedMessage = new String(arrayBytes, "UTF-8");
						/*StringWriter writer = new StringWriter();
						IOUtils.copy(inStream, writer, "UTF-8");
						String theString = writer.toString();*/
						System.out.println("Received message :" + recvedMessage);
					}}
					catch(SocketException S){
						
					}catch(IOException io){
						
					}
				}
				
			}
			
		};

		t.setPriority(Thread.MAX_PRIORITY);
		t.start();	
		
		
	}
}
