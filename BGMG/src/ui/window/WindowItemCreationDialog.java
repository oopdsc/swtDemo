package ui.window;

import helper.ResourcePlugin;

import java.math.BigDecimal;

import model.material.MaterialItem;

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
import swing2swt.layout.BorderLayout;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;

public class WindowItemCreationDialog extends TitleAreaDialog {
	private DataBindingContext m_bindingContext;

	private Text text;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public WindowItemCreationDialog(Shell parentShell) {
		super(parentShell);
		
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
		lblNewLabel.setBounds(25, 30, 90, 15);
		lblNewLabel.setText("材料名称");
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setBounds(25, 64, 90, 15);
		lblNewLabel_1.setText("材料编号");
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setBounds(25, 96, 90, 15);
		lblNewLabel_2.setText(ResourcePlugin.getProperty("material.creationDlg.label.midu"));
		
		Label lblNewLabel_5 = new Label(composite, SWT.NONE);
		lblNewLabel_5.setBounds(25, 129, 55, 15);
		lblNewLabel_5.setText("计算公式");
		
		ComboViewer comboViewer = new ComboViewer(composite_1, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		combo.setBounds(183, 27, 88, 23);
		
		Label lblNewLabel_3 = new Label(composite_1, SWT.NONE);
		lblNewLabel_3.setBounds(183, 63, 55, 15);
		
		Label lblNewLabel_4 = new Label(composite_1, SWT.NONE);
		lblNewLabel_4.setBounds(183, 96, 55, 15);
		
		text = new Text(composite_1, SWT.BORDER);
		text.setBounds(183, 122, 185, 21);
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
