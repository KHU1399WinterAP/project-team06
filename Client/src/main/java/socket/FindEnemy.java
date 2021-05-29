package main.java.socket;

import main.java.gui.Multiplayer.Multiplayer;

public class FindEnemy extends Thread {
    Client CLIENT;
    Multiplayer multiplayer;
    String username;

    public FindEnemy(Client client, Multiplayer multiplayer, String username) {
        this.CLIENT = client;
        this.username = username;
        this.multiplayer = multiplayer;
    }

    @Override
    public void run() {
        CLIENT.sendRequest(Requests.WAIT_FOR_OTHER_PLAYER.request);
        CLIENT.sendRequest(username);
        String result = CLIENT.getResponse();
        if (result.equals(Requests.ACCEPT.request))
            multiplayer.found();
    }
}
