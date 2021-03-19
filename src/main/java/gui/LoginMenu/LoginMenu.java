/*
 * Created by JFormDesigner on Thu Mar 11 15:23:19 IRST 2021
 */

package main.java.gui.LoginMenu;

import main.java.config.FontConfig;
import main.java.database.Database;
import main.java.gui.Dashord.Dashboard;
import main.java.gui.RegisterMenu.RegisterMenu;
import main.java.models.User;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Sina
 */
public class LoginMenu extends JFrame {

    private final JFrame LoginRegisterMenu;

    public LoginMenu(JFrame LoginRegisterMenu) {
        this.LoginRegisterMenu = LoginRegisterMenu;
        initComponents();
        initComponentsProperties();
      this.setVisible(true);
    }

    private void initComponentsProperties() {
        inputPassword.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        inputUsername.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        textLabel.setFont(FontConfig.comic.deriveFont(Font.BOLD, 50));
        usernameLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        passwordLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        loginButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 20));
        previousButton.setFont(FontConfig.comic.deriveFont(Font.ITALIC, 10));

    }

    private void PreviousButtonActionPerformed(ActionEvent e) {
        this.dispose();
        LoginRegisterMenu.setVisible(true);
    }

    private void loginButtonActionPerformed(ActionEvent e) {
        String username = inputUsername.getText();
        String password = String.valueOf(inputPassword.getPassword());
        if (!username.isBlank()) {
            User user = Database.getUserByUsername(username);
            if (user != null && user.password.equals(password)) {
                new Dashboard(LoginRegisterMenu,user);
                this.dispose();
                return;
            }
        }
        RegisterMenu.runMainPanelBackgroundColorAnimation(MainBackground);
    }

    private void thisWindowClosing(WindowEvent e) {
        this.dispose();
        LoginRegisterMenu.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        MainBackground = new JPanel();
        textLabel = new JLabel();
        faceLabel = new JLabel();
        usernameLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        inputUsername = new JTextArea();
        passwordLabel = new JLabel();
        inputPassword = new JPasswordField();
        loginButton = new JButton();
        previousButton = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setMaximizedBounds(new Rectangle(530, 60, 380, 605));
        setBackground(new Color(0, 112, 192));
        setTitle("Login Menu");
        setFont(new Font("Calibri", Font.PLAIN, 14));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo (1).jpg")).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);
        setName("LoginMenu");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //======== MainBackground ========
        {
            MainBackground.setMaximumSize(new Dimension(380, 605));
            MainBackground.setMinimumSize(new Dimension(380, 605));
            MainBackground.setBackground(new Color(0, 112, 192));
            MainBackground.setFocusable(false);

            //---- textLabel ----
            textLabel.setText("Quiz Of Kings");
            textLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
            textLabel.setForeground(Color.white);

            //---- faceLabel ----
            faceLabel.setText("text");
            faceLabel.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/SmallLogo.jpg")));

            //---- usernameLabel ----
            usernameLabel.setText("Username");
            usernameLabel.setForeground(Color.white);
            usernameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //======== scrollPane1 ========
            {

                //---- inputUsername ----
                inputUsername.setBackground(Color.white);
                inputUsername.setForeground(new Color(0, 32, 96));
                inputUsername.setLineWrap(true);
                inputUsername.setTabSize(10);
                inputUsername.setAlignmentX(1.5F);
                inputUsername.setAlignmentY(1.5F);
                scrollPane1.setViewportView(inputUsername);
            }

            //---- passwordLabel ----
            passwordLabel.setText("Password");
            passwordLabel.setForeground(Color.white);
            passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- inputPassword ----
            inputPassword.setBackground(Color.white);
            inputPassword.setForeground(new Color(0, 32, 96));

            //---- loginButton ----
            loginButton.setText("LOGIN");
            loginButton.setForeground(Color.white);
            loginButton.setBackground(new Color(0, 32, 96));
            loginButton.setFocusable(false);
            loginButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            loginButton.addActionListener(e -> loginButtonActionPerformed(e));

            //---- previousButton ----
            previousButton.setText("PREVIOUS");
            previousButton.setBackground(new Color(137, 0, 0, 209));
            previousButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
            previousButton.setForeground(Color.white);
            previousButton.setAlignmentX(16.0F);
            previousButton.setFocusable(false);
            previousButton.addActionListener(e -> PreviousButtonActionPerformed(e));

            GroupLayout MainBackgroundLayout = new GroupLayout(MainBackground);
            MainBackground.setLayout(MainBackgroundLayout);
            MainBackgroundLayout.setHorizontalGroup(
                MainBackgroundLayout.createParallelGroup()
                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                        .addGroup(MainBackgroundLayout.createParallelGroup()
                            .addGroup(MainBackgroundLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(textLabel))
                            .addGroup(MainBackgroundLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(faceLabel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(MainBackgroundLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                                .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137))
                            .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                                .addGroup(MainBackgroundLayout.createParallelGroup()
                                    .addComponent(inputPassword, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordLabel)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usernameLabel))
                                .addGap(88, 88, 88))))
            );
            MainBackgroundLayout.setVerticalGroup(
                MainBackgroundLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(faceLabel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textLabel)
                        .addGap(27, 27, 27)
                        .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(MainBackground, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(MainBackground, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel MainBackground;
    private JLabel textLabel;
    private JLabel faceLabel;
    private JLabel usernameLabel;
    private JScrollPane scrollPane1;
    private JTextArea inputUsername;
    private JLabel passwordLabel;
    private JPasswordField inputPassword;
    private JButton loginButton;
    private JButton previousButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
