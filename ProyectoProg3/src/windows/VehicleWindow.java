package windows;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;


import java.awt.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import classes.Brand;
import classes.VehicleTypes;


import java.awt.event.*;

public class VehicleWindow extends JFrame{
	
	JPanel panel1;
	JPanel panel2;

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
	
	
	public class MiModelo extends DefaultTableModel {
		   public boolean isCellEditable (int row, int column) {
		       // Aquí devolvemos true o false según queramos que una celda
		       // identificada por fila,columna (row,column), sea o no editable
			   
		       return false;
		   }
		}
	
	
	public VehicleWindow(){
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
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
				
		MiModelo modelVehicles = new MiModelo();
		modelVehicles.addColumn("license plate");
		modelVehicles.addColumn("brand");
		modelVehicles.addColumn("colour");
		
		JTable table = new JTable(modelVehicles);
		JScrollPane scrollVehicles= new JScrollPane(table);
		
		add(panel2);
		add(panel1);
		
		panel2.add(scrollVehicles);
		
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
		motorbike.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MotorBikeWindow();
				
			}
		});
		truck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TruckWindow();
				
			}
		});
		armoredCar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ArmoredCarWindow();
				
			}
		});
		armoredVan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ArmoredVanWindow();
				
			}
		});
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("VEHICLE MANAGEMENT");
		
		pack();
		setResizable(false);
		setVisible(true);
	}
}
