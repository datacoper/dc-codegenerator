/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

import java.io.File;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.util.StringUtil;

public class BuilderGenerator extends AbctractJavaGenerator {
    
    public BuilderGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		super(projectParentFile, entityName, company, moduleName);
	}

	@Override
    public String getTemplateName() {
    	return "builder";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.common.entities.builder", getCompany().getPackageName(), getModuleName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return getEntityName()+"Builder";
	}
}
