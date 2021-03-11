/*
 * Created by JFormDesigner on Thu Mar 11 15:23:19 IRST 2021
 */

package main.java.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Sina
 */
public class LoginMenu extends JFrame {
    private final JFrame PreviousFrame;
    public LoginMenu(JFrame PreviousFrame) {
        this.PreviousFrame = PreviousFrame;
        initComponents();
    }

    private void LoginFrameWindowClosed(WindowEvent e) {
        LoginFrame.dispose();
        PreviousFrame.setVisible(true);
    }

    private void LoginButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void PreviousButtonActionPerformed(ActionEvent e) {
        LoginFrame.dispose();
        PreviousFrame.setVisible(true);
    }

    private void tryAgainButtonActionPerformed(ActionEvent e) {
        new LoginMenu(PreviousFrame);
    }

    private void RegisterFrameWindowClosed(WindowEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        LoginFrame = new JFrame();
        MainBackground = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        UsernameLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        InputUserName = new JTextArea();
        PasswordLabel = new JLabel();
        InputPassword = new JPasswordField();
        LoginButton = new JButton();
        PreviousButton = new JButton();
        tryAgainButton = new JButton();
        usernameErrorLabel = new JLabel();
        passwordErrorLabel = new JLabel();

        //======== LoginFrame ========
        {
            LoginFrame.setResizable(false);
            LoginFrame.setMinimumSize(new Dimension(380, 605));
            LoginFrame.setMaximizedBounds(new Rectangle(530, 60, 380, 605));
            LoginFrame.setBackground(new Color(0, 112, 192));
            LoginFrame.setTitle("Login Menu");
            LoginFrame.setFont(new Font("Calibri", Font.PLAIN, 14));
            LoginFrame.setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Logo.jpg")).getImage());
            LoginFrame.setVisible(true);
            LoginFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            LoginFrame.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            LoginFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    RegisterFrameWindowClosed(e);
                }
            });
            var LoginFrameContentPane = LoginFrame.getContentPane();

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
                label2.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Logo.jpg")));

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

                //---- LoginButton ----
                LoginButton.setText("Login");
                LoginButton.setForeground(Color.gray);
                LoginButton.setBackground(new Color(0, 32, 96));
                LoginButton.setFocusable(false);
                LoginButton.addActionListener(e -> LoginButtonActionPerformed(e));

                //---- PreviousButton ----
                PreviousButton.setText("previous");
                PreviousButton.setBackground(new Color(137, 0, 0, 209));
                PreviousButton.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 12));
                PreviousButton.setForeground(Color.lightGray);
                PreviousButton.setAlignmentX(16.0F);
                PreviousButton.setFocusable(false);
                PreviousButton.addActionListener(e -> PreviousButtonActionPerformed(e));

                //---- tryAgainButton ----
                tryAgainButton.setText("Try again");
                tryAgainButton.setFocusable(false);
                tryAgainButton.setVisible(false);
                tryAgainButton.addActionListener(e -> tryAgainButtonActionPerformed(e));

                //---- usernameErrorLabel ----
                usernameErrorLabel.setForeground(Color.red);
                usernameErrorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

                //---- passwordErrorLabel ----
                passwordErrorLabel.setForeground(Color.red);
                passwordErrorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

                GroupLayout MainBackgroundLayout = new GroupLayout(MainBackground);
                MainBackground.setLayout(MainBackgroundLayout);
                MainBackgroundLayout.setHorizontalGroup(
                    MainBackgroundLayout.createParallelGroup()
                        .addGroup(MainBackgroundLayout.createSequentialGroup()
                            .addContainerGap(42, Short.MAX_VALUE)
                            .addGroup(MainBackgroundLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createParallelGroup()
                                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                                        .addComponent(PasswordLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(passwordErrorLabel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                    .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                                        .addGroup(MainBackgroundLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(scrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(InputPassword, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LoginButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                        .addGap(85, 85, 85)))
                                .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                    .addGap(125, 125, 125))
                                .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                                    .addGroup(MainBackgroundLayout.createParallelGroup()
                                        .addComponent(PreviousButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tryAgainButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                    .addGap(136, 136, 136))
                                .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(44, 44, 44))
                                .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                                    .addComponent(UsernameLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(usernameErrorLabel, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())))
                );
                MainBackgroundLayout.setVerticalGroup(
                    MainBackgroundLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addGroup(MainBackgroundLayout.createParallelGroup()
                                .addComponent(UsernameLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addComponent(usernameErrorLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(MainBackgroundLayout.createParallelGroup()
                                .addComponent(PasswordLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordErrorLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(InputPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(71, 71, 71)
                            .addComponent(tryAgainButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LoginButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PreviousButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }

            GroupLayout LoginFrameContentPaneLayout = new GroupLayout(LoginFrameContentPane);
            LoginFrameContentPane.setLayout(LoginFrameContentPaneLayout);
            LoginFrameContentPaneLayout.setHorizontalGroup(
                LoginFrameContentPaneLayout.createParallelGroup()
                    .addComponent(MainBackground, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            LoginFrameContentPaneLayout.setVerticalGroup(
                LoginFrameContentPaneLayout.createParallelGroup()
                    .addComponent(MainBackground, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
            );
            LoginFrame.pack();
            LoginFrame.setLocationRelativeTo(LoginFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame LoginFrame;
    private JPanel MainBackground;
    private JLabel label1;
    private JLabel label2;
    private JLabel UsernameLabel;
    private JScrollPane scrollPane1;
    private JTextArea InputUserName;
    private JLabel PasswordLabel;
    private JPasswordField InputPassword;
    private JButton LoginButton;
    private JButton PreviousButton;
    private JButton tryAgainButton;
    private JLabel usernameErrorLabel;
    private JLabel passwordErrorLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
