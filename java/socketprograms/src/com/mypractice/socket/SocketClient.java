package com.mypractice.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SocketClient {
	public static void main(String[] args) throws Exception {
		Socket socket =  new Socket("127.0.0.1", 6000);
		DataInputStream  input = new DataInputStream(System.in);
		DataOutputStream  out = new DataOutputStream(socket.getOutputStream());
		String line = "";
        while (!line.equals("EXIT")) {
                line = input.readLine(); //readUTF()
                out.writeUTF(line);
        }
        input.close();
        out.close();
        socket.close();
	}
}
