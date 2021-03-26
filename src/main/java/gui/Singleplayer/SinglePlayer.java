/*
 * Created by JFormDesigner on Tue Mar 16 18:55:03 IRST 2021
 */

package main.java.gui.Singleplayer;

import main.java.config.FontConfig;
import main.java.database.Database;
import main.java.gui.Dashord.Dashboard;
import main.java.gui.Questions.Questions;
import main.java.models.Question;
import main.java.questionTypes.QuestionTypes;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Alireza
 */
public class SinglePlayer extends JFrame {
    public final JFrame dashboard;
    public SinglePlayer(JFrame dashboard) {
        this.dashboard=dashboard;
        initComponents();
        initRecords();
        initComponentsProperties();
        this.setVisible(true);
    }

    private void initRecords(){
        yourRecordEnglishLabel.setText(String.valueOf(Dashboard.activeUser.recordEnglish));
        yourRecordMathLabel.setText(String.valueOf(Dashboard.activeUser.recordMath));
        yourRecordFoodLabel.setText(String.valueOf(Dashboard.activeUser.recordFood));
        yourRecordScienceLabel.setText(String.valueOf(Dashboard.activeUser.recordScience));
        yourRecordCommonLabel.setText(String.valueOf(Dashboard.activeUser.recordCommon));
        yourRecordGeographyLabel.setText(String.valueOf(Dashboard.activeUser.recordGeography));

        bestRecordEnglishLabel.setText(String.valueOf(Database.getTheBestRecord("recordEnglish")));
        bestRecordMathLabel.setText(String.valueOf(Database.getTheBestRecord("recordMath")));
        bestRecordFoodLabel.setText(String.valueOf(Database.getTheBestRecord("recordFood")));
        bestRecordScienceLabel.setText(String.valueOf(Database.getTheBestRecord("recordScience")));
        bestRecordCommonLabel.setText(String.valueOf(Database.getTheBestRecord("recordCommon")));
        bestRecordGeographyLabel.setText(String.valueOf(Database.getTheBestRecord("recordGeography")));
    }

