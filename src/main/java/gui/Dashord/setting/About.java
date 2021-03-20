/*
 * Created by JFormDesigner on Sat Mar 20 21:29:29 IRST 2021
 */

package main.java.gui.Dashord.setting;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Sina
 */
public class About extends JFrame {
    public final JFrame setting;
    public About(JFrame setting) {
        this.setting = setting;
        initComponents();
        this.setVisible(true);
    }

    private void AboutFrameWindowClosing(WindowEvent e) {
        this.dispose();
        setting.setVisible(true);
    }

    private void previousButtonActionPerformed(ActionEvent e) {
        this.dispose();
        setting.setVisible(true);
    }

    private void SettingFrameWindowClosing(WindowEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        MainBackground = new JPanel();
        previousButton = new JButton();
        AboutLabel = new JLabel();
        Banner = new JLabel();
        Text1 = new JLabel();
        Text2 = new JLabel();
        DevelopersLabel = new JLabel();
        Text3 = new JLabel();
        Text4 = new JLabel();
        Text5 = new JLabel();
        RepoLabel = new JLabel();
        Text6 = new JLabel();

        //======== this ========
        setResizable(false);
        setMinimumSize(new Dimension(380, 605));
        setMaximizedBounds(new Rectangle(530, 60, 380, 605));
        setBackground(new Color(0, 112, 192));
        setTitle("About");
        setFont(new Font("Calibri", Font.PLAIN, 14));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo.jpg")).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                SettingFrameWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //======== MainBackground ========
        {
            MainBackground.setMaximumSize(new Dimension(380, 605));
            MainBackground.setMinimumSize(new Dimension(380, 605));
            MainBackground.setBackground(new Color(0, 112, 192));

            //---- previousButton ----
            previousButton.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/leftArrow@2x.png")));
            previousButton.setBackground(new Color(0, 112, 192));
            previousButton.setFocusable(false);
            previousButton.setBorder(null);
            previousButton.addActionListener(e -> previousButtonActionPerformed(e));

            //---- AboutLabel ----
            AboutLabel.setText("   About us  ");
            AboutLabel.setBackground(new Color(255, 153, 0));
            AboutLabel.setForeground(new Color(255, 153, 0));
            AboutLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));

            //---- Banner ----
            Banner.setFont(new Font("Calibri", Font.PLAIN, 54));
            Banner.setForeground(Color.white);
            Banner.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/CropedBanner2.jpg")));

            //---- Text1 ----
            Text1.setText("KHU University 1399 Winter");
            Text1.setBackground(new Color(255, 153, 0));
            Text1.setForeground(Color.white);
            Text1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

            //---- Text2 ----
            Text2.setText("Advanced Programing Project");
            Text2.setBackground(new Color(255, 153, 0));
            Text2.setForeground(Color.white);
            Text2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

            //---- DevelopersLabel ----
            DevelopersLabel.setText("Developers :");
            DevelopersLabel.setBackground(new Color(255, 153, 0));
            DevelopersLabel.setForeground(new Color(255, 153, 0));
            DevelopersLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));

            //---- Text3 ----
            Text3.setText("Seyed Hossein Borghei ");
            Text3.setBackground(new Color(255, 153, 0));
            Text3.setForeground(Color.white);
            Text3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

            //---- Text4 ----
            Text4.setText("Alireza Reghabi");
            Text4.setBackground(new Color(255, 153, 0));
            Text4.setForeground(Color.white);
            Text4.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

            //---- Text5 ----
            Text5.setText("Sina Omidvar");
            Text5.setBackground(new Color(255, 153, 0));
            Text5.setForeground(Color.white);
            Text5.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

            //---- RepoLabel ----
            RepoLabel.setText("KHU1399WinterAP/project-team06");
            RepoLabel.setBackground(new Color(255, 153, 0));
            RepoLabel.setForeground(Color.white);
            RepoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

            //---- Text6 ----
            Text6.setText("Github Repository : ");
            Text6.setBackground(new Color(255, 153, 0));
            Text6.setForeground(new Color(255, 153, 0));
            Text6.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));

            GroupLayout MainBackgroundLayout = new GroupLayout(MainBackground);
            MainBackground.setLayout(MainBackgroundLayout);
            MainBackgroundLayout.setHorizontalGroup(
                MainBackgroundLayout.createParallelGroup()
                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                        .addGroup(MainBackgroundLayout.createParallelGroup()
                            .addGroup(MainBackgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Banner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(MainBackgroundLayout.createSequentialGroup()
                                .addGroup(MainBackgroundLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(MainBackgroundLayout.createParallelGroup()
                                        .addGroup(MainBackgroundLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(MainBackgroundLayout.createSequentialGroup()
                                            .addGap(64, 64, 64)
                                            .addGroup(MainBackgroundLayout.createParallelGroup()
                                                .addComponent(Text3)
                                                .addComponent(Text4)
                                                .addComponent(Text5)
                                                .addGroup(MainBackgroundLayout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(Text6)))))
                                    .addComponent(Text1, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Text2))
                                .addGap(0, 46, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(AboutLabel)
                        .addGap(0, 116, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addComponent(RepoLabel)
                        .addGap(18, 18, 18))
                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(DevelopersLabel)
                        .addContainerGap(111, Short.MAX_VALUE))
            );
            MainBackgroundLayout.setVerticalGroup(
                MainBackgroundLayout.createParallelGroup()
                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(previousButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Banner)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AboutLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Text1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Text2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DevelopersLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Text3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Text4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Text5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Text6, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RepoLabel)
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(MainBackground, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(MainBackground, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel MainBackground;
    private JButton previousButton;
    private JLabel AboutLabel;
    private JLabel Banner;
    private JLabel Text1;
    private JLabel Text2;
    private JLabel DevelopersLabel;
    private JLabel Text3;
    private JLabel Text4;
    private JLabel Text5;
    private JLabel RepoLabel;
    private JLabel Text6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
