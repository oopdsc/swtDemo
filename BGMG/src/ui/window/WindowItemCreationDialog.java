package ui.window;

import helper.ResourcePlugin;

import java.math.BigDecimal;

import model.material.MaterialItem;
import model.window.WindowItem;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import service.AppContext;
import swing2swt.layout.BorderLayout;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;

public class WindowItemCreationDialog extends TitleAreaDialog {
	private DataBindingContext m_bindingContext;
	private AppContext context;
	private Text text;
	private Text text_1;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public WindowItemCreationDialog(Shell parentShell, AppContext context) {
		super(parentShell);
		this.context = context;
		//setMessage("Wizard Page description");
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle(ResourcePlugin.getProperty("windowItem.creationDlg.title"));
		//setMessage("Create a new material item");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		container.setLayout(new BorderLayout(0, 0));
		
		Composite composite_1 = new Composite(container, SWT.NONE);
		composite_1.setLayoutData(BorderLayout.CENTER);
		
		Composite composite = new Composite(composite_1, SWT.NONE);
		composite.setBounds(0, 0, 155, 282);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(25, 29, 90, 15);
		lblNewLabel.setText("材料名称");
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setBounds(25, 78, 55, 15);
		lblNewLabel_1.setText("编号");
		
		text = new Text(composite_1, SWT.BORDER);
		text.setBounds(182, 27, 73, 21);
		
		text_1 = new Text(composite_1, SWT.BORDER);
		text_1.setBounds(182, 77, 73, 21);
		
		
		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		m_bindingContext = initDataBindings();
	}
	

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	
	@Override
	protected void okPressed() {
		String name = text.getText();
		
		String id = text_1.getText();
		
		WindowItem item = new WindowItem();
		item.setId(id);
		item.setName(name);
		
		context.getWindowService().addWindowItem(item);
		
		super.okPressed();
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
	    newShell.setText(ResourcePlugin.getProperty("material.creationDlg.shellText"));
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		return bindingContext;
	}
}
