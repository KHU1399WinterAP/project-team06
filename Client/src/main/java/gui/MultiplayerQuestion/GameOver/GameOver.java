/*
 * Created by JFormDesigner on Sat May 29 12:35:21 IRDT 2021
 */

package main.java.gui.MultiplayerQuestion.GameOver;

import java.awt.event.*;

import main.java.gui.Dashboard.Dashboard;
import main.java.models.User;
import main.java.socket.Client;
import main.java.socket.Requests;

import java.awt.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class GameOver extends JFrame {
    Client CLIENT;
    JFrame dashboard;
    User activeUser= Dashboard.activeUser;
    public GameOver(Client client,JFrame dashboard) {
        this.dashboard=dashboard;
        this.CLIENT=client;
        initComponents();
        this.setVisible(true);
        receiveInformation();
    }

    private void receiveInformation(){
        CLIENT.sendRequest(Requests.GET_FINAL_SCORE.request);

        String username1=CLIENT.getResponse();
        int score1=CLIENT.getResponseInt();

        String username2=CLIENT.getResponse();
        int score2 =CLIENT.getResponseInt();

        usernameLabel1.setText(username1);
        usernameLabel2.setText(username2);

        scorePlayer1.setText(String.valueOf(score1));
        scorePlayer2.setText(String.valueOf(score2));

        if (score1==score2)
            result.setText("! -DRAW- !");
        else if (username1.equals(activeUser.username))
            result.setText("! YOU WON !");
        else
            result.setText("! YOU LOSt !");

    }

    private void dashboardButtonActionPerformed(ActionEvent e) {
        this.dispose();
        dashboard.setVisible(true);
    }

    private void thisWindowClosing(WindowEvent e) {
        this.dispose();
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
            panel1.add(result);
            result.setBounds(55, 155, 280, 50);

            //---- scorePlayer1 ----
            scorePlayer1.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(scorePlayer1);
            scorePlayer1.setBounds(80, 260, 95, 45);

            //---- scorePlayer2 ----
            scorePlayer2.setHorizontalAlignment(SwingConstants.CENTER);
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
            dashboardButton.addActionListener(e -> dashboardButtonActionPerformed(e));
            panel1.add(dashboardButton);
            dashboardButton.setBounds(115, 385, 155, 70);

            //---- usernameLabel1 ----
            usernameLabel1.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(usernameLabel1);
            usernameLabel1.setBounds(25, 315, 150, 45);

            //---- label6 ----
            label6.setText("__");
            label6.setHorizontalAlignment(SwingConstants.CENTER);
            label6.setForeground(Color.white);
            panel1.add(label6);
            label6.setBounds(185, 310, 20, 45);
            panel1.add(usernameLabel2);
            usernameLabel2.setBounds(215, 310, 155, 45);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
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
        panel1.setBounds(0, 0, 395, 555);

        contentPane.setPreferredSize(new Dimension(395, 595));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel result;
    private JLabel scorePlayer1;
    private JLabel scorePlayer2;
    private JLabel label4;
    private JButton dashboardButton;
    private JLabel usernameLabel1;
    private JLabel label6;
    private JLabel usernameLabel2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
