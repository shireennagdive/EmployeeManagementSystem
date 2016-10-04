package com.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Job implements Runnable{
	private Socket socket=null;
	@Override
	public void run() {
		////to read message recieved
		new Thread(
			new Runnable(){
			public void run(){
				try{
				InputStream instream = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(instream));
				while(true){
					String s=br.readLine();
				}
				}catch(IOException io){
					
				}
				
				
				
			}	
			}
		).start();
		
		//to send our message
		new Thread(
				new Runnable() {
					
					@Override
					public void run() {
						try{
						OutputStream outstream = socket.getOutputStream();
						PrintWriter pw=new PrintWriter(outstream);
						pw.println();
						pw.flush();
						pw.close();
						}catch(IOException io){}
					}
				}
				).start();
		
	}

}
