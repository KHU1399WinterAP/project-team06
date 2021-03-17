/*
 * Created by JFormDesigner on Thu Mar 11 15:23:19 IRST 2021
 */

package main.java.gui.LoginMenu;

import main.java.animations.ColorChangeAnimation;
import main.java.database.Database;
import main.java.gui.Dashord.Dashbord;
import main.java.gui.RegisterMenu.RegisterMenu;
import main.java.models.User;

import java.awt.*;
import java.awt.event.*;
import java.util.function.Consumer;
import javax.swing.*;
import javax.swing.GroupLayout;

import static main.java.config.GuiConfig.COLOR_DANGER;

/**
 * @author Sina
 */
public class LoginMenu extends JFrame {

    private final JFrame LoginRegisterMenu;

    public LoginMenu(JFrame LoginRegisterMenu) {
        this.LoginRegisterMenu = LoginRegisterMenu;
        initComponents();
    }

    private void PreviousButtonActionPerformed(ActionEvent e) {
        this.dispose();
        LoginRegisterMenu.setVisible(true);
    }

    private void loginButtonActionPerformed(ActionEvent e) {
        String username = InputUserName.getText();
        String password = String.valueOf(InputPassword.getPassword());
        if (!username.isBlank()) {
            User user = Database.getUserByUsername(username);
            if (user != null && user.password.equals(password)) {
                new Dashbord(LoginRegisterMenu,user);
                this.dispose();
                return;
            }
        }
        RegisterMenu.runMainPanelBackgroundColorAnimation(MainBackground);
    }

//    private void runMainPanelBackgroundColorAnimation() {
//        Consumer<Color> stepCallback = (color) -> MainBackground.setBackground(color);
//        Runnable endCallback = () -> MainBackground.setBackground(new Color(0, 112, 192));
//        new ColorChangeAnimation(MainBackground.getBackground(), COLOR_DANGER, stepCallback, endCallback).start();
//    }

    private void thisWindowClosing(WindowEvent e) {
        this.dispose();
        LoginRegisterMenu.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        MainBackground = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        UsernameLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        InputUserName = new JTextArea();
        PasswordLabel = new JLabel();
        InputPassword = new JPasswordField();
        loginButton = new JButton();
        PreviousButton = new JButton();

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
        setVisible(true);
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

            //---- label1 ----
            label1.setText("Quiz Of Kings");
            label1.setFont(new Font("Calibri", Font.PLAIN, 54));
            label1.setForeground(Color.white);

            //---- label2 ----
            label2.setText("text");
            label2.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/SmallLogo.jpg")));

            //---- UsernameLabel ----
            UsernameLabel.setText("Username");
            UsernameLabel.setForeground(Color.white);

            //======== scrollPane1 ========
            {

                //---- InputUserName ----
                InputUserName.setBackground(Color.white);
                InputUserName.setForeground(Color.darkGray);
                InputUserName.setLineWrap(true);
                InputUserName.setTabSize(10);
                InputUserName.setAlignmentX(1.5F);
                InputUserName.setAlignmentY(1.5F);
                scrollPane1.setViewportView(InputUserName);
            }

            //---- PasswordLabel ----
            PasswordLabel.setText("Password");
            PasswordLabel.setForeground(Color.white);

            //---- InputPassword ----
            InputPassword.setBackground(Color.white);
            InputPassword.setForeground(Color.darkGray);

            //---- loginButton ----
            loginButton.setText("Login");
            loginButton.setForeground(Color.gray);
            loginButton.setBackground(new Color(0, 32, 96));
            loginButton.setFocusable(false);
            loginButton.addActionListener(e -> loginButtonActionPerformed(e));

            //---- PreviousButton ----
            PreviousButton.setText("previous");
            PreviousButton.setBackground(new Color(137, 0, 0, 209));
            PreviousButton.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 12));
            PreviousButton.setForeground(Color.lightGray);
            PreviousButton.setAlignmentX(16.0F);
            PreviousButton.setFocusable(false);
            PreviousButton.addActionListener(e -> PreviousButtonActionPerformed(e));

            GroupLayout MainBackgroundLayout = new GroupLayout(MainBackground);
            MainBackground.setLayout(MainBackgroundLayout);
            MainBackgroundLayout.setHorizontalGroup(
                MainBackgroundLayout.createParallelGroup()
                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addGap(44, 44, 44))
                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                        .addGroup(MainBackgroundLayout.createParallelGroup()
                            .addGroup(MainBackgroundLayout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(PreviousButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainBackgroundLayout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(MainBackgroundLayout.createParallelGroup()
                                    .addComponent(InputPassword, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PasswordLabel)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UsernameLabel))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            MainBackgroundLayout.setVerticalGroup(
                MainBackgroundLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsernameLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PasswordLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PreviousButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
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
    private JLabel label1;
    private JLabel label2;
    private JLabel UsernameLabel;
    private JScrollPane scrollPane1;
    private JTextArea InputUserName;
    private JLabel PasswordLabel;
    private JPasswordField InputPassword;
    private JButton loginButton;
    private JButton PreviousButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
