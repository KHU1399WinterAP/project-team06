/*
 * Created by JFormDesigner on Sat Mar 06 18:47:16 IRST 2021
 */

package main.java.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Alireza
 */
public class LoginRegisterMenu extends JFrame {
    public LoginRegisterMenu() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        MainBackground = new JPanel();
        LoginBackground = new JPanel();
        Login = new JLabel();
        RegisterBackground = new JPanel();
        Register = new JLabel();
        label1 = new JLabel();
        Logo = new JPanel();

        //======== this ========
        setResizable(false);
        setMinimumSize(new Dimension(380, 605));
        setMaximizedBounds(new Rectangle(530, 60, 380, 605));
        setBackground(new Color(0, 112, 192));
        setTitle("Quiz Of Kings");
        setFont(new Font("Calibri", Font.PLAIN, 14));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Logo.jpg")).getImage());
        var contentPane = getContentPane();

        //======== MainBackground ========
        {
            MainBackground.setMaximumSize(new Dimension(380, 605));
            MainBackground.setMinimumSize(new Dimension(380, 605));
            MainBackground.setBackground(new Color(0, 112, 192));

            //======== LoginBackground ========
            {
                LoginBackground.setBackground(new Color(0, 32, 96));

                //---- Login ----
                Login.setText("Login");
                Login.setFont(new Font("Calibri", Font.PLAIN, 32));

                GroupLayout LoginBackgroundLayout = new GroupLayout(LoginBackground);
                LoginBackground.setLayout(LoginBackgroundLayout);
                LoginBackgroundLayout.setHorizontalGroup(
                    LoginBackgroundLayout.createParallelGroup()
                        .addGroup(LoginBackgroundLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(Login)
                            .addContainerGap(41, Short.MAX_VALUE))
                );
                LoginBackgroundLayout.setVerticalGroup(
                    LoginBackgroundLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, LoginBackgroundLayout.createSequentialGroup()
                            .addContainerGap(26, Short.MAX_VALUE)
                            .addComponent(Login, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20))
                );
            }

            //======== RegisterBackground ========
            {
                RegisterBackground.setBackground(new Color(0, 32, 96));

                //---- Register ----
                Register.setText("Register");
                Register.setFont(new Font("Calibri", Font.PLAIN, 32));

                GroupLayout RegisterBackgroundLayout = new GroupLayout(RegisterBackground);
                RegisterBackground.setLayout(RegisterBackgroundLayout);
                RegisterBackgroundLayout.setHorizontalGroup(
                    RegisterBackgroundLayout.createParallelGroup()
                        .addGroup(RegisterBackgroundLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(Register)
                            .addContainerGap(22, Short.MAX_VALUE))
                );
                RegisterBackgroundLayout.setVerticalGroup(
                    RegisterBackgroundLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, RegisterBackgroundLayout.createSequentialGroup()
                            .addContainerGap(28, Short.MAX_VALUE)
                            .addComponent(Register, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18))
                );
            }

            //---- label1 ----
            label1.setText("Quiz Of Kings");
            label1.setFont(new Font("Calibri", Font.PLAIN, 54));

            //======== Logo ========
            {

                GroupLayout LogoLayout = new GroupLayout(Logo);
                Logo.setLayout(LogoLayout);
                LogoLayout.setHorizontalGroup(
                    LogoLayout.createParallelGroup()
                        .addGap(0, 100, Short.MAX_VALUE)
                );
                LogoLayout.setVerticalGroup(
                    LogoLayout.createParallelGroup()
                        .addGap(0, 100, Short.MAX_VALUE)
                );
            }

            GroupLayout MainBackgroundLayout = new GroupLayout(MainBackground);
            MainBackground.setLayout(MainBackgroundLayout);
            MainBackgroundLayout.setHorizontalGroup(
                MainBackgroundLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(LoginBackground, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RegisterBackground, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addGap(42, 42, 42))
                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(Logo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            MainBackgroundLayout.setVerticalGroup(
                MainBackgroundLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(Logo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(MainBackgroundLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(LoginBackground, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegisterBackground, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87))
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
                .addComponent(MainBackground, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel MainBackground;
    private JPanel LoginBackground;
    private JLabel Login;
    private JPanel RegisterBackground;
    private JLabel Register;
    private JLabel label1;
    private JPanel Logo;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
