/*
 * Created by JFormDesigner on Wed May 26 11:42:20 IRDT 2021
 */

package main.java.gui.chooseCategory;

import java.awt.event.*;

import main.java.config.FontConfig;
import main.java.config.ThemeConfig;
import main.java.gui.Dashboard.Dashboard;
import main.java.gui.MultiplayerQuestion.MultiplayerQuestion;
import main.java.models.Question;
import main.java.questionTypes.QuestionTypes;
import main.java.socket.Client;
import main.java.socket.RandomCategory;
import main.java.socket.ReceiveCategoryName;
import main.java.socket.Requests;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class ChooseCategory extends JFrame {
    Client CLIENT;
    JFrame dashboard;

    public ChooseCategory(Client client, JFrame dashboard) {
        this.dashboard=dashboard;
        this.CLIENT = client;
        initComponents();
        new RandomCategory(categoryButton1, categoryButton2, CLIENT, turn).start();
        initListeners();
        initCostume();
        initComponentsProperties();
        this.setVisible(true);
        new ReceiveCategoryName(CLIENT, selectedCategory, this,dashboard).start();
    }

    private void initCostume() {
        panel.setBackground(ThemeConfig.background);
        categoryButton1.setBackground(ThemeConfig.button);
        categoryButton2.setBackground(ThemeConfig.button);
    }

    private void initComponentsProperties() {
        label1.setFont(FontConfig.comic.deriveFont(Font.BOLD, 22));
        categoryButton1.setFont(FontConfig.comic.deriveFont(Font.BOLD, 17));
        categoryButton2.setFont(FontConfig.comic.deriveFont(Font.BOLD, 17));
        turn.setFont(FontConfig.comic.deriveFont(Font.ITALIC, 16));
        selectedCategory.setFont(FontConfig.comic.deriveFont(Font.BOLD, 22));
    }

    private void initListeners() {
        categoryButton1.addActionListener(e -> sendCategory(categoryButton1));
        categoryButton2.addActionListener(e -> sendCategory(categoryButton2));
    }

    private void sendCategory(JButton button) {
        CLIENT.sendRequest(Requests.SEND_SELECTED_CATEGORY.request);
        CLIENT.sendRequest(button.getText());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel = new JPanel();
        label1 = new JLabel();
        categoryButton1 = new JButton();
        categoryButton2 = new JButton();
        turn = new JLabel();
        selectedCategory = new JLabel();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo.jpg")).getImage());
        setTitle("Select category");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel ========
        {
            panel.setBackground(new Color(255, 102, 102));
            panel.setLayout(null);

            //---- label1 ----
            label1.setText("Choose a category");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setForeground(Color.white);
            label1.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
            panel.add(label1);
            label1.setBounds(50, 105, 225, 60);

            //---- categoryButton1 ----
            categoryButton1.setForeground(Color.white);
            categoryButton1.setBorder(null);
            categoryButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            categoryButton1.setFocusable(false);
            categoryButton1.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
            panel.add(categoryButton1);
            categoryButton1.setBounds(100, 195, 150, 75);

            //---- categoryButton2 ----
            categoryButton2.setForeground(Color.white);
            categoryButton2.setBorder(null);
            categoryButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            categoryButton2.setFocusable(false);
            categoryButton2.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
            panel.add(categoryButton2);
            categoryButton2.setBounds(100, 280, 150, 70);

            //---- turn ----
            turn.setForeground(Color.white);
            turn.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
            turn.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(turn);
            turn.setBounds(75, 360, 200, 45);

            //---- selectedCategory ----
            selectedCategory.setForeground(Color.white);
            selectedCategory.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            selectedCategory.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(selectedCategory);
            selectedCategory.setBounds(75, 420, 200, 55);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < panel.getComponentCount(); i++) {
                    Rectangle bounds = panel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel.setMinimumSize(preferredSize);
                panel.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel);
        panel.setBounds(0, 0, 375, 585);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel;
    private JLabel label1;
    private JButton categoryButton1;
    private JButton categoryButton2;
    private JLabel turn;
    private JLabel selectedCategory;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
