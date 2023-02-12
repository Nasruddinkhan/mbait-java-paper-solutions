package com.mypractice.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

	ArrayList<Socket> clients = new ArrayList<>();
	DataInputStream dataInputStream;
	DataOutputStream outputStream;

	public static void main(String[] args) throws Exception {
		new ChatServer().startServer();
	}

	public void startServer() throws Exception {
	
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("Server started at 9999");

			while (true) {
				Socket client = ss.accept();
				clients.add(client);
				System.out.println("Client connected: " + client);
				dataInputStream = new DataInputStream(client.getInputStream());
				outputStream = new DataOutputStream(client.getOutputStream());
				Thread t = new Thread(() -> {
					try {
						while (true) {
							String message = dataInputStream.readUTF();
							broadcast(message);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				t.start();
			}
		
	}

	public void broadcast(String message) throws IOException {
		for (Socket client : clients) {
			outputStream = new DataOutputStream(client.getOutputStream());
			outputStream.writeUTF(message);
		}
	}
}
