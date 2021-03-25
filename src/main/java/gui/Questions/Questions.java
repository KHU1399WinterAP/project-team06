/*
 * Created by JFormDesigner on Tue Mar 16 19:59:15 IRST 2021
 */

package main.java.gui.Questions;

import main.java.config.FontConfig;
import main.java.models.Question;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Alireza
 */
public class Questions extends JFrame {
    Question question;
    public final JFrame singlePlayer;
    ArrayList<Question> questions;

    public Questions(JFrame singlePlayer, ArrayList<Question> questions) {
        this.questions = questions;
        this.singlePlayer = singlePlayer;
        initComponents();
        initComponentsProperties();
        showQuestion(questions);
        this.setVisible(true);
    }

    private void showQuestion(ArrayList<Question> questions) {
        question = randomQuestion(questions);
        questionLabel.setText(question.question);
        ArrayList<String> answers = new ArrayList<>();
        answers.add(question.answer1);
        answers.add(question.answer2);
        answers.add(question.answer3);
        answers.add(question.correctAnswer);
        answerButton1.setText(randomAnswer(answers));
        answerButton2.setText(randomAnswer(answers));
        answerButton3.setText(randomAnswer(answers));
        answerButton4.setText(randomAnswer(answers));
    }

    private String randomAnswer(ArrayList<String> answers) {
        Random random = new Random();
        int rand = random.nextInt(answers.size());
        String answer = answers.get(rand);
        answers.remove(rand);
        return answer;
    }

    private Question randomQuestion(ArrayList<Question> questions) {
        Random random = new Random();
        int rand = random.nextInt(questions.size());
        Question question = questions.get(rand);
        questions.remove(rand);
        return question;
    }

    private void questionsWindowClosing(WindowEvent e) {
        this.dispose();
        singlePlayer.setVisible(true);
    }

    private void isCorrect(JButton inputAnswer) {
        if (inputAnswer.getText().equals(question.correctAnswer)) {
            inputAnswer.setBackground(Color.GREEN);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inputAnswer.setBackground(new Color(0, 32, 96));
            showQuestion(questions);
        } else {
            inputAnswer.setBackground(Color.RED);
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            this.dispose();
//            singlePlayer.setVisible(true);
        }
    }

    private void initComponentsProperties() {
        questionLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 18));
        answerButton1.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 15));
        answerButton2.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 15));
        answerButton3.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 15));
        answerButton4.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 15));
        powerUp1.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 15));
        powerUp2.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 15));
    }

    private void answerButton3ActionPerformed(ActionEvent e) {
        isCorrect(answerButton3);
    }

    private void answerButton2ActionPerformed(ActionEvent e) {
        isCorrect(answerButton2);
    }

    private void answerButton4ActionPerformed(ActionEvent e) {
        isCorrect(answerButton4);
    }

    private void answerButton1ActionPerformed(ActionEvent e) {
        isCorrect(answerButton1);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Panel = new JPanel();
        questionLabel = new JLabel();
        powerUp1 = new JButton();
        powerUp2 = new JButton();
        answerButton3 = new JButton();
        answerButton2 = new JButton();
        answerButton4 = new JButton();
        answerButton1 = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setName("Questions");
        setMaximizedBounds(new Rectangle(580, 60, 380, 605));
        setResizable(false);
        setTitle("Questions");
        setBackground(new Color(0, 112, 192));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo (1).jpg")).getImage());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                questionsWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //======== Panel ========
        {
            Panel.setBackground(new Color(0, 112, 192));

            //---- questionLabel ----
            questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
            questionLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            questionLabel.setForeground(Color.white);
            questionLabel.setBackground(new Color(0, 0, 204));

            //---- powerUp1 ----
            powerUp1.setText("Power UP 1");
            powerUp1.setBackground(new Color(0, 153, 51));
            powerUp1.setFocusable(false);
            powerUp1.setForeground(Color.white);
            powerUp1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));

            //---- powerUp2 ----
            powerUp2.setText("Power UP 2");
            powerUp2.setBackground(new Color(0, 153, 51));
            powerUp2.setFocusable(false);
            powerUp2.setForeground(Color.white);
            powerUp2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));

            //---- answerButton3 ----
            answerButton3.setBackground(new Color(0, 32, 96));
            answerButton3.setFocusable(false);
            answerButton3.setForeground(Color.white);
            answerButton3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            answerButton3.addActionListener(e -> answerButton3ActionPerformed(e));

            //---- answerButton2 ----
            answerButton2.setBackground(new Color(0, 32, 96));
            answerButton2.setFocusable(false);
            answerButton2.setForeground(Color.white);
            answerButton2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            answerButton2.addActionListener(e -> answerButton2ActionPerformed(e));

            //---- answerButton4 ----
            answerButton4.setBackground(new Color(0, 32, 96));
            answerButton4.setFocusable(false);
            answerButton4.setForeground(Color.white);
            answerButton4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            answerButton4.addActionListener(e -> answerButton4ActionPerformed(e));

            //---- answerButton1 ----
            answerButton1.setBackground(new Color(0, 32, 96));
            answerButton1.setFocusable(false);
            answerButton1.setForeground(Color.white);
            answerButton1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            answerButton1.addActionListener(e -> answerButton1ActionPerformed(e));

            GroupLayout PanelLayout = new GroupLayout(Panel);
            Panel.setLayout(PanelLayout);
            PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelLayout.createParallelGroup()
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(questionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                .addGap(0, 19, Short.MAX_VALUE)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(answerButton3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(answerButton4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(powerUp1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addGap(27, 27, 27)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(answerButton1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(answerButton2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(powerUp2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))))
            );
            PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(answerButton3, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                            .addComponent(answerButton2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(answerButton4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                            .addComponent(answerButton1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(powerUp2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                            .addComponent(powerUp1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel Panel;
    private JLabel questionLabel;
    private JButton powerUp1;
    private JButton powerUp2;
    private JButton answerButton3;
    private JButton answerButton2;
    private JButton answerButton4;
    private JButton answerButton1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
