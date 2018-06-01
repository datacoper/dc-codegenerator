package com.datacoper.maven.ui;

import com.datacoper.maven.metadata.TemplateModel;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public abstract class AbstractPanelWizard extends AbstractWizardPage {
	private static final long serialVersionUID = 1L;

	private TemplateModel templateModel;

	public AbstractPanelWizard(TemplateModel templateModel) {
		this.templateModel = templateModel;
	}
	
	public TemplateModel getTemplateModel() {
		return templateModel;
	}
	

}
