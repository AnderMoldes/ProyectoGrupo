package Windows;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class MainWindow extends JFrame {

	JLabel image;
	JButton start;
	JTextPane title;

	public MainWindow() throws BadLocationException {

		title = new JTextPane();
		SimpleAttributeSet attrs = new SimpleAttributeSet();
		StyleConstants.setBold(attrs, true);
		title.getStyledDocument().insertString(title.getStyledDocument().getLength(),
				"¡Welcome to the police station!", attrs);

		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		title.setParagraphAttributes(center, false);

		title.setEditable(false);
		add(title, BorderLayout.NORTH);

		image = new JLabel(new ImageIcon("police_station.jpg"));
		add(image, BorderLayout.CENTER);

		start = new JButton("Get started with management");
		add(start, BorderLayout.SOUTH);

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GeneralWindow();
				dispose();

			}
		});

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("POLICE STATION");
		pack();
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					new MainWindow();
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

}