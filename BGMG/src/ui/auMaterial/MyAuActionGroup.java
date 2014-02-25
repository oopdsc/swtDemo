package ui.auMaterial;

import helper.ResourcePlugin;
import model.auMaterial.AuxiliaryMaterial;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.actions.ActionGroup;

public class MyAuActionGroup extends ActionGroup {

	private TableViewer tv;

	public MyAuActionGroup(TableViewer tv) {

		this.tv = tv;

	}

	public void fillContextMenu(IMenuManager mgr) {

		MenuManager menuManager = (MenuManager) mgr;

		menuManager.add(new OpenAction());

		menuManager.add(new RefreshAction());

		Table table = tv.getTable();
		Menu menu = menuManager.createContextMenu(table);

		table.setMenu(menu);

	}

	private class OpenAction extends Action {

		public OpenAction() {
			setText(ResourcePlugin.getProperty("auMaterial.creationDlg.menu.open"));
		}

		public void run() {

			IStructuredSelection selection =

			(IStructuredSelection) tv.getSelection();

			AuxiliaryMaterial o = (AuxiliaryMaterial)selection.getFirstElement();

			if (o == null){

				MessageDialog.openInformation(null, null, ResourcePlugin.getProperty("auMaterial.creationDlg.message.noRecord"));

			}else{

				AuxiliaryMaterialCreationDialog micd = new AuxiliaryMaterialCreationDialog(null);
				micd.setAuxiliaryMaterial(o);
				int ret = micd.open();
				
				if(ret == TitleAreaDialog.OK){
					o = micd.getAuxiliaryMaterial();
					tv.refresh();
				}
			}
		}

	}

	private class RefreshAction extends Action {

		public RefreshAction() {
			setText(ResourcePlugin.getProperty("auMaterial.creationDlg.menu.refresh"));
		}

		public void run() {

			tv.refresh();

		}

	}
	}
