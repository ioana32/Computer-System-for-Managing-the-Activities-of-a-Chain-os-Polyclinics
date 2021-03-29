package prBD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Vaccin extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField nume;
	private JTextField prenume;
	private JTextField acord;
	private JPasswordField parola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vaccin frame = new Vaccin();
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

	Connection connection = null;

	public Vaccin() {
		setTitle("Policlinica - VACCINARE");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\PROIECT BD\\hospital-plus-logo-914E10A64D-seeklogo.com.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Pentru a va inregistra in vederea efectuarii vaccinului \"Pfizer\"");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(36, 55, 580, 20);
		contentPane.add(lblNewLabel);

		JLabel lblVaRugamSa = new JLabel("va rugam sa completati campurile urmatoare:");
		lblVaRugamSa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVaRugamSa.setBounds(36, 85, 580, 25);
		contentPane.add(lblVaRugamSa);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(36, 165, 100, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("Va multumim pentru alegerea facuta!");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(343, 441, 343, 30);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_1_1 = new JLabel("Nume");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(36, 215, 100, 20);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Prenume");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(36, 265, 100, 20);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Sunt de acord cu vaccinarea");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(36, 315, 261, 20);
		contentPane.add(lblNewLabel_1_3);

		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		id.setBounds(484, 165, 100, 20);
		contentPane.add(id);
		id.setColumns(10);

		nume = new JTextField();
		nume.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nume.setColumns(10);
		nume.setBounds(484, 216, 100, 20);
		contentPane.add(nume);

		prenume = new JTextField();
		prenume.setFont(new Font("Tahoma", Font.PLAIN, 16));
		prenume.setColumns(10);
		prenume.setBounds(484, 265, 100, 20);
		contentPane.add(prenume);

		acord = new JTextField();
		acord.setText("DA/NU");
		acord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		acord.setColumns(10);
		acord.setBounds(484, 315, 100, 20);
		contentPane.add(acord);

		JLabel lblNewLabel_1_4 = new JLabel("Parola");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(36, 365, 100, 20);
		contentPane.add(lblNewLabel_1_4);

		parola = new JPasswordField();
		parola.setBounds(484, 365, 100, 20);
		contentPane.add(parola);

		JButton btnNewButton = new JButton("Trimite");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql = "UPDATE Utilizatori SET vaccin = '" + acord.getText() + "' WHERE id_utilizator = " + id.getText()+" ";
					PreparedStatement pst=con.prepareStatement(sql);
					
					pst.execute(sql);
					//ResultSet rs = stmt.executeQuery(sql);
					
					if (pst!=null) {
						JOptionPane.showMessageDialog(null, "Modificare efectuata cu succes");
						connection.close();
					}
					else {
						JOptionPane.showMessageDialog(null, "Datele introduse nu sunt corecte");
					}
				} catch (Exception e1) {
					
				}
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(453, 395, 135, 35);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Nota: sunt acceptate modificari ulterioare.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(408, 10, 318, 20);
		contentPane.add(lblNewLabel_2);
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principala vpr= new principala();
				vpr.show();
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(607, 632, 79, 21);
		contentPane.add(btnNewButton_1);
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Ioana\\Downloads\\Webp.net-resizeimage (1).jpg"));
		lblNewLabel_3.setBounds(0, 384, 686, 309);
		contentPane.add(lblNewLabel_3);
		
		
	}
}
