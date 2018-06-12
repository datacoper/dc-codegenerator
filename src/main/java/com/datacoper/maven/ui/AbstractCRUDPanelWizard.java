package com.datacoper.maven.ui;

import com.datacoper.maven.metadata.TemplateModel;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public abstract class AbstractCRUDPanelWizard extends AbstractWizardPage {
	private static final long serialVersionUID = 1L;
	
	private TemplateModel templateModel;
	
	public AbstractCRUDPanelWizard(TemplateModel templateModel) {
		this.templateModel = templateModel;
	}

	public TemplateModel getTemplateModel() {
		return templateModel;
	}
	
	abstract void onNext();
	
	abstract void onFinish();


}
