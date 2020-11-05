package Windows;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class DetainedWindow extends JFrame {

	JButton first;
	JButton second;

	public DetainedWindow() {
		setLayout(new GridLayout(2, 1));

		first = new JButton("Create a Arrested");
		second = new JButton("Create a Fined");

		add(first);
		add(second);

		

		first.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateDetainedWindow();
				dispose();
			}
		});

		second.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FainedWindow();
				dispose();
			}
		});

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("CHOOSING THE TYPE OF EMPLOYEE");
		pack();
		setVisible(true);

	}

}
