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
	
	JButton crearJinete;
	JButton consultarJinetes;
	JButton campeonato;
	JButton crearEmpleado;
	JButton consultarEmpleados;
	JButton bCerrar;
	JButton bgestionarRelaciones;
	JButton bgestionarCaballos;
	JButton bvalorarEmpleados;
	JList listaJinetes;
	DefaultListModel modeloJinetes;
	JList listaCaballos;
	DefaultListModel modeloCaballos;
	DefaultListModel modeloEmpleado;
	JList listaEmpleado;
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

		file = new JMenu("Fichero");
		
		close = new JMenu("Cerrar");
		cerrarPestaña = new JMenuItem("Cerrar esta ventana");

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

		crearJinete = new JButton("Crear Jinete");
		consultarJinetes = new JButton("Consultar Jinetes");

		panelBotones.add(crearJinete);
		panelBotones.add(consultarJinetes);

		modeloJinetes = new DefaultListModel();
		listaJinetes = new JList(modeloJinetes);
		JScrollPane scrollJinetes = new JScrollPane(listaJinetes);

		arriba.add(scrollJinetes);
		arriba.add(panelBotones, BorderLayout.NORTH);

		JPanel panelBotones2 = new JPanel();

		JButton crearCaballo = new JButton("Crear Caballo");
		JButton consultarCaballos = new JButton("Consultar Caballos");

		panelBotones2.add(crearCaballo);
		panelBotones2.add(consultarCaballos);

		modeloCaballos = new DefaultListModel();
		listaCaballos = new JList(modeloCaballos);
		JScrollPane scroolCaballos = new JScrollPane(listaCaballos);

		centro.add(scroolCaballos);
		centro.add(panelBotones2, BorderLayout.NORTH);

		campeonato = new JButton("Carrera");

		JPanel panelabajo = new JPanel();
		crearEmpleado = new JButton("Crear Empleado");
		consultarEmpleados = new JButton("Consultar Empleados");

		panelabajo.add(crearEmpleado);
		panelabajo.add(consultarEmpleados);

		modeloEmpleado = new DefaultListModel();
		listaEmpleado = new JList(modeloEmpleado);
		JScrollPane scrollEmpleado = new JScrollPane(listaEmpleado);

		abajo.add(panelabajo, BorderLayout.NORTH);
		abajo.add(scrollEmpleado);

		JPanel arribaTotal = new JPanel();
		arribaTotal.add(arriba);
		arribaTotal.add(centro);
		arribaTotal.add(abajo);

		JPanel abajoTotal = new JPanel();

		bCerrar = new JButton("Cerrar Ventana");
		bgestionarRelaciones = new JButton("Gestionar Relaciones");
		bgestionarCaballos = new JButton("Gestionar Caballos");
		bvalorarEmpleados = new JButton("Valorar Empleados");
		abajoTotal.add(campeonato, BorderLayout.CENTER);
		abajoTotal.add(bgestionarRelaciones, BorderLayout.CENTER);
		abajoTotal.add(bgestionarCaballos, BorderLayout.CENTER);
		abajoTotal.add(bvalorarEmpleados, BorderLayout.CENTER);

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
		setTitle("CREACIÓN Y ORGANIZACIÓN");
		pack();
		setResizable(false);
		setVisible(true);

	}
}
