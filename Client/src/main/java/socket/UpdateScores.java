package main.java.socket;

import main.java.gui.MultiplayerQuestion.MultiplayerQuestion;

public class UpdateScores extends Thread {
    Client CLIENT;
    MultiplayerQuestion multiplayerQuestion;
    public static boolean isFinished = false;

    public UpdateScores(Client client, MultiplayerQuestion multiplayerQuestion) {
        this.multiplayerQuestion = multiplayerQuestion;
        this.CLIENT = client;
    }

    @Override
    public void run() {
        while (true) {
            if (isFinished)
                break;
            String username = CLIENT.getResponse();
            String isTrue = CLIENT.getResponse();
            int questionNumber = CLIENT.getResponseInt();

            multiplayerQuestion.updateScore(username, isTrue, questionNumber);

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
