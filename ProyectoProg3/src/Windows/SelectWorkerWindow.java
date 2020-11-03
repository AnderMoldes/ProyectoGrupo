package Windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Classes.Police_Station;

public class SelectWorkerWindow extends JFrame{
	Police_Station policeStation;
	JButton grade1;
	JButton grade2;
	JButton grade3;
	
	
	public SelectWorkerWindow() {
		setLayout(new GridLayout(3,1));
		grade1 = new JButton("Create a Grade 1 worker");
		grade2 = new JButton("Create a Grade 2 worker");
		grade3 = new JButton("Create a Grade 3 worker");
		
		add(grade1);
		add(grade2);
		add(grade3);
		
		grade1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Grade1Window(policeStation, null, null);
				
			}});
		grade2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Grade2Window(policeStation, null, null);
				
			}});
		grade3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Grade3Window(policeStation, null, null);
				
			}});
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Select the grade of the worker");
		pack();
		setResizable(false);
		setVisible(true);
		
		
	}

}
