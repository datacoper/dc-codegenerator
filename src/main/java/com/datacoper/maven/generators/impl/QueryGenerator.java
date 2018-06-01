package com.datacoper.maven.generators.impl;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.util.StringUtil;

public class QueryGenerator extends AbstractGenerator  {
    
    @Override
    public String getTemplateName() {
    	return "query";
    }

    @Override
    public String getPackage(String entityName, CompanyOptions companyOptions, String moduleName) {
        return StringUtil.format("com.{0}.cooperate.{1}.server.consultas", companyOptions.getPackageName(), moduleName.toLowerCase());
    }

	@Override
	public EnumProject getProject() {
		return EnumProject.SERVER;
	}

	@Override
	public String getClassName(String entityName) {
		return "Query"+entityName;
	}
}
