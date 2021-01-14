package windows;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import classes.Boss;
import classes.PoliceStation;
import classes.Specialty;
import classes.Specialty.SpecialtyEnum;
import classes.Workers;
import classes.Workers2;
import databases.BDWorkers;
import windows.WindowWorkers.MiModelo;

public class WindowWorkers {

	PoliceStation policeS;
	Workers2 workers2;
	Boss boss;
	Workers workers;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextArea textArea_5;
	private JSpinner spinner;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton;
	private JComboBox<SpecialtyEnum> comboBox;
	private ButtonGroup group;
	private JTable table;
	private MiModelo modelWorkers;
	BDWorkers conexion;

	public class MiModelo extends DefaultTableModel {
		public boolean isCellEditable(int row, int column) {
			// Aqu� devolvemos true o false seg�n queramos que una celda
			// identificada por fila,columna (row,column), sea o no editable

			return false;
		}

	}

	public void agregar() {
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
				object[6] = textField_4.getText().toString();
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

				creation.setSpecialty((SpecialtyEnum) comboBox.getSelectedItem());
				creation.setStartWorkingIn((String) textField_4.getText());
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
				object[6] = textField_4.getText().toString();
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

				creationB.setSpecialty((SpecialtyEnum) comboBox.getSelectedItem());
				creationB.setStartWorkingIn((String) textField_4.getText());
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

	public void llenar_tablaWorkers() {

		conexion = new BDWorkers();
		workers2 = new Workers2();
		boss = new Boss();
		ArrayList<Workers2> list = conexion.consultarDatos();

		if (list.size() > 0) {

			for (int i = 0; i < list.size(); i++) {
				Object fila[] = new Object[8];
				workers2 = list.get(i);
				fila[0] = workers2.getCode();
				fila[1] = workers2.getGrade();
				fila[2] = workers2.getName();
				fila[3] = workers2.getSurname();
				fila[4] = workers2.getGender();
				fila[5] = workers2.getSpecialty();
				fila[6] = workers2.getStartWorkingIn();
				fila[7] = workers2.getAssesment();
				modelWorkers.addRow(fila);
			}
		}
		table.setModel(modelWorkers);
	}

	public void llenar_tablaBoss() {

		conexion = new BDWorkers();
		workers2 = new Workers2();
		boss = new Boss();
		ArrayList<Boss> listBoss = conexion.consultarDatosBoss();

		if (listBoss.size() > 0) {

			for (int i = 0; i < listBoss.size(); i++) {
				Object filaB[] = new Object[9];
				boss = listBoss.get(i);
				filaB[0] = boss.getCode();
				filaB[1] = boss.getGrade();
				filaB[2] = boss.getName();
				filaB[3] = boss.getSurname();
				filaB[4] = boss.getGender();
				filaB[5] = boss.getSpecialty();
				filaB[6] = boss.getStartWorkingIn();
				filaB[7] = boss.getAssesment();
				modelWorkers.addRow(filaB);
			}
		}
		table.setModel(modelWorkers);

	}

	public void update_workers() {
		conexion = new BDWorkers();
		Workers2 workers = new Workers2();

		workers.setGrade((int) spinner.getValue());
		workers.setName(textField.getText());
		workers.setSurname(textField_1.getText());

		if (rdbtnNewRadioButton_1.isSelected()) {
			workers.setGender(rdbtnNewRadioButton_1.getActionCommand());
		} else if (rdbtnNewRadioButton.isSelected()) {
			workers.setGender(rdbtnNewRadioButton.getActionCommand());
		}

		workers.setSpecialty((SpecialtyEnum) comboBox.getSelectedItem());
		workers.setStartWorkingIn(textField_4.getText());
		workers.setAssesment(textField_2.getText());
		workers.setCode(Integer.parseInt(textArea_5.getText()));

		conexion.update(workers);
	}

	public void update_boss() {
		Boss boss = new Boss();

		boss.setGrade((int) spinner.getValue());
		boss.setName(textField.getText());
		boss.setSurname(textField_1.getText());

		if (rdbtnNewRadioButton_1.isSelected()) {
			boss.setGender(rdbtnNewRadioButton_1.getActionCommand());
		} else if (rdbtnNewRadioButton.isSelected()) {
			boss.setGender(rdbtnNewRadioButton.getActionCommand());
		}

		boss.setSpecialty((SpecialtyEnum) comboBox.getSelectedItem());
		boss.setStartWorkingIn(textField_4.getText());
		boss.setAssesment(textField_2.getText());
		boss.setFunction(textField_3.getText());
		boss.setCode(Integer.parseInt(textArea_5.getText()));

		conexion.updateBoss(boss);
	}

	public void delete_workers() {
		Workers2 workers2 = new Workers2();
		workers2.setCode(Integer.parseInt(textArea_5.getText()));
		conexion.delete(workers2);
	}

	public void delete_boss() {
		Boss boss = new Boss();
		boss.setCode(Integer.parseInt(textArea_5.getText()));
		conexion.deleteBoss(boss);
	}

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

		spinner = new JSpinner(new SpinnerNumberModel(0, 0, 5, 1));
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

		group = new ButtonGroup();

		rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(45, 243, 111, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBounds(173, 243, 111, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);

		JLabel lblNewLabel_4 = new JLabel("Specialty:");
		lblNewLabel_4.setBounds(45, 283, 111, 14);
		frame.getContentPane().add(lblNewLabel_4);

		comboBox = new JComboBox<SpecialtyEnum>();
		comboBox.addItem(SpecialtyEnum.DRIVER);
		comboBox.addItem(SpecialtyEnum.DOCTOR);
		comboBox.addItem(SpecialtyEnum.SECURITY);
		comboBox.setBounds(45, 308, 111, 22);
		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel_5 = new JLabel("Start Working in: ");
		lblNewLabel_5.setBounds(45, 355, 144, 14);
		frame.getContentPane().add(lblNewLabel_5);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String fechaComoCadena = sdf.format(new Date());
		textField_4 = new JTextField(fechaComoCadena);
		textField_4.setBounds(45, 380, 111, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Assessment:");
		lblNewLabel_6.setBounds(45, 424, 98, 14);
		frame.getContentPane().add(lblNewLabel_6);

		textField_2 = new JTextField();
		textField_2.setBounds(45, 449, 109, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("CODE:");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBounds(45, 491, 78, 14);
		frame.getContentPane().add(lblNewLabel_9);

		textArea_5 = new JTextArea();
		textArea_5.setEditable(false);
		textArea_5.setBounds(45, 516, 86, 20);
		frame.getContentPane().add(textArea_5);
		textArea_5.setColumns(10);

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

		modelWorkers = new MiModelo();
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

					textArea_5.setText(table.getValueAt(fila, 0).toString());
					spinner.setValue(table.getValueAt(fila, 1));
					textField.setText(table.getValueAt(fila, 2).toString());
					textField_1.setText(table.getValueAt(fila, 3).toString());

					String texto = table.getValueAt(fila, 4).toString();

					if (texto.equals("Male")) {
						rdbtnNewRadioButton.setSelected(true);

					} else if (texto.equals("Female")) {
						rdbtnNewRadioButton_1.setSelected(true);

					}

					String textoCombo = table.getValueAt(fila, 5).toString();
					if (textoCombo.equals("DRIVER")) {
						comboBox.setSelectedIndex(0);
					} else if (textoCombo.equals("DOCTOR")) {
						comboBox.setSelectedIndex(1);
					}else if (textoCombo.equals("SECURITY")) {
						comboBox.setSelectedIndex(2);
					}

					textField_4.setText(table.getValueAt(fila, 6).toString());
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
				agregar();
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
				modelWorkers.setRowCount(0);
				llenar_tablaWorkers();
				llenar_tablaBoss();

			}
		});

		mntmNewMenuItem_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelWorkers.setRowCount(0);
				llenar_tablaWorkers();

			}
		});

		mntmNewMenuItem_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelWorkers.setRowCount(0);
				llenar_tablaBoss();

			}
		});

		mntmNewMenuItem_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelWorkers.setRowCount(0);
				llenar_tablaWorkers();
				llenar_tablaBoss();

			}
		});

		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				update_workers();
				//update_boss;
				llenar_tablaWorkers();
				//llenar_tablaboss;

			}
		});

		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				delete_workers();
				llenar_tablaWorkers();
			}
		});

		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setTitle("POLICE MANAGEMENT");
		frame.setResizable(true);
		frame.setVisible(true);

	}
}
