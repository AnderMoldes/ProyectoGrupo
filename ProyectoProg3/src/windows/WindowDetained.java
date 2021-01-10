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
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import classes.Arrested;
import classes.Boss;
import classes.Country;
import classes.Detained;
import classes.Fined;
import classes.PoliceStation;
import classes.Workers;
import classes.Workers2;
import databases.BDWorkers;
import databases.BDetained;

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

	
	public WindowDetained(Detained detained, PoliceStation policeStation, DefaultTableModel model) {
		policeS = new PoliceStation();
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(100, 100, 911, 697);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton bcreate = new JButton("Create");
		bcreate.setBounds(739, 50, 111, 23);
		frame.getContentPane().add(bcreate);
		
		JButton bupdate = new JButton("Update");
		bupdate.setBounds(739, 90, 111, 23);
		frame.getContentPane().add(bupdate);
		
		JButton bdelete = new JButton("Delete");
		bdelete.setBounds(739, 130, 111, 23);
		frame.getContentPane().add(bdelete);
		
		JButton bsave = new JButton("Save");
		bsave.setBounds(739, 170, 111, 23);
		frame.getContentPane().add(bsave);
		
		JButton bback = new JButton("Back");
		bback.setBounds(45, 533, 89, 23);
		frame.getContentPane().add(bback);
		
		JButton bshow = new JButton("Show");
		bshow.setBounds(739, 210, 111, 23);
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
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedColumn() != -1) {
					int fila = table.getSelectedRow();

					spinAge.setValue(table.getValueAt(fila, 1));
					tname.setText(table.getValueAt(fila, 2).toString());
					tsurname.setText(table.getValueAt(fila, 3).toString());
					
					if (table.getValueAt(fila, 4).equals("Male")) {
						radioMale.setSelected(true);
						radioFemale.setSelected(false);
					} else {
						radioFemale.setSelected(true);
						radioMale.setSelected(false);
					}

					//comboBox.setSelectedItem(table.getValueAt(fila, 5));
//					spinner_1.setValue(table.getValueAt(fila, 6));
					//textField_2.setText(table.getValueAt(fila, 7).toString());
					
					
//					if (table.getValueAt(fila, 8).equals("")) {
//						textField_3.setText("");
//					}else {
//						textField_3.setText(table.getValueAt(fila, 8).toString());
//					}
					
				}

			}
		});
		
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
				Fined creation2;

				if (detained != null) {
					object= null;
					creation= null;
					creation2= null;
				} else {
					object = new Object[9];
					creation= new Arrested();    
					creation2= new Fined();  
				}
				if(spinPayment.getValue().equals(null)) {
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

					if (detained == null) {
						policeS.getDetained().add(creation);
						modelDetained.addRow(object);
						System.out.println(creation.toString());
					}
					tname.setText("");
					tsurname.setText("");
					spinAge.setValue(0);
				
					spinNumberArr.setValue(0);
					tdescription.setText("");
					treleased.setText("");
					spinPayment.setValue(0);
				}else {
					object[0] =null;
					object[1] = tname.getText();
					object[2] = tsurname.getText();
					object[3] = spinAge.getValue();
				
								
					if (radioFemale.isSelected()) {
						object[4] = radioFemale.getActionCommand();
					} else if (radioMale.isSelected()){
						object[4] = radioMale.getActionCommand();
					}
					object[5] = tdescription.getText();
					object[6] = comboNationality.getSelectedItem();
					object[7] = spinPayment.getValue();
					
					creation2.setName(tname.getText());
					creation2.setLastName(tsurname.getText());
					creation2.setAge((int) spinAge.getValue());

					if (radioFemale.isSelected()) {
						creation2.setGender(radioMale.getActionCommand());
					} else if(radioMale.isSelected()) {
						creation2.setGender(radioMale.getActionCommand());
					}

					creation2.setDescription(tdescription.getText());
					creation2.setCitizenship((Country) comboNationality.getSelectedItem());
					creation2.setPayment((int) spinPayment.getValue());
					
					if (detained == null) {
						policeS.getDetained().add(creation2);
						modelDetained.addRow(object);
						System.out.println(creation2.toString());
					}
					tname.setText("");
					tsurname.setText("");
					spinAge.setValue(0);
				
					spinNumberArr.setValue(0);
					tdescription.setText("");
					treleased.setText("");
					spinPayment.setValue(0);
	
				} 
			
				}
			});
		bsave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Detained detained : policeS.getDetained()) {
					if (detained instanceof Arrested) {
						BDetained.insertIntoPrepStat((Arrested) detained);
					}
				}

				for (Detained fined : policeS.getDetained()) {
					if (fined instanceof Fined) {
						BDetained.insertIntoPrepStatFained((Fined) fined);
					}
				}

			}
		});

		saveArrItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Detained arrested : policeS.getDetained()) {
					if (arrested instanceof Detained) {
						BDetained.insertIntoPrepStat((Arrested) arrested);
					}
				}
			}
		});

		saveFinedItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Detained fined : policeS.getDetained()) {
					if (fined instanceof Fined) {
						BDetained.insertIntoPrepStatFained((Fined) fined);
					}
				}

			}
		});

		bshow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Object[]> datos = new ArrayList<Object[]>();
					datos = BDetained.consultarDatosArrested("DetainedTable");

					for (int i = 0; i < datos.size(); i++) {
						modelDetained.addRow(datos.get(i));
					}
					table.setModel(modelDetained);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					ArrayList<Object[]> datosFined = new ArrayList<Object[]>();
					datosFined = BDetained.consultarDatosFained("FainedTable");

					for (int i = 0; i < datosFined.size(); i++) {
						modelDetained.addRow(datosFined.get(i));
					}
					table.setModel(modelDetained);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		showArrItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Object[]> datos = new ArrayList<Object[]>();
					datos = BDetained.consultarDatosArrested("DetainedTable");

					for (int i = 0; i < datos.size(); i++) {
						modelDetained.addRow(datos.get(i));
					}
					table.setModel(modelDetained);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		showFinedItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Object[]> datosFined = new ArrayList<Object[]>();
					datosFined = BDetained.consultarDatosFained("FainedTable");

					for (int i = 0; i < datosFined.size(); i++) {
						modelDetained.addRow(datosFined.get(i));
					}
					table.setModel(modelDetained);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		showAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Object[]> datos = new ArrayList<Object[]>();
					datos = BDetained.consultarDatosArrested("DetainedTable");

					for (int i = 0; i < datos.size(); i++) {
						modelDetained.addRow(datos.get(i));
					}
					table.setModel(modelDetained);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					ArrayList<Object[]> datosFined = new ArrayList<Object[]>();
					datosFined = BDetained.consultarDatosFained("FainedTable");

					for (int i = 0; i < datosFined.size(); i++) {
						modelDetained.addRow(datosFined.get(i));
					}
					table.setModel(modelDetained);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		bupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Detained arrested : policeStation.getDetained()) {
					if (arrested instanceof Arrested) {
						BDetained.update((Arrested) arrested);
					}
				}
				
				for (Detained fined : policeStation.getDetained()) {
					if (fined instanceof Fined) {
						BDetained.updateFined((Fined) fined);
					}
				}
			}
		});

		showFinedItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		bback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new GeneralWindow();
				
			}
		});

		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setTitle("POLICE MANAGEMENT");
		frame.setResizable(true);
		frame.setVisible(true);
				
		
		
	}
	

}
