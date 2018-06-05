package com.datacoper.maven.metadata;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.datacoper.maven.enums.options.Company;

public class TemplateModel {
	
	private Company company = Company.DATACOPER;
	
	private String entityName;
	
    private String moduleName;

    private String packag;

    private String className;
    
    private Set<TemplateAttributeModel> attributes = new HashSet<>();

    public TemplateModel(String entityName, Company company, String moduleName, String className, String packag) {
    	this.entityName = entityName;
    	this.company = company;
    	this.moduleName = moduleName;
    	this.className = className;
    	this.packag = packag;
    	
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
	}

	public String getEntityName() {
		return entityName;
	}
	
}
