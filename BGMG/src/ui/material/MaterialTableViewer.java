package ui.material;

import helper.ResourcePlugin;
import model.material.MaterialItem;

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

public class MaterialTableViewer extends TableViewer {
	
	private Table table;

	public MaterialTableViewer(Composite parent) {
		super(parent);
		fun1();
	}

	public MaterialTableViewer(Composite parent, int style) {
		super(parent, style);
		fun1();
	}

	public MaterialTableViewer(Table table) {
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
        valueColumn.getColumn().setText(ResourcePlugin.getProperty("material.table.column.id"));
        valueColumn.getColumn().setWidth(150);
        
		TableViewerColumn valueColumn2 = new TableViewerColumn(this,
                SWT.CENTER);
        valueColumn2.getColumn().setText(ResourcePlugin.getProperty("material.table.column.name"));
        valueColumn2.getColumn().setWidth(300);
        
		TableViewerColumn valueColumn3 = new TableViewerColumn(this,
                SWT.CENTER);
        valueColumn3.getColumn().setText(ResourcePlugin.getProperty("material.table.column.midu"));
        valueColumn3.getColumn().setWidth(80);
		
		this.setContentProvider(new ContentProvider());
		
		this.setLabelProvider(new TableViewerLabelProvider());
		
		this.addDoubleClickListener(new IDoubleClickListener(){

			@Override
			public void doubleClick(DoubleClickEvent arg0) {
				IStructuredSelection selection = (IStructuredSelection) arg0.getSelection();
								
				MaterialItemCreationDialog micd = new MaterialItemCreationDialog(null);
				MaterialItem item = (MaterialItem)selection.getFirstElement();
				micd.setMaterialItem(item);
				int ret = micd.open();
				
				if(ret == TitleAreaDialog.OK){
					item = micd.getMaterialItem();
					
					MessageDialog.openInformation(null, "Alert", item.getItemName());
				}

			}
			
		});
		
		MyActionGroup actionGroup = new MyActionGroup(this);  

		actionGroup.fillContextMenu(new MenuManager());
	}

}
