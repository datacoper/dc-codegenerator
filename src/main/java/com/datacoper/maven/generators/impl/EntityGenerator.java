package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class EntityGenerator extends AbstractGenerator {

    public EntityGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
    public String getTemplateName() {
    	return "entity";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.common.entities", getCompany().getPackageName(), getModuleName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return getEntityName();
	}
}
