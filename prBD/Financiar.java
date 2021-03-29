package prBD;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Financiar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Financiar frame = new Financiar();
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
	public Financiar() {
		setTitle("Policlinica");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\PROIECT BD\\hospital-plus-logo-914E10A64D-seeklogo.com.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Administrator financiar");
		btnNewButton.setBounds(117, 157, 361, 55);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrator_log f=new Administrator_log();
				f.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnNewButton_1 = new JButton("Salarii");
		btnNewButton_1.setBounds(207, 282, 156, 55);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salariu f=new Salariu();
				f.show();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblNewLabel = new JLabel("Operatii financiar contabile");
		lblNewLabel.setForeground(new Color(0, 51, 204));
		lblNewLabel.setBounds(77, 10, 449, 43);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		
		JButton btnNewButton_2 = new JButton("Inapoi");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principala finp=new principala();
				finp.show();
				dispose();
			}
		});
		btnNewButton_2.setBounds(5, 455, 118, 43);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.setLayout(null);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\PROIECT BD\\giphy (1).gif"));
		lblNewLabel_1.setBounds(-14, 0, 614, 531);
		contentPane.add(lblNewLabel_1);
	}
}
