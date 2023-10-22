package group1.e04.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class LoginView {
    private JFrame mainFrame;
    private JPanel inputPanel;
    private JTextField inputUser;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JPasswordField inputPass;
    private JPanel controlPanel;
    private JLabel msglabel;
    Insets marginVertical = new Insets(10, 0, 10, 0);
    Insets marginBottom = new Insets(0, 0, 10, 0);
    Insets marginTop = new Insets(20, 0, 0, 0);

    public LoginView() {
        loginUI();
    }

    private void loginUI() {
        mainFrame = new JFrame("Login");
        mainFrame.setSize(350, 300);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());

        userLabel = new JLabel("Username: ");
        userLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        userLabel.setBorder(new EmptyBorder(marginBottom));

        inputUser = new JTextField(null, "", 20);
        inputUser.setPreferredSize(new Dimension(200, 20));

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBorder(new EmptyBorder(marginVertical));

        inputPass = new JPasswordField("", 20);
        inputPass.setPreferredSize(new Dimension(200, 20));

        msglabel = new JLabel("Đăng nhập thành công", JLabel.CENTER);

        controlPanel = new JPanel();
        controlPanel.setBorder(new EmptyBorder(marginTop));
        controlPanel.setLayout(new GridBagLayout());
        // controlPanel.setLayout(new FlowLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        mainFrame.add(inputPanel);
        inputPanel.add(userLabel, gbc);
        gbc.gridy = 1;
        inputPanel.add(inputUser, gbc);
        gbc.gridy = 2;
        inputPanel.add(passwordLabel, gbc);
        gbc.gridy = 3;
        inputPanel.add(inputPass, gbc);
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(controlPanel, gbc);

        mainFrame.setVisible(true);
    }

    public void onShowLogin() {

        // headerLabel.setText("Container in action: JFrame");
        final JFrame frame = new JFrame();
        frame.setSize(300, 100);
        frame.setLayout(new GridBagLayout());

        JButton loginButton = new JButton("Login");// create button
        loginButton.setPreferredSize(new Dimension(150, 30));// set button size

        loginButton.addActionListener(new ActionListener() {// add action listener when press button
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);

                msglabel.setText("Đăng nhập thành công\n ");
                frame.add(msglabel);
                frame.add(new JLabel("Chào mừng " + inputUser.getText()));
                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent windowEvent) {
                        frame.dispose();
                    }
                });
                frame.setVisible(true);
            }
        });

        controlPanel.add(loginButton);
        mainFrame.setVisible(true);

    }
}
