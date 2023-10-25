package group1.e04.view;

// import java.awt.BorderLayout;
// import java.awt.Button;
// import java.awt.Color;
// import java.awt.EventQueue;
// import java.awt.GridBagConstraints;
// import java.awt.GridBagLayout;
// import java.awt.GridLayout;
// import java.awt.Insets;
// import java.awt.event.FocusAdapter;
// import java.awt.event.FocusEvent;
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;

// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import javax.swing.JScrollPane;
// import javax.swing.JTabbedPane;

// import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;
// import javax.swing.border.LineBorder;

// public class StudentView extends JFrame {

// 	/**
// 	 * Launch the application.
// 	 */
// 	public static void main(String[] args) {
// 		EventQueue.invokeLater(new Runnable() {
// 			public void run() {
// 				try {
// 					StudentView frame = new StudentView();
// 					frame.setVisible(true);
// 				} catch (Exception e) {
// 					e.printStackTrace();
// 				}
// 			}
// 		});
// 	}

// 	private Button forcus(Button OptionLabel) {
// 		OptionLabel.addFocusListener(new FocusAdapter() {
// 			@Override
// 			public void focusGained(FocusEvent e) {
// 				OptionLabel.setBackground(Color.PINK);
// 			}

// 			@Override
// 			public void focusLost(FocusEvent e) {
// 				OptionLabel.setBackground(Color.WHITE);
// 			}
// 		});
// 		return OptionLabel;
// 	}

// 	/**
// 	 * Create the frame.
// 	 */
// 	public StudentView() {
// 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		setBounds(100, 100, 800, 500);

// 		JPanel panel = new JPanel();
// 		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
// 		getContentPane().add(panel, BorderLayout.WEST);
// 		GridBagLayout gbl_panel = new GridBagLayout();
// 		gbl_panel.columnWidths = new int[] { 74, 0 };
// 		gbl_panel.rowHeights = new int[] { 30, 231, 0 };
// 		gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
// 		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
// 		panel.setLayout(gbl_panel);

// 		JPanel panel_2 = new JPanel();
// 		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
// 		gbc_panel_2.fill = GridBagConstraints.BOTH;
// 		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
// 		gbc_panel_2.gridx = 0;
// 		gbc_panel_2.gridy = 0;
// 		panel.add(panel_2, gbc_panel_2);
// 		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

// 		JPanel panel_3 = new JPanel();
// 		panel_2.add(panel_3);

// 		JPanel panel_4 = new JPanel();
// 		panel_2.add(panel_4);
// 		panel_4.setLayout(null);
// 		panel_4.setLayout(new GridLayout(0, 1, 0, 0));

// 		JLabel lblNewLabel = new JLabel("B21DCDT144");
// 		panel_4.add(lblNewLabel);

// 		JLabel TenSVLabel = new JLabel("Ma luong");
// 		panel_4.add(TenSVLabel);

// 		JPanel panel_5 = new JPanel();
// 		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
// 		gbc_panel_5.fill = GridBagConstraints.BOTH;
// 		gbc_panel_5.gridx = 0;
// 		gbc_panel_5.gridy = 1;
// 		panel.add(panel_5, gbc_panel_5);
// 		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

// 		Button Option1Label = new Button("1. Change information");
// 		Option1Label.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 			}
// 		});
// 		Option1Label = forcus(Option1Label);
// 		Option1Label.addMouseListener(new MouseAdapter() {
// 			@Override
// 			public void mousePressed(MouseEvent e) {
// 				System.out.println("change information");
// 				// hien change informationpanel
// 			}
// 		});
// 		// Option1Label.setBorder(new LineBorder(new Color(0, 0, 0)));
// 		panel_5.add(Option1Label);

// 		Button Option2Label = new Button("2. View all courses");
// 		Option2Label = forcus(Option2Label);
// 		Option2Label.addMouseListener(new MouseAdapter() {
// 			@Override
// 			public void mousePressed(MouseEvent e) {
// 				// hien list tat ca course
// 			}
// 		});
// 		// Option2Label.setBorder(new LineBorder(new Color(0, 0, 0)));
// 		panel_5.add(Option2Label);

// 		Button Option3Label = new Button("3. View all courses are not full");
// 		Option3Label = forcus(Option3Label);
// 		Option3Label.addMouseListener(new MouseAdapter() {
// 			@Override
// 			public void mousePressed(MouseEvent e) {
// 				// hien list
// 			}
// 		});
// 		// Option3Label.setBorder(new LineBorder(new Color(0, 0, 0)));
// 		panel_5.add(Option3Label);

