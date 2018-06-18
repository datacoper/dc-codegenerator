package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractJavaGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class ResourceGenerator extends AbstractJavaGenerator {
    
    public ResourceGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
    public String getTemplateName() {
    	return "resource";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.rest.common.resources", getCompany().getPackageName(), getModulePackageName());
    }

	@Override
	public String getClassName() {
		return getEntityName()+"Resource";
	}
}
