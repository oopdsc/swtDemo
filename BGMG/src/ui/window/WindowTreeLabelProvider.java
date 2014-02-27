package ui.window;

import model.window.WindowMaterialItem;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

public class WindowTreeLabelProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int arg1) {
		switch (arg1) {
		case 0:
			return element.toString();
		case 1:
			if (element instanceof WindowMaterialItem)
				return ((WindowMaterialItem) element).getItemName();
		case 2:
			if (element instanceof WindowMaterialItem)
				return ((WindowMaterialItem) element).getCmpFormula();
		}
		return null;
	}

}
