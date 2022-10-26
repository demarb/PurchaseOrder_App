package model;

import java.io.Serializable;

public class User implements Serializable{

	//Attributes
	private String user_id;
	private String password;
	private String f_name;
	private String l_name;
	private String role;
	
	private static final long serialVersionUID = 546675745643453457L;
	
	/**
	 * @param user_id
	 * @param password
	 * @param f_name
	 * @param l_name
	 * @param role
	 */
	
	//Constructors
	public User() {
		this.user_id = "";
		this.password = "";
		this.f_name = "";
		this.l_name = "";
		this.role = "";
	}
	
	public User(String user_id, String password, String f_name, String l_name, String role) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.f_name = f_name;
		this.l_name = l_name;
		this.role = role;
	}

	

	//Getters and setters
	public String getuser_id() {
		return user_id;
	}

	public void setuser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getf_name() {
		return f_name;
	}

	public void setf_name(String f_name) {
		this.f_name = f_name;
	}

	public String getl_name() {
		return l_name;
	}

	public void setl_name(String l_name) {
		this.l_name = l_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", password=" + password + ", f_name=" + f_name + ", l_name=" + l_name + ", role="
				+ role + "]";
	}

	
	
	
	
	
	
}
