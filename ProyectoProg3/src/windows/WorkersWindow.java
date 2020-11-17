package windows;

import javax.swing.*;

import classes.PoliceStation;
import classes.Specialty;
import classes.Workers;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;



public class WorkersWindow extends JFrame{
	
	
	JLabel lgrade;
	JTextField tgrade;
	JLabel lname;
	JLabel lsurname;
	JLabel lgender;
	JLabel lspecialty;
	JLabel lworkingYears;
	JLabel lassessment;
	JTextField tname;
	JTextField tsurname;
	JTextField tgender;
	JComboBox comboSpecialty;
	JSpinner spinYears;
	JTextField tassesstment;
	JButton create;
	JButton cancel;
	
	
	public WorkersWindow (PoliceStation policeStation, Workers workers, DefaultListModel model) {
		setLayout(new GridLayout(8,2));
		lgrade = new JLabel("Grade: ");
		lname = new JLabel("Name: ");
		lsurname = new JLabel("Surname: ");
		lgender = new JLabel("Gender: ");
		lspecialty = new JLabel("Specialty: ");
		lworkingYears = new JLabel("Start Working in: ");
		lassessment = new JLabel("Assessment: ");
		
		tname = new JTextField(30);
		tsurname = new JTextField(20);
		tgender = new JTextField(15);
		comboSpecialty = new JComboBox();
		comboSpecialty.addItem(Specialty.DRIVER);
		comboSpecialty.addItem(Specialty.DOCTOR);
		
		
		spinYears = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
		spinYears.setEditor(new JSpinner.DateEditor(spinYears,"dd/MM/yyyy"));
		
		tassesstment = new JTextField(100);
		tgrade = new JTextField(1);
		
		create = new JButton("Create");
		cancel = new JButton("Cancel");
		
		
		if (workers != null) {
			create.setText("Store");
			tgrade.setText(String.valueOf(workers.getGrade()));
			tname.setText(workers.getName());
			tsurname.setText(workers.getSurname());
			tgender.setText(workers.getGender());
			tassesstment.setText(String.valueOf(workers.getAssesment()));
			spinYears.setValue(workers.getStartWorkingIn());
			comboSpecialty.setSelectedItem(workers.getSpecialty());
		}
		
		
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Workers creation;
				
				if (workers != null) {
					creation = workers;
				} else {
					creation = new Workers();
				}
				creation.setGrade(Integer.valueOf(tgrade.getText()));
				creation.setName(tname.getText());
				creation.setSurname(tsurname.getText());
				creation.setGender(tgender.getText());
				creation.setAssesment(tassesstment.getText());
				creation.setStartWorkingIn((Date)spinYears.getValue());
				creation.setSpecialty((Specialty) comboSpecialty.getSelectedItem());
				
				if (workers == null) {
					policeStation.getWorkers().add(creation);
					model.addElement(creation);
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
		add(create);
		add(cancel);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Create a worker");
		setSize(500,500);
		setResizable(false);
		setVisible(true);
	}

}
