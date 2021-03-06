package windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ArmoredCarWindow extends JFrame {

	// Declaramos
	JPanel panelPhoto;
	JPanel panelText;
	JLabel image;
	JTextArea text;
	JButton back;

	public ArmoredCarWindow() {
		JPanel panelPhoto = new JPanel();
		JPanel panelText = new JPanel();
		URL iconURL = getClass().getResource("/icons/armoredcar.jpg");
		image = new JLabel(new ImageIcon(iconURL));

		JTextArea text = new JTextArea();

		JButton back = new JButton("Back");

		// Texto donde a�adimos informacion sobre el coche armado
		text.setEditable(false);
		text.setText(" The armored car is a wheeled armored personnel carrier designed for military\n"
				+ " and law enforcement use. It is in use by several military forces and law enforcement\n"
				+ " agencies around the world. Armored cars are typically referred to by law enforcement\n"
				+ " agencies as being armored rescue vehicles with their primary use being to\n"
				+ " transport tactical officers to and from hostile\n"
				+ " situations and to assist with the recovery and protection of civilians in harm's\n"
				+ " way during terrorist threats, hostage incidents, or encounters with large gatherings\n"
				+ " of aggressors. The armored car is designed to provide protection from a variety\n"
				+ " of small arms, explosives and IED threats.");
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
		setTitle("ARMORED CAR");
		pack();
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
