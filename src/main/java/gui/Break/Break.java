/*
 * Created by JFormDesigner on Fri Mar 26 21:32:36 IRDT 2021
 */

package main.java.gui.Break;

import main.java.config.FontConfig;
import main.java.gui.Dashord.Dashboard;
import main.java.gui.GameOver.GameOver;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Brainrain
 */
public class Break extends JFrame {
    JFrame questions;
    JFrame singlePlayer;
    int score=0;
    int category;
    public Break(JFrame singlePlayer,int score,JFrame questions,int category) {
        this.category=category;
        this.questions=questions;
        this.score=score;
        this.singlePlayer=singlePlayer;
        initComponents();
        initComponentsProperties();
        this.setVisible(true);
        currentScoreLable.setText(String.valueOf(score));
        coinAmountLabel.setText(String.valueOf(Dashboard.activeUser.coins));
    }

    private void initComponentsProperties() {
        coinAmountLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        label1.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 16));
        currentScoreLable.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        nextButton.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 18));
        stopButton.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 16));
    }
        private void questionsWindowClosing(WindowEvent e) {
        this.dispose();
        new GameOver(singlePlayer,score,category);
    }

    private void nextButtonActionPerformed(ActionEvent e) {
        this.dispose();
        questions.setVisible(true);

    }

    private void stopButtonActionPerformed(ActionEvent e) {
        this.dispose();
        new GameOver(singlePlayer,score,category);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Panel = new JPanel();
        coinLabel = new JLabel();
        coinAmountLabel = new JLabel();
        label1 = new JLabel();
        currentScoreLable = new JLabel();
        nextButton = new JButton();
        stopButton = new JButton();

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

            //---- coinLabel ----
            coinLabel.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Dashboard/smallCoin.png")));
            coinLabel.setHorizontalAlignment(SwingConstants.CENTER);

            //---- coinAmountLabel ----
            coinAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
            coinAmountLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            coinAmountLabel.setForeground(new Color(255, 255, 51));

            //---- label1 ----
            label1.setText("Score :");
            label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
            label1.setForeground(Color.white);

            //---- currentScoreLable ----
            currentScoreLable.setHorizontalAlignment(SwingConstants.CENTER);
            currentScoreLable.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            currentScoreLable.setForeground(Color.white);

            //---- nextButton ----
            nextButton.setText("next");
            nextButton.setBackground(new Color(0, 32, 96));
            nextButton.setForeground(Color.white);
            nextButton.setFocusable(false);
            nextButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            nextButton.addActionListener(e -> nextButtonActionPerformed(e));

            //---- stopButton ----
            stopButton.setText("stop");
            stopButton.setBackground(new Color(0, 32, 96));
            stopButton.setForeground(Color.white);
            stopButton.setFocusable(false);
            stopButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            stopButton.addActionListener(e -> stopButtonActionPerformed(e));

            GroupLayout PanelLayout = new GroupLayout(Panel);
            Panel.setLayout(PanelLayout);
            PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup()
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(stopButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addGroup(PanelLayout.createParallelGroup()
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addComponent(label1)
                                        .addGap(18, 18, 18)
                                        .addComponent(currentScoreLable, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addComponent(coinLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(coinAmountLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(124, Short.MAX_VALUE))
            );
            PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(PanelLayout.createParallelGroup()
                            .addComponent(coinAmountLabel, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(coinLabel, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelLayout.createParallelGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addComponent(currentScoreLable, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                        .addGap(164, 164, 164)
                        .addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(stopButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
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
    private JLabel coinLabel;
    private JLabel coinAmountLabel;
    private JLabel label1;
    private JLabel currentScoreLable;
    private JButton nextButton;
    private JButton stopButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
