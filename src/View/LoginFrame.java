package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Client;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.User;


public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userPasswordField; //formally JPasswordField
	private JTextField userIdTextField;
	
	Client client = new Client();
	User user = new User();
	
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 465);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(0, 128, 128));
		topPanel.setBounds(0, 0, 773, 35);
		contentPane.add(topPanel);
		
		JLabel SystemLabel = new JLabel("Purchase Order System");
		SystemLabel.setForeground(new Color(255, 255, 255));
		SystemLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		topPanel.add(SystemLabel);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(0, 128, 128));
		bottomPanel.setBounds(0, 392, 773, 34);
		contentPane.add(bottomPanel);
		bottomPanel.setLayout(null);
		
		JLabel userLabel = new JLabel("User:");
		userLabel.setForeground(new Color(0, 0, 0));
		userLabel.setBounds(10, 0, 376, 34);
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bottomPanel.add(userLabel);
		
		JLabel deptLabel = new JLabel("Role: ");
		deptLabel.setForeground(new Color(0, 0, 0));
		deptLabel.setBounds(386, 0, 386, 34);
		deptLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bottomPanel.add(deptLabel);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(Color.WHITE);
		loginPanel.setBounds(180, 169, 379, 150);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		JPanel loginGrpPanel = new JPanel();
		loginGrpPanel.setBounds(0, 0, 379, 150);
		loginPanel.add(loginGrpPanel);
		loginGrpPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		userIdTextField = new JTextField();
		userIdTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userIdTextField.setToolTipText("Enter company id");
		userIdTextField.setText("User ID");
		loginGrpPanel.add(userIdTextField);
		userIdTextField.setColumns(10);
		
		userPasswordField = new JTextField(); //
		userPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginGrpPanel.add(userPasswordField);
		userPasswordField.setToolTipText("Enter Password");
		userPasswordField.setColumns(20);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User userObj = new User();
				user.setuser_id(userIdTextField.getText());
				user.setPassword(userPasswordField.getText());
				System.out.println("[LOGIN] : Login Information received.");
				
				client.setAction("Login");
				client.sendAction("Login");
				client.sendAction(user.getuser_id());
				client.sendAction(user.getPassword());
				
				userObj = client.receiveUser();
				
				if (client.isConnected()) {
					user.setuser_id(userObj.getuser_id());
					user.setPassword(userObj.getPassword());
					user.setf_name(userObj.getf_name());
					user.setl_name(userObj.getl_name());
					user.setRole(userObj.getRole());
					
					userLabel.setText("User: "+ user.getf_name() + " " +user.getl_name());
					deptLabel.setText("Role: "+ user.getRole());
					
					if(user.getRole().equalsIgnoreCase("employee")) {
						InventoryEmployeeFrame inventoryEmpFrame = new InventoryEmployeeFrame(client, userObj);
						inventoryEmpFrame.setVisible(true);
						disposeFrame();
					}else if(user.getRole().equalsIgnoreCase("accounts")) {
						AccountsPayableFrame accountsPayFrame = new AccountsPayableFrame(client, userObj);
						accountsPayFrame.setVisible(true);
						disposeFrame();
						
					}
				}else {
					JOptionPane.showMessageDialog(loginButton, "Login Unsuccessful: ID/Password Incorrect.");
				}
			}
		});
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginButton.setForeground(new Color(0, 0, 0));
		loginGrpPanel.add(loginButton);
		loginButton.setBackground(new Color(0, 128, 128));
		
		JLabel companyNameLabel = new JLabel("Company Name");
		companyNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		companyNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		companyNameLabel.setBounds(180, 88, 379, 51);
		contentPane.add(companyNameLabel);
	}
	
	public void disposeFrame() {
		this.setVisible(false);
	}
	
	
}
