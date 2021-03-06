package windows;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import classes.Brand;
import classes.VehicleTypes;

import java.awt.event.*;
import java.net.URL;

public class PatrolCarWindow extends JFrame {

	// Declaramos
	JPanel panelPhoto;
	JPanel panelText;
	JLabel image;
	JTextArea text;
	JButton back;

	public PatrolCarWindow() {
		JPanel panelPhoto = new JPanel();
		JPanel panelText = new JPanel();
		URL iconURL = getClass().getResource("/icons/patrol.png");
		image = new JLabel(new ImageIcon(iconURL));

		JTextArea text = new JTextArea();

		JButton back = new JButton("Back");

		// Texto donde a�adimos informacion sobre el vehiculo patrulla
		text.setEditable(false);
		text.setText(" The patrol car is a ground vehicle used by police for transportation during\n "
				+ " patrols and to enable them to respond to incidents and chases. Typical uses of a police\n"
				+ " car include transporting officers so they can reach the scene of an incident quickly, \n"
				+ " transporting and temporarily detaining suspects in the back seats, as a location to use \n"
				+ " their police radio or laptop, or to patrol an area, all while providing a visible deterrent \n"
				+ " to crime. Some police cars are specially adapted for certain locations or for certain operations.\n"
				+ " Police cars typically have rooftop flashing lights, a siren, and emblems or markings indicating \n"
				+ " that the vehicle is a police car. Some police cars may have reinforced bumpers and alley lights, for \n"
				+ " illuminating darkened alleys.");

		// Eventos
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		// Dise�o
		this.setLayout(new GridLayout(2, 1));
		panelPhoto.setLayout(new BorderLayout());

		panelPhoto.add(image, BorderLayout.CENTER);

		add(panelPhoto);
		add(panelText);

		panelPhoto.setLayout(new FlowLayout());

		panelText.setLayout(new BorderLayout());

		panelText.add(text, BorderLayout.CENTER);
		panelText.add(back, BorderLayout.SOUTH);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("PATROL CAR");
		pack();
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);

	}
}
