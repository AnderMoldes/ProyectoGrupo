package windows;

import java.awt.GridLayout;

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
	JLabel lGender;
	JRadioButton radioMale;
	JRadioButton radioFamale;
	JLabel lNID;
	JTextField tNID;
	JLabel lCountry;
	JComboBox<Country> comboCountry;
	JLabel lOther;
	JTextField tOther;
	JLabel Empty;

	ButtonGroup group = new ButtonGroup();

	public FainedWindow(Fined fined, PoliceStation policeStation, DefaultListModel model) {

		lName = new JLabel("Name: ");
		tName = new JTextField(20);
		lLastName = new JLabel("Last Name: ");
		tLastName = new JTextField(20);
		lGender = new JLabel("Gender: ");
		radioMale = new JRadioButton("Male");
		radioFamale = new JRadioButton("Famale");
		lNID = new JLabel("ID/INID: ");
		tNID = new JTextField(9);
		lCountry = new JLabel("Nationality: ");
		comboCountry = new JComboBox<Country>();
		for (int i = 0; i < Country.values().length; i++) {
			comboCountry.addItem(Country.values()[i]);
		}
		lOther = new JLabel("Other: ");
		tOther = new JTextField(15);
		Empty = new JLabel();

		group.add(radioMale);
		group.add(radioFamale);

		this.setLayout(new GridLayout(7, 2));
		add(lName);
		add(tName);
		add(lLastName);
		add(tLastName);
		add(lGender);
		add(radioMale);
		add(Empty);
		add(radioFamale);
		add(lNID);
		add(tNID);
		add(lCountry);
		add(comboCountry);
		add(lOther);
		add(tOther);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Create new detained");
		setSize(800, 250);
		setVisible(true);
	}

}