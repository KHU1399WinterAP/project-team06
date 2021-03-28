/*
 * Created by JFormDesigner on Sat Mar 06 18:47:16 IRST 2021
 */

package main.java.gui.LoginRegisterMenu;

import main.java.config.FontConfig;
import main.java.gui.LoginMenu.LoginMenu;
import main.java.gui.RegisterMenu.RegisterMenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Alireza
 */
public class LoginRegisterMenu extends JFrame {
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel MainBackground;
	private JLabel Banner;
	private JButton loginButton;
	private JButton registerButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	public LoginRegisterMenu() {
		initComponents();
		initComponentsProperties();
		this.setVisible(true);
	}
	
	private void RegisterActionPerformed(ActionEvent e) {
		new RegisterMenu(this);
		this.setVisible(false);
	}
	
	private void LoginActionPerformed(ActionEvent e) {
		new LoginMenu(this);
		this.setVisible(false);
	}
	
	private void initComponentsProperties() {
		loginButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 25));
		registerButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 25));
	}
	
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		MainBackground = new JPanel();
		Banner = new JLabel();
		loginButton = new JButton();
		registerButton = new JButton();
		
		//======== this ========
		setResizable(false);
		setMinimumSize(new Dimension(380, 605));
		setMaximizedBounds(new Rectangle(530, 60, 380, 605));
		setBackground(new Color(0, 112, 192));
		setTitle("Quiz Of Kings");
		setFont(new Font("Calibri", Font.PLAIN, 14));
		setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo.jpg")).getImage());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		var contentPane = getContentPane();
		
		//======== MainBackground ========
		{
			MainBackground.setMaximumSize(new Dimension(380, 605));
			MainBackground.setMinimumSize(new Dimension(380, 605));
			MainBackground.setBackground(new Color(0, 112, 192));
			
			//---- Banner ----
			Banner.setFont(new Font("Calibri", Font.PLAIN, 54));
			Banner.setForeground(Color.white);
			Banner.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/CropedBanner2.jpg")));
			
			//---- loginButton ----
			loginButton.setText("LOGIN");
			loginButton.setFont(loginButton.getFont().deriveFont(Font.PLAIN, loginButton.getFont().getSize() + 15f));
			loginButton.setBackground(new Color(0, 32, 96));
			loginButton.setFocusable(false);
			loginButton.setForeground(Color.white);
			loginButton.addActionListener(e -> LoginActionPerformed(e));
			
			//---- registerButton ----
			registerButton.setText("REGISTER");
			registerButton.setFont(registerButton.getFont().deriveFont(Font.PLAIN, registerButton.getFont().getSize() + 15f));
			registerButton.setBackground(new Color(0, 32, 96));
			registerButton.setFocusable(false);
			registerButton.setForeground(Color.white);
			registerButton.addActionListener(e -> RegisterActionPerformed(e));
			
			GroupLayout MainBackgroundLayout = new GroupLayout(MainBackground);
			MainBackground.setLayout(MainBackgroundLayout);
			MainBackgroundLayout.setHorizontalGroup(
					MainBackgroundLayout.createParallelGroup()
							.addGroup(MainBackgroundLayout.createSequentialGroup()
									.addGap(14, 14, 14)
									.addGroup(MainBackgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
											.addGroup(MainBackgroundLayout.createSequentialGroup()
													.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
													.addComponent(registerButton, GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
											.addComponent(Banner))
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			MainBackgroundLayout.setVerticalGroup(
					MainBackgroundLayout.createParallelGroup()
							.addGroup(MainBackgroundLayout.createSequentialGroup()
									.addGap(72, 72, 72)
									.addComponent(Banner)
									.addGap(115, 115, 115)
									.addGroup(MainBackgroundLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
											.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
		}
		
		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
				contentPaneLayout.createParallelGroup()
						.addComponent(MainBackground, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
		);
		contentPaneLayout.setVerticalGroup(
				contentPaneLayout.createParallelGroup()
						.addComponent(MainBackground, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
}
