/*
 * Created by JFormDesigner on Fri Mar 26 22:39:06 IRDT 2021
 */

package main.java.gui.GameOver;

import main.java.config.FontConfig;
import main.java.config.MusicConfig;
import main.java.config.ThemeConfig;
import main.java.database.Database;
import main.java.gui.Dashord.Dashboard;
import main.java.gui.Dashord.profilesettings.ProfileSettings;
import main.java.models.User;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Brainrain
 */

public class GameOver extends JFrame {
	User activeUser = Dashboard.activeUser;
	JFrame singlePlayer;
	int score;
	int category;
	
	public GameOver(JFrame singlePlayer, int score, int category) {
		this.score = score;
		this.category = category;
		this.singlePlayer = singlePlayer;
		initComponents();
        initCustomTheme();
		initLabels();
		initComponentsProperties();
		this.setVisible(true);
	}

	private void initCustomTheme(){
	    Panel.setBackground(ThemeConfig.background);
	    tryAgainButton.setBackground(ThemeConfig.button);
    }
	
	private void initLabels() {
		currentScoreLable.setText(String.valueOf(score));
		coinAmountLabel.setText(String.valueOf(activeUser.coins));
		
		int record;
		switch (category) {
			case 1 -> record = activeUser.recordEnglish;
			case 2 -> record = activeUser.recordMath;
			case 3 -> record = activeUser.recordFood;
			case 4 -> record = activeUser.recordScience;
			case 5 -> record = activeUser.recordCommon;
			default -> record = activeUser.recordGeography;
		}
		
		recordLabel.setText(String.valueOf(record));
	}
	
	private void initComponentsProperties() {
	    for (JLabel jLabel : Arrays.asList(coinAmountLabel,label1,currentScoreLable,yourRecordLabel,recordLabel)){
	        jLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 16));
        }
		tryAgainButton.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 15));
	}
	
	private void questionsWindowClosing(WindowEvent e) {
		singlePlayerPage();
	}
	
	private void tryAgainButtonActionPerformed(ActionEvent e) {
		singlePlayerPage();
	}
	
	private void singlePlayerPage() {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);
		this.dispose();
		singlePlayer.setVisible(true);
	}
	
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Panel = new JPanel();
        coinLabel = new JLabel();
        coinAmountLabel = new JLabel();
        label1 = new JLabel();
        currentScoreLable = new JLabel();
        tryAgainButton = new JButton();
        yourRecordLabel = new JLabel();
        recordLabel = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setName("Questions");
        setMaximizedBounds(new Rectangle(580, 60, 380, 605));
        setResizable(false);
        setTitle("Questions");
        setBackground(new Color(0, 112, 192));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo.jpg")).getImage());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                questionsWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //======== Panel ========
        {
            Panel.setBackground(new Color(0, 112, 192));

            //---- coinLabel ----
            coinLabel.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Dashboard/smallCoin.png")));
            coinLabel.setHorizontalAlignment(SwingConstants.CENTER);

            //---- coinAmountLabel ----
            coinAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
            coinAmountLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            coinAmountLabel.setForeground(new Color(255, 255, 51));

            //---- label1 ----
            label1.setText("Score :");
            label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
            label1.setForeground(Color.white);

            //---- currentScoreLable ----
            currentScoreLable.setHorizontalAlignment(SwingConstants.CENTER);
            currentScoreLable.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            currentScoreLable.setForeground(Color.white);

            //---- tryAgainButton ----
            tryAgainButton.setText("Try again");
            tryAgainButton.setBackground(new Color(0, 32, 96));
            tryAgainButton.setForeground(Color.white);
            tryAgainButton.setFocusable(false);
            tryAgainButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
            tryAgainButton.setBorder(null);
            tryAgainButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            tryAgainButton.addActionListener(e -> tryAgainButtonActionPerformed(e));

            //---- yourRecordLabel ----
            yourRecordLabel.setText("your record :");
            yourRecordLabel.setForeground(Color.white);
            yourRecordLabel.setHorizontalAlignment(SwingConstants.CENTER);
            yourRecordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));

            //---- recordLabel ----
            recordLabel.setHorizontalAlignment(SwingConstants.CENTER);
            recordLabel.setForeground(Color.white);
            recordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));

            GroupLayout PanelLayout = new GroupLayout(Panel);
            Panel.setLayout(PanelLayout);
            PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(currentScoreLable, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(coinLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(coinAmountLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(139, Short.MAX_VALUE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(yourRecordLabel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(recordLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(tryAgainButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 120, Short.MAX_VALUE))
            );
            PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(PanelLayout.createParallelGroup()
                            .addComponent(coinAmountLabel, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(coinLabel, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelLayout.createParallelGroup()
                            .addComponent(currentScoreLable, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(yourRecordLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addComponent(recordLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addComponent(tryAgainButton, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(Panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(Panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
	
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel Panel;
    private JLabel coinLabel;
    private JLabel coinAmountLabel;
    private JLabel label1;
    private JLabel currentScoreLable;
    private JButton tryAgainButton;
    private JLabel yourRecordLabel;
    private JLabel recordLabel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
