package main.java.models;

public class Question implements Cloneable {
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();

        Question question2 = (Question) clone;

        question2.answer1 = answer1;
        question2.question = question;
        question2.answer2 = answer2;
        question2.answer3 = answer3;
        question2.questionIndex = questionIndex;
        question2.correctAnswer = correctAnswer;
        question2.category = category;
        return question2;
    }

    @Override
    public String toString() {
        return "Question{" +
                "category=" + category +
                ", questionIndex=" + questionIndex +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", question='" + question + '\'' +
                '}';
    }
}
