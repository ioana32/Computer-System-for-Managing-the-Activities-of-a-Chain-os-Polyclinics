package prBD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class modul1_1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modul1_1 frame = new modul1_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public modul1_1() {
		setTitle("Policlinica");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\PROIECT BD\\hospital-plus-logo-914E10A64D-seeklogo.com.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Administrator resurse umane");
		btnNewButton.setBounds(143, 162, 370, 59);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_resurse_umane lru=new Login_resurse_umane();
				lru.show();
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Angajat*");
		btnNewButton_1.setBounds(143, 362, 370, 59);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Angajat lr1=new Angajat();
				lr1.show();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNewButton_1);
		
		JButton btnEconomic = new JButton("Administrator economic");
		btnEconomic.setBounds(143, 266, 370, 59);
		btnEconomic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Economic le=new Login_Economic();
				le.show();
				dispose();
			}
		});
		btnEconomic.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnEconomic);
		
		JLabel lblNewLabel = new JLabel("Te logezi ca:");
		lblNewLabel.setBounds(102, 0, 411, 106);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 50));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("*Angajat al unitatii medicale: receptioner, medic, asistent");
		lblNewLabel_1.setBounds(32, 556, 470, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\PROIECT BD\\giphy (1).gif"));
		lblNewLabel_2.setBounds(0, -11, 686, 617);
		contentPane.add(lblNewLabel_2);
	}
}
