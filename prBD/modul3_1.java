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

public class modul3_1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modul3_1 frame = new modul3_1();
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
	public modul3_1() {
		setTitle("Policlinica");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\PROIECT BD\\hospital-plus-logo-914E10A64D-seeklogo.com.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656,658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("RECEPTIONER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_receptioner3 lr3=new Login_receptioner3();
				lr3.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(126, 172, 386, 74);
		contentPane.add(btnNewButton);
		
		JButton btnMedic = new JButton("MEDIC");
		btnMedic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginMedic3 lm3=new LoginMedic3();
				lm3.show();
				dispose();
			}
		});
		btnMedic.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnMedic.setBounds(126, 290, 386, 74);
		contentPane.add(btnMedic);
		
		JButton btnAsistentMedical = new JButton("ASISTENT MEDICAL");
		btnAsistentMedical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAsistent3 la3=new LoginAsistent3();
				la3.show();
				dispose();
			}
		});
		btnAsistentMedical.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnAsistentMedical.setBounds(126, 418, 386, 74);
		contentPane.add(btnAsistentMedical);
		
		JLabel lblNewLabel = new JLabel("Te logezi ca:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 51, 204));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 55));
		lblNewLabel.setBounds(67, 10, 516, 86);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\PROIECT BD\\giphy (1).gif"));
		lblNewLabel_1.setBounds(0, -13, 676, 651);
		contentPane.add(lblNewLabel_1);
	}

}
