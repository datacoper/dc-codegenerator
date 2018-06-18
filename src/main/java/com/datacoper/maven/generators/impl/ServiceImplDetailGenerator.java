package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractJavaDetailGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class ServiceImplDetailGenerator extends AbstractJavaDetailGenerator {
    
    public ServiceImplDetailGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
    public String getTemplateName() {
    	return "serviceImplDetail";
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
