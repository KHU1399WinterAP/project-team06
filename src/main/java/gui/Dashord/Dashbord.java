/*
 * Created by JFormDesigner on Thu Mar 11 21:54:48 IRST 2021
 */

package main.java.gui.Dashord;

import main.java.config.profileConfig;
import main.java.gui.Dashord.profilesettings.profilesettings;
import main.java.models.User;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class Dashbord extends JFrame {
    public static User activeUser;
    private final JFrame LoginRegisterMenu;

    public Dashbord(JFrame LoginRegisterMenu, User activeUser) {
        Dashbord.activeUser =activeUser;
        this.LoginRegisterMenu = LoginRegisterMenu;
        initComponents();
        username.setText(activeUser.username);
        initProfilePicture(activeUser);
    }
   
    private void ProfileButtonActionPerformed(ActionEvent e) {
        this.setVisible(false);
        new profilesettings(LoginRegisterMenu,this);
    }

    private void dashboardFrameWindowClosing(WindowEvent e) {
        this.dispose();
        LoginRegisterMenu.setVisible(true);
    }

    public void initProfilePicture(User user){
        profile.setIcon(new ImageIcon(getClass().getResource(profileConfig.profilePicture(user))));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Panel = new JPanel();
        CoinIcon = new JLabel();
        ProfileButton = new JButton();
        SettingsIcon = new JButton();
        MultiplayerButton = new JButton();
        SingleplayerButton = new JButton();
        profile = new JLabel();
        username = new JLabel();
        label1 = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setName("Dashboard");
        setMaximizedBounds(new Rectangle(580, 60, 380, 605));
        setResizable(false);
        setTitle("Dashboard");
        setBackground(new Color(0, 112, 192));
        setVisible(true);
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo (1).jpg")).getImage());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dashboardFrameWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //======== Panel ========
        {
            Panel.setBackground(new Color(0, 112, 192));

            //---- CoinIcon ----
            CoinIcon.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Dashboard/smallCoin.png")));

            //---- ProfileButton ----
            ProfileButton.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Dashboard/profile.png")));
            ProfileButton.setBackground(new Color(0, 112, 192));
            ProfileButton.setFocusable(false);
            ProfileButton.addActionListener(e -> ProfileButtonActionPerformed(e));

            //---- SettingsIcon ----
            SettingsIcon.setBackground(new Color(0, 112, 192));
            SettingsIcon.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Dashboard/settingUB.png")));
            SettingsIcon.setFocusable(false);

            //---- MultiplayerButton ----
            MultiplayerButton.setText("Multiplayer");
            MultiplayerButton.setBackground(new Color(255, 153, 0));
            MultiplayerButton.setForeground(new Color(0, 204, 153));
            MultiplayerButton.setFont(MultiplayerButton.getFont().deriveFont(MultiplayerButton.getFont().getSize() + 4f));
            MultiplayerButton.setFocusable(false);

            //---- SingleplayerButton ----
            SingleplayerButton.setText("Singleplayer");
            SingleplayerButton.setBackground(new Color(255, 153, 0));
            SingleplayerButton.setForeground(new Color(0, 204, 153));
            SingleplayerButton.setFont(SingleplayerButton.getFont().deriveFont(SingleplayerButton.getFont().getSize() + 4f));
            SingleplayerButton.setFocusable(false);

            //---- username ----
            username.setBackground(Color.white);
            username.setFont(new Font("Segoe UI", Font.BOLD, 18));

            //---- label1 ----
            label1.setBackground(new Color(255, 255, 51));
            label1.setForeground(new Color(255, 152, 0));
            label1.setText("0");

            GroupLayout PanelLayout = new GroupLayout(Panel);
            Panel.setLayout(PanelLayout);
            PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelLayout.createParallelGroup()
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup()
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addComponent(ProfileButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(SettingsIcon, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                        .addGap(0, 43, Short.MAX_VALUE)
                                        .addComponent(MultiplayerButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(SingleplayerButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)))
                                .addGap(6, 6, 6)
                                .addComponent(CoinIcon)
                                .addContainerGap())
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(profile)
                                .addGap(18, 18, 18)
                                .addComponent(username, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                                .addGap(30, 30, 30))))
            );
            PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelLayout.createParallelGroup()
                            .addComponent(ProfileButton)
                            .addComponent(SettingsIcon)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(PanelLayout.createParallelGroup()
                                    .addComponent(CoinIcon)
                                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(profile, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addComponent(username, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(MultiplayerButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                            .addComponent(SingleplayerButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                        .addGap(337, 337, 337))
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
    private JLabel CoinIcon;
    private JButton ProfileButton;
    private JButton SettingsIcon;
    private JButton MultiplayerButton;
    private JButton SingleplayerButton;
    private JLabel profile;
    private JLabel username;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
