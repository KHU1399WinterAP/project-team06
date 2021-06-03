package main.java.socket;

import main.java.gui.MultiplayerQuestion.MultiplayerQuestion;

public class UpdateScores extends Thread {
    Client CLIENT;
    MultiplayerQuestion multiplayerQuestion;

    public UpdateScores(Client client, MultiplayerQuestion multiplayerQuestion) {
        this.multiplayerQuestion = multiplayerQuestion;
        this.CLIENT = client;
    }

    @Override
    public void run() {
        int x=0;
        while (x<10) {
            String username = CLIENT.getResponse();
            if (username.equals("QUESTION"))
                return;

            x++;
            String isTrue = CLIENT.getResponse();
            int questionNumber = CLIENT.getResponseInt();

            multiplayerQuestion.updateScore(username, isTrue, questionNumber);
        }
    }
}
