package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class ResourceImplGenerator extends AbstractGenerator {
    
    public ResourceImplGenerator(TemplateModel templateModel) {
		super(templateModel);
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
