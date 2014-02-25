package service;

import java.util.ArrayList;
import java.util.List;

import model.material.MaterialItem;
import model.window.WindowItem;
import model.window.WindowItemNode;
import model.window.WindowMtrlNode;
import model.window.WindowRootNode;
import model.window.WindowTreeNode;

public class WindowService {
	
	private WindowRootNode node;
	private List<WindowRootNode> rootNodes;
	private List<WindowTreeNode> mtrlNodes;
	private List<WindowTreeNode> treeNodes;
	
	public WindowService(){
		init();
	}
	
	protected void init(){		
		createWdMtrlNode();
		createTreeNode();
		createRootNode();
	}

	private void createRootNode() {
		node = new WindowRootNode();
		node.setChildren(treeNodes);	
		rootNodes = new ArrayList<WindowRootNode>();
		rootNodes.add(node);
	}

	private void createTreeNode() {
		treeNodes = new ArrayList<WindowTreeNode>();
		
		WindowItem item = new WindowItem();
		item.setId("id1");
		item.setName("name1");
		WindowTreeNode node1 = new WindowItemNode(item);
		node1.setChildren(mtrlNodes);
		
		treeNodes.add(node1);
	}

	private void createWdMtrlNode() {
		mtrlNodes = new ArrayList<WindowTreeNode>();
		
		MaterialItem item = new MaterialItem();
		item.setItemId("id12");
		item.setItemName("name12");
		WindowTreeNode node1 = new WindowMtrlNode(item);
		
		mtrlNodes.add(node1);
	}

	public List<WindowRootNode> getNode() {
		return rootNodes;
	}
	
	

}
