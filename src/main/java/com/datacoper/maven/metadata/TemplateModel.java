package com.datacoper.maven.metadata;

import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.datacoper.maven.enums.options.Company;

public class TemplateModel {

	private Company company = Company.DATACOPER;

	private String entityName;
	
    private String moduleName;

    private String packag;

    private String className;
    
    private Set<String> attributeImports = new TreeSet<>();
    
	private File projectParentFile;

	private Set<TemplateAttributeModel> attributes = new HashSet<>();

	private Set<TemplateModelDetail> details = new HashSet<>();

	public TemplateModel(String moduleName, File projectParentFile) {
		this.moduleName = moduleName;
		this.projectParentFile = projectParentFile;
	}

	public Company getCompany() {
		return company;
	}

	public String getModuleName() {
		return moduleName;
	}

	public String getPackage() {
		return packag;
	}

	public String getClassName() {
		return className;
	}

	public Set<TemplateAttributeModel> getAttributes() {
		return Collections.unmodifiableSet(attributes);
	}

	public String getPackag() {
		return packag;
	}

	public void setAttributes(Set<TemplateAttributeModel> attributes) {
		this.attributes = attributes;
		for (TemplateAttributeModel templateAttributeModel : attributes) {
			attributeImports.add(templateAttributeModel.getType());
		}
	}
	
	public boolean hasAttributeBoolean() {
		return attributes.stream().filter(a -> a.isBoolean()).findFirst().isPresent();
	}
	
	public boolean addImport(String importPackage) {
		return attributeImports.add(importPackage);
	}
	
	public Set<String> getAttributeImports() {
		return attributeImports;
	}

	public String getEntityName() {
		return entityName;
	}

	public void addDetail(TemplateModelDetail templateModelDetail) {
		details.add(templateModelDetail);
	}

	public Set<TemplateModelDetail> getDetails() {
		return details;
	}

	public void setDetails(Set<TemplateModelDetail> details) {
		this.details = details;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public void setPackag(String packag) {
		this.packag = packag;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public File getProjectParentFile() {
		return projectParentFile;
	}

	public boolean isMaster() {
		return true;
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
		TemplateModel other = (TemplateModel) obj;
		if (entityName == null) {
			if (other.entityName != null)
				return false;
		} else if (!entityName.equals(other.entityName))
			return false;
		return true;
	}

}
