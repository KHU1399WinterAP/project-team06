/*
 * Created by JFormDesigner on Thu Mar 11 21:54:48 IRST 2021
 */

package main.java.gui.Dashord;

import main.java.config.*;
import main.java.database.Database;
import main.java.gui.Dashord.profilesettings.ProfileSettings;
import main.java.gui.Dashord.setting.SettingPanel;
import main.java.gui.LoginRegisterMenu.LoginRegisterMenu;
import main.java.gui.Multiplayer.Multiplayer;
import main.java.gui.Singleplayer.SinglePlayer;
import main.java.gui.theme.ThemeTypes;
import main.java.models.Theme;
import main.java.models.User;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;
import javax.swing.GroupLayout;

public class Dashboard extends JFrame {
    public static User activeUser;
    private final JFrame LoginRegisterMenu;
    public static String password;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel Panel;
    private JLabel coinIcon;
    private JButton settingsIcon;
    private JButton profileButton;
    private JLabel usernameLabel;
    private JLabel coinLabel;
    private JButton singlePlayerButton;
    private JButton multiplayerButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public Dashboard(JFrame LoginRegisterMenu, User activeUser, String password) {
        LoginRegisterMenu.dispose();
        MusicConfig.mp3PlayerLong.stop();
        MusicConfig.initLongMusic(MusicConfig.gamePLaySong);
        Dashboard.password = password;
        Dashboard.activeUser = activeUser;
        this.LoginRegisterMenu = LoginRegisterMenu;
        ThemeConfig.themeId = Database.getThemeIdByUsername(activeUser.username);
        initComponents();
        init();
        ThemeConfig.initTheme();
        initCustomTheme();
        this.setVisible(true);
    }

    private void initCustomTheme() {
        Panel.setBackground(ThemeConfig.background);
        settingsIcon.setBackground(ThemeConfig.background);
        multiplayerButton.setBackground(ThemeConfig.button);
        singlePlayerButton.setBackground(ThemeConfig.button);
        profileButton.setBackground(ThemeConfig.background);
    }

    private void init() {
        initComponentsProperties();
        setCurrentInformation();
        setCurrentCoins();
    }

    private void initComponentsProperties() {
        multiplayerButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 18));
        singlePlayerButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 18));
        usernameLabel.setFont(FontConfig.comic.deriveFont(Font.BOLD, 16));
        coinLabel.setFont(FontConfig.comic.deriveFont(Font.BOLD, 19));
    }

    private void setCurrentCoins() {
        coinLabel.setText(String.valueOf(activeUser.coins));
    }

    private void setCurrentInformation() {
        profileButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass()
                .getResource(ProfileConfig.profilePicture(activeUser.profilePicture)))));
        usernameLabel.setText(activeUser.username);
    }

    private void dashboardFrameWindowClosing(WindowEvent e) {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);
        MusicConfig.mp3PlayerLong.stop();
        this.dispose();
        new LoginRegisterMenu();
    }

    private void settingsIconActionPerformed(ActionEvent e) {
        clicked();
        var settingPanel = new SettingPanel(this);
        settingPanel.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                initCustomTheme();
            }
        });
    }

    private void singlePlayerButtonActionPerformed(ActionEvent e) {
        clicked();
        var singlePlayer = new SinglePlayer(this);
        singlePlayer.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                setCurrentCoins();
            }
        });
    }

    private void multiplayerButtonActionPerformed(ActionEvent e) {
        clicked();
        new Multiplayer(this);
    }

    private void profileButtonActionPerformed(ActionEvent e) {
        clicked();
        var profileSettings = new ProfileSettings(LoginRegisterMenu, this);
        profileSettings.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                setCurrentInformation();
            }
        });
    }

    private void clicked() {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Panel = new JPanel();
        coinIcon = new JLabel();
        settingsIcon = new JButton();
        profileButton = new JButton();
        usernameLabel = new JLabel();
        coinLabel = new JLabel();
        singlePlayerButton = new JButton();
        multiplayerButton = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setName("Dashboard");
        setMaximizedBounds(new Rectangle(580, 60, 380, 605));
        setResizable(false);
        setTitle("Dashboard");
        setBackground(new Color(0, 112, 192));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo.jpg")).getImage());
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
            Panel.setLayout(null);

            //---- coinIcon ----
            coinIcon.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Dashboard/smallCoin.png")));
            Panel.add(coinIcon);
            coinIcon.setBounds(new Rectangle(new Point(331, 30), coinIcon.getPreferredSize()));

            //---- settingsIcon ----
            settingsIcon.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Dashboard/settingsIcon.png")));
            settingsIcon.setFocusable(false);
            settingsIcon.setBorder(null);
            settingsIcon.setBackground(new Color(0, 112, 192));
            settingsIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            settingsIcon.addActionListener(e -> settingsIconActionPerformed(e));
            Panel.add(settingsIcon);
            settingsIcon.setBounds(12, 29, 41, settingsIcon.getPreferredSize().height);

            //---- profileButton ----
            profileButton.setFocusable(false);
            profileButton.setBorder(null);
            profileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            profileButton.addActionListener(e -> profileButtonActionPerformed(e));
            Panel.add(profileButton);
            profileButton.setBounds(59, 6, 58, 61);

            //---- usernameLabel ----
            usernameLabel.setBackground(Color.white);
            usernameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
            usernameLabel.setForeground(Color.white);
            Panel.add(usernameLabel);
            usernameLabel.setBounds(123, 30, 134, 37);

            //---- coinLabel ----
            coinLabel.setBackground(new Color(255, 255, 51));
            coinLabel.setForeground(new Color(255, 152, 0));
            coinLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            Panel.add(coinLabel);
            coinLabel.setBounds(263, 30, 62, 29);

            //---- singlePlayerButton ----
            singlePlayerButton.setText("Singleplayer");
            singlePlayerButton.setBackground(new Color(0, 32, 96));
            singlePlayerButton.setForeground(Color.white);
            singlePlayerButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            singlePlayerButton.setFocusable(false);
            singlePlayerButton.setBorder(null);
            singlePlayerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            singlePlayerButton.addActionListener(e -> singlePlayerButtonActionPerformed(e));
            Panel.add(singlePlayerButton);
            singlePlayerButton.setBounds(30, 135, 151, 69);

            //---- multiplayerButton ----
            multiplayerButton.setText("Multiplayer");
            multiplayerButton.setBackground(new Color(0, 32, 96));
            multiplayerButton.setForeground(Color.white);
            multiplayerButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            multiplayerButton.setFocusable(false);
            multiplayerButton.setBorder(null);
            multiplayerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            multiplayerButton.addActionListener(e -> multiplayerButtonActionPerformed(e));
            Panel.add(multiplayerButton);
            multiplayerButton.setBounds(200, 135, 154, 69);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < Panel.getComponentCount(); i++) {
                    Rectangle bounds = Panel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = Panel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                Panel.setMinimumSize(preferredSize);
                Panel.setPreferredSize(preferredSize);
            }
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
}
