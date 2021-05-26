/*
 * Created by JFormDesigner on Mon May 24 15:55:56 IRDT 2021
 */

package main.java.gui.MultiplayerQuestion;

import main.java.animations.ClockAnimation;
import main.java.config.FontConfig;
import main.java.config.MusicConfig;
import main.java.config.ThemeConfig;
import main.java.gui.Dashboard.Dashboard;
import main.java.models.User;
import main.java.socket.Client;
import main.java.socket.Requests;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

/**
 * @author Alireza
 */
public class MultiplayerQuestion extends JFrame {
    int seconds = 10;
    int questionNumber;
    User activeUser;
    ClockAnimation clockAnimationSlow;
    Client CLIENT;
    JFrame currentFrame;

    public MultiplayerQuestion(Client client) {
        questionNumber = 0;
        currentFrame = this;
        activeUser = Dashboard.activeUser;
        initComponents();
        init();
        clockAnimationSlow = new ClockAnimation(clockLabel);
        this.CLIENT = client;
        this.setVisible(true);
        receiveQuestion();
    }

    private void receiveQuestion() {
        CLIENT.sendRequest(Requests.GET_QUESTION.request);
        CLIENT.sendRequest(String.valueOf(questionNumber));

        questionLabel.setText(CLIENT.getResponse());
        for (JButton jButton : Arrays.asList(answerButton1, answerButton2, answerButton3, answerButton4))
            jButton.setText(CLIENT.getResponse());

        questionNumber++;
    }

    private void initCustomTheme() {
        Panel.setBackground(ThemeConfig.background);
        for (JButton jButton : Arrays.asList(answerButton1, answerButton2, answerButton3, answerButton4)) {
            jButton.setBackground(ThemeConfig.button);
        }
    }

    private void initComponentsProperties() {
        init1(answerButton1, answerButton2, answerButton3, answerButton4, Freezer, Helper, questionLabel, coinAmountLabel);
    }

