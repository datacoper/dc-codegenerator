package com.datacoper.maven.metadata;

import com.datacoper.maven.enums.options.Company;

public class TemplateModelDetail extends TemplateModel{

	private String entityName;
	
	private TemplateModel templateModelMaster;

	public TemplateModelDetail(String entityName, TemplateModel templateModelMaster) {
		super(templateModelMaster.getModuleName(), templateModelMaster.getProjectParentFile());
		this.entityName = entityName;
		this.templateModelMaster = templateModelMaster;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entityName == null) ? 0 : entityName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TemplateModelDetail other = (TemplateModelDetail) obj;
		if (entityName == null) {
			if (other.entityName != null)
				return false;
		} else if (!entityName.equals(other.entityName))
			return false;
		return true;
	}

}
