package prBD;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Salariu extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField parola;
	private JTable table;
	private JTextField completare;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salariu frame = new Salariu();
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
	public Salariu() {
		setTitle("Policlinica");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\PROIECT BD\\hospital-plus-logo-914E10A64D-seeklogo.com.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Id: ");
		lblNewLabel.setBounds(28, 78, 32, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton salariu = new JButton("Afiseaza salariu actual");
		salariu.setBounds(383, 38, 285, 33);
		salariu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					Statement stmt=con.createStatement();
					String sql="Select * from utilizatori where  id_utilizator='"+user.getText()+"' and parola='"+parola.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					
					if(rs.next()) {
						String sql2="Select * from utilizatori where  id_utilizator='"+user.getText()+"' and parola='"+parola.getText().toString()+"' and tip='medic';";
					ResultSet tip=stmt.executeQuery(sql2);
						if(!tip.next()) {
						PreparedStatement s= con.prepareStatement("SELECT nume, prenume, salar_neg*nr_ore*(28-SUM(IF(programangajati.concediu=1,1,0))) as salariu FROM Angajat, utilizatori, programangajati \r\n"
								+ "WHERE angajat.id_angajat=utilizatori.id_ca_angajat \r\n"
								+ "AND MONTH(programangajati.datapr)=MONTH(CURRENT_DATE - INTERVAL 1 MONTH)\r\n"
								+ "AND utilizatori.id_utilizator="+user.getText()+";");
						ResultSet rez= s.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rez));}
						else
						{
							PreparedStatement s2= con.prepareStatement("SELECT MONTH(CURRENT_DATE - INTERVAL 1 MONTH) as luna, \r\n"
									+ " IF(COUNT(programari.medicul),3000+SUM(medic.Procent_neg_servicii/100 * sumaplatita),3000) as salariu  \r\n"
									+ " FROM istoricbonuri, programari,medic\r\n"
									+ " WHERE MONTH(programari.datapacient)=MONTH(CURRENT_DATE - INTERVAL 1 MONTH)\r\n"
									+ " AND istoricbonuri.id_de_la_programare=programari.id_programare \r\n"
									+ " and programari.medicul=medic.id_medic \r\n"
									+ " and medic.id_ca_utilizator="+user.getText()+";");
							ResultSet rez2= s2.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rez2));
						}
						
						
					}
					else
						JOptionPane.showMessageDialog(null,"Id sau parola gresita! ");
					con.close();
				}catch(Exception e) {System.out.print(e);}
			}
			
		});
		salariu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton istoric = new JButton("Istoric salarii");
		istoric.setBounds(444, 81, 151, 33);
		istoric.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					Statement stmt=con.createStatement();
					String sql="Select * from utilizatori where  id_utilizator='"+user.getText()+"' and parola='"+parola.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {String sql2="Select * from utilizatori where  id_utilizator='"+user.getText()+"' and parola='"+parola.getText().toString()+"' and tip='medic';";
					ResultSet tip=stmt.executeQuery(sql2);
					if(!tip.next()) {
						PreparedStatement s= con.prepareStatement("SELECT salariu, data_aplicarii FROM Istoric_Salariu, angajat, utilizatori WHERE angajat.id_angajat=Istoric_Salariu.id_angajat AND angajat.id_angajat=utilizatori.id_ca_angajat AND utilizatori.id_utilizator="+user.getText()+";");
						ResultSet rez= s.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rez));
					}
					else
					{
						PreparedStatement s2= con.prepareStatement("\r\n"
								+ "SELECT m.luna, IF(COUNT(programari.medicul),3000+SUM(medic.Procent_neg_servicii/100 * sumaplatita),3000) as salariu \r\n"
								+ "FROM (\r\n"
								+ "SELECT 'January' AS\r\n"
								+ "luna\r\n"
								+ "UNION SELECT 'February' AS\r\n"
								+ "luna\r\n"
								+ "UNION SELECT 'March' AS\r\n"
								+ "luna\r\n"
								+ "UNION SELECT 'April' AS\r\n"
								+ "luna\r\n"
								+ "UNION SELECT 'May' AS\r\n"
								+ "luna\r\n"
								+ "UNION SELECT 'June' AS\r\n"
								+ "luna\r\n"
								+ "UNION SELECT 'July' AS\r\n"
								+ "luna\r\n"
								+ "UNION SELECT 'August' AS\r\n"
								+ "luna\r\n"
								+ "UNION SELECT 'September' AS\r\n"
								+ "luna\r\n"
								+ "UNION SELECT 'October' AS\r\n"
								+ "luna\r\n"
								+ "UNION SELECT 'November' AS\r\n"
								+ "luna\r\n"
								+ "UNION SELECT 'December' AS\r\n"
								+ "luna\r\n"
								+ ") AS m, istoricbonuri, programari,medic \r\n"
								+ "WHERE istoricbonuri.id_de_la_programare=programari.id_programare \r\n"
								+ "and programari.medicul=medic.id_medic \r\n"
								+ "and medic.id_ca_utilizator="+user.getText()+" and m.luna=monthname(programari.datapacient)\r\n"
										+ "group by m.luna;");
						ResultSet rez2= s2.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rez2));
					}
					}
					else
						JOptionPane.showMessageDialog(null,"Id sau parola gresita! ");
					con.close();
				}catch(Exception e) {System.out.print(e);}
			}
			
		});

		istoric.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.setBounds(15, 515, 97, 33);
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Financiar f=new Financiar();
					f.show();
					dispose();
				
			}
		});
		btnInapoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblParola = new JLabel("Parola: ");
		lblParola.setBounds(28, 125, 84, 25);
		lblParola.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		user = new JTextField();
		user.setBounds(122, 71, 172, 31);
		user.setFont(new Font("Tahoma", Font.PLAIN, 20));
		user.setColumns(10);
		
		parola = new JPasswordField();
		parola.setBounds(122, 122, 172, 31);
		parola.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.setLayout(null);
		contentPane.add(lblParola);
		contentPane.add(lblNewLabel);
		contentPane.add(user);
		contentPane.add(parola);
		contentPane.add(salariu);
		contentPane.add(istoric);
		contentPane.add(btnInapoi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 203, 529, 294);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnProfitGenerat = new JButton("Profit generat");
		btnProfitGenerat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					Statement stmt=con.createStatement();
					String sql="Select * from utilizatori where  id_utilizator='"+user.getText()+"' and parola='"+parola.getText().toString()+"' and tip='medic';";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
						
						PreparedStatement s= con.prepareStatement("SELECT MONTH(CURDATE()) as luna, \r\n"
								+ "IF(COUNT(programari.medicul),SUM((100-medic.Procent_neg_servicii)/100 * sumaplatita)-3000,-3000) as profit \r\n"
								+ "FROM istoricbonuri, programari,medic \r\n"
								+ "WHERE \r\n"
								+ "MONTH(programari.datapacient)=MONTH(CURRENT_DATE - INTERVAL 1 MONTH) \r\n"
								+ "AND istoricbonuri.id_de_la_programare=programari.id_programare \r\n"
								+ "and programari.medicul=medic.id_medic\r\n"
								+ "and medic.id_ca_utilizator="+user.getText()+";");
						ResultSet rez= s.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rez));
					}
					else
						JOptionPane.showMessageDialog(null,"Doar medicii pot accesa profitul!"
								+ "  Id sau parola gresita! ");
					con.close();
				}catch(Exception e) {System.out.print(e);}
			}
		});
		btnProfitGenerat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnProfitGenerat.setBounds(442, 125, 163, 33);
		contentPane.add(btnProfitGenerat);
		table.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
	}
}
