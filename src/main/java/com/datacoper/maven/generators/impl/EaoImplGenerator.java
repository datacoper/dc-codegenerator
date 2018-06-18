package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractJavaGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class EaoImplGenerator extends AbstractJavaGenerator {
    
    public EaoImplGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
    public String getTemplateName() {
    	return "eaoImpl";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.server.eao.impl", getCompany().getPackageName(), getModulePackageName());
    }

	@Override
	public String getClassName() {
		return getEntityName()+"EAOImpl";
	}
}
