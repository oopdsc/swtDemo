package model.window;

import helper.ResourcePlugin;

import java.util.List;

public class WindowRootNode extends WindowTreeNode {
	
	private String nodeName = "";
	private List<WindowTreeNode> children;
	
	public WindowRootNode(){
		nodeName = ResourcePlugin.getProperty("window.tree.rootNode.name");
	}

	@Override
	public String getName() {
		return nodeName;
	}

	@Override
	public void setChildren(List<WindowTreeNode> Children) {
		System.out.println(Children.get(0).getName());
		children = Children;
	}

	@Override
	public List<WindowTreeNode> getChildren() {
		//System.out.println(children);
		return children;
	}

}
