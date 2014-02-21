package ui;

import helper.ContentProvider;
import helper.MyActionGroup;
import helper.ResourcePlugin;
import helper.TableViewerLabelProvider;
import model.material.MaterialItem;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import service.MaterialService;
import ui.material.AuxiliaryMaterialCreationDialog;
import ui.material.MaterialItemCreationDialog;

import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;

public class MainUI extends ApplicationWindow {
	private DataBindingContext m_bindingContext;
	private TableViewer tableViewer;
	private MaterialService mtrlService;
	private Table table;
	private CTabFolder tabFolder;
	private Composite container;

	/**
	 * Create the application window.
	 */
	public MainUI() {
		super(null);	
		
		mtrlService = new MaterialService();
		
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
		
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		
		tabFolder = new CTabFolder(container, SWT.BORDER);
		tabFolder.setBounds(0, 0, 434, 189);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		tableViewer = new TableViewer(tabFolder, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		
		CTabItem tbtmNewItem = new CTabItem(tabFolder, SWT.CLOSE);
		tbtmNewItem.setText(ResourcePlugin.getProperty("material.list.tabName"));
		tbtmNewItem.setControl(table);
				
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setBounds(0, 0, 100, 100);		
		
		TableViewerColumn valueColumn = new TableViewerColumn(tableViewer,
                SWT.CENTER);
        valueColumn.getColumn().setText(ResourcePlugin.getProperty("material.table.column.id"));
        valueColumn.getColumn().setWidth(150);
        
		TableViewerColumn valueColumn2 = new TableViewerColumn(tableViewer,
                SWT.CENTER);
        valueColumn2.getColumn().setText(ResourcePlugin.getProperty("material.table.column.name"));
        valueColumn2.getColumn().setWidth(300);
        
		TableViewerColumn valueColumn3 = new TableViewerColumn(tableViewer,
                SWT.CENTER);
        valueColumn3.getColumn().setText(ResourcePlugin.getProperty("material.table.column.midu"));
        valueColumn3.getColumn().setWidth(80);
		
		tableViewer.setContentProvider(new ContentProvider());
		
		tableViewer.setInput(mtrlService.getAllRecords());

		tableViewer.setLabelProvider(new TableViewerLabelProvider());
		
		tableViewer.addDoubleClickListener(new IDoubleClickListener(){

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
		
		MyActionGroup actionGroup = new MyActionGroup(tableViewer);  

		actionGroup.fillContextMenu(new MenuManager());		
		
		m_bindingContext = initDataBindings();
		
		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
		
	}

	/**
	 * Create the menu manager.
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		
		MenuManager fileMenu = new MenuManager(ResourcePlugin.getProperty("menu.file"));
		menuManager.add(fileMenu);
		
		IAction materialItemAction = new Action(ResourcePlugin.getProperty("menu.new.materialItem")){

			@Override
			public void run() {
				super.run();
				MaterialItemCreationDialog micd = new MaterialItemCreationDialog(null);
				MaterialItem item = new MaterialItem();
				micd.setMaterialItem(item);
				int ret = micd.open();
				
				if(ret == TitleAreaDialog.OK){
					item = micd.getMaterialItem();
					mtrlService.add(item);
					
					tableViewer.refresh();
				}

			}
			
		};
		
		IAction auMaterialItemAction = new Action(ResourcePlugin.getProperty("menu.new.auMaterialItem")){

			@Override
			public void run() {
				super.run();
				AuxiliaryMaterialCreationDialog micd = new AuxiliaryMaterialCreationDialog(null);
				MaterialItem item = new MaterialItem();
				micd.setMaterialItem(item);
				int ret = micd.open();
				
				if(ret == TitleAreaDialog.OK){
					item = micd.getMaterialItem();
					mtrlService.add(item);
					
					tableViewer.refresh();
				}

			}
			
		};
		
		MenuManager cascadingMenu = new MenuManager(ResourcePlugin.getProperty("menu.new"));
		cascadingMenu.add(materialItemAction);
		cascadingMenu.add(auMaterialItemAction);
		fileMenu.add(cascadingMenu);
		
		// Add the actions to the File menu
		//fileMenu.add(newAction);
		//IAction openAction = new Action("Open"){
			
		//};
		//fileMenu.add(openAction);
		//IAction saveAction = new Action("Save"){
			
		//};
//		fileMenu.add(saveAction);
//		IAction saveAsAction = new Action("Save As"){
//			
//		};;
//		fileMenu.add(saveAsAction);
//
//		// Create the cascading menu
//		MenuManager cascadingMenu = new MenuManager("Cascading");
//		cascadingMenu.add(newAction);
//		cascadingMenu.add(openAction);
//		cascadingMenu.add(saveAction);
//		cascadingMenu.add(saveAsAction);
//		fileMenu.add(cascadingMenu);
//
//		// Create the More Cascading menu
//		MenuManager moreCascading = new MenuManager("More Cascading");
//		IAction aboutAction = new Action("about"){
//			
//		};
//		moreCascading.add(aboutAction);
//		cascadingMenu.add(moreCascading);
//
//		// Create the rest of File's actions
//		fileMenu.add(new Separator());
//		IAction exitAction = new Action("exit"){
//			
//		};
//		fileMenu.add(exitAction);
		
		
		return menuManager;
	}

	/**
	 * Create the toolbar manager.
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		return toolBarManager;
	}

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		Display display = Display.getDefault();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
					window.setBlockOnOpen(true);
					window.open();
					Display.getCurrent().dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(ResourcePlugin.getProperty("app.name"));
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(600, 450);
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeBoundsTabObserveWidget = WidgetProperties.bounds().observe(tabFolder);
		IObservableValue observeBoundsContainerObserveWidget = WidgetProperties.bounds().observe(container);
		bindingContext.bindValue(observeBoundsTabObserveWidget, observeBoundsContainerObserveWidget, null, null);
		//
		
		//IObservableValue observeBoundsTableObserveWidget = WidgetProperties.bounds().observe(table);
		//bindingContext.bindValue(observeBoundsTableObserveWidget, observeBoundsContainerObserveWidget, null, null);
		return bindingContext;
	}
}
