package windows;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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

import java.awt.event.*;

public class GeneralWindow extends JFrame {
	protected static final Workers worker = null;
	PoliceStation policeStation;

	JMenuBar bar;
	JMenu file;
	JMenu end;

	JMenuItem workers;
	JMenuItem vehicle;
	JMenuItem detained;


	JButton createWorkers;
	JButton consultWorkers;
	JButton consultDetained;
	JButton bClose;
	JButton bManageRelations;
	JButton bManageDetained;
	JButton bManageWorkers;
	JButton createBoss;
	JButton createArrested;
	JButton createFined;
	JButton delete;
//	JList listWorkers;
//	JList listBoss;
//	DefaultListModel modelWorkers;
//	DefaultListModel modelBoss;
//	JList listDetained;
//	DefaultListModel modelDetained;

	JLabel lbar;
	JProgressBar progress;

	public GeneralWindow() {

		setLayout(new GridLayout(3, 1));

		JPanel up = new JPanel();
		JPanel center = new JPanel();
		JPanel down = new JPanel();

		up.setLayout(new BorderLayout());
		center.setLayout(new BorderLayout());
		down.setLayout(new BorderLayout());

		policeStation = new PoliceStation();
		bar = new JMenuBar();

		file = new JMenu("File");

		
		
		end = new JMenu("Menu");

		workers = new JMenuItem("Workers");
		vehicle = new JMenuItem("Vehicles");
		detained = new JMenuItem("Detained");

		end.add(workers);
		end.add(detained);
		end.add(vehicle);


		bar.add(file);
		bar.add(end);
		

		

		vehicle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VehicleWindow();
				dispose();

			}
		});

		setJMenuBar(bar);

		JPanel ButtonPanel = new JPanel();

		createWorkers = new JButton("Create Normal Worker");
		createBoss = new JButton("Create a Boss");
		consultWorkers = new JButton("Consult Workers");

		ButtonPanel.add(createWorkers);
		ButtonPanel.add(consultWorkers);
		ButtonPanel.add(createBoss);

		JPanel ButtonPanel2 = new JPanel();

		createArrested = new JButton("Create Arrested");
		createFined = new JButton("Create Fined");
		consultDetained = new JButton("Consult Detained");

		ButtonPanel2.add(createArrested);
		ButtonPanel2.add(createFined);
		ButtonPanel2.add(consultDetained);


		JPanel UP = new JPanel();
		UP.add(up);
		UP.add(center);
		UP.add(down);

		JPanel DOWN = new JPanel();

		bClose = new JButton("Close Window");
		
		
		delete = new JButton("Delete");
		bManageRelations = new JButton("Manage Relations");
		bManageWorkers = new JButton("Manage Workers");
		bManageDetained = new JButton("Manage Detained");

		DOWN.add(bManageRelations, BorderLayout.CENTER);
		DOWN.add(bManageWorkers, BorderLayout.CENTER);
		DOWN.add(bManageDetained, BorderLayout.CENTER);
		DOWN.add(delete, BorderLayout.CENTER);

		JPanel MOREDOWN = new JPanel();
		MOREDOWN.setLayout(new GridLayout(3, 1));
		lbar = new JLabel("Closing the window...");
		lbar.setVisible(false);
		progress = new JProgressBar(0, 100);
		progress.setVisible(false);

		bClose.setMinimumSize(new Dimension(20,20));
		bClose.setMaximumSize(new Dimension(150,60));
		bClose.setPreferredSize(new Dimension(120,30));
		
		MOREDOWN.add(bClose);
		MOREDOWN.add(lbar);
		MOREDOWN.add(progress);

		add(UP, BorderLayout.NORTH);
		add(DOWN, BorderLayout.CENTER);
		add(MOREDOWN, BorderLayout.SOUTH);
		MOREDOWN.setLayout(new FlowLayout());

		bClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {

						lbar.setVisible(true);
						progress.setVisible(true);

						for (int i = 0; i <= 100; i++) {
							progress.setValue(i);
							try {
								Thread.sleep(7);
							} catch (InterruptedException el) {
								el.printStackTrace();
							}
						}

						lbar.setVisible(false);
						progress.setVisible(false);
						dispose();
					}
				});

				thread.start();

			}
		});

