package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class ServiceGenerator extends AbstractGenerator {
    
    public ServiceGenerator(TemplateModel templateModel) {
		super(templateModel);
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
