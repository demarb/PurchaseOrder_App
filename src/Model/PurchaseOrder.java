package model;

import java.io.Serializable;

public class PurchaseOrder implements Serializable{
	//Class Description: PurchaseOrder model definition
	
	//Attributes
	private int po_id;
	private int req_id;
	private String approving_emp;
	private String dateTime;
	
	private int item_id;
	private String item_name;
	private double quantity;
	private double unit_price;
	private double total_price;
	private String supplier_name;
	private String supplier_tel;
	private String supplier_email;
	private String associated_emp;
	private String req_status;
	
	private static final long serialVersionUID = 534754574466756435L;
	
	public PurchaseOrder() {
		super();
		this.po_id = 0;
		this.req_id = 0;
		this.approving_emp = "";
		this.dateTime = "";
	}
	
	public PurchaseOrder(int po_id, int req_id, String approving_emp, String dateTime) {
		super();
		this.po_id = po_id;
		this.req_id = req_id;
		this.approving_emp = approving_emp;
		this.dateTime = dateTime;
	}
	
	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getSupplier_tel() {
		return supplier_tel;
	}

	public void setSupplier_tel(String supplier_tel) {
		this.supplier_tel = supplier_tel;
	}

	public String getSupplier_email() {
		return supplier_email;
	}

	public void setSupplier_email(String supplier_email) {
		this.supplier_email = supplier_email;
	}

	public String getAssociated_emp() {
		return associated_emp;
	}

	public void setAssociated_emp(String associated_emp) {
		this.associated_emp = associated_emp;
	}

	public String getReq_status() {
		return req_status;
	}

	public void setReq_status(String req_status) {
		this.req_status = req_status;
	}

	public int getPo_id() {
		return po_id;
	}

	public void setPo_id(int po_id) {
		this.po_id = po_id;
	}

	public int getReq_id() {
		return req_id;
	}

	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}

	public String getApproving_emp() {
		return approving_emp;
	}

	public void setApproving_emp(String approving_emp) {
		this.approving_emp = approving_emp;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [getItem_id()=" + getItem_id() + ", getItem_name()=" + getItem_name() + ", getQuantity()="
				+ getQuantity() + ", getUnit_price()=" + getUnit_price() + ", getTotal_price()=" + getTotal_price()
				+ ", getSupplier_name()=" + getSupplier_name() + ", getSupplier_tel()=" + getSupplier_tel()
				+ ", getSupplier_email()=" + getSupplier_email() + ", getAssociated_emp()=" + getAssociated_emp()
				+ ", getReq_status()=" + getReq_status() + ", getPo_id()=" + getPo_id() + ", getReq_id()=" + getReq_id()
				+ ", getApproving_emp()=" + getApproving_emp() + ", getDateTime()=" + getDateTime() + "]";
	}
	

	
}
