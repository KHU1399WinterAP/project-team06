/*
 * Created by JFormDesigner on Wed Mar 17 10:29:16 IRST 2021
 */

package main.java.gui.Dashord.profilesettings;

import main.java.animations.RunAnimation;
import main.java.config.FontConfig;
import main.java.config.ProfileConfig;
import main.java.database.Database;
import main.java.errors.GuiError;
import main.java.gui.Dashord.Dashboard;
import main.java.gui.RegisterMenu.RegisterMenu;
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

    public ProfileSettings(JFrame LoginRegisterMenu, JFrame dashboard) {
        profilePicture = activeUser.profilePicture;
        this.dashboard = dashboard;
        this.LoginRegisterMenu = LoginRegisterMenu;
        initComponents();
        initProfilePictures();
        initComponentsProperties();
        inputNewPassword.setText(Dashboard.password);
        inputNewUsername.setText(activeUser.username);
        this.setVisible(true);
    }

    private void initComponentsProperties() {
        inputNewPassword.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        inputNewUsername.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        logoutButton.setFont(FontConfig.comic.deriveFont(Font.ITALIC, 13));
    }

    private void logoutButtonActionPerformed(ActionEvent e) {
        this.dispose();
        LoginRegisterMenu.setVisible(true);
    }

    private void previousButtonActionPerformed(ActionEvent e) {
        previousPage();
    }

    private void ProfileSettingsFrameWindowClosing(WindowEvent e) {
        previousPage();
    }

    private void previousPage() {
        this.dispose();
        dashboard.setVisible(true);
    }

    private void face1ActionPerformed(ActionEvent e) {
        selectAPhoto();
        face1.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
        profilePicture = 1;
    }

    private void face2ActionPerformed(ActionEvent e) {
        selectAPhoto();
        face2.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
        profilePicture = 2;
    }

    private void face3ActionPerformed(ActionEvent e) {
        selectAPhoto();
        face3.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
        profilePicture = 3;
    }

    private void face4ActionPerformed(ActionEvent e) {
        selectAPhoto();
        face4.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
        profilePicture = 4;
    }

    private void face5ActionPerformed(ActionEvent e) {
        selectAPhoto();
        face5.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
        profilePicture = 5;
    }

    private void face6ActionPerformed(ActionEvent e) {
        selectAPhoto();
        face6.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
        profilePicture = 6;
    }

    private void face7ActionPerformed(ActionEvent e) {
        selectAPhoto();
        face7.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
        profilePicture = 7;
    }

    private void face8ActionPerformed(ActionEvent e) {
        selectAPhoto();
        face8.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
        profilePicture = 8;
    }

    private void face9ActionPerformed(ActionEvent e) {
        selectAPhoto();
        face9.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
        profilePicture = 9;
    }

    private void face10ActionPerformed(ActionEvent e) {
        selectAPhoto();
        face10.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
        profilePicture = 10;
    }

    private void face11ActionPerformed(ActionEvent e) {
        selectAPhoto();
        face11.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
        profilePicture = 11;
    }

    private void face12ActionPerformed(ActionEvent e) {
        selectAPhoto();
        face12.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
        profilePicture = 12;
    }

    private void selectAPhoto() {
        face1.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face1.png")));
        face2.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face2.png")));
        face3.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face3.png")));
        face4.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face4.png")));
        face5.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face5.png")));
        face6.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face6.png")));
        face7.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face7.png")));
        face8.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face8.png")));
        face9.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face9.png")));
        face10.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face10.png")));
        face11.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face11.png")));
        face12.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face12.png")));
    }

    private void applyChanges() {
        applyChangesButton.setText("changed !");
        applyChangesButton.setBackground(Color.GREEN);
        this.dispose();
        dashboard.setVisible(true);
    }

    private void applyChangesButtonActionPerformed(ActionEvent e) {
        String newPassword = String.valueOf(inputNewPassword.getPassword());
        String newUsername = inputNewUsername.getText();

        if (activeUser.username.equals(newUsername) && newPassword.equals(Dashboard.password) &&
                profilePicture == activeUser.profilePicture) {
            errorLabel.setText("");
            RunAnimation.runMainPanelBackgroundColorAnimation(panel);
        } else {
            var usernameError = GuiValidation.validateUsername(newUsername);
            var passwordError = GuiValidation.validatePassword(newPassword);
            if (usernameError==null && passwordError==null) {
                if (activeUser.profilePicture!=profilePicture){
                    activeUser.profilePicture=profilePicture;
                    Database.updateDatabaseProfilePicture(activeUser.username,profilePicture);
                }
                if (!activeUser.username.equals(newUsername)){
                    Database.updateDatabaseUsername(activeUser.username,newUsername);
                    activeUser.username=newUsername;
                }
                if (activeUser.password!=Objects.hash(newPassword)){
                    activeUser.password=Objects.hash(newPassword);
                    Database.updateDatabasePassword(activeUser.username,newPassword);
                    Dashboard.password=newPassword;
                }
                applyChanges();
            }else error();
        }
    }

    private void error() {
        errorLabel.setText("Password or username cannot be replaced !");
        RunAnimation.runMainPanelBackgroundColorAnimation(panel);
    }

    private void init(){
        ArrayList<JButton> facesButton=new ArrayList<>();
        for (int i=1;i<=12;i++){
            facesButton.add(new JButton());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel = new JPanel();
        previousButton = new JButton();
        face1 = new JButton();
        face2 = new JButton();
        face3 = new JButton();
        face5 = new JButton();
        face6 = new JButton();
        face4 = new JButton();
        face7 = new JButton();
        face8 = new JButton();
        face10 = new JButton();
        face9 = new JButton();
        face11 = new JButton();
        face12 = new JButton();
        applyChangesButton = new JButton();
        inputNewPassword = new JPasswordField();
        errorLabel = new JLabel();
        logoutButton = new JButton();
        inputNewUsername = new JTextArea();
        label1 = new JLabel();
        newUsernameLabel = new JLabel();
        newpasswordLabel = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setName("ProfileSettings");
        setMaximizedBounds(new Rectangle(580, 60, 380, 605));
        setResizable(false);
        setTitle("profile settings");
        setBackground(new Color(0, 112, 192));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo (1).jpg")).getImage());
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

            //---- previousButton ----
            previousButton.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/leftArrow@2x.png")));
            previousButton.setBackground(new Color(0, 112, 192));
            previousButton.setFocusable(false);
            previousButton.setBorder(null);
            previousButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            previousButton.addActionListener(e -> previousButtonActionPerformed(e));

            //---- face1 ----
            face1.setBackground(new Color(0, 112, 192));
            face1.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face1.png")));
            face1.setFocusable(false);
            face1.setBorder(null);
            face1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            face1.addActionListener(e -> face1ActionPerformed(e));

            //---- face2 ----
            face2.setBackground(new Color(0, 112, 192));
            face2.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face2.png")));
            face2.setFocusable(false);
            face2.setBorder(null);
            face2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            face2.addActionListener(e -> face2ActionPerformed(e));

            //---- face3 ----
            face3.setBackground(new Color(0, 112, 192));
            face3.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face3.png")));
            face3.setFocusable(false);
            face3.setBorder(null);
            face3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            face3.addActionListener(e -> face3ActionPerformed(e));

            //---- face5 ----
            face5.setBackground(new Color(0, 112, 192));
            face5.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face5.png")));
            face5.setFocusable(false);
            face5.setBorder(null);
            face5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            face5.addActionListener(e -> face5ActionPerformed(e));

            //---- face6 ----
            face6.setBackground(new Color(0, 112, 192));
            face6.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face6.png")));
            face6.setFocusable(false);
            face6.setBorder(null);
            face6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            face6.addActionListener(e -> face6ActionPerformed(e));

            //---- face4 ----
            face4.setBackground(new Color(0, 112, 192));
            face4.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face4.png")));
            face4.setFocusable(false);
            face4.setBorder(null);
            face4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            face4.addActionListener(e -> face4ActionPerformed(e));

            //---- face7 ----
            face7.setBackground(new Color(0, 112, 192));
            face7.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face7.png")));
            face7.setFocusable(false);
            face7.setBorder(null);
            face7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            face7.addActionListener(e -> face7ActionPerformed(e));

            //---- face8 ----
            face8.setBackground(new Color(0, 112, 192));
            face8.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face8.png")));
            face8.setFocusable(false);
            face8.setBorder(null);
            face8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            face8.addActionListener(e -> face8ActionPerformed(e));

            //---- face10 ----
            face10.setBackground(new Color(0, 112, 192));
            face10.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face10.png")));
            face10.setFocusable(false);
            face10.setBorder(null);
            face10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            face10.addActionListener(e -> face10ActionPerformed(e));

            //---- face9 ----
            face9.setBackground(new Color(0, 112, 192));
            face9.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face9.png")));
            face9.setFocusable(false);
            face9.setBorder(null);
            face9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            face9.addActionListener(e -> face9ActionPerformed(e));

            //---- face11 ----
            face11.setBackground(new Color(0, 112, 192));
            face11.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face11.png")));
            face11.setFocusable(false);
            face11.setBorder(null);
            face11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            face11.addActionListener(e -> face11ActionPerformed(e));

            //---- face12 ----
            face12.setBackground(new Color(0, 112, 192));
            face12.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face12.png")));
            face12.setFocusable(false);
            face12.setBorder(null);
            face12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            face12.addActionListener(e -> face12ActionPerformed(e));

            //---- applyChangesButton ----
            applyChangesButton.setText("Apply Changes");
            applyChangesButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            applyChangesButton.setBackground(new Color(0, 32, 96));
            applyChangesButton.setFocusable(false);
            applyChangesButton.setForeground(Color.white);
            applyChangesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            applyChangesButton.setBorder(null);
            applyChangesButton.addActionListener(e -> applyChangesButtonActionPerformed(e));

            //---- inputNewPassword ----
            inputNewPassword.setBackground(Color.white);
            inputNewPassword.setForeground(new Color(0, 32, 96));
            inputNewPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- errorLabel ----
            errorLabel.setForeground(Color.red);
            errorLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
            errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            errorLabel.setBackground(new Color(0, 112, 192));

            //---- logoutButton ----
            logoutButton.setText("LOG OUT");
            logoutButton.setBackground(new Color(137, 0, 0, 209));
            logoutButton.setForeground(Color.white);
            logoutButton.setFocusable(false);
            logoutButton.setBorder(null);
            logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            logoutButton.addActionListener(e -> logoutButtonActionPerformed(e));

            //---- inputNewUsername ----
            inputNewUsername.setBackground(Color.white);
            inputNewUsername.setForeground(new Color(0, 32, 96));
            inputNewUsername.setLineWrap(true);
            inputNewUsername.setTabSize(5);
            inputNewUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- label1 ----
            label1.setText("Change your avatar:");
            label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
            label1.setForeground(Color.white);

            //---- newUsernameLabel ----
            newUsernameLabel.setText("new username");
            newUsernameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- newpasswordLabel ----
            newpasswordLabel.setText("new password");
            newpasswordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            GroupLayout panelLayout = new GroupLayout(panel);
            panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup()
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(panelLayout.createParallelGroup()
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(face1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(face2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(face3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(face4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(face5, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(face9, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup()
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(face6, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(face7, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(face10, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(face11, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup()
                                    .addComponent(face8, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(face12, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))))
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
                            .addComponent(newpasswordLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(face1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(face2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(face3, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(face4, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup()
                            .addComponent(face5, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(face6, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(face7, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(face8, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup()
                            .addComponent(face9, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(face10, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(face11, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(face12, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newUsernameLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputNewUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(newpasswordLabel)
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
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initProfilePictures() {
        // TODO: add profile picture to GUI

        JButton[] faces = new JButton[12];
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel;
    private JButton previousButton;
    private JButton face1;
    private JButton face2;
    private JButton face3;
    private JButton face5;
    private JButton face6;
    private JButton face4;
    private JButton face7;
    private JButton face8;
    private JButton face10;
    private JButton face9;
    private JButton face11;
    private JButton face12;
    private JButton applyChangesButton;
    private JPasswordField inputNewPassword;
    private JLabel errorLabel;
    private JButton logoutButton;
    private JTextArea inputNewUsername;
    private JLabel label1;
    private JLabel newUsernameLabel;
    private JLabel newpasswordLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
