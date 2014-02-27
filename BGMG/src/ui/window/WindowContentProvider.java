package ui.window;

import java.util.List;

import model.window.WindowItem;
import model.window.WindowRootNode;
import model.window.WindowTreeNode;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class WindowContentProvider implements ITreeContentProvider {

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
		if (arg0 instanceof List)
			return ((List<?>) arg0).toArray();
		if (arg0 instanceof WindowRootNode)
			return ((WindowRootNode) arg0).getChildren().toArray();
		if (arg0 instanceof WindowItem)
			return ((WindowItem) arg0).getItems().toArray();
		return new Object[0];
	}

	@Override
	public Object[] getElements(Object arg0) {
		return getChildren(arg0);
	}

	@Override
	public Object getParent(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object arg0) {
		if (arg0 instanceof List)
			return ((List<?>) arg0).toArray().length > 0;
		if (arg0 instanceof WindowRootNode)
			return ((WindowRootNode) arg0).getChildren().size() > 0;
		if (arg0 instanceof WindowItem)
			return ((WindowItem) arg0).getItems().size() > 0;
		return false;
	}



}
