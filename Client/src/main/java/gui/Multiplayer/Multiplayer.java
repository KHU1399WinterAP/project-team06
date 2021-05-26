package main.java.gui.Multiplayer;

import main.java.config.FontConfig;
import main.java.config.MusicConfig;
import main.java.config.ThemeConfig;
import main.java.gui.Dashboard.Dashboard;
import main.java.gui.MultiplayerQuestion.MultiplayerQuestion;
import main.java.gui.chooseCategory.ChooseCategory;
import main.java.socket.Client;
import main.java.socket.FindEnemy;
import main.java.socket.Requests;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;
import javax.swing.GroupLayout;

public class Multiplayer extends JFrame {
    public final JFrame dashboard;
    public final Client CLIENT = Dashboard.CLIENT;
    FindEnemy findEnemy;

    public Multiplayer(JFrame dashboard) {
        this.dashboard = dashboard;
        initComponents();
        initComponentsProperties();
        initCustomTheme();
        findEnemy = new FindEnemy(CLIENT, this);
        findEnemy.start();
        this.setVisible(true);
    }

    public void found() {
        loadingGif.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/main/resources/icons/check.png"))));
        loadingText.setText("found !");

        Timer pause = new Timer(1000, e -> {
            this.dispose();
            new ChooseCategory(CLIENT);
        });
        pause.setRepeats(false);
        pause.start();
    }

    private void initComponentsProperties() {
        loadingText.setFont(FontConfig.comic.deriveFont(Font.BOLD, 25));
    }

    private void initCustomTheme() {
        Panel.setBackground(ThemeConfig.background);
        loadingGif.setBackground(ThemeConfig.background);
        previousButton.setBackground(ThemeConfig.background);
    }

    private void previousButtonActionPerformed(ActionEvent e) {
        previous();
    }

    private void MultiplayerWindowClosing(WindowEvent e) {
        previous();
    }

    private void previous() {
        MusicConfig.initShortMp3(MusicConfig.celClickSong);
        this.dispose();

        CLIENT.sendRequest(Requests.OUT_OF_MULTIPLAYER.request);

        dashboard.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Panel = new JPanel();
        previousButton = new JButton();
        loadingText = new JLabel();
        loadingGif = new JLabel();

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
        contentPane.setLayout(null);

        //======== Panel ========
        {
            Panel.setBackground(new Color(0, 112, 192));
            Panel.setLayout(null);

            //---- previousButton ----
            previousButton.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/previous.png")));
            previousButton.setBackground(new Color(0, 112, 192));
            previousButton.setFocusable(false);
            previousButton.setBorder(null);
            previousButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            previousButton.addActionListener(e -> previousButtonActionPerformed(e));
            Panel.add(previousButton);
            previousButton.setBounds(18, 21, 57, previousButton.getPreferredSize().height);

            //---- loadingText ----
            loadingText.setText("Looking for a player...");
            loadingText.setFont(loadingText.getFont().deriveFont(loadingText.getFont().getSize() + 18f));
            loadingText.setForeground(Color.white);
            loadingText.setHorizontalAlignment(SwingConstants.CENTER);
            Panel.add(loadingText);
            loadingText.setBounds(new Rectangle(new Point(40, 365), loadingText.getPreferredSize()));

            //---- loadingGif ----
            loadingGif.setIcon(new ImageIcon(getClass().getResource("/main/resources/icons/Multiplayer/Spinner-1s-200px (1).gif")));
            Panel.add(loadingGif);
            loadingGif.setBounds(85, 140, loadingGif.getPreferredSize().width, 162);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < Panel.getComponentCount(); i++) {
                    Rectangle bounds = Panel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = Panel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                Panel.setMinimumSize(preferredSize);
                Panel.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(Panel);
        Panel.setBounds(0, 0, 380, 565);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel Panel;
    private JButton previousButton;
    private JLabel loadingText;
    private JLabel loadingGif;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
