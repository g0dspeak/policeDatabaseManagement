package cs304;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;

public class FrontEnd {

	private JFrame frame;
	private JTextField recordText;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTable table;
	private JTextField startDate;
	private JTextField endDate;
	private JTextField textField_16;
	private Driver driver = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontEnd window = new FrontEnd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrontEnd() {
		driver = Driver.getDriver();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 982, 518);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		tabbedPane.addTab("Update", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblRecordId = new JLabel("Record ID:");
		lblRecordId.setBounds(21, 26, 72, 13);
		panel.add(lblRecordId);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(21, 49, 72, 13);
		panel.add(lblDescription);
		
		JTextArea description = new JTextArea();
		description.setBounds(95, 49, 211, 185);
		panel.add(description);
		
		recordText = new JTextField();
		recordText.setBounds(95, 23, 211, 19);
		panel.add(recordText);
		recordText.setColumns(10);
		
		JCheckBox chckbxType = new JCheckBox("Type 1");
		chckbxType.setBounds(21, 240, 65, 21);
		panel.add(chckbxType);
		
		JCheckBox chckbxType_1 = new JCheckBox("Type 2");
		chckbxType_1.setBounds(85, 240, 65, 21);
		panel.add(chckbxType_1);
		
		JCheckBox checkBox = new JCheckBox("Type 2");
		checkBox.setBounds(152, 240, 65, 21);
		panel.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Type 2");
		checkBox_1.setBounds(219, 240, 65, 21);
		panel.add(checkBox_1);
		
		JLabel lblPeoplesInformation = new JLabel("Suspect Information");
		lblPeoplesInformation.setBounds(359, 26, 93, 13);
		panel.add(lblPeoplesInformation);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(369, 49, 70, 13);
		panel.add(lblName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(369, 72, 70, 13);
		panel.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone #");
		lblPhone.setBounds(369, 95, 70, 13);
		panel.add(lblPhone);
		
		JLabel lblSin = new JLabel("SIN:");
		lblSin.setBounds(369, 118, 70, 13);
		panel.add(lblSin);
		
		textField = new JTextField();
		textField.setBounds(449, 49, 135, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(449, 72, 135, 19);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(449, 95, 135, 19);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(449, 118, 135, 19);
		panel.add(textField_3);
		
		JLabel lblVictimInformation = new JLabel("Victim Information");
		lblVictimInformation.setBounds(359, 176, 93, 13);
		panel.add(lblVictimInformation);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setBounds(369, 199, 70, 13);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Address:");
		label_2.setBounds(369, 222, 70, 13);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Phone #");
		label_3.setBounds(369, 245, 70, 13);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("SIN:");
		label_4.setBounds(369, 268, 70, 13);
		panel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(449, 199, 135, 19);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(449, 222, 135, 19);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(449, 245, 135, 19);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(449, 268, 135, 19);
		panel.add(textField_7);
		
		JLabel lblOfficerInformation = new JLabel("Officer Information");
		lblOfficerInformation.setBounds(21, 301, 93, 13);
		panel.add(lblOfficerInformation);
		
		JLabel lblOfficerId = new JLabel("Officer ID:");
		lblOfficerId.setBounds(31, 324, 62, 13);
		panel.add(lblOfficerId);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(103, 321, 135, 19);
		panel.add(textField_8);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(31, 271, 62, 13);
		panel.add(lblDate);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(103, 268, 135, 19);
		panel.add(textField_9);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(21, 379, 85, 21);
		panel.add(btnUpdate);
		
		JLabel lblCourtInformation = new JLabel("Court Information");
		lblCourtInformation.setBounds(620, 26, 93, 13);
		panel.add(lblCourtInformation);
		
		JLabel lblTrialId = new JLabel("Trial id:");
		lblTrialId.setBounds(630, 49, 70, 13);
		panel.add(lblTrialId);
		
		JLabel lblJudge = new JLabel("Judge:");
		lblJudge.setBounds(630, 72, 70, 13);
		panel.add(lblJudge);
		
		JLabel lblOutcome = new JLabel("Outcome");
		lblOutcome.setBounds(630, 95, 70, 13);
		panel.add(lblOutcome);
		
		JLabel lblDate_1 = new JLabel("Date:");
		lblDate_1.setBounds(630, 118, 70, 13);
		panel.add(lblDate_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(710, 49, 135, 19);
		panel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(710, 72, 135, 19);
		panel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(710, 95, 135, 19);
		panel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(710, 118, 135, 19);
		panel.add(textField_13);
		
		JLabel label = new JLabel("Description:");
		label.setBounds(630, 141, 72, 13);
		panel.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(710, 141, 205, 185);
		panel.add(textArea);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(129, 383, 45, 13);
		panel.add(lblResult);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(167, 383, 332, 98);
		panel.add(textArea_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(21, 410, 85, 21);
		panel.add(btnDelete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.background"));
		tabbedPane.addTab("Search", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(470, 90, 460, 324);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Button button = new Button("populateTest");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				/*
				 * ResultSet rs = pst.executeQuery();
				 * 
				 * 
				 * 
				 */

			}
		});
		button.setBounds(599, 43, 120, 20);
		panel_1.add(button);
		
		JCheckBox homicideS = new JCheckBox("Homicide");
		homicideS.setBounds(6, 60, 84, 21);
		panel_1.add(homicideS);
		
		JCheckBox arsonS = new JCheckBox("Arson");
		arsonS.setBounds(92, 60, 65, 21);
		panel_1.add(arsonS);
		
		JCheckBox assaultS = new JCheckBox("Assault");
		assaultS.setBounds(158, 60, 65, 21);
		panel_1.add(assaultS);
		
		JCheckBox burglaryS = new JCheckBox("Burglary");
		burglaryS.setBounds(235, 60, 65, 21);
		panel_1.add(burglaryS);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(10, 13, 62, 13);
		panel_1.add(lblStartDate);
		
		startDate = new JTextField();
		startDate.setColumns(10);
		startDate.setBounds(82, 10, 135, 19);
		panel_1.add(startDate);
		
		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setBounds(10, 34, 62, 13);
		panel_1.add(lblEndDate);
		
		endDate = new JTextField();
		endDate.setColumns(10);
		endDate.setBounds(82, 31, 135, 19);
		panel_1.add(endDate);
		
		JButton btnFindRecord = new JButton("Find Records");
		btnFindRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				table.setModel(DbUtils.resultSetToTableModel(driver.getTest()));

				//check start date, startDate
				//check end date, endDate
				//homicideS
				//arsonS
				//assaultS
				//burglaryS
				

				
			}
		});
		btnFindRecord.setBounds(66, 88, 120, 21);
		panel_1.add(btnFindRecord);
		
		JLabel lblRecordId_1 = new JLabel("Record ID:");
		lblRecordId_1.setBounds(16, 140, 72, 13);
		panel_1.add(lblRecordId_1);
		
		textField_16 = new JTextField();
		textField_16.setBounds(82, 137, 135, 20);
		panel_1.add(textField_16);
		textField_16.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 119, 340, 2);
		panel_1.add(separator);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
