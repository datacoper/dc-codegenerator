package com.datacoper.maven.generators.impl;

import java.io.File;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.generators.AbstractCRUDGenerator;
import com.datacoper.maven.util.StringUtil;

public class ResourceImplGenerator extends AbstractCRUDGenerator {
    
    public ResourceImplGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		super(projectParentFile, entityName, company, moduleName);
	}

	@Override
    public String getTemplateName() {
    	return "resourceImpl";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.{1}.rest.resources.impl", getCompany().getPackageName(), getModuleName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return getEntityName()+"ResourceImpl";
	}
}