    public static void init1(JButton answerButton1,
                             JButton answerButton2, JButton answerButton3,
                             JButton answerButton4, JButton freezer,
                             JButton helper, JLabel questionLabel, JLabel coinAmountLabel) {
        for (JButton jButton : Arrays.asList(answerButton1, answerButton2, answerButton3,
                answerButton4, freezer, helper))
            jButton.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 15));

        questionLabel.setFont(FontConfig.comic.deriveFont(Font.BOLD, 18));
        coinAmountLabel.setFont(FontConfig.comic.deriveFont(Font.BOLD, 19));
    }

    private void init() {
        initCustomTheme();
        coinAmountLabel.setText(String.valueOf(activeUser.coins));
        timeProgressBar.setMaximum(10);
        timeProgressBar.setMinimum(0);
        initComponentsProperties();
    }


    private void updateCoins() {
        CLIENT.sendRequest("UPDATE_COINS");
        CLIENT.sendRequest(activeUser.username);
        CLIENT.sendRequest(String.valueOf(activeUser.coins));

        coinAmountLabel.setText(String.valueOf(activeUser.coins));
    }

    private void questionsWindowClosing(WindowEvent e) {

    }

    private void FreezerActionPerformed(ActionEvent e) {

    }

    private void HelperActionPerformed(ActionEvent e) {

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Panel = new JPanel();
        questionLabel = new JLabel();
        Freezer = new JButton();
        Helper = new JButton();
        answerButton3 = new JButton();
        answerButton2 = new JButton();
        answerButton4 = new JButton();
        answerButton1 = new JButton();
        coinLabel = new JLabel();
        coinAmountLabel = new JLabel();
        timelabel = new JLabel();
        timeProgressBar = new JProgressBar();
        clockLabel = new JLabel();
        icon1 = new JLabel();
        icon2 = new JLabel();
        icon3 = new JLabel();
        icon4 = new JLabel();
        icon5 = new JLabel();
        icon6 = new JLabel();
        icon7 = new JLabel();
        icon8 = new JLabel();
        icon9 = new JLabel();
        icon10 = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setName("Questions");
        setMaximizedBounds(new Rectangle(580, 60, 380, 605));
        setResizable(false);
        setTitle("Questions");
        setBackground(new Color(0, 112, 192));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo.jpg")).getImage());
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
            Panel.setLayout(null);

            //---- questionLabel ----
            questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
            questionLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            questionLabel.setForeground(Color.white);
            questionLabel.setBackground(new Color(0, 0, 204));
            Panel.add(questionLabel);
            questionLabel.setBounds(6, 139, 366, 188);

            //---- Freezer ----
            Freezer.setText("<html>Freeze Time<br>&nbsp;&nbsp;&nbsp;100 coins </html>");
            Freezer.setBackground(new Color(0, 153, 51));
            Freezer.setFocusable(false);
            Freezer.setForeground(Color.white);
            Freezer.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            Freezer.setBorder(null);
            Freezer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            Freezer.addActionListener(e -> FreezerActionPerformed(e));
            Panel.add(Freezer);
            Freezer.setBounds(25, 525, 150, 53);

            //---- Helper ----
            Helper.setText("<html>2 Wrongs Out<br>&nbsp;&nbsp;&nbsp;200 coins</html>");
            Helper.setBackground(new Color(0, 153, 51));
            Helper.setForeground(Color.white);
            Helper.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            Helper.setBorder(null);
            Helper.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            Helper.setFocusable(false);
            Helper.addActionListener(e -> HelperActionPerformed(e));
            Panel.add(Helper);
            Helper.setBounds(200, 525, 150, 53);

            //---- answerButton3 ----
            answerButton3.setBackground(new Color(0, 32, 96));
            answerButton3.setFocusable(false);
            answerButton3.setForeground(Color.white);
            answerButton3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            answerButton3.setBorder(null);
            answerButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            Panel.add(answerButton3);
            answerButton3.setBounds(25, 339, 150, 76);

            //---- answerButton2 ----
            answerButton2.setBackground(new Color(0, 32, 96));
            answerButton2.setFocusable(false);
            answerButton2.setForeground(Color.white);
            answerButton2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            answerButton2.setBorder(null);
            answerButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            Panel.add(answerButton2);
            answerButton2.setBounds(202, 339, 150, 76);

            //---- answerButton4 ----
            answerButton4.setBackground(new Color(0, 32, 96));
            answerButton4.setFocusable(false);
            answerButton4.setForeground(Color.white);
            answerButton4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            answerButton4.setBorder(null);
            answerButton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            Panel.add(answerButton4);
            answerButton4.setBounds(25, 427, 150, 76);

            //---- answerButton1 ----
            answerButton1.setBackground(new Color(0, 32, 96));
            answerButton1.setFocusable(false);
            answerButton1.setForeground(Color.white);
            answerButton1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            answerButton1.setBorder(null);
            answerButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            Panel.add(answerButton1);
            answerButton1.setBounds(202, 427, 150, 76);

            //---- coinLabel ----
            coinLabel.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Dashboard/smallCoin.png")));
            Panel.add(coinLabel);
            coinLabel.setBounds(320, 15, 35, 37);

            //---- coinAmountLabel ----
            coinAmountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            coinAmountLabel.setForeground(new Color(255, 255, 51));
            Panel.add(coinAmountLabel);
            coinAmountLabel.setBounds(255, 15, 57, 43);

            //---- timelabel ----
            timelabel.setBackground(new Color(255, 153, 0));
            timelabel.setForeground(new Color(255, 153, 0));
            timelabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
            timelabel.setText("10");
            timelabel.setHorizontalAlignment(SwingConstants.CENTER);
            Panel.add(timelabel);
            timelabel.setBounds(27, 55, 46, timelabel.getPreferredSize().height);

            //---- timeProgressBar ----
            timeProgressBar.setBackground(Color.green);
            Panel.add(timeProgressBar);
            timeProgressBar.setBounds(90, 65, 220, 23);
            Panel.add(clockLabel);
            clockLabel.setBounds(320, 50, 45, 39);

            //---- icon1 ----
            icon1.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Multiplayer/Questions/red-button.png")));
            Panel.add(icon1);
            icon1.setBounds(34, 95, icon1.getPreferredSize().width, 38);

            //---- icon2 ----
            icon2.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Multiplayer/Questions/red-button.png")));
            Panel.add(icon2);
            icon2.setBounds(68, 95, icon2.getPreferredSize().width, 38);

            //---- icon3 ----
            icon3.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Multiplayer/Questions/red-button.png")));
            Panel.add(icon3);
            icon3.setBounds(102, 95, icon3.getPreferredSize().width, 38);

            //---- icon4 ----
            icon4.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Multiplayer/Questions/red-button.png")));
            Panel.add(icon4);
            icon4.setBounds(136, 95, icon4.getPreferredSize().width, 38);

            //---- icon5 ----
            icon5.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Multiplayer/Questions/green-button.png")));
            Panel.add(icon5);
            icon5.setBounds(170, 95, icon5.getPreferredSize().width, 38);

            //---- icon6 ----
            icon6.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Multiplayer/Questions/green-button.png")));
            Panel.add(icon6);
            icon6.setBounds(196, 95, icon6.getPreferredSize().width, 38);

            //---- icon7 ----
            icon7.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Multiplayer/Questions/red-button.png")));
            Panel.add(icon7);
            icon7.setBounds(222, 95, icon7.getPreferredSize().width, 38);

            //---- icon8 ----
            icon8.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Multiplayer/Questions/red-button.png")));
            Panel.add(icon8);
            icon8.setBounds(256, 95, icon8.getPreferredSize().width, 38);

            //---- icon9 ----
            icon9.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Multiplayer/Questions/red-button.png")));
            Panel.add(icon9);
            icon9.setBounds(290, 95, icon9.getPreferredSize().width, 38);

            //---- icon10 ----
            icon10.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Multiplayer/Questions/red-button.png")));
            Panel.add(icon10);
            icon10.setBounds(324, 95, icon10.getPreferredSize().width, 38);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < Panel.getComponentCount(); i++) {
                    Rectangle bounds = Panel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = Panel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                Panel.setMinimumSize(preferredSize);
                Panel.setPreferredSize(preferredSize);
            }
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(Panel, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(Panel, GroupLayout.PREFERRED_SIZE, 611, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel Panel;
    private JLabel questionLabel;
    private JButton Freezer;
    private JButton Helper;
    private JButton answerButton3;
    private JButton answerButton2;
    private JButton answerButton4;
    private JButton answerButton1;
    private JLabel coinLabel;
    private JLabel coinAmountLabel;
    private JLabel timelabel;
    private JProgressBar timeProgressBar;
    private JLabel clockLabel;
    private JLabel icon1;
    private JLabel icon2;
    private JLabel icon3;
    private JLabel icon4;
    private JLabel icon5;
    private JLabel icon6;
    private JLabel icon7;
    private JLabel icon8;
    private JLabel icon9;
    private JLabel icon10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
