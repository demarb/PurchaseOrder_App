package model;

public class Requisition {

	//Attributes
	private String requisitionId;
	private String itemId;
	private String itemName;
	private float quantity;
	private float unitPrice;
	private float totalPrice;
	private Supplier supplierObj;
	private String requisitionStatus;


	//Constructor
	public Requisition(String requisitionId, String itemId, String itemName, float quantity, float unitPrice,
			float totalPrice, Supplier supplierObj, String requisitionStatus) {
		super();
		this.requisitionId = requisitionId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.supplierObj = supplierObj;
		this.requisitionStatus = requisitionStatus;
	}

	//Getters and setters
	public String getRequisitionId() {
		return requisitionId;
	}


	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}


	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public float getQuantity() {
		return quantity;
	}


	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}


	public float getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}


	public float getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Supplier getSupplierObj() {
		return supplierObj;
	}


	public void setSupplierObj(Supplier supplierObj) {
		this.supplierObj = supplierObj;
	}


	public String getRequisitionStatus() {
		return requisitionStatus;
	}


	public void setRequisitionStatus(String requisitionStatus) {
		this.requisitionStatus = requisitionStatus;
	}

	@Override
	public String toString() {
		return "Requisition [requisitionId=" + requisitionId + ", itemId=" + itemId + ", itemName=" + itemName
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice
				+ ", supplierObj=" + supplierObj + ", requisitionStatus=" + requisitionStatus + "]";
	}
	
	
	
}
