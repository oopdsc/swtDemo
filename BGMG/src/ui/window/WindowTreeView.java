package ui.window;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

import service.AppContext;
import ui.material.MyActionGroup;

public class WindowTreeView extends TreeViewer {	
	
	private AppContext context;

	public WindowTreeView(Composite parent, AppContext context) {
		super(parent);
		this.context = context;
		fun1();
	}

	public WindowTreeView(Composite parent, int style, AppContext context) {
		super(parent, style);
		this.context = context;
		fun1();
	}

	public WindowTreeView(Tree tree, AppContext context) {
		super(tree);
		this.context = context;
		fun1();
	}
	
	protected void fun1(){

		this.setContentProvider(new WindowContentProvider());
		this.setLabelProvider(new WindowTreeLabelProvider());
		
		MyTreeActionGroup actionGroup = new MyTreeActionGroup(this, context);  

		actionGroup.fillContextMenu(new MenuManager());
	}
}
