package main.java.gui.Dashboard.setting;

import main.java.config.FontConfig;
import main.java.config.MusicConfig;
import main.java.config.ThemeConfig;
import main.java.gui.Dashboard.Dashboard;
import main.java.gui.dashboard.setting.About.About;
import main.java.gui.theme.ThemeTypes;
import main.java.models.User;
import main.java.socket.Client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Sina
 */
public class SettingPanel extends JFrame {
    public final JFrame dashboard;
    User activeUser = Dashboard.activeUser;
    Client client=Dashboard.CLIENT;

    public SettingPanel(JFrame dashboard) {
        this.dashboard = dashboard;
        initComponents();
        initComponentsProperties();
        initCustomTheme();
        if (MusicConfig.mp3PlayerLong.isPaused()) musicButton.setText(MusicPlayerStatus.OFF.labelText);
        else musicButton.setText(MusicPlayerStatus.ON.labelText);
        themeButton.setText(ThemeConfig.name);
        this.setVisible(true);
    }

    private void initCustomTheme() {
        previousButton.setBackground(ThemeConfig.background);
        aboutButton.setBackground(ThemeConfig.button);
        mainBackground.setBackground(ThemeConfig.background);
        musicButton.setBackground(ThemeConfig.background);
        themeButton.setBackground(ThemeConfig.background);
    }

    private void initComponentsProperties() {
        musicButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 18));
        musiclabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 24));
        aboutButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 18));
    }

    private void SettingFrameWindowClosing(WindowEvent e) {
        previousPage();
    }

    private void previousButtonActionPerformed(ActionEvent e) {
        previousPage();
    }

    private void previousPage() {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);
        this.dispose();
        dashboard.setVisible(true);
    }

    private void musicButtonActionPerformed(ActionEvent e) {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);

        if (musicButton.getText().equals(MusicPlayerStatus.ON.labelText)) {
            musicButton.setText(MusicPlayerStatus.OFF.labelText);
            MusicConfig.mp3PlayerLong.pause();
        } else {
            musicButton.setText(MusicPlayerStatus.ON.labelText);
            MusicConfig.mp3PlayerLong.play();
        }
    }

    private void AboutButtonActionPerformed(ActionEvent e) {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);
        this.setVisible(false);
        new About(this);
    }

    private void themeButtonActionPerformed(ActionEvent e) {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);

        ThemeConfig.themeId%=ThemeTypes.themes.size();
        ThemeConfig.themeId++;
        ThemeConfig.initTheme();
        themeButton.setText(ThemeConfig.name);

        client.sendRequest("UPDATE_THEME");
        client.sendRequest(activeUser.username);
        client.sendRequest(String.valueOf(ThemeConfig.themeId));

        initCustomTheme();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        mainBackground = new JPanel();
        previousButton = new JButton();
        musiclabel = new JLabel();
        musicButton = new JButton();
        aboutButton = new JButton();
        label1 = new JLabel();
        themeButton = new JButton();

        //======== this ========
        setResizable(false);
        setMinimumSize(new Dimension(380, 605));
        setMaximizedBounds(new Rectangle(530, 60, 380, 605));
        setBackground(new Color(0, 112, 192));
        setTitle("Setting");
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

        //======== mainBackground ========
        {
            mainBackground.setMaximumSize(new Dimension(380, 605));
            mainBackground.setMinimumSize(new Dimension(380, 605));
            mainBackground.setBackground(new Color(0, 112, 192));

            //---- previousButton ----
            previousButton.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/previous.png")));
            previousButton.setBackground(new Color(0, 112, 192));
            previousButton.setFocusable(false);
            previousButton.setBorder(null);
            previousButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            previousButton.addActionListener(e -> previousButtonActionPerformed(e));

            //---- musiclabel ----
            musiclabel.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/music.png")));

            //---- musicButton ----
            musicButton.setBackground(new Color(0, 112, 192));
            musicButton.setForeground(Color.white);
            musicButton.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
            musicButton.setText("ON");
            musicButton.setBorder(null);
            musicButton.setFocusable(false);
            musicButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            musicButton.addActionListener(e -> musicButtonActionPerformed(e));

            //---- aboutButton ----
            aboutButton.setText("About");
            aboutButton.setBackground(new Color(0, 32, 96));
            aboutButton.setForeground(Color.white);
            aboutButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            aboutButton.setFocusable(false);
            aboutButton.setBorder(null);
            aboutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            aboutButton.addActionListener(e -> AboutButtonActionPerformed(e));

            //---- label1 ----
            label1.setText("Theme  ");
            label1.setForeground(Color.white);
            label1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            label1.setHorizontalAlignment(SwingConstants.CENTER);

            //---- themeButton ----
            themeButton.setBackground(new Color(0, 112, 192));
            themeButton.setBorder(null);
            themeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            themeButton.setFocusable(false);
            themeButton.setForeground(Color.white);
            themeButton.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
            themeButton.addActionListener(e -> themeButtonActionPerformed(e));

            GroupLayout mainBackgroundLayout = new GroupLayout(mainBackground);
            mainBackground.setLayout(mainBackgroundLayout);
            mainBackgroundLayout.setHorizontalGroup(
                mainBackgroundLayout.createParallelGroup()
                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                        .addGroup(mainBackgroundLayout.createParallelGroup()
                            .addGroup(mainBackgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainBackgroundLayout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addGroup(mainBackgroundLayout.createParallelGroup()
                                    .addComponent(aboutButton, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(mainBackgroundLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(mainBackgroundLayout.createSequentialGroup()
                                            .addComponent(label1)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(themeButton))
                                        .addGroup(GroupLayout.Alignment.LEADING, mainBackgroundLayout.createSequentialGroup()
                                            .addComponent(musiclabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(musicButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            mainBackgroundLayout.setVerticalGroup(
                mainBackgroundLayout.createParallelGroup()
                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(previousButton)
                        .addGap(10, 10, 10)
                        .addGroup(mainBackgroundLayout.createParallelGroup()
                            .addComponent(musiclabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                            .addComponent(musicButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(mainBackgroundLayout.createParallelGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                            .addComponent(themeButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aboutButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(mainBackground, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(mainBackground, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel mainBackground;
    private JButton previousButton;
    private JLabel musiclabel;
    private JButton musicButton;
    private JButton aboutButton;
    private JLabel label1;
    private JButton themeButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

enum MusicPlayerStatus {
    ON("ON"),
    OFF("OFF");

    String labelText;

    MusicPlayerStatus(String labelText) {
        this.labelText = labelText;
    }
}
