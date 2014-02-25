package ui.auMaterial;


import model.material.AuxiliaryMaterial;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

public class AuTableViewerLabelProvider implements ITableLabelProvider  {


	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object arg0, int arg1) {
		String retVal = arg0.toString();
		AuxiliaryMaterial m1 = (AuxiliaryMaterial)arg0;
		if(arg1 == 0){
			retVal = m1.getItemName();
		}
		
		if(arg1 == 1){
			retVal = m1.getItemBrand();
		}
		
		if(arg1 == 2){
			retVal = m1.getUnit();
		}
		
		if(arg1 == 3){
			retVal = m1.getPrice().toPlainString();
		}
		
		return retVal;
	}

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
	


}
