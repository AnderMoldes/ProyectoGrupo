package windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import classes.Arrested;
import classes.Asignable;
import classes.Boss;
import classes.Detained;
import classes.Fined;
import classes.PoliceStation;
import classes.Workers;
import classes.Workers2;
import databases.BDWorkers;
import databases.BDetained;

public class WindowManageDetained extends JFrame {
	private JPanel contentPane;
	BDWorkers conexion;
	BDetained conexionD;
	Workers2 workers2;
	Boss boss;
	Arrested arrested;
	Fined fined;
	PoliceStation policeS;
	private JComboBox<Asignable> comboWorkers;
	private DefaultListModel modelDetained1;
	private JList listDetained;

	public WindowManageDetained(PoliceStation policeStation) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 662);
		setVisible(true);
		setLocationRelativeTo( null );
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboWorkers = new JComboBox<>();
		comboWorkers.setBackground(Color.CYAN);
		comboWorkers.setForeground(Color.BLACK);
		
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
		
		//Scroll and list for the left JList
		modelDetained1 = new DefaultListModel<>();

		listDetained = new JList<>(modelDetained1);
		listDetained.setBackground(Color.WHITE);
		JScrollPane scrollDetained = new JScrollPane(listDetained);
		scrollDetained.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollDetained.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollDetained.setBounds(39, 232, 267, 340);
		contentPane.add(scrollDetained);
		
		policeS = new PoliceStation();
		conexionD = new BDetained();
		ArrayList<Arrested> listA = conexionD.consultarDatosArrested();
		ArrayList<Fined> listF = conexionD.consultarDatosFained();
		policeS.getDetained().addAll(listA);
		policeS.getDetained().addAll(listF);
		System.out.println(policeS.toString());
		
		
		for (Detained detained : policeS.getDetained()) {
			modelDetained1.addElement(detained);
		}
		
		//Scroll and list for the right JLIst
		DefaultListModel modelDetained2 = new DefaultListModel();

		JList listManage = new JList(modelDetained2);
		listManage.setBackground(Color.WHITE);
		JScrollPane scrollListManage = new JScrollPane(listManage);
		scrollListManage.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollListManage.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollListManage.setBounds(468, 232, 267, 340);
		contentPane.add(scrollListManage);
		
		Asignable asignable= (Asignable) comboWorkers.getSelectedItem();
		ArrayList<Detained> detainedAsignados= policeS.getHmWorDetai().get(asignable);
		modelDetained2.clear();
		
		if (detainedAsignados != null) {
			for (Detained detained : detainedAsignados) {
				modelDetained2.addElement(detained);
			}
		} 
		
		//Objects from panels
		JButton bmanageRight = new JButton("=>");
		bmanageRight.setBackground(Color.CYAN);
		bmanageRight.setForeground(Color.BLACK);
		bmanageRight.setBounds(316, 294, 142, 67);
		contentPane.add(bmanageRight);

		JButton bmanageLeft = new JButton("<=");
		bmanageLeft.setForeground(Color.BLACK);
		bmanageLeft.setBackground(Color.CYAN);
		bmanageLeft.setBounds(316, 412, 142, 67);
		contentPane.add(bmanageLeft);

		
		
		comboWorkers.setBounds(39, 88, 696, 42);
		contentPane.add(comboWorkers);

		JLabel lworkers = new JLabel("Workers:");
		lworkers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lworkers.setForeground(Color.BLACK);
		lworkers.setBounds(39, 45, 667, 32);
		contentPane.add(lworkers);

		JLabel ldetained = new JLabel("Detained:");
		ldetained.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ldetained.setForeground(Color.BLACK);
		ldetained.setBounds(39, 187, 267, 34);
		contentPane.add(ldetained);

		JLabel lmanage = new JLabel("Manage:");
		lmanage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lmanage.setForeground(Color.BLACK);
		lmanage.setBounds(467, 187, 268, 34);
		contentPane.add(lmanage);

		JButton bback = new JButton("Back");
		bback.setBounds(341, 503, 89, 23);
		contentPane.add(bback);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(341, 537, 89, 23);
		contentPane.add(btnSave);
		
		//Events
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
				Asignable asignable= (Asignable) comboWorkers.getSelectedItem();
				ArrayList<Detained> detainedAsignados= policeS.getHmWorDetai().get(asignable);
				Detained detained= (Detained) listDetained.getSelectedValue();
				
				if (detained!= null) {
					
					if (detainedAsignados==null) {
						detainedAsignados= new ArrayList<Detained>(); 
						detainedAsignados.add(detained);
						policeS.getHmWorDetai().put(asignable, detainedAsignados);
						modelDetained2.addElement(detained);
						modelDetained1.removeElement(detained);
						
					}else {
						if (detainedAsignados.indexOf(detained) < 0) {
							detainedAsignados.add(detained);
							policeS.getHmWorDetai().put(asignable, detainedAsignados);
							modelDetained2.addElement(detained);
							modelDetained1.removeElement(detained);
						}
						
					}
				}
				
			}
		});

		bmanageLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Asignable asignable= (Asignable) comboWorkers.getSelectedItem();
				Detained detained= (Detained) listManage.getSelectedValue();
				modelDetained2.removeElement(detained);
				policeS.getHmWorDetai().get(asignable).remove(detained);
				modelDetained1.addElement(detained);
				
			}
		});
		
		comboWorkers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Asignable asignable= (Asignable) comboWorkers.getSelectedItem();
				ArrayList<Detained> detainedAsignados= policeS.getHmWorDetai().get(asignable);
				modelDetained2.clear();
				
				if (detainedAsignados != null) {
					for (Detained detained : detainedAsignados) {
						modelDetained2.addElement(detained);
					}
				}
			}
		});
		
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HashMap<Asignable, ArrayList<Detained>> hmWorDetai = new HashMap<Asignable, ArrayList<Detained>>();
				Properties properties = new Properties();
				hmWorDetai = policeS.getHmWorDetai();
				

				for (Entry<Asignable, ArrayList<Detained>> entry : hmWorDetai.entrySet()) {
					properties.put(entry.getKey(), entry.getValue());

				}

				try {
					properties.storeToXML(new FileOutputStream("data.properties"), null);
					System.out.println(properties);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		Properties properties = new Properties();
		Enumeration<Object> claves = properties.keys();

		try {
			properties.load(new FileInputStream("data.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(claves);

		while (claves.hasMoreElements()) {
			Object clave = claves.nextElement();
			System.out.println(properties.getProperty(clave.toString()));

		}
		
	}
	

}
