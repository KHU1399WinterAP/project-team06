/*
 * Created by JFormDesigner on Thu Mar 11 21:54:48 IRST 2021
 */

package main.java.gui.Dashord;

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
        Panel = new JPanel();
        CoinIcon = new JLabel();
        NumberOfCoins = new JTextField();
        ProfileName = new JTextField();
        ProfileButton = new JButton();
        SettingsIcon = new JButton();
        MultiplayerButton = new JButton();
        SingleplayerButton = new JButton();

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

                //---- CoinIcon ----
                CoinIcon.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Dashboard/smallCoin.png")));

                //---- NumberOfCoins ----
                NumberOfCoins.setBackground(new Color(255, 255, 51));
                NumberOfCoins.setForeground(new Color(255, 255, 51));

                //---- ProfileButton ----
                ProfileButton.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Dashboard/profile.png")));
                ProfileButton.setBackground(new Color(0, 112, 192));

                //---- SettingsIcon ----
                SettingsIcon.setBackground(new Color(0, 112, 192));
                SettingsIcon.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Dashboard/settingUB.png")));

                //---- MultiplayerButton ----
                MultiplayerButton.setText("Multiplayer");
                MultiplayerButton.setBackground(new Color(255, 153, 0));
                MultiplayerButton.setForeground(new Color(0, 204, 153));
                MultiplayerButton.setFont(MultiplayerButton.getFont().deriveFont(MultiplayerButton.getFont().getSize() + 4f));

                //---- SingleplayerButton ----
                SingleplayerButton.setText("Singleplayer");
                SingleplayerButton.setBackground(new Color(255, 153, 0));
                SingleplayerButton.setForeground(new Color(0, 204, 153));
                SingleplayerButton.setFont(SingleplayerButton.getFont().deriveFont(SingleplayerButton.getFont().getSize() + 4f));

                GroupLayout PanelLayout = new GroupLayout(Panel);
                Panel.setLayout(PanelLayout);
                PanelLayout.setHorizontalGroup(
                    PanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                            .addGroup(PanelLayout.createParallelGroup()
                                .addGroup(PanelLayout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(ProfileButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ProfileName, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(SettingsIcon, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                                    .addComponent(NumberOfCoins, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGroup(PanelLayout.createSequentialGroup()
                                    .addContainerGap(52, Short.MAX_VALUE)
                                    .addComponent(MultiplayerButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(SingleplayerButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CoinIcon)
                            .addContainerGap())
                );
                PanelLayout.setVerticalGroup(
                    PanelLayout.createParallelGroup()
                        .addGroup(PanelLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(PanelLayout.createParallelGroup()
                                .addGroup(PanelLayout.createSequentialGroup()
                                    .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(CoinIcon)
                                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(NumberOfCoins, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ProfileName)))
                                    .addGap(71, 71, 71))
                                .addGroup(PanelLayout.createSequentialGroup()
                                    .addGroup(PanelLayout.createParallelGroup()
                                        .addGroup(PanelLayout.createSequentialGroup()
                                            .addGap(3, 3, 3)
                                            .addComponent(SettingsIcon))
                                        .addGroup(PanelLayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(ProfileButton)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(MultiplayerButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                .addComponent(SingleplayerButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(380, Short.MAX_VALUE))
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
    private JLabel CoinIcon;
    private JTextField NumberOfCoins;
    private JTextField ProfileName;
    private JButton ProfileButton;
    private JButton SettingsIcon;
    private JButton MultiplayerButton;
    private JButton SingleplayerButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
