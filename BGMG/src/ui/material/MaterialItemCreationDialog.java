package ui.material;

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

public class MaterialItemCreationDialog extends TitleAreaDialog {
	private DataBindingContext m_bindingContext;
	
	private MaterialItem materialItem;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public MaterialItemCreationDialog(Shell parentShell) {
		super(parentShell);
		materialItem = new MaterialItem();
		
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
		composite.setBounds(0, 0, 155, 282);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(25, 30, 90, 15);
		lblNewLabel.setText(ResourcePlugin.getProperty("material.creationDlg.label.id"));
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setBounds(25, 80, 90, 15);
		lblNewLabel_1.setText(ResourcePlugin.getProperty("material.creationDlg.label.name"));
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setBounds(25, 130, 90, 15);
		lblNewLabel_2.setText(ResourcePlugin.getProperty("material.creationDlg.label.midu"));
		
		text = new Text(composite_1, SWT.BORDER);
		text.setBounds(188, 30, 114, 20);
		
		text_1 = new Text(composite_1, SWT.BORDER);
		text_1.setBounds(188, 80, 114, 20);
		
		text_2 = new Text(composite_1, SWT.BORDER);
		text_2.setBounds(188, 130, 114, 20);
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
	
	

	public MaterialItem getMaterialItem() {
		return materialItem;
	}
	
	

	public void setMaterialItem(MaterialItem materialItem) {
		this.materialItem = materialItem;
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
		
		String val = text.getText();		
		materialItem.setItemId(val);
		
		val = text_1.getText();
		materialItem.setItemName(val);
		
		materialItem.setItemMidu(new BigDecimal("0"));
		
		val = text_2.getText();
		if(!val.equals("")){
			this.setErrorMessage(ResourcePlugin.getProperty("material.creationDlg.errorMessage"));
			
		}else{
			super.okPressed();
		}
		
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
	    newShell.setText(ResourcePlugin.getProperty("material.creationDlg.shellText"));
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue itemIdMaterialItemObserveValue = PojoProperties.value("itemId").observe(materialItem);
		IObservableValue textTextObserveValue = PojoProperties.value("text").observe(text);
		bindingContext.bindValue(textTextObserveValue, itemIdMaterialItemObserveValue, null, null);
		//
		IObservableValue itemNameMaterialItemObserveValue = PojoProperties.value("itemName").observe(materialItem);
		IObservableValue textText_1ObserveValue = PojoProperties.value("text").observe(text_1);
		bindingContext.bindValue(textText_1ObserveValue, itemNameMaterialItemObserveValue, null, null);
		//
		IObservableValue itemMiduMaterialItemObserveValue = PojoProperties.value("itemMidu").observe(materialItem);
		IObservableValue textText_2ObserveValue = PojoProperties.value("text").observe(text_2);
		bindingContext.bindValue(textText_2ObserveValue, itemMiduMaterialItemObserveValue, null, null);
		//
		return bindingContext;
	}
}
