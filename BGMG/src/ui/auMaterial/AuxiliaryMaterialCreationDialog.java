package ui.auMaterial;

import helper.ResourcePlugin;

import java.math.BigDecimal;

import model.auMaterial.AuxiliaryMaterial;

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

public class AuxiliaryMaterialCreationDialog extends TitleAreaDialog {
	private DataBindingContext m_bindingContext;
	
	private AuxiliaryMaterial auxiliaryMaterial;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public AuxiliaryMaterialCreationDialog(Shell parentShell) {
		super(parentShell);
		auxiliaryMaterial = new AuxiliaryMaterial();
		
		//setMessage("Wizard Page description");
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle(ResourcePlugin.getProperty("material.creationDlg.title"));
		//setMessage("Create a new material item");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		container.setLayout(new BorderLayout(0, 0));
		
		Composite composite_1 = new Composite(container, SWT.NONE);
		composite_1.setLayoutData(BorderLayout.CENTER);
		
		Composite composite = new Composite(composite_1, SWT.NONE);
		composite.setBounds(0, 0, 130, 282);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(25, 30, 90, 15);
		lblNewLabel.setText(ResourcePlugin.getProperty("auMaterial.creationDlg.label.name"));
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setBounds(25, 80, 90, 15);
		lblNewLabel_1.setText(ResourcePlugin.getProperty("auMaterial.creationDlg.label.brand"));
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setBounds(25, 130, 90, 15);
		lblNewLabel_2.setText(ResourcePlugin.getProperty("auMaterial.creationDlg.label.unit"));
		
		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setBounds(25, 180, 90, 15);
		lblNewLabel_3.setText(ResourcePlugin.getProperty("auMaterial.creationDlg.label.price"));
		
		text = new Text(composite_1, SWT.BORDER);
		text.setBounds(188, 30, 114, 20);
		
		text_1 = new Text(composite_1, SWT.BORDER);
		text_1.setBounds(188, 80, 114, 20);
		
		text_2 = new Text(composite_1, SWT.BORDER);
		text_2.setBounds(188, 130, 114, 20);
		
		text_3 = new Text(composite_1, SWT.BORDER);
		text_3.setBounds(188, 180, 114, 20);
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
	
	public AuxiliaryMaterial getAuxiliaryMaterial() {
		return auxiliaryMaterial;
	}

	public void setAuxiliaryMaterial(AuxiliaryMaterial auxiliaryMaterial) {
		this.auxiliaryMaterial = auxiliaryMaterial;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(600, 450);
	}
	
	@Override
	protected void okPressed() {
		
		String val = text.getText();		
		auxiliaryMaterial.setItemName(val);
		
		val = text_1.getText();
		auxiliaryMaterial.setItemBrand(val);
		
		val = text_2.getText();
		auxiliaryMaterial.setUnit(val);
		
		val = text_3.getText();
		auxiliaryMaterial.setPrice(new BigDecimal(val));

		super.okPressed();
		
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
	    newShell.setText(ResourcePlugin.getProperty("auMaterial.creationDlg.shellText"));
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();

		return bindingContext;
	}

}