// 		Button Option4Label = new Button("4. Register in a course");
// 		Option4Label = forcus(Option4Label);
// 		Option4Label.addMouseListener(new MouseAdapter() {
// 			@Override
// 			public void mousePressed(MouseEvent e) {
// 			}
// 		});
// 		// Option4Label.setBorder(new LineBorder(new Color(0, 0, 0)));
// 		panel_5.add(Option4Label);

// 		Button Option5Label = new Button("5. Width draw");
// 		Option5Label = forcus(Option5Label);
// 		Option5Label.addMouseListener(new MouseAdapter() {
// 			@Override
// 			public void mousePressed(MouseEvent e) {
// 			}
// 		});
// 		// Option5Label.setBorder(new LineBorder(new Color(0, 0, 0)));
// 		panel_5.add(Option5Label);

// 		Button Option6Label = new Button("6. Exit");
// 		Option6Label = forcus(Option6Label);
// 		Option6Label.addMouseListener(new MouseAdapter() {
// 			@Override
// 			public void mousePressed(MouseEvent e) {

// 			}
// 		});
// 		// Option6Label.setBorder(new LineBorder(new Color(0, 0, 0)));
// 		panel_5.add(Option6Label);

// 		JPanel panel_1 = new JPanel();
// 		getContentPane().add(panel_1, BorderLayout.CENTER);
// 		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
// 	}

