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
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;

public class InventorySupervisorFrame extends JFrame {

	private JPanel contentPane;
	private JTable requsitionTable;
	private JTextField txtRequisitionId;
	private final ButtonGroup approveButtonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventorySupervisorFrame frame = new InventorySupervisorFrame();
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
	public InventorySupervisorFrame() {
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
		
		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setBounds(0, 80, 934, 390);
		contentPane.add(tableScrollPane);
		
		requsitionTable = new JTable();
		tableScrollPane.setViewportView(requsitionTable);
		requsitionTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Requisition ID", "Item ID", "Item Name", "Requested Quantity", "Unit Price", "Total Price", "Supplier Name", "Supplier Tel", "Supplier Email", "Req Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Integer.class, Float.class, Integer.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		requsitionTable.getColumnModel().getColumn(0).setPreferredWidth(77);
		requsitionTable.getColumnModel().getColumn(1).setPreferredWidth(72);
		requsitionTable.getColumnModel().getColumn(2).setPreferredWidth(77);
		requsitionTable.getColumnModel().getColumn(3).setPreferredWidth(110);
		requsitionTable.getColumnModel().getColumn(7).setPreferredWidth(116);
		requsitionTable.setBackground(new Color(255, 255, 255));
		requsitionTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtRequisitionId = new JTextField();
		txtRequisitionId.setText("Requisition ID");
		txtRequisitionId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRequisitionId.setBounds(32, 481, 180, 35);
		contentPane.add(txtRequisitionId);
		txtRequisitionId.setColumns(10);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		submitButton.setBackground(new Color(0, 128, 128));
		submitButton.setBounds(434, 481, 180, 35);
		contentPane.add(submitButton);
		
		JButton refreshButton = new JButton("Refresh");
		refreshButton.setBackground(new Color(0, 128, 128));
		refreshButton.setBounds(707, 481, 190, 35);
		contentPane.add(refreshButton);
		
		JLabel ReqLabel = new JLabel("Approve/Deny Request for Requisition");
		ReqLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ReqLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ReqLabel.setBounds(0, 35, 934, 45);
		contentPane.add(ReqLabel);
		
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
	}
}
