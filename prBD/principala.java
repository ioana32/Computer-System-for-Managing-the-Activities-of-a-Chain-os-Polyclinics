package prBD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class principala extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principala frame = new principala();
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
	public principala() {
		setFont(new Font("Dialog", Font.PLAIN, 11));
		setForeground(Color.BLUE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\PROIECT BD\\hospital-plus-logo-914E10A64D-seeklogo.com.png"));
		setAlwaysOnTop(true);
		setTitle("Policlinica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 678);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gestiunea resurselor umane");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modul1_1 m1=new modul1_1();
				m1.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(156, 117, 347, 51);
		contentPane.add(btnNewButton);
		
		JButton btnModul = new JButton("Opera\u0163ii financiar contabile  ");
		btnModul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Financiar m2=new Financiar();
				m2.show();
				dispose();
			}
		});
		btnModul.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModul.setBounds(156, 212, 347, 51);
		contentPane.add(btnModul);
		
		JButton btnModul_1 = new JButton("Gestiunea activit\u0103\u021Bilor opera\u021Bionale");
		btnModul_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modul3_1 m3=new modul3_1();
				m3.show();
				dispose();
			}
		});
		btnModul_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModul_1.setBounds(156, 307, 347, 51);
		contentPane.add(btnModul_1);
		
		JButton btnAdministrator = new JButton("Administrator");
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_admin l4=new Login_admin();
				l4.show();
				dispose();
			}
		});
		btnAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdministrator.setBounds(156, 409, 347, 51);
		contentPane.add(btnAdministrator);
		
		JButton btnSuperAdministrator = new JButton("Super Administrator");
		btnSuperAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_superadmin l5=new Login_superadmin();
				l5.show();
				dispose();
			}
			
		});
		btnSuperAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSuperAdministrator.setBounds(156, 507, 347, 51);
		contentPane.add(btnSuperAdministrator);
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vaccin vac= new Vaccin();
				vac.show();
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Ioana\\Downloads\\whatsapp-image-2021-01-11-at-1.jpg"));
		btnNewButton_1.setBounds(536, 540, 80, 80);
		contentPane.add(btnNewButton_1);
		JLabel lblNewLabel = new JLabel("POLICLINICA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 55));
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setBounds(111, 10, 445, 97);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\PROIECT BD\\giphy (1).gif"));
		lblNewLabel_1.setBounds(0, 0, 660, 641);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
