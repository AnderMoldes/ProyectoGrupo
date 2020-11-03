package Windows;

import javax.swing.*;
import java.awt.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import Classes.Brand;
import Classes.VehicleTypes;

import java.awt.event.*;

public class VehicleWindow extends JFrame{
	
	JPanel panel1;

	JMenuBar bar;
	JMenu types;
	JMenuItem patrolCar;
	JMenuItem armoredCar;
	JMenuItem armoredVan;
	JMenuItem motorbike;
	JMenuItem truck;
	
	JLabel type;
	JComboBox<VehicleTypes> comboTypes;
	JLabel brand;
	JComboBox<Brand> comboBrand;
	
	
	
	
	
	public VehicleWindow(){
		JPanel panel1 = new JPanel();
		
		JMenuBar bar = new JMenuBar();
		JMenu types = new JMenu("Types of Vehicle");
		JMenuItem patrolCar = new JMenuItem("Patrol Car");
		JMenuItem armoredCar = new JMenuItem("Armored Car");
		JMenuItem armoredVan = new JMenuItem("Armored Van");
		JMenuItem motorbike = new JMenuItem("Motorbike");
		JMenuItem truck = new JMenuItem("Truck");
		
		JLabel type = new JLabel("Type of vehicle");
		
		JComboBox<VehicleTypes> comboTypes = new JComboBox<VehicleTypes>();
		comboTypes.addItem(VehicleTypes.PATROLCAR);
		comboTypes.addItem(VehicleTypes.ARMOREDCAR);
		comboTypes.addItem(VehicleTypes.ARMOREDVAN);
		comboTypes.addItem(VehicleTypes.MOTORBIKE);
		comboTypes.addItem(VehicleTypes.TRUCK);
		
		JLabel brand = new JLabel("Brand");
		
		JComboBox<Brand> comboBrand = new JComboBox<Brand>();
		comboBrand.addItem(Brand.MITSUBISHI);
		comboBrand.addItem(Brand.NISSAN);
		comboBrand.addItem(Brand.PEUGEOT);
		comboBrand.addItem(Brand.RENAULT);
		comboBrand.addItem(Brand.SEAT);
		
		this.setLayout(new FlowLayout());
		
		add(panel1);
		
		bar.add(types);
		types.add(patrolCar);
		types.add(armoredCar);
		types.add(armoredVan);
		types.add(motorbike);
		types.add(truck);
		
		panel1.add(type);
		panel1.add(comboTypes);
		panel1.add(brand);
		panel1.add(comboBrand);
		
		panel1.setLayout(new GridLayout(2,2));
		
		setJMenuBar(bar);
		
		patrolCar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PatrolCarWindow();
				
			}
		});
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("VEHICLE MANAGEMENT");
		setSize(500, 500);
		//pack();
		setResizable(false);
		setVisible(true);
	}
}
