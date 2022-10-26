package model;

public class Supplier {

	//Attributes
	private String supplierName;
	private String supplierTel;
	private String supplierEmail;

	//Constructor
	public Supplier(String supplierName, String supplierTel, String supplierEmail) {
		super();
		this.supplierName = supplierName;
		this.supplierTel = supplierTel;
		this.supplierEmail = supplierEmail;
	}

	//Getters and setters
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierTel() {
		return supplierTel;
	}

	public void setSupplierTel(String supplierTel) {
		this.supplierTel = supplierTel;
	}

	public String getSupplierEmail() {
		return supplierEmail;
	}

	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}

	@Override
	public String toString() {
		return "Supplier [supplierName=" + supplierName + ", supplierTel=" + supplierTel + ", supplierEmail="
				+ supplierEmail + "]";
	}
	
	
	
	
	
	
}
