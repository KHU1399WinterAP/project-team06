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
        label1 = new JLabel();
        button1 = new JButton();
        Register = new JButton();
        label2 = new JLabel();

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

            //---- label1 ----
            label1.setText("Quiz Of Kings");
            label1.setFont(new Font("Calibri", Font.PLAIN, 54));

            //---- button1 ----
            button1.setText("Login");
            button1.setFont(button1.getFont().deriveFont(Font.PLAIN, button1.getFont().getSize() + 15f));
            button1.setBackground(new Color(0, 32, 96));

            //---- Register ----
            Register.setText("Register");
            Register.setFont(Register.getFont().deriveFont(Font.PLAIN, Register.getFont().getSize() + 15f));
            Register.setBackground(new Color(0, 32, 96));

            //---- label2 ----
            label2.setText("text");
            label2.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Logo.jpg")));

            GroupLayout MainBackgroundLayout = new GroupLayout(MainBackground);
            MainBackground.setLayout(MainBackgroundLayout);
            MainBackgroundLayout.setHorizontalGroup(
                MainBackgroundLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addGap(42, 42, 42))
                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                        .addGroup(MainBackgroundLayout.createParallelGroup()
                            .addGroup(MainBackgroundLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(Register, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainBackgroundLayout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            MainBackgroundLayout.setVerticalGroup(
                MainBackgroundLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(MainBackgroundLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Register, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private JLabel label1;
    private JButton button1;
    private JButton Register;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
