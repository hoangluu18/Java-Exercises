package Database_Connection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class bai2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_input;
	private JTable table;
	private JRadioButton radio_id;
	private JRadioButton radio_name;
	private JRadioButton radio_date;
	private JRadioButton radio_address;
	private JRadioButton radio_gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai2 frame = new bai2();
					frame.setTitle("Select");
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
	public bai2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_input = new JTextField();
		textField_input.setBounds(199, 44, 153, 28);
		contentPane.add(textField_input);
		textField_input.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nhap noi dung");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(56, 45, 122, 21);
		contentPane.add(lblNewLabel);
		
		JButton btn_search = new JButton("Search");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String condition = "";
                if (radio_id.isSelected()) {
                    condition = "Id = " + textField_input.getText();
                }
                if (radio_name.isSelected()) {
                    condition = "Name = '" + textField_input.getText() + "'";
                }
                if (radio_date.isSelected()) {
                    condition = "Date = '" + textField_input.getText() + "'";
                }
                if (radio_address.isSelected()) {
                    condition = "Address = '" + textField_input.getText() + "'";
                }
                if (radio_gender.isSelected()) {
                	condition = "Gender = '" + textField_input.getText() + "'";
                }
                
                executeSelectQuery(condition);
				
			}
		});
		btn_search.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_search.setBounds(396, 34, 85, 47);
		contentPane.add(btn_search);
		
		JButton btn_reset = new JButton("Reset");
		btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_input.setText("");
				table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
				if (radio_id.isSelected()) {
					radio_id.setSelected(false);
				}
				if (radio_name.isSelected()) {
					radio_name.setSelected(false);
				}
				if (radio_date.isSelected()) {
					radio_date.setSelected(false);
				}
				if (radio_address.isSelected()) {
                    radio_address.setSelected(false);
                    
				}
				if (radio_gender.isSelected()) {
					radio_gender.setSelected(false);
				}
			}
		});
		btn_reset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_reset.setBounds(522, 34, 85, 47);
		contentPane.add(btn_reset);
		
		JButton btn_exit = new JButton("Exit");
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
							
			}
		});
		btn_exit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_exit.setBounds(638, 34, 85, 47);
		contentPane.add(btn_exit);
		
		JLabel lblTimKiemThoe = new JLabel("Tim kiem theo");
		lblTimKiemThoe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTimKiemThoe.setBounds(69, 134, 122, 24);
		contentPane.add(lblTimKiemThoe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 189, 762, 293);
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
		     
		      radio_id = new JRadioButton("Id");
		      radio_id.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(radio_id.isSelected()) {
              			radio_name.setSelected(false);
              			radio_date.setSelected(false);
              			radio_address.setSelected(false);
              			radio_gender.setSelected(false);
		      		}
		      	}
		      });
		      radio_id.setBounds(234, 133, 39, 27);
		      contentPane.add(radio_id);
		      radio_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		      
		       radio_name = new JRadioButton("Name");
		       radio_name.addActionListener(new ActionListener() {
		       	public void actionPerformed(ActionEvent e) {
		       		if(radio_name.isSelected()) {
              			radio_id.setSelected(false);
              			radio_date.setSelected(false);
              			radio_address.setSelected(false);
              			radio_gender.setSelected(false);
		       		}
		       	}
		       });
		       radio_name.setBounds(307, 133, 65, 27);
		       contentPane.add(radio_name);
		       radio_name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		       
		        radio_date = new JRadioButton("Date");
		        radio_date.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		if(radio_date.isSelected()) {
              			radio_name.setSelected(false);
              			radio_id.setSelected(false);
              			radio_address.setSelected(false);
              			radio_gender.setSelected(false);
		        	}
		        	}
		        });
		        radio_date.setBounds(396, 133, 57, 27);
		        contentPane.add(radio_date);
		        radio_date.setFont(new Font("Tahoma", Font.PLAIN, 15));
		        
		         radio_address = new JRadioButton("Address");
		         radio_address.addActionListener(new ActionListener() {
		         	public void actionPerformed(ActionEvent e) {
		         		if(radio_address.isSelected()) {
              			radio_name.setSelected(false);
              			radio_date.setSelected(false);
              			radio_id.setSelected(false);
              			radio_gender.setSelected(false);
		         	}
		         	}
		         });
		         radio_address.setBounds(489, 133, 79, 27);
		         contentPane.add(radio_address);
		         radio_address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		         
		          radio_gender = new JRadioButton("Gender");
		          radio_gender.addActionListener(new ActionListener() {
		          	public void actionPerformed(ActionEvent e) {
		          		if(radio_gender.isSelected()) {
              			radio_name.setSelected(false);
              			radio_date.setSelected(false);
              			radio_address.setSelected(false);
              			radio_id.setSelected(false);
		          	}
		          	}
		          });
		          radio_gender.setBounds(596, 133, 75, 27);
		          contentPane.add(radio_gender);
		          radio_gender.setFont(new Font("Tahoma", Font.PLAIN, 15));	          
	}
	
	public Connection getConnection() {
		try {	
			String url = "jdbc:mysql://localhost:3306/data";
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
	
	public void executeSelectQuery(String condition) {
		Connection connection = getConnection();
		String query = "SELECT * FROM table2 WHERE " + condition;
		if(connection != null) {
			try {
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				DefaultTableModel model = new DefaultTableModel();
				table.setModel(model);
				
				model.addColumn("Id");
				model.addColumn("Name");
				model.addColumn("Date");
				model.addColumn("Address");
				model.addColumn("Gender");
				
				
				
				while(rs.next()) {
                    int Id = rs.getInt("Id");
                    String Name = rs.getString("Name");
                    String Date = rs.getString("Date");
                    String Address = rs.getString("Address");
                    String Gender = rs.getString("Gender");
                    
                    model.addRow(new Object[] {Id, Name, Date, Address,Gender});
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
}
