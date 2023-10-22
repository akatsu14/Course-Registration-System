package group1.e04.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class StudentView {
    private JFrame mainFrame;
    private JPanel inputPanel;
    private JLabel Option1;
    private JLabel Option2;
    private JLabel Option3;
    private JLabel Option4;
    private JLabel Option5;
    private JLabel Option6;

    public StudentView() {
        // setVisible(false);
        studentUI();
    }

    public void setVisible(boolean visible) {
        mainFrame.setVisible(visible);
    }

    private void studentUI() {
        mainFrame = new JFrame("Login");
        mainFrame.setSize(800, 500);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // tạo 1 view nhỏ hơn chứa các label và input
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());

        Option1 = new JLabel("1. View all courses");
        Option1.setSize(200, 40);
        Option1.setFont(Option1.getFont().deriveFont(16.0f));

        Option2 = new JLabel("2. View all courses that are NOT full");
        Option2.setSize(200, 40);
        Option2.setFont(Option1.getFont().deriveFont(16.0f));

        Option3 = new JLabel("3. View your transcript");
        Option3.setSize(200, 40);
        Option3.setFont(Option1.getFont().deriveFont(16.0f));

        Option4 = new JLabel("4. View your course list");
        Option4.setSize(200, 40);
        Option4.setFont(Option1.getFont().deriveFont(16.0f));

        Option5 = new JLabel("5. View your course detail");
        Option5.setSize(200, 40);
        Option5.setFont(Option1.getFont().deriveFont(16.0f));

        Option6 = new JLabel("6. Logout");
        Option6.setSize(200, 40);
        Option6.setFont(Option1.getFont().deriveFont(16.0f));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainFrame.add(inputPanel);
        inputPanel.add(Option1, gbc);

        gbc.gridy = 1;
        inputPanel.add(Option2, gbc);

        gbc.gridy = 2;
        inputPanel.add(Option3, gbc);

        gbc.gridy = 3;
        inputPanel.add(Option4, gbc);

        gbc.gridy = 4;
        inputPanel.add(Option5, gbc);

        gbc.gridy = 5;
        inputPanel.add(Option6, gbc);

        mainFrame.setVisible(true);
    }
}
