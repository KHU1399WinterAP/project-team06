package main.java.socket;

import main.java.gui.MultiplayerQuestion.GameOver.GameOver;

import javax.swing.*;

public class GetFinalScore extends Thread{
    GameOver gameOver;
    Client CLIENT;

    public GetFinalScore(GameOver gameOver, Client CLIENT){
        this.CLIENT=CLIENT;
        this.gameOver=gameOver;
    }
    @Override
    public void run() {
        CLIENT.sendRequest(Requests.GET_FINAL_SCORE.request);
        String username1 = CLIENT.getResponse();

        if (username1.equals("QUESTION"))
            username1= CLIENT.getResponse();

        gameOver.usernameLabel1.setText(username1);

        int score1 = CLIENT.getResponseInt();
        gameOver.scorePlayer1.setText(String.valueOf(score1));

        String username2 = CLIENT.getResponse();
        gameOver.usernameLabel2.setText(username2);

        int score2 = CLIENT.getResponseInt();
        gameOver.scorePlayer2.setText(String.valueOf(score2));

        if (score1 == score2)
            gameOver.result.setText("!     -DRAW-     !");
        else if (username1.equals(gameOver.activeUser.username))
            gameOver.result.setText("!    YOU  WON    !");
        else
            gameOver.result.setText("!    YOU LOST    !");
    }
}
