package main.java.socket;

import javax.swing.*;

public class RandomCategory extends Thread{
    JButton categoryButton1;
    JButton categoryButton2;
    Client CLIENT;
    JLabel turn;
    public RandomCategory(JButton button1,JButton button2,Client client,JLabel turn){
        this.categoryButton1=button1;
        this.categoryButton2=button2;
        this.CLIENT=client;
        this.turn=turn;
    }
    @Override
    public void run() {
        String firstChoice = CLIENT.getResponse();
        categoryButton1.setText(firstChoice);

        String secondChoice = CLIENT.getResponse();
        categoryButton2.setText(secondChoice);

        String isYourTurn = CLIENT.getResponse();
        System.out.println(isYourTurn);
        if (isYourTurn.equals(Requests.ACCEPT.request)) {
            categoryButton1.setEnabled(true);
            categoryButton2.setEnabled(true);
            turn.setText("It is your turn");
        } else {
            categoryButton1.setEnabled(false);
            categoryButton2.setEnabled(false);
            turn.setText("It is not your turn !!");
        }
    }
}
