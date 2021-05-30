package main.java.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static final String HOST = "localhost";
    public static final int PORT = 5000;

    public final Socket SOCKET;
    public final DataInputStream DATA_INPUT_STREAM;
    public final DataOutputStream DATA_OUTPUT_STREAM;

    public Client() throws IOException {
        System.out.println("Connecting to " + HOST + ":" + PORT);
        this.SOCKET = new Socket(HOST, PORT);
        System.out.println("Connected to " + SOCKET.getRemoteSocketAddress());

        this.DATA_INPUT_STREAM = new DataInputStream(SOCKET.getInputStream());
        this.DATA_OUTPUT_STREAM = new DataOutputStream(SOCKET.getOutputStream());
    }

    public void sendRequest(String text) {
        try {
            DATA_OUTPUT_STREAM.writeUTF(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getResponse() {
        try {
            return DATA_INPUT_STREAM.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public int getResponseInt() {
        try {
            return Integer.parseInt(DATA_INPUT_STREAM.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
