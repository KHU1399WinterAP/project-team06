/*
 * Created by JFormDesigner on Tue Mar 16 18:55:03 IRST 2021
 */

package main.java.gui.Singleplayer;

import main.java.config.FontConfig;
import main.java.gui.Dashord.Dashboard;
import main.java.gui.Questions.Questions;
import main.java.models.Question;
import main.java.questionTypes.QuestionTypes;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
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
        initComponentsProperties();
        this.setVisible(true);
    }

    private void initComponentsProperties() {

        title.setFont(FontConfig.comic.deriveFont(Font.BOLD, 30));
        categoriesLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 24));
        category1.setFont(FontConfig.comic.deriveFont(Font.BOLD, 20));
        category2.setFont(FontConfig.comic.deriveFont(Font.BOLD, 20));
        category3.setFont(FontConfig.comic.deriveFont(Font.BOLD, 20));
        category4.setFont(FontConfig.comic.deriveFont(Font.BOLD, 20));
        category5.setFont(FontConfig.comic.deriveFont(Font.BOLD, 20));
        category6.setFont(FontConfig.comic.deriveFont(Font.BOLD, 20));
    }

    private void previousButtonActionPerformed(ActionEvent e) {
        this.dispose();
        dashboard.setVisible(true);
    }

    private void whenCategoryIsSelected(ArrayList<Question> questions){
        this.setVisible(false);
        new Questions(this,questions);
    }

    private void category1ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.english);
    }

    private void category2ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.mathematics);
    }

    private void category3ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.foodAndDrink);
    }

    private void category4ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.science);
    }

    private void category5ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.commonKnowledge);
    }

    private void category6ActionPerformed(ActionEvent e) {
        whenCategoryIsSelected(QuestionTypes.geography);
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
            category1.setForeground(new Color(51, 255, 51));
            category1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            category1.setFocusable(false);
            category1.addActionListener(e -> category1ActionPerformed(e));

            //---- category2 ----
            category2.setText("Mathematics");
            category2.setBackground(new Color(0, 32, 96));
            category2.setForeground(new Color(51, 255, 51));
            category2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            category2.setFocusable(false);
            category2.addActionListener(e -> category2ActionPerformed(e));

            //---- category3 ----
            category3.setText("Food & Drink");
            category3.setBackground(new Color(0, 32, 96));
            category3.setForeground(new Color(51, 255, 51));
            category3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            category3.setFocusable(false);
            category3.addActionListener(e -> category3ActionPerformed(e));

            //---- category5 ----
            category5.setText("Common Knowledge");
            category5.setBackground(new Color(0, 32, 96));
            category5.setForeground(new Color(51, 255, 51));
            category5.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            category5.setFocusable(false);
            category5.addActionListener(e -> category5ActionPerformed(e));

            //---- category4 ----
            category4.setText("Science");
            category4.setBackground(new Color(0, 32, 96));
            category4.setForeground(new Color(51, 255, 51));
            category4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            category4.setFocusable(false);
            category4.addActionListener(e -> category4ActionPerformed(e));

            //---- category6 ----
            category6.setText("Geography");
            category6.setBackground(new Color(0, 32, 96));
            category6.setForeground(new Color(51, 255, 51));
            category6.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            category6.setFocusable(false);
            category6.addActionListener(e -> category6ActionPerformed(e));

            //---- previousButton ----
            previousButton.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/leftArrow@2x.png")));
            previousButton.setBackground(new Color(0, 112, 192));
            previousButton.setFocusable(false);
            previousButton.setBorder(null);
            previousButton.addActionListener(e -> previousButtonActionPerformed(e));

            GroupLayout PanelLayout = new GroupLayout(Panel);
            Panel.setLayout(PanelLayout);
            PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup()
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(title))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(PanelLayout.createParallelGroup()
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addComponent(categoriesLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(category1, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(category6, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(category5, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(category4, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(category3, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(category2, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(32, Short.MAX_VALUE))
            );
            PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(title)
                            .addComponent(previousButton))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(categoriesLabel)
                        .addGap(26, 26, 26)
                        .addComponent(category1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(category2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(category3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(category4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(category5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(category6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
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
    private JLabel title;
    private JLabel categoriesLabel;
    private JButton category1;
    private JButton category2;
    private JButton category3;
    private JButton category5;
    private JButton category4;
    private JButton category6;
    private JButton previousButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
