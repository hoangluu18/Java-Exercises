package Database_Connection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class bai1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_input_path;
	private JTextField textField_query;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai1 frame = new bai1();
					frame.setTitle("Database Programing");
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
	public bai1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 991, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Input Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(136, 44, 195, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblSqlQuery = new JLabel("SQL Query");
		lblSqlQuery.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSqlQuery.setBounds(136, 81, 117, 27);
		contentPane.add(lblSqlQuery);
		
		textField_input_path = new JTextField();
		textField_input_path.setBounds(341, 41, 636, 19);
		contentPane.add(textField_input_path);
		textField_input_path.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Id");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(26, 140, 45, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Name");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(258, 140, 45, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(497, 140, 164, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Total");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(732, 140, 45, 13);
		contentPane.add(lblNewLabel_1_4);
		
		textField_query = new JTextField();
		textField_query.setColumns(10);
		textField_query.setBounds(341, 87, 320, 19);
		contentPane.add(textField_query);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Insert", "Update", "Delete"}));
		comboBox.setBounds(671, 86, 306, 21);
		contentPane.add(comboBox);
		
		JButton btn_submit = new JButton("Submit");
		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = textField_input_path.getText();
				String query = textField_query.getText();
				String type = comboBox.getSelectedItem().toString();

				if (comboBox.getSelectedItem().toString().equalsIgnoreCase("select") && query.toLowerCase().contains("select")) {
					executeSelectQuery(query, path);
				}
				else if (comboBox.getSelectedItem().toString().equalsIgnoreCase("insert")
						&& query.toLowerCase().contains("insert")) {
					executeUpdateQuery(query, path);
				} else if (comboBox.getSelectedItem().toString().equalsIgnoreCase("update")
						&& query.toLowerCase().contains("update")) {
					executeUpdateQuery(query, path);
				} else if (comboBox.getSelectedItem().toString().equalsIgnoreCase("delete")
						&& query.toLowerCase().contains("delete")) {
					executeUpdateQuery(query, path);
				} else {
					System.out.println("Invalid query or type");
				}
			}
		});
		btn_submit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_submit.setBounds(111, 504, 92, 21);
		contentPane.add(btn_submit);
		
		JButton btn_reset = new JButton("Reset");
		btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_input_path.setText("");
				textField_query.setText("");
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
						}
					));
			}
		});
		btn_reset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_reset.setBounds(448, 504, 117, 21);
		contentPane.add(btn_reset);
		
		JButton btn_submit_cancel = new JButton("Cancel");
		btn_submit_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btn_submit_cancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_submit_cancel.setBounds(794, 504, 85, 21);
		contentPane.add(btn_submit_cancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 161, 967, 333);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		
		
	}
	
	public Connection getConnection(String url) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String urlPath = url;
			String user = "root";
			String password = "Pmshoanghot1@"; // password of your mysql server
			Connection con = DriverManager.getConnection(urlPath,user, password);
			return con;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void executeSelectQuery(String query, String path) {
		Connection connection = getConnection(path);
		if(connection != null) {
			try {
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				DefaultTableModel model = new DefaultTableModel();
				table.setModel(model);
				
				model.addColumn("Id");
				model.addColumn("Name");
				model.addColumn("Address");
				model.addColumn("Total");
				
				while(rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("Name");
                    String address = rs.getString("Address");
                    int total = rs.getInt("Total");
                    
                    model.addRow(new Object[] {id, name, address, total});
                }
				connection.close();
				stmt.close();
				rs.close();
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void executeUpdateQuery(String query, String path) {
		Connection connection = getConnection(path);
		if (connection != null) {
			try {
				Statement stmt = connection.createStatement();
				int rowAffected = stmt.executeUpdate(query);
				System.out.println("Row affected: " + rowAffected);
				connection.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
