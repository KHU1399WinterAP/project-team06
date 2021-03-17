/*
 * Created by JFormDesigner on Tue Mar 16 19:24:25 IRST 2021
 */

package main.java.gui.Multiplayer;

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
        Panel = new JPanel();
        QuestionMark = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setName("Dashbord");
        setMaximizedBounds(new Rectangle(580, 60, 380, 605));
        setResizable(false);
        setTitle("Dashbord");
        setBackground(new Color(0, 112, 192));
        setVisible(true);
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo (1).jpg")).getImage());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                DashbordFrameWindowClosed(e);
            }
        });
        var contentPane = getContentPane();

        //======== Panel ========
        {
            Panel.setBackground(new Color(0, 112, 192));

            //---- QuestionMark ----
            QuestionMark.setEnabled(false);
            QuestionMark.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/QuestionMark.jpg")));

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
                        .addContainerGap(163, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel Panel;
    private JLabel QuestionMark;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
