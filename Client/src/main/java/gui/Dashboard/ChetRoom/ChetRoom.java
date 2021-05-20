/*
 * Created by JFormDesigner on Thu May 20 18:31:58 IRDT 2021
 */

package main.java.gui.Dashboard.ChetRoom;

import main.java.config.MusicConfig;
import main.java.models.User;
import main.java.socket.ChetSyncer;
import main.java.socket.Client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Sina
 */
public class ChetRoom extends JFrame {
    User activeUser = main.java.gui.Dashord.Dashboard.activeUser;
    public final JFrame dashboard;
    public static Client CLIENT;

    public ChetRoom(JFrame dashboard ,  Client client) {
        this.dashboard = dashboard;
        CLIENT = client;
        CLIENT.sendRequest("UPDATE_CHET");
        new ChetSyncer(this).start();
        initComponents();
        SendByEnter();
        this.setVisible(true);
    }

    public void updateChet(String chet) {
        ChetBox.setText(chet);
    }
    private void ChetFrameWindowClosing(WindowEvent e) {
        previousPage();
    }
    private void previousButtonActionPerformed(ActionEvent e) {
        previousPage();
    }
    private void SendButtonActionPerformed(ActionEvent e) { sendMessage(); }

    private void SendByEnter() {
        MessageField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10)
                    sendMessage();
            }
        });
    }
    private void previousPage() {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);
        this.dispose();
        dashboard.setVisible(true);
    }
    private void sendMessage() {
        String message = normalize(MessageField.getText());
        if (message.isBlank())
            return;

        CLIENT.sendRequest("SEND_MESSAGE");
        CLIENT.sendRequest(activeUser.username);
        CLIENT.sendRequest(message);

        MessageField.setText("");

    }
    public String normalize(String text) {
        text = text.replaceAll(" +", " ");
        return text.trim();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        mainBackground = new JPanel();
        previousButton = new JButton();
        ChetBox = new JTextArea();
        scrollPane1 = new JScrollPane();
        MessageField = new JTextArea();
        SendButton = new JButton();

        //======== this ========
        setResizable(false);
        setMinimumSize(new Dimension(380, 605));
        setMaximizedBounds(new Rectangle(530, 60, 380, 605));
        setBackground(new Color(0, 112, 192));
        setTitle("Chet Room");
        setFont(new Font("Calibri", Font.PLAIN, 14));
        setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/Logo.jpg")).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ChetFrameWindowClosing(e);
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

            //---- ChetBox ----
            ChetBox.setBackground(Color.white);
            ChetBox.setEditable(false);

            //======== scrollPane1 ========
            {

                //---- MessageField ----
                MessageField.setBackground(Color.white);
                scrollPane1.setViewportView(MessageField);
            }

            //---- SendButton ----
            SendButton.setText("Send");
            SendButton.addActionListener(e -> SendButtonActionPerformed(e));

            GroupLayout mainBackgroundLayout = new GroupLayout(mainBackground);
            mainBackground.setLayout(mainBackgroundLayout);
            mainBackgroundLayout.setHorizontalGroup(
                mainBackgroundLayout.createParallelGroup()
                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainBackgroundLayout.createParallelGroup()
                            .addComponent(ChetBox)
                            .addGroup(mainBackgroundLayout.createSequentialGroup()
                                .addGroup(mainBackgroundLayout.createParallelGroup()
                                    .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SendButton)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
            );
            mainBackgroundLayout.setVerticalGroup(
                mainBackgroundLayout.createParallelGroup()
                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(previousButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChetBox, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainBackgroundLayout.createParallelGroup()
                            .addComponent(scrollPane1)
                            .addComponent(SendButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private JTextArea ChetBox;
    private JScrollPane scrollPane1;
    private JTextArea MessageField;
    private JButton SendButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
