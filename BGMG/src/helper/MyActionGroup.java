package helper;

import model.material.MaterialItem;

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

import ui.material.MaterialItemCreationDialog;

public class MyActionGroup extends ActionGroup {

	private TableViewer tv;

	public MyActionGroup(TableViewer tv) {

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
			setText("打开");
		}

		public void run() {

			IStructuredSelection selection =

			(IStructuredSelection) tv.getSelection();

			MaterialItem o = (MaterialItem)selection.getFirstElement();

			if (o == null){

				MessageDialog.openInformation(null, null, "请先选择记录");

			}else{

				MaterialItemCreationDialog micd = new MaterialItemCreationDialog(null);
				micd.setMaterialItem(o);
				int ret = micd.open();
				
				if(ret == TitleAreaDialog.OK){
					o = micd.getMaterialItem();
					tv.refresh();
				}
			}
		}

	}

	private class RefreshAction extends Action {

		public RefreshAction() {
			setText("刷新");
		}

		public void run() {

			tv.refresh();

		}

	}
	}