//		modelWorkers = new DefaultListModel();
//		listWorkers = new JList(modelWorkers);
//		JScrollPane scrollWorkers = new JScrollPane(listWorkers);
		
		DefaultTableModel modelWorkers= new DefaultTableModel();
		modelWorkers.addColumn("code");
		modelWorkers.addColumn("grade");
		modelWorkers.addColumn("name");
		modelWorkers.addColumn("surname");
		modelWorkers.addColumn("gender");
		modelWorkers.addColumn("Specialty");
		modelWorkers.addColumn("startWorkingIn");
		modelWorkers.addColumn("Assesment");
		
		
		
		JTable table = new JTable(modelWorkers);
		JScrollPane scrollWorkers= new JScrollPane(table);

		up.add(scrollWorkers);
		up.add(ButtonPanel, BorderLayout.NORTH);

		createWorkers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new WorkersWindow(null, policeStation, null); //arreglar debido a la tabla
			}
		});

		createBoss.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new BossWindow(null, policeStation, null); //arreglar debido a la tabla
			}
		});

//		consultWorkers.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Workers workers = (Workers) listWorkers.getSelectedValue();
//
//				if (workers instanceof Boss) {
//					new BossWindow((Boss) workers, policeStation, modelWorkers);
//				} else {
//					new WorkersWindow(workers, policeStation, modelWorkers);
//				}
//			}
//		});
//		
//		listWorkers.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent evt) {
//				JList list = (JList) evt.getSource();
//				if (evt.getClickCount() == 2) {
//					Workers workers = (Workers) listWorkers.getSelectedValue();
//
//					if (workers instanceof Boss) {
//						new BossWindow((Boss) workers, policeStation, modelWorkers);
//					} else {
//						new WorkersWindow(workers, policeStation, modelWorkers);
//					}
//				}
//			}
//		});


//		modelDetained = new DefaultListModel();
//		listDetained = new JList(modelDetained);
//		JScrollPane scrollDetained = new JScrollPane(listDetained);
		
		DefaultTableModel modelDetained= new DefaultTableModel();
		modelDetained.addColumn("name");
		modelDetained.addColumn("LastName");
		modelDetained.addColumn("age");
		modelDetained.addColumn("gender");

		
		
		
		JTable tableDetained = new JTable(modelDetained);
		JScrollPane scrollDetained= new JScrollPane(tableDetained);

		center.add(scrollDetained);
		center.add(ButtonPanel2, BorderLayout.NORTH);

//		createArrested.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new ArrestedWindow(null, policeStation, modelDetained);  
//			}
//		});
//
//		
//		createFined.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new FainedWindow(null, policeStation, modelDetained);
//			}
//		});
//		
//		consultDetained.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Detained detained = (Detained) listDetained.getSelectedValue();
//
//				if (detained instanceof Arrested) {
//					new ArrestedWindow((Arrested) detained, policeStation, modelDetained);
//				} else if (detained instanceof Fined){
//					new FainedWindow((Fined)detained, policeStation, modelDetained);
//				}
//				
//			}
//		});
//		
//		listDetained.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent evt) {
//				JList list = (JList) evt.getSource();
//				if (evt.getClickCount() == 2) {
//					Detained detained = (Detained) listDetained.getSelectedValue();
//					 
//					if (detained instanceof Arrested) {
//						new ArrestedWindow((Arrested) detained, policeStation, modelDetained);
//					} else if (detained instanceof Fined){
//						new FainedWindow((Fined)detained, policeStation, modelDetained);
//					}
//				}
//			}
//		});
		


//		delete.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int question = JOptionPane.showConfirmDialog(null, "Are you sure that you want to delete this?");
//				if (question == 0) {
//					Workers worker = (Workers) listWorkers.getSelectedValue();
//					Workers boss = (Boss) listWorkers.getSelectedValue();
//					Detained arrested = (Arrested) listDetained.getSelectedValue();
//					Detained fined = (Fined) listDetained.getSelectedValue();
//
//					policeStation.getWorkers().remove(worker);
//					policeStation.getWorkers().remove(boss);
//					policeStation.getDetained().remove(arrested);
//					policeStation.getDetained().remove(fined);
//
//					modelWorkers.removeElement(worker);
//					modelWorkers.removeElement(boss);
//					modelDetained.removeElement(arrested);
//					modelDetained.removeElement(fined);
//
//				}
//
//			}
//		});
		

		

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("POLICE MANAGEMENT");
		setSize(1000,800);
		setResizable(true);
		setVisible(true);

	}
}
