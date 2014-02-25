package model.window;

import java.util.List;

import model.material.MaterialItem;

public class WindowMtrlNode extends WindowTreeNode {
	
	private MaterialItem item;
	
	public WindowMtrlNode(MaterialItem arg0){
		this.item = arg0;		
	}

	@Override
	public String getName() {
		return item.getItemId() + " - " + item.getItemName();
	}

	@Override
	public void setChildren(List<WindowTreeNode> Children) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<WindowTreeNode> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

}
