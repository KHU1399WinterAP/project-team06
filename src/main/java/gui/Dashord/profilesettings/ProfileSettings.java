/*
 * Created by JFormDesigner on Wed Mar 17 10:29:16 IRST 2021
 */

package main.java.gui.Dashord.profilesettings;

import main.java.animations.RunAnimation;
import main.java.config.FontConfig;
import main.java.config.MusicConfig;
import main.java.config.ProfileConfig;
import main.java.config.ThemeConfig;
import main.java.database.Database;
import main.java.errors.GuiError;
import main.java.gui.Dashord.Dashboard;
import main.java.gui.LoginRegisterMenu.LoginRegisterMenu;
import main.java.models.User;
import main.java.utils.GuiValidation;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;
import javax.swing.GroupLayout;

public class ProfileSettings extends JFrame {
    User activeUser = Dashboard.activeUser;
    public final JFrame LoginRegisterMenu;
    public final JFrame dashboard;
    public static int profilePicture;
    ArrayList<JButton> facesButton;

    public ProfileSettings(JFrame LoginRegisterMenu, JFrame dashboard) {
        profilePicture = activeUser.profilePicture;
        this.dashboard = dashboard;
        this.LoginRegisterMenu = LoginRegisterMenu;
        init();
        initComponentsProperties();
        initCustomTheme();
        inputNewPassword.setText(Dashboard.password);
        inputNewUsername.setText(activeUser.username);
        this.setVisible(true);
    }

    private void initCustomTheme(){
        panel.setBackground(ThemeConfig.background);
        for (JButton jButton : facesButton) {
            jButton.setBackground(ThemeConfig.background);
        }
        applyChangesButton.setBackground(ThemeConfig.button);
        previousButton.setBackground(ThemeConfig.background);
    }

    private void initComponentsProperties() {
        inputNewPassword.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        inputNewUsername.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        logoutButton.setFont(FontConfig.comic.deriveFont(Font.ITALIC, 13));
    }

