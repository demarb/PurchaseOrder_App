package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import model.Product;
import model.PurchaseOrder;
import model.Requisition;
import model.User;
import view.InventoryEmployeeFrame;
import view.LoginFrame;

public class Client {
	
	private Socket connectionSocket;
	private ObjectOutputStream objOs;
	private ObjectInputStream objIs;
	private String action = "";
	
	public Client() {
		this.createConnection();
		this.configureStreams();
//		this.getLoginScreen();
	}
	
	private void createConnection(){
		try {
			//Create a socket to connect to the server
			connectionSocket = new Socket("127.0.0.1", 7000);
		}catch (IOException ex) {
			System.out.println("Failed to Connect to Server");
			ex.printStackTrace();
		}
	}
	
	private void configureStreams() {
		try {
			objIs = new ObjectInputStream(connectionSocket.getInputStream());
			objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			objOs.close();
			objIs.close();
			connectionSocket.close();
		}catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void sendAction(String action) { 
//		this.setAction(action);
		try {
			objOs.writeObject(action);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendRequisition(Requisition requisitionObj) { 
//		this.setAction(action);
		try {
			objOs.writeObject(requisitionObj);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void setAction(String action) {
		this.action=  action;
	}
	
	public String getAction() {
		return action;
	}
	
	

//	public void getLoginScreen(){
//		LoginFrame loginFrame = new LoginFrame();
//		loginFrame.setVisible(true);
//		
//		
//	}
	
//	public User receiveResponse() {
//		User userObj = new User();
//		
//		
//		try {
//			if (this.getAction().equalsIgnoreCase("Login")){
//				boolean flag = (boolean) objIs.readObject();
//				if(flag==true) {
//					System.out.println("Login Correct");
//					userObj = (User) objIs.readObject();
//					
//					
////					new InventoryEmployeeFrame();
//				}else {
//					System.out.println("Login Incorrect");
//					
//					
//				}
//			}else {
//				System.out.println("Login not detected");
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return userObj;
//	}
	
	public ObjectOutputStream getObjOs() {
		return objOs;
	}

	public void setObjOs(ObjectOutputStream objOs) {
		this.objOs = objOs;
	}

	public ObjectInputStream getObjIs() {
		return objIs;
	}

	public void setObjIs(ObjectInputStream objIs) {
		this.objIs = objIs;
	}

	public User receiveUser() {
		User userObj = new User();
		
		try {
			System.out.println("test action: "+this.getAction());
			if (this.getAction().equalsIgnoreCase("Login")){
				boolean flag = (boolean) objIs.readObject();
				if(flag==true) {
					System.out.println("Login Correct");
					userObj = (User) objIs.readObject();
					
					
					
//					new InventoryEmployeeFrame();
				}else {
					System.out.println("Login Incorrect");
					
					
					
				}
//			}else {
//				System.out.println("Login not detected");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return userObj;
	}	
	
	public ArrayList receiveProdArr() {
		Product productObj = new Product();
		ArrayList<Product> productListObj = new ArrayList<Product>();
		
		try {
			System.out.println("test action: "+this.getAction());
			if (this.getAction().equalsIgnoreCase("Employee- Check Inventory")){
				
				
				productListObj = (ArrayList<Product>) objIs.readObject();
					
					
					
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return productListObj;
	}
	
	public ArrayList receiveReqArr() {
		Requisition requisitionObj = new Requisition();
		ArrayList<Requisition> requisitionListObj = new ArrayList<Requisition>();
		
		try {
			System.out.println("test action: "+this.getAction());
			if (this.getAction().equalsIgnoreCase("Accounts- Check Requisition and PO")){
				
				requisitionListObj = (ArrayList<Requisition>) objIs.readObject();
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return requisitionListObj;
	}
	
	public ArrayList receivePOArr() {
		PurchaseOrder purchaseOrderObj = new PurchaseOrder();
		ArrayList<PurchaseOrder> PO_ListObj = new ArrayList<PurchaseOrder>();
		
		try {
			System.out.println("test action: "+this.getAction());
			if (this.getAction().equalsIgnoreCase("Accounts- Check Requisition and PO")){
				
				PO_ListObj = (ArrayList<PurchaseOrder>) objIs.readObject();
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return PO_ListObj;
	}
	
	public boolean receiveConfirmation() {
		boolean confirmation = false;
		
		try {
			System.out.println("test action: "+this.getAction());
			if (this.getAction().equalsIgnoreCase("Employee- Update Inventory")){
				confirmation = (Boolean) objIs.readObject();
					

			}else if (this.getAction().equalsIgnoreCase("Employee- Create Requisition")){
				confirmation = (Boolean) objIs.readObject();
				
					

			}else if (this.getAction().equalsIgnoreCase("Accounts- Create PO/Deny Requisition")){
				confirmation = (Boolean) objIs.readObject();
				
					

			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return confirmation;
	}
	
	
}
