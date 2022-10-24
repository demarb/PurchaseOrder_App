package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;

public class InventoryEmployeeFrame extends JFrame {

	private JPanel contentPane;
	private JTable productTable;
	private JTextField itemIDTextField;
	private JTextField itemQuantitytextField;
	private JTextField itemIDTextField_1;
	private JTextField quantityTextField_1;
	private JTextField supplierNameTextField;
	private JTextField supplierTelTextField;
	private JTextField supplierEmailTextField;
	private JTextField unitPricetextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryEmployeeFrame frame = new InventoryEmployeeFrame();
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
	public InventoryEmployeeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(0, 128, 128));
		topPanel.setBounds(0, 0, 934, 35);
		contentPane.add(topPanel);
		
		JLabel SystemLabel = new JLabel("Purchase Order System");
		SystemLabel.setForeground(new Color(255, 255, 255));
		SystemLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		topPanel.add(SystemLabel);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(0, 128, 128));
		bottomPanel.setBounds(0, 527, 934, 34);
		contentPane.add(bottomPanel);
		bottomPanel.setLayout(null);
		
		JLabel userLabel = new JLabel("User:");
		userLabel.setForeground(new Color(0, 0, 0));
		userLabel.setBounds(39, 0, 376, 34);
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bottomPanel.add(userLabel);
		
		JLabel deptLabel = new JLabel("Role: ");
		deptLabel.setForeground(new Color(0, 0, 0));
		deptLabel.setBounds(449, 0, 386, 34);
		deptLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bottomPanel.add(deptLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(0, 46, 934, 430);
		contentPane.add(tabbedPane);
		
		JPanel checkInventoryPanel = new JPanel();
		checkInventoryPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Check Inventory", null, checkInventoryPanel, null);
		checkInventoryPanel.setLayout(new BoxLayout(checkInventoryPanel, BoxLayout.X_AXIS));
		
		JScrollPane checkInventoryScrollPane = new JScrollPane();
		checkInventoryPanel.add(checkInventoryScrollPane);
		
		productTable = new JTable();
		checkInventoryScrollPane.setViewportView(productTable);
		productTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Item ID", "Item Name", "Item Max", "Item Current", "Item Reorder Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		productTable.getColumnModel().getColumn(1).setPreferredWidth(205);
		productTable.getColumnModel().getColumn(4).setPreferredWidth(116);
		productTable.setBackground(new Color(255, 255, 255));
		productTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel updateInventoryPanel = new JPanel();
		updateInventoryPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Update Inventory", null, updateInventoryPanel, null);
		updateInventoryPanel.setLayout(null);
		
		JLabel updateInventoryLabel = new JLabel("Update Inventory");
		updateInventoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		updateInventoryLabel.setBounds(0, 5, 934, 35);
		updateInventoryLabel.setBackground(new Color(255, 255, 255));
		updateInventoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		updateInventoryPanel.add(updateInventoryLabel);
		
		JPanel formPanel = new JPanel();
		formPanel.setBackground(new Color(255, 255, 255));
		formPanel.setBounds(200, 103, 534, 200);
		updateInventoryPanel.add(formPanel);
		formPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel itemIDLabel = new JLabel("Enter Item ID");
		itemIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formPanel.add(itemIDLabel);
		
		itemIDTextField = new JTextField();
		itemIDTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formPanel.add(itemIDTextField);
		itemIDTextField.setColumns(10);
		
		JLabel itemQuantityLabel = new JLabel("Enter New Product Quantity");
		itemQuantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formPanel.add(itemQuantityLabel);
		
		itemQuantitytextField = new JTextField();
		itemQuantitytextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formPanel.add(itemQuantitytextField);
		itemQuantitytextField.setColumns(10);
		
		JButton updateInventoryButton = new JButton("Update Inventory");
		updateInventoryButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateInventoryButton.setBackground(new Color(0, 128, 128));
		formPanel.add(updateInventoryButton);
		
		JPanel createRequisitionPanel = new JPanel();
		createRequisitionPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Create New Requisition", null, createRequisitionPanel, null);
		
		JPanel formPanel_1 = new JPanel();
		formPanel_1.setBackground(Color.WHITE);
		createRequisitionPanel.add(formPanel_1);
		formPanel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel itemIDLabel1 = new JLabel("Item ID");
		itemIDLabel1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formPanel_1.add(itemIDLabel1);
		
		itemIDTextField_1 = new JTextField();
		itemIDTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemIDTextField_1.setColumns(10);
		formPanel_1.add(itemIDTextField_1);
		
		JLabel lblQuantity = new JLabel("Requested Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formPanel_1.add(lblQuantity);
		
		quantityTextField_1 = new JTextField();
		quantityTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		quantityTextField_1.setColumns(10);
		formPanel_1.add(quantityTextField_1);
		
		JLabel lblUnitPrice = new JLabel("Unit Price");
		lblUnitPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formPanel_1.add(lblUnitPrice);
		
		unitPricetextField = new JTextField();
		unitPricetextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		unitPricetextField.setColumns(10);
		formPanel_1.add(unitPricetextField);
		
		JLabel lblNewLabel = new JLabel("Supplier Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formPanel_1.add(lblNewLabel);
		
		supplierNameTextField = new JTextField();
		supplierNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formPanel_1.add(supplierNameTextField);
		supplierNameTextField.setColumns(10);
		
		JLabel lblSupplierTel = new JLabel("Supplier Telephone");
		lblSupplierTel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formPanel_1.add(lblSupplierTel);
		
		supplierTelTextField = new JTextField();
		supplierTelTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierTelTextField.setColumns(10);
		formPanel_1.add(supplierTelTextField);
		
		JLabel lblSupplierEmail = new JLabel("Supplier Email");
		lblSupplierEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formPanel_1.add(lblSupplierEmail);
		
		supplierEmailTextField = new JTextField();
		supplierEmailTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierEmailTextField.setColumns(10);
		formPanel_1.add(supplierEmailTextField);
		
		JButton submitReqButton = new JButton("Submit Requisition for Approval");
		submitReqButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		submitReqButton.setBackground(new Color(0, 128, 128));
		formPanel_1.add(submitReqButton);
		
		JButton refreshButton = new JButton("Refresh Inventory");
		refreshButton.setBackground(new Color(0, 128, 128));
		refreshButton.setBounds(711, 486, 180, 35);
		contentPane.add(refreshButton);
	}
}
