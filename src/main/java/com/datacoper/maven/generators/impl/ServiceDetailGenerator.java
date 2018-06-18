package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractJavaDetailGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class ServiceDetailGenerator extends AbstractJavaDetailGenerator {
    
    public ServiceDetailGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
    public String getTemplateName() {
    	return "serviceDetail";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.common.services", getCompany().getPackageName(), getModulePackageName());
    }

	@Override
	public String getClassName() {
		return getEntityName()+"Service";
	}
}
