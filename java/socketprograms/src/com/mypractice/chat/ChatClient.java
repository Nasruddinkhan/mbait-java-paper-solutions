package com.mypractice.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	public static void main(String[] args) throws Exception {

		Socket client = new Socket("localhost", 6000);
		System.out.println("Connected to server");
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		Thread t = new Thread(() -> {
			try {
				while (true) {
					String message = dis.readUTF();
					System.out.println(message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		t.start();
		Scanner sc = new Scanner(System.in);
		while (true) {
			String message = sc.nextLine();
			dos.writeUTF(message);
		}
	}
}
