package ui.material;

import model.material.MaterialItem;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import swing2swt.layout.BorderLayout;

public class MaterialItemCreationPage extends WizardPage {
	
	private MaterialItem materialItem;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Create the wizard.
	 */
	public MaterialItemCreationPage() {
		super("wizardPage");
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new BorderLayout(0, 0));
		
		Composite composite_1 = new Composite(container, SWT.NONE);
		composite_1.setLayoutData(BorderLayout.CENTER);
		
		Composite composite = new Composite(composite_1, SWT.NONE);
		composite.setBounds(0, 0, 155, 282);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(60, 30, 55, 15);
		lblNewLabel.setText("Item Number");
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setBounds(60, 80, 55, 15);
		lblNewLabel_1.setText("Item Name");
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setBounds(60, 130, 55, 15);
		lblNewLabel_2.setText("Item Midu");
		
		text = new Text(composite_1, SWT.BORDER);
		text.setBounds(188, 30, 70, 20);
		
		text_1 = new Text(composite_1, SWT.BORDER);
		text_1.setBounds(188, 80, 70, 20);
		
		text_2 = new Text(composite_1, SWT.BORDER);
		text_2.setBounds(188, 130, 70, 20);
	}
	
	

	public MaterialItem getMaterialItem() {
		return materialItem;
	}

	

}
