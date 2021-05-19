package main.java.gui.Multiplayer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class Multiplayer extends JFrame {
    public final JFrame dashboard;
    public Multiplayer(JFrame dashboard) {
        this.dashboard=dashboard;
        initComponents();
        this.setVisible(true);
    }

    private void previousButtonActionPerformed(ActionEvent e) {
        this.dispose();
        dashboard.setVisible(true);
    }

    private void MultiplayerWindowClosing(WindowEvent e) {
        this.dispose();
        dashboard.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Panel = new JPanel();
        previousButton = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(380, 605));
        setMaximizedBounds(new Rectangle(580, 60, 380, 605));
        setResizable(false);
        setTitle("Multiplayer");
        setBackground(new Color(0, 112, 192));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo.jpg")).getImage());
        setName("Multiplayer");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MultiplayerWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //======== Panel ========
        {
            Panel.setBackground(new Color(0, 112, 192));

            //---- previousButton ----
            previousButton.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/previous.png")));
            previousButton.setBackground(new Color(0, 112, 192));
            previousButton.setFocusable(false);
            previousButton.setBorder(null);
            previousButton.addActionListener(e -> previousButtonActionPerformed(e));

            //---- label1 ----
            label1.setText("Looking for a player...");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 18f));

            //---- label2 ----
            label2.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Multiplayer/Spinner-1s-200px (1).gif")));

            GroupLayout PanelLayout = new GroupLayout(Panel);
            Panel.setLayout(PanelLayout);
            PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addContainerGap(48, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addGap(45, 45, 45))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup()
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(label2)))
                        .addContainerGap(92, Short.MAX_VALUE))
            );
            PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup()
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(previousButton)
                        .addGap(27, 27, 27)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label1)
                        .addContainerGap(239, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel Panel;
    private JButton previousButton;
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
