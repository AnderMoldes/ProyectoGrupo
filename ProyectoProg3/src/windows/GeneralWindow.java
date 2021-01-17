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

		
		JMenuItem table = new JMenuItem("Create/Activate Tables");
		mnNewMenu.add(table);
		frame.getContentPane().setLayout(null);
		
		JMenuItem dropTables = new JMenuItem("Drop Tables");
		mnNewMenu.add(dropTables);
		frame.getContentPane().setLayout(null);

		JMenuItem vehicle = new JMenuItem("Vehicles");
		mnNewMenu.add(vehicle);
		frame.getContentPane().setLayout(null);
		

		JButton btnNewButton = new JButton(new ImageIcon("POLICIAS_Y_LADRONES_35.gif"));
		btnNewButton.setBounds(500, 65, 97, 130);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Vehicles");
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
		

		JButton buttonInfo =new JButton(new ImageIcon(((new ImageIcon("info.jpg").getImage()  .getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)))));
		buttonInfo.setBounds(24, 11, 34, 30);
		frame.getContentPane().add(buttonInfo);
		buttonInfo.setEnabled(true);
		
		buttonInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(buttonInfo, "The database was created / activated at the moment you entered the window.",
						"Database Info", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		
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
				frame.dispose();
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WindowDetained(null, police);
				frame.dispose();
			}
		});

		
		table.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BDWorkers.conection("WorkersTable");
				BDWorkers.conectionBoss("WorkersTableBoss");

				BDetained.conection("DetainedTable");
				BDetained.conectionFained("FainedTable");
				
			}
		});

		dropTables.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BDWorkers.dropTable("WorkersTable");
				BDWorkers.dropTable("WorkersTableBoss");
				BDetained.dropTable("DetainedTable");
				BDetained.dropTable("FainedTable");
				
			}
		});
		btnNewButton_2_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new WindowManageWorkers();
				frame.dispose();
			}
		});
		btnNewButton_2_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new WindowManageDetained(police);
				frame.dispose();
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VehicleWindow();
				frame.dispose();
			}
		});
		
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setTitle("POLICE MANAGEMENT");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo( null );



	}
}