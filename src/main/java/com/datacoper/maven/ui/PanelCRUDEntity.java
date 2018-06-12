package com.datacoper.maven.ui;

import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.datacoper.cooperate.arquitetura.client.layout.VerticalFlowLayout;
import com.datacoper.cooperate.arquitetura.client.panel.DCPanelTitled;
import com.datacoper.cooperate.arquitetura.client.textfield.DCTextField;
import com.datacoper.maven.enums.options.Company;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public class PanelCRUDEntity extends AbstractCRUDPanelWizard {
	private static final long serialVersionUID = 1L;
	
	private JComboBox<Company> comboCompany = new JComboBox<>(Company.values());
	
	private JTextField fieldEntity = new JTextField();
	
	private PanelCRUDAttributes panelCRUDAttributes;
	
	public PanelCRUDEntity(File projectParentFile, String moduleName) {
		super(projectParentFile, moduleName);
		
		setLayout(new VerticalFlowLayout());
		
		DCPanelTitled panelCompany = new DCPanelTitled();
		panelCompany.setTitle("Empresa");
		panelCompany.setMandatory(true);
		panelCompany.add(comboCompany);
		
		DCPanelTitled panelEntity = new DCPanelTitled();
		panelEntity.setTitle("Entidade");
		panelEntity.setMandatory(true);
		panelEntity.add(fieldEntity);
		
		add(panelEntity);
		add(panelCompany);
		
		panelCRUDAttributes = new PanelCRUDAttributes(projectParentFile, moduleName);
		
	}

	@Override
	protected AbstractWizardPage getNextPage() {
		return panelCRUDAttributes;
	}

	@Override
	protected boolean isCancelAllowed() {
		return true;
	}

	@Override
	protected boolean isPreviousAllowed() {
		return true;
	}

	@Override
	protected boolean isNextAllowed() {
		return true;
	}

	@Override
	protected boolean isFinishAllowed() {
		return false;
	}

	@Override
	void onNext() {
		String entityName = fieldEntity.getText();
		panelCRUDAttributes.init(entityName, (Company)comboCompany.getSelectedItem());
	}

	@Override
	void onFinish() {
		
	}

}
