package main.java.gui.RegisterMenu;

import main.java.animations.ColorChangeAnimation;
import main.java.config.FontConfig;
import main.java.database.Database;
import main.java.errors.GuiError;
import main.java.models.User;
import main.java.utils.GuiValidation;

import java.awt.*;
import java.awt.event.*;
import java.util.function.Consumer;
import javax.swing.*;
import javax.swing.GroupLayout;

import static main.java.config.GuiConfig.COLOR_DANGER;


public class RegisterMenu extends JFrame {
    private final JFrame PreviousFrame;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel mainBackground;
    private JLabel textLabel;
    private JLabel faceLabel;
    private JLabel usernameLabel;
    private JScrollPane scrollPane1;
    private JTextArea inputUserName;
    private JLabel passwordLabel;
    private JPasswordField inputPassword;
    private JButton registerButton;
    private JLabel usernameErrorLabel;
    private JLabel passwordErrorLabel;
    private JButton previousButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public RegisterMenu(JFrame PreviousFrame) {
        this.PreviousFrame = PreviousFrame;
        initComponents();
        initComponentsProperties();
        this.setVisible(true);
    }

    private void initComponentsProperties() {
        inputPassword.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        inputUserName.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        textLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 50));
        usernameErrorLabel.setFont(FontConfig.comic.deriveFont(Font.ITALIC, 14));
        passwordErrorLabel.setFont(FontConfig.comic.deriveFont(Font.ITALIC, 14));
        usernameLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        passwordLabel.setFont(FontConfig.comic.deriveFont(Font.PLAIN, 14));
        registerButton.setFont(FontConfig.comic.deriveFont(Font.BOLD, 20));
        previousButton.setFont(FontConfig.comic.deriveFont(Font.ITALIC, 10));


    }

    private void RegisterButtonActionPerformed(ActionEvent e) {

        var usernameError = GuiValidation.validateUsername(inputUserName.getText());
        var passwordError = GuiValidation.validatePassword(String.valueOf(inputPassword.getPassword()));

        if (Database.AlreadyExisted(inputUserName.getText())) {

            usernameErrorLabel.setText("username already exists");
            runMainPanelBackgroundColorAnimation(mainBackground);

        } else if (usernameError == null && passwordError == null) {

            User user = new User(inputUserName.getText(), inputPassword.getPassword(),1,100,0,0,0,0,0,0);
            Database.InsertInToUsers(user);
            registerButton.setBackground(Color.GREEN);
            registerButton.setText("Registered !");

        } else {
            runMainPanelBackgroundColorAnimation(mainBackground);
            updateErrorLabel(usernameError, usernameErrorLabel);
            updateErrorLabel(passwordError, passwordErrorLabel);
        }
    }

    public static void  runMainPanelBackgroundColorAnimation(JPanel MainBackground) {
        Consumer<Color> stepCallback = MainBackground::setBackground;
        Runnable endCallback = () -> MainBackground.setBackground(new Color(0, 112, 192));
        new ColorChangeAnimation(MainBackground.getBackground(), COLOR_DANGER, stepCallback, endCallback).start();
    }

    private void updateErrorLabel(GuiError error, JLabel errorLabel) {
        if (error != null)
            errorLabel.setText(error.getMessage());
        else
            errorLabel.setText("");
    }

    private void PreviousButtonActionPerformed(ActionEvent e) {
        this.dispose();
        PreviousFrame.setVisible(true);
    }

    private void RegisterFrameWindowClosed(WindowEvent e) {
        this.dispose();
        PreviousFrame.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        mainBackground = new JPanel();
        textLabel = new JLabel();
        faceLabel = new JLabel();
        usernameLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        inputUserName = new JTextArea();
        passwordLabel = new JLabel();
        inputPassword = new JPasswordField();
        registerButton = new JButton();
        usernameErrorLabel = new JLabel();
        passwordErrorLabel = new JLabel();
        previousButton = new JButton();

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

            //---- textLabel ----
            textLabel.setText("Quiz Of Kings");
            textLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
            textLabel.setForeground(Color.white);

            //---- faceLabel ----
            faceLabel.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Theme/SmallLogo.jpg")));

            //---- usernameLabel ----
            usernameLabel.setText("Username");
            usernameLabel.setForeground(Color.white);
            usernameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

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

            //---- passwordLabel ----
            passwordLabel.setText("Password");
            passwordLabel.setForeground(Color.white);
            passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- inputPassword ----
            inputPassword.setBackground(Color.white);
            inputPassword.setForeground(new Color(0, 32, 96));
            inputPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

            //---- registerButton ----
            registerButton.setText("REGISTER");
            registerButton.setForeground(Color.white);
            registerButton.setBackground(new Color(0, 32, 96));
            registerButton.setFocusable(false);
            registerButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            registerButton.addActionListener(e -> RegisterButtonActionPerformed(e));

            //---- usernameErrorLabel ----
            usernameErrorLabel.setForeground(Color.red);
            usernameErrorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

            //---- passwordErrorLabel ----
            passwordErrorLabel.setForeground(Color.red);
            passwordErrorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

            //---- previousButton ----
            previousButton.setText("PREVIOUS");
            previousButton.setBackground(new Color(137, 0, 0, 209));
            previousButton.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
            previousButton.setForeground(Color.white);
            previousButton.setAlignmentX(16.0F);
            previousButton.setFocusable(false);
            previousButton.addActionListener(e -> PreviousButtonActionPerformed(e));

            GroupLayout mainBackgroundLayout = new GroupLayout(mainBackground);
            mainBackground.setLayout(mainBackgroundLayout);
            mainBackgroundLayout.setHorizontalGroup(
                mainBackgroundLayout.createParallelGroup()
                    .addGroup(mainBackgroundLayout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(mainBackgroundLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createSequentialGroup()
                                .addComponent(faceLabel)
                                .addGap(119, 119, 119))
                            .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createSequentialGroup()
                                .addComponent(textLabel)
                                .addGap(29, 29, 29))
                            .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createParallelGroup()
                                .addGroup(mainBackgroundLayout.createSequentialGroup()
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
                                .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createSequentialGroup()
                                    .addGroup(mainBackgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createSequentialGroup()
                                            .addComponent(usernameLabel)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(usernameErrorLabel, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createParallelGroup()
                                            .addGroup(mainBackgroundLayout.createSequentialGroup()
                                                .addComponent(passwordLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passwordErrorLabel, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(inputPassword, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(16, 16, 16)))
                            .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createSequentialGroup()
                                .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136))))
            );
            mainBackgroundLayout.setVerticalGroup(
                mainBackgroundLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, mainBackgroundLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(faceLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textLabel)
                        .addGap(26, 26, 26)
                        .addGroup(mainBackgroundLayout.createParallelGroup()
                            .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameErrorLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainBackgroundLayout.createParallelGroup()
                            .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordErrorLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
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
                .addComponent(mainBackground, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

}
