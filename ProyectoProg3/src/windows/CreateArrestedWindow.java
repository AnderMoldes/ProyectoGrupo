package windows;

import java.awt.*;


import javax.swing.*;

import java.awt.event.*;

import classes.Arrested;
import classes.Country;
import classes.Detained;
import classes.PoliceStation;


public class CreateArrestedWindow extends JFrame {
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
	JPanel panelIzquierda;
	JPanel panelDerecha;

	ButtonGroup group = new ButtonGroup();

	public CreateArrestedWindow(Arrested arrested, Detained detained, DefaultListModel model) {

		setLayout(new GridLayout(1, 2));

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

		// Hacer todo en un for
		comboCountry.addItem(Country.Austria);
		comboCountry.addItem(Country.Belgium);
		comboCountry.addItem(Country.Bulgaria);
		comboCountry.addItem(Country.Croatia);
		comboCountry.addItem(Country.Cyprus);
		comboCountry.addItem(Country.Czechia);
		comboCountry.addItem(Country.Denmark);
		comboCountry.addItem(Country.England);
		comboCountry.addItem(Country.Estonia);
		comboCountry.addItem(Country.Finland);
		comboCountry.addItem(Country.France);
		comboCountry.addItem(Country.Germany);
		comboCountry.addItem(Country.Greece);
		comboCountry.addItem(Country.Hungary);
		comboCountry.addItem(Country.Ireland);
		comboCountry.addItem(Country.Italy);
		comboCountry.addItem(Country.Latvia);
		comboCountry.addItem(Country.Lithuania);
		comboCountry.addItem(Country.Luxembourg);
		comboCountry.addItem(Country.Malta);
		comboCountry.addItem(Country.Netherlands);
		comboCountry.addItem(Country.Poland);
		comboCountry.addItem(Country.Portugal);
		comboCountry.addItem(Country.Romania);
		comboCountry.addItem(Country.Slovakia);
		comboCountry.addItem(Country.Slovenia);
		comboCountry.addItem(Country.Spain);
		comboCountry.addItem(Country.Sweden);

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
					PoliceStation.getDetained().add(creation);
					model.addElement(creation);
				}

				dispose();
			}
		});
		

		panelDerecha.setLayout(new GridLayout(8, 1));
		panelDerecha.add(lName);
		panelDerecha.add(lLastName);
		panelDerecha.add(lGender);
		panelDerecha.add(numberOfArrest);
		panelDerecha.add(lCountry);
		panelDerecha.add(ldescription);
		panelDerecha.add(ljailrelease);
		panelDerecha.add(create);

		panelIzquierda.setLayout(new GridLayout(9, 1));
		panelIzquierda.add(tName);
		panelIzquierda.add(tLastName);
		panelIzquierda.add(radioFamale);
		panelIzquierda.add(radioMale);
		panelIzquierda.add(pnumberOfArrest);
		panelIzquierda.add(comboCountry);
		panelIzquierda.add(tdescription);
		panelIzquierda.add(tjailrelease);
		panelIzquierda.add(cancel);

		add(panelDerecha);
		add(panelIzquierda);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Create new detained");
		pack();
		setVisible(true);
	}

}
