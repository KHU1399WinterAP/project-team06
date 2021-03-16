/*
 * Created by JFormDesigner on Tue Mar 16 18:55:03 IRST 2021
 */

package main.java.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Alireza
 */
public class Singleplayer extends JFrame {
    public Singleplayer() {
        initComponents();
    }

    private void DashbordFrameWindowClosed(WindowEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Singleplayer = new JFrame();
        Panel = new JPanel();
        Title = new JLabel();
        label1 = new JLabel();
        Category1 = new JButton();
        Category2 = new JButton();
        Category3 = new JButton();
        Category4 = new JButton();
        Category5 = new JButton();
        Category6 = new JButton();

        //======== Singleplayer ========
        {
            Singleplayer.setMinimumSize(new Dimension(380, 605));
            Singleplayer.setName("Dashbord");
            Singleplayer.setMaximizedBounds(new Rectangle(580, 60, 380, 605));
            Singleplayer.setResizable(false);
            Singleplayer.setTitle("Dashbord");
            Singleplayer.setBackground(new Color(0, 112, 192));
            Singleplayer.setVisible(true);
            Singleplayer.setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Logo (1).jpg")).getImage());
            Singleplayer.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    DashbordFrameWindowClosed(e);
                }
            });
            var SingleplayerContentPane = Singleplayer.getContentPane();

            //======== Panel ========
            {
                Panel.setBackground(new Color(0, 112, 192));

                //---- Title ----
                Title.setText("Singleplayer");
                Title.setFont(Title.getFont().deriveFont(Title.getFont().getSize() + 25f));
                Title.setBackground(new Color(153, 0, 255));
                Title.setForeground(new Color(255, 204, 102));

                //---- label1 ----
                label1.setText("Categories:");
                label1.setBackground(new Color(255, 153, 0));
                label1.setForeground(new Color(255, 153, 0));
                label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

                //---- Category1 ----
                Category1.setText("English");
                Category1.setBackground(new Color(153, 0, 255));
                Category1.setForeground(new Color(51, 255, 51));
                Category1.setFont(Category1.getFont().deriveFont(Category1.getFont().getSize() + 5f));

                //---- Category2 ----
                Category2.setText("Mathematics");
                Category2.setBackground(new Color(153, 0, 255));
                Category2.setForeground(new Color(51, 255, 51));
                Category2.setFont(Category2.getFont().deriveFont(Category2.getFont().getSize() + 5f));

                //---- Category3 ----
                Category3.setText("Food & Drink");
                Category3.setBackground(new Color(153, 0, 255));
                Category3.setForeground(new Color(51, 255, 51));
                Category3.setFont(Category3.getFont().deriveFont(Category3.getFont().getSize() + 5f));

                //---- Category4 ----
                Category4.setText("Common Knowledge");
                Category4.setBackground(new Color(153, 0, 255));
                Category4.setForeground(new Color(51, 255, 51));
                Category4.setFont(Category4.getFont().deriveFont(Category4.getFont().getSize() + 5f));

                //---- Category5 ----
                Category5.setText("Science");
                Category5.setBackground(new Color(153, 0, 255));
                Category5.setForeground(new Color(51, 255, 51));
                Category5.setFont(Category5.getFont().deriveFont(Category5.getFont().getSize() + 5f));

                //---- Category6 ----
                Category6.setText("Geography");
                Category6.setBackground(new Color(153, 0, 255));
                Category6.setForeground(new Color(51, 255, 51));
                Category6.setFont(Category6.getFont().deriveFont(Category6.getFont().getSize() + 5f));

                GroupLayout PanelLayout = new GroupLayout(Panel);
                Panel.setLayout(PanelLayout);
                PanelLayout.setHorizontalGroup(
                    PanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                            .addContainerGap(90, Short.MAX_VALUE)
                            .addComponent(Title)
                            .addGap(88, 88, 88))
                        .addGroup(PanelLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(Category1, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(212, 212, 212))
                                .addComponent(Category6, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Category4, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Category5, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Category3, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Category2, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(37, Short.MAX_VALUE))
                );
                PanelLayout.setVerticalGroup(
                    PanelLayout.createParallelGroup()
                        .addGroup(PanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(Title)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label1)
                            .addGap(27, 27, 27)
                            .addComponent(Category1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Category2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Category3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Category5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Category4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Category6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(64, Short.MAX_VALUE))
                );
            }

            GroupLayout SingleplayerContentPaneLayout = new GroupLayout(SingleplayerContentPane);
            SingleplayerContentPane.setLayout(SingleplayerContentPaneLayout);
            SingleplayerContentPaneLayout.setHorizontalGroup(
                SingleplayerContentPaneLayout.createParallelGroup()
                    .addComponent(Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            SingleplayerContentPaneLayout.setVerticalGroup(
                SingleplayerContentPaneLayout.createParallelGroup()
                    .addComponent(Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            Singleplayer.pack();
            Singleplayer.setLocationRelativeTo(Singleplayer.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame Singleplayer;
    private JPanel Panel;
    private JLabel Title;
    private JLabel label1;
    private JButton Category1;
    private JButton Category2;
    private JButton Category3;
    private JButton Category4;
    private JButton Category5;
    private JButton Category6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
