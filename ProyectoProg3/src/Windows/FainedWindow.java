package Windows;

import java.awt.GridLayout;

import javax.swing.*;
import Classes.Country;

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

	public FainedWindow() {

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