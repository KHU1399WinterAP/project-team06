/*
 * Created by JFormDesigner on Sat Mar 06 18:47:16 IRST 2021
 */

package main.java.gui.LoginRegisterMenu;

import main.java.gui.LoginMenu.LoginMenu;
import main.java.gui.RegisterMenu.RegisterMenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Alireza
 */
public class LoginRegisterMenu extends JFrame {

    public LoginRegisterMenu() {
        initComponents();

    }

    private void RegisterActionPerformed(ActionEvent e) {
        new RegisterMenu(MainMenuFrame);
        MainMenuFrame.setVisible(false);

    }

    private void LoginActionPerformed(ActionEvent e) {
        new LoginMenu(MainMenuFrame);
        MainMenuFrame.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        MainMenuFrame = new JFrame();
        MainBackground = new JPanel();
        Banner = new JLabel();
        Login = new JButton();
        Register = new JButton();

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

                //---- Banner ----
                Banner.setFont(new Font("Calibri", Font.PLAIN, 54));
                Banner.setForeground(Color.white);
                Banner.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/CropedBanner2.jpg")));

                //---- Login ----
                Login.setText("Login");
                Login.setFont(Login.getFont().deriveFont(Font.PLAIN, Login.getFont().getSize() + 15f));
                Login.setBackground(new Color(0, 32, 96));
                Login.setFocusable(false);
                Login.setForeground(Color.white);
                Login.addActionListener(e -> LoginActionPerformed(e));

                //---- Register ----
                Register.setText("Register");
                Register.setFont(Register.getFont().deriveFont(Font.PLAIN, Register.getFont().getSize() + 15f));
                Register.setBackground(new Color(0, 32, 96));
                Register.setFocusable(false);
                Register.setForeground(Color.white);
                Register.addActionListener(e -> RegisterActionPerformed(e));

                GroupLayout MainBackgroundLayout = new GroupLayout(MainBackground);
                MainBackground.setLayout(MainBackgroundLayout);
                MainBackgroundLayout.setHorizontalGroup(
                    MainBackgroundLayout.createParallelGroup()
                        .addGroup(MainBackgroundLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(Banner)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(MainBackgroundLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(Login, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Register, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                            .addGap(25, 25, 25))
                );
                MainBackgroundLayout.setVerticalGroup(
                    MainBackgroundLayout.createParallelGroup()
                        .addGroup(MainBackgroundLayout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addComponent(Banner)
                            .addGap(115, 115, 115)
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
    private JLabel Banner;
    private JButton Login;
    private JButton Register;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
