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

import classes.Arrested;
import classes.Country;
import classes.PoliceStation;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class WindowDetained {
	PoliceStation policeS;
	private JFrame frame;
	private JTextField tname;
	private JTextField tsurname;
	private JTextField tdescription;
	private JTable table;
	private JTextField treleased;

	
	public WindowDetained(Arrested arrested, PoliceStation police, DefaultTableModel model) {
		policeS = new PoliceStation();
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(100, 100, 911, 697);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton bcreate = new JButton("Create");
		bcreate.setBounds(739, 56, 111, 23);
		frame.getContentPane().add(bcreate);
		
		JButton bupdate = new JButton("Update");
		bupdate.setBounds(739, 107, 111, 23);
		frame.getContentPane().add(bupdate);
		
		JButton bdelete = new JButton("Delete");
		bdelete.setBounds(739, 157, 111, 23);
		frame.getContentPane().add(bdelete);
		
		JButton bread = new JButton("Read");
		bread.setBounds(739, 209, 111, 23);
		frame.getContentPane().add(bread);
		
		JButton bshow = new JButton("Show");
		bshow.setBounds(739, 258, 111, 23);
		frame.getContentPane().add(bshow);
		
		JLabel lage = new JLabel("Age:");
		lage.setBounds(46, 162, 129, 23);
		frame.getContentPane().add(lage);
		
		JSpinner spinAge = new JSpinner();
		spinAge.setBounds(46, 191, 78, 20);
		frame.getContentPane().add(spinAge);
		
		JLabel lname = new JLabel("Name:");
		lname.setBounds(46, 60, 154, 14);
		frame.getContentPane().add(lname);
		
		tname = new JTextField();
		tname.setBounds(46, 82, 111, 20);
		frame.getContentPane().add(tname);
		tname.setColumns(10);
		
		JLabel lsurname = new JLabel("Surname:");
		lsurname.setBounds(46, 111, 111, 14);
		frame.getContentPane().add(lsurname);
		
		tsurname = new JTextField();
		tsurname.setBounds(46, 136, 111, 20);
		frame.getContentPane().add(tsurname);
		tsurname.setColumns(10);
		
		JLabel lgender = new JLabel("Gender");
		lgender.setBounds(45, 222, 111, 14);
		frame.getContentPane().add(lgender);
		
		JRadioButton radioMale = new JRadioButton("Male");
		radioMale.setBounds(45, 243, 111, 23);
		frame.getContentPane().add(radioMale);
		
		JRadioButton radioFemale = new JRadioButton("Female");
		radioFemale.setBounds(173, 243, 111, 23);
		frame.getContentPane().add(radioFemale);
		
		JLabel lnacionality = new JLabel("Nacionality:");
		lnacionality.setBounds(45, 283, 111, 14);
		frame.getContentPane().add(lnacionality);
		
		JComboBox comboNationality = new JComboBox();
		comboNationality.setBounds(45, 308, 111, 22);
		frame.getContentPane().add(comboNationality);
		
		JLabel lnumberArr = new JLabel("Number of arrest: ");
		lnumberArr.setBounds(316, 60, 168, 14);
		frame.getContentPane().add(lnumberArr);
		
		JSpinner spinNumberArr = new JSpinner();
		spinNumberArr.setBounds(316, 85, 111, 20);
		frame.getContentPane().add(spinNumberArr);
		
		JLabel ldescription = new JLabel("Description:");
		ldescription.setBounds(45, 351, 98, 14);
		frame.getContentPane().add(ldescription);
		
		tdescription = new JTextField();
		tdescription.setBounds(45, 376, 109, 20);
		frame.getContentPane().add(tdescription);
		tdescription.setColumns(10);
		
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
		
		JLabel lreleased = new JLabel("Jail Release:");
		lreleased.setBounds(316, 116, 184, 14);
		frame.getContentPane().add(lreleased);
		
		treleased = new JTextField();
		treleased.setBounds(316, 136, 111, 20);
		frame.getContentPane().add(treleased);
		treleased.setColumns(10);
		
		JLabel lblNewLabel_7_1 = new JLabel("If is fined, fill this section:");
		lblNewLabel_7_1.setForeground(Color.RED);
		lblNewLabel_7_1.setBounds(316, 171, 359, 14);
		frame.getContentPane().add(lblNewLabel_7_1);
		
		JLabel lpayment = new JLabel("Payment:");
		lpayment.setBounds(316, 194, 214, 14);
		frame.getContentPane().add(lpayment);
		
		JSpinner spinPayment = new JSpinner();
		spinPayment.setBounds(316, 219, 111, 20);
		frame.getContentPane().add(spinPayment);
		
		JLabel lblNewLabel_7_2 = new JLabel("Obligatory Fields:");
		lblNewLabel_7_2.setForeground(Color.RED);
		lblNewLabel_7_2.setBounds(46, 41, 359, 14);
		frame.getContentPane().add(lblNewLabel_7_2);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Database Detained");
		menuBar.add(menu);
		
		JMenuItem saveArrItem = new JMenuItem("Save Data Arrested");
		menu.add(saveArrItem);
		
		JMenuItem showArrItem = new JMenuItem("Show Data Arrested");
		menu.add(showArrItem);
		
		JMenuItem saveFinedItem = new JMenuItem("Save Data Fined");
		menu.add(saveFinedItem);
		
		JMenuItem showFinedItem = new JMenuItem("Show Data Fined");
		menu.add(showFinedItem);
		
		JMenuItem showAll = new JMenuItem("Show All");
		menu.add(showAll);
		
		bcreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] object;
				Arrested creation;

				if (arrested != null) {
					object= null;
					creation= null;
				} else {
					object = new Object[9];
					creation= new Arrested();    
				}
				
				object[0] =null;
				object[1] = tname.getText();
				object[2] = tsurname.getText();
				object[3] = spinAge.getValue();
				
				if (radioFemale.isSelected()) {
					object[4] = radioFemale.getActionCommand();
				} else if (radioMale.isSelected()){
					object[4] = radioMale.getActionCommand();
				}
				
				object[5] = spinNumberArr.getValue();
				object[6] = tdescription.getText();
				object[7] = treleased.getText();
				object[8] = comboNationality.getSelectedItem();
				
				
				creation.setName(tname.getText());
				creation.setLastName(tsurname.getText());
				creation.setAge((int) spinAge.getValue());

				if (radioFemale.isSelected()) {
					creation.setGender(radioMale.getActionCommand());
				} else if(radioMale.isSelected()) {
					creation.setGender(radioMale.getActionCommand());
				}

				creation.setNumberOfArrest((int) spinNumberArr.getValue());
				creation.setDescription(tdescription.getText());
				creation.setJailRelease(treleased.getText());
				creation.setCitizenship((Country) comboNationality.getSelectedItem());

				if (arrested == null) {
					policeS.getDetained().add(creation);
					modelDetained.addRow(object);
					System.out.println(creation.toString());
				}

	
			}
		});
		
			
		
		
		
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setTitle("POLICE MANAGEMENT");
		frame.setResizable(true);
		frame.setVisible(true);
		
		
		
		
		
	}
	

}
