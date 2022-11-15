package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.Client;
import controller.GeneratePdf;
import model.PurchaseOrder;
import model.Requisition;
import model.User;

import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;



public class AccountsPayableFrame extends JFrame {
	//Class Description: Accounts Payable View

	private JPanel contentPane;
	private JTextField txtReqId;
	private JScrollPane reqTableScrollPane;
	private JScrollPane POtableScrollPane;
	private final ButtonGroup approveButtonGroup = new ButtonGroup();
	private JTable requisitionTable;
	private JTable pOTable;
	private JTextField genPOtextField;
	private JLabel userLabel = new JLabel("User:");
	private JLabel deptLabel = new JLabel("Role: ");
	private Client client;
	private User userObj;
	private Requisition requisitionObj;
	private ArrayList<Requisition> requisitionListObj = new ArrayList<Requisition>();
	private PurchaseOrder purchaseOrderObj;
	private ArrayList<PurchaseOrder> PO_ListObj = new ArrayList<PurchaseOrder>();

	public AccountsPayableFrame(Client client, User userObj) {
		this.client= client;
		this.userObj = userObj;
		this.getUserLabel().setText("User: "+ userObj.getf_name() + " " +userObj.getl_name());
		this.getDeptLabel().setText("Role: "+ userObj.getRole());
		
		System.out.println("[NEW VIEW] : Accounts Payable Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1263, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(0, 128, 128));
		topPanel.setBounds(0, 0, 1247, 35);
		contentPane.add(topPanel);
		
		JLabel SystemLabel = new JLabel("Purchase Order System");
		SystemLabel.setForeground(new Color(255, 255, 255));
		SystemLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		topPanel.add(SystemLabel);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(0, 128, 128));
		bottomPanel.setBounds(0, 527, 1247, 34);
		contentPane.add(bottomPanel);
		bottomPanel.setLayout(null);
		
		getUserLabel().setForeground(new Color(0, 0, 0));
		getUserLabel().setBounds(39, 0, 376, 34);
		getUserLabel().setFont(new Font("Tahoma", Font.PLAIN, 18));
		bottomPanel.add(getUserLabel());

		deptLabel.setForeground(new Color(0, 0, 0));
		deptLabel.setBounds(819, 0, 386, 34);
		deptLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bottomPanel.add(deptLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(0, 46, 1247, 430);
		contentPane.add(tabbedPane);
		
		JPanel viewPendingReqPanel = new JPanel();
		viewPendingReqPanel.setLayout(null);
		viewPendingReqPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Pending Requisition", null, viewPendingReqPanel, null);
		
		reqTableScrollPane = new JScrollPane();
		reqTableScrollPane.setBounds(0, 0, 1242, 394);
		viewPendingReqPanel.add(reqTableScrollPane);
		
		JPanel viewAllPurchaseOrderPanel = new JPanel();
		viewAllPurchaseOrderPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("View All Purchase Orders", null, viewAllPurchaseOrderPanel, null);
		viewAllPurchaseOrderPanel.setLayout(new BoxLayout(viewAllPurchaseOrderPanel, BoxLayout.X_AXIS));
		
		POtableScrollPane = new JScrollPane();
		viewAllPurchaseOrderPanel.add(POtableScrollPane);
		checkReq_PO();
		
		JPanel generatePdfPanel = new JPanel();
		generatePdfPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Generate PDF", null, generatePdfPanel, null);
		
		JPanel pdfFormPanel = new JPanel();
		pdfFormPanel.setBackground(Color.WHITE);
		generatePdfPanel.add(pdfFormPanel);
		pdfFormPanel.setLayout(new GridLayout(0, 1, 0, 10));
		
		JLabel lblPurchaseOrderId_1 = new JLabel("Purchase Order ID");
		lblPurchaseOrderId_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pdfFormPanel.add(lblPurchaseOrderId_1);
		
		genPOtextField = new JTextField();
		genPOtextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		genPOtextField.setColumns(25);
		pdfFormPanel.add(genPOtextField);
		
		//Button to generrate PDF for Purchase Order
		JButton generatePdfBtn = new JButton("Generate PDF for Purchase Order");
		generatePdfBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean poExists = false;
				PurchaseOrder purchaseOrderObj = new PurchaseOrder();
				for(int i=0; i < PO_ListObj.size(); i++) {
					if(PO_ListObj.get(i).getPo_id()==Integer.parseInt(genPOtextField.getText())) {
						poExists= true;
						purchaseOrderObj= PO_ListObj.get(i);
						break;
					}	
				}
				if(poExists==true) {
					GeneratePdf.po_id = Integer.toString(purchaseOrderObj.getPo_id());
					GeneratePdf.approving_emp = "Approving Accountant: "+ purchaseOrderObj.getApproving_emp();
					GeneratePdf.dateTime = "Approval Date: "+ purchaseOrderObj.getDateTime();
					GeneratePdf.req_id = "Requisition ID: "+ Integer.toString(purchaseOrderObj.getReq_id());
					GeneratePdf.item_id = "Item ID: "+ Integer.toString(purchaseOrderObj.getItem_id());
					GeneratePdf.item_name = "Item Name: "+ purchaseOrderObj.getItem_name();
					GeneratePdf.quantity = "Quantity: "+ Double.toString(purchaseOrderObj.getQuantity());
					GeneratePdf.unit_price = "Unit Price: "+ Double.toString(purchaseOrderObj.getUnit_price());
					GeneratePdf.total_price = "Total Price: "+ Double.toString(purchaseOrderObj.getTotal_price());
					GeneratePdf.supplier_name = "Supplier Name: "+ purchaseOrderObj.getSupplier_name();
					GeneratePdf.supplier_tel = "Supplier Telephone: "+ purchaseOrderObj.getSupplier_tel();
					GeneratePdf.supplier_email = "Supplier Email: "+ purchaseOrderObj.getSupplier_email();
					GeneratePdf.associated_emp = "Requesting Employee: "+ purchaseOrderObj.getAssociated_emp();
					
					//Document Name
					LocalDateTime localdatetime = LocalDateTime.now();
					
				    DateTimeFormatter dateFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
				    String formattedDate = localdatetime.format(dateFormatObj);
					
					GeneratePdf.document_name = "./generated-pdfs/PO-" +purchaseOrderObj.getPo_id()+ "_generatedAt-"+ formattedDate+ ".pdf";
					try {
						GeneratePdf.createPDF();
						JOptionPane.showMessageDialog(generatePdfBtn, "SUCCESS: PDF Generated for Purchase Order: "+ purchaseOrderObj.getPo_id());
					}catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(generatePdfBtn, "ERROR: Purchase Order Not Found. Does not exist or POs need to be refreshed.");
				}
			}
		});
		generatePdfBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		generatePdfBtn.setBackground(new Color(0, 128, 128));
		pdfFormPanel.add(generatePdfBtn);
		
		txtReqId = new JTextField();
		txtReqId.setText("Requisition ID");
		txtReqId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtReqId.setBounds(32, 481, 180, 35);
		contentPane.add(txtReqId);
		txtReqId.setColumns(10);
		
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
		
		//Button to deny or approve requisition and subsequently create PO id necessary
		JButton createOrDenyButton = new JButton("Create PO/Deny");
		createOrDenyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String changeReqStatus = "";
				if (rdlbtnApprove.isSelected()) { 
					changeReqStatus = "Approve";
                }
                else if (rdbtnDeny.isSelected()) {
  
                	changeReqStatus = "Deny";
                }
				
				if ((txtReqId.getText().length()<1) || (changeReqStatus.length()<1)) {
					JOptionPane.showMessageDialog(createOrDenyButton, "ERROR: Requsition ID field blank/ No option selected.");
				}else {
					boolean reqExists = false;
					for(int i=0; i < requisitionListObj.size(); i++) {
						
						if(requisitionListObj.get(i).getReq_id()==Integer.parseInt(txtReqId.getText())) {
							reqExists= true;
							break;
						}	
					}
					
					if(reqExists==false) {
						JOptionPane.showMessageDialog(createOrDenyButton, "ERROR: ERROR: Invalid Requisition ID. Requisition does not exist or Requisitions needs to be refreshed.");
					}else if(reqExists==true) {
						client.setAction("Accounts- Create PO/Deny Requisition");
						client.sendAction("Accounts- Create PO/Deny Requisition");
						client.sendAction(txtReqId.getText());
						client.sendAction(changeReqStatus);
						client.sendAction(userObj.getf_name() + " " +userObj.getl_name());
						
						if(client.receiveConfirmation()) {
							JOptionPane.showMessageDialog(createOrDenyButton, "Requisition Status Change Successful. Purchase Order Created if Necessary.");
						}else {
							JOptionPane.showMessageDialog(createOrDenyButton, "Requistion Status Change FAIL.");
						}
						
					}
				}

			}
		});
		createOrDenyButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createOrDenyButton.setBackground(new Color(0, 128, 128));
		createOrDenyButton.setBounds(434, 481, 180, 35);
		contentPane.add(createOrDenyButton);
		
		//Button to refresh Purchase Order and requisitions
		JButton refreshButton = new JButton("Refresh Requisition/PO");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkReq_PO();
				JOptionPane.showMessageDialog(refreshButton, "SUCCESS: Requisitions & Purchase Orders Updated");
			}
		});
		refreshButton.setBackground(new Color(0, 128, 128));
		refreshButton.setBounds(1011, 481, 180, 35);
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
	
	//This methods updates the table in view for PO and requisitions
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
					"Requisition ID", "Item ID", "Item Name", "Requested Quantity", "Unit Price", "Total Price", "Supplier Name", "Supplier Tel", "Supplier Email", "Employee Requesting", "Req Status"
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

			model.addRow(rowData);
		}
		
		PO_ListObj = client.receivePOArr();
		
		pOTable = new JTable();
		pOTable.setBackground(new Color(255, 255, 255));
		pOTable.setEnabled(false);
		POtableScrollPane.setViewportView(pOTable);
		pOTable.setModel(new DefaultTableModel(
				new Object[][] {

				},
				new String[] {
					"PO ID", "Approving Accountant", "PO Date", "Requisition ID", "Item ID", "Item Name", "Requested Quantity", "Unit Price", "Total Price", "Supplier Name", "Supplier Tel", "Supplier Email", "Employee Requesting"
				}
			) {
				Class[] columnTypes = new Class[] {
						Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		
		DefaultTableModel model2 = (DefaultTableModel) pOTable.getModel();
		Object rowData2[] = new Object[13];
		
		for (int i=0; i < PO_ListObj.size(); i++) {
			System.out.println(PO_ListObj.toString());
			rowData2[0] = PO_ListObj.get(i).getPo_id();
			rowData2[1] = PO_ListObj.get(i).getApproving_emp();
			rowData2[2] = PO_ListObj.get(i).getDateTime();
			rowData2[3] = PO_ListObj.get(i).getReq_id();
			rowData2[4] = PO_ListObj.get(i).getItem_id();
			rowData2[5] = PO_ListObj.get(i).getItem_name();
			rowData2[6] = PO_ListObj.get(i).getQuantity();
			rowData2[7] = PO_ListObj.get(i).getUnit_price();
			rowData2[8] = PO_ListObj.get(i).getTotal_price();
			rowData2[9] = PO_ListObj.get(i).getSupplier_name();
			rowData2[10] = PO_ListObj.get(i).getSupplier_tel();
			rowData2[11] = PO_ListObj.get(i).getSupplier_email();
			rowData2[12] = PO_ListObj.get(i).getAssociated_emp();

			model2.addRow(rowData2);
		}
		
	}
}
