package com.datacoper.maven.metadata;

import com.datacoper.maven.enums.options.Company;

public class TemplateModelDetail extends TemplateModel{

	private TemplateModel templateModelMaster;

	public TemplateModelDetail(String entityName, TemplateModel templateModelMaster) {
		super(templateModelMaster.getModuleName(), templateModelMaster.getProjectParentFile());
		super.setEntityName(entityName);
		this.templateModelMaster = templateModelMaster;
	}

	public String getEntityNameMaster() {
		return templateModelMaster.getEntityName();
	}
	
	@Override
	public Company getCompany() {
		return templateModelMaster.getCompany();
	}

	@Override
	public String getModuleName() {
		return templateModelMaster.getModuleName();
	}
	
	public boolean isMaster() {
		return false;
	}
}
