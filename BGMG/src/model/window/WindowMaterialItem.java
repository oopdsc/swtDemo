package model.window;

import java.math.BigDecimal;

import model.material.MaterialItem;

public class WindowMaterialItem{
	
	private String cmpFormula;
	private MaterialItem item;
	
	public WindowMaterialItem(MaterialItem item) {
		super();
		this.item = item;
	}

	public String getCmpFormula() {
		return cmpFormula;
	}

	public void setCmpFormula(String cmpFormula) {
		this.cmpFormula = cmpFormula;
	}

	public String getItemName() {
		return item.getItemName();
	}

	public String getItemId() {
		return item.getItemId();
	}


	public BigDecimal getItemMidu() {
		return item.getItemMidu();
	}


}
