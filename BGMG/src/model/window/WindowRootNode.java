package model.window;

import helper.ResourcePlugin;

import java.util.List;

public class WindowRootNode{
	
	private String nodeName = "";
	private List<WindowItem> children;
	
	public WindowRootNode(){
		nodeName = ResourcePlugin.getProperty("window.tree.rootNode.name");
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public List<WindowItem> getChildren() {
		return children;
	}

	public void setChildren(List<WindowItem> children) {
		this.children = children;
	}

	public void addChild(WindowItem item){
		this.children.add(item);
	}


}
