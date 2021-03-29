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
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modul3_4 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBoxId;
	private JTextField t8;
	private JTextField t7;
	private JTextField t6;
	private JTextField t5;
	private JTextField t4;
	private JTextField t3;
	private JTextField t2;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modul3_4 frame = new modul3_4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void refreshTable() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
			String sql="Select * from raport_medical ";
			Statement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		}catch(Exception e2) {System.out.print(e2);}
	}
	public void fillComboBox() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
			String sqls="Select * from raport_medical;";
			PreparedStatement pst=con.prepareStatement(sqls);
			ResultSet rss=pst.executeQuery();
			
			while(rss.next()) {
				comboBoxId.addItem(rss.getInt("id_fisa"));//+" "+rs.getString("Nume")+" "+rs.getString("Prenume"));
				//System.out.println("");
			}
			
			con.close();
			
		}catch(Exception e2) {System.out.print(e2);}
	}
	/**
	 * Create the frame.
	 */
	public modul3_4() {
		setTitle("Policlinica");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\PROIECT BD\\hospital-plus-logo-914E10A64D-seeklogo.com.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200,700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Vizualizare raporte medicale");
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql="Select * from raport_medical ";
					Statement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
				}catch(Exception e2) {System.out.print(e2);}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(512, 40, 415, 50);
		contentPane.add(btnNewButton);
		
		JButton btnVizualizareIstoricPacienti = new JButton("adaugare");
		btnVizualizareIstoricPacienti.setBackground(new Color(124, 252, 0));
		btnVizualizareIstoricPacienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e4) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql1="insert into raport_medical"+ " values "+ "("+t1.getText()+","+ t2.getText()+",\""+ t3.getText()+"\",\""+t4.getText()+"\",\""+ t5.getText()+"\",\""+ t6.getText()+"\",\""+ t7.getText()+"\","+ t8.getText()+" );" ;
					PreparedStatement pst=con2.prepareStatement(sql1);
					
					pst.execute(sql1);
					JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					
					con2.close();
				}catch(Exception e3) {System.out.print(e4);}
				refreshTable();
			}
		});
		btnVizualizareIstoricPacienti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVizualizareIstoricPacienti.setBounds(123, 491, 166, 50);
		contentPane.add(btnVizualizareIstoricPacienti);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(334, 125, 827, 356);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					int row=table.getSelectedRow();
					String idul=(table.getModel().getValueAt(row,0)).toString();
					//String sql1="select * from utilizatori where id_utilizator='"+idul+"'";
					String sql1="select * from raport_medical where id_fisa="+idul+";";
					PreparedStatement pst=con2.prepareStatement(sql1);
				//	pst.setString(1, (String)comboBoxId.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
						t1.setText(rs.getString("id_fisa"));
						t2.setText(rs.getString("id_programare"));
						t3.setText(rs.getString("istoric"));
						t4.setText(rs.getString("simptome"));
						t5.setText(rs.getString("investigatii"));
						t6.setText(rs.getString("diagnostic"));
						t7.setText(rs.getString("recomandari"));
						t8.setText(rs.getString("validare"));
						
						
					}
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("Cautare dupa id");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(517, 491, 117, 29);
		contentPane.add(lblNewLabel_2);
		
		 comboBoxId = new JComboBox();
		comboBoxId.setBounds(654, 488, 192, 38);
		contentPane.add(comboBoxId);
		
		JButton btnCautare = new JButton("Cautare");
		btnCautare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					//String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
					String sql1="select * from raport_medical where id_fisa="+comboBoxId.getSelectedItem()+";";
					PreparedStatement pst=con2.prepareStatement(sql1);
				//	pst.setString(1, (String)comboBoxId.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
						t8.setText(rs.getString("id_fisa"));
						t6.setText(rs.getString("id_programare"));
						t5.setText(rs.getString("observatii"));
						t4.setText(rs.getString("complicatii"));
						t3.setText(rs.getString("recomandari"));
						
					}
					//JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					con2.close();
				}catch(Exception e6) {System.out.print(e6);}
			}
		});
		btnCautare.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCautare.setBounds(882, 491, 95, 29);
		contentPane.add(btnCautare);
		
		JButton btnDelogare = new JButton("Delogare");
		btnDelogare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principala pm3=new principala();
				pm3.show();
				dispose();
			}
		});
		
		btnDelogare.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelogare.setBounds(1043, 583, 117, 29);
		contentPane.add(btnDelogare);
		
		t8 = new JTextField();
		t8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t8.setEditable(false);
		t8.setText("-1");
		t8.setColumns(10);
		t8.setBounds(160, 414, 150, 30);
		contentPane.add(t8);
		
		JLabel lblNewLabel_2_12_1_4 = new JLabel("validare");
		lblNewLabel_2_12_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_12_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_12_1_4.setBounds(24, 412, 126, 29);
		contentPane.add(lblNewLabel_2_12_1_4);
		
		JLabel lblNewLabel_2_12_1_3 = new JLabel("recomandari");
		lblNewLabel_2_12_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_12_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_12_1_3.setBounds(24, 367, 126, 29);
		contentPane.add(lblNewLabel_2_12_1_3);
		
		t7 = new JTextField();
		t7.setColumns(10);
		t7.setBounds(160, 364, 150, 30);
		contentPane.add(t7);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(160, 324, 150, 30);
		contentPane.add(t6);
		
		JLabel lblNewLabel_2_12_1_2 = new JLabel("diagnostic");
		lblNewLabel_2_12_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_12_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_12_1_2.setBounds(24, 322, 126, 29);
		contentPane.add(lblNewLabel_2_12_1_2);
		
		JLabel lblNewLabel_2_12_1_1 = new JLabel("investigatii");
		lblNewLabel_2_12_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_12_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_12_1_1.setBounds(24, 277, 126, 29);
		contentPane.add(lblNewLabel_2_12_1_1);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(160, 279, 150, 30);
		contentPane.add(t5);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(160, 227, 150, 30);
		contentPane.add(t4);
		
		JLabel lblNewLabel_2_12_1 = new JLabel("simptome");
		lblNewLabel_2_12_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_12_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_12_1.setBounds(24, 225, 126, 29);
		contentPane.add(lblNewLabel_2_12_1);
		
		JLabel lblNewLabel_2_12 = new JLabel("istoric");
		lblNewLabel_2_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_12.setBounds(24, 175, 126, 29);
		contentPane.add(lblNewLabel_2_12);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(160, 177, 150, 30);
		contentPane.add(t3);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(160, 133, 150, 30);
		contentPane.add(t2);
		
		JLabel lblNewLabel_2_11 = new JLabel("id_programare");
		lblNewLabel_2_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_11.setBounds(24, 133, 126, 29);
		contentPane.add(lblNewLabel_2_11);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(160, 93, 150, 30);
		contentPane.add(t1);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
			
			String sql1="select max(id_fisa)+1 as idp from raport_medical  ;";
			PreparedStatement pst=con2.prepareStatement(sql1);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {

				t1.setText(rs.getString("idp"));
			}
			if(t1.getText().equals("")) {
				t1.setText("1");
			}
			//JOptionPane.showMessageDialog(null," Successfully ");
			
			pst.close();
			con2.close();
		}catch(Exception e6) {System.out.print(e6);}
		
		JLabel lblNewLabel_2_9 = new JLabel("id_fisa");
		lblNewLabel_2_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_9.setBounds(24, 93, 126, 29);
		contentPane.add(lblNewLabel_2_9);
		
		JButton btnModificare = new JButton("modificare");
		btnModificare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=btsbts43");
					String sql1="update raport_medical"+ " set "+ "id_programare="+ t2.getText()+", istoric=\""+ t3.getText()+"\", simptome= \""+t4.getText()+"\", investigatii=\""+ t5.getText()+"\",diagnostic= \""+ t6.getText()+"\", recomandari= \""+ t7.getText()+"\", validare="+ t8.getText()+" where id_fisa="+t1.getText()+" ;" ;
					PreparedStatement pst=con2.prepareStatement(sql1);
					
					pst.execute(sql1);
					JOptionPane.showMessageDialog(null," Successfully ");
					
					pst.close();
					
					con2.close();
				}catch(Exception e3) {System.out.print(e);}
				refreshTable();
			}
		});
		btnModificare.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModificare.setBackground(new Color(124, 252, 0));
		btnModificare.setBounds(123, 570, 166, 50);
		contentPane.add(btnModificare);
		fillComboBox();
	}
}
