/*
 * Created by JFormDesigner on Tue Mar 16 19:24:25 IRST 2021
 */

package main.java.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Alireza
 */
public class Multiplayer extends JFrame {
    public Multiplayer() {
        initComponents();
    }

    private void DashbordFrameWindowClosed(WindowEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        DashbordFrame = new JFrame();
        Panel = new JPanel();
        QuestionMark = new JLabel();

        //======== DashbordFrame ========
        {
            DashbordFrame.setMinimumSize(new Dimension(380, 605));
            DashbordFrame.setName("Dashbord");
            DashbordFrame.setMaximizedBounds(new Rectangle(580, 60, 380, 605));
            DashbordFrame.setResizable(false);
            DashbordFrame.setTitle("Dashbord");
            DashbordFrame.setBackground(new Color(0, 112, 192));
            DashbordFrame.setVisible(true);
            DashbordFrame.setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Logo (1).jpg")).getImage());
            DashbordFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    DashbordFrameWindowClosed(e);
                }
            });
            var DashbordFrameContentPane = DashbordFrame.getContentPane();

            //======== Panel ========
            {
                Panel.setBackground(new Color(0, 112, 192));

                //---- QuestionMark ----
                QuestionMark.setEnabled(false);
                QuestionMark.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/709c2fb9d74ddc87ccab6eb4341f888e.jpg")));

                GroupLayout PanelLayout = new GroupLayout(Panel);
                Panel.setLayout(PanelLayout);
                PanelLayout.setHorizontalGroup(
                    PanelLayout.createParallelGroup()
                        .addGroup(PanelLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(QuestionMark)
                            .addContainerGap(29, Short.MAX_VALUE))
                );
                PanelLayout.setVerticalGroup(
                    PanelLayout.createParallelGroup()
                        .addGroup(PanelLayout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addComponent(QuestionMark)
                            .addContainerGap(171, Short.MAX_VALUE))
                );
            }

            GroupLayout DashbordFrameContentPaneLayout = new GroupLayout(DashbordFrameContentPane);
            DashbordFrameContentPane.setLayout(DashbordFrameContentPaneLayout);
            DashbordFrameContentPaneLayout.setHorizontalGroup(
                DashbordFrameContentPaneLayout.createParallelGroup()
                    .addComponent(Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            DashbordFrameContentPaneLayout.setVerticalGroup(
                DashbordFrameContentPaneLayout.createParallelGroup()
                    .addComponent(Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            DashbordFrame.pack();
            DashbordFrame.setLocationRelativeTo(DashbordFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame DashbordFrame;
    private JPanel Panel;
    private JLabel QuestionMark;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
