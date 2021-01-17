package windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MotorBikeWindow extends JFrame {

	// Declaramos
	JPanel panelPhoto;
	JPanel panelText;
	JLabel image;
	JTextArea text;
	JButton back;

	public MotorBikeWindow() {
		JPanel panelPhoto = new JPanel();
		JPanel panelText = new JPanel();
		URL iconURL = getClass().getResource("/icons/motorbike.jpg");
		image = new JLabel(new ImageIcon(iconURL));

		JTextArea text = new JTextArea();

		JButton back = new JButton("Back");

		// Texto donde añadimos informacion sobre la moto
		text.setEditable(false);
		text.setText(" A police motorcycle is a motorcycle used by various police departments. They may be\n"
				+ " custom designed to meet the requirements unique of a particular use. A police motorcycle\n"
				+ " is often called a \"motor\" by police officers in the United States. Similarly, motorcycle\n"
				+ " units are known as \"motor units\" and motorcycle officers are known as motor officers.\r\n"
				+ "\r\n"
				+ " The maneuverability of the motorcycle on crowded streets offer advantages not provided by larger,\n"
				+ " more traditional police vehicles. The motorcycle's relatively small size allows it to get to\n"
				+ " accident scenes more quickly when incidents such as traffic collisions slow down access by\n"
				+ " four-wheel vehicles. Police motorcycles are also used in police funerals, VIP motorcades,\n"
				+ " and other special events.");

		// Eventos
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		// Diseño
		this.setLayout(new GridLayout(2, 1));
		panelPhoto.setLayout(new BorderLayout());

		panelPhoto.add(image, BorderLayout.CENTER);

		add(panelPhoto);
		add(panelText);

		panelPhoto.setLayout(new FlowLayout());

		panelText.setLayout(new BorderLayout());

		panelText.add(text, BorderLayout.CENTER);
		panelText.add(back, BorderLayout.SOUTH);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("MOTORBIKE");
		pack();
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
