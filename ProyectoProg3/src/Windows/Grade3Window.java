package Windows;

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
import Classes.Grade_3;
import Classes.Police_Station;
import Classes.Specialty;
import Classes.Workers;

public class Grade3Window extends JFrame{
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
	
	
	public Grade3Window (Police_Station policeStation, Grade_3 grade3, DefaultListModel model) {
		setLayout(new GridLayout(7,2));
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
		
		
		spinYears = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
		spinYears.setEditor(new JSpinner.DateEditor(spinYears,"dd/MM/yyyy"));
		
		tassesstment = new JTextField(100);
		
		create = new JButton("Create");
		cancel = new JButton("Cancel");
		
		if (grade3 != null) {
			create.setText("Store");
			tname.setText(grade3.getName());
			tsurname.setText(grade3.getSurname());
			tgender.setText(grade3.getGender());
			//tassesstment.setText(grade1.getAssessment());
			spinYears.setValue(grade3.getWorkingYears());
			comboSpecialty.setSelectedItem(grade3.getSpecialty());
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
				Grade_3 New;
				
				if (grade3 != null) {
					New = grade3;
				} else {
					New = new Grade_3();
				}
				
				New.setName(tname.getText());
				New.setSurname(tsurname.getText());
				New.setGender(tgender.getText());
				//New.setAssessment(tassessment.getText());
				New.setWorkingYears((Date) spinYears.getValue());
				New.setSpecialty((Specialty) comboSpecialty.getSelectedItem());
				
				if (grade3 == null) {
					policeStation.getWorkers().add(New);
					//model.addElement(New);
				}
				
				dispose();
			}
		});
		
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
