package main.java.gui.RegisterMenu;

import main.java.animations.ColorChangeAnimation;
import main.java.animations.RunAnimation;
import main.java.config.FontConfig;
import main.java.config.GuiConfig;
import main.java.config.SpriteConfig;
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
    private JLabel usernameLabel;
    private JScrollPane scrollPane1;
    private JTextArea inputUserName;
    private JLabel passwordLabel;
    private JPasswordField inputPassword;
    private JButton registerButton;
    private JLabel usernameErrorLabel;
    private JLabel passwordErrorLabel;
    private JButton previousButton;
    private JLabel PictureLabel;
    private JLabel label1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	public RegisterMenu(JFrame loginRegisterMenu) {
		this.loginRegisterMenu = loginRegisterMenu;
		initComponents();
		initComponentsProperties();
		this.setVisible(true);
	}
	
	private void initComponentsProperties() {
	    for (JLabel jLabel : Arrays.asList(usernameLabel,passwordLabel,usernameErrorLabel,passwordErrorLabel)){
	        jLabel.setFont(FontConfig.comic.deriveFont(Font.BOLD, 13));
        }
		inputPassword.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 12));
		inputUserName.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 12));
		registerButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 20));
		previousButton.setFont(FontConfig.comic.deriveFont(Font.ITALIC, 12));
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
        usernameLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        inputUserName = new JTextArea();
        passwordLabel = new JLabel();
        inputPassword = new JPasswordField();
        registerButton = new JButton();
        usernameErrorLabel = new JLabel();
        passwordErrorLabel = new JLabel();
        previousButton = new JButton();
        PictureLabel = new JLabel();
        label1 = new JLabel();

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
            mainBackground.setLayout(null);

            //---- usernameLabel ----
            usernameLabel.setText("Username");
            usernameLabel.setForeground(Color.white);
            usernameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            mainBackground.add(usernameLabel);
            usernameLabel.setBounds(85, 250, 72, 35);

            //======== scrollPane1 ========
            {

                //---- inputUserName ----
                inputUserName.setBackground(Color.white);
                inputUserName.setForeground(new Color(0, 32, 96));
                inputUserName.setLineWrap(true);
                inputUserName.setTabSize(10);
                inputUserName.setAlignmentX(1.5F);
                inputUserName.setAlignmentY(1.5F);
                inputUserName.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
                scrollPane1.setViewportView(inputUserName);
            }
            mainBackground.add(scrollPane1);
            scrollPane1.setBounds(85, 290, 235, scrollPane1.getPreferredSize().height);

            //---- passwordLabel ----
            passwordLabel.setText("Password");
            passwordLabel.setForeground(Color.white);
            passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            mainBackground.add(passwordLabel);
            passwordLabel.setBounds(85, 360, 74, 39);

            //---- inputPassword ----
            inputPassword.setBackground(Color.white);
            inputPassword.setForeground(new Color(0, 32, 96));
            inputPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            mainBackground.add(inputPassword);
            inputPassword.setBounds(85, 405, 235, inputPassword.getPreferredSize().height);

            //---- registerButton ----
            registerButton.setText("REGISTER");
            registerButton.setForeground(Color.white);
            registerButton.setBackground(new Color(0, 32, 96));
            registerButton.setFocusable(false);
            registerButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            registerButton.setBorder(null);
            registerButton.addActionListener(e -> RegisterButtonActionPerformed(e));
            mainBackground.add(registerButton);
            registerButton.setBounds(85, 485, 235, 47);

            //---- usernameErrorLabel ----
            usernameErrorLabel.setForeground(Color.red);
            usernameErrorLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
            usernameErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            mainBackground.add(usernameErrorLabel);
            usernameErrorLabel.setBounds(45, 325, 315, 33);

            //---- passwordErrorLabel ----
            passwordErrorLabel.setForeground(Color.red);
            passwordErrorLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
            passwordErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            mainBackground.add(passwordErrorLabel);
            passwordErrorLabel.setBounds(45, 445, 315, 33);

            //---- previousButton ----
            previousButton.setText("PREVIOUS");
            previousButton.setBackground(new Color(157, 0, 0));
            previousButton.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
            previousButton.setForeground(Color.white);
            previousButton.setAlignmentX(16.0F);
            previousButton.setFocusable(false);
            previousButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            previousButton.setBorder(null);
            previousButton.addActionListener(e -> PreviousButtonActionPerformed(e));
            mainBackground.add(previousButton);
            previousButton.setBounds(140, 535, 124, 38);

            //---- PictureLabel ----
            PictureLabel.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/icon@2x.png")));
            mainBackground.add(PictureLabel);
            PictureLabel.setBounds(new Rectangle(new Point(40, 35), PictureLabel.getPreferredSize()));

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/appTitle.png")));
            mainBackground.add(label1);
            label1.setBounds(195, 35, 161, 168);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < mainBackground.getComponentCount(); i++) {
                    Rectangle bounds = mainBackground.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = mainBackground.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                mainBackground.setMinimumSize(preferredSize);
                mainBackground.setPreferredSize(preferredSize);
            }
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(mainBackground, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(mainBackground, GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
}
