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
import java.util.Objects;
import javax.swing.*;
import javax.swing.GroupLayout;

public class ProfileSettings extends JFrame {
	User activeUser = Dashboard.activeUser;
	public final JFrame LoginRegisterMenu;
	public final JFrame dashboard;
	
	public ProfileSettings(JFrame LoginRegisterMenu, JFrame dashboard) {
		this.dashboard = dashboard;
		this.LoginRegisterMenu = LoginRegisterMenu;
		initComponents();
		initProfilePictures();
		initComponentsProperties();
		this.setVisible(true);
	}
	
	private void initComponentsProperties() {
		inputNewPassword.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
		inputNewUsername.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
		changePasswordButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 15));
		changeUsernameButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 15));
		usernameErrorLabel.setFont(FontConfig.comic.deriveFont(Font.ITALIC, 14));
		passwordErrorLabel.setFont(FontConfig.comic.deriveFont(Font.ITALIC, 14));
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
	
	private void InputNewUserNameFocusGained(FocusEvent e) {
		if (inputNewUsername.getText().equals("new username")) inputNewUsername.setText("");
	}
	
	private void inputNewPasswordFocusGained(FocusEvent e) {
		if (String.valueOf(inputNewPassword.getPassword()).equals("new password")) inputNewPassword.setText("");
	}
	
	private void InputNewUserNameFocusLost(FocusEvent e) {
		if (inputNewUsername.getText().equals("")) inputNewUsername.setText("new username");
	}
	
	private void inputNewPasswordFocusLost(FocusEvent e) {
		if (String.valueOf(inputNewPassword.getPassword()).equals("")) inputNewPassword.setText("new password");
	}
	
	private void changeUsernameButtonActionPerformed(ActionEvent e) {
		if (inputNewUsername.getText().equals("new username")) inputNewUsername.setText("");
		
		var usernameError = GuiValidation.validateUsername(inputNewUsername.getText());
		
		if (Database.AlreadyExisted(inputNewUsername.getText())) {
			usernameErrorLabel.setText("Username already exists");
			RunAnimation.runMainPanelBackgroundColorAnimation(panel);
		} else if (usernameError == null) {
			Database.updateDatabaseUsername(activeUser.username, inputNewUsername.getText());
			changeUsernameButton.setBackground(Color.GREEN);
			changeUsernameButton.setText("changed successfully !");
			activeUser.username = inputNewUsername.getText();
		} else {
			RunAnimation.runMainPanelBackgroundColorAnimation(panel);
			updateErrorLabel(usernameError, usernameErrorLabel);
		}
	}
	
	private void updateErrorLabel(GuiError error, JLabel errorLabel) {
		if (error != null)
			errorLabel.setText(error.getMessage());
		else
			errorLabel.setText("");
	}
	
	private void changePasswordButtonActionPerformed(ActionEvent e) {
		String newPassword = String.valueOf(inputNewPassword.getPassword());
		if (newPassword.equals("new password")) newPassword = "";
		
		var passwordError = GuiValidation.validatePassword(newPassword);
		if (passwordError == null) {
			Database.updateDatabasePassword(activeUser.username, newPassword);
			changePasswordButton.setBackground(Color.GREEN);
			changePasswordButton.setText("Changed successfully !");
			activeUser.password = Objects.hash(newPassword);
		} else {
			RunAnimation.runMainPanelBackgroundColorAnimation(panel);
			updateErrorLabel(passwordError, passwordErrorLabel);
		}
	}
	
	private void face1ActionPerformed(ActionEvent e) {
		selectAPhoto();
		face1.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/check3.png")));
		Database.updateDatabaseProfilePicture(activeUser.username, 1);
		activeUser.profilePicture = 1;
	}
	
	private void face2ActionPerformed(ActionEvent e) {
		selectAPhoto();
		face2.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
		Database.updateDatabaseProfilePicture(activeUser.username, 2);
		activeUser.profilePicture = 2;
	}
	
	private void face3ActionPerformed(ActionEvent e) {
		selectAPhoto();
		face3.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
		Database.updateDatabaseProfilePicture(activeUser.username, 3);
		activeUser.profilePicture = 3;
	}
	
	private void face4ActionPerformed(ActionEvent e) {
		selectAPhoto();
		face4.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
		Database.updateDatabaseProfilePicture(activeUser.username, 4);
		activeUser.profilePicture = 4;
	}
	
	private void face5ActionPerformed(ActionEvent e) {
		selectAPhoto();
		face5.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
		Database.updateDatabaseProfilePicture(activeUser.username, 5);
		activeUser.profilePicture = 5;
	}
	
	private void face6ActionPerformed(ActionEvent e) {
		selectAPhoto();
		face6.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
		Database.updateDatabaseProfilePicture(activeUser.username, 6);
		activeUser.profilePicture = 6;
	}
	
	private void face7ActionPerformed(ActionEvent e) {
		selectAPhoto();
		face7.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
		Database.updateDatabaseProfilePicture(activeUser.username, 7);
		activeUser.profilePicture = 7;
	}
	
	private void face8ActionPerformed(ActionEvent e) {
		selectAPhoto();
		face8.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
		Database.updateDatabaseProfilePicture(activeUser.username, 8);
		activeUser.profilePicture = 8;
	}
	
	private void face9ActionPerformed(ActionEvent e) {
		selectAPhoto();
		face9.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
		Database.updateDatabaseProfilePicture(activeUser.username, 9);
		activeUser.profilePicture = 9;
	}
	
	private void face10ActionPerformed(ActionEvent e) {
		selectAPhoto();
		face10.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
		Database.updateDatabaseProfilePicture(activeUser.username, 10);
		activeUser.profilePicture = 10;
	}
	
	private void face11ActionPerformed(ActionEvent e) {
		selectAPhoto();
		face11.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
		Database.updateDatabaseProfilePicture(activeUser.username, 11);
		activeUser.profilePicture = 11;
	}
	
	private void face12ActionPerformed(ActionEvent e) {
		selectAPhoto();
		face12.setIcon(new ImageIcon(getClass().getResource(ProfileConfig.selected)));
		Database.updateDatabaseProfilePicture(activeUser.username, 12);
		activeUser.profilePicture = 12;
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
		changeUsernameButton = new JButton();
		changePasswordButton = new JButton();
		inputNewPassword = new JPasswordField();
		usernameErrorLabel = new JLabel();
		passwordErrorLabel = new JLabel();
		logoutButton = new JButton();
		inputNewUsername = new JTextArea();
		
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
			previousButton.addActionListener(e -> previousButtonActionPerformed(e));
			
			//---- face1 ----
			face1.setBackground(new Color(0, 112, 192));
			face1.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face1.png")));
			face1.setFocusable(false);
			face1.setBorder(null);
			face1.addActionListener(e -> face1ActionPerformed(e));
			
			//---- face2 ----
			face2.setBackground(new Color(0, 112, 192));
			face2.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face2.png")));
			face2.setFocusable(false);
			face2.setBorder(null);
			face2.addActionListener(e -> face2ActionPerformed(e));
			
			//---- face3 ----
			face3.setBackground(new Color(0, 112, 192));
			face3.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face3.png")));
			face3.setFocusable(false);
			face3.setBorder(null);
			face3.addActionListener(e -> face3ActionPerformed(e));
			
			//---- face5 ----
			face5.setBackground(new Color(0, 112, 192));
			face5.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face5.png")));
			face5.setFocusable(false);
			face5.setBorder(null);
			face5.addActionListener(e -> face5ActionPerformed(e));
			
			//---- face6 ----
			face6.setBackground(new Color(0, 112, 192));
			face6.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face6.png")));
			face6.setFocusable(false);
			face6.setBorder(null);
			face6.addActionListener(e -> face6ActionPerformed(e));
			
			//---- face4 ----
			face4.setBackground(new Color(0, 112, 192));
			face4.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face4.png")));
			face4.setFocusable(false);
			face4.setBorder(null);
			face4.addActionListener(e -> face4ActionPerformed(e));
			
			//---- face7 ----
			face7.setBackground(new Color(0, 112, 192));
			face7.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face7.png")));
			face7.setFocusable(false);
			face7.setBorder(null);
			face7.addActionListener(e -> face7ActionPerformed(e));
			
			//---- face8 ----
			face8.setBackground(new Color(0, 112, 192));
			face8.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face8.png")));
			face8.setFocusable(false);
			face8.setBorder(null);
			face8.addActionListener(e -> face8ActionPerformed(e));
			
			//---- face10 ----
			face10.setBackground(new Color(0, 112, 192));
			face10.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face10.png")));
			face10.setFocusable(false);
			face10.setBorder(null);
			face10.addActionListener(e -> face10ActionPerformed(e));
			
			//---- face9 ----
			face9.setBackground(new Color(0, 112, 192));
			face9.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face9.png")));
			face9.setFocusable(false);
			face9.setBorder(null);
			face9.addActionListener(e -> face9ActionPerformed(e));
			
			//---- face11 ----
			face11.setBackground(new Color(0, 112, 192));
			face11.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face11.png")));
			face11.setFocusable(false);
			face11.setBorder(null);
			face11.addActionListener(e -> face11ActionPerformed(e));
			
			//---- face12 ----
			face12.setBackground(new Color(0, 112, 192));
			face12.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Avatars/face12.png")));
			face12.setFocusable(false);
			face12.setBorder(null);
			face12.addActionListener(e -> face12ActionPerformed(e));
			
			//---- changeUsernameButton ----
			changeUsernameButton.setText("Change username ");
			changeUsernameButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			changeUsernameButton.setBackground(new Color(0, 32, 96));
			changeUsernameButton.setForeground(Color.white);
			changeUsernameButton.setFocusable(false);
			changeUsernameButton.addActionListener(e -> changeUsernameButtonActionPerformed(e));
			
			//---- changePasswordButton ----
			changePasswordButton.setText("Change password ");
			changePasswordButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			changePasswordButton.setBackground(new Color(0, 32, 96));
			changePasswordButton.setFocusable(false);
			changePasswordButton.setForeground(Color.white);
			changePasswordButton.addActionListener(e -> changePasswordButtonActionPerformed(e));
			
			//---- inputNewPassword ----
			inputNewPassword.setBackground(Color.white);
			inputNewPassword.setForeground(new Color(0, 32, 96));
			inputNewPassword.setText("new password");
			inputNewPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			inputNewPassword.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					inputNewPasswordFocusGained(e);
				}
				
				@Override
				public void focusLost(FocusEvent e) {
					inputNewPasswordFocusLost(e);
				}
			});
			
			//---- usernameErrorLabel ----
			usernameErrorLabel.setForeground(Color.red);
			usernameErrorLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
			usernameErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
			usernameErrorLabel.setBackground(new Color(0, 112, 192));
			
			//---- passwordErrorLabel ----
			passwordErrorLabel.setForeground(Color.red);
			passwordErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
			passwordErrorLabel.setBackground(new Color(0, 112, 192));
			passwordErrorLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
			
			//---- logoutButton ----
			logoutButton.setText("LOG OUT");
			logoutButton.setBackground(new Color(137, 0, 0, 209));
			logoutButton.setForeground(Color.white);
			logoutButton.setFocusable(false);
			logoutButton.setBorder(null);
			logoutButton.addActionListener(e -> logoutButtonActionPerformed(e));
			
			//---- inputNewUsername ----
			inputNewUsername.setBackground(Color.white);
			inputNewUsername.setForeground(new Color(0, 32, 96));
			inputNewUsername.setLineWrap(true);
			inputNewUsername.setTabSize(5);
			inputNewUsername.setText("new username");
			inputNewUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			inputNewUsername.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					InputNewUserNameFocusGained(e);
				}
				
				@Override
				public void focusLost(FocusEvent e) {
					InputNewUserNameFocusLost(e);
				}
			});
			
			GroupLayout panelLayout = new GroupLayout(panel);
			panel.setLayout(panelLayout);
			panelLayout.setHorizontalGroup(
					panelLayout.createParallelGroup()
							.addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
									.addGap(0, 63, Short.MAX_VALUE)
									.addGroup(panelLayout.createParallelGroup()
											.addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
													.addGroup(panelLayout.createParallelGroup()
															.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
																	.addComponent(passwordErrorLabel, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
																	.addComponent(usernameErrorLabel, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
															.addGroup(panelLayout.createSequentialGroup()
																	.addGap(39, 39, 39)
																	.addGroup(panelLayout.createParallelGroup()
																			.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																					.addComponent(changeUsernameButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																					.addComponent(inputNewPassword, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
																			.addComponent(inputNewUsername, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
																			.addComponent(changePasswordButton, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))))
													.addGap(50, 50, 50))
											.addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
													.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
													.addGap(121, 121, 121))))
							.addGroup(panelLayout.createSequentialGroup()
									.addGroup(panelLayout.createParallelGroup()
											.addGroup(panelLayout.createSequentialGroup()
													.addContainerGap()
													.addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
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
																			.addComponent(face12, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))))))
									.addContainerGap(37, Short.MAX_VALUE))
			);
			panelLayout.setVerticalGroup(
					panelLayout.createParallelGroup()
							.addGroup(panelLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(previousButton)
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
									.addGap(30, 30, 30)
									.addComponent(inputNewUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(usernameErrorLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(changeUsernameButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(inputNewPassword, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(passwordErrorLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(changePasswordButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
									.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
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
	private JButton changeUsernameButton;
	private JButton changePasswordButton;
	private JPasswordField inputNewPassword;
	private JLabel usernameErrorLabel;
	private JLabel passwordErrorLabel;
	private JButton logoutButton;
	private JTextArea inputNewUsername;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
