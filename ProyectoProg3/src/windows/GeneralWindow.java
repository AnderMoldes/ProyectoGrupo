package windows;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import classes.Arrested;
import classes.Boss;
import classes.Detained;
import classes.Fined;
import classes.PoliceStation;
import classes.Workers;
import classes.Workers2;
import databases.BDWorkers;
import databases.BDetained;

import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class GeneralWindow {
	JMenuItem vehicle;
	Workers workers;
	JButton bClose;
	JLabel lbar;
	JProgressBar progress;
	PoliceStation police;
	Detained detained;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_4;

	public GeneralWindow() {
		BDWorkers cc = new BDWorkers();
		Connection cn = cc.getConection();

		frame = new JFrame();
		frame.setBounds(100, 100, 801, 462);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Create/Activate Database");
		mnNewMenu.add(mntmNewMenuItem);
		frame.getContentPane().setLayout(null);

		JMenuItem vehicle = new JMenuItem("Vehicles");
		mnNewMenu.add(vehicle);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton(new ImageIcon("POLICIAS_Y_LADRONES_35.gif"));
		btnNewButton.setBounds(500, 65, 97, 130);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Manage Relations");
		btnNewButton_2.setBounds(65, 239, 170, 23);
		frame.getContentPane().add(btnNewButton_2);

		JButton bClose = new JButton("Close Window");
		bClose.setForeground(Color.RED);
		bClose.setBounds(334, 301, 121, 23);
		frame.getContentPane().add(bClose);

		JButton btnNewButton_2_1 = new JButton("Manage Workers");
		btnNewButton_2_1.setBounds(312, 239, 163, 23);
		frame.getContentPane().add(btnNewButton_2_1);

		JButton btnNewButton_2_2 = new JButton("Manage Detained");
		btnNewButton_2_2.setBounds(559, 239, 155, 23);
		frame.getContentPane().add(btnNewButton_2_2);

		JLabel lblNewLabel = new JLabel("Closing the window...");
		lblNewLabel.setBounds(278, 360, 279, 14);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(false);

		JProgressBar progressBar = new JProgressBar(0, 100);
		progressBar.setBounds(415, 360, 146, 14);
		frame.getContentPane().add(progressBar);

		JButton btnNewButton_1 = new JButton(new ImageIcon("criminal-preso.gif"));
		btnNewButton_1.setBounds(181, 65, 97, 130);
		frame.getContentPane().add(btnNewButton_1);
		progressBar.setVisible(false);

		vehicle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VehicleWindow();
				frame.dispose();

			}
		});

		bClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {

						lblNewLabel.setVisible(true);
						progressBar.setVisible(true);

						for (int i = 0; i <= 100; i++) {
							progressBar.setValue(i);
							try {
								Thread.sleep(7);
							} catch (InterruptedException el) {
								el.printStackTrace();
							}
						}

						lblNewLabel.setVisible(false);
						progressBar.setVisible(false);
						frame.dispose();
					}
				});

				thread.start();

			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WindowWorkers(null, police);
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WindowDetained((Arrested) detained, police, null);
			}
		});

		mntmNewMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				BDWorkers.initBD("Workers.db");
				BDetained.initBD("Detained.db");

			}
		});

		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setTitle("POLICE MANAGEMENT");
		frame.setResizable(true);
		frame.setVisible(true);

