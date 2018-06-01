package com.datacoper.maven.generators.impl;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.util.StringUtil;

public class VoGenerator extends AbstractGenerator {
    
    @Override
    public String getTemplateName() {
    	return "vo";
    }

    @Override
    public String getPackage(String entityName, CompanyOptions companyOptions, String moduleName) {
        return StringUtil.format("com.{0}.cooperate.{1}.common.consultas", companyOptions.getPackageName(), moduleName.toLowerCase(), entityName.toLowerCase());
    }

	@Override
	public EnumProject getProject() {
		return EnumProject.COMMON;
	}

	@Override
	public String getClassName(String entityName) {
		return entityName+"VO";
	}
}
