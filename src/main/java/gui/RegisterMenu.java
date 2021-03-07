package main.java.gui;
import main.java.database.Database;
import main.java.models.User;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;


public class RegisterMenu extends JFrame {
    private final JFrame PreviousFrame;

    public RegisterMenu(JFrame PreviousFrame) {
        this.PreviousFrame = PreviousFrame;
        initComponents();
    }

    private void RegisterButtonActionPerformed(ActionEvent e) {
        if (Database.AlreadyExisted(InputUserName.getText())) {
            RegisterButton.setBackground(Color.red);
            RegisterButton.setText("Username Already exists !");
        } else {
            User user = new User(InputUserName.getText(), InputPassword.getPassword());
            Database.InsertInToUsers(user);
            RegisterButton.setBackground(Color.GREEN);
            RegisterButton.setText("Registered successfully !");
        }
    }

    private void PreviousButtonActionPerformed(ActionEvent e) {
        RegisterFrame.dispose();
        PreviousFrame.setVisible(true);
    }

    private void RegisterFrameWindowClosed(WindowEvent e) {
        RegisterFrame.dispose();
        PreviousFrame.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        RegisterFrame = new JFrame();
        JPanel mainBackground = new JPanel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel usernameLabel = new JLabel();
        JScrollPane scrollPane1 = new JScrollPane();
        InputUserName = new JTextArea();
        JLabel passwordLabel = new JLabel();
        InputPassword = new JPasswordField();
        RegisterButton = new JButton();
        JButton previousButton = new JButton();

        //======== RegisterFrame ========
        {
            RegisterFrame.setResizable(false);
            RegisterFrame.setMinimumSize(new Dimension(380, 605));
            RegisterFrame.setMaximizedBounds(new Rectangle(530, 60, 380, 605));
            RegisterFrame.setBackground(new Color(0, 112, 192));
            RegisterFrame.setTitle("Register Menu");
            RegisterFrame.setFont(new Font("Calibri", Font.PLAIN, 14));
            RegisterFrame.setIconImage(new ImageIcon(getClass().getResource("/main/resources/icons/Logo.jpg")).getImage());
            RegisterFrame.setVisible(true);
            RegisterFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            RegisterFrame.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            RegisterFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    RegisterFrameWindowClosed(e);
                }
            });
            var RegisterFrameContentPane = RegisterFrame.getContentPane();

            //======== MainBackground ========
            {
                mainBackground.setMaximumSize(new Dimension(380, 605));
                mainBackground.setMinimumSize(new Dimension(380, 605));
                mainBackground.setBackground(new Color(0, 112, 192));
                mainBackground.setFocusable(false);

                //---- label1 ----
                label1.setText("Quiz Of Kings");
                label1.setFont(new Font("Calibri", Font.PLAIN, 54));

                //---- label2 ----
                label2.setText("text");
                label2.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Logo.jpg")));

                //---- UsernameLabel ----
                usernameLabel.setText("Username");
                usernameLabel.setForeground(Color.white);

                //======== scrollPane1 ========
                {

                    //---- InputUserName ----
                    InputUserName.setBackground(Color.white);
                    InputUserName.setForeground(Color.darkGray);
                    InputUserName.setLineWrap(true);
                    InputUserName.setTabSize(10);
                    InputUserName.setAlignmentX(1.5F);
                    InputUserName.setAlignmentY(1.5F);
                    scrollPane1.setViewportView(InputUserName);
                }

                //---- PasswordLabel ----
                passwordLabel.setText("Password");
                passwordLabel.setForeground(Color.white);

                //---- InputPassword ----
                InputPassword.setBackground(Color.white);
                InputPassword.setForeground(Color.darkGray);

                //---- RegisterButton ----
                RegisterButton.setText("Register");
                RegisterButton.setForeground(Color.gray);
                RegisterButton.setBackground(new Color(0, 32, 96));
                RegisterButton.setFocusable(false);
                RegisterButton.addActionListener(this::RegisterButtonActionPerformed);

                //---- PreviousButton ----
                previousButton.setText("previous");
                previousButton.setBackground(new Color(137, 0, 0, 209));
                previousButton.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 12));
                previousButton.setForeground(Color.lightGray);
                previousButton.setAlignmentX(16.0F);
                previousButton.setFocusable(false);
                previousButton.addActionListener(this::PreviousButtonActionPerformed);

                GroupLayout MainBackgroundLayout = new GroupLayout(mainBackground);
                mainBackground.setLayout(MainBackgroundLayout);
                MainBackgroundLayout.setHorizontalGroup(
                        MainBackgroundLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(MainBackgroundLayout.createParallelGroup()
                                                .addGroup(MainBackgroundLayout.createSequentialGroup()
                                                        .addGap(131, 131, 131)
                                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(MainBackgroundLayout.createSequentialGroup()
                                                        .addGap(90, 90, 90)
                                                        .addGroup(MainBackgroundLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(RegisterButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(scrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(InputPassword, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(usernameLabel, GroupLayout.Alignment.LEADING)
                                                                .addComponent(passwordLabel, GroupLayout.Alignment.LEADING)))
                                                .addGroup(MainBackgroundLayout.createSequentialGroup()
                                                        .addGap(140, 140, 140)
                                                        .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(MainBackgroundLayout.createSequentialGroup()
                                                        .addGap(45, 45, 45)
                                                        .addComponent(label1)))
                                        .addGap(48, 48, 48))
                );
                MainBackgroundLayout.setVerticalGroup(
                        MainBackgroundLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, MainBackgroundLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(label1)
                                        .addGap(30, 30, 30)
                                        .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(InputPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(RegisterButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                );
            }

            GroupLayout RegisterFrameContentPaneLayout = new GroupLayout(RegisterFrameContentPane);
            RegisterFrameContentPane.setLayout(RegisterFrameContentPaneLayout);
            RegisterFrameContentPaneLayout.setHorizontalGroup(
                    RegisterFrameContentPaneLayout.createParallelGroup()
                            .addComponent(mainBackground, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            RegisterFrameContentPaneLayout.setVerticalGroup(
                    RegisterFrameContentPaneLayout.createParallelGroup()
                            .addComponent(mainBackground, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
            );
            RegisterFrame.pack();
            RegisterFrame.setLocationRelativeTo(RegisterFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame RegisterFrame;
    private JTextArea InputUserName;
    private JPasswordField InputPassword;
    private JButton RegisterButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
