package com.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String args[]) throws UnknownHostException, IOException{
		Socket socket = new Socket("localhost",3339);
		
		new Thread(new Job()).start();
	}
}
