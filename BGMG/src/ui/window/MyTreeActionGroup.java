package ui.window;

import model.material.MaterialItem;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.actions.ActionGroup;

public class MyTreeActionGroup extends ActionGroup {

	private TreeViewer tv;

	public MyTreeActionGroup(TreeViewer tv) {

		this.tv = tv;

	}

	public void fillContextMenu(IMenuManager mgr) {

		MenuManager menuManager = (MenuManager) mgr;

		menuManager.add(new OpenAction());

		menuManager.add(new RefreshAction());
		
		menuManager.add(new AddAction());

		Tree tree = tv.getTree();
		
		Menu menu = menuManager.createContextMenu(tree);

		tree.setMenu(menu);

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

				MessageDialog.openInformation(null, null, "请先选择记录2");
			}
		}

	}
	
	private class AddAction extends Action {

		public AddAction() {
			setText("添加");
		}

		public void run() {

			WindowItemCreationDialog wicd = new WindowItemCreationDialog(null);
			wicd.open();
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
