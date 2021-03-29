package prBD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Angajat extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	private JPasswordField passwordField;
	private JTextField D;
	private JTextField Dinceput;
	private JTextField Dfinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Angajat frame = new Angajat();
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

	public Angajat() {
		setTitle("Policlinica");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\PROIECT BD\\hospital-plus-logo-914E10A64D-seeklogo.com.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(268, 60, 372, 275);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.PLAIN, 12));
		id.setBounds(138, 113, 100, 20);
		getContentPane().add(id);
		id.setColumns(10);

		JLabel txtId = new JLabel("ID");
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setBounds(28, 113, 100, 20);
		getContentPane().add(txtId);

		JLabel lblParola = new JLabel("PAROLA");
		lblParola.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblParola.setBounds(28, 167, 100, 20);
		getContentPane().add(lblParola);

		passwordField = new JPasswordField();
		passwordField.setBounds(138, 167, 100, 20);
		getContentPane().add(passwordField);

		JButton ProgramAfisare = new JButton("Afisare program");
		ProgramAfisare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql = "SELECT datapr AS 'Data', ora_incepere AS 'Ora inceput', ora_plecare AS 'Ora final', Unit.denumire AS 'Unitatea'"
							+ " FROM Utilizatori U, Angajat A, programangajati Pr, unitati_medicale AS Unit"
							+ " WHERE U.id_ca_angajat = A.id_angajat AND A.id_angajat = Pr.id_ca_angajat AND id_unitate_medicala = Pr.unitate"
							+ " AND id_utilizator = '" + id.getText() + "' AND parola = '" + passwordField.getText()
							+ "'" + " AND concediu = 0 ORDER BY datapr";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next())
						table.setModel(DbUtils.resultSetToTableModel(rs));

					connection.close();
				} catch (Exception e1) {
					System.out.print("Nu sunt date de afisat");
				}
			}
		});
		ProgramAfisare.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ProgramAfisare.setBackground(new Color(216, 191, 216));
		ProgramAfisare.setBounds(28, 229, 190, 35);
		getContentPane().add(ProgramAfisare);

		JButton btnAfisareConcediu = new JButton("Afisare concediu");
		btnAfisareConcediu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql = "SELECT datapr AS 'Data'"
							+ " FROM Utilizatori U, Angajat A, programangajati Pr, unitati_medicale AS Unit"
							+ " WHERE U.id_ca_angajat = A.id_angajat AND A.id_angajat = Pr.id_ca_angajat AND id_unitate_medicala = Pr.unitate"
							+ " AND id_utilizator = '" + id.getText() + "' AND parola = '" + passwordField.getText()
							+ "'" + "AND concediu = 1 ORDER BY datapr";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					// if(rs.next())
					table.setModel(DbUtils.resultSetToTableModel(rs));

					connection.close();
				} catch (Exception e1) {
					System.out.print("Nu sunt date de afisat");
				}
			}
		});
		btnAfisareConcediu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAfisareConcediu.setBackground(new Color(216, 191, 216));
		btnAfisareConcediu.setBounds(28, 288, 190, 35);
		getContentPane().add(btnAfisareConcediu);

		JLabel lblNewLabel = new JLabel("Introduceti o data calendaristica pentru a afisa programul");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(28, 394, 612, 20);
		getContentPane().add(lblNewLabel);

		D = new JTextField();
		D.setFont(new Font("Tahoma", Font.PLAIN, 12));
		D.setText("AN-LUNA-ZI");
		D.setBounds(28, 445, 100, 20);
		getContentPane().add(D);
		D.setColumns(10);

		JButton cautareZi = new JButton("Afisare program");
		cautareZi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql = "SELECT CONCAT(ora_incepere, ' - ', ora_plecare) AS 'Program', Unit.denumire AS 'Unitatea'"
							+ " FROM Utilizatori U, Angajat A, programangajati Pr, unitati_medicale AS Unit"
							+ " WHERE concediu = 0 AND U.id_ca_angajat = A.id_angajat AND A.id_angajat = Pr.id_ca_angajat AND id_unitate_medicala = Pr.unitate"
							+ " AND id_angajat = '" + id.getText() + "' AND parola = '" + passwordField.getText() + "'"
							+ "AND datapr = '" + D.getText() + "'";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					// if(rs.next())
					table.setModel(DbUtils.resultSetToTableModel(rs));
					String sql2 = "call verificareAconcediu('" + id.getText() + "', '" + passwordField.getText()
							+ "', '" + D.getText() + "')";
					Statement stmt2 = connection.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sql2);
					if (rs2.next() && rs2.getString("concediu").equals("1")) {
						JOptionPane.showMessageDialog(null, "Perioada de concediu");
					}
					connection.close();
				} catch (Exception e1) {
					System.out.print("Nu sunt date de afisat");
				}
			}
		});
		cautareZi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cautareZi.setBackground(new Color(255, 222, 173));
		cautareZi.setBounds(450, 435, 190, 35);

		getContentPane().add(cautareZi);

		JLabel lblNewLabel_1 = new JLabel("Sau introduceti o perioada");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(28, 504, 612, 20);
		getContentPane().add(lblNewLabel_1);

		Dinceput = new JTextField();
		Dinceput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Dinceput.setText("Data de inceput");
		Dinceput.setColumns(10);
		Dinceput.setBounds(28, 551, 100, 20);
		getContentPane().add(Dinceput);

		JLabel lblNewLabel_2 = new JLabel("    -");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(113, 550, 34, 20);
		getContentPane().add(lblNewLabel_2);

		Dfinal = new JTextField();
		Dfinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Dfinal.setText("Data de final");
		Dfinal.setColumns(10);
		Dfinal.setBounds(145, 551, 100, 20);
		getContentPane().add(Dfinal);

		JButton cautareProgram = new JButton("Afisare program");
		cautareProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql = "SELECT datapr AS 'Data', CONCAT(ora_incepere, ' - ', ora_plecare) AS 'Program', Unit.denumire AS 'Unitatea'"
							+ " FROM Utilizatori U, Angajat A, programangajati Pr, unitati_medicale AS Unit"
							+ " WHERE concediu = 0 AND U.id_ca_angajat = A.id_angajat AND A.id_angajat = Pr.id_ca_angajat AND id_unitate_medicala = Pr.unitate"
							+ " AND id_utilizator = '" + id.getText() + "' AND parola = '" + passwordField.getText()
							+ "'" + "AND datapr BETWEEN '" + Dinceput.getText() + "' AND '" + Dfinal.getText()
							+ "' ORDER BY datapr";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					// if(rs.next())
					table.setModel(DbUtils.resultSetToTableModel(rs));

					connection.close();
				} catch (Exception e1) {
					System.out.print("Nu sunt date de afisat");
				}
			}
		});
		cautareProgram.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cautareProgram.setBackground(new Color(255, 222, 173));
		cautareProgram.setBounds(450, 541, 190, 35);
		getContentPane().add(cautareProgram);

		JButton btn_back1_1_1 = new JButton("BACK");
		btn_back1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principala m1_1 = new principala();
				m1_1.show();
				dispose();
			}
		});
		btn_back1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_back1_1_1.setBackground(new Color(245, 245, 245));
		btn_back1_1_1.setBounds(450, 618, 190, 35);
		getContentPane().add(btn_back1_1_1);

		JLabel lblNewLabel_3 = new JLabel("Va rugam introduceti datele");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(28, 56, 229, 20);
		getContentPane().add(lblNewLabel_3);

		JButton AfisareProgramari = new JButton("Afisare programari ");
		AfisareProgramari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql = "SELECT CONCAT(ora_incepere, ' ', ora_plecare) AS 'Programare', Unit.denumire AS 'Unitatea',"
							+ " echipament_necesar AS 'Echipament'"
							+ " FROM Utilizatori U, Angajat A, programangajati Pr, unitati_medicale AS Unit, programari PrP, servicii S"
							+ " WHERE U.id_ca_angajat = A.id_angajat AND A.id_angajat = Pr.id_ca_angajat AND id_unitate_medicala = Pr.unitate"
							+ " AND PrP.unitatea = id_unitate_medicala AND PrP.medicul = id_angajat AND PrP.id_serviciupr = id_servicii"
							+ " AND id_utilizator = '" + id.getText() + "' AND parola = '" + passwordField.getText()
							+ "'" + " AND datapr = '" + D.getText() + "'";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					// if(rs.next())
					table.setModel(DbUtils.resultSetToTableModel(rs));

					connection.close();
				} catch (Exception e1) {
					System.out.print("Nu sunt date de afisat");
				}
			}
		});
		AfisareProgramari.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AfisareProgramari.setBackground(new Color(205, 92, 92));
		AfisareProgramari.setBounds(224, 435, 208, 35);
		getContentPane().add(AfisareProgramari);
	}
}
