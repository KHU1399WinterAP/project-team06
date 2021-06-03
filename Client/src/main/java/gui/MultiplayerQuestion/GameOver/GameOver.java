/*
 * Created by JFormDesigner on Sat May 29 12:35:21 IRDT 2021
 */

package main.java.gui.MultiplayerQuestion.GameOver;

import java.awt.event.*;

import main.java.config.FontConfig;
import main.java.config.ThemeConfig;
import main.java.gui.Dashboard.Dashboard;
import main.java.models.User;
import main.java.socket.Client;
import main.java.socket.GetFinalScore;
import main.java.socket.Requests;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class GameOver extends JFrame {
    Client CLIENT;
    JFrame dashboard;
    public User activeUser = Dashboard.activeUser;
    GetFinalScore getFinalScore;

    public GameOver(Client client, JFrame dashboard) {
        this.dashboard = dashboard;
        this.CLIENT = client;
        initComponents();
        initCostumeTheme();
        initCostumeProperties();
        this.setVisible(true);
        getFinalScore = new GetFinalScore(this, CLIENT);
        getFinalScore.start();
        try {
            getFinalScore.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initCostumeProperties() {
        dashboardButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 18));
        result.setFont(FontConfig.comic.deriveFont(Font.BOLD, 22));

        for (JLabel jLabel : Arrays.asList(scorePlayer1, scorePlayer2, usernameLabel1, usernameLabel2))
            jLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 16));
    }

    private void initCostumeTheme() {
        panel1.setBackground(ThemeConfig.background);
        dashboardButton.setBackground(ThemeConfig.button);
    }

    private void dashboardButtonActionPerformed(ActionEvent e) {
        this.dispose();
        CLIENT.sendRequest(Requests.EXIT_MULTIPLAYER_AFTER_GAME.request);
        CLIENT.sendRequest(activeUser.username);
        dashboard.setVisible(true);
    }

    private void thisWindowClosing(WindowEvent e) {
        this.dispose();
        CLIENT.sendRequest(Requests.EXIT_MULTIPLAYER_AFTER_GAME.request);
        CLIENT.sendRequest(activeUser.username);
        dashboard.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        result = new JLabel();
        scorePlayer1 = new JLabel();
        scorePlayer2 = new JLabel();
        label4 = new JLabel();
        dashboardButton = new JButton();
        usernameLabel1 = new JLabel();
        label6 = new JLabel();
        usernameLabel2 = new JLabel();

        //======== this ========
        setTitle("GameOver");
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo.jpg")).getImage());
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(255, 102, 153));
            panel1.setLayout(null);

            //---- result ----
            result.setHorizontalAlignment(SwingConstants.CENTER);
            result.setForeground(Color.white);
            panel1.add(result);
            result.setBounds(55, 155, 280, 50);

            //---- scorePlayer1 ----
            scorePlayer1.setHorizontalAlignment(SwingConstants.CENTER);
            scorePlayer1.setForeground(Color.white);
            panel1.add(scorePlayer1);
            scorePlayer1.setBounds(80, 260, 95, 45);

            //---- scorePlayer2 ----
            scorePlayer2.setHorizontalAlignment(SwingConstants.CENTER);
            scorePlayer2.setForeground(Color.white);
            panel1.add(scorePlayer2);
            scorePlayer2.setBounds(210, 260, 95, 45);

            //---- label4 ----
            label4.setText("__");
            label4.setHorizontalAlignment(SwingConstants.CENTER);
            label4.setForeground(Color.white);
            panel1.add(label4);
            label4.setBounds(185, 260, 20, 45);

            //---- dashboardButton ----
            dashboardButton.setText("dashboard");
            dashboardButton.setForeground(Color.white);
            dashboardButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            dashboardButton.setFocusable(false);
            dashboardButton.addActionListener(e -> dashboardButtonActionPerformed(e));
            panel1.add(dashboardButton);
            dashboardButton.setBounds(115, 385, 155, 70);

            //---- usernameLabel1 ----
            usernameLabel1.setHorizontalAlignment(SwingConstants.CENTER);
            usernameLabel1.setForeground(Color.white);
            panel1.add(usernameLabel1);
            usernameLabel1.setBounds(25, 315, 150, 45);

            //---- label6 ----
            label6.setText("__");
            label6.setHorizontalAlignment(SwingConstants.CENTER);
            label6.setForeground(Color.white);
            panel1.add(label6);
            label6.setBounds(185, 310, 20, 45);

            //---- usernameLabel2 ----
            usernameLabel2.setHorizontalAlignment(SwingConstants.CENTER);
            usernameLabel2.setForeground(Color.white);
            panel1.add(usernameLabel2);
            usernameLabel2.setBounds(215, 310, 155, 45);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 395, 585);

        contentPane.setPreferredSize(new Dimension(395, 590));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    public JLabel result;
    public JLabel scorePlayer1;
    public JLabel scorePlayer2;
    private JLabel label4;
    private JButton dashboardButton;
    public JLabel usernameLabel1;
    private JLabel label6;
    public JLabel usernameLabel2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
