package ui.window;

import java.util.List;

import model.window.WindowRootNode;
import model.window.WindowTreeNode;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class WindowContentProvider implements IStructuredContentProvider,
		ITreeContentProvider {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getChildren(Object arg0) {
		WindowTreeNode node = (WindowTreeNode) arg0;
		List list = node.getChildren();

		if (list == null) {
			return new Object[0];
		}
		return list.toArray();
	}

	@Override
	public Object getParent(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object arg0) {
		WindowTreeNode node = (WindowTreeNode) arg0;
		List list = node.getChildren();
		return !(list == null || list.isEmpty());
	}

	@Override
	public Object[] getElements(Object arg0) {
		if(arg0 instanceof List){
			return ((List) arg0).toArray();
		}
		return new Object[0];
	}

}
