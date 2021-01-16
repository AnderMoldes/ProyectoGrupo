package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
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
import javax.swing.JTextArea;

public class WindowDetained {
	PoliceStation policeS;
	Detained detained;
	Arrested arrested;
	Fined fined;
	private JFrame frame;
	private JTextField tname;
	private JTextField tsurname;
	private JTextField tdescription;
	private JTextArea textArea_5;
	private JTable table;
	private JTextField treleased;
	private JRadioButton radioMale;
	private JSpinner spinAge;
	private JSpinner spinPayment;
	private JRadioButton radioFemale;
	private ButtonGroup group;
	private JComboBox<Country> comboNationality;
	private MiModelo modelDetained;
	private JScrollPane scrollDetained;
	private JSpinner spinNumberArr;
	private int clic_tabla = 0;
	BDetained conexion;

	public class MiModelo extends DefaultTableModel {
		public boolean isCellEditable(int row, int column) {
			// Aqu� devolvemos true o false seg�n queramos que una celda
			// identificada por fila,columna (row,column), sea o no editable

			if (column == 0) {
				return false;
			}
			return true;
		}

	}

	public void agregar() {
		Object[] object;
		Arrested creation;
		Fined creation2;

		if (detained != null) {
			object = null;
			creation = null;
			creation2 = null;
		} else {
			object = new Object[10];
			creation = new Arrested();
			creation2 = new Fined();
		}

		if (radioFemale.isSelected() || radioMale.isSelected()) {

			if (spinPayment.getValue().equals(0)) {
				object[0] = null;
				object[1] = tname.getText();
				object[2] = tsurname.getText();
				object[3] = spinAge.getValue();

				if (radioFemale.isSelected()) {
					object[4] = radioFemale.getActionCommand();
				} else if (radioMale.isSelected()) {
					object[4] = radioMale.getActionCommand();
				}

				object[5] = spinNumberArr.getValue();
				object[6] = tdescription.getText();
				object[7] = treleased.getText();
				object[8] = comboNationality.getSelectedItem();
				object[9] = null;

				creation.setName(tname.getText());
				creation.setLastName(tsurname.getText());
				creation.setAge((int) spinAge.getValue());

				if (radioFemale.isSelected()) {
					creation.setGender(radioMale.getActionCommand());
				} else if (radioMale.isSelected()) {
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
				spinAge.setValue(16);
				group.clearSelection();
				spinNumberArr.setValue(0);
				tdescription.setText("");
				treleased.setText("");
				comboNationality.setSelectedIndex(0);
				spinPayment.setValue(0);

			} else if (spinNumberArr.getValue().equals(0) && treleased.getText().equals("")) {

				object[0] = null;
				object[1] = tname.getText();
				object[2] = tsurname.getText();
				object[3] = spinAge.getValue();

				if (radioFemale.isSelected()) {
					object[4] = radioFemale.getActionCommand();
				} else if (radioMale.isSelected()) {
					object[4] = radioMale.getActionCommand();
				}
				object[5] = null;
				object[6] = tdescription.getText();
				object[7] = null;
				object[8] = comboNationality.getSelectedItem();
				object[9] = spinPayment.getValue();

				creation2.setName(tname.getText());
				creation2.setLastName(tsurname.getText());
				creation2.setAge((int) spinAge.getValue());

				if (radioFemale.isSelected()) {
					creation2.setGender(radioMale.getActionCommand());
				} else if (radioMale.isSelected()) {
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
				spinAge.setValue(16);
				group.clearSelection();
				tdescription.setText("");
				comboNationality.setSelectedIndex(0);
				spinPayment.setValue(0);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Gender required field");
		}
	}

	public void llenar_tablaArrested(JTable table) {
		conexion = new BDetained();
		arrested = new Arrested();
		ArrayList<Arrested> list = conexion.consultarDatosArrested();

		if (list.size() > 0) {

			for (int i = 0; i < list.size(); i++) {
				Object filaB[] = new Object[9];
				arrested = list.get(i);
				filaB[0] = arrested.getIdentificative();
				filaB[1] = arrested.getName();
				filaB[2] = arrested.getLastName();
				filaB[3] = arrested.getAge();
				filaB[4] = arrested.getGender();
				filaB[5] = arrested.getNumberOfArrest();
				filaB[6] = arrested.getDescription();
				filaB[7] = arrested.getJailRelease();
				filaB[8] = arrested.getCitizenship();
				modelDetained.addRow(filaB);
			}
		}
		table.setModel(modelDetained);

	}

	public void llenar_tablaFined(JTable table) {
		conexion = new BDetained();
		fined = new Fined();
		ArrayList<Fined> list = conexion.consultarDatosFained();

		if (list.size() > 0) {

			for (int i = 0; i < list.size(); i++) {
				Object fila[] = new Object[10];
				fined = list.get(i);
				fila[0] = fined.getIdentificative();
				fila[1] = fined.getName();
				fila[2] = fined.getLastName();
				fila[3] = fined.getAge();
				fila[4] = fined.getGender();
				fila[5] = null;
				fila[6] = fined.getDescription();
				fila[7] = null;
				fila[8] = fined.getCitizenship();
				fila[9] = fined.getPayment();
				modelDetained.addRow(fila);
			}
		}
		table.setModel(modelDetained);

	}

	public void update_detained() {
		table.getModel().addTableModelListener((TableModelEvent e) -> {

			if (e.getType() == TableModelEvent.UPDATE) {

				int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?", "data update",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (input == 0) {

					try {
						int fila = e.getFirstRow();

						if (table.getValueAt(fila, 9) == null) {
							int identificative = (int) table.getValueAt(table.getSelectedRow(), 0);

							String name = table.getValueAt(fila, 1).toString();
							String lastName = "" + table.getValueAt(fila, 2);
							String age = ""+ table.getValueAt(fila, 3);
							String gender = "" + table.getValueAt(fila, 4);
							String numberofarrest = ""+ table.getValueAt(fila, 5);
							String description = "" + table.getValueAt(fila, 6);
							String jailrelease = "" + table.getValueAt(fila, 7);
							String city = "" + table.getValueAt(fila, 8);

							String sql = "UPDATE DetainedTable SET name=?, lastName=?, age=?, gender=?, numberOfArrest=?, description=?, jailRelease=?, cityzenship=? where ID=?;";
							PreparedStatement stmt = conexion.getConection().prepareStatement(sql);

							stmt.setString(1, name);
							stmt.setString(2, lastName);
							stmt.setString(3, age);
							stmt.setString(4, gender);
							stmt.setString(5, numberofarrest);
							stmt.setString(6, description);
							stmt.setString(7, jailrelease);
							stmt.setString(8, city);
							stmt.setInt(9, identificative);

							stmt.executeUpdate();
							JOptionPane.showMessageDialog(null, "  UPDATE ARRESTED COMPLETED ");

						} else if (table.getValueAt(fila, 5) == null && table.getValueAt(fila, 7) == null) {

							int identificative = (int) table.getValueAt(table.getSelectedRow(), 0);

							String name = table.getValueAt(fila, 1).toString();
							String lastName = "" + table.getValueAt(fila, 2);
							String age = ""+ table.getValueAt(fila, 3);
							String gender = "" + table.getValueAt(fila, 4);
							String description = "" + table.getValueAt(fila, 6);
							String city = "" + table.getValueAt(fila, 8);
							String payment = ""+ table.getValueAt(fila, 9);

							String sql = "UPDATE FainedTable SET name=?, lastName=?, age=?, gender=?, description=?, cityzenship=?, payment=?  where ID=?;";
							PreparedStatement stmt = conexion.getConection().prepareStatement(sql);

							stmt.setString(1, name);
							stmt.setString(2, lastName);
							stmt.setString(3, age);
							stmt.setString(4, gender);
							stmt.setString(5, description);
							stmt.setString(6, city);
							stmt.setString(7, payment);
							stmt.setInt(8, identificative);

							stmt.executeUpdate();
							JOptionPane.showMessageDialog(null, "  UPDATE FINED COMPLETED ");
						}

					} catch (SQLException e2) {
						System.out.println("Could not update detained in database ");
					}
				}
			}
		});
	}

	public void delete_Arrested() {
		Arrested arrested = new Arrested();
		arrested.setIdentificative(Integer.parseInt(textArea_5.getText()));
		conexion.delete(arrested);
	}

	public void delete_Fined() {
		Fined fined = new Fined();
		fined.setIdentificative(Integer.parseInt(textArea_5.getText()));
		conexion.deleteFined(fined);
	}

	public void eliminar(final DefaultTableModel model) {
		clic_tabla = table.getSelectedRowCount();
		for (int i = clic_tabla; i < model.getRowCount(); i++) {
			model.getDataVector().clear();
		}

	}

	public WindowDetained(Detained detained, PoliceStation policeStation) {
		policeS = new PoliceStation();
		arrested = new Arrested();
		fined = new Fined();

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

		JButton btnNewButton_5 = new JButton(new ImageIcon(
				((new ImageIcon("descarga.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)))));
		btnNewButton_5.setBounds(860, 0, 34, 33);
		frame.getContentPane().add(btnNewButton_5);

		JButton bshow = new JButton("Show");
		bshow.setBounds(739, 210, 111, 23);
		frame.getContentPane().add(bshow);

		JLabel lage = new JLabel("Age:");
		lage.setBounds(46, 162, 129, 23);
		frame.getContentPane().add(lage);

		spinAge = new JSpinner(new SpinnerNumberModel(18, 16, 100, 1));
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

		group = new ButtonGroup();

		radioMale = new JRadioButton("Male");
		radioMale.setBounds(45, 243, 111, 23);
		frame.getContentPane().add(radioMale);

		radioFemale = new JRadioButton("Female");
		radioFemale.setBounds(173, 243, 111, 23);
		frame.getContentPane().add(radioFemale);

		group.add(radioMale);
		group.add(radioFemale);

		JLabel lnacionality = new JLabel("Nacionality:");
		lnacionality.setBounds(45, 283, 111, 14);
		frame.getContentPane().add(lnacionality);

		comboNationality = new JComboBox<Country>();
		comboNationality.setBounds(45, 308, 111, 22);
		frame.getContentPane().add(comboNationality);
		for (int i = 0; i < Country.values().length; i++) {
			comboNationality.addItem(Country.values()[i]);
		}

		JLabel lnumberArr = new JLabel("Number of arrest: ");
		lnumberArr.setBounds(316, 60, 168, 14);
		frame.getContentPane().add(lnumberArr);

		spinNumberArr = new JSpinner(new SpinnerNumberModel(0, 0, 1000000, 1));
		spinNumberArr.setBounds(316, 85, 111, 20);
		frame.getContentPane().add(spinNumberArr);

		JLabel ldescription = new JLabel("Description:");
		ldescription.setBounds(45, 351, 98, 14);
		frame.getContentPane().add(ldescription);

		tdescription = new JTextField();
		tdescription.setBounds(45, 376, 109, 20);
		frame.getContentPane().add(tdescription);
		tdescription.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("ID:");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBounds(45, 491, 78, 14);
		frame.getContentPane().add(lblNewLabel_9);

		textArea_5 = new JTextArea();
		textArea_5.setEditable(false);
		textArea_5.setBounds(45, 516, 86, 20);
		frame.getContentPane().add(textArea_5);
		textArea_5.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("If is arrested, fill this section:");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(316, 41, 359, 14);
		frame.getContentPane().add(lblNewLabel_7);

		modelDetained = new MiModelo();
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

		scrollDetained = new JScrollPane();
		scrollDetained.setViewportView(table);

		scrollDetained.setBounds(243, 311, 567, 296);

		frame.getContentPane().add(scrollDetained);

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

		spinPayment = new JSpinner(new SpinnerNumberModel(0, 0, 1000000, 50));
		spinPayment.setBounds(316, 219, 111, 20);
		frame.getContentPane().add(spinPayment);

		JLabel lblNewLabel_7_2 = new JLabel("Obligatory Fields:");
		lblNewLabel_7_2.setForeground(Color.RED);
		lblNewLabel_7_2.setBounds(46, 41, 359, 14);
		frame.getContentPane().add(lblNewLabel_7_2);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				clic_tabla = table.getSelectedRow();

				int identificative = (int) table.getValueAt(clic_tabla, 0);

				textArea_5.setText(String.valueOf(identificative));

			}
		});

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

		update_detained();

		bcreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(bcreate,
						"Are you sure you want to create? Remember that the gender field is necessary", "data creation",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (input == 0) {
					agregar();
				}

			}
		});
		bsave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int input = JOptionPane.showConfirmDialog(bsave, "Are you sure you want to save?", "Data saving",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (input == 0) {

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
				modelDetained.setRowCount(0);
				llenar_tablaArrested(table);
				llenar_tablaFined(table);
			}
		});

		showArrItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelDetained.setRowCount(0);
				llenar_tablaArrested(table);
			}
		});

		showFinedItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelDetained.setRowCount(0);
				llenar_tablaFined(table);

			}
		});

		showAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelDetained.setRowCount(0);
				llenar_tablaArrested(table);
				llenar_tablaFined(table);
			}
		});

		bupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"To update an attribute, select the row you would like to modify and make the change in"
								+ " the appropriate cell.",
						"Updated information", JOptionPane.INFORMATION_MESSAGE, null);

			}
		});

		bdelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(bdelete, "Are you sure you want to delete?", "data erasure",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (input == 0) {

					if (table.getValueAt(clic_tabla, 9) == null) {
						delete_Arrested();
					} else if (table.getValueAt(clic_tabla, 5) == null && table.getValueAt(clic_tabla, 7) == null) {
						delete_Fined();
					}
					eliminar(modelDetained);
					llenar_tablaArrested(table);
					llenar_tablaFined(table);
				}
			}
		});

		btnNewButton_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(btnNewButton_5, "Are you sure you want to go back?",
						"Go back to menu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (input == 0) {
					new GeneralWindow();
					frame.dispose();
				}
			}
		});

		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setTitle("POLICE MANAGEMENT");
		frame.setResizable(true);
		frame.setVisible(true);

	}

}
