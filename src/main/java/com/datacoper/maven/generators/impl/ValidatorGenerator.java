/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.util.StringUtil;

public class ValidatorGenerator extends AbstractGenerator {
    
    @Override
    public String getTemplateName() {
    	return "validator";
    }

    @Override
    public String getPackage(String entityName, CompanyOptions companyOptions, String moduleName) {
        return StringUtil.format("com.{0}.cooperate.{1}.server.{2}", companyOptions.getPackageName(), moduleName.toLowerCase(), entityName.toLowerCase());
    }

	@Override
	public EnumProject getProject() {
		return EnumProject.SERVER;
	}

	@Override
	public String getClassName(String entityName) {
		return "Validador"+entityName;
	}
}