    private void logoutButtonActionPerformed(ActionEvent e) {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);
        MusicConfig.mp3PlayerLong.stop();
        this.dispose();
        new LoginRegisterMenu();
    }

    private void previousButtonActionPerformed(ActionEvent e) {
        previousPage();
    }

    private void ProfileSettingsFrameWindowClosing(WindowEvent e) {
        previousPage();
    }

    private void previousPage() {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);
        this.dispose();
        dashboard.setVisible(true);
    }

    private void selectAPhoto() {
        for (int i = 0; i < facesButton.size(); i++) {
            facesButton.get(i).setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/main/resources/icons/Avatars/face" + (i + 1) + ".png"))));
        }
    }

    private void applyChanges() {
        applyChangesButton.setText("changed !");
        applyChangesButton.setBackground(Color.GREEN);

        javax.swing.Timer pause = new javax.swing.Timer(500, e1 -> {
            applyChangesButton.setBackground(new Color(0, 32, 96));
            this.dispose();
            dashboard.setVisible(true);
        });
        pause.setRepeats(false);
        pause.start();
    }

    private void applyChangesButtonActionPerformed(ActionEvent e) {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);
        String newPassword = String.valueOf(inputNewPassword.getPassword());
        String newUsername = inputNewUsername.getText();
        var usernameError = GuiValidation.validateUsername(newUsername);
        var passwordError = GuiValidation.validatePassword(newPassword);

        if (activeUser.username.equals(newUsername) && newPassword.equals(Dashboard.password) &&
                profilePicture == activeUser.profilePicture) {
            errorLabel.setText("");
            RunAnimation.runMainPanelBackgroundColorAnimation(panel,ThemeConfig.background);
        } else {
            if (Database.AlreadyExisted(newUsername) && !activeUser.username.equals(newUsername)) {
                 error();
            } else if (usernameError == null && passwordError == null) {
                if (activeUser.profilePicture != profilePicture) {
                    activeUser.profilePicture = profilePicture;
                    Database.updateDatabaseProfilePicture(activeUser.username, profilePicture);
                }
                if (!activeUser.username.equals(newUsername)) {
                    Database.updateDatabaseUsername(activeUser.username, newUsername);
                    activeUser.username = newUsername;
                }
                if (activeUser.password != Objects.hash(newPassword)) {
                    activeUser.password = Objects.hash(newPassword);
                    Database.updateDatabasePassword(activeUser.username, newPassword);
                    Dashboard.password = newPassword;
                }
                applyChanges();
            } else error();
        }
    }

    private void error() {
        errorLabel.setText("Password or username cannot be replaced !");
        RunAnimation.runMainPanelBackgroundColorAnimation(panel,ThemeConfig.background);
    }

    private void init() {
        facesButton = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            JButton face = new JButton();
            face.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/main/resources/icons/Avatars/face" + i + ".png"))));
            face.setFocusable(false);
            face.setBorder(null);
            face.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            int finalI = i;
            face.addActionListener(e -> {
                MusicConfig.initShortMp3(MusicConfig.celClickSong);
                selectAPhoto();
                face.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource(ProfileConfig.selected))));
                profilePicture = finalI;
            });
            facesButton.add(face);
        }

        panel = new JPanel();
        previousButton = new JButton();
        applyChangesButton = new JButton();
        inputNewPassword = new JPasswordField();
        errorLabel = new JLabel();
        logoutButton = new JButton();
        inputNewUsername = new JTextArea();
        JLabel label1 = new JLabel();
        JLabel newUsernameLabel = new JLabel();
        JLabel newPasswordLabel = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setName("ProfileSettings");
        setMaximizedBounds(new Rectangle(580, 60, 380, 605));
        setResizable(false);
        setTitle("profile settings");
        setBackground(new Color(0, 112, 192));
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/main/resources/icons/Theme/Logo (1).jpg"))).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ProfileSettingsFrameWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //======== panel ========
        {
            panel.setBackground(new Color(0, 112, 192));

            previousButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/main/resources/icons/previous.png"))));
            previousButton.setBackground(new Color(0, 112, 192));
            previousButton.setFocusable(false);
            previousButton.setBorder(null);
            previousButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            previousButton.addActionListener(this::previousButtonActionPerformed);

            applyChangesButton.setText("Apply Changes");
            applyChangesButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            applyChangesButton.setBackground(new Color(0, 32, 96));
            applyChangesButton.setFocusable(false);
            applyChangesButton.setForeground(Color.white);
            applyChangesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            applyChangesButton.setBorder(null);
            applyChangesButton.addActionListener(this::applyChangesButtonActionPerformed);

            inputNewPassword.setBackground(Color.white);
            inputNewPassword.setForeground(new Color(0, 32, 96));
            inputNewPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            errorLabel.setForeground(Color.red);
            errorLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
            errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            errorLabel.setBackground(new Color(0, 112, 192));

            logoutButton.setText("LOG OUT");
            logoutButton.setBackground(new Color(137, 0, 0, 209));
            logoutButton.setForeground(Color.white);
            logoutButton.setFocusable(false);
            logoutButton.setBorder(null);
            logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            logoutButton.addActionListener(this::logoutButtonActionPerformed);

            inputNewUsername.setBackground(Color.white);
            inputNewUsername.setForeground(new Color(0, 32, 96));
            inputNewUsername.setLineWrap(true);
            inputNewUsername.setTabSize(5);
            inputNewUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            label1.setText("Change your avatar:");
            label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
            label1.setForeground(Color.white);

            newUsernameLabel.setText("new username");
            newUsernameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            newUsernameLabel.setForeground(Color.white);

            newPasswordLabel.setText("new password");
            newPasswordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            newPasswordLabel.setForeground(Color.white);

            GroupLayout panelLayout = new GroupLayout(panel);
            panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                    panelLayout.createParallelGroup()
                            .addGroup(panelLayout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addGroup(panelLayout.createParallelGroup()
                                            .addGroup(panelLayout.createSequentialGroup()
                                                    .addComponent(facesButton.get(0), GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(facesButton.get(1), GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(facesButton.get(2), GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(facesButton.get(3), GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panelLayout.createSequentialGroup()
                                                    .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                            .addComponent(facesButton.get(4), GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(facesButton.get(8), GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(panelLayout.createParallelGroup()
                                                            .addGroup(panelLayout.createSequentialGroup()
                                                                    .addComponent(facesButton.get(5), GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(facesButton.get(6), GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(panelLayout.createSequentialGroup()
                                                                    .addComponent(facesButton.get(9), GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(facesButton.get(10), GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(panelLayout.createParallelGroup()
                                                            .addComponent(facesButton.get(7), GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(facesButton.get(11), GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))))
                                    .addGap(0, 37, Short.MAX_VALUE))
                            .addGroup(panelLayout.createSequentialGroup()
                                    .addGroup(panelLayout.createParallelGroup()
                                            .addGroup(panelLayout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panelLayout.createSequentialGroup()
                                                    .addGap(125, 125, 125)
                                                    .addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panelLayout.createSequentialGroup()
                                                    .addGap(39, 39, 39)
                                                    .addComponent(label1)))
                                    .addContainerGap(130, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                    .addContainerGap(100, Short.MAX_VALUE)
                                    .addGroup(panelLayout.createParallelGroup()
                                            .addComponent(inputNewUsername, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(applyChangesButton, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(inputNewPassword, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(newUsernameLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(newPasswordLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
                                    .addGap(88, 88, 88))
                            .addGroup(panelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(errorLabel, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            panelLayout.setVerticalGroup(
                    panelLayout.createParallelGroup()
                            .addGroup(panelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(previousButton)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelLayout.createParallelGroup()
                                            .addComponent(facesButton.get(0), GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(facesButton.get(1), GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(facesButton.get(2), GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(facesButton.get(3), GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelLayout.createParallelGroup()
                                            .addComponent(facesButton.get(4), GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(facesButton.get(5), GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(facesButton.get(6), GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(facesButton.get(7), GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelLayout.createParallelGroup()
                                            .addComponent(facesButton.get(8), GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(facesButton.get(9), GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(facesButton.get(10), GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(facesButton.get(11), GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(newUsernameLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(inputNewUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                    .addComponent(newPasswordLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(inputNewPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(applyChangesButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );
        }

        GroupLayoutSettings(contentPane, panel);
        setLocationRelativeTo(getOwner());
    }

    public static void GroupLayoutSettings(Container contentPane, JPanel panel) {
        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    private JButton previousButton;
    private JPanel panel;
    private JButton applyChangesButton;
    private JPasswordField inputNewPassword;
    private JLabel errorLabel;
    private JButton logoutButton;
    private JTextArea inputNewUsername;
}