package com.web;

import java.io.IOException;

public class Main {
public static void main(String[] args) {
	ChatClient chat = new ChatClient();
	try {
		chat.createSocket();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
