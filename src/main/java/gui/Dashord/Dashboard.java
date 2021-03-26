/*
 * Created by JFormDesigner on Thu Mar 11 21:54:48 IRST 2021
 */

package main.java.gui.Dashord;

import main.java.config.FontConfig;
import main.java.config.profileConfig;
import main.java.gui.Dashord.profilesettings.ProfileSettings;
import main.java.gui.Dashord.setting.SettingPanel;
import main.java.gui.Multiplayer.Multiplayer;
import main.java.gui.Singleplayer.SinglePlayer;
import main.java.models.User;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class Dashboard extends JFrame {
    public static User activeUser;
    private final JFrame LoginRegisterMenu;

    public Dashboard(JFrame LoginRegisterMenu, User activeUser) {
        Dashboard.activeUser = activeUser;
        this.LoginRegisterMenu = LoginRegisterMenu;
        initComponents();
        initComponentsProperties();
        this.setVisible(true);
        setCurrentUsername();
        setCurrentCoins();
        initProfilePicture(activeUser);
    }

    private void initComponentsProperties() {
        multiplayerButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 18));
        singlePlayerButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 18));
        usernameLabel.setFont(FontConfig.comic.deriveFont(Font.BOLD, 14));
        coinLabel.setFont(FontConfig.comic.deriveFont(Font.BOLD, 13));

    }

    private void setCurrentUsername(){
        usernameLabel.setText(activeUser.username);
    }

    private void setCurrentCoins(){
        coinLabel.setText(String.valueOf(activeUser.coins));
    }
    private void ProfileButtonActionPerformed(ActionEvent e) {
        this.setVisible(false);
        var profileSettings = new ProfileSettings(LoginRegisterMenu, this);
        profileSettings.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                setCurrentUsername();
                initProfilePicture(activeUser);
            }
        });
    }

    private void dashboardFrameWindowClosing(WindowEvent e) {
        this.dispose();
        LoginRegisterMenu.setVisible(true);
    }

    public void initProfilePicture(User user) {
        profile.setIcon(new ImageIcon(getClass().getResource(profileConfig.profilePicture(user))));
    }

    private void settingsIconActionPerformed(ActionEvent e) {
        this.setVisible(false);
        new SettingPanel(this);
    }

    private void singlePlayerButtonActionPerformed(ActionEvent e) {
        this.setVisible(false);
       var singlePlayer=new SinglePlayer(this);
       singlePlayer.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosed(WindowEvent e) {
               setCurrentCoins();
           }
       });
    }

    private void multiplayerButtonActionPerformed(ActionEvent e) {
        this.setVisible(false);
        new Multiplayer(this);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Panel = new JPanel();
        coinIcon = new JLabel();
        profileButton = new JButton();
        settingsIcon = new JButton();
        multiplayerButton = new JButton();
        singlePlayerButton = new JButton();
        profile = new JLabel();
        usernameLabel = new JLabel();
        coinLabel = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setName("Dashboard");
        setMaximizedBounds(new Rectangle(580, 60, 380, 605));
        setResizable(false);
        setTitle("Dashboard");
        setBackground(new Color(0, 112, 192));
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

            //---- coinIcon ----
            coinIcon.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Dashboard/smallCoin.png")));

            //---- profileButton ----
            profileButton.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Dashboard/profile.png")));
            profileButton.setBackground(new Color(0, 112, 192));
            profileButton.setFocusable(false);
            profileButton.setBorder(null);
            profileButton.addActionListener(e -> ProfileButtonActionPerformed(e));

            //---- settingsIcon ----
            settingsIcon.setBackground(new Color(0, 112, 192));
            settingsIcon.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Dashboard/settingUB.png")));
            settingsIcon.setFocusable(false);
            settingsIcon.setBorder(null);
            settingsIcon.addActionListener(e -> settingsIconActionPerformed(e));

            //---- multiplayerButton ----
            multiplayerButton.setText("Multiplayer");
            multiplayerButton.setBackground(new Color(0, 32, 96));
            multiplayerButton.setForeground(Color.white);
            multiplayerButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            multiplayerButton.setFocusable(false);
            multiplayerButton.addActionListener(e -> multiplayerButtonActionPerformed(e));

            //---- singlePlayerButton ----
            singlePlayerButton.setText("Singleplayer");
            singlePlayerButton.setBackground(new Color(0, 32, 96));
            singlePlayerButton.setForeground(Color.white);
            singlePlayerButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            singlePlayerButton.setFocusable(false);
            singlePlayerButton.addActionListener(e -> singlePlayerButtonActionPerformed(e));

            //---- usernameLabel ----
            usernameLabel.setBackground(Color.white);
            usernameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
            usernameLabel.setForeground(Color.white);

            //---- coinLabel ----
            coinLabel.setBackground(new Color(255, 255, 51));
            coinLabel.setForeground(new Color(255, 152, 0));
            coinLabel.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout PanelLayout = new GroupLayout(Panel);
            Panel.setLayout(PanelLayout);
            PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelLayout.createParallelGroup()
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(profileButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(settingsIcon, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                                .addComponent(coinLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(coinIcon))
                            .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                .addGap(0, 7, Short.MAX_VALUE)
                                .addGroup(PanelLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                        .addComponent(singlePlayerButton, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(multiplayerButton, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                        .addComponent(profile, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
            );
            PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup()
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(PanelLayout.createParallelGroup()
                                    .addComponent(coinIcon)
                                    .addComponent(coinLabel, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
                            .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(profileButton)
                                    .addComponent(settingsIcon))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(PanelLayout.createParallelGroup()
                            .addComponent(usernameLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addComponent(profile, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(singlePlayerButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                            .addComponent(multiplayerButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
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
    private JLabel coinIcon;
    private JButton profileButton;
    private JButton settingsIcon;
    private JButton multiplayerButton;
    private JButton singlePlayerButton;
    private JLabel profile;
    private JLabel usernameLabel;
    private JLabel coinLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
