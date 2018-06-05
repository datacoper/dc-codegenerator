package com.datacoper.maven.generators.impl;

import java.io.File;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.generators.AbstractCRUDGenerator;
import com.datacoper.maven.util.StringUtil;

public class ServiceImplGenerator extends AbstractCRUDGenerator {
    
    public ServiceImplGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		super(projectParentFile, entityName, company, moduleName);
	}

	@Override
    public String getTemplateName() {
    	return "serviceImpl";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.server.{2}", getCompany().getPackageName(), getModuleName().toLowerCase(), getEntityName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return getEntityName()+"ServiceImpl";
	}
}
