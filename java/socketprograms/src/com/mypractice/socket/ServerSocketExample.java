package com.mypractice.socket;

import java.net.*;
import java.io.*;

public class ServerSocketExample {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(6000);
		Socket socket = server.accept();
		DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		String line = "";
		while (!line.equals("EXIT")) {
			line = in.readUTF();
			System.out.println(line);
		}
		System.out.println("Closing connection");
		socket.close();
		server.close();
	}

}
