/*
 * Created by JFormDesigner on Sat Mar 06 18:47:16 IRST 2021
 */

package main.java.gui.LoginRegisterMenu;

import main.java.config.FontConfig;
import main.java.config.MusicConfig;
import main.java.config.SpriteConfig;
import main.java.gui.LoginMenu.LoginMenu;
import main.java.gui.RegisterMenu.RegisterMenu;
import main.java.socket.Client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Alireza
 */
public class LoginRegisterMenu extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel mainBackground;
    private JLabel Banner;
    private JButton loginButton;
    private JButton registerButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static Client CLIENT;

    public LoginRegisterMenu(Client client) {
        FontConfig.initFonts();
        MusicConfig.initLongMusic(MusicConfig.LoginSong);
        CLIENT = client;
        initComponents();
        initComponentsProperties();
        this.setVisible(true);
    }

    private void createUIComponents() {
        mainBackground = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(SpriteConfig.BACKGROUND, 0, 0, this);
            }
        };
    }

    private void RegisterActionPerformed(ActionEvent e) {
        new RegisterMenu(this,CLIENT);
        this.setVisible(false);
    }

    private void LoginActionPerformed(ActionEvent e) {
        new LoginMenu(this,CLIENT);
        this.setVisible(false);
    }

    private void initComponentsProperties() {
        loginButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 30));
        registerButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 25));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        createUIComponents();

        Banner = new JLabel();
        loginButton = new JButton();
        registerButton = new JButton();

        //======== this ========
        setResizable(false);
        setMinimumSize(new Dimension(380, 605));
        setMaximizedBounds(new Rectangle(530, 60, 380, 605));
        setBackground(new Color(0, 112, 192));
        setTitle("Quiz Of Kings");
        setFont(new Font("Calibri", Font.PLAIN, 14));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo.jpg")).getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== mainBackground ========
        {
            mainBackground.setMaximumSize(new Dimension(380, 605));
            mainBackground.setMinimumSize(new Dimension(380, 605));
            mainBackground.setBackground(new Color(0, 112, 192));
            mainBackground.setLayout(null);

            //---- Banner ----
            Banner.setFont(new Font("Calibri", Font.PLAIN, 54));
            Banner.setForeground(Color.white);
            Banner.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/banner.png")));
            mainBackground.add(Banner);
            Banner.setBounds(new Rectangle(new Point(14, 72), Banner.getPreferredSize()));

            //---- loginButton ----
            loginButton.setText("LOGIN");
            loginButton.setFont(loginButton.getFont().deriveFont(Font.PLAIN, loginButton.getFont().getSize() + 15f));
            loginButton.setBackground(new Color(0, 32, 96));
            loginButton.setFocusable(false);
            loginButton.setForeground(Color.white);
            loginButton.setBorder(null);
            loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            loginButton.addActionListener(e -> LoginActionPerformed(e));
            mainBackground.add(loginButton);
            loginButton.setBounds(25, 350, 166, 77);

            //---- registerButton ----
            registerButton.setText("REGISTER");
            registerButton.setFont(registerButton.getFont().deriveFont(Font.PLAIN, registerButton.getFont().getSize() + 15f));
            registerButton.setBackground(new Color(0, 32, 96));
            registerButton.setFocusable(false);
            registerButton.setForeground(Color.white);
            registerButton.setBorder(null);
            registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            registerButton.addActionListener(e -> RegisterActionPerformed(e));
            mainBackground.add(registerButton);
            registerButton.setBounds(195, 350, 164, 77);

            {
                // compute preferred size
                RegisterMenu.preferSize(mainBackground);
            }
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(mainBackground, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(mainBackground, GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
