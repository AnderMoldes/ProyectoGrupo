package windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TruckWindow extends JFrame{
	//Declaramos
	JPanel panelPhoto;
	JPanel panelText;
	
	JLabel image;
	
	JTextArea text;
	JButton back;
	
    
	
	public TruckWindow() {
		JPanel panelPhoto = new JPanel();
		JPanel panelText = new JPanel();
		
		image = new JLabel(new ImageIcon("truck.jpg"));
		
		JTextArea text = new JTextArea();
		
		JButton back = new JButton("Back");	
		
		text.setEditable(false);
		/*Text Area en el que añadimos la información del vehiculo*/
		text.setText(" A police truck is, broadly, a large motor vehicle that is\n"
				+ " used for police and law enforcement duties. A police truck may be used for\n"
				+ " many different purposes. Four-wheel drive versions may be used for patrolling\n"
				+ " off-road areas such as mountains, forests, flooded areas, shorelines and beaches,\n"
				+ " where a police car has difficulty maneuvering. They can be used for transporting\n"
				+ " SWAT teams and often have facilities to securely detain and transport a small number\n"
				+ " of suspects. Sometimes, police agencies use trucks equipped with cages for animal control.");
		
		//Eventos
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		//Diseño
		this.setLayout(new GridLayout(2,1));
		panelPhoto.setLayout(new BorderLayout());
		
		panelPhoto.add(image, BorderLayout.CENTER);
		
		add(panelPhoto);
		add(panelText);
		
		panelPhoto.setLayout(new FlowLayout());
		
		panelText.setLayout(new BorderLayout());
		
		panelText.add(text, BorderLayout.CENTER);
		panelText.add(back, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("TRUCK");	
		pack();
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
}
}

