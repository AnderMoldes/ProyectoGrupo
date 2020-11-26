package windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import classes.Arrested;
import classes.Country;
import classes.Fined;
import classes.PoliceStation;

public class FainedWindow extends JFrame {
	JLabel lName;
	JTextField tName;
	JLabel lLastName;
	JTextField tLastName;
	JLabel lage;
	JSpinner age;
	JLabel lGender;
	JRadioButton radioMale;
	JRadioButton radioFamale;
	JLabel lNID;
	JSpinner tNID;
	JLabel lCountry;
	JComboBox<Country> comboCountry;
	JLabel ldescription;
	JTextField tdescription;
	JLabel lpayment;
	JSpinner spinPayment;
	JLabel Empty;
	JButton create;
	JButton cancel;
	JPanel leftPanel;
	JPanel rightPanel;

	ButtonGroup group = new ButtonGroup();

	public FainedWindow(Fined fined, PoliceStation policeStation, DefaultListModel model) {
		setLayout(new GridLayout(1, 2));
		rightPanel = new JPanel();
		leftPanel = new JPanel();
		
		rightPanel.setLayout(new GridLayout(8, 1));
		leftPanel.setLayout(new GridLayout(9, 1));

		
		create= new JButton("Create");
		cancel= new JButton("Cancel");
		lName = new JLabel("Name: ");
		tName = new JTextField(20);
		lLastName = new JLabel("Last Name: ");
		tLastName = new JTextField(20);
		lage = new JLabel("Age: ");
		age = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		lGender = new JLabel("Gender: ");
		radioMale = new JRadioButton("Male");
		radioFamale = new JRadioButton("Famale");
		lNID = new JLabel("ID/INID: ");
		tNID = new JSpinner(new SpinnerNumberModel(0, 0, 100000, 1));
		lCountry = new JLabel("Nationality: ");
		comboCountry = new JComboBox<Country>();
		for (int i = 0; i < Country.values().length; i++) {
			comboCountry.addItem(Country.values()[i]);
		}
		ldescription = new JLabel("Description: ");
		tdescription = new JTextField(8000);
		lpayment = new JLabel("Payment: ");
		spinPayment = new JSpinner(new SpinnerNumberModel(0, 0, 100000, 1));
		Empty = new JLabel();

		group.add(radioMale);
		group.add(radioFamale);
		if (fined == null) {
			create = new JButton("Create");

		} else {

			create = new JButton("Save data");
			tName.setText(fined.getName());
			tLastName.setText(fined.getLastName());
			age.setValue(fined.getAge());
			
			if (radioFamale.isSelected()) {
				radioFamale.setActionCommand(fined.getGender());
			} else {
				radioMale.setActionCommand(fined.getGender());
			}
			tNID.setValue(fined.getNumber());
			comboCountry.setSelectedItem(fined.getCitizenship());
			tdescription.setText(fined.getDescription());
			spinPayment.setValue(fined.getPayment());
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
				Fined creation;

				if (fined != null) {
					creation = fined;
				} else {
					creation = new Fined();
				}
				creation.setName(tName.getText());
				creation.setLastName(tLastName.getText());
				creation.setAge((int) age.getValue());
				creation.setNumber((int) tNID.getValue());

				if (radioFamale.isSelected()) {
					creation.setGender(radioFamale.getActionCommand());
				} else {
					creation.setGender(radioMale.getActionCommand());
				}

				creation.setCitizenship((Country) comboCountry.getSelectedItem());
				creation.setDescription(tdescription.getText());
				creation.setPayment((int)spinPayment.getValue());

				if (fined == null) {
					policeStation.getDetained().add(creation);
					model.addElement(creation);
				}

				dispose();
			}
		});
		rightPanel.add(lName);
		rightPanel.add(lLastName);
		rightPanel.add(lGender);
		rightPanel.add(lNID);
		rightPanel.add(lCountry);
		rightPanel.add(ldescription);
		rightPanel.add(lpayment);
		rightPanel.add(create);
		
		leftPanel.add(tName);
		leftPanel.add(tLastName);
		leftPanel.add(radioMale);
		leftPanel.add(radioFamale);
		leftPanel.add(tNID);
		leftPanel.add(comboCountry);
		leftPanel.add(tdescription);
		leftPanel.add(spinPayment);
		leftPanel.add(cancel);
		
		add(rightPanel);
		add(leftPanel);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Create new detained");
		setSize(800, 250);
		setVisible(true);
	}

}