package windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import classes.Grade;
import classes.PoliceStation;
import classes.Specialty;
import classes.Workers;

public class Grade1Window extends JFrame{
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
	
	
	public Grade1Window (PoliceStation policeStation, Grade grade1, DefaultListModel model) {
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
		
		
		if (grade1 != null) {
			create.setText("Store");
			tgrade.setText(String.valueOf(grade1.getGrade()));
			tname.setText(grade1.getName());
			tsurname.setText(grade1.getSurname());
			tgender.setText(grade1.getGender());
			tassesstment.setText(String.valueOf(grade1.getAssessment()));
			spinYears.setValue(grade1.getWorkingYears());
			comboSpecialty.setSelectedItem(grade1.getSpecialty());
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
				Grade New;
				
				if (grade1 != null) {
					New = grade1;
				} else {
					New = new Grade();
				}
				New.setGrade(Integer.valueOf(tgrade.getText()));
				New.setName(tname.getText());
				New.setSurname(tsurname.getText());
				New.setGender(tgender.getText());
				New.setAssessment(Integer.valueOf(tassesstment.getText()));
				New.setWorkingYears((Date) spinYears.getValue());
				New.setSpecialty((Specialty) comboSpecialty.getSelectedItem());
				
				if (grade1 == null) {
					policeStation.getWorkers().add(New);
					model.addElement(New);
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