    private void initComponentsProperties() {
        title.setFont(FontConfig.comic.deriveFont(Font.BOLD, 30));
        categoriesLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 24));
        category1.setFont(FontConfig.comic.deriveFont(Font.BOLD, 16));
        category2.setFont(FontConfig.comic.deriveFont(Font.BOLD, 16));
        category3.setFont(FontConfig.comic.deriveFont(Font.BOLD, 16));
        category4.setFont(FontConfig.comic.deriveFont(Font.BOLD, 16));
        category5.setFont(FontConfig.comic.deriveFont(Font.BOLD, 11));
        category6.setFont(FontConfig.comic.deriveFont(Font.BOLD, 16));

        yourRecordEnglishLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        yourRecordGeographyLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        yourRecordCommonLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        yourRecordScienceLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        yourRecordFoodLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        yourRecordMathLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));

        bestRecordEnglishLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        bestRecordCommonLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        bestRecordFoodLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        bestRecordGeographyLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        bestRecordScienceLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        bestRecordMathLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));

        label1.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        label2.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        label3.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        label4.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));

    }

    private void previousButtonActionPerformed(ActionEvent e) {
        this.dispose();
        dashboard.setVisible(true);
    }

    private void whenCategoryIsSelected(ArrayList<Question> questions,int category){
        this.setVisible(false);
       var questionPanel = new Questions(this,questions,category);
       questionPanel.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosed(WindowEvent e) {
               initRecords();
           }
       });
    }

    private void category1ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.english,1);
    }

    private void category2ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.mathematics,2);
    }

    private void category3ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.foodAndDrink,3);
    }

    private void category4ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.science,4);
    }

    private void category5ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.commonKnowledge,5);
    }

    private void category6ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.geography,5);
    }

    private void singlePlayerWindowClosing(WindowEvent e) {
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
        bestRecordEnglishLabel = new JLabel();
        bestRecordMathLabel = new JLabel();
        bestRecordFoodLabel = new JLabel();
        bestRecordScienceLabel = new JLabel();
        bestRecordCommonLabel = new JLabel();
        bestRecordGeographyLabel = new JLabel();
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
            category1.addActionListener(e -> category1ActionPerformed(e));

            //---- category2 ----
            category2.setText("Mathematics");
            category2.setBackground(new Color(0, 32, 96));
            category2.setForeground(Color.white);
            category2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            category2.setFocusable(false);
            category2.addActionListener(e -> category2ActionPerformed(e));

            //---- category3 ----
            category3.setText("Food & Drink");
            category3.setBackground(new Color(0, 32, 96));
            category3.setForeground(Color.white);
            category3.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            category3.setFocusable(false);
            category3.addActionListener(e -> category3ActionPerformed(e));

            //---- category5 ----
            category5.setText("Common Knowledge");
            category5.setBackground(new Color(0, 32, 96));
            category5.setForeground(Color.white);
            category5.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
            category5.setFocusable(false);
            category5.addActionListener(e -> category5ActionPerformed(e));

            //---- category4 ----
            category4.setText("Science");
            category4.setBackground(new Color(0, 32, 96));
            category4.setForeground(Color.white);
            category4.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            category4.setFocusable(false);
            category4.addActionListener(e -> category4ActionPerformed(e));

            //---- category6 ----
            category6.setText("Geography");
            category6.setBackground(new Color(0, 32, 96));
            category6.setForeground(Color.white);
            category6.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            category6.setFocusable(false);
            category6.addActionListener(e -> category6ActionPerformed(e));

            //---- previousButton ----
            previousButton.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/leftArrow@2x.png")));
            previousButton.setBackground(new Color(0, 112, 192));
            previousButton.setFocusable(false);
            previousButton.setBorder(null);
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

            //---- bestRecordEnglishLabel ----
            bestRecordEnglishLabel.setHorizontalAlignment(SwingConstants.CENTER);
            bestRecordEnglishLabel.setForeground(Color.white);
            bestRecordEnglishLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- bestRecordMathLabel ----
            bestRecordMathLabel.setHorizontalAlignment(SwingConstants.CENTER);
            bestRecordMathLabel.setForeground(Color.white);
            bestRecordMathLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- bestRecordFoodLabel ----
            bestRecordFoodLabel.setHorizontalAlignment(SwingConstants.CENTER);
            bestRecordFoodLabel.setForeground(Color.white);
            bestRecordFoodLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- bestRecordScienceLabel ----
            bestRecordScienceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            bestRecordScienceLabel.setForeground(Color.white);
            bestRecordScienceLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- bestRecordCommonLabel ----
            bestRecordCommonLabel.setHorizontalAlignment(SwingConstants.CENTER);
            bestRecordCommonLabel.setForeground(Color.white);
            bestRecordCommonLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- bestRecordGeographyLabel ----
            bestRecordGeographyLabel.setHorizontalAlignment(SwingConstants.CENTER);
            bestRecordGeographyLabel.setForeground(Color.white);
            bestRecordGeographyLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

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
                                .addGroup(PanelLayout.createParallelGroup()
                                    .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(PanelLayout.createParallelGroup()
                                            .addGroup(PanelLayout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(category1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(category4, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                                    .addComponent(category3, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                                    .addComponent(category2, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                                    .addComponent(category6, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                                    .addComponent(category5, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(PanelLayout.createParallelGroup()
                                                    .addComponent(bestRecordEnglishLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bestRecordCommonLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bestRecordGeographyLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bestRecordScienceLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bestRecordFoodLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bestRecordMathLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(PanelLayout.createSequentialGroup()
                                                .addComponent(categoriesLabel)
                                                .addGap(69, 69, 69)
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))))
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
                                .addGap(15, 15, 15)
                                .addComponent(title)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(title)
                            .addComponent(previousButton))
                        .addGap(18, 18, 18)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(categoriesLabel)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(label2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup()
                                    .addComponent(bestRecordEnglishLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(category1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(bestRecordMathLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(bestRecordFoodLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(bestRecordScienceLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(PanelLayout.createParallelGroup()
                                    .addComponent(bestRecordCommonLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
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
                                .addGap(0, 49, Short.MAX_VALUE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup()
                                    .addComponent(bestRecordGeographyLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(category6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(49, Short.MAX_VALUE))))
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
    private JLabel bestRecordEnglishLabel;
    private JLabel bestRecordMathLabel;
    private JLabel bestRecordFoodLabel;
    private JLabel bestRecordScienceLabel;
    private JLabel bestRecordCommonLabel;
    private JLabel bestRecordGeographyLabel;
    private JLabel yourRecordEnglishLabel;
    private JLabel yourRecordMathLabel;
    private JLabel yourRecordFoodLabel;
    private JLabel yourRecordScienceLabel;
    private JLabel yourRecordCommonLabel;
    private JLabel yourRecordGeographyLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
