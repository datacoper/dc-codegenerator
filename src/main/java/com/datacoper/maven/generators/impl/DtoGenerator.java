package com.datacoper.maven.generators.impl;

import java.io.File;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.util.StringUtil;

public class DtoGenerator extends AbctractJavaGenerator {
    
    public DtoGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		super(projectParentFile, entityName, company, moduleName);
	}

	@Override
    public String getTemplateName() {
    	return "dto";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.rest.common.dto", getCompany().getPackageName(), getModuleName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return getEntityName()+"DTO";
	}

}
