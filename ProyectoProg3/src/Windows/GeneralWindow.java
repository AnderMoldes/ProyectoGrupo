package Windows;

import javax.swing.*;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import java.awt.event.*;

public class GeneralWindow extends JFrame {

	JMenuBar bar;
	JMenu file;
	JMenu close;
	JMenu end;
	
	JMenuItem workers;
	JMenuItem vehicle;
	JMenuItem detained;
	
	JMenuItem cerrarPestaña;
	
	JButton createWorkers;
	JButton consultWorkers;
	JButton createDetained;
	JButton consultDetained;
	JButton bCerrar;
	JButton bgestionarRelaciones;
	JButton bmanageDetained;
	JButton bvalorateWorkers;
	JList listWorkers;
	DefaultListModel modelWorkers;
	JList listDetained;
	DefaultListModel modelDetained;
	
	
	JLabel lbarra;
	JProgressBar progreso;

	public GeneralWindow() {

		setLayout(new GridLayout(3, 1));

		JPanel arriba = new JPanel();
		JPanel centro = new JPanel();
		JPanel abajo = new JPanel();

		arriba.setLayout(new BorderLayout());
		centro.setLayout(new BorderLayout());
		abajo.setLayout(new BorderLayout());

		bar = new JMenuBar();

		file = new JMenu("File");
		
		close = new JMenu("Close");
		cerrarPestaña = new JMenuItem("Close this window");

		end = new JMenu("Menu");
		
		workers = new JMenuItem ("Workers");
		vehicle = new JMenuItem ("Vehicles");
		detained = new JMenuItem ("Detained");
		
		end.add(workers);
		end.add(detained);
		end.add(vehicle);
		

		close.add(cerrarPestaña);

		
		bar.add(file);
		bar.add(end);
		bar.add(close);

		cerrarPestaña.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		setJMenuBar(bar);

		JPanel panelBotones = new JPanel();

		createWorkers = new JButton("Create Worker");
		consultWorkers = new JButton("Consult Workers");

		panelBotones.add(createWorkers);
		panelBotones.add(consultWorkers);

		modelWorkers = new DefaultListModel();
		listWorkers = new JList(modelWorkers);
		JScrollPane scrollWorkers = new JScrollPane(listWorkers);

		arriba.add(scrollWorkers);
		arriba.add(panelBotones, BorderLayout.NORTH);

		JPanel panelBotones2 = new JPanel();

		JButton createDetained = new JButton("Create Detained");
		JButton consultDetained = new JButton("Consult Detained");

		panelBotones2.add(createDetained);
		panelBotones2.add(consultDetained);

		modelDetained = new DefaultListModel();
		listDetained = new JList(modelDetained);
		JScrollPane scrollDetained = new JScrollPane(listDetained);

		centro.add(scrollDetained);
		centro.add(panelBotones2, BorderLayout.NORTH);


		JPanel arribaTotal = new JPanel();
		arribaTotal.add(arriba);
		arribaTotal.add(centro);
		arribaTotal.add(abajo);

		JPanel abajoTotal = new JPanel();

		bCerrar = new JButton("Close Window");
		bgestionarRelaciones = new JButton("Manage Relations");
		bmanageDetained = new JButton("Manage Workers");
		bvalorateWorkers = new JButton("Valorate Workers");
		abajoTotal.add(bgestionarRelaciones, BorderLayout.CENTER);
		abajoTotal.add(bmanageDetained, BorderLayout.CENTER);
		abajoTotal.add(bvalorateWorkers, BorderLayout.CENTER);

		JPanel abajoFinal = new JPanel();
		abajoFinal.setLayout(new GridLayout(3, 1));
		lbarra = new JLabel("Cerrando la ventana...");
		lbarra.setVisible(false);
		progreso = new JProgressBar(0, 100);
		progreso.setVisible(false);

		abajoFinal.add(bCerrar, BorderLayout.CENTER);
		abajoFinal.add(lbarra);
		abajoFinal.add(progreso);

		add(arribaTotal, BorderLayout.NORTH);
		add(abajoTotal, BorderLayout.CENTER);
		add(abajoFinal, BorderLayout.SOUTH);

		bCerrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Thread hilo = new Thread(new Runnable() {
					@Override
					public void run() {

						lbarra.setVisible(true);
						progreso.setVisible(true);

						for (int i = 0; i <= 100; i++) {
							progreso.setValue(i);
							try {
								Thread.sleep(4);
							} catch (InterruptedException el) {
								el.printStackTrace();
							}
						}

						lbarra.setVisible(false);
						progreso.setVisible(false);
						dispose();

					}
				});

				hilo.start();

			}
		});

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("POLICE MANAGEMENT");
		pack();
		setResizable(false);
		setVisible(true);

	}
}
