/*
 * Created by JFormDesigner on Fri Apr 02 19:54:10 IRDT 2021
 */

package main.java.gui.Singleplayer.ScoreBoard;

import main.java.config.FontConfig;
import main.java.config.MusicConfig;
import main.java.config.ProfileConfig;
import main.java.config.ThemeConfig;
import main.java.gui.RegisterMenu.RegisterMenu;
import main.java.models.ScoreBoardInformation;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;

/**
 * @author Brainrain
 */

public class ScoreBoard extends JFrame {
    JFrame singlePlayer;
    ArrayList<ScoreBoardInformation> scoreBoardInformation;
    String categoryName;

    public ScoreBoard(JFrame singlePlayer, ArrayList<ScoreBoardInformation> scoreBoardInformation, String categoryName) {
        this.singlePlayer = singlePlayer;
        this.categoryName = categoryName;
        this.scoreBoardInformation = scoreBoardInformation;
        init();
        initCustomTheme();
        this.setVisible(true);
    }

    private void scoreBoardWindowClosing(WindowEvent e) {
        previousPage();
    }

    private void previousButtonActionPerformed(ActionEvent e) {
        previousPage();
    }
    private void previousPage(){
        MusicConfig.initShortMp3(MusicConfig.celClickSong);
        this.dispose();
        singlePlayer.setVisible(true);
    }

    private void initCustomTheme() {
        panel.setBackground(ThemeConfig.background);
        previousButton.setBackground(ThemeConfig.background);
    }

    private void init() {
        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        JScrollPane scrollPane1 = new JScrollPane();
        panel = new JPanel();
        previousButton = new JButton();
        JLabel categoryLabel = new JLabel();
        JLabel title = new JLabel();
        JLabel categoryNameLabel = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setMaximizedBounds(new Rectangle(580, 60, 380, 605));
        setResizable(false);
        setTitle("Score Boad");
        setBackground(new Color(0, 112, 192));
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/main/resources/icons/Theme/Logo.jpg"))).getImage());
        setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                scoreBoardWindowClosing(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //======== panel ========
            {
                panel.setBackground(new Color(0, 112, 192));
                panel.setLayout(null);

                //---- previousButton ----
                previousButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/main/resources/icons/previous.png"))));
                previousButton.setBackground(new Color(0, 112, 192));
                previousButton.setFocusable(false);
                previousButton.setBorder(null);
                previousButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                previousButton.addActionListener(this::previousButtonActionPerformed);
                panel.add(previousButton);
                previousButton.setBounds(5, 10, 57, 48);

                //---- categoryLabel ----
                categoryLabel.setText("Category :");
                categoryLabel.setForeground(Color.white);
                categoryLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
                panel.add(categoryLabel);
                categoryLabel.setBounds(10, 85, 125, 34);

                //---- title ----
                title.setText("Leader Board");
                title.setFont(new Font("Comic Sans MS", Font.BOLD, 39));
                title.setForeground(Color.white);
                panel.add(title);
                title.setBounds(75, 10, 260, 55);
                categoryNameLabel.setText(categoryName);
                categoryNameLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 20));
                categoryNameLabel.setForeground(Color.white);
                panel.add(categoryNameLabel);
                categoryNameLabel.setBounds(155, 85, 195, 35);
                int y = 140;
                for (int i = 0; i < scoreBoardInformation.size(); i++) {
                    JLabel numberLabel = new JLabel();
                    JLabel usernameLabel = new JLabel();
                    JLabel recordLabel = new JLabel();
                    JLabel profilePicture = new JLabel();

                    initLabels(numberLabel);
                    numberLabel.setBounds(30, y, 55, 70);

                    profilePicture.setHorizontalAlignment(SwingConstants.LEADING);
                    profilePicture.setFocusable(false);
                    profilePicture.setBorder(null);
                    panel.add(profilePicture);
                    profilePicture.setBounds(58, y, 100, 70);

                    initLabels(usernameLabel);
                    usernameLabel.setBounds(130, y, 200, 70);

                    initLabels(recordLabel);
                    recordLabel.setBounds(315, y, 45, 70);

                    y += 70;

                    numberLabel.setText(i + 1 + " . ");
                    String profilePath = ProfileConfig.profilePicture(scoreBoardInformation.get(i).profilePicture);
                    ImageIcon profile = new ImageIcon(Objects.requireNonNull(getClass().getResource(profilePath)));
                    profilePicture.setIcon(profile);
                    usernameLabel.setText(scoreBoardInformation.get(i).username);
                    recordLabel.setText(String.valueOf(scoreBoardInformation.get(i).record));
                }

                {
                    // compute preferred size
                    RegisterMenu.preferSize(panel);
                }
            }
            scrollPane1.setViewportView(panel);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 380, 570);

        {
            // compute preferred size
            RegisterMenu.preferSize((JPanel) contentPane);
        }
        pack();
        setLocationRelativeTo(getOwner());
    }

    private void initLabels(JLabel recordLabel) {
        recordLabel.setHorizontalAlignment(SwingConstants.LEADING);
        recordLabel.setVerticalAlignment(SwingConstants.CENTER);
        recordLabel.setFocusable(false);
        recordLabel.setForeground(Color.white);
        recordLabel.setBorder(null);
        recordLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 16));
        panel.add(recordLabel);
    }

    private JPanel panel;
    private JButton previousButton;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
