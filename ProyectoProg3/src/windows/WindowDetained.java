package windows;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class WindowDetained {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_4;

	
	public WindowDetained() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(100, 100, 911, 697);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBounds(739, 56, 111, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBounds(739, 107, 111, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(739, 157, 111, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Read");
		btnNewButton_3.setBounds(739, 209, 111, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Show");
		btnNewButton_4.setBounds(739, 258, 111, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Age:");
		lblNewLabel.setBounds(46, 162, 129, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(46, 191, 78, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(46, 60, 154, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(46, 82, 111, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Surname:");
		lblNewLabel_2.setBounds(46, 111, 111, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(46, 136, 111, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setBounds(45, 222, 111, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(45, 243, 111, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBounds(173, 243, 111, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Nacionality:");
		lblNewLabel_4.setBounds(45, 283, 111, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(45, 308, 111, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Number of arrest: ");
		lblNewLabel_5.setBounds(316, 60, 168, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(316, 85, 111, 20);
		frame.getContentPane().add(spinner_1);
		
		JLabel lblNewLabel_6 = new JLabel("Description:");
		lblNewLabel_6.setBounds(45, 351, 98, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(45, 376, 109, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("If is arrested, fill this section:");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(316, 41, 359, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		DefaultTableModel modelDetained = new DefaultTableModel();
		modelDetained.addColumn("identificative");
        modelDetained.addColumn("name");
        modelDetained.addColumn("LastName");
        modelDetained.addColumn("age");
        modelDetained.addColumn("gender");
        modelDetained.addColumn("numberOfArrest");
        modelDetained.addColumn("description");
        modelDetained.addColumn("jailRelease");
        modelDetained.addColumn("citizenship");
        modelDetained.addColumn("payment");
		
		table = new JTable(modelDetained);
		table.setBounds(243, 311, 567, 296);
	
		
		JScrollPane scrollWorkers = new JScrollPane(table);
		scrollWorkers.setBounds(243, 311, 567, 296);
		
		frame.getContentPane().add(scrollWorkers);
		
		JLabel lblNewLabel_9 = new JLabel("Jail Release:");
		lblNewLabel_9.setBounds(316, 116, 184, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		textField_4 = new JTextField();
		textField_4.setBounds(316, 136, 111, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7_1 = new JLabel("If is fined, fill this section:");
		lblNewLabel_7_1.setForeground(Color.RED);
		lblNewLabel_7_1.setBounds(316, 171, 359, 14);
		frame.getContentPane().add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8 = new JLabel("Payment:");
		lblNewLabel_8.setBounds(316, 194, 214, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(316, 219, 111, 20);
		frame.getContentPane().add(spinner_2);
		
		JLabel lblNewLabel_7_2 = new JLabel("Obligatory Fields:");
		lblNewLabel_7_2.setForeground(Color.RED);
		lblNewLabel_7_2.setBounds(46, 41, 359, 14);
		frame.getContentPane().add(lblNewLabel_7_2);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Database Detained");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Save Data Arrested");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Show Data Arrested");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save Data Fined");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Show Data Fined");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Show All");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setTitle("POLICE MANAGEMENT");
		frame.setResizable(true);
		frame.setVisible(true);
		
	}
	

}