//		createWorkers.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new WorkersWindow(null, policeStation, modelWorkers);
//			}
//		});
//
//		createBoss.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new BossWindow(null, policeStation, modelWorkers);
//			}
//		});
//
//		/*
//		 * consultWorkers.addActionListener(new ActionListener() {
//		 * 
//		 * @Override public void actionPerformed(ActionEvent e) { Workers workers =
//		 * (Workers) modelWorkers.getValueAt(1, 1 );
//		 * 
//		 * if (workers instanceof Boss) { new BossWindow((Boss) workers, policeStation,
//		 * modelWorkers); } else { new WorkersWindow(workers, policeStation,
//		 * modelWorkers); } } });
//		 * 
//		 * table.addMouseListener(new MouseAdapter() { public void
//		 * mouseClicked(MouseEvent evt) { JList list = (JList) evt.getSource(); if
//		 * (evt.getClickCount() == 2) { Workers workers = (Workers)
//		 * table.getSelectionModel();
//		 * 
//		 * if (workers instanceof Boss) { new BossWindow((Boss) workers, policeStation,
//		 * modelWorkers); } else { new WorkersWindow(workers, policeStation,
//		 * modelWorkers); } } } });
//		 */
//		
////		tableWorkers.addMouseListener(new MouseAdapter() {
////			public void mouseClicked(MouseEvent e) {
////				int fila = tableWorkers.rowAtPoint(e.getPoint());
////				int columna = tableWorkers.columnAtPoint(e.getPoint());
////			if ((fila > -1) && (columna > -1) || e.getClickCount() == 2 ) {
////				if (e.getClickCount() == 2) {
////					Workers2 workers2=  (Workers2) tableWorkers.getSelectionModel(); 
////					new WorkersWindow((Workers2) workers, policeStation, modelWorkers);
////				}
////			}
////		});
//
//
//		createArrested.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new ArrestedWindow(null, policeStation, modelDetained);
//			}
//		});
//
//		createFined.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new FainedWindow(null, policeStation, modelDetained);
//			}
//		});
//
//		/*
//		 * consultDetained.addActionListener(new ActionListener() {
//		 * 
//		 * @Override public void actionPerformed(ActionEvent e) { Detained detained =
//		 * (Detained) listDetained.getSelectedValue();
//		 * 
//		 * if (detained instanceof Arrested) { new ArrestedWindow((Arrested) detained,
//		 * policeStation, modelDetained); } else if (detained instanceof Fined){ new
//		 * FainedWindow((Fined)detained, policeStation, modelDetained); }
//		 * 
//		 * } });
//		 * 
//		 * listDetained.addMouseListener(new MouseAdapter() { public void
//		 * mouseClicked(MouseEvent evt) { JList list = (JList) evt.getSource(); if
//		 * (evt.getClickCount() == 2) { Detained detained = (Detained)
//		 * listDetained.getSelectedValue();
//		 * 
//		 * if (detained instanceof Arrested) { new ArrestedWindow((Arrested) detained,
//		 * policeStation, modelDetained); } else if (detained instanceof Fined){ new
//		 * FainedWindow((Fined)detained, policeStation, modelDetained); } } } });
//		 * 
//		 * 
//		 * 
//		 * delete.addActionListener(new ActionListener() {
//		 * 
//		 * @Override public void actionPerformed(ActionEvent e) { int question =
//		 * JOptionPane.showConfirmDialog(null,
//		 * "Are you sure that you want to delete this?"); if (question == 0) { Workers
//		 * worker = (Workers) listWorkers.getSelectedValue(); Workers boss = (Boss)
//		 * listWorkers.getSelectedValue(); Detained arrested = (Arrested)
//		 * listDetained.getSelectedValue(); Detained fined = (Fined)
//		 * listDetained.getSelectedValue();
//		 * 
//		 * policeStation.getWorkers().remove(worker);
//		 * policeStation.getWorkers().remove(boss);
//		 * policeStation.getDetained().remove(arrested);
//		 * policeStation.getDetained().remove(fined);
//		 * 
//		 * modelWorkers.removeElement(worker); modelWorkers.removeElement(boss);
//		 * modelDetained.removeElement(arrested); modelDetained.removeElement(fined);
//		 * 
//		 * }
//		 * 
//		 * } });
//		 */
//		delete.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int fila = tableWorkers.getSelectedRow();
//				int fila2 = tableDetained.getSelectedColumn();
//				if (fila >= 0 && tableWorkers.isColumnSelected(fila)) {
//					modelWorkers.removeRow(fila);
//				} else if (fila2 >= 0 && tableDetained.isColumnSelected(fila)) {
//					modelDetained.removeRow(fila);
//				} else {
//					JOptionPane.showMessageDialog(null, "Select Row");
//				}
//			}
//
//		});
//
//		consultWorkers.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				for (Workers workers : policeStation.getWorkers()) {
//					if (workers instanceof Workers2) {
//						BDWorkers.update((Workers2) workers);
//					}
//				}
//				
//				for (Workers workers : policeStation.getWorkers()) {
//					if (workers instanceof Boss) {
//						BDWorkers.updateBoss((Boss) workers);
//					}
//				}
//				
//				
//
//			}
//		});
//
//		consultDetained.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int fila = Integer.parseInt(getName());
//				int columna = Integer.parseInt(getTitle());
//
//			}
//		});
//
//		
//
//		
//		
//		createTables.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				BDWorkers.conection("WorkersTable");
//				BDWorkers.conectionBoss("WorkersTableBoss");
//
//				BDetained.conection("DetainedTable");
//				BDetained.conectionFained("FainedTable");
//				
//			}
//		});
//		
//		dropTables.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				BDWorkers.dropTable("WorkersTable");
//				BDWorkers.dropTable("WorkersTableBoss");
//				BDetained.dropTable("DetainedTable");
//				BDetained.dropTable("FainedTable");
//				
//			}
//		});
//
//		saveDataWorkers.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				for (Workers workers : policeStation.getWorkers()) {
//					if (workers instanceof Workers2) {
//					BDWorkers.insertIntoPrepStat((Workers2) workers);
//					}
//				}
//			}
//		});
//		
//		ShowDataWorkers.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					ArrayList<Object[]> datos = new ArrayList<Object[]>();
//					datos = BDWorkers.consultarDatos("WorkersTable");
//
//					for (int i = 0; i < datos.size(); i++) {
//						modelWorkers.addRow(datos.get(i));
//					}
//					tableWorkers.setModel(modelWorkers);
//
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}
//		});
//
//		ShowData.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					ArrayList<Object[]> datos = new ArrayList<Object[]>();
//					datos = BDWorkers.consultarDatos("WorkersTable");
//
//					for (int i = 0; i < datos.size(); i++) {
//						modelWorkers.addRow(datos.get(i));
//					}
//					tableWorkers.setModel(modelWorkers);
//
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				try {
//					ArrayList<Object[]> datosBoss = new ArrayList<Object[]>();
//					datosBoss = BDWorkers.consultarDatosBoss("WorkersTableBoss");
//
//					for (int i = 0; i < datosBoss.size(); i++) {
//						modelWorkers.addRow(datosBoss.get(i));
//					}
//					tableWorkers.setModel(modelWorkers);
//
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				try {
//					ArrayList<Object[]> datosArrested = new ArrayList<Object[]>();
//					datosArrested = BDetained.consultarDatosArrested("DetainedTable");
//
//					for (int i = 0; i < datosArrested.size(); i++) {
//						modelDetained.addRow(datosArrested.get(i));
//					}
//					tableDetained.setModel(modelDetained);
//
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				try {
//					ArrayList<Object[]> datosFained = new ArrayList<Object[]>();
//					datosFained = BDetained.consultarDatosFained("FainedTable");
//
//					for (int i = 0; i < datosFained.size(); i++) {
//						modelDetained.addRow(datosFained.get(i));
//					}
//					tableDetained.setModel(modelDetained);
//
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}
//		});
//
//		saveDataBoss.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				for (Workers workers : policeStation.getWorkers()) {
//					if (workers instanceof Boss) {
//						BDWorkers.insertIntoPrepStatBoss((Boss) workers);
//					}
//				}
//			}
//		});
//		
//		ShowDataBoss.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					ArrayList<Object[]> datosBoss = new ArrayList<Object[]>();
//					datosBoss = BDWorkers.consultarDatosBoss("WorkersTableBoss");
//
//					for (int i = 0; i < datosBoss.size(); i++) {
//						modelWorkers.addRow(datosBoss.get(i));
//					}
//					tableWorkers.setModel(modelWorkers);
//
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}
//		});
//
//		saveDataDetained.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				for (Detained detained : policeStation.getDetained()) {
//					if (detained instanceof Arrested) {
//						BDetained.insertIntoPrepStat((Arrested) detained);
//					}
//				}
//
//			}
//		});
//		
//		ShowDataArrested.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					ArrayList<Object[]> datosArrested = new ArrayList<Object[]>();
//					datosArrested = BDetained.consultarDatosArrested("DetainedTable");
//
//					for (int i = 0; i < datosArrested.size(); i++) {
//						modelDetained.addRow(datosArrested.get(i));
//					}
//					tableDetained.setModel(modelDetained);
//
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}
//		});
//
//		saveDataFained.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				for (Detained detained : policeStation.getDetained()) {
//					if (detained instanceof Fined) {
//						BDetained.insertIntoPrepStatFained((Fined) detained);
//					}
//				}
//
//			}
//		});
//		
//		
//		ShowDataFained.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				try {
//					ArrayList<Object[]> datosFained = new ArrayList<Object[]>();
//					datosFained = BDetained.consultarDatosFained("FainedTable");
//
//					for (int i = 0; i < datosFained.size(); i++) {
//						modelDetained.addRow(datosFained.get(i));
//					}
//					tableDetained.setModel(modelDetained);
//
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
//		
//		
//		
//		
//		//Parte recursivo
//		ArrayList list = new ArrayList();
//
//		for (int i = 0; i < tableWorkers.getRowCount(); i++) {
//			list.add(tableWorkers.getName());
//		}
//		
//		
//		sortTable.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Collections.sort(list);
//				
//			}
//		});
//		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(modelWorkers);
//		tableWorkers.setRowSorter(sorter);

	}
}