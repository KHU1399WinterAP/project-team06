package main.java.app;

import main.java.models.User;
import main.java.socket.ClientHandler;
import main.java.socket.Responses;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class AppManager {
    private static String chet = "";
    public static final ArrayList<ClientHandler> CLIENT_HANDLERS = new ArrayList<>();
    public static final ArrayList<User> EnteredUsers=new ArrayList<>();
    public static final ArrayList<ClientHandler> CLIENT_HANDLERS_MULTIPLAYER=new ArrayList<>();

    public static void addUser(User user){
        EnteredUsers.add(user);
    }

    public static void addSocket(Socket socket) throws IOException {
        var clientHandler = new ClientHandler(socket);
        CLIENT_HANDLERS.add(clientHandler);
        clientHandler.start();
    }

    public static void addMessage(String name , String message) {
        chet += name + ": " + message + "\n";
    }

    public static void syncChet() {
        for (var clientHandler : CLIENT_HANDLERS)
            clientHandler.sendResponseStr(chet);

    }

    public static boolean startTheGame() {
        System.out.println(CLIENT_HANDLERS_MULTIPLAYER.size());
        if (CLIENT_HANDLERS_MULTIPLAYER.size() == 2) {
            for (var clientHandlersMultiplayer : CLIENT_HANDLERS_MULTIPLAYER)
                clientHandlersMultiplayer.sendResponseStr(Responses.ACCEPT.response);

            return true;
        }

        return false;
    }

    public static String randomCategoryName(ArrayList<String> arrayList) {
        Random random = new Random();
        int rand = random.nextInt(arrayList.size());
        String randomCategory=arrayList.get(rand);
        arrayList.remove(rand);
        return randomCategory;
    }

    public static void sendCategoryName(ArrayList<String> arrayList){
        for (var clientHandler : CLIENT_HANDLERS_MULTIPLAYER) {
            clientHandler.sendResponseStr(randomCategoryName(arrayList));
            clientHandler.sendResponseStr(randomCategoryName(arrayList));
        }
    }

    public static void changeState(Socket socket,ArrayList<ClientHandler> arrayList1,ArrayList<ClientHandler> arrayList2 ){
        for (int i=0;i<arrayList1.size();i++){
            if (arrayList1.get(i).SOCKET.getRemoteSocketAddress().equals(socket.getRemoteSocketAddress())){
                arrayList2.add(arrayList1.get(i));
                arrayList1.remove(i);
                break;
            }
        }
    }
}
