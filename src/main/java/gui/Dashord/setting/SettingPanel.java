
package main.java.gui.Dashord.setting;

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
        this.setVisible(true);
    }

    private void SettingFrameWindowClosing(WindowEvent e) {
        this.dispose();
        dashboard.setVisible(true);
    }

    private void previousButtonActionPerformed(ActionEvent e) {
        this.dispose();
        dashboard.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        MainBackground = new JPanel();
        previousButton = new JButton();

        //======== this ========
        setResizable(false);
        setMinimumSize(new Dimension(380, 605));
        setMaximizedBounds(new Rectangle(530, 60, 380, 605));
        setBackground(new Color(0, 112, 192));
        setTitle("Setting");
        setFont(new Font("Calibri", Font.PLAIN, 14));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo.jpg")).getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

            GroupLayout MainBackgroundLayout = new GroupLayout(MainBackground);
            MainBackground.setLayout(MainBackgroundLayout);
            MainBackgroundLayout.setHorizontalGroup(
                MainBackgroundLayout.createParallelGroup()
                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            MainBackgroundLayout.setVerticalGroup(
                MainBackgroundLayout.createParallelGroup()
                    .addGroup(MainBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(previousButton)
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
                .addComponent(MainBackground, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel MainBackground;
    private JButton previousButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
