package model;

import java.io.Serializable;

public class Product implements Serializable{
	//Class Description: Product model definition

	//Attribute
	private int item_id;
	private String item_name;
	private int item_max;
	private int item_current;
	private String item_reorder_status;

	private static final long serialVersionUID = 643453457546675745L;
	
	
	//Constructors 
	public Product() {
		
		this.item_id = 0;
		this.item_name = "";
		this.item_max = 0;
		this.item_current = 0;
		this.item_reorder_status = "";
	}
	
	public Product(int item_id, String item_name, int item_max, int item_current, String item_reorder_status) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_max = item_max;
		this.item_current = item_current;
		this.item_reorder_status = item_reorder_status;
	}
	
	//Getters and setters
	public int getitem_id() {
		return item_id;
	}
	public void setitem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getitem_name() {
		return item_name;
	}
	public void setitem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getitem_max() {
		return item_max;
	}
	public void setitem_max(int item_max) {
		this.item_max = item_max;
	}
	public int getitem_current() {
		return item_current;
	}
	public void setitem_current(int item_current) {
		this.item_current = item_current;
	}
	public String getitem_reorder_status() {
		return item_reorder_status;
	}
	public void setitem_reorder_status(String item_reorder_status) {
		this.item_reorder_status = item_reorder_status;
	}
	
	@Override
	public String toString() {
		return "Product [item_id=" + item_id + ", item_name=" + item_name + ", item_max=" + item_max + ", item_current="
				+ item_current + ", item_reorder_status=" + item_reorder_status + "]";
	}

}
