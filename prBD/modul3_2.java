package prBD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Toolkit;

public class modul3_2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTable table_1;
	private JTable table2;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField txtNull;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTable table_3;
	private JTable table5;
	private JTable table6;
	private JTable table7;
	private JTextField idp;
	private JTextField pac;
	private JTextField serv;
	private JTextField oi;
	private JTextField of;
	private JTextField dat;
	private JTextField unit;
	private JTextField med;
	private JTable table8;
	private JTextField echip;
	private JTextField idserv;
	private JTextField utilid;
	private JTextField ore;
	private int validare1=0;
	private int validare2=0;
	private JTextField utilid2;
	private JTextField ids2;
	private JTextField serv2;
	private JTextField ore2;
	private JTextField ids3;
	private JTextField serv3;
	private JTextField ore3;
	int al1=0;
	int al2=0;
	int al3=0;
	private JTextField echip2;
	private JTextField echip3;
	private JTextField cab;
	private JTextField idse2;
	private JTextField idse3;
	private JTextField cab2;
	private JTextField textField_10;
	private JTextField textField_15;
	private JTextField gr1;
	private JTextField gr2;
	private JTextField gr3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modul3_2 frame = new modul3_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void refreshTable1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
			String sql="Select * from istoricbonuri ";
			Statement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery(sql);
			table_3.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		}catch(Exception e2) {System.out.print(e2);}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
			
			String sql1="select max(id_bon)+1 as idp from istoricbonuri  ;";
			PreparedStatement pst=con2.prepareStatement(sql1);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {

				textField_29.setText(rs.getString("idp"));
			}
			if(textField_29.getText().equals("")) {
				textField_29.setText("1");
			}
			textField_30.setText("");
			textField_31.setText("");
			//JOptionPane.showMessageDialog(null," Successfully ");
			
			pst.close();
			con2.close();
		}catch(Exception e6) {System.out.print(e6);}
	}
	public void refreshTable2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
			String sql="Select * from pacienti";
			Statement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		}catch(Exception e2) {System.out.print(e2);}
	}
	public void refreshTable3() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
			String sql="Select * from programari";
			Statement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery(sql);
			table2.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		}catch(Exception e2) {System.out.print(e2);}
	}
	/**
	 * Create the frame.
	 */
	public modul3_2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\PROIECT BD\\hospital-plus-logo-914E10A64D-seeklogo.com.png"));
		setTitle("Policlinica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.setBounds(24, 10, 1141, 669);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Pacienti", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(364, 23, 736, 369);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					int row=table.getSelectedRow();
					String idul=(table.getModel().getValueAt(row,0)).toString();
					
					String sql1="select * from pacienti where id_pacient="+idul+";";
					PreparedStatement pst=con2.prepareStatement(sql1);
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
						textField.setText(rs.getString("id_pacient"));
						textField_1.setText(rs.getString("alergii"));
						textField_2.setText(rs.getString("boli"));
						textField_3.setText(rs.getString("nume"));
						textField_4.setText(rs.getString("prenume"));
						textField_5.setText(rs.getString("datanasterii"));
						textField_6.setText(rs.getString("sexul"));
						textField_7.setText(rs.getString("domiciliu"));
						textField_8.setText(rs.getString("cetatenie"));
						textField_9.setText(rs.getString("asigurare"));
					}
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(159, 21, 150, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
			
			String sql1="select max(id_pacient)+1 as idp from pacienti  ;";
			PreparedStatement pst=con2.prepareStatement(sql1);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {

				textField.setText(rs.getString("idp"));
			}
			//JOptionPane.showMessageDialog(null," Successfully ");
			
			pst.close();
			con2.close();
		}catch(Exception e6) {System.out.print(e6);}
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(159, 61, 150, 30);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(159, 101, 150, 30);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(159, 142, 150, 30);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(159, 181, 150, 30);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(159, 221, 150, 30);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(159, 261, 150, 30);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(159, 303, 150, 30);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(159, 342, 150, 30);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(159, 382, 150, 30);
		panel.add(textField_9);
		
		JLabel lblNewLabel = new JLabel("id_pacient");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(35, 22, 112, 27);
		panel.add(lblNewLabel);
		
		JLabel lblAlergii = new JLabel("alergii");
		lblAlergii.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlergii.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlergii.setBounds(35, 64, 112, 27);
		panel.add(lblAlergii);
		
		JLabel lblBoli = new JLabel("boli");
		lblBoli.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBoli.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBoli.setBounds(35, 101, 112, 27);
		panel.add(lblBoli);
		
		JLabel lblNume = new JLabel("nume");
		lblNume.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNume.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNume.setBounds(35, 142, 112, 27);
		panel.add(lblNume);
		
		JLabel lblPrenume = new JLabel("prenume");
		lblPrenume.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrenume.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrenume.setBounds(35, 181, 112, 27);
		panel.add(lblPrenume);
		
		JLabel lblDatanasterii = new JLabel("datanasterii");
		lblDatanasterii.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDatanasterii.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDatanasterii.setBounds(35, 221, 112, 27);
		panel.add(lblDatanasterii);
		
		JLabel lblSexul = new JLabel("sexul");
		lblSexul.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexul.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSexul.setBounds(37, 264, 112, 27);
		panel.add(lblSexul);
		
		JLabel lblDomiciliu = new JLabel("domiciliu");
		lblDomiciliu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDomiciliu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDomiciliu.setBounds(35, 306, 112, 27);
		panel.add(lblDomiciliu);
		
		JLabel lblCetatenie = new JLabel("cetatenie");
		lblCetatenie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCetatenie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCetatenie.setBounds(37, 342, 112, 27);
		panel.add(lblCetatenie);
		
		JLabel lblAsigurare = new JLabel("asigurare");
		lblAsigurare.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAsigurare.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAsigurare.setBounds(37, 385, 112, 27);
		panel.add(lblAsigurare);
		
		JButton btnNewButton_1 = new JButton("Vizualizare Pacienti");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e41) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql="SELECT * FROM pacienti";
					Statement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					con.close();
				}catch(Exception e2) {System.out.print(e2);}
				
			}
		});
		btnNewButton_1.setBackground(new Color(175, 238, 238));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(374, 411, 302, 30);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Modificare date de la un pacient");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql1="update pacienti  set alergii='"+ textField_1.getText()+"',boli='"+ textField_2.getText()+"',nume='"+ textField_3.getText()+"',prenume='"+ textField_4.getText()+"',datanasterii='"+ textField_5.getText()+"',sexul='"+ textField_6.getText()+"',domiciliu='"+ textField_7.getText()+"',cetatenie='"+ textField_8.getText()+"',asigurare='"+ textField_9.getText()+"' where id_pacient="+textField.getText()+";" ;
					PreparedStatement pst=con2.prepareStatement(sql1);
					
					pst.execute(sql1);
					JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					
					con2.close();
				}catch(Exception e3) {System.out.print(e3);}
				refreshTable2();
			}
		});
		btnNewButton_1_1.setBackground(new Color(216, 191, 216));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1_1.setBounds(374, 454, 302, 30);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Stergere Pacient");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql1="delete from pacienti where id_pacient="+textField.getText()+";" ;
					PreparedStatement pst=con2.prepareStatement(sql1);
					
					pst.execute(sql1);
					JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					
					con2.close();
				}catch(Exception e3) {System.out.print(e3);}
				refreshTable2();
			}
		});
		btnNewButton_1_2.setBackground(new Color(250, 128, 114));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1_2.setBounds(713, 454, 302, 30);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Inserare Pacient");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql1="insert into pacienti"+ " values "+ "("+textField.getText()+",'"+ textField_1.getText()+"','"+ textField_2.getText()+"','"+ textField_3.getText()+"','"+ textField_4.getText()+"','"+ textField_5.getText()+"','"+ textField_6.getText()+"','"+ textField_7.getText()+"','"+ textField_8.getText()+"','"+ textField_9.getText()+"' );" ;
					PreparedStatement pst=con2.prepareStatement(sql1);
					
					pst.execute(sql1);
					JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					
					con2.close();
				}catch(Exception e3) {System.out.print(e3);}
				refreshTable2();
			}
		});
		btnNewButton_1_3.setBackground(new Color(152, 251, 152));
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1_3.setBounds(713, 411, 302, 30);
		panel.add(btnNewButton_1_3);
		
		JLabel lblNewLabel_1 = new JLabel("Cautare dupa nume");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(523, 511, 150, 30);
		panel.add(lblNewLabel_1);
		
		textField_11 = new JTextField();
		textField_11.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					//String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
					String sql1="select * from pacienti where nume=?";
					PreparedStatement pst=con2.prepareStatement(sql1);
					pst.setString(1, textField_11.getText());
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		textField_11.setBounds(685, 511, 171, 30);
		panel.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cautare dupa prenume");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(500, 556, 175, 30);
		panel.add(lblNewLabel_1_1);
		
		textField_12 = new JTextField();
		textField_12.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					//String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
					String sql1="select * from pacienti where prenume=?";
					PreparedStatement pst=con2.prepareStatement(sql1);
					pst.setString(1, textField_12.getText());
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		textField_12.setColumns(10);
		textField_12.setBounds(687, 556, 171, 30);
		panel.add(textField_12);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Programari", null, panel_1, null);
		panel_1.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(752, 171, 1, 1);
		panel_1.add(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(349, 25, 777, 345);
		panel_1.add(scrollPane_1);
		
		table2 = new JTable();
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					int row=table2.getSelectedRow();
					String idul=(table2.getModel().getValueAt(row,0)).toString();
					
					String sql1="select * from programari where id_programare="+idul+";";
					PreparedStatement pst=con2.prepareStatement(sql1);
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
						textField_13.setText(rs.getString("id_programare"));
						textField_14.setText(rs.getString("id_pacient"));
						txtNull.setText(rs.getString("id_serviciupr"));
						idse2.setText(rs.getString("id_serviciupr2"));
						idse3.setText(rs.getString("id_serviciupr3"));
						textField_16.setText(rs.getString("ora_inceperii"));
						textField_17.setText(rs.getString("ora_finalizarii"));
						textField_18.setText(rs.getString("datapacient"));
						textField_19.setText(rs.getString("unitatea"));
						textField_20.setText(rs.getString("medicul"));
						cab2.setText(rs.getString("cabinetul"));
					}
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		scrollPane_1.setViewportView(table2);
		idp = new JTextField();
		idp.setBounds(156, 321, 150, 30);
		idp.setColumns(10);
	
		textField_13 = new JTextField();
		textField_13.setBounds(142, 33, 150, 30);
		panel_1.add(textField_13);
		textField_13.setColumns(10);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
			
			String sql1="select max(id_programare)+1 as idp from programari  ;";
			PreparedStatement pst=con2.prepareStatement(sql1);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {

				textField_13.setText(rs.getString("idp"));
				idp.setText(rs.getString("idp"));
			}
			//JOptionPane.showMessageDialog(null," Successfully ");
			
			pst.close();
			con2.close();
		}catch(Exception e6) {System.out.print(e6);}
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(142, 79, 150, 30);
		panel_1.add(textField_14);
		
		txtNull = new JTextField();
		txtNull.setText("NULL");
		txtNull.setColumns(10);
		txtNull.setBounds(142, 124, 38, 30);
		panel_1.add(txtNull);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(142, 169, 150, 30);
		panel_1.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(142, 214, 150, 30);
		panel_1.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(142, 257, 150, 30);
		panel_1.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(106, 297, 76, 30);
		panel_1.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(142, 340, 76, 30);
		panel_1.add(textField_20);
		
		JLabel lblNewLabel_2 = new JLabel("id_programare");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 34, 122, 22);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("id_pacient");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(10, 80, 122, 22);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("id_serviciupr");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(10, 125, 122, 22);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("ora_inceperii");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(10, 172, 122, 22);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("ora_finalizarii");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4.setBounds(10, 215, 122, 22);
		panel_1.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("data");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_5.setBounds(10, 258, 122, 22);
		panel_1.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("unitatea");
		lblNewLabel_2_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_6.setBounds(10, 300, 86, 22);
		panel_1.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("medic");
		lblNewLabel_2_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_7.setBounds(10, 341, 122, 22);
		panel_1.add(lblNewLabel_2_7);
		
		JButton btnNewButton_3 = new JButton("Vizualizare programari");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e41) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql="SELECT * FROM programari";
					Statement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery(sql);
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					con.close();
				}catch(Exception e2) {System.out.print(e2);}
				
			}
		});
		btnNewButton_3.setBackground(new Color(176, 224, 230));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(349, 413, 297, 30);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Adaugare programare");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql1;
					if(idse2.getText().equals("") && idse3.getText().equals("")) {
						 sql1="insert into programari"+ "  values "+ "("+textField_13.getText()+","+textField_14.getText()+","+txtNull.getText()+",NULL,NULL,"+textField_16.getText()+","+textField_17.getText()+",'"+textField_18.getText()+"',"+textField_19.getText()+","+cab2.getText()+","+textField_20.getText()+" );" ;
						
					}
					else if( idse3.getText().equals(""))
					{
						sql1="insert into programari"+ "  values "+ "("+textField_13.getText()+","+textField_14.getText()+","+txtNull.getText()+","+idse2.getText()+",NULL,"+textField_16.getText()+","+textField_17.getText()+",'"+textField_18.getText()+"',"+textField_19.getText()+","+cab2.getText()+","+textField_20.getText()+" );" ;
						
					}
					else {
						 sql1="insert into programari"+ "  values "+ "("+textField_13.getText()+","+textField_14.getText()+","+txtNull.getText()+","+idse2.getText()+","+idse3.getText()+","+textField_16.getText()+","+textField_17.getText()+",'"+textField_18.getText()+"',"+textField_19.getText()+","+cab2.getText()+","+textField_20.getText()+" );" ;
					}
					PreparedStatement pst=con2.prepareStatement(sql1);
					if(validare1==1) {
					pst.execute(sql1);
					JOptionPane.showMessageDialog(null," Programare adaugata cu succes! ");
					}
					else {
						JOptionPane.showMessageDialog(null," Programarea nu a fost verificata! ");
					}
					pst.close();
					
					con2.close();
				}catch(Exception e3) {System.out.print(e3);}
				refreshTable3();
			}
		});
		btnNewButton_3_1.setBackground(new Color(152, 251, 152));
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_1.setBounds(785, 431, 206, 30);
		panel_1.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_1_1 = new JButton("Modificare programare");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql1="update programari"+ "  set id_pacient="+textField_14.getText()+",id_serviciupr="+txtNull.getText()+",id_serviciupr2="+idse2.getText()+",id_serviciupr3="+idse3.getText()+",ora_inceperii="+textField_16.getText()+",ora_finalizarii="+textField_17.getText()+",datapacient='"+textField_18.getText()+"',unitatea="+textField_19.getText()+",medicul="+textField_20.getText()+" where id_programare="+textField_13.getText()+" ;" ;
					PreparedStatement pst=con2.prepareStatement(sql1);
					if(validare1==1) {
					pst.execute(sql1);
					JOptionPane.showMessageDialog(null," Programare modificata cu succes! ");
					}
					else {
						JOptionPane.showMessageDialog(null," Programarea nu a fost verificata! ");
					}
					pst.close();
					
					con2.close();
				}catch(Exception e3) {System.out.print(e3);}
				refreshTable3();
			}
		});
		btnNewButton_3_1_1.setBackground(new Color(216, 191, 216));
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_1_1.setBounds(785, 467, 206, 30);
		panel_1.add(btnNewButton_3_1_1);
		
		JButton btnNewButton_3_1_2 = new JButton("Stergere programare");
		btnNewButton_3_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql1="delete from programari where id_programare="+textField_13.getText()+" ;" ;
					PreparedStatement pst=con2.prepareStatement(sql1);
					
					pst.execute(sql1);
					JOptionPane.showMessageDialog(null," Programare stearsa cu succes! ");
					
					pst.close();
					
					con2.close();
				}catch(Exception e3) {System.out.print(e3);}
				refreshTable3();
			}
		});
		btnNewButton_3_1_2.setBackground(new Color(255, 182, 193));
		btnNewButton_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_1_2.setBounds(785, 507, 206, 30);
		panel_1.add(btnNewButton_3_1_2);
		
		textField_21 = new JTextField();
		textField_21.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					//String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
					String sql1="select * from programari where id_programare=?";
					PreparedStatement pst=con2.prepareStatement(sql1);
					pst.setString(1, textField_21.getText());
					ResultSet rs=pst.executeQuery();
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		textField_21.setColumns(10);
		textField_21.setBounds(21, 573, 122, 30);
		panel_1.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					//String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
					String sql1="select * from programari where id_pacient=?";
					PreparedStatement pst=con2.prepareStatement(sql1);
					pst.setString(1, textField_22.getText());
					ResultSet rs=pst.executeQuery();
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		textField_22.setColumns(10);
		textField_22.setBounds(156, 573, 122, 30);
		panel_1.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					//String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
					String sql1="select * from programari where id_serviciupr=?";
					PreparedStatement pst=con2.prepareStatement(sql1);
					pst.setString(1, textField_23.getText());
					ResultSet rs=pst.executeQuery();
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		textField_23.setColumns(10);
		textField_23.setBounds(291, 573, 44, 30);
		panel_1.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					//String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
					String sql1="select * from programari where ora_inceperii=?";
					PreparedStatement pst=con2.prepareStatement(sql1);
					pst.setString(1, textField_24.getText());
					ResultSet rs=pst.executeQuery();
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		textField_24.setColumns(10);
		textField_24.setBounds(456, 573, 122, 30);
		panel_1.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					//String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
					String sql1="select * from programari where ora_finalizarii=?";
					PreparedStatement pst=con2.prepareStatement(sql1);
					pst.setString(1, textField_25.getText());
					ResultSet rs=pst.executeQuery();
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		textField_25.setColumns(10);
		textField_25.setBounds(588, 573, 122, 30);
		panel_1.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					//String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
					String sql1="select * from programari where datapacient=?";
					PreparedStatement pst=con2.prepareStatement(sql1);
					pst.setString(1, textField_26.getText());
					ResultSet rs=pst.executeQuery();
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		textField_26.setColumns(10);
		textField_26.setBounds(720, 573, 122, 30);
		panel_1.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					//String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
					String sql1="select * from programari where unitatea=?";
					PreparedStatement pst=con2.prepareStatement(sql1);
					pst.setString(1, textField_27.getText());
					ResultSet rs=pst.executeQuery();
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		textField_27.setColumns(10);
		textField_27.setBounds(854, 573, 122, 30);
		panel_1.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					//String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
					String sql1="select * from programari where medicul=?";
					PreparedStatement pst=con2.prepareStatement(sql1);
					pst.setString(1, textField_28.getText());
					ResultSet rs=pst.executeQuery();
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		textField_28.setColumns(10);
		textField_28.setBounds(986, 573, 122, 30);
		panel_1.add(textField_28);
		
		JLabel lblNewLabel_2_8 = new JLabel("id_programare");
		lblNewLabel_2_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_8.setBounds(10, 601, 122, 22);
		panel_1.add(lblNewLabel_2_8);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("id_pacient");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(145, 604, 122, 22);
		panel_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("id_serviciupr");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(280, 604, 122, 22);
		panel_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("ora_inceperii");
		lblNewLabel_2_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3_1.setBounds(434, 601, 122, 22);
		panel_1.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("ora_finalizarii");
		lblNewLabel_2_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1.setBounds(577, 601, 122, 22);
		panel_1.add(lblNewLabel_2_4_1);
		
		JLabel lblNewLabel_2_5_1 = new JLabel("data");
		lblNewLabel_2_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_5_1.setBounds(709, 601, 122, 22);
		panel_1.add(lblNewLabel_2_5_1);
		
		JLabel lblNewLabel_2_6_1 = new JLabel("unitatea");
		lblNewLabel_2_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_6_1.setBounds(843, 601, 122, 22);
		panel_1.add(lblNewLabel_2_6_1);
		
		JLabel lblNewLabel_2_7_1 = new JLabel("medic");
		lblNewLabel_2_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_7_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_7_1.setBounds(975, 601, 122, 22);
		panel_1.add(lblNewLabel_2_7_1);
		
		JLabel lblNewLabel_3 = new JLabel("Cautati programare dupa:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(42, 525, 329, 30);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton_3_2 = new JButton("Verificare programare");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql="SELECT * from programari,programangajati where programangajati.id_ca_angajat="+utilid2.getText()+" and datapacient='"+textField_18.getText()+"'  and  id_serviciupr="+txtNull.getText()+" and unitatea="+textField_19.getText()+" and medicul="+textField_20.getText()+" and ((ora_inceperii<="+textField_16.getText()+" and ora_finalizarii>="+textField_16.getText()+" ) or (ora_inceperii<="+textField_17.getText()+" and ora_finalizarii>="+textField_17.getText()+" ) or(ora_inceperii>"+textField_16.getText()+" and ora_finalizarii<"+textField_17.getText()+") or (ora_incepere>"+textField_16.getText()+" or ora_plecare<"+textField_17.getText()+") )  ";
					Statement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null," Interval orar incorect! ");
						validare1=0;
					}
					else {
						JOptionPane.showMessageDialog(null," Programarea este valida! ");
						validare1=1;
					}
					//JOptionPane.showMessageDialog(null," Successfully ");
					pst.close();
					con.close();
				}catch(Exception e2) {System.out.print(e2);}
			}
		});
		btnNewButton_3_2.setBackground(new Color(255, 255, 0));
		btnNewButton_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_2.setBounds(722, 391, 297, 30);
		panel_1.add(btnNewButton_3_2);
		
		JButton btnNewButton_3_3 = new JButton("Vizualizare medici");
		btnNewButton_3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e41) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql="SELECT id_medic,nume,prenume,specialitate,grad,utilizatori.id_ca_angajat FROM medic,utilizatori where medic.id_ca_utilizator=utilizatori.id_utilizator";
					Statement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery(sql);
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					con.close();
				}catch(Exception e2) {System.out.print(e2);}
				
			}
		});
		btnNewButton_3_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_3.setBackground(new Color(176, 224, 230));
		btnNewButton_3_3.setBounds(21, 391, 297, 30);
		panel_1.add(btnNewButton_3_3);
		
		JButton btnNewButton_3_4 = new JButton("Vizualizare servicii");
		btnNewButton_3_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e41) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql="SELECT * FROM servicii";
					Statement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery(sql);
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					con.close();
				}catch(Exception e2) {System.out.print(e2);}
				
			}
		});
		btnNewButton_3_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_4.setBackground(new Color(176, 224, 230));
		btnNewButton_3_4.setBounds(21, 441, 297, 30);
		panel_1.add(btnNewButton_3_4);
		
		JButton btnNewButton_3_5 = new JButton("Vizualizare cabinete");
		btnNewButton_3_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e41) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql="SELECT * FROM cabinete";
					Statement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery(sql);
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					con.close();
				}catch(Exception e2) {System.out.print(e2);}
				
			}
		});
		btnNewButton_3_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_5.setBackground(new Color(176, 224, 230));
		btnNewButton_3_5.setBounds(21, 485, 297, 30);
		panel_1.add(btnNewButton_3_5);
		
		utilid2 = new JTextField();
		utilid2.setColumns(10);
		utilid2.setBounds(242, 340, 76, 30);
		panel_1.add(utilid2);
		
		JButton btnNewButton_3_5_1 = new JButton("Vizualizare unitati medicale");
		btnNewButton_3_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql="SELECT * FROM unitati_medicale";
					Statement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery(sql);
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					con.close();
				}catch(Exception e2) {System.out.print(e2);}
			}
		});
		btnNewButton_3_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_5_1.setBackground(new Color(176, 224, 230));
		btnNewButton_3_5_1.setBounds(349, 467, 297, 30);
		panel_1.add(btnNewButton_3_5_1);
		
		idse2 = new JTextField();
		idse2.setText("NULL");
		idse2.setColumns(10);
		idse2.setBounds(190, 124, 38, 30);
		panel_1.add(idse2);
		
		idse3 = new JTextField();
		idse3.setText("NULL");
		idse3.setColumns(10);
		idse3.setBounds(242, 124, 38, 30);
		panel_1.add(idse3);
		
		cab2 = new JTextField();
		cab2.setColumns(10);
		cab2.setBounds(263, 297, 76, 30);
		panel_1.add(cab2);
		
		JLabel lblNewLabel_2_6_3 = new JLabel("cabinetul");
		lblNewLabel_2_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_6_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_6_3.setBounds(183, 300, 70, 22);
		panel_1.add(lblNewLabel_2_6_3);
		
		textField_10 = new JTextField();
		textField_10.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					//String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
					String sql1="select * from programari where id_serviciupr2=?";
					PreparedStatement pst=con2.prepareStatement(sql1);
					pst.setString(1, textField_10.getText());
					ResultSet rs=pst.executeQuery();
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		textField_10.setColumns(10);
		textField_10.setBounds(342, 573, 44, 30);
		panel_1.add(textField_10);
		
		textField_15 = new JTextField();
		textField_15.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					//String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
					String sql1="select * from programari where id_serviciupr3=?";
					PreparedStatement pst=con2.prepareStatement(sql1);
					pst.setString(1, textField_15.getText());
					ResultSet rs=pst.executeQuery();
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		textField_15.setColumns(10);
		textField_15.setBounds(390, 573, 44, 30);
		panel_1.add(textField_15);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Bon Fiscal", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2_9 = new JLabel("id_bon");
		lblNewLabel_2_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_9.setBounds(55, 94, 122, 22);
		panel_2.add(lblNewLabel_2_9);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(187, 93, 150, 30);
		panel_2.add(textField_29);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
			
			String sql1="select max(id_bon)+1 as idp from istoricbonuri  ;";
			PreparedStatement pst=con2.prepareStatement(sql1);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {

				textField_29.setText(rs.getString("idp"));
			}
			if(textField_29.getText().equals("")) {
				textField_29.setText("1");
			}
			//JOptionPane.showMessageDialog(null," Successfully ");
			
			pst.close();
			con2.close();
		}catch(Exception e6) {System.out.print(e6);}
		
		JLabel lblNewLabel_2_10 = new JLabel("id_de_la_programare");
		lblNewLabel_2_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_10.setBounds(32, 134, 145, 22);
		panel_2.add(lblNewLabel_2_10);
		
		textField_30 = new JTextField();
		textField_30.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					
					String sql1="select sum(pret) as suma from programari,servicii where programari.id_programare="+textField_30.getText()+" and (programari.id_serviciupr=servicii.Id_servicii or programari.id_serviciupr2=servicii.Id_servicii or programari.id_serviciupr3=servicii.Id_servicii);";
					PreparedStatement pst=con2.prepareStatement(sql1);
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
	
						textField_31.setText(rs.getString("suma"));
					}
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		textField_30.setColumns(10);
		textField_30.setBounds(187, 133, 150, 30);
		panel_2.add(textField_30);
		
		JLabel lblNewLabel_2_11 = new JLabel("sumaplatita");
		lblNewLabel_2_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_11.setBounds(55, 174, 122, 22);
		panel_2.add(lblNewLabel_2_11);
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		textField_31.setBounds(187, 173, 150, 30);
		panel_2.add(textField_31);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(385, 10, 702, 550);
		panel_2.add(scrollPane_2);
		
		table_3 = new JTable();
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					int row=table_3.getSelectedRow();
					String idul=(table_3.getModel().getValueAt(row,0)).toString();
					
					String sql1="select * from istoricbonuri where id_bon="+idul+";";
					PreparedStatement pst=con2.prepareStatement(sql1);
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
						textField_29.setText(rs.getString("id_bon"));
						textField_30.setText(rs.getString("id_de_la_programare"));
						textField_31.setText(rs.getString("sumaplatita"));
					}
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		scrollPane_2.setViewportView(table_3);
		
		JButton btnNewButton_4 = new JButton("Vizualizare istoric bonuri");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql="SELECT * FROM istoricbonuri";
					Statement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery(sql);
					table_3.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					con.close();
				}catch(Exception e2) {System.out.print(e2);}
			}
		});
		btnNewButton_4.setBackground(new Color(135, 206, 250));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.setBounds(32, 273, 329, 30);
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Adaugare bon");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql1="insert into istoricbonuri"+ " values "+ "("+textField_29.getText()+","+ textField_30.getText()+","+ textField_31.getText()+" );" ;
					PreparedStatement pst=con2.prepareStatement(sql1);
					
					pst.execute(sql1);
					JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					
					con2.close();
				}catch(Exception e3) {System.out.print(e3);}
				refreshTable1();
			}
			
		});
		btnNewButton_4_1.setBackground(new Color(152, 251, 152));
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4_1.setBounds(32, 321, 329, 30);
		panel_2.add(btnNewButton_4_1);
		
		JButton btnNewButton_4_2 = new JButton("Modificare bon");
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql1="update istoricbonuri"+ " set id_de_la_programare= "+textField_30.getText()+", sumaplatita="+ textField_31.getText()+" where id_bon="+ textField_29.getText()+" ;" ;
					PreparedStatement pst=con2.prepareStatement(sql1);
					
					pst.execute(sql1);
					JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					
					con2.close();
				}catch(Exception e3) {System.out.print(e3);}
				refreshTable1();
			}
		});
		btnNewButton_4_2.setBackground(new Color(216, 191, 216));
		btnNewButton_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4_2.setBounds(32, 365, 329, 30);
		panel_2.add(btnNewButton_4_2);
		
		JButton btnNewButton_4_3 = new JButton("Stergere bon");
		btnNewButton_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql1="delete from istoricbonuri where id_bon="+ textField_29.getText()+" ;" ;
					PreparedStatement pst=con2.prepareStatement(sql1);
					
					pst.execute(sql1);
					JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					
					con2.close();
				}catch(Exception e3) {System.out.print(e3);}
				refreshTable1();
			}
		});
		btnNewButton_4_3.setBackground(new Color(250, 128, 114));
		btnNewButton_4_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4_3.setBounds(32, 409, 329, 30);
		panel_2.add(btnNewButton_4_3);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Programare speciala", null, panel_3, null);
		panel_3.setLayout(null);
		
		JRadioButton ales1 = new JRadioButton("Serviciu 1");
		JRadioButton ales3 = new JRadioButton("Serviciu 3");
		
		JRadioButton ales2 = new JRadioButton("Serviciu 2");
		ales2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ales2.isSelected()) {
					al1=0;
					al2=1;
					al3=0;
					ales1.setSelected(false);
					ales3.setSelected(false);
				}
				else
				{
					al1=0;
					al2=0;
					al3=0;
				}
			}
		});
		ales3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ales3.isSelected()) {
					al1=0;
					al2=0;
					al3=1;
					ales1.setSelected(false);
					ales2.setSelected(false);
				}
				else
				{
					al1=0;
					al2=0;
					al3=0;
				}
			}
		});
		ales1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ales1.isSelected()) {
					al1=1;
					al2=0;
					al3=0;
					ales2.setSelected(false);
					ales3.setSelected(false);
				}
				else
				{
					al1=0;
					al2=0;
					al3=0;
				}
			}
		});
		
		
		ales1.setBounds(474, 117, 103, 21);
		panel_3.add(ales1);
		
		
		ales2.setBounds(574, 117, 103, 21);
		panel_3.add(ales2);
		
		ales3.setBounds(679, 117, 103, 21);
		panel_3.add(ales3);
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(385, 10, 709, 101);
		panel_3.add(scrollPane_3);
		echip2 = new JTextField();
		echip2.setColumns(10);
		echip2.setBounds(251, 122, 75, 22);
		panel_3.add(echip2);
		
		echip3 = new JTextField();
		echip3.setColumns(10);
		echip3.setBounds(336, 121, 75, 22);
		panel_3.add(echip3);
		table5 = new JTable();
		table5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					int row=table5.getSelectedRow();
					String idul=(table5.getModel().getValueAt(row,0)).toString();
					String idu=(table5.getModel().getValueAt(row,4)).toString();
					String sql1="select * from servicii where id_servicii="+idul+";";
					PreparedStatement pst=con2.prepareStatement(sql1);
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
						if(al1==1) {
							serv.setText(rs.getString("secialitate"));
							echip.setText(rs.getString("echipament_necesar"));
							idserv.setText(rs.getString("id_servicii"));
							gr1.setText(rs.getString("necesitate_competente"));
							ore.setText(idu);	
						}
						if(al2==1) {
							serv2.setText(rs.getString("secialitate"));
							echip2.setText(rs.getString("echipament_necesar"));
							ids2.setText(rs.getString("id_servicii"));
							gr2.setText(rs.getString("necesitate_competente"));
							ore2.setText(idu);
						}
						if(al3==1) {
							serv3.setText(rs.getString("secialitate"));
							echip3.setText(rs.getString("echipament_necesar"));
							ids3.setText(rs.getString("id_servicii"));
							gr3.setText(rs.getString("necesitate_competente"));
							ore3.setText(idu);
						}
						
					}
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		scrollPane_3.setViewportView(table5);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(380, 157, 714, 91);
		panel_3.add(scrollPane_4);
		
		table6 = new JTable();
		scrollPane_4.setViewportView(table6);
		
		JScrollPane scrollPane7 = new JScrollPane();
		scrollPane7.setBounds(385, 298, 712, 91);
		panel_3.add(scrollPane7);
		
		table7 = new JTable();
		table7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
			
					int row=table7.getSelectedRow();
					String idul=(table7.getModel().getValueAt(row,0)).toString();
					String iduluni=(table7.getModel().getValueAt(row,8)).toString();
					String idulcab=(table7.getModel().getValueAt(row,9)).toString();
					//String sql1="select * from medic where id_medic="+idul+";";
					
						med.setText(idul);
						unit.setText(iduluni);
						cab.setText(idulcab);
					
					//JOptionPane.showMessageDialog(null," Successfully ");
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		scrollPane7.setViewportView(table7);
		
		
		
		JLabel lblNewLabel_2_12 = new JLabel("id_programare");
		lblNewLabel_2_12.setBounds(24, 322, 122, 22);
		lblNewLabel_2_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2_12);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("id_pacient");
		lblNewLabel_2_1_2.setBounds(24, 361, 122, 22);
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2_1_2);
		
		pac = new JTextField();
		pac.setBounds(156, 360, 150, 30);
		pac.setColumns(10);
		panel_3.add(pac);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("serviciul 1");
		lblNewLabel_2_2_2.setBounds(10, 28, 84, 22);
		lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2_2_2);
		
		serv = new JTextField();
		serv.setBounds(153, 28, 75, 22);
		serv.setColumns(10);
		panel_3.add(serv);
		panel_3.add(idp);
		JLabel lblNewLabel_2_3_2 = new JLabel("ora_inceperii");
		lblNewLabel_2_3_2.setBounds(24, 400, 122, 22);
		lblNewLabel_2_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2_3_2);
		
		oi = new JTextField();
		oi.setBounds(156, 399, 150, 30);
		oi.setColumns(10);
		panel_3.add(oi);
		
		JLabel lblNewLabel_2_4_2 = new JLabel("ora_finalizarii");
		lblNewLabel_2_4_2.setBounds(24, 441, 122, 22);
		lblNewLabel_2_4_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2_4_2);
		
		of = new JTextField();
		of.setBounds(156, 440, 150, 30);
		of.setColumns(10);
		panel_3.add(of);
		
		JLabel lblNewLabel_2_5_2 = new JLabel("data");
		lblNewLabel_2_5_2.setBounds(24, 242, 122, 22);
		lblNewLabel_2_5_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_5_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2_5_2);
		
		dat = new JTextField();
		dat.setBounds(156, 241, 150, 30);
		dat.setColumns(10);
		panel_3.add(dat);
		
		JLabel lblNewLabel_2_6_2 = new JLabel("unitatea");
		lblNewLabel_2_6_2.setBounds(24, 155, 64, 22);
		lblNewLabel_2_6_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_6_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2_6_2);
		
		unit = new JTextField();
		unit.setBounds(98, 151, 75, 30);
		unit.setColumns(10);
		panel_3.add(unit);
		
		JLabel lblNewLabel_2_7_2 = new JLabel("medic");
		lblNewLabel_2_7_2.setBounds(24, 197, 122, 22);
		lblNewLabel_2_7_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_7_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2_7_2);
		
		med = new JTextField();
		med.setBounds(156, 195, 75, 30);
		med.setColumns(10);
		panel_3.add(med);
		
		JButton btnNewButton_2 = new JButton("Vizualizeaza serviciile");
		btnNewButton_2.setBounds(788, 121, 306, 26);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql="SELECT * FROM servicii";
					Statement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery(sql);
					table5.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					con.close();
				}catch(Exception e2) {System.out.print(e2);}
			}
		});
		btnNewButton_2.setBackground(new Color(135, 206, 235));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Vizualizeaza unitati medicale");
		btnNewButton_2_1.setBounds(826, 258, 268, 30);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql="SELECT * FROM unitati_medicale";
					Statement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery(sql);
					table6.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					con.close();
				}catch(Exception e2) {System.out.print(e2);}
			}
		});
		btnNewButton_2_1.setBackground(new Color(135, 206, 235));
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Vizualizeaza medicii pentru acel serviciu");
		btnNewButton_2_2.setBounds(788, 399, 306, 30);
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					int gol1=0;
					int gol2=0;
					int gol3=0;
					//System.out.println("*"+serv.getText()+"*");
					if(echip.getText().equals("")) {
						//System.out.println("*");
						gol1=1;
					}
					if(echip2.getText().equals("")) {
						//System.out.println("*");
						gol2=1;
					}
					if(echip3.getText().equals("")) {
						//System.out.println("*");
						gol3=1;
					}
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					//String sql="SELECT medic.id_medic,nume,prenume,specialitate,grad,competente_detinute,titlu_stiintific,echipamente,cabinete.id_unitate ,id_cabinet FROM medic,utilizatori,cabinete where medic.id_ca_utilizator=utilizatori.id_utilizator and cabinete.id_medic=medic.id_medic and (specialitate='"+serv.getText()+"' or specialitate='"+serv2.getText()+"' or specialitate='"+serv3.getText()+"') and ((echipamente like '%"+echip.getText()+"%' and "+gol1+"=0 ) or (echipamente like '%"+echip2.getText()+"%' and "+gol2+"=0 ) or ( echipamente like '%"+echip3.getText()+"%' and "+gol3+"=0 ));";
					
					String sql;
						if(gol1==1 || gol2==1 || gol3==1) {
							 sql="SELECT medic.id_medic,nume,prenume,specialitate,grad,competente_detinute,titlu_stiintific,echipamente,cabinete.id_unitate ,id_cabinet FROM medic,utilizatori,cabinete where medic.id_ca_utilizator=utilizatori.id_utilizator and cabinete.id_medic=medic.id_medic and (specialitate='"+serv.getText()+"' or specialitate='"+serv2.getText()+"' or specialitate='"+serv3.getText()+"') and (grad='"+gr1.getText()+"' or grad='"+gr2.getText()+"' or grad='"+gr3.getText()+"') and ((echipamente like '%"+echip.getText()+"%' and "+gol1+"=0 ) or (echipamente like '%"+echip2.getText()+"%' and "+gol2+"=0 ) or ( echipamente like '%"+echip3.getText()+"%' and "+gol3+"=0 ) or ( echipamente like ''));";
						}
						else {
							sql="SELECT medic.id_medic,nume,prenume,specialitate,grad,competente_detinute,titlu_stiintific,echipamente,cabinete.id_unitate ,id_cabinet FROM medic,utilizatori,cabinete where medic.id_ca_utilizator=utilizatori.id_utilizator and cabinete.id_medic=medic.id_medic and (specialitate='"+serv.getText()+"' or specialitate='"+serv2.getText()+"' or specialitate='"+serv3.getText()+"') and (grad='"+gr1.getText()+"' or grad='"+gr2.getText()+"' or grad='"+gr3.getText()+"')  and ((echipamente like '%"+echip.getText()+"%' and echipamente like '%"+echip2.getText()+"%' and  echipamente like '%"+echip3.getText()+"%') or (echipamente like '')) ;";
						}
						Statement pst2=con.prepareStatement(sql);
						ResultSet rs2=pst2.executeQuery(sql);
						table7.setModel(DbUtils.resultSetToTableModel(rs2));
						if(!rs2.next()) {
						
							//sql="SELECT medic.id_medic,nume,prenume,specialitate,grad,competente_detinute,titlu_stiintific,echipamente,cabinete.id_unitate ,id_cabinet FROM medic,utilizatori,cabinete where medic.id_ca_utilizator=utilizatori.id_utilizator and cabinete.id_medic=medic.id_medic and (specialitate='"+serv.getText()+"' or specialitate='"+serv2.getText()+"' or specialitate='"+serv3.getText()+"') and ((echipamente like '%"+echip.getText()+"%' and "+gol1+"=0 ) or (echipamente like '%"+echip2.getText()+"%' and "+gol2+"=0 ) or ( echipamente like '%"+echip3.getText()+"%' and "+gol3+"=0 ));";
							 pst2=con.prepareStatement(sql);
							 rs2=pst2.executeQuery(sql);
							 table7.setModel(DbUtils.resultSetToTableModel(rs2));
						}
							
				
					
					pst2.close();
					con.close();
				}catch(Exception e2) {System.out.print(e2);}
			}
		});
		btnNewButton_2_2.setBackground(new Color(135, 206, 235));
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(btnNewButton_2_2);
		
		JButton btnNewButton_3_2_1 = new JButton("Verificare  programarea");
		btnNewButton_3_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql="SELECT * from programari,programangajati where programangajati.id_ca_angajat="+utilid.getText()+" and datapacient='"+dat.getText()+"'  and  id_serviciupr="+idserv.getText()+" and unitatea="+unit.getText()+" and medicul="+med.getText()+" and ((ora_inceperii<="+oi.getText()+" and ora_finalizarii>="+oi.getText()+" ) or (ora_inceperii<="+of.getText()+" and ora_finalizarii>="+of.getText()+" ) or(ora_inceperii>"+oi.getText()+" and ora_finalizarii<"+of.getText()+") or (ora_incepere>"+oi.getText()+" or ora_plecare<"+of.getText()+") )  ";
					Statement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null," Interval orar incorect! ");
						validare2=0;
					}
					else {
						int rez=0;
						String sql2="call verificare_ore1("+ore.getText()+","+ore2.getText()+","+ore3.getText()+","+oi.getText()+","+of.getText()+")";
						
						
						Statement pst2=con.prepareStatement(sql2);
						ResultSet rs2=pst2.executeQuery(sql2);
						if(rs2.next() && rs2.getString("ifc").equals("1")) {
						//	System.out.print(rs2.getString("ifc")+",");
							JOptionPane.showMessageDialog(null," Programarea este valida! ");
						validare2=1;
						}
						else {
							JOptionPane.showMessageDialog(null," Durata incorecta pentru serviciile alese! ");
							validare2=0;
						}
						//System.out.print(rez);
						
					}
					//JOptionPane.showMessageDialog(null," Successfully ");
					pst.close();
					con.close();
				}catch(Exception e2) {System.out.print(e2);}
			}
		});
		btnNewButton_3_2_1.setBounds(44, 536, 297, 30);
		btnNewButton_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_2_1.setBackground(new Color(0, 255, 0));
		panel_3.add(btnNewButton_3_2_1);
		
		JButton btnNewButton_3_1_3 = new JButton("Adaugare programare");
		btnNewButton_3_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql1="insert into programari"+ "  values "+ "("+idp.getText()+","+pac.getText()+","+idserv.getText()+","+ids2.getText()+","+ids3.getText()+","+oi.getText()+","+of.getText()+",'"+dat.getText()+"',"+unit.getText()+","+cab.getText()+","+med.getText()+" );" ;
					PreparedStatement pst=con2.prepareStatement(sql1);
					if(validare2==1) {
					pst.execute(sql1);
					JOptionPane.showMessageDialog(null," Programare adaugata cu succes! ");
					}
					else {
						JOptionPane.showMessageDialog(null," Programarea nu a fost verificata! ");
					}
					pst.close();
					
					con2.close();
				}catch(Exception e3) {System.out.print(e3);}
			}
		});
		btnNewButton_3_1_3.setBounds(44, 576, 297, 30);
		btnNewButton_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_1_3.setBackground(new Color(233, 150, 122));
		panel_3.add(btnNewButton_3_1_3);
		
		JLabel lblNewLabel_4 = new JLabel("Introduceti manual aceste date:");
		lblNewLabel_4.setBounds(58, 281, 268, 30);
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Selectati din tabele serviciul, unitatea si medicul");
		lblNewLabel_4_1.setBounds(22, 1, 320, 30);
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(Color.RED);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("valabila programarea si apoi adaugati-o");
		lblNewLabel_4_1_1.setBounds(22, 491, 367, 42);
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setForeground(Color.RED);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Dupa ce ati introdus datele,\r\n verificati daca e ");
		lblNewLabel_4_1_1_1.setBounds(10, 469, 367, 42);
		lblNewLabel_4_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1.setForeground(Color.RED);
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_4_1_1_1);
		
		JButton btnNewButton_2_2_1 = new JButton("Vizualizeaza zilele cand e medicul e la unitate");
		btnNewButton_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql="SELECT utilizatori.nume,utilizatori.prenume,medic.specialitate,datapr,ora_incepere,ora_plecare,programangajati.unitate,id_cabinet,utilizatori.id_ca_angajat FROM programangajati,utilizatori,medic,cabinete where medic.specialitate='"+serv.getText()+"' and medic.id_medic="+ med.getText()+" and medic.id_ca_utilizator=utilizatori.id_utilizator and programangajati.datapr>=curdate() and utilizatori.id_ca_angajat= programangajati.id_ca_angajat and programangajati.unitate=cabinete.id_unitate and programangajati.unitate="+unit.getText()+" and cabinete.id_medic="+med.getText()+" and id_cabinet="+cab.getText()+" and cabinete.echipamente='"+echip.getText()+"' and programangajati.concediu=0";
					Statement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery(sql);
					table8.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					con.close();
				}catch(Exception e2) {System.out.print(e2);}
			}
		});
		btnNewButton_2_2_1.setBounds(722, 561, 367, 30);
		btnNewButton_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_2_1.setBackground(new Color(135, 206, 235));
		panel_3.add(btnNewButton_2_2_1);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(385, 457, 719, 91);
		panel_3.add(scrollPane_5);
		
		table8 = new JTable();
		table8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					int row=table8.getSelectedRow();
					//String idul=(table8.getModel().getValueAt(row,6)).toString();
					String idul2=(table8.getModel().getValueAt(row,3)).toString();
					String idul3=(table8.getModel().getValueAt(row,8)).toString();
					
						//unit.setText(idul);
						dat.setText(idul2);
						utilid.setText(idul3);
						
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		scrollPane_5.setViewportView(table8);
		
		echip = new JTextField();
		echip.setColumns(10);
		echip.setBounds(163, 122, 75, 22);
		panel_3.add(echip);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("echipament necesar");
		lblNewLabel_2_2_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_2_1.setBounds(-8, 123, 169, 22);
		panel_3.add(lblNewLabel_2_2_2_1);
		
		idserv = new JTextField();
		idserv.setText("NULL");
		idserv.setColumns(10);
		idserv.setBounds(104, 28, 39, 22);
		panel_3.add(idserv);
		
		utilid = new JTextField();
		utilid.setColumns(10);
		utilid.setBounds(241, 194, 75, 30);
		panel_3.add(utilid);
		
		JLabel lblNewLabel_2_7_2_1 = new JLabel("id_angajat al medicului");
		lblNewLabel_2_7_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_7_2_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_7_2_1.setBounds(221, 220, 122, 22);
		panel_3.add(lblNewLabel_2_7_2_1);
		
		ore = new JTextField();
		ore.setText("0");
		ore.setColumns(10);
		ore.setBounds(313, 28, 39, 22);
		panel_3.add(ore);
		
		JLabel lblNewLabel_2_7_2_1_1 = new JLabel("timp");
		lblNewLabel_2_7_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_7_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_7_2_1_1.setBounds(301, 106, 75, 22);
		panel_3.add(lblNewLabel_2_7_2_1_1);
		
		JLabel lblNewLabel_2_7_2_1_1_1 = new JLabel("id_serviciu");
		lblNewLabel_2_7_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_7_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_7_2_1_1_1.setBounds(86, 106, 75, 22);
		panel_3.add(lblNewLabel_2_7_2_1_1_1);
		
		
		
		ids2 = new JTextField();
		ids2.setText("NULL");
		ids2.setColumns(10);
		ids2.setBounds(104, 61, 39, 22);
		panel_3.add(ids2);
		
		serv2 = new JTextField();
		serv2.setColumns(10);
		serv2.setBounds(153, 61, 75, 22);
		panel_3.add(serv2);
		
		ore2 = new JTextField();
		ore2.setText("0");
		ore2.setColumns(10);
		ore2.setBounds(313, 61, 39, 22);
		panel_3.add(ore2);
		
		ids3 = new JTextField();
		ids3.setText("NULL");
		ids3.setColumns(10);
		ids3.setBounds(104, 89, 39, 22);
		panel_3.add(ids3);
		
		serv3 = new JTextField();
		serv3.setColumns(10);
		serv3.setBounds(153, 89, 75, 22);
		panel_3.add(serv3);
		
		ore3 = new JTextField();
		ore3.setText("0");
		ore3.setColumns(10);
		ore3.setBounds(313, 89, 39, 22);
		panel_3.add(ore3);
		
		JLabel lblNewLabel_2_2_2_2 = new JLabel("serviciul 2");
		lblNewLabel_2_2_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_2_2.setBounds(10, 60, 84, 22);
		panel_3.add(lblNewLabel_2_2_2_2);
		
		JLabel lblNewLabel_2_2_2_3 = new JLabel("serviciul 3");
		lblNewLabel_2_2_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_2_3.setBounds(10, 89, 84, 22);
		panel_3.add(lblNewLabel_2_2_2_3);
		
		cab = new JTextField();
		cab.setColumns(10);
		cab.setBounds(257, 154, 75, 30);
		panel_3.add(cab);
		
		JLabel lblNewLabel_2_6_2_1 = new JLabel("cabinetul");
		lblNewLabel_2_6_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_6_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_6_2_1.setBounds(183, 158, 64, 22);
		panel_3.add(lblNewLabel_2_6_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Vizualizeaza programari");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql="SELECT * FROM programari";
					Statement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery(sql);
					table6.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					con.close();
				}catch(Exception e2) {System.out.print(e2);}
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_1_1.setBackground(new Color(135, 206, 235));
		btnNewButton_2_1_1.setBounds(578, 258, 226, 30);
		panel_3.add(btnNewButton_2_1_1);
		
		gr1 = new JTextField();
		gr1.setColumns(10);
		gr1.setBounds(231, 28, 75, 22);
		panel_3.add(gr1);
		
		gr2 = new JTextField();
		gr2.setColumns(10);
		gr2.setBounds(231, 61, 75, 22);
		panel_3.add(gr2);
		
		gr3 = new JTextField();
		gr3.setColumns(10);
		gr3.setBounds(231, 89, 75, 22);
		panel_3.add(gr3);
		
		
		
		
		JButton btnNewButton = new JButton("Delogare");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principala frprm32=new principala();
				frprm32.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(971, 708, 116, 29);
		contentPane.add(btnNewButton);
	}
}
