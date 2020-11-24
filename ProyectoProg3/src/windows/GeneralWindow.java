package windows;

import javax.swing.*;
import java.awt.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import classes.Boss;
import classes.Detained;
import classes.PoliceStation;
import classes.Workers;

import java.awt.event.*;

public class GeneralWindow extends JFrame {
	protected static final Workers worker = null;
	PoliceStation policeStation;
	
	JMenuBar bar;
	JMenu file;
	JMenu close;
	JMenu end;
	
	JMenuItem workers;
	JMenuItem vehicle;
	JMenuItem detained;
	
	JMenuItem closeWindow;
	
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
	JList listWorkers;
	JList listBoss;
	DefaultListModel modelWorkers;
	DefaultListModel modelBoss;
	JList listDetained;
	DefaultListModel modelDetained;
	
	
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
		
		close = new JMenu("Close");
		closeWindow = new JMenuItem("Close this window");

		end = new JMenu("Menu");
		
		workers = new JMenuItem ("Workers");
		vehicle = new JMenuItem ("Vehicles");
		detained = new JMenuItem ("Detained");
		
		end.add(workers);
		end.add(detained);
		end.add(vehicle);
		

		close.add(closeWindow);

		
		bar.add(file);
		bar.add(end);
		bar.add(close);

		closeWindow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		
		vehicle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VehicleWindow();
				
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

		modelDetained = new DefaultListModel();
		listDetained = new JList(modelDetained);
		JScrollPane scrollDetained = new JScrollPane(listDetained);
		
		createArrested.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ArrestedWindow(null, policeStation, modelDetained);
			}});
		
		listDetained.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        	Detained arrested = (Detained) listDetained.getSelectedValue();
		        	new ArrestedWindow(null, policeStation, modelDetained);
					
					
		        }		    
		    }
		});
		createFined.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FainedWindow(null, policeStation, modelDetained);
			}});
		
		listDetained.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        	Detained fined = (Detained) listDetained.getSelectedValue();
		        	new FainedWindow(null, policeStation, modelDetained);
					
					
		        }		    
		    }
		});
		
		
		
		center.add(scrollDetained);
		center.add(ButtonPanel2, BorderLayout.NORTH);


		JPanel UP = new JPanel();
		UP.add(up);
		UP.add(center);
		UP.add(down);

		JPanel DOWN = new JPanel();

		bClose = new JButton("Close Window");
		
		bManageRelations = new JButton("Manage Relations");
		bManageWorkers= new JButton("Manage Workers");
		bManageDetained = new JButton("Manage Detained");
		
		
		DOWN.add(bManageRelations, BorderLayout.CENTER);
		DOWN.add(bManageWorkers, BorderLayout.CENTER);
		DOWN.add(bManageDetained, BorderLayout.CENTER);
		
		

		JPanel MOREDOWN = new JPanel();
		MOREDOWN.setLayout(new GridLayout(3, 1));
		lbar = new JLabel("Closing the window...");
		lbar.setVisible(false);
		progress = new JProgressBar(0, 100);
		progress.setVisible(false);

		MOREDOWN.add(bClose, BorderLayout.CENTER);
		MOREDOWN.add(lbar);
		MOREDOWN.add(progress);

		add(UP, BorderLayout.NORTH);
		add(DOWN, BorderLayout.CENTER);
		add(MOREDOWN, BorderLayout.SOUTH);

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
		
		modelWorkers = new DefaultListModel();
		listWorkers = new JList(modelWorkers);
		JScrollPane scrollWorkers = new JScrollPane(listWorkers);

		up.add(scrollWorkers);
		up.add(ButtonPanel, BorderLayout.NORTH);
		
		
		createWorkers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new WorkersWindow(null, policeStation, modelWorkers);
			}});
		//Error al modificar los workers normales
		listWorkers.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 1) {
		        	Workers workers = (Workers) listWorkers.getSelectedValue();
		        	new WorkersWindow(workers, policeStation, modelWorkers);
					
					
		        }		    
		    }
		});
		
		listBoss = new JList(modelWorkers);
		JScrollPane scrollBoss = new JScrollPane(listBoss);

		up.add(scrollBoss);
		up.add(ButtonPanel, BorderLayout.NORTH);
		
		createBoss.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new BossWindow(null, policeStation, modelWorkers);
			}});
		
		listBoss.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        	Boss boss = (Boss) listBoss.getSelectedValue();
		        	new BossWindow(boss, policeStation, modelWorkers);
					
					
		        }		    
		    }
		});
		
		
		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("POLICE MANAGEMENT");
		pack();
		setResizable(false);
		setVisible(true);

	}
}
