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
import databases.BDWorkers;
import classes.Vehicle;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import classes.*;

public class VehicleWindow extends JFrame{
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
	DefaultListModel<Object> modelVehicles = new DefaultListModel();
	JList vehicleJList = new JList(modelVehicles);
	JScrollPane scrollVehicle = new JScrollPane(vehicleJList);
	
	PoliceStation policeStation = new PoliceStation();
	private JPanel contentPane;
	
	ArrayList<Vehicle> al = new ArrayList<>();
	
	public VehicleWindow(){
		scrollVehicle.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollVehicle.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
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
		
		
		
		contentPane.add(scrollVehicle);
		scrollVehicle.setBounds(72, 234, 503, 143);
		
		JButton bback = new JButton("Back");
		bback.setBounds(10, 417, 89, 23);
		contentPane.add(bback);
		
		JButton bdelete = new JButton("Delete");
		bdelete.setBounds(10, 156, 112, 23);
		contentPane.add(bdelete);
		
		JButton bshow = new JButton("Show");
		bshow.setBounds(164, 156, 112, 23);
		contentPane.add(bshow);
		
		
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
				VehicleTypes vehicle;
				BrandEnum brand;
				ColourEnum colour;
				
				vehicle = (VehicleTypes) comboType.getSelectedItem();
				brand = (BrandEnum) comboBrand.getSelectedItem();
				colour = (ColourEnum) comboColour.getSelectedItem();
				
				Vehicle v = new Vehicle(brand,colour,vehicle);
				policeStation.getVehicles().add(v);
				
				modelVehicles.addElement(v);
				al.add(v);
				
				
				
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
		bsave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				doCSV();
			}

			
		});
		bshow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					try {
						BufferedReader br = new BufferedReader(new FileReader("vehicles.txt"));
						if(modelVehicles.isEmpty()) {
						String line = br.readLine();
						while(line!=null) {
							String data[] = line.split(" ");
							BrandEnum bra = BrandEnum.valueOf(data[0]);
							ColourEnum col = ColourEnum.valueOf(data[1]);
							VehicleTypes veh = VehicleTypes.valueOf(data[2]);
						
							Vehicle v = new Vehicle(bra,col,veh);
							modelVehicles.addElement(v);
							policeStation.getVehicles().add(v);
							line = br.readLine();
						}
						vehicleJList.setModel(modelVehicles);
						br.close();
					}else {
						JOptionPane.showMessageDialog(null, "Error.");
					}
				
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		bdelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int question = JOptionPane.showConfirmDialog(null, "Are you sure?");
				if (question == 0) {
					
				Vehicle v = (Vehicle) vehicleJList.getSelectedValue();
				al.remove(v);
				modelVehicles.removeElement(v);
				policeStation.getVehicles().remove(v);
				doCSV();
				}
			}
		});
		
		
		
	}
	private void doCSV() {
		// TODO Auto-generated method stub
		try {
			PrintWriter pw = new PrintWriter(new File("vehicles.txt"));
			for(int i=0;i<modelVehicles.getSize();i++) {
				Vehicle v = (Vehicle) modelVehicles.get(i);
				pw.println(v.getBrand()+" "+v.getColour()+" "+v.getVehicleTypes());
				al.add(v);
				policeStation.getVehicles().add(v);	
			}
			System.out.println(policeStation);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
