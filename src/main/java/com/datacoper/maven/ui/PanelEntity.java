package com.datacoper.maven.ui;

import com.datacoper.cooperate.arquitetura.client.layout.VerticalFlowLayout;
import com.datacoper.cooperate.arquitetura.client.panel.DCPanelTitled;
import com.datacoper.cooperate.arquitetura.client.textfield.DCTextField;
import com.datacoper.maven.metadata.TemplateModel;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public class PanelEntity extends AbstractPanelWizard {
	private static final long serialVersionUID = 1L;
	
	private DCTextField fieldEntity = new DCTextField();
	
	public PanelEntity(TemplateModel templateModel) {
		super(templateModel);
		
		setLayout(new VerticalFlowLayout());
		
		DCPanelTitled panelEntity = new DCPanelTitled();
		panelEntity.setTitle("Entidade");
		panelEntity.setMandatory(true);
		add(panelEntity);
		
		panelEntity.add(fieldEntity);
		
	}

	@Override
	protected AbstractWizardPage getNextPage() {
		TemplateModel templateModel = getTemplateModel();
		templateModel.setEntityName(fieldEntity.getText());
		return new PanelClasses(templateModel);
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

}
