package windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WindowManageDetained extends JFrame{
	private JPanel contentPane;
	
	public WindowManageDetained() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 662);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList listDetained = new JList();
		listDetained.setBackground(Color.WHITE);
		listDetained.setBounds(39, 232, 267, 340);
		contentPane.add(listDetained);
		
		JList listManage = new JList();
		listManage.setBackground(Color.WHITE);
		listManage.setBounds(468, 232, 267, 340);
		contentPane.add(listManage);
		
		JButton bmanageRight = new JButton("=>");
		bmanageRight.setBackground(Color.CYAN);
		bmanageRight.setForeground(Color.BLACK);
		bmanageRight.setBounds(316, 294, 142, 67);
		contentPane.add(bmanageRight);
		
		JButton bmanageLeft = new JButton("<=");
		bmanageLeft.setForeground(Color.BLACK);
		bmanageLeft.setBackground(Color.CYAN);
		bmanageLeft.setBounds(316, 412, 142, 67);
		contentPane.add(bmanageLeft);
		
		JComboBox comboWorkers = new JComboBox();
		comboWorkers.setBackground(Color.CYAN);
		comboWorkers.setForeground(Color.BLACK);
		comboWorkers.setBounds(39, 88, 696, 42);
		contentPane.add(comboWorkers);
		
		JLabel lworkers = new JLabel("Workers:");
		lworkers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lworkers.setForeground(Color.BLACK);
		lworkers.setBounds(39, 45, 667, 32);
		contentPane.add(lworkers);
		
		JLabel ldetained = new JLabel("Detained:");
		ldetained.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ldetained.setForeground(Color.BLACK);
		ldetained.setBounds(39, 187, 267, 34);
		contentPane.add(ldetained);
		
		JLabel lmanage = new JLabel("Manage:");
		lmanage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lmanage.setForeground(Color.BLACK);
		lmanage.setBounds(467, 187, 268, 34);
		contentPane.add(lmanage);
		
		JButton bback = new JButton("Back");
		bback.setBounds(340, 533, 89, 23);
		contentPane.add(bback);
		
		
		bback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GeneralWindow();
				dispose();
			}
		});
	}

}
