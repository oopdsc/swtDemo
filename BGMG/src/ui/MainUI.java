package ui;

import helper.ResourcePlugin;
import model.auMaterial.AuxiliaryMaterial;
import model.material.MaterialItem;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

import service.AppContext;
import service.AuMaterialService;
import service.MaterialService;
import service.WindowService;
import ui.auMaterial.AuMaterialTableViewer;
import ui.auMaterial.AuxiliaryMaterialCreationDialog;
import ui.material.MaterialItemCreationDialog;
import ui.material.MaterialTableViewer;
import ui.window.WindowTreeView;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;

public class MainUI extends ApplicationWindow {
	private DataBindingContext m_bindingContext;
	private TableViewer tableViewer;
	
	private TableViewer auTableViewer;
	
	private Tree tree;
	private Composite composite;
	private TreeViewer treeViewer;
	
	private AppContext context;
	
	private CTabFolder tabFolder;
	private Composite container;

	/**
	 * Create the application window.
	 */
	public MainUI() {
		super(null);
		
		context = new AppContext();
		
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
		
		tableViewer = new MaterialTableViewer(tabFolder, SWT.BORDER | SWT.FULL_SELECTION);
		
		CTabItem tbtmNewItem = new CTabItem(tabFolder, SWT.NULL); 	//as no open function, so can not close
		tbtmNewItem.setText(ResourcePlugin.getProperty("material.list.tabName"));
		tbtmNewItem.setControl(tableViewer.getTable());
		
		tableViewer.setInput(context.getMtrlService().getAllRecords());
		
		
		auTableViewer= new AuMaterialTableViewer(tabFolder, SWT.BORDER | SWT.FULL_SELECTION, context);
		
		CTabItem tbtmNewItem2 = new CTabItem(tabFolder, SWT.NULL);
		tbtmNewItem2.setText(ResourcePlugin.getProperty("auMaterial.list.tabName"));
		tbtmNewItem2.setControl(auTableViewer.getTable());
		
		auTableViewer.setInput(context.getAuMaterialService().getAllRecords());
		
		
		CTabItem tbtmNewItem3 = new CTabItem(tabFolder, SWT.NULL);
		tbtmNewItem3.setText(ResourcePlugin.getProperty("window.list.tabName"));
		//SashForm sashForm = new SashForm(tabFolder, SWT.HORIZONTAL);
		//sashForm.setLayoutData(swing2swt.layout.BorderLayout.CENTER);
		
		//composite = new Composite(sashForm, SWT.BORDER);
		
		treeViewer = new WindowTreeView(tabFolder, SWT.BORDER, context);
		
		tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		TreeColumn column1 = new TreeColumn(tree, SWT.LEFT);
		tree.setLinesVisible(true);
		column1.setAlignment(SWT.LEFT);
		column1.setText("Land/Stadt");
		column1.setWidth(160);
		TreeColumn column2 = new TreeColumn(tree, SWT.RIGHT);
		column2.setAlignment(SWT.LEFT);
		column2.setText("Person");
		column2.setWidth(100);
		TreeColumn column3 = new TreeColumn(tree, SWT.RIGHT);
		column3.setAlignment(SWT.LEFT);
		column3.setText("m/w");
		column3.setWidth(35);
		
		
		tree.setBounds(0, 0, 115, 182);
		treeViewer.setInput(context.getWindowService().getNode());
		
		tbtmNewItem3.setControl(tree);
		
//		Composite composite2 = new Composite(sashForm, SWT.BORDER);
//		
//		Button btnRadioButton = new Button(composite2, SWT.RADIO);
//		btnRadioButton.setBounds(10, 40, 97, 17);
//		btnRadioButton.setText("Radio Button");
//		sashForm.setWeights(new int[] {119, 312});
		

//		tbtmNewItem3.setControl(sashForm);
		
		
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
					context.getMtrlService().add(item);
					
					tableViewer.refresh();
				}

			}
			
		};
		
		IAction auMaterialItemAction = new Action(ResourcePlugin.getProperty("menu.new.auMaterialItem")){

			@Override
			public void run() {
				super.run();
				AuxiliaryMaterialCreationDialog micd = new AuxiliaryMaterialCreationDialog(null);
				AuxiliaryMaterial item = new AuxiliaryMaterial();
				micd.setAuxiliaryMaterial(item);
				int ret = micd.open();
				
				if(ret == TitleAreaDialog.OK){
					item = micd.getAuxiliaryMaterial();
					context.getAuMaterialService().add(item);
					
					auTableViewer.refresh();
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
		
		//IObservableValue observeBoundsTreeViewerObserveWidget = WidgetProperties.bounds().observe(tree);
		//IObservableValue observeBoundsCompositeObserveWidget = WidgetProperties.bounds().observe(composite);
		//bindingContext.bindValue(observeBoundsTreeViewerObserveWidget, observeBoundsCompositeObserveWidget, null, null);
		//
		
		//IObservableValue observeBoundsTableObserveWidget = WidgetProperties.bounds().observe(table);
		//bindingContext.bindValue(observeBoundsTableObserveWidget, observeBoundsContainerObserveWidget, null, null);
		return bindingContext;
	}
}
