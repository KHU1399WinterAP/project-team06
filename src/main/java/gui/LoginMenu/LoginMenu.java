/*
 * Created by JFormDesigner on Thu Mar 11 15:23:19 IRST 2021
 */

package main.java.gui.LoginMenu;

import main.java.animations.RunAnimation;
import main.java.config.FontConfig;
import main.java.config.GuiConfig;
import main.java.database.Database;
import main.java.gui.Dashord.Dashboard;
import main.java.gui.RegisterMenu.RegisterMenu;
import main.java.models.User;

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
        previousPage();
    }

    private void loginButtonActionPerformed(ActionEvent e) {
        String username = inputUsername.getText();
        int password = Objects.hash(String.valueOf(inputPassword.getPassword()));
        if (!username.isBlank()) {
            User user = Database.getUserByUsername(username);
            if (user != null && user.password == password) {
                new Dashboard(LoginRegisterMenu, user,String.valueOf(inputPassword.getPassword()));
                this.dispose();
                return;
            }
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        mainBackground = new JPanel();
        textLabel = new JLabel();
        faceLabel = new JLabel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        inputPassword = new JPasswordField();
        loginButton = new JButton();
        previousButton = new JButton();
        inputUsername = new JTextArea();

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

            //---- passwordLabel ----
            passwordLabel.setText("Password");
            passwordLabel.setForeground(Color.white);
            passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- inputPassword ----
            inputPassword.setBackground(Color.white);
            inputPassword.setForeground(new Color(0, 32, 96));
            inputPassword.setBorder(null);

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
            previousButton.setBackground(new Color(137, 0, 0, 209));
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

            GroupLayout mainBackgroundLayout = new GroupLayout(mainBackground);
            mainBackground.setLayout(mainBackgroundLayout);
            mainBackgroundLayout.setHorizontalGroup(
                mainBackgroundLayout.createParallelGroup()
                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                        .addGroup(mainBackgroundLayout.createParallelGroup()
                            .addGroup(mainBackgroundLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(textLabel))
                            .addGroup(mainBackgroundLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(faceLabel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(mainBackgroundLayout.createParallelGroup()
                            .addComponent(usernameLabel)
                            .addComponent(inputPassword, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputUsername, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel)
                            .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
            );
            mainBackgroundLayout.setVerticalGroup(
                mainBackgroundLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(faceLabel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(mainBackground, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(mainBackground, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel mainBackground;
    private JLabel textLabel;
    private JLabel faceLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JPasswordField inputPassword;
    private JButton loginButton;
    private JButton previousButton;
    private JTextArea inputUsername;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
