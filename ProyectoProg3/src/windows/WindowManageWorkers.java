package windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxEditor;

import classes.Asignable;
import classes.Boss;
import classes.PoliceStation;
import classes.Vehicle;
import classes.VehicleTypes;
import classes.Workers;
import classes.Workers2;
import classes.Brand.BrandEnum;
import classes.Colour.ColourEnum;
import databases.BDWorkers;

public class WindowManageWorkers extends JFrame {
	private JPanel contentPane;
	BDWorkers conexion;
	Workers2 workers2;
	Workers workers;
	Boss boss;
	PoliceStation policeS;
	private JComboBox<Asignable> comboWorkers;
	private DefaultListModel modelWorker1;
	private JList listVehicle;

	public WindowManageWorkers() {
		//Declaramos atributos del frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 662);
		setVisible(true);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboWorkers = new JComboBox<>();

		policeS = new PoliceStation();
		conexion = new BDWorkers();
		ArrayList<Boss> listBoss = conexion.consultarDatosBoss();
		ArrayList<Workers2> list = conexion.consultarDatos();
		policeS.getWorkers().addAll(list);
		policeS.getWorkers().addAll(listBoss);
		System.out.println(policeS.toString());

		for (Workers workers : policeS.getWorkers()) {
			comboWorkers.addItem((Asignable) workers);
		}

		comboWorkers.setBounds(39, 88, 696, 42);

		contentPane.add(comboWorkers);

		modelWorker1 = new DefaultListModel<Vehicle>();

		listVehicle = new JList(modelWorker1);
		JScrollPane scrollListVehicle = new JScrollPane(listVehicle);
		scrollListVehicle.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollListVehicle.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollListVehicle.setBounds(39, 232, 267, 340);
		contentPane.add(scrollListVehicle);

		DefaultListModel<Vehicle> modelWorker2 = new DefaultListModel();

		JList listManage = new JList(modelWorker2);
		JScrollPane scrollListManage = new JScrollPane(listManage);
		scrollListManage.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollListManage.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollListManage.setBounds(468, 232, 267, 340);
		contentPane.add(scrollListManage);

		JButton bmanageRight = new JButton("=>");
		bmanageRight.setBackground(Color.RED);
		bmanageRight.setForeground(Color.BLACK);
		bmanageRight.setBounds(316, 294, 142, 67);
		contentPane.add(bmanageRight);

		JButton bmanageLeft = new JButton("<=");
		bmanageLeft.setForeground(Color.BLACK);
		bmanageLeft.setBackground(Color.RED);
		bmanageLeft.setBounds(316, 412, 142, 67);
		contentPane.add(bmanageLeft);

		JLabel lWorkers = new JLabel("Workers:");
		lWorkers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lWorkers.setForeground(Color.WHITE);
		lWorkers.setBounds(39, 45, 667, 32);
		contentPane.add(lWorkers);

		JLabel lvehicles = new JLabel("Vehicles:");
		lvehicles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lvehicles.setForeground(Color.WHITE);
		lvehicles.setBounds(39, 187, 267, 34);
		contentPane.add(lvehicles);

		JLabel lmanage = new JLabel("Manage:");
		lmanage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lmanage.setForeground(Color.WHITE);
		lmanage.setBounds(467, 187, 268, 34);
		contentPane.add(lmanage);

		JButton bback = new JButton("Back");
		bback.setBounds(341, 503, 89, 23);
		contentPane.add(bback);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(341, 537, 89, 23);
		contentPane.add(btnSave);

		PoliceStation policeStation = new PoliceStation();
		Workers worke = (Workers) comboWorkers.getSelectedItem();
		ArrayList<Vehicle> declaredVehicles = policeStation.getHmWorVehi().get(workers);

		try {
			BufferedReader br = new BufferedReader(new FileReader("vehicles.txt"));//Buffer Reader
			if (modelWorker1.isEmpty()) {
				String line = br.readLine();
				while (line != null) {
					String data[] = line.split(" ");
					BrandEnum bra = BrandEnum.valueOf(data[0]);
					ColourEnum col = ColourEnum.valueOf(data[1]);
					VehicleTypes veh = VehicleTypes.valueOf(data[2]);
					String pla = String.valueOf(data[3]);

					Vehicle v = new Vehicle(bra, col, veh,pla);
					modelWorker1.addElement(v);

					policeStation.getVehicles().add(v);
					System.out.println(policeStation);
					line = br.readLine();
				}
				listVehicle.setModel(modelWorker1);

				br.close();
			} else {
				JOptionPane.showMessageDialog(null, "Error.");
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		policeStation.getVehicles();
		//Eventos
		bback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GeneralWindow();
				dispose();
			}
		});

		bmanageRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Asignable asignable = (Asignable) comboWorkers.getSelectedItem();
				workers = new Workers();
				workers = (Workers) asignable;

				ArrayList<Vehicle> vehicleDeclarados = policeStation.getHmWorVehi().get(asignable);
				Vehicle vehicle = (Vehicle) listVehicle.getSelectedValue();

				int input = JOptionPane.showConfirmDialog(bmanageRight,
						"The worker=> " + workers.getName() + " has selected the vehicle=> " + vehicle.getBrand() + ", "
								+ vehicle.getVehicleTypes() + ".\n                                                 "
								+ "Are you sure?",
						" data relation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (input == 0) {

					if (vehicle != null) {

						if (vehicleDeclarados == null) {
							vehicleDeclarados = new ArrayList<Vehicle>();
							vehicleDeclarados.add(vehicle);
							policeS.getHmWorVehi().put(asignable, vehicleDeclarados);
							modelWorker2.addElement(vehicle);
							modelWorker1.removeElement(vehicle);
						} else {
							if (vehicleDeclarados.indexOf(vehicle) < 0) {
								vehicleDeclarados.add(vehicle);
								policeS.getHmWorVehi().put(asignable, vehicleDeclarados);
								modelWorker2.addElement(vehicle);
								modelWorker1.removeElement(vehicle);
							}
						}
					}
				}
			}
		});

		bmanageLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Asignable asignable = (Asignable) comboWorkers.getSelectedItem();
				Vehicle vehicle = (Vehicle) listManage.getSelectedValue();
				
				int input = JOptionPane.showConfirmDialog(bmanageRight,
						"The worker=> " + workers.getName() + " has selected the vehicle=> " + vehicle.getBrand() + ", "
								+ vehicle.getVehicleTypes() + ".\n              "
								+ "Are you sure to take the vehicle away from the worker?",
						" data relation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (input == 0) {
					
					modelWorker2.removeElement(vehicle);
					policeS.getHmWorVehi().get(asignable).remove(vehicle);
					modelWorker1.addElement(vehicle);
				}
			}
		});

		comboWorkers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Asignable asignable = (Asignable) comboWorkers.getSelectedItem();
				ArrayList<Vehicle> vehiclesAsignados = policeS.getHmWorVehi().get(asignable);
				modelWorker2.clear();
				if (vehiclesAsignados != null) {
					for (Vehicle vehicle : vehiclesAsignados) {
						modelWorker2.addElement(vehicle);
					}
				}
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
	}

}
