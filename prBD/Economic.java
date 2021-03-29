package prBD;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class Economic extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Economic frame = new Economic();
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
	private JTextField nume;
	private JTextField prenume;
	private JTextField functia;
	private JTextField datapr;
	private JTextField Dinceput;
	private JTextField Dfinal;
	private JTable table_program;
	private JTextField unit;
	private JTable table_2;
	private JTextField Cnume;
	private JTextField Cprenume;
	private JTextField Cfunctie;
	private JTextField Dinceput2;
	private JTextField Dfinal2;

	public Economic() {
		setTitle("Policlinica");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\PROIECT BD\\hospital-plus-logo-914E10A64D-seeklogo.com.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane Tabs = new JTabbedPane(JTabbedPane.TOP);
		Tabs.setBounds(2, 2, 684, 661);
		Tabs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(Tabs);

		JPanel CautareAngajat = new JPanel();
		Tabs.addTab("Cautare angajat", null, CautareAngajat, null);
		CautareAngajat.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(236, 72, 387, 203);
		CautareAngajat.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = table.getSelectedRow();
					String table_nume = (table.getModel().getValueAt(row, 0).toString());
					String table_prenume = (table.getModel().getValueAt(row, 1).toString());
					String table_functia = (table.getModel().getValueAt(row, 2).toString());
					nume.setText(table_nume);
					prenume.setText(table_prenume);
					functia.setText(table_functia);
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btn_cautare = new JButton("Cautare zi");
		btn_cautare.setBackground(new Color(147, 112, 219));
		btn_cautare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql = "SELECT ora_incepere AS 'Ora incepere' , ora_plecare AS 'Ora plecare', unit.denumire AS 'Unitate'"
							+ " FROM Utilizatori U, Angajat A, Programangajati Pr, Unitati_medicale unit"
							+ " WHERE U.id_ca_angajat = A.id_angajat AND Pr.id_ca_angajat = A.id_angajat AND Pr.unitate = unit.id_unitate_medicala"
							+ " AND concediu = 0 AND U.nume ='" + nume.getText() + "' AND U.prenume = '"
							+ prenume.getText() + "'" + " AND tip = '" + functia.getText() + "' AND datapr = '"
							+ datapr.getText() + "'";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));

					if (rs != null) {

					} else {
						String sql2 = "call verificare('" + nume.getText() + "', '" + prenume.getText() + "', '"
								+ functia.getText() + "', '" + datapr.getText() + "')";
						Statement stmt2 = connection.createStatement();
						ResultSet rs2 = stmt2.executeQuery(sql2);
						if (rs2.getString("concediu").equals("1")) {
							JOptionPane.showMessageDialog(null,
									"Angajatul este in concediu, va rugam verificati sectiunea -Concediu-");
						} else
							JOptionPane.showMessageDialog(null, "Datele introduse nu sunt corecte");
					}
					connection.close();
				} catch (Exception e) {
					System.out.print(e);
				}
			}
		});

		btn_cautare.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_cautare.setBounds(433, 297, 190, 35);
		CautareAngajat.add(btn_cautare);

		JButton btn_back1 = new JButton("BACK");
		btn_back1.setBackground(new Color(245, 245, 245));
		btn_back1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principala m1_1 = new principala();
				m1_1.show();
				dispose();
			}
		});
		btn_back1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_back1.setBounds(433, 563, 190, 35);
		CautareAngajat.add(btn_back1);

		nume = new JTextField();
		nume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nume.setBounds(111, 76, 100, 20);
		CautareAngajat.add(nume);
		nume.setColumns(10);

		prenume = new JTextField();
		prenume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		prenume.setBounds(111, 118, 100, 20);
		CautareAngajat.add(prenume);
		prenume.setColumns(10);

		functia = new JTextField();
		functia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		functia.setBounds(111, 168, 100, 20);
		CautareAngajat.add(functia);
		functia.setColumns(10);

		JLabel INume = new JLabel("NUME");
		INume.setFont(new Font("Tahoma", Font.PLAIN, 16));
		INume.setBounds(23, 73, 80, 20);
		CautareAngajat.add(INume);

		JLabel IPrenume = new JLabel("PRENUME");
		IPrenume.setFont(new Font("Tahoma", Font.PLAIN, 16));
		IPrenume.setBounds(23, 118, 80, 20);
		CautareAngajat.add(IPrenume);

		JLabel IFunctia = new JLabel("FUNCTIA");
		IFunctia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		IFunctia.setBounds(23, 165, 80, 20);
		CautareAngajat.add(IFunctia);

		JButton btn_dataC = new JButton("Cautare perioada");
		btn_dataC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql = "SELECT datapr AS 'Data', ora_incepere AS 'Ora incepere' , ora_plecare AS 'Ora plecare', unit.denumire AS 'Unitate'"
							+ " FROM Utilizatori U, Angajat A, Programangajati Pr, Unitati_medicale unit"
							+ " WHERE U.id_ca_angajat = A.id_angajat AND concediu = 0 AND Pr.id_ca_angajat = A.id_angajat AND Pr.unitate = unit.id_unitate_medicala"
							+ " AND U.nume ='" + nume.getText() + "' AND U.prenume = '" + prenume.getText() + "'"
							+ " AND tip = '" + functia.getText() + "' AND datapr BETWEEN  '" + Dinceput.getText()
							+ "' AND '" + Dfinal.getText() + "'";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					connection.close();
				} catch (Exception e) {
					System.out.print(e);
				}
			}
		});
		btn_dataC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_dataC.setBackground(new Color(147, 112, 219));
		btn_dataC.setBounds(433, 341, 190, 35);
		CautareAngajat.add(btn_dataC);

		datapr = new JTextField();
		datapr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		datapr.setBounds(111, 309, 100, 20);
		CautareAngajat.add(datapr);
		datapr.setColumns(10);

		Dinceput = new JTextField();
		Dinceput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Dinceput.setText("Data de inceput");
		Dinceput.setBounds(111, 353, 100, 20);
		CautareAngajat.add(Dinceput);
		Dinceput.setColumns(10);

		Dfinal = new JTextField();
		Dfinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Dfinal.setText("Data de final");
		Dfinal.setBounds(250, 353, 100, 20);
		CautareAngajat.add(Dfinal);
		Dfinal.setColumns(10);

		JLabel lblNewLabel = new JLabel("DATA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(23, 312, 80, 20);
		CautareAngajat.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PERIOADA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(23, 353, 80, 20);
		CautareAngajat.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("    -");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(207, 353, 45, 20);
		CautareAngajat.add(lblNewLabel_2);

		JButton btn_cautare_1 = new JButton("Cautare angajat*");
		btn_cautare_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql = "SELECT ora_incepere AS 'Ora incepere' , ora_plecare AS 'Ora plecare', unit.denumire AS 'Unitate'"
							+ " FROM Utilizatori U, Angajat A, Programangajati Pr, Unitati_medicale unit"
							+ " WHERE U.id_ca_angajat = A.id_angajat AND Pr.id_ca_angajat = A.id_angajat AND Pr.unitate = unit.id_unitate_medicala"
							+ " AND U.nume ='" + nume.getText() + "' AND U.prenume = '" + prenume.getText() + "'"
							+ " AND tip = '" + functia.getText() + "' AND datapr = current_date()";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					if (rs.next()) {

					} else {
						String sql2 = "call vericare(" + nume.getText() + ", " + prenume.getText() + ", "
								+ functia.getText() + ", " + datapr.getText() + ")";
						Statement stmt2 = connection.createStatement();
						ResultSet rs2 = stmt2.executeQuery(sql2);
						if (rs2.next() && rs2.getString("concediu").equals("1")) {
							JOptionPane.showMessageDialog(null,
									"Angajatul este in concediu, va rugam verificati sectiunea -Concediu-");
						} else
							JOptionPane.showMessageDialog(null, "Datele introduse nu sunt corecte");
					}
					connection.close();
				} catch (Exception e2) {
					System.out.print(e2);
				}
			}
		});
		btn_cautare_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_cautare_1.setBackground(new Color(147, 112, 219));
		btn_cautare_1.setBounds(23, 224, 190, 35);
		CautareAngajat.add(btn_cautare_1);

		JButton btnNewButton_1 = new JButton("Afisare angajati");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql = "SELECT DISTINCT nume AS 'Nume', prenume AS 'Prenume', U.tip AS 'Functie'"
							+ " FROM Utilizatori U, Angajat A WHERE U.id_ca_angajat = A.id_angajat ORDER BY nume, prenume;";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} else
						JOptionPane.showMessageDialog(null, "Angajatul este in concediu");
					connection.close();
				} catch (Exception e1) {
					System.out.print(e1);
				}
			}
		});
		btnNewButton_1.setBackground(new Color(216, 191, 216));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(21, 563, 190, 35);
		CautareAngajat.add(btnNewButton_1);

		JLabel lblNewLabel_12 = new JLabel("*Se va afisa programul pentru ziua curenta.");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_12.setBounds(23, 255, 203, 20);
		CautareAngajat.add(lblNewLabel_12);

		// tab2
		JPanel OrarSaptamanal = new JPanel();
		Tabs.addTab("Orar saptamanal", null, OrarSaptamanal, null);
		OrarSaptamanal.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(44, 96, 585, 104);
		OrarSaptamanal.add(scrollPane_1);

		table_program = new JTable();
		table_program.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = table_program.getSelectedRow();
					String table_unitate = (table_program.getModel().getValueAt(row, 0).toString());
					unit.setText(table_unitate);
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
			}
		});
		table_program.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane_1.setViewportView(table_program);

		JLabel lblNewLabel_5 = new JLabel("PERIOADA");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(44, 256, 150, 20);
		OrarSaptamanal.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("UNITATE MEDICALA");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(44, 308, 150, 20);
		OrarSaptamanal.add(lblNewLabel_6);

		unit = new JTextField();
		unit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		unit.setBounds(243, 308, 150, 20);
		OrarSaptamanal.add(unit);
		unit.setColumns(10);

		JButton btn_back1_1 = new JButton("BACK");
		btn_back1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_back1_1.setBackground(new Color(245, 245, 245));
		btn_back1_1.setBounds(439, 567, 190, 35);
		OrarSaptamanal.add(btn_back1_1);

		JButton unitati = new JButton("Afisare unitati");
		unitati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql = "SELECT DISTINCT denumire AS 'Unitatea medicala', adresa AS 'Locatia'"
							+ " FROM unitati_medicale ORDER BY denumire;";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					table_program.setModel(DbUtils.resultSetToTableModel(rs));
					if (rs != null) {

					} else
						JOptionPane.showMessageDialog(null, "Nu exista unitati medicale de afisat");
					connection.close();
				} catch (Exception e1) {
					System.out.print(e1);
				}
			}
		});
		unitati.setFont(new Font("Tahoma", Font.PLAIN, 20));
		unitati.setBackground(new Color(216, 191, 216));
		unitati.setBounds(439, 299, 190, 35);
		OrarSaptamanal.add(unitati);

		JLabel lblNewLabel_7 = new JLabel("Introduceti datele mentionate pentru a afisa programul saptamanal ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(44, 31, 585, 20);
		OrarSaptamanal.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("al unei unitati medicale.");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(44, 50, 585, 20);
		OrarSaptamanal.add(lblNewLabel_8);

		Dinceput2 = new JTextField();
		Dinceput2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Dinceput2.setText("Data de inceput");
		Dinceput2.setColumns(10);
		Dinceput2.setBounds(243, 259, 100, 20);
		OrarSaptamanal.add(Dinceput2);

		Dfinal2 = new JTextField();
		Dfinal2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Dfinal2.setText("Data de inceput");
		Dfinal2.setColumns(10);
		Dfinal2.setBounds(377, 259, 100, 20);
		OrarSaptamanal.add(Dfinal2);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("    -");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1_1_2.setBounds(334, 256, 45, 20);
		OrarSaptamanal.add(lblNewLabel_2_1_1_2);

		JButton programUnit = new JButton("Afisare program");
		programUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql = "SELECT datapr AS 'Data', CONCAT(ora_deschidere, ' - ', ora_inchidere) AS 'Program' "
							+ "FROM unitati_medicale U, program P "
							+ "WHERE id_unitate_medicala = unitate AND U.denumire = '" + unit.getText() + "' "
							+ "AND P.datapr BETWEEN '" + Dinceput2.getText() + "' AND '" + Dfinal2.getText() + "';";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					table_program.setModel(DbUtils.resultSetToTableModel(rs));
					if (rs != null) {

					} else
						JOptionPane.showMessageDialog(null, "Datele introduse nu sunt corecte");

					connection.close();
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		programUnit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		programUnit.setBackground(new Color(216, 191, 216));
		programUnit.setBounds(439, 382, 190, 35);
		OrarSaptamanal.add(programUnit);

		// tab3
		JPanel Concediu = new JPanel();
		Tabs.addTab("Concediu", null, Concediu, null);
		Concediu.setLayout(null);

		JButton btn_back1_1_1 = new JButton("BACK");
		btn_back1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_back1_1_1.setBackground(new Color(245, 245, 245));
		btn_back1_1_1.setBounds(453, 537, 190, 35);
		Concediu.add(btn_back1_1_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(238, 49, 405, 245);
		Concediu.add(scrollPane_2);

		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = table_2.getSelectedRow();
					String table_nume = (table_2.getModel().getValueAt(row, 0).toString());
					String table_prenume = (table_2.getModel().getValueAt(row, 1).toString());
					String table_functia = (table_2.getModel().getValueAt(row, 2).toString());
					Cnume.setText(table_nume);
					Cprenume.setText(table_prenume);
					Cfunctie.setText(table_functia);
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
			}
		});

		Cnume = new JTextField();
		Cnume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Cnume.setColumns(10);
		Cnume.setBounds(112, 61, 100, 20);
		Concediu.add(Cnume);

		Cprenume = new JTextField();
		Cprenume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Cprenume.setColumns(10);
		Cprenume.setBounds(112, 112, 100, 20);
		Concediu.add(Cprenume);

		Cfunctie = new JTextField();
		Cfunctie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Cfunctie.setColumns(10);
		Cfunctie.setBounds(112, 164, 100, 20);
		Concediu.add(Cfunctie);

		JLabel INume_1 = new JLabel("NUME");
		INume_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		INume_1.setBounds(22, 61, 80, 20);
		Concediu.add(INume_1);

		JLabel IPrenume_1 = new JLabel("PRENUME");
		IPrenume_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		IPrenume_1.setBounds(22, 112, 80, 20);
		Concediu.add(IPrenume_1);

		JLabel IFunctia_1 = new JLabel("FUNCTIA");
		IFunctia_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		IFunctia_1.setBounds(22, 164, 80, 20);
		Concediu.add(IFunctia_1);

		JButton ConcediuAfisare = new JButton("Afisare concedii");
		ConcediuAfisare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql = " SELECT datapr AS 'Data'" + " FROM Utilizatori U, Angajat A, programangajati Pr "
							+ " WHERE U.id_ca_angajat = A.id_angajat AND A.id_angajat = Pr.id_ca_angajat "
							+ " AND U.nume = '" + Cnume.getText() + "' AND prenume = '" + Cprenume.getText()
							+ "' AND concediu = 1 ORDER BY datapr";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
					if(rs == null)
						JOptionPane.showMessageDialog(null, " Nu sunt date de afisat ");
					connection.close();
				} catch (Exception e1) {
					System.out.print(e1);
				}
			}
		});
		ConcediuAfisare.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ConcediuAfisare.setBackground(new Color(216, 191, 216));
		ConcediuAfisare.setBounds(22, 247, 190, 35);
		Concediu.add(ConcediuAfisare);

		JButton AAngajati = new JButton("Afisare angajati");
		AAngajati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql = "SELECT DISTINCT nume AS 'Nume', prenume AS 'Prenume', U.tip AS 'Functie'"
							+ " FROM Utilizatori U, Angajat A WHERE U.id_ca_angajat = A.id_angajat ORDER BY nume, prenume;";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next())
						table_2.setModel(DbUtils.resultSetToTableModel(rs));

					connection.close();
				} catch (Exception e1) {
					System.out.print(e1);
				}
			}
		});
		AAngajati.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AAngajati.setBackground(new Color(216, 191, 216));
		AAngajati.setBounds(22, 537, 190, 35);
		Concediu.add(AAngajati);

	}
}
