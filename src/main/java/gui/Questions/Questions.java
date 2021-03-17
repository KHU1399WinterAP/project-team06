/*
 * Created by JFormDesigner on Tue Mar 16 19:59:15 IRST 2021
 */

package main.java.gui.Questions;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Alireza
 */
public class Questions extends JFrame {
    public Questions() {
        initComponents();
    }

    private void DashbordFrameWindowClosed(WindowEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Panel = new JPanel();
        QuestionPlace = new JTextField();
        Answer1 = new JTextField();
        Answer2 = new JTextField();
        Answer3 = new JTextField();
        Answer4 = new JTextField();
        PowerUp1 = new JButton();
        PowerUp2 = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setName("Questions");
        setMaximizedBounds(new Rectangle(580, 60, 380, 605));
        setResizable(false);
        setTitle("Questions");
        setBackground(new Color(0, 112, 192));
        setVisible(true);
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo (1).jpg")).getImage());
        var contentPane = getContentPane();

        //======== Panel ========
        {
            Panel.setBackground(new Color(0, 112, 192));

            //---- QuestionPlace ----
            QuestionPlace.setText("Question Goes Here");
            QuestionPlace.setHorizontalAlignment(SwingConstants.CENTER);
            QuestionPlace.setFont(QuestionPlace.getFont().deriveFont(QuestionPlace.getFont().getSize() + 10f));
            QuestionPlace.setForeground(new Color(255, 153, 51));
            QuestionPlace.setBackground(new Color(0, 0, 204));

            //---- PowerUp1 ----
            PowerUp1.setText("Power UP 1");
            PowerUp1.setBackground(new Color(0, 153, 51));

            //---- PowerUp2 ----
            PowerUp2.setText("Power UP 2");
            PowerUp2.setBackground(new Color(0, 153, 51));

            GroupLayout PanelLayout = new GroupLayout(Panel);
            Panel.setLayout(PanelLayout);
            PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(QuestionPlace, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addComponent(Answer4, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Answer3, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addComponent(Answer1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Answer2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(PowerUp1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PowerUp2, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))))
            );
            PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(QuestionPlace, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Answer1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Answer2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Answer3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Answer4, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(PowerUp1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                            .addComponent(PowerUp2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
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
    private JTextField QuestionPlace;
    private JTextField Answer1;
    private JTextField Answer2;
    private JTextField Answer3;
    private JTextField Answer4;
    private JButton PowerUp1;
    private JButton PowerUp2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
