package model.window;

import java.util.ArrayList;
import java.util.List;

public class WindowItem{
	
	private String id;
	private String name;
	private List<WindowMaterialItem> items = new ArrayList<WindowMaterialItem>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<WindowMaterialItem> getItems() {
		return items;
	}
	public void setItems(List<WindowMaterialItem> items) {
		this.items = items;
	}
	
	public void addItem(WindowMaterialItem item){
		items.add(item);
	}
}
