/*
 * Created by JFormDesigner on Thu Mar 11 15:23:19 IRST 2021
 */

package main.java.gui.LoginMenu;

import main.java.animations.RunAnimation;
import main.java.config.FontConfig;
import main.java.config.GuiConfig;
import main.java.gui.Dashboard.Dashboard;
import main.java.models.User;
import main.java.socket.Client;
import main.java.socket.Requests;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Sina
 */
public class LoginMenu extends JFrame {

    private final JFrame LoginRegisterMenu;
    private final Client CLIENT;

    public LoginMenu(JFrame LoginRegisterMenu, Client client) {
        this.CLIENT = client;
        this.LoginRegisterMenu = LoginRegisterMenu;
        initComponents();
        initComponentsProperties();
        this.setVisible(true);
    }

    private void initComponentsProperties() {
        inputPassword.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        inputUsername.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        usernameLabel.setFont(FontConfig.comic.deriveFont(Font.ITALIC, 14));
        passwordLabel.setFont(FontConfig.comic.deriveFont(Font.ITALIC, 14));
        loginButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 20));
        previousButton.setFont(FontConfig.comic.deriveFont(Font.ITALIC, 10));
    }

    private void PreviousButtonActionPerformed(ActionEvent e) {
        previousPage();
    }

    private void loginButtonActionPerformed(ActionEvent e) {
        loginButton();
    }

    private void loginButton(){
        String username = inputUsername.getText().replace("\n","");
        String password = String.valueOf(inputPassword.getPassword());
        int passwordHash = Objects.hash(password);

        CLIENT.sendRequest(Requests.LOGIN.request);
        CLIENT.sendRequest(username);
        CLIENT.sendRequest(String.valueOf(passwordHash));

        String response=CLIENT.getResponse();
        if (response.equals(Requests.ACCEPT.request)) {
            User user =new User(username,passwordHash, CLIENT.getResponseInt(),
                    CLIENT.getResponseInt(),CLIENT.getResponseInt(),
                    CLIENT.getResponseInt(),CLIENT.getResponseInt(),
                    CLIENT.getResponseInt(),CLIENT.getResponseInt(),
                    CLIENT.getResponseInt(),CLIENT.getResponseInt());

            new Dashboard(LoginRegisterMenu, user, password,CLIENT);
            this.dispose();
            return;
        }

        RunAnimation.runMainPanelBackgroundColorAnimation(mainBackground, GuiConfig.COLOR_DEFAULT_BLUE);
    }

    private void loginMenuWindowClosing(WindowEvent e) {
        previousPage();
    }

    private void previousPage() {
        this.dispose();
        LoginRegisterMenu.setVisible(true);
    }

    private void inputUsernameKeyPressed(KeyEvent e) {
        if (e.getKeyCode()==10)
            inputPassword.requestFocus();

    }

    private void inputPasswordKeyPressed(KeyEvent e) {
        if (e.getKeyCode()==10)
            loginButton();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        mainBackground = new JPanel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        inputPassword = new JPasswordField();
        loginButton = new JButton();
        previousButton = new JButton();
        inputUsername = new JTextArea();
        PictureLabel = new JLabel();
        label1 = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setMaximizedBounds(new Rectangle(530, 60, 380, 605));
        setBackground(new Color(0, 112, 192));
        setTitle("Login Menu");
        setFont(new Font("Calibri", Font.PLAIN, 14));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo.jpg")).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);
        setName("LoginMenu");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginMenuWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //======== mainBackground ========
        {
            mainBackground.setMaximumSize(new Dimension(380, 605));
            mainBackground.setMinimumSize(new Dimension(380, 605));
            mainBackground.setBackground(new Color(0, 112, 192));
            mainBackground.setFocusable(false);

            //---- usernameLabel ----
            usernameLabel.setText("Username");
            usernameLabel.setForeground(Color.white);
            usernameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- passwordLabel ----
            passwordLabel.setText("Password");
            passwordLabel.setForeground(Color.white);
            passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- inputPassword ----
            inputPassword.setBackground(Color.white);
            inputPassword.setForeground(new Color(0, 32, 96));
            inputPassword.setBorder(null);
            inputPassword.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    inputPasswordKeyPressed(e);
                }
            });

            //---- loginButton ----
            loginButton.setText("LOGIN");
            loginButton.setForeground(Color.white);
            loginButton.setBackground(new Color(0, 32, 96));
            loginButton.setFocusable(false);
            loginButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            loginButton.setBorder(null);
            loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            loginButton.addActionListener(e -> loginButtonActionPerformed(e));

            //---- previousButton ----
            previousButton.setText("PREVIOUS");
            previousButton.setBackground(new Color(157, 0, 0));
            previousButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
            previousButton.setForeground(Color.white);
            previousButton.setAlignmentX(16.0F);
            previousButton.setFocusable(false);
            previousButton.setBorder(null);
            previousButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            previousButton.addActionListener(e -> PreviousButtonActionPerformed(e));

            //---- inputUsername ----
            inputUsername.setBackground(Color.white);
            inputUsername.setForeground(new Color(0, 32, 96));
            inputUsername.setLineWrap(true);
            inputUsername.setTabSize(10);
            inputUsername.setAlignmentX(1.5F);
            inputUsername.setAlignmentY(1.5F);
            inputUsername.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    inputUsernameKeyPressed(e);
                }
            });

            //---- PictureLabel ----
            PictureLabel.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/icon@2x.png")));

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/appTitle.png")));

            GroupLayout mainBackgroundLayout = new GroupLayout(mainBackground);
            mainBackground.setLayout(mainBackgroundLayout);
            mainBackgroundLayout.setHorizontalGroup(
                mainBackgroundLayout.createParallelGroup()
                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                        .addContainerGap(38, Short.MAX_VALUE)
                        .addComponent(PictureLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(mainBackgroundLayout.createParallelGroup()
                            .addComponent(inputPassword, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputUsername, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameLabel)
                            .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            mainBackgroundLayout.setVerticalGroup(
                mainBackgroundLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(mainBackgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PictureLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputUsername, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(mainBackground, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(mainBackground, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel mainBackground;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JPasswordField inputPassword;
    private JButton loginButton;
    private JButton previousButton;
    private JTextArea inputUsername;
    private JLabel PictureLabel;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
