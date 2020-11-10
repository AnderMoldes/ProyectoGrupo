package Windows;

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

public class ArmoredVanWindow extends JFrame{

	JPanel panelPhoto;
	JPanel panelText;
	
	JLabel image;
	
	JTextArea text;
	JButton back;
	
    
	
	public ArmoredVanWindow(){
		JPanel panelPhoto = new JPanel();
		JPanel panelText = new JPanel();
		
		image = new JLabel(new ImageIcon("armoredvan.jpg"));
		
		JTextArea text = new JTextArea();
		
		JButton back = new JButton("Back");	
		
		text.setEditable(false);
		text.setText(" An armored van vehicle, also known as an armoured rescue vehicle, a vehicle\n"
				+ " used by police tactical units to respond to incidents. These are often non-military\n"
				+ " armored vehicles which offer protection to the passengers and can additionally be\n"
				+ " used to transport specialized equipment such as weapons and breaching tools.\n");
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
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
		setTitle("ARMORED VAN");	
		pack();
		setResizable(false);
		setVisible(true);
}
}
