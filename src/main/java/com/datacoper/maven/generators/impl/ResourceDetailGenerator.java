package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class ResourceDetailGenerator extends AbstractGenerator {
    
    public ResourceDetailGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
    public String getTemplateName() {
    	return "resourceDetail";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.rest.common.resources", getCompany().getPackageName(), getModuleName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return getEntityName()+"Resource";
	}
}
