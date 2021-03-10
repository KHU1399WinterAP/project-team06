/*
 * Created by JFormDesigner on Sat Mar 06 18:47:16 IRST 2021
 */

package main.java.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Alireza
 */
public class LoginRegisterMenu  {

    public LoginRegisterMenu() {
        initComponents();

    }

    private void RegisterActionPerformed(ActionEvent e) {
        new RegisterMenu(MainMenuFrame);
        MainMenuFrame.setVisible(false);

    }

    private void LoginActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        MainMenuFrame = new JFrame();
        MainBackground = new JPanel();
        label1 = new JLabel();
        Login = new JButton();
        Register = new JButton();
        label2 = new JLabel();

        //======== MainMenuFrame ========
        {
            MainMenuFrame.setResizable(false);
            MainMenuFrame.setMinimumSize(new Dimension(380, 605));
            MainMenuFrame.setMaximizedBounds(new Rectangle(530, 60, 380, 605));
            MainMenuFrame.setBackground(new Color(0, 112, 192));
            MainMenuFrame.setTitle("Quiz Of Kings");
            MainMenuFrame.setFont(new Font("Calibri", Font.PLAIN, 14));
            MainMenuFrame.setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Logo.jpg")).getImage());
            MainMenuFrame.setVisible(true);
            MainMenuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            var MainMenuFrameContentPane = MainMenuFrame.getContentPane();

            //======== MainBackground ========
            {
                MainBackground.setMaximumSize(new Dimension(380, 605));
                MainBackground.setMinimumSize(new Dimension(380, 605));
                MainBackground.setBackground(new Color(0, 112, 192));

                //---- label1 ----
                label1.setText("Quiz Of Kings");
                label1.setFont(new Font("Calibri", Font.PLAIN, 54));
                label1.setForeground(Color.white);

                //---- Login ----
                Login.setText("Login");
                Login.setFont(Login.getFont().deriveFont(Font.PLAIN, Login.getFont().getSize() + 15f));
                Login.setBackground(new Color(0, 32, 96));
                Login.setFocusable(false);
                Login.addActionListener(e -> LoginActionPerformed(e));

                //---- Register ----
                Register.setText("Register");
                Register.setFont(Register.getFont().deriveFont(Font.PLAIN, Register.getFont().getSize() + 15f));
                Register.setBackground(new Color(0, 32, 96));
                Register.setFocusable(false);
                Register.addActionListener(e -> RegisterActionPerformed(e));

                //---- label2 ----
                label2.setText("text");
                label2.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Logo.jpg")));

                GroupLayout MainBackgroundLayout = new GroupLayout(MainBackground);
                MainBackground.setLayout(MainBackgroundLayout);
                MainBackgroundLayout.setHorizontalGroup(
                    MainBackgroundLayout.createParallelGroup()
                        .addGroup(MainBackgroundLayout.createSequentialGroup()
                            .addGroup(MainBackgroundLayout.createParallelGroup()
                                .addGroup(MainBackgroundLayout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(Login, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Register, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
                                .addGroup(MainBackgroundLayout.createSequentialGroup()
                                    .addGap(131, 131, 131)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(MainBackgroundLayout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(label1)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                MainBackgroundLayout.setVerticalGroup(
                    MainBackgroundLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(MainBackgroundLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Login, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Register, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }

            GroupLayout MainMenuFrameContentPaneLayout = new GroupLayout(MainMenuFrameContentPane);
            MainMenuFrameContentPane.setLayout(MainMenuFrameContentPaneLayout);
            MainMenuFrameContentPaneLayout.setHorizontalGroup(
                MainMenuFrameContentPaneLayout.createParallelGroup()
                    .addComponent(MainBackground, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
            );
            MainMenuFrameContentPaneLayout.setVerticalGroup(
                MainMenuFrameContentPaneLayout.createParallelGroup()
                    .addComponent(MainBackground, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
            );
            MainMenuFrame.pack();
            MainMenuFrame.setLocationRelativeTo(MainMenuFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame MainMenuFrame;
    private JPanel MainBackground;
    private JLabel label1;
    private JButton Login;
    private JButton Register;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
