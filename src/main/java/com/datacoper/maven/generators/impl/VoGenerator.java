package com.datacoper.maven.generators.impl;

import java.io.File;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.util.StringUtil;

public class VoGenerator extends AbctractJavaGenerator {
    
    public VoGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		super(projectParentFile, entityName, company, moduleName);
	}

	@Override
    public String getTemplateName() {
    	return "vo";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.common.consultas", getCompany().getPackageName(), getModuleName().toLowerCase(), getEntityName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return getEntityName()+"VO";
	}
}
