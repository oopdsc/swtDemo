package model.material;

import java.math.BigDecimal;

public class MaterialItem {
	
	private String itemName;
	private String itemId;
	private BigDecimal itemMidu;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public BigDecimal getItemMidu() {
		return itemMidu;
	}
	public void setItemMidu(BigDecimal itemMidu) {
		this.itemMidu = itemMidu;
	}
	
	

}

