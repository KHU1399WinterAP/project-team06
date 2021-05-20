package main.java.app;

import main.java.socket.ClientHandler;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class AppManager {
    private static String chet = "";
    private static final ArrayList<ClientHandler> CLIENT_HANDLERS = new ArrayList<>();

    public static void addSocket(Socket socket) throws IOException {
        var clientHandler = new ClientHandler(socket);
        CLIENT_HANDLERS.add(clientHandler);
        clientHandler.start();
    }

    public static void addMessage(String name , String message) {
        chet += name + ": " + message + "\n";
    }

    public static void syncChet() {
        for (var clientHandler : CLIENT_HANDLERS) {
            clientHandler.sendResponseStr(chet);
        }
    }
}
