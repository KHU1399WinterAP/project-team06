/*
 * Created by JFormDesigner on Fri Apr 02 19:54:10 IRDT 2021
 */

package main.java.gui.Singleplayer.ScoreBoard;

import main.java.config.FontConfig;
import main.java.config.ThemeConfig;
import main.java.models.ScoreBoardInformation;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Brainrain
 */

public class ScoreBoard extends JFrame {
    JFrame singlePlayer;
    ArrayList<ScoreBoardInformation> scoreBoardInformation;
    String categoryName;

    public ScoreBoard(JFrame singlePlayer, ArrayList<ScoreBoardInformation> scoreBoardInformation,String categoryName) {
        this.singlePlayer = singlePlayer;
        this.categoryName=categoryName;
        this.scoreBoardInformation = scoreBoardInformation;
        init();
        initCustomTheme();
        this.setVisible(true);
    }

    private void scoreBoardWindowClosing(WindowEvent e) {
        this.dispose();
        singlePlayer.setVisible(true);
    }

    private void previousButtonActionPerformed(ActionEvent e) {
        this.dispose();
        singlePlayer.setVisible(true);
    }

    private void initCustomTheme(){
        panel.setBackground(ThemeConfig.background);
        previousButton.setBackground(ThemeConfig.background);
    }
    private void init() {
        scrollPane1 = new JScrollPane();
        panel = new JPanel();
        previousButton = new JButton();
        categoryLabel = new JLabel();
        title = new JLabel();
        categoryNameLabel = new JLabel();


        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setMaximizedBounds(new Rectangle(580, 60, 380, 605));
        setResizable(false);
        setTitle("Score Boad");
        setBackground(new Color(0, 112, 192));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo (1).jpg")).getImage());
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
                previousButton.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/previous.png")));
                previousButton.setBackground(new Color(0, 112, 192));
                previousButton.setFocusable(false);
                previousButton.setBorder(null);
                previousButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                previousButton.addActionListener(e -> previousButtonActionPerformed(e));
                panel.add(previousButton);
                previousButton.setBounds(5, 10, 57, 48);

                //---- categoryLabel ----
                categoryLabel.setText("Category :");
                categoryLabel.setBackground(new Color(255, 153, 0));
                categoryLabel.setForeground(new Color(255, 153, 0));
                categoryLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
                panel.add(categoryLabel);
                categoryLabel.setBounds(10, 85, 125, 34);

                //---- title ----
                title.setText("Score Board");
                title.setFont(new Font("Comic Sans MS", Font.BOLD, 39));
                title.setBackground(new Color(153, 0, 255));
                title.setForeground(new Color(255, 204, 102));
                panel.add(title);
                title.setBounds(75, 10, 260, 55);
                categoryNameLabel.setText(categoryName);
                categoryNameLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 20));
                categoryNameLabel.setForeground(Color.white);
                panel.add(categoryNameLabel);
                categoryNameLabel.setBounds(155, 85, 195, 35);
                int y = 140;
                for (int i = 0; i < scoreBoardInformation.size(); i++) {
                    JLabel numberLabel=new JLabel();
                    JLabel usernameLabel = new JLabel();
                    JLabel recordLabel = new JLabel();

                    numberLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    numberLabel.setFocusable(false);
                    numberLabel.setForeground(Color.white);
                    numberLabel.setBorder(null);
                    numberLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 16));
                    panel.add(numberLabel);
                    numberLabel.setBounds(20, y, 55, 40);

                    usernameLabel.setFocusable(false);
                    usernameLabel.setForeground(Color.white);
                    usernameLabel.setBorder(null);
                    usernameLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 16));
                    panel.add(usernameLabel);
                    usernameLabel.setBounds(75, y, 200, 30);

                    recordLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    recordLabel.setFocusable(false);
                    recordLabel.setForeground(Color.white);
                    recordLabel.setBorder(null);
                    recordLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 16));
                    panel.add(recordLabel);
                    recordLabel.setBounds(280, y, 65, 30);

                    y+=40;

                    numberLabel.setText(i+1+" . ");
                    usernameLabel.setText(scoreBoardInformation.get(i).username);
                    recordLabel.setText(String.valueOf(scoreBoardInformation.get(i).record));
                }

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
            scrollPane1.setViewportView(panel);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 380, 570);

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

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JPanel panel;
    private JButton previousButton;
    private JLabel categoryLabel;
    private JLabel title;
    private JLabel categoryNameLabel;
//    private JLabel numberLabel;
//    private JLabel usernameLabel;
//    private JLabel recordLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
