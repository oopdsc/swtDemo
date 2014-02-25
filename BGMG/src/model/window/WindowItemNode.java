package model.window;

import java.util.List;

public class WindowItemNode extends WindowTreeNode {
	
	private WindowItem item;
	private List<WindowTreeNode> children;
	
	public WindowItemNode(WindowItem arg0){
		item = arg0;
	}

	@Override
	public String getName() {
		return item.getName() + item.getId();
	}

	@Override
	public void setChildren(List<WindowTreeNode> Children) {
		children = Children;

	}

	@Override
	public List<WindowTreeNode> getChildren() {
		return children;
	}

}
