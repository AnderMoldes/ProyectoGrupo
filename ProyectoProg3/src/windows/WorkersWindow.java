package windows;

import javax.swing.*;


import javax.swing.table.DefaultTableModel;

import classes.PoliceStation;
import classes.Specialty;
import classes.Specialty.SpecialtyEnum;
import classes.Workers;
import classes.Workers2;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;

public class WorkersWindow extends JFrame {

	JLabel lgrade;
	JSpinner tgrade;
	JLabel lname;
	JLabel lsurname;
	JLabel lgender;
	JLabel lspecialty;
	JLabel lworkingYears;
	JLabel lassessment;
	JTextField tname;
	JTextField tsurname;
	JTextField tgender;
	JComboBox<SpecialtyEnum> comboSpecialty;
	JSpinner spinYears;
	JTextField tassesstment;
	JButton create;
	JButton cancel;
	JPanel panel;
	
	

	public WorkersWindow(Workers2 workers, PoliceStation policeStation, DefaultTableModel modelWorkers) {

		setLayout(new GridLayout(8, 2));

		lgrade = new JLabel("Grade: ");
		tgrade = new JSpinner(new SpinnerNumberModel(0, 0, 5, 1));
		lname = new JLabel("Name: ");
		tname = new JTextField(30);
		lsurname = new JLabel("Surname: ");
		tsurname = new JTextField(20);
		lgender = new JLabel("Gender: ");
		tgender = new JTextField(15);
		lspecialty = new JLabel("Specialty: ");
		lworkingYears = new JLabel("Start Working in: ");
		lassessment = new JLabel("Assessment: ");
		tassesstment = new JTextField(100);

		comboSpecialty = new JComboBox<SpecialtyEnum>();
		comboSpecialty.addItem(SpecialtyEnum.DRIVER);
		comboSpecialty.addItem(SpecialtyEnum.DOCTOR);

		spinYears = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
		spinYears.setEditor(new JSpinner.DateEditor(spinYears, "dd/MM/yyyy"));

		create = new JButton("Create");
		cancel = new JButton("Cancel");

		if (workers == null) {
			create = new JButton("Create");

		} else {

			create = new JButton("Save data");

//			Object[] object = null;
//			object[1] = tgrade.setValue(workers.getGrade());
//			object[2] = tname.getText();
//			object[3] = tsurname.getText();
//			object[4] = tgender.getText();
//			object[5] = tassesstment.getText();
//			object[6] = spinYears.getValue();
//			object[7] = comboSpecialty.getSelectedItem();
			
		

			tgrade.setValue(workers.getGrade());
			tname.setText(workers.getName());
			tsurname.setText(workers.getSurname());
			tgender.setText(workers.getGender());
			comboSpecialty.setSelectedItem(workers.getSpecialty());
			spinYears.setValue(workers.getStartWorkingIn());
			tassesstment.setText(String.valueOf(workers.getAssesment()));
			

		}

		panel = new JPanel();
		cancel = new JButton("Cancel");
		panel.add(create);
		panel.add(cancel);
		panel.add(Box.createHorizontalGlue());

		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Workers2 creation;
				Object[] object;

				if (workers != null) {
					creation = null;
					object = null;
				} else {
					object = new Object[8];
					creation = new Workers2();
				}

				object[0] = null;
				object[1] = tgrade.getValue();
				object[2] = tname.getText();
				object[3] = tsurname.getText();
				object[4] = tgender.getText();
				object[5] = comboSpecialty.getSelectedItem();
				object[6] = spinYears.getValue();
				object[7] = tassesstment.getText();
				
				creation.setGrade((int) tgrade.getValue());
				creation.setName(tname.getText());
				creation.setSurname(tsurname.getText());
				creation.setGender(tgender.getText());
				creation.setSpecialty((SpecialtyEnum) comboSpecialty.getSelectedItem());
//				creation.setStartWorkingIn((Date) spinYears.getValue());
				creation.setAssesment(tassesstment.getText());

				if (workers == null) {
					policeStation.getWorkers().add(creation);
					modelWorkers.addRow(object);
					System.out.println(creation.toString());

				}
				dispose();

			}
		});

		add(lgrade);
		add(tgrade);
		add(lname);
		add(tname);
		add(lsurname);
		add(tsurname);
		add(lgender);
		add(tgender);
		add(lspecialty);
		add(comboSpecialty);
		add(lworkingYears);
		add(spinYears);
		add(lassessment);
		add(tassesstment);
		add(panel);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Create a worker");
		setSize(500, 500);
		setResizable(false);
		setVisible(true);

	}

}
