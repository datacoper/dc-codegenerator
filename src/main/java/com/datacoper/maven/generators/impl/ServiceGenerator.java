package com.datacoper.maven.generators.impl;

import java.io.File;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.util.StringUtil;

public class ServiceGenerator extends AbctractJavaGenerator {
    
    public ServiceGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		super(projectParentFile, entityName, company, moduleName);
	}

	@Override
    public String getTemplateName() {
    	return "service";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.common.services", getCompany().getPackageName(), getModuleName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return getEntityName()+"Service";
	}
}
