package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
	
	public User receiveResponse() {
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
}
