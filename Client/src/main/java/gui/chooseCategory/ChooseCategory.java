/*
 * Created by JFormDesigner on Wed May 26 11:42:20 IRDT 2021
 */

package main.java.gui.chooseCategory;

import java.awt.event.*;

import main.java.config.ThemeConfig;
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

    public ChooseCategory(Client client) {
        this.CLIENT = client;
        initComponents();
        new RandomCategory(categoryButton1,categoryButton2,CLIENT,turn).start();
        initListeners();
        initCostume();
        this.setVisible(true);
        new ReceiveCategoryName(this,CLIENT).start();
    }

    private void initCostume(){
        panel.setBackground(ThemeConfig.background);
        categoryButton1.setBackground(ThemeConfig.button);
        categoryButton2.setBackground(ThemeConfig.button);
    }

    private void initListeners() {
        categoryButton1.addActionListener(e -> {
            CLIENT.sendRequest("SEND_SELECTED_CATEGORY");
            CLIENT.sendRequest(categoryButton1.getText());
            this.dispose();
        });
        categoryButton2.addActionListener(e -> {
            CLIENT.sendRequest("SEND_SELECTED_CATEGORY");
            CLIENT.sendRequest(categoryButton2.getText());
            this.dispose();
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel = new JPanel();
        label1 = new JLabel();
        categoryButton1 = new JButton();
        categoryButton2 = new JButton();
        turn = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel ========
        {
            panel.setBackground(new Color(255, 102, 102));
            panel.setLayout(null);

            //---- label1 ----
            label1.setText("Choose a category");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(label1);
            label1.setBounds(100, 170, 175, 60);
            panel.add(categoryButton1);
            categoryButton1.setBounds(55, 250, 115, 65);
            panel.add(categoryButton2);
            categoryButton2.setBounds(185, 250, 130, 65);
            panel.add(turn);
            turn.setBounds(120, 345, 125, 35);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel.getComponentCount(); i++) {
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
        panel.setBounds(0, 0, 380, 560);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
