/*
 * Created by JFormDesigner on Thu Mar 11 21:54:48 IRST 2021
 */

package main.java.gui.Dashord;

import main.java.gui.LoginRegisterMenu.LoginRegisterMenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Brainrain
 */
public class Dashbord extends JFrame {

    private final JFrame LoginRegisterMenu;

    public Dashbord(JFrame LoginRegisterMenu) {
        this.LoginRegisterMenu = LoginRegisterMenu;
        initComponents();
    }

    private void logoutButtonActionPerformed(ActionEvent e) {
        DashbordFrame.dispose();
        LoginRegisterMenu.setVisible(true);
    }

    private void DashbordFrameWindowClosed(WindowEvent e) {
        DashbordFrame.dispose();
        LoginRegisterMenu.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        DashbordFrame = new JFrame();
        panel1 = new JPanel();
        logoutButton = new JButton();
        label1 = new JLabel();

        //======== DashbordFrame ========
        {
            DashbordFrame.setMinimumSize(new Dimension(380, 605));
            DashbordFrame.setName("Dashbord");
            DashbordFrame.setMaximizedBounds(new Rectangle(580, 60, 380, 605));
            DashbordFrame.setResizable(false);
            DashbordFrame.setTitle("Dashbord");
            DashbordFrame.setBackground(new Color(0, 112, 192));
            DashbordFrame.setVisible(true);
            DashbordFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    DashbordFrameWindowClosed(e);
                }
            });
            var DashbordFrameContentPane = DashbordFrame.getContentPane();

            //======== panel1 ========
            {
                panel1.setBackground(new Color(0, 112, 192));

                //---- logoutButton ----
                logoutButton.setText("Log out");
                logoutButton.setFocusable(false);
                logoutButton.addActionListener(e -> logoutButtonActionPerformed(e));

                //---- label1 ----
                label1.setText("adasdasdasds");

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(111, 111, 111)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(134, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addGap(98, 98, 98)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                            .addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                            .addGap(151, 151, 151))
                );
            }

            GroupLayout DashbordFrameContentPaneLayout = new GroupLayout(DashbordFrameContentPane);
            DashbordFrameContentPane.setLayout(DashbordFrameContentPaneLayout);
            DashbordFrameContentPaneLayout.setHorizontalGroup(
                DashbordFrameContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            DashbordFrameContentPaneLayout.setVerticalGroup(
                DashbordFrameContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            DashbordFrame.pack();
            DashbordFrame.setLocationRelativeTo(DashbordFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame DashbordFrame;
    private JPanel panel1;
    private JButton logoutButton;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
