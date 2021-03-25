package main.java.models;

public class Question {
    public int category;
    public int questionIndex;
    public String answer1;
    public String answer2;
    public String answer3;
    public String correctAnswer;
    public String question;

    public Question(int category, int questionIndex,
                    String answer1, String answer2, String answer3,
                    String correctAnswer, String question) {
        this.category = category;
        this.questionIndex = questionIndex;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.correctAnswer = correctAnswer;
        this.question = question;
    }
}
