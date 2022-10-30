package model;

public class Requisition {

	//Attributes
	private int req_id;
	private int item_id;
	private String item_name;
	private float quantity;
	private float unit_price;
	private float total_price;
	private String req_supplier_name;
	private String req_supplier_tel;
	private String req_supplier_email;
	private String req_status;
	
	public Requisition(int req_id, int item_id, String item_name, float quantity, float unit_price,
			float total_price, String req_supplier_name, String req_supplier_tel, String req_supplier_email,
			String req_status) {
		
		this.req_id = req_id;
		this.item_id = item_id;
		this.item_name = item_name;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.total_price = total_price;
		this.req_supplier_name = req_supplier_name;
		this.req_supplier_tel = req_supplier_tel;
		this.req_supplier_email = req_supplier_email;
		this.req_status = req_status;
	}
	



	
}
