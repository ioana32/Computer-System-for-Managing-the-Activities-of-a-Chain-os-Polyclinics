package prBD;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Login_superadmin extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_superadmin frame = new Login_superadmin();
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
	public Login_superadmin() {
		setTitle("Policlinica");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\PROIECT BD\\hospital-plus-logo-914E10A64D-seeklogo.com.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AUTENTIFICARE SUPER-ADMIN");
		lblNewLabel.setForeground(new Color(0, 51, 204));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 40));
		lblNewLabel.setBounds(0, 20, 637, 88);
		contentPane.add(lblNewLabel);
		
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 17));
		user.setBounds(135, 271, 367, 43);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(144, 229, 83, 32);
		contentPane.add(lblNewLabel_1);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pass.setBounds(135, 375, 367, 43);
		contentPane.add(pass);
		
		JLabel lblNewLabel_2 = new JLabel("Parola");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(135, 340, 114, 25);
		contentPane.add(lblNewLabel_2);
		
		JButton btnlogin = new JButton("Logare");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					Statement stmt=con.createStatement();
					String sql="Select * from utilizatori where tip='superadmin' and  id_utilizator='"+user.getText()+"' and parola='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
						superadmin1 sad1=new superadmin1();
						sad1.show();
						dispose();
						JOptionPane.showMessageDialog(null,"Login Successfully ");
					}
					else
						JOptionPane.showMessageDialog(null,"Wrong id and password ");
					con.close();
				}catch(Exception e) {System.out.print(e);}
			}
		});
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnlogin.setBounds(432, 492, 142, 61);
		contentPane.add(btnlogin);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principala p1=new principala();
				p1.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(51, 492, 126, 61);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\PROIECT BD\\giphy (1).gif"));
		lblNewLabel_3.setBounds(0, -11, 663, 627);
		contentPane.add(lblNewLabel_3);
	}
}
