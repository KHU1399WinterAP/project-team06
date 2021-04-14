/*
 * Created by JFormDesigner on Tue Mar 16 18:55:03 IRST 2021
 */

package main.java.gui.Singleplayer;

import main.java.config.FontConfig;
import main.java.config.MusicConfig;
import main.java.config.ThemeConfig;
import main.java.database.Database;
import main.java.gui.Category.Categories;
import main.java.gui.Dashord.Dashboard;
import main.java.gui.Dashord.profilesettings.ProfileSettings;
import main.java.gui.Questions.Questions;
import main.java.gui.Singleplayer.ScoreBoard.ScoreBoard;
import main.java.models.Question;
import main.java.models.User;
import main.java.models.UserColumns;
import main.java.questionTypes.QuestionTypes;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Alireza
 */
public class SinglePlayer extends JFrame {
    User activeUser = Dashboard.activeUser;
    public final JFrame dashboard;

    public SinglePlayer(JFrame dashboard) {
        this.dashboard = dashboard;
        initComponents();
        initRecords();
        initCustomTheme();
        initComponentsProperties();
        this.setVisible(true);
    }

    private void initCustomTheme() {
        for (JButton jButton : Arrays.asList(previousButton, bestRecordEnglishButton,
                bestRecordMathButton, bestRecordFoodButton, bestRecordScienceButton,
                bestRecordCommonButton, bestRecordGeographyButton)) {
            jButton.setBackground(ThemeConfig.background);
        }
        Panel.setBackground(ThemeConfig.background);
        for (JButton jButton : Arrays.asList(category1, category2, category3, category4, category5, category6)) {
            jButton.setBackground(ThemeConfig.button);
        }
    }

    private void initRecords() {
        yourRecordEnglishLabel.setText(String.valueOf(activeUser.recordEnglish));
        yourRecordMathLabel.setText(String.valueOf(activeUser.recordMath));
        yourRecordFoodLabel.setText(String.valueOf(activeUser.recordFood));
        yourRecordScienceLabel.setText(String.valueOf(activeUser.recordScience));
        yourRecordCommonLabel.setText(String.valueOf(activeUser.recordCommon));
        yourRecordGeographyLabel.setText(String.valueOf(activeUser.recordGeography));

        bestRecordEnglishButton.setText(String.valueOf(Database.getTheBestRecord(UserColumns.ENGLISH.column)));
        bestRecordMathButton.setText(String.valueOf(Database.getTheBestRecord(UserColumns.MATHEMATICS.column)));
        bestRecordFoodButton.setText(String.valueOf(Database.getTheBestRecord(UserColumns.FOOD_DRINK.column)));
        bestRecordScienceButton.setText(String.valueOf(Database.getTheBestRecord(UserColumns.SCIENCE.column)));
        bestRecordCommonButton.setText(String.valueOf(Database.getTheBestRecord(UserColumns.COMMON_KNOWLEDGE.column)));
        bestRecordGeographyButton.setText(String.valueOf(Database.getTheBestRecord(UserColumns.GEOGRAPHY.column)));
    }

