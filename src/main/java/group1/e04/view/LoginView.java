package group1.e04.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class LoginView {
    private JFrame mainFrame;
    private JPanel backgroundPanel;
    private JPanel inputPanel;
    private JTextField inputUser;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JPasswordField inputPass;
    private JPanel controlPanel;
    private JButton loginButton;
    private JLabel msglabel;
    private JLabel registerLabel;
    private JPanel registerPanel;

    Insets marginVertical = new Insets(10, 0, 10, 0);
    Insets marginBottom = new Insets(0, 0, 10, 0);
    Insets marginTop = new Insets(20, 0, 0, 0);

    public LoginView() {
        loginUI();
    }

    private void loginUI() {
        // tạo View Login
        mainFrame = new JFrame("Login");
        mainFrame.setSize(800, 500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // backgroundPanel = new JPanel();
        // backgroundPanel.setLayout(new GridBagLayout());
        // try {
        // // Đọc ảnh từ src/asset/image/okhe_blur.png
        // Image backgroundImage = ImageIO.read(new
        // File("src/asset/image/okhe_blur.png"));

        // // Tạo một JLabel để hiển thị hình nền
        // backgroundPanel = new JPanel() {
        // @Override
        // protected void paintComponent(Graphics g) {
        // super.paintComponent(g);
        // g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        // }
        // };

        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        // tạo 1 view nhỏ hơn chứa các label và input
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setOpaque(false);// đặt màu nền trong suốt

        // tạo label username
        userLabel = new JLabel("Username: ");
        userLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        userLabel.setBorder(new EmptyBorder(marginBottom));
        userLabel.setFont(userLabel.getFont().deriveFont(16.0f));
        userLabel.setForeground(Color.darkGray);

        // tạo input username
        inputUser = new JTextField(null, "", 30);
        inputUser.setPreferredSize(new Dimension(200, 30));

        // tạo label password
        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBorder(new EmptyBorder(marginVertical));
        passwordLabel.setFont(passwordLabel.getFont().deriveFont(16.0f));
        passwordLabel.setForeground(Color.darkGray);

        // tạo input pass
        inputPass = new JPasswordField("", 30);
        inputPass.setPreferredSize(new Dimension(200, 30));

        // tạo view chứa button
        controlPanel = new JPanel();
        controlPanel.setBorder(new EmptyBorder(marginTop));
        controlPanel.setOpaque(false);// đặt màu nền trong suốt
        controlPanel.setLayout(new GridBagLayout());
        // controlPanel.setLayout(new FlowLayout());

        // tạo button
        loginButton = new JButton("Login");// create button
        loginButton.setPreferredSize(new Dimension(200, 30));// set button size

        // tạo label đăng ký
        msglabel = new JLabel("Not a member ?");
        msglabel.setFont(msglabel.getFont().deriveFont(16.0f));

        // tạo label đăng ký
        registerLabel = new JLabel("Register now");
        registerLabel.setForeground(Color.blue);
        registerLabel.setFont(registerLabel.getFont().deriveFont(16.0f));

        // tạo view chứa label đăng ký
        registerPanel = new JPanel();
        registerPanel.setBorder(new EmptyBorder(marginTop));
        registerPanel.setOpaque(false);// đặt màu nền trong suốt

        GridBagConstraints gbc = new GridBagConstraints();
        // gbc.gridx = GridBagConstraints.CENTER;
        // gbc.gridy = GridBagConstraints.CENTER;
        // gbc.ipady = GridBagConstraints.CENTER;
        // backgroundPanel.add(inputPanel, gbc);

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
        controlPanel.add(loginButton);
        inputPanel.add(controlPanel, gbc);

        gbc.gridy = 5;
        registerPanel.add(msglabel);
        registerPanel.add(registerLabel);
        inputPanel.add(registerPanel, gbc);

        mainFrame.setVisible(true);
    }

    public void onLogin() {

        // headerLabel.setText("Container in action: JFrame");
        // final JFrame frame = new JFrame();
        // frame.setSize(300, 100);
        // frame.setLayout(new GridBagLayout());

        // add action listener when press button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                System.out.println("Tài khoản là " + inputUser.getText());
                System.out.println(
                        "Mật khẩu là " + new String(inputPass.getPassword()));
                StudentView frame = new StudentView();
                frame.setVisible(true);
            }
        });

        registerLabel.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent e) {
                JFrame frame = new JFrame("Clickable JLabel");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 200);
                // Xử lý hành động khi người dùng nhấn vào liên kết
                JOptionPane.showMessageDialog(frame, "Chức năng đang được phát triển", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
