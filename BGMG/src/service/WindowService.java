package service;

import java.util.ArrayList;
import java.util.List;

import model.material.MaterialItem;
import model.window.WindowItem;
import model.window.WindowItemNode;
import model.window.WindowMaterialItem;
import model.window.WindowMtrlNode;
import model.window.WindowRootNode;
import model.window.WindowTreeNode;

public class WindowService {
	
	private List<WindowRootNode> rootNodes;	
	private WindowRootNode root;
	
	public WindowService(){
		init();
	}
	
	
	
	protected void init(){	
		
		createWdMtrlNode();
		createTreeNode();
		createRootNode();
	}

	private void createRootNode() {
		
		rootNodes = new ArrayList<WindowRootNode>();
		root = new WindowRootNode();
		root.setChildren(createTreeNode());
		rootNodes.add(root);
		
		//node = new WindowRootNode();
		//node.setChildren(treeNodes);
		//rootNodes = new ArrayList<WindowRootNode>();
		//rootNodes.add(node);
	}

	private List<WindowItem> createTreeNode() {
		List<WindowItem> treeNodes = new ArrayList<WindowItem>();
		
		WindowItem item = new WindowItem();
		item.setId("id1");
		item.setName("name1");
		
		item.setItems(createWdMtrlNode());
		
		treeNodes.add(item);
		return treeNodes;
	}

	private List<WindowMaterialItem> createWdMtrlNode() {
		List<WindowMaterialItem> mtrlNodes = new ArrayList<WindowMaterialItem>();
		
		MaterialItem mtrl = new MaterialItem();		
		mtrl.setItemId("id12");
		mtrl.setItemName("name12");
		
		WindowMaterialItem item = new WindowMaterialItem(mtrl);
		item.setCmpFormula("formula1");
		mtrlNodes.add(item);
		
		mtrl = new MaterialItem();		
		mtrl.setItemId("id122");
		mtrl.setItemName("name122");
		WindowMaterialItem item2 = new WindowMaterialItem(mtrl);
		item2.setCmpFormula("formula12");
		
		mtrlNodes.add(item2);
		return mtrlNodes;
	}

	public List<WindowRootNode> getNode() {
		return rootNodes;
	}
	
	public void addWindowItem(WindowItem item){
		root.addChild(item);
	}
	
	

}
