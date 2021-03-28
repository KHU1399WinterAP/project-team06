package main.java.questionTypes;

import main.java.database.Database;
import main.java.models.Question;

import java.util.ArrayList;

public class QuestionTypes {
    public static ArrayList<Question> english = Database.SelectAllQuestions(1);
    public static ArrayList<Question> mathematics = Database.SelectAllQuestions(2);
    public static ArrayList<Question> foodAndDrink = Database.SelectAllQuestions(3);
    public static ArrayList<Question> science = Database.SelectAllQuestions(4);
    public static ArrayList<Question> commonKnowledge = Database.SelectAllQuestions(5);
    public static ArrayList<Question> geography = Database.SelectAllQuestions(6);
}
