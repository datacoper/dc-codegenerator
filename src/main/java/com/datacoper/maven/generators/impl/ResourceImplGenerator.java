package com.datacoper.maven.generators.impl;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.util.StringUtil;

public class ResourceImplGenerator extends AbstractGenerator {
    
    @Override
    public String getTemplateName() {
    	return "resourceImpl";
    }

    @Override
    public String getPackage(String entityName, CompanyOptions companyOptions, String moduleName) {
        return StringUtil.format("com.{0}.{1}.rest.resources.impl", companyOptions.getPackageName(), moduleName.toLowerCase());
    }

	@Override
	public EnumProject getProject() {
		return EnumProject.REST;
	}

	@Override
	public String getClassName(String entityName) {
		return entityName+"ResourceImpl";
	}
}