// }
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class StudentView extends JFrame {

	public StudentView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);

		// Create a JTabbedPane with tabs on the left
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		// Create a JPanel for additional information
		JPanel infoPanel = new JPanel();
		GridBagLayout gbl_infoPanel = new GridBagLayout();
		gbl_infoPanel.columnWidths = new int[] { 0 };
		gbl_infoPanel.rowHeights = new int[] { 0, 0 };
		gbl_infoPanel.columnWeights = new double[] { 0.0 };
		gbl_infoPanel.rowWeights = new double[] { 0.0, 0.0 };
		infoPanel.setLayout(gbl_infoPanel);

		JPanel MaSVLabelPanel = new JPanel();
		MaSVLabelPanel.setLayout(new FlowLayout(0));
		JLabel MaSVLabelLabel = new JLabel("Mã sinh viên");
		JLabel MaSVLabelLabelValue = new JLabel("B21DCDT144");
		MaSVLabelPanel.add(MaSVLabelLabel);
		MaSVLabelPanel.add(MaSVLabelLabelValue);
		GridBagConstraints gbc_MaSVLabel = new GridBagConstraints();
		gbc_MaSVLabel.fill = GridBagConstraints.BOTH;
		gbc_MaSVLabel.gridx = 0;
		gbc_MaSVLabel.gridy = 0;
		infoPanel.add(MaSVLabelPanel, gbc_MaSVLabel);

		JPanel TenSVLabelPanel = new JPanel();
		TenSVLabelPanel.setLayout(new FlowLayout(0));
		JLabel TenSVLabelLabel = new JLabel("Tên sinh viên:");
		JLabel TenSVLabelLabelValue = new JLabel("Ma luong");
		TenSVLabelPanel.add(TenSVLabelLabel);
		TenSVLabelPanel.add(TenSVLabelLabelValue);
		GridBagConstraints gbc_TenSVLabel = new GridBagConstraints();
		gbc_TenSVLabel.fill = GridBagConstraints.BOTH;
		gbc_TenSVLabel.gridx = 0;
		gbc_TenSVLabel.gridy = 1;
		infoPanel.add(TenSVLabelPanel, gbc_TenSVLabel);

		JPanel LocationSVPanel = new JPanel();
		LocationSVPanel.setLayout(new FlowLayout(0));
		JLabel LocationSVLabel = new JLabel("Địa chỉ:");
		JLabel LocationSVLabelValue = new JLabel("Hà Đông , Hà Nội");
		LocationSVPanel.add(LocationSVLabel);
		LocationSVPanel.add(LocationSVLabelValue);

		GridBagConstraints gbc_LocationSVLabel = new GridBagConstraints();
		gbc_LocationSVLabel.fill = GridBagConstraints.BOTH;
		gbc_LocationSVLabel.gridx = 0;
		gbc_LocationSVLabel.gridy = 2;
		infoPanel.add(LocationSVPanel, gbc_LocationSVLabel);

		JPanel EmailSVPanel = new JPanel();
		EmailSVPanel.setLayout(new FlowLayout(0));
		JLabel EmailSVLabel = new JLabel("Email:");
		JLabel EmailSVLabelValue = new JLabel("email@gmail.com");
		EmailSVPanel.add(EmailSVLabel);
		EmailSVPanel.add(EmailSVLabelValue);

		GridBagConstraints gbc_EmailSVLabel = new GridBagConstraints();
		gbc_EmailSVLabel.fill = GridBagConstraints.BOTH;
		gbc_EmailSVLabel.gridx = 0;
		gbc_EmailSVLabel.gridy = 3;
		infoPanel.add(EmailSVPanel, gbc_EmailSVLabel);
		// import JPanel information to tabbar
		tabbedPane.addTab("Information", infoPanel);
		// Create a JPanel for additional information
		JPanel changeInfoPanel = new JPanel();
		GridBagLayout gbl_changeInfoPanel = new GridBagLayout();
		gbl_changeInfoPanel.columnWidths = new int[] { 0 };
		gbl_changeInfoPanel.rowHeights = new int[] { 0, 0 };
		gbl_changeInfoPanel.columnWeights = new double[] { 0.0 };
		gbl_changeInfoPanel.rowWeights = new double[] { 0.0, 0.0 };
		changeInfoPanel.setLayout(gbl_changeInfoPanel);

		// Panel sửa mã sinh viên
		JPanel changeMaSVPanel = new JPanel();
		changeMaSVPanel.setLayout(new GridLayout(0, 1));
		JLabel changeMaSVLabel = new JLabel("Student id: ");
		JTextField changeMaSVTextField = new JTextField("", 15);
		changeMaSVTextField.setBorder(new LineBorder(new Color(0, 0, 0)));
		changeMaSVPanel.add(changeMaSVLabel);
		changeMaSVPanel.add(changeMaSVTextField);

		// config vị trí layout của changeMaSVPanel trong changeInfoPanel
		GridBagConstraints gbc_changeMaSVLabel = new GridBagConstraints();
		gbc_changeMaSVLabel.fill = GridBagConstraints.BOTH;
		gbc_changeMaSVLabel.insets = new Insets(0, 0, 5, 0);
		gbc_changeMaSVLabel.gridx = 0;
		gbc_changeMaSVLabel.gridy = 0;
		changeInfoPanel.add(changeMaSVPanel, gbc_changeMaSVLabel);

		// Panel sửa tên sinh viên
		JPanel changeTenSVPanel = new JPanel();
		changeTenSVPanel.setLayout(new GridLayout(0, 1));
		JLabel changeTenSVLabel = new JLabel("Student name: ");
		JTextField changeTenSVTextField = new JTextField("", 15);
		changeTenSVTextField.setBorder(new LineBorder(new Color(0, 0, 0)));
		changeTenSVPanel.add(changeTenSVLabel);
		changeTenSVPanel.add(changeTenSVTextField);

		// config vị trí layout của changeTenSVPanel trong changeInfoPanel
		GridBagConstraints gbc_changeTenSVLabel = new GridBagConstraints();
		gbc_changeTenSVLabel.fill = GridBagConstraints.BOTH;
		gbc_changeTenSVLabel.insets = new Insets(0, 0, 5, 0);
		gbc_changeTenSVLabel.gridx = 0;
		gbc_changeTenSVLabel.gridy = 1;
		changeInfoPanel.add(changeTenSVPanel, gbc_changeTenSVLabel);

		// Panel sửa địa chỉ sinh viên
		JPanel changeLocationSVPanel = new JPanel();
		changeLocationSVPanel.setLayout(new GridLayout(0, 1));
		JLabel changeLocationSVLabel = new JLabel("Location: ");
		JTextArea changeLocationSVTextField = new JTextArea(2, 20);
		changeLocationSVTextField.setBorder(new LineBorder(new Color(0, 0, 0)));
		changeLocationSVPanel.add(changeLocationSVLabel);
		changeLocationSVPanel.add(changeLocationSVTextField);

		// config vị trí layout của changeLocationSVPanel trong changeInfoPanel
		GridBagConstraints gbc_changeLocationSVLabel = new GridBagConstraints();
		gbc_changeLocationSVLabel.fill = GridBagConstraints.BOTH;
		gbc_changeLocationSVLabel.insets = new Insets(0, 0, 5, 0);
		gbc_changeLocationSVLabel.gridx = 0;
		gbc_changeLocationSVLabel.gridy = 2;
		changeInfoPanel.add(changeLocationSVPanel, gbc_changeLocationSVLabel);

		// Panel sửa email sinh viên
		JPanel changeEmailSVPanel = new JPanel();
		changeEmailSVPanel.setLayout(new GridLayout(0, 1));
		JLabel changeEmailSVLabel = new JLabel("Email: ");
		JTextField changeEmailSVTextField = new JTextField("", 15);
		changeEmailSVTextField.setBorder(new LineBorder(new Color(0, 0, 0)));
		changeEmailSVPanel.add(changeEmailSVLabel);
		changeEmailSVPanel.add(changeEmailSVTextField);

		// config vị trí layout của changeEmailSVPanel trong changeInfoPanel
		GridBagConstraints gbc_changeEmailSVLabel = new GridBagConstraints();
		gbc_changeEmailSVLabel.fill = GridBagConstraints.BOTH;
		gbc_changeEmailSVLabel.insets = new Insets(0, 0, 20, 0);
		gbc_changeEmailSVLabel.gridx = 0;
		gbc_changeEmailSVLabel.gridy = 3;
		changeInfoPanel.add(changeEmailSVPanel, gbc_changeEmailSVLabel);

		// tạo button
		JPanel changeInfoButtonPanel = new JPanel();
		JButton changeInfoButton = new JButton("Save");
		changeInfoButtonPanel.add(changeInfoButton);
		GridBagConstraints gbc_changeInfoButton = new GridBagConstraints();
		gbc_changeInfoButton.fill = GridBagConstraints.BOTH;
		gbc_changeInfoButton.gridx = 0;
		gbc_changeInfoButton.gridy = 4;

		changeInfoPanel.add(changeInfoButtonPanel, gbc_changeInfoButton);
		// import JPanel information to tabbar
		tabbedPane.addTab("1.Change information", changeInfoPanel);

		List<String> courseIds = Arrays.asList("1", "2", "3");
		List<String> courseNames = Arrays.asList("Toán", "Văn", "Anh");
		List<String> courseCredits = Arrays.asList("1", "2", "3");
		List<String> facultyNames = Arrays.asList("Quỳnh", "Hiếu", "Tony");
		List<String> maxStudent = Arrays.asList("10", "20", "15");
		List<String> currentStudent = Arrays.asList("3", "20", "10");

		DefaultTableModel tableModelAllCourses = new DefaultTableModel();
		tableModelAllCourses.addColumn("Course id");
		tableModelAllCourses.addColumn("Course name");
		tableModelAllCourses.addColumn("Course credit");
		tableModelAllCourses.addColumn("Faculty name");
		tableModelAllCourses.addColumn("Max student");
		tableModelAllCourses.addColumn("Current student");
		for (int i = 0; i < (courseIds.size()); i++) {
			Object[] rowDataAllCourses = new Object[6];
			if (i < courseIds.size()) {
				rowDataAllCourses[0] = courseIds.get(i);
			}
			if (i < courseNames.size()) {
				rowDataAllCourses[1] = courseNames.get(i);
			}
			if (i < courseCredits.size()) {
				rowDataAllCourses[2] = courseCredits.get(i);
			}
			if (i < facultyNames.size()) {
				rowDataAllCourses[3] = facultyNames.get(i);
			}
			if (i < maxStudent.size()) {
				rowDataAllCourses[4] = maxStudent.get(i);
			}
			if (i < currentStudent.size()) {
				rowDataAllCourses[5] = currentStudent.get(i);
			}
			tableModelAllCourses.addRow(rowDataAllCourses);
		}

		// Create a JTable and set its model
		JTable tableAllCourses = new JTable(tableModelAllCourses);

		// Create a JScrollPane for the JTable
		JScrollPane scrollPaneAllCourses = new JScrollPane(tableAllCourses);

		// Create tabs with labels
		tabbedPane.addTab("2.View all courses", scrollPaneAllCourses);

		DefaultTableModel tableModelCoursesNotFull = new DefaultTableModel();
		tableModelCoursesNotFull.addColumn("Course id");
		tableModelCoursesNotFull.addColumn("Course name");
		tableModelCoursesNotFull.addColumn("Course credit");
		tableModelCoursesNotFull.addColumn("Faculty name");
		tableModelCoursesNotFull.addColumn("Max student");
		tableModelCoursesNotFull.addColumn("Current student");
		for (int i = 0; i < (courseIds.size()); i++) {
			Object[] rowDataCoursesNotFull = new Object[6];
			if (i < courseIds.size()) {
				rowDataCoursesNotFull[0] = courseIds.get(i);
			}
			if (i < courseNames.size()) {
				rowDataCoursesNotFull[1] = courseNames.get(i);
			}
			if (i < courseCredits.size()) {
				rowDataCoursesNotFull[2] = courseCredits.get(i);
			}
			if (i < facultyNames.size()) {
				rowDataCoursesNotFull[3] = facultyNames.get(i);
			}
			if (i < maxStudent.size()) {
				rowDataCoursesNotFull[4] = maxStudent.get(i);
			}
			if (i < currentStudent.size()) {
				rowDataCoursesNotFull[5] = currentStudent.get(i);
			}
			tableModelCoursesNotFull.addRow(rowDataCoursesNotFull);
		}

		// Create a JTable and set its model
		JTable tableCoursesNotFull = new JTable(tableModelCoursesNotFull);
		// Create a JScrollPane for the JTable
		JScrollPane scrollPaneCoursesNotFull = new JScrollPane(tableCoursesNotFull);
		tabbedPane.addTab("3.View all courses are not full", scrollPaneCoursesNotFull);
		//
		JPanel registerCourse = new JPanel();
		registerCourse.setLayout(new GridBagLayout());

		JPanel registerInputCourse = new JPanel();
		registerInputCourse.setBounds(0, 0, 0, 5);

		JLabel registerLabel = new JLabel("Id course:");
		JTextField registerTextField = new JTextField("", 20);
		registerTextField.setBorder(new LineBorder(Color.BLACK));

		registerInputCourse.add(registerLabel);
		registerInputCourse.add(registerTextField);
		GridBagConstraints registerGbc = new GridBagConstraints();
		JButton registerButton = new JButton("Register");
		registerGbc.gridx = 0;
		registerGbc.insets = new Insets(0, 0, 5, 0);
		registerGbc.gridy = 0;
		registerCourse.add(registerInputCourse, registerGbc);
		registerGbc.gridy = 1;
		registerCourse.add(registerButton, registerGbc);

		tabbedPane.addTab("4.Register in a course", registerCourse);

		JPanel widthDrawCourse = new JPanel();
		widthDrawCourse.setLayout(new GridBagLayout());

		JPanel widthDrawInputCourse = new JPanel();
		widthDrawInputCourse.setBounds(0, 0, 0, 5);

		JLabel widthDrawLabel = new JLabel("Id course:");
		JTextField widthDrawTextField = new JTextField("", 20);
		widthDrawTextField.setBorder(new LineBorder(Color.BLACK));

		widthDrawInputCourse.add(widthDrawLabel);
		widthDrawInputCourse.add(widthDrawTextField);
		GridBagConstraints widthDrawGbc = new GridBagConstraints();
		JButton widthDrawButton = new JButton("Width draw");
		widthDrawGbc.gridx = 0;
		widthDrawGbc.insets = new Insets(0, 0, 5, 0);
		widthDrawGbc.gridy = 0;
		widthDrawCourse.add(widthDrawInputCourse, widthDrawGbc);
		widthDrawGbc.gridy = 1;
		widthDrawCourse.add(widthDrawButton, widthDrawGbc);

		tabbedPane.addTab("5.Width draw", widthDrawCourse);

		JPanel exitPanel = new JPanel();
		exitPanel.setLayout(new GridBagLayout());

		JLabel exitLabel = new JLabel("Do you want to log out? ");

		JPanel exitJPanelControl = new JPanel();
		exitJPanelControl.setLayout(new GridLayout(0, 3));
		JButton exitYesButton = new JButton("Yes");
		JButton exitNoButton = new JButton("No");
		exitJPanelControl.add(exitYesButton);
		exitJPanelControl.add(new JLabel());
		exitJPanelControl.add(exitNoButton);

		GridBagConstraints exitGbc = new GridBagConstraints();
		exitGbc.gridx = 0;
		exitGbc.insets = new Insets(0, 0, 10, 0);
		exitGbc.gridy = 0;
		exitPanel.add(exitLabel, exitGbc);
		exitGbc.gridy = 1;
		exitPanel.add(exitJPanelControl, exitGbc);
		tabbedPane.addTab("6.Exit", exitPanel);

	}

	private JPanel createTabContent(String content) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JTextArea textArea = new JTextArea(content);
		textArea.setEditable(false);
		panel.add(textArea, BorderLayout.CENTER);
		return panel;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentView frame = new StudentView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
