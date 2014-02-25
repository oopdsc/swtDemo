package ui.auMaterial;

import helper.ResourcePlugin;
import model.auMaterial.AuxiliaryMaterial;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public class AuMaterialTableViewer extends TableViewer {
	
	private Table table;

	public AuMaterialTableViewer(Composite parent) {
		super(parent);
		fun1();
	}

	public AuMaterialTableViewer(Composite parent, int style) {
		super(parent, style);
		fun1();
	}

	public AuMaterialTableViewer(Table table) {
		super(table);
		fun1();
	}
	
	protected void fun1(){
		
		table = this.getTable();
		
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setBounds(0, 0, 100, 100);
		
		TableViewerColumn valueColumn = new TableViewerColumn(this,
                SWT.CENTER);
        valueColumn.getColumn().setText(ResourcePlugin.getProperty("auMaterial.table.column.name"));
        valueColumn.getColumn().setWidth(150);
        
		TableViewerColumn valueColumn2 = new TableViewerColumn(this,
                SWT.CENTER);
        valueColumn2.getColumn().setText(ResourcePlugin.getProperty("auMaterial.table.column.brand"));
        valueColumn2.getColumn().setWidth(300);
        
		TableViewerColumn valueColumn3 = new TableViewerColumn(this,
                SWT.CENTER);
        valueColumn3.getColumn().setText(ResourcePlugin.getProperty("auMaterial.table.column.unit"));
        valueColumn3.getColumn().setWidth(80);
        
		TableViewerColumn valueColumn4 = new TableViewerColumn(this,
                SWT.CENTER);
        valueColumn4.getColumn().setText(ResourcePlugin.getProperty("auMaterial.table.column.price"));
        valueColumn4.getColumn().setWidth(80);
		
		this.setContentProvider(new AuContentProvider());
		
		this.setLabelProvider(new AuTableViewerLabelProvider());
		
		this.addDoubleClickListener(new IDoubleClickListener(){

			@Override
			public void doubleClick(DoubleClickEvent arg0) {
				IStructuredSelection selection = (IStructuredSelection) arg0.getSelection();
								
				AuxiliaryMaterialCreationDialog micd = new AuxiliaryMaterialCreationDialog(null);
				AuxiliaryMaterial item = (AuxiliaryMaterial)selection.getFirstElement();
				micd.setAuxiliaryMaterial(item);
				int ret = micd.open();
				
				if(ret == TitleAreaDialog.OK){
					item = micd.getAuxiliaryMaterial();
					
					MessageDialog.openInformation(null, "Alert", item.getItemName());
				}

			}
			
		});
		
		MyAuActionGroup actionGroup = new MyAuActionGroup(this);  

		actionGroup.fillContextMenu(new MenuManager());
	}

}
