package main.java.gui.RegisterMenu;

import main.java.animations.ColorChangeAnimation;
import main.java.animations.RunAnimation;
import main.java.config.FontConfig;
import main.java.config.GuiConfig;
import main.java.database.Database;
import main.java.errors.GuiError;
import main.java.gui.Dashord.Dashboard;
import main.java.gui.GameOver.GameOver;
import main.java.models.Settings;
import main.java.models.User;
import main.java.utils.GuiValidation;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Timer;
import java.util.function.Consumer;
import javax.swing.*;
import javax.swing.GroupLayout;

import static main.java.config.GuiConfig.COLOR_DANGER;

public class RegisterMenu extends JFrame {
	private final JFrame loginRegisterMenu;
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel mainBackground;
    private JLabel textLabel;
    private JLabel faceLabel;
    private JLabel usernameLabel;
    private JScrollPane scrollPane1;
    private JTextArea inputUserName;
    private JLabel passwordLabel;
    private JPasswordField inputPassword;
    private JButton registerButton;
    private JLabel usernameErrorLabel;
    private JLabel passwordErrorLabel;
    private JButton previousButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	public RegisterMenu(JFrame loginRegisterMenu) {
		this.loginRegisterMenu = loginRegisterMenu;
		initComponents();
		initComponentsProperties();
		this.setVisible(true);
	}
	
