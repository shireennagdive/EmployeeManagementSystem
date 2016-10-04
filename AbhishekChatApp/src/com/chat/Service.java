package com.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Service {
	public static void main(String args[]) throws IOException {
		ServerSocket serversocket = new ServerSocket(3339);
		Socket socket = null;
		while (true) {
			socket = serversocket.accept();
			new Thread(new Job()).start();

		}
	}
}
