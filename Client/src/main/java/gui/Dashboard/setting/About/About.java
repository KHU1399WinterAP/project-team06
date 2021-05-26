/*
 * Created by JFormDesigner on Sat Mar 20 21:29:29 IRST 2021
 */

package main.java.gui.dashboard.setting.About;

import main.java.config.FontConfig;
import main.java.config.MusicConfig;
import main.java.config.ThemeConfig;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Sina
 */
public class About extends JFrame {
	public final JFrame setting;
	
	public About(JFrame setting) {
		this.setting = setting;
		initComponents();
		initComponentsProperties();
		initCustomTheme();
		this.setVisible(true);
	}

	private void initCustomTheme(){
	    mainBackground.setBackground(ThemeConfig.background);
	    previousButton.setBackground(ThemeConfig.background);
    }
	
	private void initComponentsProperties() {
	    for (JLabel jLabel: Arrays.asList(text1,text2,text3,text4,text5,repoLabel)){
	        jLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 20));
        }
		aboutLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 30));
		text6.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 28));
		developersLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 28));
	}
	
	private void AboutFrameWindowClosing(WindowEvent e) {
		previousPage();
	}
	
	private void previousButtonActionPerformed(ActionEvent e) {
		previousPage();
	}
	
	private void previousPage() {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);
		this.dispose();
		setting.setVisible(true);
	}
	
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        mainBackground = new JPanel();
        previousButton = new JButton();
        aboutLabel = new JLabel();
        Banner = new JLabel();
        text1 = new JLabel();
        text2 = new JLabel();
        developersLabel = new JLabel();
        text3 = new JLabel();
        text4 = new JLabel();
        text5 = new JLabel();
        repoLabel = new JLabel();
        text6 = new JLabel();

        //======== this ========
        setResizable(false);
        setMinimumSize(new Dimension(380, 605));
        setMaximizedBounds(new Rectangle(530, 60, 380, 605));
        setBackground(new Color(0, 112, 192));
        setTitle("About");
        setFont(new Font("Calibri", Font.PLAIN, 14));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo.jpg")).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                AboutFrameWindowClosing(e);
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

            //---- aboutLabel ----
            aboutLabel.setText("   About us  ");
            aboutLabel.setBackground(new Color(255, 153, 0));
            aboutLabel.setForeground(new Color(255, 153, 0));
            aboutLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));

            //---- Banner ----
            Banner.setFont(new Font("Calibri", Font.PLAIN, 54));
            Banner.setForeground(Color.white);
            Banner.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/banner.png")));

            //---- text1 ----
            text1.setText("KHU University 1399 Winter");
            text1.setBackground(new Color(255, 153, 0));
            text1.setForeground(Color.white);
            text1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

            //---- text2 ----
            text2.setText("Advanced Programing Project");
            text2.setBackground(new Color(255, 153, 0));
            text2.setForeground(Color.white);
            text2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

            //---- developersLabel ----
            developersLabel.setText("Developers :");
            developersLabel.setBackground(new Color(255, 153, 0));
            developersLabel.setForeground(new Color(255, 153, 0));
            developersLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));

            //---- text3 ----
            text3.setText("Seyed Hossein Borghei ");
            text3.setBackground(new Color(255, 153, 0));
            text3.setForeground(Color.white);
            text3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

            //---- text4 ----
            text4.setText("Alireza Reghabi");
            text4.setBackground(new Color(255, 153, 0));
            text4.setForeground(Color.white);
            text4.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

            //---- text5 ----
            text5.setText("Sina Omidvar");
            text5.setBackground(new Color(255, 153, 0));
            text5.setForeground(Color.white);
            text5.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

            //---- repoLabel ----
            repoLabel.setText("KHU1399WinterAP/project-team06");
            repoLabel.setBackground(new Color(255, 153, 0));
            repoLabel.setForeground(Color.white);
            repoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

            //---- text6 ----
            text6.setText("Github Repository : ");
            text6.setBackground(new Color(255, 153, 0));
            text6.setForeground(new Color(255, 153, 0));
            text6.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));

            GroupLayout mainBackgroundLayout = new GroupLayout(mainBackground);
            mainBackground.setLayout(mainBackgroundLayout);
            mainBackgroundLayout.setHorizontalGroup(
                mainBackgroundLayout.createParallelGroup()
                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(aboutLabel)
                        .addGap(0, 116, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addComponent(repoLabel)
                        .addGap(18, 18, 18))
                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                        .addGroup(mainBackgroundLayout.createParallelGroup()
                            .addGroup(mainBackgroundLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(mainBackgroundLayout.createParallelGroup()
                                    .addComponent(text3)
                                    .addComponent(text4)
                                    .addComponent(text5)
                                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(text6))
                                    .addComponent(text1, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(text2)))
                            .addGroup(mainBackgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainBackgroundLayout.createParallelGroup()
                                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(Banner))
                                    .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(mainBackgroundLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(developersLabel)))
                        .addContainerGap(18, Short.MAX_VALUE))
            );
            mainBackgroundLayout.setVerticalGroup(
                mainBackgroundLayout.createParallelGroup()
                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(previousButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Banner)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aboutLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(developersLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text6, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(repoLabel)
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
                .addComponent(mainBackground, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
	
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel mainBackground;
    private JButton previousButton;
    private JLabel aboutLabel;
    private JLabel Banner;
    private JLabel text1;
    private JLabel text2;
    private JLabel developersLabel;
    private JLabel text3;
    private JLabel text4;
    private JLabel text5;
    private JLabel repoLabel;
    private JLabel text6;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
