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
	Boss boss;
	PoliceStation policeS;
	private JComboBox<Object> comboWorkers;
	private DefaultListModel<Vehicle> modelWorker1;
	private JList listVehicle;
	
	public WindowManageWorkers() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 662);
		setVisible(true);
		setLocationRelativeTo( null );
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		modelWorker1 = new DefaultListModel<Vehicle>();

		listVehicle = new JList(modelWorker1);
		listVehicle.setBounds(39, 232, 267, 340);
		contentPane.add(listVehicle);

		DefaultListModel<Vehicle> modelWorker2 = new DefaultListModel();

		JList listManage = new JList(modelWorker2);
		listManage.setBounds(468, 232, 267, 340);
		contentPane.add(listManage);

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

		comboWorkers = new JComboBox<>();

		cargarDatosComboBox();

		comboWorkers.setBounds(39, 88, 696, 42);

		contentPane.add(comboWorkers);

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
		bback.setBounds(340, 533, 89, 23);
		contentPane.add(bback);
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("vehicles.txt"));
			if(modelWorker1.isEmpty()) {
			String line = br.readLine();
			while(line!=null) {
				String data[] = line.split(" ");
				BrandEnum bra = BrandEnum.valueOf(data[0]);
				ColourEnum col = ColourEnum.valueOf(data[1]);
				VehicleTypes veh = VehicleTypes.valueOf(data[2]);
			
				Vehicle v = new Vehicle(bra,col,veh);
				modelWorker1.addElement(v);
				line = br.readLine();
			}
			listVehicle.setModel(modelWorker1);
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
				int pos = listVehicle.getSelectedIndex();
				if (pos != -1) {
					modelWorker2.addElement(modelWorker1.get(pos));
					modelWorker1.remove(pos);
					listManage.setModel(modelWorker2);
					listVehicle.setModel(modelWorker1);
				}
			}
		});

		bmanageLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int pos = listManage.getSelectedIndex();
				if (pos != -1) {
					modelWorker1.addElement(modelWorker2.get(pos));
					modelWorker2.remove(pos);
					listVehicle.setModel(modelWorker1);
					listManage.setModel(modelWorker2);
				}
			}
		});
	}

	public void cargarDatosComboBox() {

		conexion = new BDWorkers();
		workers2 = new Workers2();
		boss = new Boss();
		ArrayList<Workers2> list = conexion.consultarDatos();
		ArrayList<Boss> listB = conexion.consultarDatosBoss();

		if (list.size() > 0 || listB.size() > 0) {

			for (int i = 0; i < list.size(); i++) {
				comboWorkers = new JComboBox<>();
				workers2 = list.get(i);
				for (Workers workers2 : list) {
					comboWorkers.addItem(workers2);
				}

			}
			for (int i = 0; i < listB.size(); i++) {
				boss = listB.get(i);
				comboWorkers.addItem(boss);

			}

		}
	}

}
