
package main.java.gui.Dashord.setting;

import main.java.app.Main;
import main.java.config.FontConfig;

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
    }

    private void SettingFrameWindowClosing(WindowEvent e) {
        this.dispose();
        dashboard.setVisible(true);
    }

    private void previousButtonActionPerformed(ActionEvent e) {
        this.dispose();
        dashboard.setVisible(true);
    }

    private void musicButtonActionPerformed(ActionEvent e) {
        if (musicButton.getText().equals("ON")) {
            musicButton.setText("OFF");
            Main.mp3Player.pause();
        }else {
            musicButton.setText("ON");
            Main.mp3Player.play();
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
        MusicLabel = new JLabel();
        AboutButton = new JButton();

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

            //---- MusicLabel ----
            MusicLabel.setText("   Music  ");
            MusicLabel.setBackground(new Color(255, 153, 0));
            MusicLabel.setForeground(new Color(255, 153, 0));
            MusicLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

            //---- AboutButton ----
            AboutButton.setText("About");
            AboutButton.setBackground(new Color(0, 32, 96));
            AboutButton.setForeground(Color.white);
            AboutButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            AboutButton.setFocusable(false);
            AboutButton.addActionListener(e -> AboutButtonActionPerformed(e));

            GroupLayout MainBackgroundLayout = new GroupLayout(MainBackground);
            MainBackground.setLayout(MainBackgroundLayout);
            MainBackgroundLayout.setHorizontalGroup(
                MainBackgroundLayout.createParallelGroup()
                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(musiclabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(MusicLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(musicButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                        .addGroup(MainBackgroundLayout.createParallelGroup()
                            .addGroup(MainBackgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainBackgroundLayout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(AboutButton, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            MainBackgroundLayout.setVerticalGroup(
                MainBackgroundLayout.createParallelGroup()
                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(previousButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainBackgroundLayout.createParallelGroup()
                            .addGroup(MainBackgroundLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(musicButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                .addComponent(MusicLabel))
                            .addComponent(musiclabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AboutButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
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
    private JLabel MusicLabel;
    private JButton AboutButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
