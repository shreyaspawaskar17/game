package p1;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class scoreboard extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					scoreboard frame = new scoreboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "shreyas@45");
		    Statement stm = con.createStatement();
		    ResultSet rs = stm.executeQuery("select * from userdetails.scoreboard");

			DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Name", "Performance"}, 0);
			while(rs.next()) {
		    	String Name = rs.getString("Name");
		    	double Performance = rs.getDouble("Performance");
		    	tableModel.addRow(new Object[]{Name, Performance});
		    }
		    table.setModel(tableModel);

			rs.close();
			stm.close();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Create the frame.
	 */
	public scoreboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 10, 342, 232);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		tableModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Performance"
			}
		);
		table.setModel(tableModel);
	}
}
