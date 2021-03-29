package prBD;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Administrator_log extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField parola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator_log frame = new Administrator_log();
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
	public Administrator_log() {
		setTitle("Policlinica");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\PROIECT BD\\hospital-plus-logo-914E10A64D-seeklogo.com.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		user = new JTextField();
		user.setBounds(209, 189, 234, 43);
		user.setFont(new Font("Tahoma", Font.PLAIN, 20));
		user.setColumns(10);

		parola = new JPasswordField();
		parola.setBounds(207, 284, 236, 43);
		parola.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblNewLabel = new JLabel("Id: ");
		lblNewLabel.setBounds(167, 193, 45, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));

		JLabel lblParola = new JLabel("Parola: ");
		lblParola.setBounds(126, 288, 96, 31);
		lblParola.setFont(new Font("Tahoma", Font.PLAIN, 25));

		JLabel lblNewLabel_1 = new JLabel("Administrator financiar");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 51, 204));
		lblNewLabel_1.setBounds(92, 10, 414, 51);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));

		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setBounds(368, 407, 138, 43);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					Statement stmt = con.createStatement();
					String sql = "Select * from utilizatori where  id_utilizator='"+user.getText()+"' and parola='"+parola.getText().toString()+"' and tip='economic';";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						Administrator_financiar f = new Administrator_financiar();
						f.show();
						dispose();

						// JOptionPane.showMessageDialog(null,"Login Successfully ");
					} else
						JOptionPane.showMessageDialog(null, "Wrong id and password ");
					con.close();
				} catch (Exception e) {
					System.out.print(e);
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnNewButton_1 = new JButton("Inapoi");
		btnNewButton_1.setBounds(5, 465, 104, 43);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Financiar f = new Financiar();
				f.show();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblParola);
		contentPane.add(parola);
		contentPane.add(user);
		contentPane.add(lblNewLabel_1);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\PROIECT BD\\giphy (1).gif"));
		lblNewLabel_2.setBounds(0, 0, 600, 532);
		contentPane.add(lblNewLabel_2);
	}

}
