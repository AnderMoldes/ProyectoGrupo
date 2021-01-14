package windows;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import java.awt.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import classes.Brand;
import classes.Brand.BrandEnum;
import classes.Colour.ColourEnum;
import classes.PoliceStation;
import classes.Vehicle;
import classes.VehicleTypes;

import classes.Vehicle;
import java.awt.event.*;
import java.util.Date;
import classes.*;

public class VehicleWindow extends JFrame{
	PoliceStation policeStation;
	Vehicle vehicles;
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
	JComboBox<BrandEnum> comboBrand;
	JComboBox<ColourEnum> comboColour;
	
	
	private JPanel contentPane;
	
	
	public VehicleWindow(){
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 559);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel brandLabel = new JLabel("Brand:");
		brandLabel.setBounds(645, 190, 127, 44);
		contentPane.add(brandLabel);
		
		JComboBox<BrandEnum> comboBrand = new JComboBox();
		comboBrand.addItem(BrandEnum.MITSUBISHI);
		comboBrand.addItem(BrandEnum.NISSAN);
		comboBrand.addItem(BrandEnum.PEUGEOT);
		comboBrand.addItem(BrandEnum.RENAULT);
		comboBrand.addItem(BrandEnum.SEAT);
		comboBrand.setBounds(629, 231, 132, 22);
		contentPane.add(comboBrand);
		
		JLabel colourJLabel = new JLabel("Colour:");
		colourJLabel.setBounds(645, 264, 138, 22);
		contentPane.add(colourJLabel);
		
		JComboBox<ColourEnum> comboColour = new JComboBox();
		comboColour.setBounds(629, 289, 132, 22);
		comboColour.addItem(ColourEnum.BLACK);
		comboColour.addItem(ColourEnum.BLUE);
		comboColour.addItem(ColourEnum.GOLD);
		comboColour.addItem(ColourEnum.GREEN);
		comboColour.addItem(ColourEnum.GREY);
		comboColour.addItem(ColourEnum.RED);
		comboColour.addItem(ColourEnum.WHITE);
		contentPane.add(comboColour);
		
		JLabel labelType = new JLabel("Vehicle Type:");
		labelType.setBounds(645, 322, 138, 22);
		contentPane.add(labelType);
		
		JComboBox<VehicleTypes> comboType = new JComboBox();
		comboType.addItem(VehicleTypes.PATROLCAR);
		comboType.addItem(VehicleTypes.ARMOREDCAR);
		comboType.addItem(VehicleTypes.ARMOREDVAN);
		comboType.addItem(VehicleTypes.MOTORBIKE);
		comboType.addItem(VehicleTypes.TRUCK);
		
		comboType.setBounds(629, 355, 132, 22);
		contentPane.add(comboType);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 793, 22);
		contentPane.add(menuBar);
		
		JMenu menuInfo = new JMenu("Info for Vehycle types:");
		menuBar.add(menuInfo);
		
		JMenuItem patrolCar = new JMenuItem("Patrol Car");
		menuInfo.add(patrolCar);
		
		JMenuItem armoredCar = new JMenuItem("Armored Car");
		menuInfo.add(armoredCar);
		
		JMenuItem armoredVan = new JMenuItem("Armored Van");
		menuInfo.add(armoredVan);
		
		JMenuItem motorbike = new JMenuItem("Motorbike");
		menuInfo.add(motorbike);
		
		JMenuItem truck = new JMenuItem("Truck");
		menuInfo.add(truck);
		
		
		DefaultListModel<Object> modelVehicles = new DefaultListModel();
		JList vehicleJList = new JList(modelVehicles);
		contentPane.add(vehicleJList);
		vehicleJList.setBounds(72, 234, 503, 143);
		
		JButton bback = new JButton("Back");
		bback.setBounds(10, 417, 89, 23);
		contentPane.add(bback);
		
		JButton bdelete = new JButton("Delete");
		bdelete.setBounds(10, 156, 112, 23);
		contentPane.add(bdelete);
		
		JButton bshow = new JButton("Show");
		bshow.setBounds(164, 156, 112, 23);
		contentPane.add(bshow);
		
		JButton bupdate = new JButton("Update");
		bupdate.setBounds(320, 156, 112, 23);
		contentPane.add(bupdate);
		
		JButton bsave = new JButton("Save");
		bsave.setBounds(486, 156, 112, 23);
		contentPane.add(bsave);
		
		JButton bcreate = new JButton("Create");
		bcreate.setBounds(649, 156, 112, 23);
		contentPane.add(bcreate);
		
		
			
		
		
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
		bcreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				crearVehiculo(vehicles, policeStation, modelVehicles);
			}
			
		});
		bback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new GeneralWindow();
			}
		});
		
		
		
	}
	public void crearVehiculo(Vehicle vehicle, PoliceStation policeStation,DefaultListModel model) {
		Vehicle nuevo;
		
		if (vehicle != null) {
			nuevo = vehicle;
		} else {
			nuevo = new Vehicle();
		}
		nuevo.setColour((ColourEnum) comboColour.getSelectedItem());
		nuevo.setBrand((BrandEnum) comboBrand.getSelectedItem());
		nuevo.setVehicleTypes((VehicleTypes) comboTypes.getSelectedItem());
		
		if (vehicle == null) {
			policeStation.getVehicles().add(nuevo);
			model.addElement(nuevo);
		}
	}
	
}
