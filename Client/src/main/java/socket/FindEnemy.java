package main.java.socket;

import main.java.gui.Multiplayer.Multiplayer;

public class FindEnemy extends Thread {
    Client CLIENT;
    Multiplayer multiplayer;


    public FindEnemy(Client client, Multiplayer multiplayer) {
        this.CLIENT = client;
        this.multiplayer = multiplayer;
    }

    @Override
    public void run() {
        CLIENT.sendRequest(Requests.WAIT_FOR_OTHER_PLAYER.request);
        CLIENT.getResponse();
        multiplayer.found();
    }
}
