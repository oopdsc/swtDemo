package ui.window;

import model.window.WindowTreeNode;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class WindowTreeLabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object element) {
		// TODO Auto-generated method stub
		return super.getImage(element);
	}

	@Override
	public String getText(Object element) {
		WindowTreeNode node = (WindowTreeNode)element;
		return node.getName();
	}

}
