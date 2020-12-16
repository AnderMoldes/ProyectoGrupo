package windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import classes.PoliceStation;
import classes.Specialty;
import classes.Workers;
import classes.Boss;

public class BossWindow extends JFrame{
	JLabel lfunction;
	JLabel lgrade;
	JSpinner tgrade;
	JLabel lname;
	JLabel lsurname;
	JLabel lgender;
	JLabel lspecialty;
	JLabel lworkingYears;
	JLabel lassessment;
	JTextField tname;
	JTextField tfunction;
	JTextField tsurname;
	JTextField tgender;
	JComboBox<Specialty> comboSpecialty;
	JSpinner spinYears;
	JTextField tassesstment;
	JButton create;
	JButton cancel;
	JPanel panel;

	public BossWindow(Boss boss, PoliceStation policeStation, DefaultTableModel model) {

		setLayout(new GridLayout(9,2));
		lfunction = new JLabel("This boss function is: ");
		tfunction = new JTextField(40);
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
		
		//Añadir especialidades especiales
		
		comboSpecialty = new JComboBox<Specialty>();
		comboSpecialty.addItem(Specialty.DRIVER);
		comboSpecialty.addItem(Specialty.DOCTOR);
		
		spinYears = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
		spinYears.setEditor(new JSpinner.DateEditor(spinYears, "dd/MM/yyyy"));

		create = new JButton("Create");
		cancel = new JButton("Cancel");

		if (boss == null) {
			create = new JButton("Create");

		} else {

			create = new JButton("Save data");

//			tfunction.setText(boss.getFunction());
//			tname.setText(boss.getName());
//			tsurname.setText(boss.getSurname());
//			tgender.setText(boss.getGender());
//			tassesstment.setText(String.valueOf(boss.getAssesment()));
//			spinYears.setValue(boss.getStartWorkingIn());
//			//comboSpecialty.setSelectedItem(boss.getSpecialty());
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
				Object[] object;

				if (boss != null) {
					object = null;
				} else {
					object = new Object[9];
				}

				
				object[0] = Workers.getCounter();
				object[1] = tgrade.getValue();
				object[2] = tname.getText();
				object[3] = tsurname.getText();
				object[4] = tgender.getText();
				object[5] = tassesstment.getText();
				object[6] = spinYears.getValue();
				object[7] = comboSpecialty.getSelectedItem();
				object[8] = tfunction.getText();

//				creation.setFunction(tfunction.getText());
//				creation.setName(tname.getText());
//				creation.setSurname(tsurname.getText());
//				creation.setGender(tgender.getText());
//				creation.setAssesment(tassesstment.getText());
//				creation.setStartWorkingIn((Date) spinYears.getValue());
//				//creation.setSpecialty((Specialty) comboSpecialty.getSelectedItem());

				if (boss == null) {
					//policeStation.getWorkers().add(creation);
					model.addRow(object);
				}

				dispose();
			}
		});
		add(lfunction);
		add(tfunction);
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
