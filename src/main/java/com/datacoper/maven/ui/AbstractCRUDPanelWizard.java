package com.datacoper.maven.ui;

import java.io.File;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public abstract class AbstractCRUDPanelWizard extends AbstractWizardPage {
	private static final long serialVersionUID = 1L;
	
	private File projectParentFile;
	private String moduleName;
	
	public AbstractCRUDPanelWizard(File projectParentFile, String moduleName) {
		this.projectParentFile = projectParentFile;
		this.moduleName = moduleName;
	}
	
	public File getProjectParentFile() {
		return projectParentFile;
	}
	
	public String getModuleName() {
		return moduleName;
	}
	
	abstract void onNext();
	
	abstract void onFinish();


}
