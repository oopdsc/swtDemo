package ui.window;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

public class WindowTreeView extends TreeViewer {
	
	

	public WindowTreeView(Composite parent) {
		super(parent);
		fun1();
	}

	public WindowTreeView(Composite parent, int style) {
		super(parent, style);
		fun1();
	}

	public WindowTreeView(Tree tree) {
		super(tree);
		fun1();
	}
	
	protected void fun1(){
		this.setContentProvider(new WindowContentProvider());
		this.setLabelProvider(new WindowTreeLabelProvider());
	}
}
