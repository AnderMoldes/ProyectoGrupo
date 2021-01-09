package windows;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class WindowWorkers {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;
	
	public WindowWorkers() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(100, 100, 911, 706);
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
		
		JLabel lblNewLabel = new JLabel("Grade: ");
		lblNewLabel.setBounds(45, 56, 129, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(45, 79, 78, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(45, 111, 49, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(45, 136, 111, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Surname:");
		lblNewLabel_2.setBounds(45, 166, 111, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(45, 191, 111, 20);
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
		
		JLabel lblNewLabel_4 = new JLabel("Specialty:");
		lblNewLabel_4.setBounds(45, 283, 111, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(45, 308, 111, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Start Working in: ");
		lblNewLabel_5.setBounds(45, 355, 144, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(45, 380, 111, 20);
		frame.getContentPane().add(spinner_1);
		
		JLabel lblNewLabel_6 = new JLabel("Assessment:");
		lblNewLabel_6.setBounds(45, 424, 98, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(45, 449, 109, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("If the Worker is a boss, fill in this section:");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(331, 60, 359, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Boss fuction:");
		lblNewLabel_8.setBounds(331, 96, 109, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField_3 = new JTextField();
		textField_3.setBounds(331, 121, 109, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		DefaultTableModel modelWorkers = new DefaultTableModel();
		modelWorkers.addColumn("code");
        modelWorkers.addColumn("grade");
        modelWorkers.addColumn("name");
        modelWorkers.addColumn("surname");
        modelWorkers.addColumn("gender");
        modelWorkers.addColumn("Specialty");
        modelWorkers.addColumn("startWorkingIn");
        modelWorkers.addColumn("Assesment");
        modelWorkers.addColumn("boss function");
		
		table = new JTable(modelWorkers);
		table.setBounds(243, 311, 567, 296);
	
		
		JScrollPane scrollWorkers = new JScrollPane(table);
		scrollWorkers.setBounds(243, 311, 567, 296);
		
		frame.getContentPane().add(scrollWorkers);
		
		JLabel lblNewLabel_7_1 = new JLabel("Obligatory:");
		lblNewLabel_7_1.setForeground(Color.RED);
		lblNewLabel_7_1.setBounds(47, 31, 359, 14);
		frame.getContentPane().add(lblNewLabel_7_1);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Database Workers");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Save Data Workers");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Show Data Workers");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save Data Boss");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Show Data Boss");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Show All");
		mnNewMenu.add(mntmNewMenuItem_4);

		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setTitle("POLICE MANAGEMENT");
		frame.setResizable(true);
		frame.setVisible(true);

	}
		

}
