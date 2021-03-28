package main.java.gui.Dashord.setting;

import main.java.config.FontConfig;
import main.java.config.MusicConfig;
import main.java.gui.Dashord.setting.About.About;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Sina
 */
public class SettingPanel extends JFrame {
	public final JFrame dashboard;
	
	public SettingPanel(JFrame dashboard) {
		this.dashboard = dashboard;
		initComponents();
		initComponentsProperties();
		this.setVisible(true);
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
		this.dispose();
		dashboard.setVisible(true);
	}
	
	private void musicButtonActionPerformed(ActionEvent e) {
		if (musicButton.getText().equals(MusicPlayerStatus.ON.labelText)) {
			musicButton.setText(MusicPlayerStatus.OFF.labelText);
			MusicConfig.mp3Player.pause();
		} else {
			musicButton.setText(MusicPlayerStatus.ON.labelText);
			MusicConfig.mp3Player.play();
		}
	}
	
	private void AboutButtonActionPerformed(ActionEvent e) {
		this.setVisible(false);
		new About(this);
	}
	
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		MainBackground = new JPanel();
		previousButton = new JButton();
		musiclabel = new JLabel();
		musicButton = new JButton();
		aboutButton = new JButton();
		
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
		
		//======== MainBackground ========
		{
			MainBackground.setMaximumSize(new Dimension(380, 605));
			MainBackground.setMinimumSize(new Dimension(380, 605));
			MainBackground.setBackground(new Color(0, 112, 192));
			
			//---- previousButton ----
			previousButton.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/leftArrow@2x.png")));
			previousButton.setBackground(new Color(0, 112, 192));
			previousButton.setFocusable(false);
			previousButton.setBorder(null);
			previousButton.addActionListener(e -> previousButtonActionPerformed(e));
			
			//---- musiclabel ----
			musiclabel.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/musicCat@2x.png")));
			
			//---- musicButton ----
			musicButton.setBackground(new Color(0, 112, 192));
			musicButton.setForeground(Color.white);
			musicButton.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
			musicButton.setText("ON");
			musicButton.setBorder(null);
			musicButton.setFocusable(false);
			musicButton.addActionListener(e -> musicButtonActionPerformed(e));
			
			//---- aboutButton ----
			aboutButton.setText("About");
			aboutButton.setBackground(new Color(0, 32, 96));
			aboutButton.setForeground(Color.white);
			aboutButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			aboutButton.setFocusable(false);
			aboutButton.addActionListener(e -> AboutButtonActionPerformed(e));
			
			GroupLayout MainBackgroundLayout = new GroupLayout(MainBackground);
			MainBackground.setLayout(MainBackgroundLayout);
			MainBackgroundLayout.setHorizontalGroup(
					MainBackgroundLayout.createParallelGroup()
							.addGroup(MainBackgroundLayout.createSequentialGroup()
									.addGroup(MainBackgroundLayout.createParallelGroup()
											.addGroup(MainBackgroundLayout.createSequentialGroup()
													.addContainerGap()
													.addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
											.addGroup(MainBackgroundLayout.createSequentialGroup()
													.addGap(114, 114, 114)
													.addComponent(aboutButton, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
											.addGroup(MainBackgroundLayout.createSequentialGroup()
													.addGap(79, 79, 79)
													.addComponent(musiclabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
													.addComponent(musicButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			MainBackgroundLayout.setVerticalGroup(
					MainBackgroundLayout.createParallelGroup()
							.addGroup(MainBackgroundLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(previousButton)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(MainBackgroundLayout.createParallelGroup()
											.addComponent(musicButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addComponent(musiclabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(aboutButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addGap(141, 141, 141))
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
						.addComponent(MainBackground, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
	
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel MainBackground;
	private JButton previousButton;
	private JLabel musiclabel;
	private JButton musicButton;
	private JButton aboutButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}

enum MusicPlayerStatus {
	ON("1"),
	OFF("0");
	
	String labelText;
	
	private MusicPlayerStatus(String labelText) {
		this.labelText = labelText;
	}
}
