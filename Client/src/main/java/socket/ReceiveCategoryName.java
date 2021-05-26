package main.java.socket;

import main.java.gui.MultiplayerQuestion.MultiplayerQuestion;
import main.java.models.Question;
import main.java.questionTypes.QuestionTypes;

import javax.swing.*;
import java.util.ArrayList;

public class ReceiveCategoryName extends Thread {
    JFrame chooseCategory;
    Client CLIENT;

    public ReceiveCategoryName(JFrame chooseCategory ,Client client){
        this.chooseCategory=chooseCategory;
        this.CLIENT=client;
    }

    @Override
    public void run() {
        String category=CLIENT.getResponse();
        ArrayList<Question> questions;
        switch (category){
            case "English"->questions= QuestionTypes.english;
            case "Math"->questions= QuestionTypes.mathematics;
            case "Food"->questions= QuestionTypes.foodAndDrink;
            case "Science"->questions= QuestionTypes.science;
            case "Common"->questions= QuestionTypes.commonKnowledge;
            default ->questions=QuestionTypes.geography;
        }

        chooseCategory.dispose();
        new MultiplayerQuestion(questions,category);
    }
}
