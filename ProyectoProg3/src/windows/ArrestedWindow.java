package windows;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import classes.Arrested;
import classes.Country;
import classes.PoliceStation;

public class ArrestedWindow extends JFrame {
	JLabel lName;
	JTextField tName;
	JLabel lLastName;
	JTextField tLastName;
	JLabel lage;
	JSpinner age;
	JLabel lGender;
	JRadioButton radioMale;
	JRadioButton radioFamale;
	JLabel numberOfArrest;
	JSpinner pnumberOfArrest;
	JLabel ldescription;
	JTextField tdescription;
	JLabel lCountry;
	JComboBox<Country> comboCountry;
	JLabel ljailrelease;
	JTextField tjailrelease;
	JButton create;
	JButton cancel;
	JPanel leftPanel;
	JPanel rightPanel;

	ButtonGroup group = new ButtonGroup();

	public ArrestedWindow(Arrested arrested, PoliceStation policeStation, DefaultListModel model) {

		setLayout(new GridLayout(1, 2));
		rightPanel = new JPanel();
		leftPanel = new JPanel();
		
		rightPanel.setLayout(new GridLayout(8, 1));
		leftPanel.setLayout(new GridLayout(9, 1));

		lName = new JLabel("Name: ");
		tName = new JTextField(20);
		lLastName = new JLabel("Last Name: ");
		tLastName = new JTextField(20);
		lage = new JLabel("Age: ");
		age = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		lGender = new JLabel("Gender: ");
		radioMale = new JRadioButton("Male");
		radioFamale = new JRadioButton("Famale");
		numberOfArrest = new JLabel("Number of Arrest: ");
		pnumberOfArrest = new JSpinner(new SpinnerNumberModel(0, 0, 100000, 1));
		lCountry = new JLabel("Nationality: ");
		comboCountry = new JComboBox<Country>();
		ldescription = new JLabel("Description: ");
		tdescription = new JTextField(50);
		ljailrelease = new JLabel("Jail release: ");
		tjailrelease = new JTextField(30);

		for (int i = 0; i < Country.values().length; i++) {
			comboCountry.addItem(Country.values()[i]);
		}

		group.add(radioMale);
		group.add(radioFamale);

		if (arrested == null) {
			create = new JButton("Create");

		} else {

			create = new JButton("Save data");
			tName.setText(arrested.getName());
			tLastName.setText(arrested.getLastName());
			age.setValue(arrested.getAge());

			if (radioFamale.isSelected()) {
				radioFamale.setActionCommand(arrested.getGender());
			} else {
				radioMale.setActionCommand(arrested.getGender());
			}
			pnumberOfArrest.setValue(arrested.getNumberOfArrest());
			comboCountry.setSelectedItem(arrested.getCitizenship());
			tdescription.setText(arrested.getDescription());
			tjailrelease.setText(arrested.getJailRelease());
		}

		cancel = new JButton("Cancel");

		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Arrested creation;

				if (arrested != null) {
					creation = arrested;
				} else {
					creation = new Arrested();
				}
				creation.setName(tName.getText());
				creation.setLastName(tLastName.getText());
				creation.setAge((int) age.getValue());
				creation.setNumberOfArrest((int) pnumberOfArrest.getValue());

				if (radioFamale.isSelected()) {
					creation.setGender(radioFamale.getActionCommand());
				} else {
					creation.setGender(radioMale.getActionCommand());
				}

				creation.setCitizenship((Country) comboCountry.getSelectedItem());
				creation.setDescription(tdescription.getText());
				creation.setJailRelease(tjailrelease.getText());

				if (arrested == null) {
					policeStation.getDetained().add(creation);
					model.addElement(creation);
				}

				dispose();
			}
		});

		rightPanel.add(lName);
		rightPanel.add(lLastName);
		rightPanel.add(lGender);
		rightPanel.add(numberOfArrest);
		rightPanel.add(lCountry);
		rightPanel.add(ldescription);
		rightPanel.add(ljailrelease);
		rightPanel.add(create);

		leftPanel.add(tName);
		leftPanel.add(tLastName);
		leftPanel.add(radioFamale);
		leftPanel.add(radioMale);
		leftPanel.add(pnumberOfArrest);
		leftPanel.add(comboCountry);
		leftPanel.add(tdescription);
		leftPanel.add(tjailrelease);
		leftPanel.add(cancel);

		add(rightPanel);
		add(leftPanel);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Create new detained");
		pack();
		setVisible(true);
	}

}
