package Model;

public class User {

	//Attributes
	private String userID;
	private String password;
	private String fName;
	private String lName;
	private String role;
	
	/**
	 * @param userID
	 * @param password
	 * @param fName
	 * @param lName
	 * @param role
	 */
	
	//Constructors
	public User(String userID, String password, String fName, String lName, String role) {
		super();
		this.userID = userID;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.role = role;
	}

	

	//Getters and setters
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [userID=" + userID + ", password=" + password + ", fName=" + fName + ", lName=" + lName + ", role="
				+ role + "]";
	}

	
	
	
	
	
	
}
