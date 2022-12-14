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

public class Client {
	//Class Description: Client definition. Handles socket connection between server and
	//facilitates the transmission of objects over the connection
	
	private Socket connectionSocket;
	private ObjectOutputStream objOs;
	private ObjectInputStream objIs;
	private String action = "";
	private boolean isConnected = false;

	public Client() {
		this.createConnection();
		this.configureStreams();
	}
	
	//Connect to server socket
	private void createConnection(){
		try {
			//Create a socket to connect to the server
			connectionSocket = new Socket("127.0.0.1", 7000);
		}catch (IOException ex) {
			System.out.println("Failed to Connect to Server");
			ex.printStackTrace();
		}
	}
	
	//Configure object streams for data transmission
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
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendAction(String action) { 
		try {
			objOs.writeObject(action);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendRequisition(Requisition requisitionObj) { 
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
	
	public boolean isConnected() {
		return isConnected;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}

	public User receiveUser() {
		User userObj = new User();
		
		try {
			System.out.println("[RECEIVING RESPONSE FOR ACTION] : "+  this.getAction());
			if (this.getAction().equalsIgnoreCase("Login")){
				boolean flag = (boolean) objIs.readObject();
				this.setConnected(flag);
				if(flag==true) {
					userObj = (User) objIs.readObject();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return userObj;
	}	
	
	public ArrayList receiveProdArr() {
		ArrayList<Product> productListObj = new ArrayList<Product>();
		
		try {
			System.out.println("[RECEIVING RESPONSE FOR ACTION] : "+  this.getAction());
			if (this.getAction().equalsIgnoreCase("Employee- Check Inventory")){
				
				productListObj = (ArrayList<Product>) objIs.readObject();
					
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return productListObj;
	}
	
	public ArrayList receiveReqArr() {
		ArrayList<Requisition> requisitionListObj = new ArrayList<Requisition>();
		
		try {
			System.out.println("[RECEIVING RESPONSE FOR ACTION] : "+  this.getAction());
			if (this.getAction().equalsIgnoreCase("Accounts- Check Requisition and PO")){
				
				requisitionListObj = (ArrayList<Requisition>) objIs.readObject();
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return requisitionListObj;
	}
	
	public ArrayList receivePOArr() {
		ArrayList<PurchaseOrder> PO_ListObj = new ArrayList<PurchaseOrder>();
		
		try {
			System.out.println("[RECEIVING RESPONSE FOR ACTION] : "+  this.getAction());
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
			System.out.println("[RECEIVING RESPONSE FOR ACTION] : "+  this.getAction());
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
