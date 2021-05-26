package main.java.socket;

import main.java.gui.MultiplayerQuestion.MultiplayerQuestion;
import main.java.gui.chooseCategory.ChooseCategory;
import main.java.models.Question;
import main.java.questionTypes.QuestionTypes;

import javax.swing.*;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ReceiveCategoryName extends Thread {
    Client CLIENT;
    JLabel selectedCategory;
    JFrame chooseCategory;

    public ReceiveCategoryName(Client client,JLabel selectedCategory,JFrame chooseCategory){
        this.CLIENT=client;
        this.chooseCategory=chooseCategory;
        this.selectedCategory=selectedCategory;
    }

    @Override
    public void run() {
        String category=CLIENT.getResponse();
        selectedCategory.setText(category);
        Timer pause = new Timer(1000, e -> {
            new MultiplayerQuestion(CLIENT);
            chooseCategory.dispose();
        });
        pause.setRepeats(false);
        pause.start();
    }
}