    private void initComponentsProperties() {
        title.setFont(FontConfig.comic.deriveFont(Font.BOLD, 30));
        categoriesLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 24));

        for (JLabel jLabel : Arrays.asList(yourRecordEnglishLabel, yourRecordGeographyLabel, yourRecordCommonLabel,
                yourRecordScienceLabel, yourRecordFoodLabel, yourRecordMathLabel)) {
            jLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        }
        for (JButton jButton : Arrays.asList(bestRecordCommonButton, bestRecordFoodButton,
                bestRecordEnglishButton, bestRecordMathButton, bestRecordGeographyButton,
                bestRecordScienceButton, category1, category2, category3, category4, category5, category6)) {
            jButton.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 16));
        }
    }

    private void whenCategoryIsSelected(ArrayList<Question> questions, String column, int category) {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);
        this.setVisible(false);
        Questions questionPanel = new Questions(this, questions, column, category);
        questionPanel.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                initRecords();
                MusicConfig.mp3PlayerClockSlow.stop();
                MusicConfig.mp3PlayerClockFast.stop();
                if (!MusicConfig.mp3PlayerLong.isPaused()) {
                    MusicConfig.mp3PlayerLong.stop();
                    MusicConfig.initLongMusic(MusicConfig.gamePLaySong);
                }
            }
        });
    }

    private void category1ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.english, UserColumns.ENGLISH.column, 1);
    }

    private void category2ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.mathematics, UserColumns.MATHEMATICS.column, 2);
    }

    private void category3ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.foodAndDrink, UserColumns.FOOD_DRINK.column, 3);
    }

    private void category4ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.science, UserColumns.SCIENCE.column, 4);
    }

    private void category5ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.commonKnowledge, UserColumns.COMMON_KNOWLEDGE.column, 5);
    }

    private void category6ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.geography, UserColumns.GEOGRAPHY.column, 6);
    }

    private void bestRecordEnglishButtonActionPerformed(ActionEvent e) {
        recordSelected(UserColumns.ENGLISH.column, Categories.ENGLISH.category);
    }

    private void bestRecordMathButtonActionPerformed(ActionEvent e) {
        recordSelected(UserColumns.MATHEMATICS.column, Categories.MATHEMATICS.category);
    }

    private void bestRecordFoodButtonActionPerformed(ActionEvent e) {
        recordSelected(UserColumns.FOOD_DRINK.column, Categories.FOOD_DRINK.category);
    }

    private void bestRecordScienceButtonActionPerformed(ActionEvent e) {
        recordSelected(UserColumns.SCIENCE.column, Categories.SCIENCE.category);
    }

    private void bestRecordCommonButtonActionPerformed(ActionEvent e) {
        recordSelected(UserColumns.COMMON_KNOWLEDGE.column, Categories.COMMON_KNOWLEDGE.category);
    }

    private void bestRecordGeographyButtonActionPerformed(ActionEvent e) {
        recordSelected(UserColumns.GEOGRAPHY.column, Categories.GEOGRAPHY.category);
    }

    private void recordSelected(String column, String category) {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);
        this.setVisible(false);
        new ScoreBoard(this, Database.getUserOrderedByRecords(column), category);
    }

    private void singlePlayerWindowClosing(WindowEvent e) {
        previousPage();
    }

    private void previousButtonActionPerformed(ActionEvent e) {
        previousPage();
    }

    private void previousPage() {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);
        this.dispose();
        dashboard.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Panel = new JPanel();
        title = new JLabel();
        categoriesLabel = new JLabel();
        category1 = new JButton();
        category2 = new JButton();
        category3 = new JButton();
        category5 = new JButton();
        category4 = new JButton();
        category6 = new JButton();
        previousButton = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        bestRecordEnglishButton = new JButton();
        bestRecordMathButton = new JButton();
        bestRecordFoodButton = new JButton();
        bestRecordScienceButton = new JButton();
        bestRecordCommonButton = new JButton();
        bestRecordGeographyButton = new JButton();
        yourRecordEnglishLabel = new JLabel();
        yourRecordMathLabel = new JLabel();
        yourRecordFoodLabel = new JLabel();
        yourRecordScienceLabel = new JLabel();
        yourRecordCommonLabel = new JLabel();
        yourRecordGeographyLabel = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setMaximizedBounds(new Rectangle(580, 60, 380, 605));
        setResizable(false);
        setTitle("Single player");
        setBackground(new Color(0, 112, 192));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo (1).jpg")).getImage());
        setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                singlePlayerWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //======== Panel ========
        {
            Panel.setBackground(new Color(0, 112, 192));

            //---- title ----
            title.setText("Singleplayer");
            title.setFont(new Font("Comic Sans MS", Font.BOLD, 39));
            title.setBackground(new Color(153, 0, 255));
            title.setForeground(new Color(255, 204, 102));

            //---- categoriesLabel ----
            categoriesLabel.setText("Categories:");
            categoriesLabel.setBackground(new Color(255, 153, 0));
            categoriesLabel.setForeground(new Color(255, 153, 0));
            categoriesLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

            //---- category1 ----
            category1.setText("English");
            category1.setBackground(new Color(0, 32, 96));
            category1.setForeground(Color.white);
            category1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            category1.setFocusable(false);
            category1.setBorder(null);
            category1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            category1.addActionListener(e -> category1ActionPerformed(e));

            //---- category2 ----
            category2.setText("Mathematics");
            category2.setBackground(new Color(0, 32, 96));
            category2.setForeground(Color.white);
            category2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            category2.setFocusable(false);
            category2.setBorder(null);
            category2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            category2.addActionListener(e -> category2ActionPerformed(e));

            //---- category3 ----
            category3.setText("Food & Drink");
            category3.setBackground(new Color(0, 32, 96));
            category3.setForeground(Color.white);
            category3.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            category3.setFocusable(false);
            category3.setBorder(null);
            category3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            category3.addActionListener(e -> category3ActionPerformed(e));

            //---- category5 ----
            category5.setText("Common Knowledge");
            category5.setBackground(new Color(0, 32, 96));
            category5.setForeground(Color.white);
            category5.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
            category5.setFocusable(false);
            category5.setBorder(null);
            category5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            category5.addActionListener(e -> category5ActionPerformed(e));

            //---- category4 ----
            category4.setText("Science");
            category4.setBackground(new Color(0, 32, 96));
            category4.setForeground(Color.white);
            category4.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            category4.setFocusable(false);
            category4.setBorder(null);
            category4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            category4.addActionListener(e -> category4ActionPerformed(e));

            //---- category6 ----
            category6.setText("Geography");
            category6.setBackground(new Color(0, 32, 96));
            category6.setForeground(Color.white);
            category6.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            category6.setFocusable(false);
            category6.setBorder(null);
            category6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            category6.addActionListener(e -> category6ActionPerformed(e));

            //---- previousButton ----
            previousButton.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/previous.png")));
            previousButton.setBackground(new Color(0, 112, 192));
            previousButton.setFocusable(false);
            previousButton.setBorder(null);
            previousButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            previousButton.addActionListener(e -> previousButtonActionPerformed(e));

            //---- label1 ----
            label1.setText(" best ");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setForeground(Color.white);
            label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- label2 ----
            label2.setText("record");
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setForeground(Color.white);
            label2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- label3 ----
            label3.setText("your");
            label3.setHorizontalAlignment(SwingConstants.CENTER);
            label3.setForeground(Color.white);
            label3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- label4 ----
            label4.setText("record");
            label4.setHorizontalAlignment(SwingConstants.CENTER);
            label4.setForeground(Color.white);
            label4.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- bestRecordEnglishButton ----
            bestRecordEnglishButton.setHorizontalAlignment(SwingConstants.CENTER);
            bestRecordEnglishButton.setForeground(Color.white);
            bestRecordEnglishButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            bestRecordEnglishButton.setBorder(null);
            bestRecordEnglishButton.setFocusable(false);
            bestRecordEnglishButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            bestRecordEnglishButton.addActionListener(e -> bestRecordEnglishButtonActionPerformed(e));

            //---- bestRecordMathButton ----
            bestRecordMathButton.setHorizontalAlignment(SwingConstants.CENTER);
            bestRecordMathButton.setForeground(Color.white);
            bestRecordMathButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            bestRecordMathButton.setBorder(null);
            bestRecordMathButton.setFocusable(false);
            bestRecordMathButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            bestRecordMathButton.addActionListener(e -> bestRecordMathButtonActionPerformed(e));

            //---- bestRecordFoodButton ----
            bestRecordFoodButton.setHorizontalAlignment(SwingConstants.CENTER);
            bestRecordFoodButton.setForeground(Color.white);
            bestRecordFoodButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            bestRecordFoodButton.setBorder(null);
            bestRecordFoodButton.setFocusable(false);
            bestRecordFoodButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            bestRecordFoodButton.addActionListener(e -> bestRecordFoodButtonActionPerformed(e));

            //---- bestRecordScienceButton ----
            bestRecordScienceButton.setHorizontalAlignment(SwingConstants.CENTER);
            bestRecordScienceButton.setForeground(Color.white);
            bestRecordScienceButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            bestRecordScienceButton.setBorder(null);
            bestRecordScienceButton.setFocusable(false);
            bestRecordScienceButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            bestRecordScienceButton.addActionListener(e -> bestRecordScienceButtonActionPerformed(e));

            //---- bestRecordCommonButton ----
            bestRecordCommonButton.setHorizontalAlignment(SwingConstants.CENTER);
            bestRecordCommonButton.setForeground(Color.white);
            bestRecordCommonButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            bestRecordCommonButton.setBorder(null);
            bestRecordCommonButton.setFocusable(false);
            bestRecordCommonButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            bestRecordCommonButton.addActionListener(e -> bestRecordCommonButtonActionPerformed(e));

            //---- bestRecordGeographyButton ----
            bestRecordGeographyButton.setHorizontalAlignment(SwingConstants.CENTER);
            bestRecordGeographyButton.setForeground(Color.white);
            bestRecordGeographyButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            bestRecordGeographyButton.setBorder(null);
            bestRecordGeographyButton.setFocusable(false);
            bestRecordGeographyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            bestRecordGeographyButton.addActionListener(e -> bestRecordGeographyButtonActionPerformed(e));

            //---- yourRecordEnglishLabel ----
            yourRecordEnglishLabel.setHorizontalAlignment(SwingConstants.CENTER);
            yourRecordEnglishLabel.setForeground(Color.white);
            yourRecordEnglishLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- yourRecordMathLabel ----
            yourRecordMathLabel.setHorizontalAlignment(SwingConstants.CENTER);
            yourRecordMathLabel.setForeground(Color.white);
            yourRecordMathLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- yourRecordFoodLabel ----
            yourRecordFoodLabel.setHorizontalAlignment(SwingConstants.CENTER);
            yourRecordFoodLabel.setForeground(Color.white);
            yourRecordFoodLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- yourRecordScienceLabel ----
            yourRecordScienceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            yourRecordScienceLabel.setForeground(Color.white);
            yourRecordScienceLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- yourRecordCommonLabel ----
            yourRecordCommonLabel.setHorizontalAlignment(SwingConstants.CENTER);
            yourRecordCommonLabel.setForeground(Color.white);
            yourRecordCommonLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- yourRecordGeographyLabel ----
            yourRecordGeographyLabel.setHorizontalAlignment(SwingConstants.CENTER);
            yourRecordGeographyLabel.setForeground(Color.white);
            yourRecordGeographyLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            GroupLayout PanelLayout = new GroupLayout(Panel);
            Panel.setLayout(PanelLayout);
            PanelLayout.setHorizontalGroup(
                    PanelLayout.createParallelGroup()
                            .addGroup(PanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(PanelLayout.createParallelGroup()
                                            .addGroup(PanelLayout.createSequentialGroup()
                                                    .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                                                    .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                            .addComponent(category4, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                                                            .addComponent(category3, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                                                            .addComponent(category2, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                                                            .addComponent(category6, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                                                            .addComponent(category5, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                                                            .addComponent(category1, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                                                                    .addGap(18, 18, 18)
                                                                    .addGroup(PanelLayout.createParallelGroup()
                                                                            .addComponent(bestRecordEnglishButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(bestRecordCommonButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(bestRecordGeographyButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(bestRecordScienceButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(bestRecordFoodButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(bestRecordMathButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                                                    .addComponent(categoriesLabel)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
                                                    .addGap(36, 36, 36)
                                                    .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(yourRecordEnglishLabel, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                            .addComponent(label4, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                            .addComponent(yourRecordGeographyLabel, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                            .addComponent(yourRecordScienceLabel, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                            .addComponent(yourRecordCommonLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                            .addComponent(yourRecordFoodLabel, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                            .addComponent(yourRecordMathLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                            .addComponent(label3, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)))
                                            .addGroup(PanelLayout.createSequentialGroup()
                                                    .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(title)))
                                    .addContainerGap())
            );
            PanelLayout.setVerticalGroup(
                    PanelLayout.createParallelGroup()
                            .addGroup(PanelLayout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addGroup(PanelLayout.createParallelGroup()
                                            .addComponent(previousButton)
                                            .addComponent(title))
                                    .addGap(18, 18, 18)
                                    .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(categoriesLabel)
                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                    .addGap(3, 3, 3)
                                    .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label4)
                                            .addComponent(label2))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addGroup(PanelLayout.createSequentialGroup()
                                                    .addGroup(PanelLayout.createParallelGroup()
                                                            .addComponent(bestRecordEnglishButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(category1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(13, 13, 13)
                                                    .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                            .addComponent(bestRecordMathButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(category2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(PanelLayout.createSequentialGroup()
                                                    .addComponent(yourRecordEnglishLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(yourRecordMathLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelLayout.createParallelGroup()
                                            .addGroup(PanelLayout.createSequentialGroup()
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(PanelLayout.createParallelGroup()
                                                            .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                                                    .addComponent(category3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addComponent(category4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                                                    .addComponent(bestRecordFoodButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(12, 12, 12)
                                                                    .addComponent(bestRecordScienceButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(PanelLayout.createParallelGroup()
                                                            .addComponent(bestRecordCommonButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(category5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                                    .addGap(11, 11, 11)
                                                    .addComponent(yourRecordFoodLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(yourRecordScienceLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(yourRecordCommonLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(PanelLayout.createParallelGroup()
                                            .addGroup(PanelLayout.createSequentialGroup()
                                                    .addComponent(yourRecordGeographyLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 41, Short.MAX_VALUE))
                                            .addGroup(PanelLayout.createSequentialGroup()
                                                    .addGroup(PanelLayout.createParallelGroup()
                                                            .addComponent(bestRecordGeographyButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(category6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                                    .addContainerGap(41, Short.MAX_VALUE))))
            );
        }

        ProfileSettings.GroupLayoutSettings(contentPane, Panel);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel Panel;
    private JLabel title;
    private JLabel categoriesLabel;
    private JButton category1;
    private JButton category2;
    private JButton category3;
    private JButton category5;
    private JButton category4;
    private JButton category6;
    private JButton previousButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton bestRecordEnglishButton;
    private JButton bestRecordMathButton;
    private JButton bestRecordFoodButton;
    private JButton bestRecordScienceButton;
    private JButton bestRecordCommonButton;
    private JButton bestRecordGeographyButton;
    private JLabel yourRecordEnglishLabel;
    private JLabel yourRecordMathLabel;
    private JLabel yourRecordFoodLabel;
    private JLabel yourRecordScienceLabel;
    private JLabel yourRecordCommonLabel;
    private JLabel yourRecordGeographyLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
