package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import javax.swing.JRadioButton;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.Client;
import model.Product;
import model.Requisition;
import model.User;

import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;



public class AccountsPayableFrame extends JFrame {

	private JPanel contentPane;
	private JTextField itemIDTextField_1;
	private JTextField quantityTextField_1;
	private JTextField supplierNameTextField;
	private JTextField supplierTelTextField;
	private JTextField supplierEmailTextField;
	private JTextField unitPricetextField;
	private JTextField txtPOId;
	private JScrollPane reqTableScrollPane;
	private final ButtonGroup approveButtonGroup = new ButtonGroup();
	private JTable requisitionTable;
	private JTable pOTable;
	private JTextField POTextField;
	private JTextField textField;
	private JLabel userLabel = new JLabel("User:");
	private JLabel deptLabel = new JLabel("Role: ");
	private Client client;
	private User userObj;
	private Requisition requisitionObj;
	private ArrayList<Requisition> requisitionListObj = new ArrayList<Requisition>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AccountsPayableFrame frame = new AccountsPayableFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AccountsPayableFrame(Client client, User userObj) {
		this.client= client;
		this.userObj = userObj;
		this.getUserLabel().setText("User: "+ userObj.getf_name() + " " +userObj.getl_name());
		this.getDeptLabel().setText("Role: "+ userObj.getRole());
		
		
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
		
		getUserLabel().setForeground(new Color(0, 0, 0));
		getUserLabel().setBounds(39, 0, 376, 34);
		getUserLabel().setFont(new Font("Tahoma", Font.PLAIN, 18));
		bottomPanel.add(getUserLabel());
		
//		JLabel userLabel = new JLabel("User:");
//		userLabel.setForeground(new Color(0, 0, 0));
//		userLabel.setBounds(39, 0, 376, 34);
//		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		bottomPanel.add(userLabel);
		
//		JLabel deptLabel = new JLabel("Role: ");
		deptLabel.setForeground(new Color(0, 0, 0));
		deptLabel.setBounds(449, 0, 386, 34);
		deptLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bottomPanel.add(deptLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(0, 46, 934, 430);
		contentPane.add(tabbedPane);
		
		JPanel viewPendingReqPanel = new JPanel();
		viewPendingReqPanel.setLayout(null);
		viewPendingReqPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Pending Requisition", null, viewPendingReqPanel, null);
		
		reqTableScrollPane = new JScrollPane();
		reqTableScrollPane.setBounds(0, 0, 929, 394);
		viewPendingReqPanel.add(reqTableScrollPane);
		checkReq_PO();
		
//		requisitionTable = new JTable();
//		requisitionTable.setEnabled(false);
//		reqTableScrollPane.setViewportView(requisitionTable);
//		requisitionTable.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null},
//			},
//			new String[] {
//				"Requisition ID", "Item ID", "Item Name", "Requested Quantity", "Unit Price", "Total Price", "Supplier Name", "Supplier Tel", "Supplier Email", "Supervisor", "Req Status"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				Integer.class, Integer.class, String.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
		
		JPanel viewAllPurchaseOrderPanel = new JPanel();
		viewAllPurchaseOrderPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("View All Purchase Orders", null, viewAllPurchaseOrderPanel, null);
		viewAllPurchaseOrderPanel.setLayout(new BoxLayout(viewAllPurchaseOrderPanel, BoxLayout.X_AXIS));
		
		JScrollPane POtableScrollPane = new JScrollPane();
		viewAllPurchaseOrderPanel.add(POtableScrollPane);
		
		pOTable = new JTable();
		POtableScrollPane.setViewportView(pOTable);
		pOTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Purchase ID", "Requisition ID", "Item ID", "Item Name", "Requested Quantity", "Unit Price", "Total Price", "Supplier Name", "Supplier Tel", "Supplier Email", "Supervisor", "Accounts Employee", "PO Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, String.class, Integer.class, Float.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		pOTable.getColumnModel().getColumn(1).setPreferredWidth(77);
		pOTable.getColumnModel().getColumn(2).setPreferredWidth(72);
		pOTable.getColumnModel().getColumn(3).setPreferredWidth(77);
		pOTable.getColumnModel().getColumn(4).setPreferredWidth(110);
		pOTable.getColumnModel().getColumn(8).setPreferredWidth(116);
		pOTable.setBackground(new Color(255, 255, 255));
		pOTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel updatePOPanel = new JPanel();
		updatePOPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Update Purchase Order", null, updatePOPanel, null);
		
		JPanel updatePOFormPanel_1 = new JPanel();
		updatePOFormPanel_1.setBackground(Color.WHITE);
		updatePOPanel.add(updatePOFormPanel_1);
		updatePOFormPanel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel POIDLabel1 = new JLabel("Purchase Order ID");
		POIDLabel1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updatePOFormPanel_1.add(POIDLabel1);
		
		itemIDTextField_1 = new JTextField();
		itemIDTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemIDTextField_1.setColumns(10);
		updatePOFormPanel_1.add(itemIDTextField_1);
		
		JLabel lblQuantity = new JLabel("Requested Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updatePOFormPanel_1.add(lblQuantity);
		
		quantityTextField_1 = new JTextField();
		quantityTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		quantityTextField_1.setColumns(25);
		updatePOFormPanel_1.add(quantityTextField_1);
		
		JLabel lblUnitPrice = new JLabel("Unit Price");
		lblUnitPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updatePOFormPanel_1.add(lblUnitPrice);
		
		unitPricetextField = new JTextField();
		unitPricetextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		unitPricetextField.setColumns(10);
		updatePOFormPanel_1.add(unitPricetextField);
		
		JLabel lblNewLabel = new JLabel("Supplier Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updatePOFormPanel_1.add(lblNewLabel);
		
		supplierNameTextField = new JTextField();
		supplierNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updatePOFormPanel_1.add(supplierNameTextField);
		supplierNameTextField.setColumns(10);
		
		JLabel lblSupplierTel = new JLabel("Supplier Telephone");
		lblSupplierTel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updatePOFormPanel_1.add(lblSupplierTel);
		
		supplierTelTextField = new JTextField();
		supplierTelTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierTelTextField.setColumns(10);
		updatePOFormPanel_1.add(supplierTelTextField);
		
		JLabel lblSupplierEmail = new JLabel("Supplier Email");
		lblSupplierEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updatePOFormPanel_1.add(lblSupplierEmail);
		
		supplierEmailTextField = new JTextField();
		supplierEmailTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierEmailTextField.setColumns(10);
		updatePOFormPanel_1.add(supplierEmailTextField);
		
		JButton updateReqButton = new JButton("Update PO");
		updateReqButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateReqButton.setBackground(new Color(0, 128, 128));
		updatePOFormPanel_1.add(updateReqButton);
		
		JPanel deletePOPanel = new JPanel();
		tabbedPane.addTab("Delete Purchase Order", null, deletePOPanel, null);
		
		JPanel deleteFormPanel = new JPanel();
		deleteFormPanel.setBackground(Color.WHITE);
		deletePOPanel.add(deleteFormPanel);
		deleteFormPanel.setLayout(new GridLayout(0, 1, 0, 10));
		
		JLabel lblPurchaseOrderId = new JLabel("Purchase Order ID");
		lblPurchaseOrderId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteFormPanel.add(lblPurchaseOrderId);
		
		POTextField = new JTextField();
		POTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		POTextField.setColumns(25);
		deleteFormPanel.add(POTextField);
		
		JButton deletePOButton = new JButton("Delete Purchase Order");
		deletePOButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deletePOButton.setBackground(new Color(0, 128, 128));
		deleteFormPanel.add(deletePOButton);
		
		JPanel generatePdfPanel = new JPanel();
		tabbedPane.addTab("Generate PDF", null, generatePdfPanel, null);
		
		JPanel pdfFormPanel = new JPanel();
		pdfFormPanel.setBackground(Color.WHITE);
		generatePdfPanel.add(pdfFormPanel);
		pdfFormPanel.setLayout(new GridLayout(0, 1, 0, 10));
		
		JLabel lblPurchaseOrderId_1 = new JLabel("Purchase Order ID");
		lblPurchaseOrderId_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pdfFormPanel.add(lblPurchaseOrderId_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(25);
		pdfFormPanel.add(textField);
		
		JButton generatePdfBtn = new JButton("Generate PDF for Purchase Order");
		generatePdfBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		generatePdfBtn.setBackground(new Color(0, 128, 128));
		pdfFormPanel.add(generatePdfBtn);
		
		txtPOId = new JTextField();
		txtPOId.setText("Purchase Order ID");
		txtPOId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPOId.setBounds(32, 481, 180, 35);
		contentPane.add(txtPOId);
		txtPOId.setColumns(10);
		
		JRadioButton rdlbtnApprove = new JRadioButton("Approve");
		approveButtonGroup.add(rdlbtnApprove);
		rdlbtnApprove.setBackground(new Color(0, 128, 128));
		rdlbtnApprove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdlbtnApprove.setBounds(234, 481, 91, 35);
		contentPane.add(rdlbtnApprove);
		
		JRadioButton rdbtnDeny = new JRadioButton("Deny");
		approveButtonGroup.add(rdbtnDeny);
		rdbtnDeny.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnDeny.setBackground(new Color(0, 128, 128));
		rdbtnDeny.setBounds(333, 481, 91, 35);
		contentPane.add(rdbtnDeny);
		
		JButton createOrDenyButton = new JButton("Create PO/Deny");
		createOrDenyButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createOrDenyButton.setBackground(new Color(0, 128, 128));
		createOrDenyButton.setBounds(434, 481, 180, 35);
		contentPane.add(createOrDenyButton);
		
		JButton refreshButton = new JButton("Refresh Requisition/PO");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkReq_PO();
				JOptionPane.showMessageDialog(refreshButton, "SUCCESS: Requisitions & Purchase Orders Updated");
			}
		});
		refreshButton.setBackground(new Color(0, 128, 128));
		refreshButton.setBounds(711, 486, 180, 35);
		contentPane.add(refreshButton);
	}
	
	public JLabel getUserLabel() {
		return userLabel;
	}

	public void setUserLabel(JLabel userLabel) {
		this.userLabel = userLabel;
	}

	public JLabel getDeptLabel() {
		return deptLabel;
	}

	public void setDeptLabel(JLabel deptLabel) {
		this.deptLabel = deptLabel;
	}
	
	public void checkReq_PO() {
		client.setAction("Accounts- Check Requisition and PO");
		client.sendAction("Accounts- Check Requisition and PO");
		
		requisitionListObj = client.receiveReqArr();
		
		requisitionTable = new JTable();
		requisitionTable.setEnabled(false);
		reqTableScrollPane.setViewportView(requisitionTable);
		requisitionTable.setModel(new DefaultTableModel(
				new Object[][] {

				},
				new String[] {
					"Requisition ID", "Item ID", "Item Name", "Requested Quantity", "Unit Price", "Total Price", "Supplier Name", "Supplier Tel", "Supplier Email", "Supervisor", "Req Status"
				}
			) {
				Class[] columnTypes = new Class[] {
						Integer.class, Integer.class, String.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		
		DefaultTableModel model = (DefaultTableModel) requisitionTable.getModel();
		Object rowData[] = new Object[11];
		
		for (int i=0; i < requisitionListObj.size(); i++) {
			System.out.println(requisitionListObj.toString()); 
			rowData[0] = requisitionListObj.get(i).getReq_id();
			rowData[1] = requisitionListObj.get(i).getItem_id();
			rowData[2] = requisitionListObj.get(i).getItem_name();
			rowData[3] = requisitionListObj.get(i).getQuantity();
			rowData[4] = requisitionListObj.get(i).getUnit_price();
			rowData[5] = requisitionListObj.get(i).getTotal_price();
			rowData[6] = requisitionListObj.get(i).getSupplier_name();
			rowData[7] = requisitionListObj.get(i).getSupplier_tel();
			rowData[8] = requisitionListObj.get(i).getSupplier_email();
			rowData[9] = requisitionListObj.get(i).getAssociated_emp();
			rowData[10] = requisitionListObj.get(i).getReq_status();
//			rowData.toString();
			model.addRow(rowData);
		}
		
		
	}
}
