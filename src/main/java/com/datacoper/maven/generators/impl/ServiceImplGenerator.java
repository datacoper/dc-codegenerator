package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractJavaGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class ServiceImplGenerator extends AbstractJavaGenerator {
    
    public ServiceImplGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
    public String getTemplateName() {
    	return "serviceImpl";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.server.{2}", getCompany().getPackageName(), getModulePackageName(), getEntityName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return getEntityName()+"ServiceImpl";
	}
}
