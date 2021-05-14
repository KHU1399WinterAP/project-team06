package main.java.questionTypes;

import main.java.gui.Dashord.Dashboard;
import main.java.models.Question;
import main.java.socket.Client;

import java.util.ArrayList;

public class QuestionTypes {
    static Client client = Dashboard.CLIENT;

    public static ArrayList<Question> english = fillingArrays(1);
    public static ArrayList<Question> mathematics = fillingArrays(2);
    public static ArrayList<Question> foodAndDrink = fillingArrays(3);
    public static ArrayList<Question> science = fillingArrays(4);
    public static ArrayList<Question> commonKnowledge =fillingArrays(5);
    public static ArrayList<Question> geography = fillingArrays(6);

    private static ArrayList<Question> fillingArrays(int category) {
        client.sendRequest("GET_QUESTIONS");
        client.sendRequest(String.valueOf(category));

        ArrayList<Question> questions = new ArrayList<>();
        int questionsSize = client.getResponseInt();
        for (int i = 0; i < questionsSize; i++) {
            Question question = new Question(category, client.getResponseInt(),
                    client.getResponse(), client.getResponse(), client.getResponse(),
                    client.getResponse(), client.getResponse());

            questions.add(question);
        }

        return questions;
    }
}
