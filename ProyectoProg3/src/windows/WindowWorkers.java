package windows;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import classes.Boss;
import classes.PoliceStation;
import classes.Specialty;
import classes.Workers;
import classes.Workers2;
import databases.BDWorkers;

public class WindowWorkers {

	PoliceStation policeS;
	Workers2 workers2;
	Boss boss;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	

	public WindowWorkers(Workers workers, PoliceStation policeStation) {

		policeS = new PoliceStation();
		workers2 = new Workers2();
		boss = new Boss();

		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(100, 100, 911, 706);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBounds(739, 56, 111, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBounds(739, 107, 111, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setBounds(739, 157, 111, 23);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setBounds(739, 209, 111, 23);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Show");
		btnNewButton_4.setBounds(739, 258, 111, 23);
		frame.getContentPane().add(btnNewButton_4);

		JLabel lblNewLabel = new JLabel("Grade: ");
		lblNewLabel.setBounds(45, 56, 129, 23);
		frame.getContentPane().add(lblNewLabel);

		JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 5, 1));
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

		ButtonGroup group = new ButtonGroup();

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(45, 243, 111, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBounds(173, 243, 111, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);

		JLabel lblNewLabel_4 = new JLabel("Specialty:");
		lblNewLabel_4.setBounds(45, 283, 111, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JComboBox<Specialty> comboBox = new JComboBox<Specialty>();
		comboBox.addItem(Specialty.DRIVER);
		comboBox.addItem(Specialty.DOCTOR);
		comboBox.setBounds(45, 308, 111, 22);
		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel_5 = new JLabel("Start Working in: ");
		lblNewLabel_5.setBounds(45, 355, 144, 14);
		frame.getContentPane().add(lblNewLabel_5);

//		JSpinner spinner_1 = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.SHORT_FORMAT));
		JSpinner spinner_1 = new JSpinner((SpinnerModel) new SimpleDateFormat("dd/M/yyyy"));
//		spinner_1.setBounds(45, 380, 111, 20);
//		frame.getContentPane().add(spinner_1);

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

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedColumn() != -1) {
					int fila = table.getSelectedRow();

					spinner.setValue(table.getValueAt(fila, 1));
					textField.setText(table.getValueAt(fila, 2).toString());
					textField_1.setText(table.getValueAt(fila, 3).toString());

					String texto = table.getValueAt(fila, 4).toString();

					if (texto.equals("Male")) {
						rdbtnNewRadioButton.setSelected(true);

					} else if (texto.equals("Female")) {
						rdbtnNewRadioButton_1.setSelected(true);

					}
					
					String textoCombo= table.getValueAt(fila, 5).toString();
					if (textoCombo.equals("DRIVER")) {
						comboBox.setSelectedIndex(0);
					}else if (textoCombo.equals("DOCTOR")) {
						comboBox.setSelectedIndex(1);
					}
						
//					spinner_1.setValue( table.getValueAt(fila, 6).toString());
					textField_2.setText(table.getValueAt(fila, 7).toString());

//					textField_3.setText(table.getValueAt(fila, 8).toString());

				}

			}
		});

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

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Workers2 creation;
				Boss creationB;
				Object[] object;

				if (workers != null) {
					creation = null;
					creationB = null;
					object = null;

				} else {
					object = new Object[9];
					creation = new Workers2();
					creationB = new Boss();
				}

				if (rdbtnNewRadioButton_1.isSelected() || rdbtnNewRadioButton.isSelected()) {

					String texto = textField_3.getText();
					if ("".equals(texto)) {
						object[0] = null;
						object[1] = spinner.getValue();
						object[2] = textField.getText();
						object[3] = textField_1.getText();

						if (rdbtnNewRadioButton_1.isSelected()) {
							object[4] = rdbtnNewRadioButton_1.getActionCommand();
						} else if (rdbtnNewRadioButton.isSelected()) {
							object[4] = rdbtnNewRadioButton.getActionCommand();
						}

						object[5] = comboBox.getSelectedItem();
						object[6] = spinner_1.getValue().toString();
						object[7] = textField_2.getText();
						object[8] = null;

						creation.setGrade((int) spinner.getValue());
						creation.setName(textField.getText());
						creation.setSurname(textField_1.getText());

						if (rdbtnNewRadioButton_1.isSelected()) {
							creation.setGender(rdbtnNewRadioButton_1.getActionCommand());
						} else if (rdbtnNewRadioButton.isSelected()) {
							creation.setGender(rdbtnNewRadioButton.getActionCommand());
						}

						creation.setSpecialty((Specialty) comboBox.getSelectedItem());
						creation.setStartWorkingIn((Date) spinner_1.getValue());
						creation.setAssesment(textField_2.getText());

						if (workers == null) {
							policeS.getWorkers().add(creation);
							modelWorkers.addRow(object);
							System.out.println(creation.toString());

						}

						spinner.setValue(0);
						textField.setText("");
						textField_1.setText("");
						group.clearSelection();
						comboBox.setSelectedIndex(0);
						textField_2.setText("");

					} else {

						object[0] = null;
						object[1] = spinner.getValue();
						object[2] = textField.getText();
						object[3] = textField_1.getText();

						if (rdbtnNewRadioButton_1.isSelected()) {
							object[4] = rdbtnNewRadioButton_1.getActionCommand();
						} else if (rdbtnNewRadioButton.isSelected()) {
							object[4] = rdbtnNewRadioButton.getActionCommand();
						}

						object[5] = comboBox.getSelectedItem();
						object[6] = spinner_1.getValue();
						object[7] = textField_2.getText();
						object[8] = textField_3.getText();

						creationB.setGrade((int) spinner.getValue());
						creationB.setName(textField.getText());
						creationB.setSurname(textField_1.getText());

						if (rdbtnNewRadioButton_1.isSelected()) {
							creationB.setGender(rdbtnNewRadioButton_1.getActionCommand());
						} else if (rdbtnNewRadioButton.isSelected()) {
							creationB.setGender(rdbtnNewRadioButton.getActionCommand());
						}

						creationB.setSpecialty((Specialty) comboBox.getSelectedItem());
						creationB.setStartWorkingIn((Date) spinner_1.getValue());
						creationB.setAssesment(textField_2.getText());
						creationB.setFunction(textField_3.getText());

						if (workers == null) {
							policeS.getWorkers().add(creationB);
							modelWorkers.addRow(object);
							System.out.println(creationB.toString());

						}

						spinner.setValue(0);
						textField.setText("");
						textField_1.setText("");
						group.clearSelection();
						comboBox.setSelectedIndex(0);
						textField_2.setText("");
						textField_3.setText("");

					}
				} else {
					JOptionPane.showMessageDialog(null, "Gender required field");
				}
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Workers workers : policeS.getWorkers()) {
					if (workers instanceof Workers2) {
						BDWorkers.insertIntoPrepStat((Workers2) workers);
					}
				}

				for (Workers workers : policeS.getWorkers()) {
					if (workers instanceof Boss) {
						BDWorkers.insertIntoPrepStatBoss((Boss) workers);
					}
				}

			}
		});

		mntmNewMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Workers workers : policeS.getWorkers()) {
					if (workers instanceof Workers2) {
						BDWorkers.insertIntoPrepStat((Workers2) workers);
					}
				}
			}
		});

		mntmNewMenuItem_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Workers workers : policeS.getWorkers()) {
					if (workers instanceof Boss) {
						BDWorkers.insertIntoPrepStatBoss((Boss) workers);
					}
				}

			}
		});

		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Object[]> datos = new ArrayList<Object[]>();
					datos = BDWorkers.consultarDatos("WorkersTable");

					for (int i = 0; i < datos.size(); i++) {
						modelWorkers.addRow(datos.get(i));
					}
					table.setModel(modelWorkers);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					ArrayList<Object[]> datosBoss = new ArrayList<Object[]>();
					datosBoss = BDWorkers.consultarDatosBoss("WorkersTableBoss");

					for (int i = 0; i < datosBoss.size(); i++) {
						modelWorkers.addRow(datosBoss.get(i));
					}
					table.setModel(modelWorkers);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		mntmNewMenuItem_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Object[]> datos = new ArrayList<Object[]>();
					datos = BDWorkers.consultarDatos("WorkersTable");

					for (int i = 0; i < datos.size(); i++) {
						modelWorkers.addRow(datos.get(i));
					}
					table.setModel(modelWorkers);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		mntmNewMenuItem_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Object[]> datosBoss = new ArrayList<Object[]>();
					datosBoss = BDWorkers.consultarDatosBoss("WorkersTableBoss");

					for (int i = 0; i < datosBoss.size(); i++) {
						modelWorkers.addRow(datosBoss.get(i));
					}
					table.setModel(modelWorkers);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		mntmNewMenuItem_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Object[]> datos = new ArrayList<Object[]>();
					datos = BDWorkers.consultarDatos("WorkersTable");

					for (int i = 0; i < datos.size(); i++) {
						modelWorkers.addRow(datos.get(i));
					}
					table.setModel(modelWorkers);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					ArrayList<Object[]> datosBoss = new ArrayList<Object[]>();
					datosBoss = BDWorkers.consultarDatosBoss("WorkersTableBoss");

					for (int i = 0; i < datosBoss.size(); i++) {
						modelWorkers.addRow(datosBoss.get(i));
					}
					table.setModel(modelWorkers);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Workers workers : policeStation.getWorkers()) {
					if (workers instanceof Workers2) {
						BDWorkers.update((Workers2) workers);
					}
				}

				for (Workers workers : policeStation.getWorkers()) {
					if (workers instanceof Boss) {
						BDWorkers.updateBoss((Boss) workers);
					}
				}
			}
		});

		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setTitle("POLICE MANAGEMENT");
		frame.setResizable(true);
		frame.setVisible(true);

	}

}
