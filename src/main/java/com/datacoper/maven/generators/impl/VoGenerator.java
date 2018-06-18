package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractJavaGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class VoGenerator extends AbstractJavaGenerator {
    
    public VoGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
    public String getTemplateName() {
    	return "vo";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.common.consultas", getCompany().getPackageName(), getModulePackageName(), getEntityName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return getEntityName()+"VO";
	}
}
