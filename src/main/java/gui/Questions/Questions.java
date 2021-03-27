/*
 * Created by JFormDesigner on Tue Mar 16 19:59:15 IRST 2021
 */

package main.java.gui.Questions;

import main.java.config.FontConfig;
import main.java.database.Database;
import main.java.gui.Break.Break;
import main.java.gui.Dashord.Dashboard;
import main.java.gui.GameOver.GameOver;
import main.java.models.Question;
import main.java.models.User;

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
    int seconds = 10;
    JFrame CurrentFrame = this;
    Question question;
    public final JFrame singlePlayer;
    ArrayList<Question> questions;
    ArrayList<Question> questions2;
    int score=0;
    int category;
    User activeUser=Dashboard.activeUser;

    Timer countdown = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            timelabel.setText(String.valueOf(seconds));
            if (seconds<=0){
                CurrentFrame.dispose();
                new GameOver(singlePlayer,score,category);
                countdown.stop();
            }
        }
    });

    public Questions(JFrame singlePlayer, ArrayList<Question> questions, int category) {
        this.category=category;
        this.questions = questions;
        this.singlePlayer = singlePlayer;
        questions2=new ArrayList<>(questions);

        initComponents();
        coinAmountLabel.setText(String.valueOf(Dashboard.activeUser.coins));
        initComponentsProperties();
        currentScoreLable.setText(String.valueOf(score));
        showQuestion(questions2);
        this.setVisible(true);
    }

    private void showQuestion(ArrayList<Question> questions2) {
        countdown.start();
        question = randomQuestion(questions2);
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

    private Question randomQuestion(ArrayList<Question> questions2) {
        Random random = new Random();
        int rand = random.nextInt(questions2.size());
        Question question = questions2.get(rand);
        questions2.remove(rand);
        return question;
    }

    private void questionsWindowClosing(WindowEvent e) {
        this.dispose();
        countdown.stop();
        new GameOver(singlePlayer,score,category);
    }

    private void isCorrect(JButton inputAnswer) {

        if (inputAnswer.getText().equals(question.correctAnswer)) {
            countdown.stop();
            score++;
            switch (category){
                case 1 -> {
                    if (activeUser.recordEnglish<score) {
                        activeUser.recordEnglish=score;
                        Database.UpdateDatabaseUserRecord(activeUser.username,"recordEnglish",score);
                    }
                }
                case 2->{
                    if (activeUser.recordMath<score){
                        activeUser.recordMath=score;
                        Database.UpdateDatabaseUserRecord(activeUser.username,"recordMath",score);
                    }
                }
                case 3->{
                    if (activeUser.recordFood<score) {
                        activeUser.recordFood=score;
                        Database.UpdateDatabaseUserRecord(activeUser.username,"recordFood",score);
                    }
                }
                case 4->{
                    if (activeUser.recordScience<score){
                        activeUser.recordScience=score;
                        Database.UpdateDatabaseUserRecord(activeUser.username,"recordScience",score);
                    }
                }
                case 5->{
                    if (activeUser.recordCommon<score){
                        activeUser.recordCommon=score;
                        Database.UpdateDatabaseUserRecord(activeUser.username,"recordCommon",score);
                    }
                }
                default -> {
                    if (activeUser.recordGeography<score) {
                        activeUser.recordGeography=score;
                        Database.UpdateDatabaseUserRecord(activeUser.username,"recordGeography",score);
                    }
                }
            }

            currentScoreLable.setText(String.valueOf(score));
            Dashboard.activeUser.coins+=20;
            Database.updateDatabaseUserCoins(Dashboard.activeUser.username,Dashboard.activeUser.coins);
            coinAmountLabel.setText(String.valueOf(Dashboard.activeUser.coins));
            inputAnswer.setBackground(Color.GREEN);
            inputAnswer.setForeground(Color.BLACK);

            Timer pause = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    inputAnswer.setBackground(new Color(0, 32, 96));
                    inputAnswer.setForeground(Color.white);
                    //CurrentFrame.setVisible(false);
                    seconds = 10;
                    //new Break(singlePlayer,score,CurrentFrame,category);
                    showQuestion(questions2);

                }
            });
            pause.setRepeats(false);
            pause.start();

        } else {
            inputAnswer.setBackground(Color.RED);
            inputAnswer.setForeground(Color.BLACK);
            countdown.stop();

            Timer pause = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    inputAnswer.setBackground(new Color(0, 32, 96));
                    inputAnswer.setForeground(Color.white);
                    seconds = 10;
                    CurrentFrame.dispose();
                    new GameOver(singlePlayer,score,category);

                }
            });
            pause.setRepeats(false);
            pause.start();

        }
    }

    private void initComponentsProperties() {
        questionLabel.setFont(FontConfig.comic.deriveFont(Font.BOLD, 18));
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
        coinLabel = new JLabel();
        coinAmountLabel = new JLabel();
        label1 = new JLabel();
        currentScoreLable = new JLabel();
        timelabel = new JLabel();

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

            //---- coinLabel ----
            coinLabel.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Dashboard/smallCoin.png")));

            //---- coinAmountLabel ----
            coinAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
            coinAmountLabel.setForeground(new Color(255, 255, 51));

            //---- label1 ----
            label1.setText("Score :");
            label1.setForeground(Color.white);

            //---- currentScoreLable ----
            currentScoreLable.setForeground(Color.white);

            //---- timelabel ----
            timelabel.setBackground(new Color(255, 153, 0));
            timelabel.setForeground(new Color(255, 153, 0));
            timelabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
            timelabel.setText("10");
            timelabel.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout PanelLayout = new GroupLayout(Panel);
            Panel.setLayout(PanelLayout);
            PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelLayout.createParallelGroup()
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(questionLabel, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup()
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addGap(0, 19, Short.MAX_VALUE)
                                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(answerButton3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(answerButton4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(powerUp1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                        .addGap(27, 27, 27)
                                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(answerButton1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(answerButton2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(powerUp2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addComponent(label1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(currentScoreLable, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                        .addGap(75, 75, 75)
                                        .addComponent(timelabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                        .addComponent(coinAmountLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(coinLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26))))
            );
            PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelLayout.createParallelGroup()
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup()
                                    .addComponent(currentScoreLable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addComponent(timelabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(2, 2, 2)))
                                .addGap(4, 4, 4))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(coinLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(coinAmountLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(answerButton3, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                            .addComponent(answerButton2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(answerButton4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                            .addComponent(answerButton1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
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
                .addComponent(Panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(Panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private JLabel coinLabel;
    private JLabel coinAmountLabel;
    private JLabel label1;
    private JLabel currentScoreLable;
    private JLabel timelabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
