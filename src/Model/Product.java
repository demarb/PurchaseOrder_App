package Model;

public class Product {

	//Attribute
	private String itemId;
	private String itemName;
	private String itemMax;
	private String itemCurrent;
	private String itemReorderStatus;
	
	
	//Constructors 
	/**
	 * @param itemId
	 * @param itemName
	 * @param itemMax
	 * @param itemCurrent
	 * @param itemReorderStatus
	 */
	public Product(String itemId, String itemName, String itemMax, String itemCurrent, String itemReorderStatus) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemMax = itemMax;
		this.itemCurrent = itemCurrent;
		this.itemReorderStatus = itemReorderStatus;
	}
	
	//Getters and setters
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
	public String getItemMax() {
		return itemMax;
	}
	public void setItemMax(String itemMax) {
		this.itemMax = itemMax;
	}
	public String getItemCurrent() {
		return itemCurrent;
	}
	public void setItemCurrent(String itemCurrent) {
		this.itemCurrent = itemCurrent;
	}
	public String getItemReorderStatus() {
		return itemReorderStatus;
	}
	public void setItemReorderStatus(String itemReorderStatus) {
		this.itemReorderStatus = itemReorderStatus;
	}
	
	
	@Override
	public String toString() {
		return "Product [itemId=" + itemId + ", itemName=" + itemName + ", itemMax=" + itemMax + ", itemCurrent="
				+ itemCurrent + ", itemReorderStatus=" + itemReorderStatus + "]";
	}
	
	
	
	
	
	
}