	private void initComponentsProperties() {
	    for (JLabel jLabel : Arrays.asList(usernameLabel,passwordLabel,usernameErrorLabel,passwordErrorLabel)){
	        jLabel.setFont(FontConfig.comic.deriveFont(Font.ITALIC, 12));
        }
		inputPassword.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 12));
		inputUserName.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 12));
		textLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 50));
		registerButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 20));
		previousButton.setFont(FontConfig.comic.deriveFont(Font.ITALIC, 10));
	}
	
	private void RegisterButtonActionPerformed(ActionEvent e) {
		var usernameError = GuiValidation.validateUsername(inputUserName.getText());
		var passwordError = GuiValidation.validatePassword(String.valueOf(inputPassword.getPassword()));
		
		if (Database.AlreadyExisted(inputUserName.getText())) {
			usernameErrorLabel.setText("username already exists");
			RunAnimation.runMainPanelBackgroundColorAnimation(mainBackground, GuiConfig.COLOR_DEFAULT_BLUE);
		} else if (usernameError == null && passwordError == null) {
            Settings settings=new Settings(Database.getTheMaxSettingId()+1);
            Database.insertInToSettings(settings);
			User user = new User(inputUserName.getText(), Objects.hash(String.valueOf(inputPassword.getPassword())),Database.getTheMaxSettingId()+1);
			Database.insertInToUsers(user);
			
			registerButton.setBackground(Color.green);
			registerButton.setText("Registered !!");

			javax.swing.Timer pause = new javax.swing.Timer(400, e1 -> {
				registerButton.setBackground(GuiConfig.COLOR_DEFAULT_DARK_BLUE);
				new Dashboard(loginRegisterMenu,user,String.valueOf(inputPassword.getPassword()));
				this.setVisible(false);
			});
			pause.setRepeats(false);
			pause.start();

		} else {
			RunAnimation.runMainPanelBackgroundColorAnimation(mainBackground,GuiConfig.COLOR_DEFAULT_BLUE);
			updateErrorLabel(usernameError, usernameErrorLabel);
			updateErrorLabel(passwordError, passwordErrorLabel);
		}
	}
	
	private void updateErrorLabel(GuiError error, JLabel errorLabel) {
		if (error != null)
			errorLabel.setText(error.getMessage());
		else
			errorLabel.setText("");
	}
	
	private void PreviousButtonActionPerformed(ActionEvent e) {
		previousPage();
	}
	
	private void RegisterFrameWindowClosed(WindowEvent e) {
		previousPage();
	}
	
	private void previousPage() {
		this.dispose();
		loginRegisterMenu.setVisible(true);
	}
	
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        mainBackground = new JPanel();
        textLabel = new JLabel();
        faceLabel = new JLabel();
        usernameLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        inputUserName = new JTextArea();
        passwordLabel = new JLabel();
        inputPassword = new JPasswordField();
        registerButton = new JButton();
        usernameErrorLabel = new JLabel();
        passwordErrorLabel = new JLabel();
        previousButton = new JButton();

        //======== this ========
        setResizable(false);
        setMinimumSize(new Dimension(380, 605));
        setMaximizedBounds(new Rectangle(530, 60, 380, 605));
        setBackground(new Color(0, 112, 192));
        setTitle("Register Menu");
        setFont(new Font("Calibri", Font.PLAIN, 14));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo.jpg")).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setName("RegisterMenu");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                RegisterFrameWindowClosed(e);
            }
        });
        var contentPane = getContentPane();

        //======== mainBackground ========
        {
            mainBackground.setMaximumSize(new Dimension(380, 605));
            mainBackground.setMinimumSize(new Dimension(380, 605));
            mainBackground.setBackground(new Color(0, 112, 192));
            mainBackground.setFocusable(false);

            //---- textLabel ----
            textLabel.setText("Quiz Of Kings");
            textLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
            textLabel.setForeground(Color.white);

            //---- faceLabel ----
            faceLabel.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/SmallLogo.jpg")));

            //---- usernameLabel ----
            usernameLabel.setText("Username");
            usernameLabel.setForeground(Color.white);
            usernameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //======== scrollPane1 ========
            {

                //---- inputUserName ----
                inputUserName.setBackground(Color.white);
                inputUserName.setForeground(new Color(0, 32, 96));
                inputUserName.setLineWrap(true);
                inputUserName.setTabSize(10);
                inputUserName.setAlignmentX(1.5F);
                inputUserName.setAlignmentY(1.5F);
                inputUserName.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
                scrollPane1.setViewportView(inputUserName);
            }

            //---- passwordLabel ----
            passwordLabel.setText("Password");
            passwordLabel.setForeground(Color.white);
            passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- inputPassword ----
            inputPassword.setBackground(Color.white);
            inputPassword.setForeground(new Color(0, 32, 96));
            inputPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

            //---- registerButton ----
            registerButton.setText("REGISTER");
            registerButton.setForeground(Color.white);
            registerButton.setBackground(new Color(0, 32, 96));
            registerButton.setFocusable(false);
            registerButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            registerButton.setBorder(null);
            registerButton.addActionListener(e -> RegisterButtonActionPerformed(e));

            //---- usernameErrorLabel ----
            usernameErrorLabel.setForeground(Color.red);
            usernameErrorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

            //---- passwordErrorLabel ----
            passwordErrorLabel.setForeground(Color.red);
            passwordErrorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

            //---- previousButton ----
            previousButton.setText("PREVIOUS");
            previousButton.setBackground(new Color(137, 0, 0, 209));
            previousButton.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
            previousButton.setForeground(Color.white);
            previousButton.setAlignmentX(16.0F);
            previousButton.setFocusable(false);
            previousButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            previousButton.setBorder(null);
            previousButton.addActionListener(e -> PreviousButtonActionPerformed(e));

            GroupLayout mainBackgroundLayout = new GroupLayout(mainBackground);
            mainBackground.setLayout(mainBackgroundLayout);
            mainBackgroundLayout.setHorizontalGroup(
                mainBackgroundLayout.createParallelGroup()
                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                        .addGroup(mainBackgroundLayout.createParallelGroup()
                            .addGroup(mainBackgroundLayout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainBackgroundLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(mainBackgroundLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createSequentialGroup()
                                        .addComponent(faceLabel)
                                        .addGap(90, 90, 90))
                                    .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createParallelGroup()
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createSequentialGroup()
                                            .addComponent(usernameLabel)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(usernameErrorLabel, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createParallelGroup()
                                            .addGroup(mainBackgroundLayout.createSequentialGroup()
                                                .addComponent(passwordLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passwordErrorLabel, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(inputPassword, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(textLabel, GroupLayout.Alignment.TRAILING))))
                        .addGap(0, 32, Short.MAX_VALUE))
            );
            mainBackgroundLayout.setVerticalGroup(
                mainBackgroundLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(faceLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textLabel)
                        .addGap(18, 18, 18)
                        .addGroup(mainBackgroundLayout.createParallelGroup()
                            .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameErrorLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainBackgroundLayout.createParallelGroup()
                            .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordErrorLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(mainBackground, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(mainBackground, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
}
