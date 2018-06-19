package com.datacoper.maven.generators.impl;

import com.datacoper.maven.enums.EnumDCModule;
import com.datacoper.maven.generators.AbstractJavaGenerator;
import com.datacoper.maven.metadata.TemplateModel;

public class EntityGenerator extends AbstractJavaGenerator {

    public EntityGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
    public String getTemplateName() {
    	return "entity";
    }

    @Override
    public String getPackage() {
        return EnumDCModule.from(getModuleName()).resolveCommonPackage(getCompany())+".entities";
    }

	@Override
	public String getClassName() {
		return getEntityName();
	}
}
