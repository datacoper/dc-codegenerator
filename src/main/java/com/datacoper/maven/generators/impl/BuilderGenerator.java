/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

import com.datacoper.maven.enums.EnumDCModule;
import com.datacoper.maven.generators.AbstractJavaGenerator;
import com.datacoper.maven.metadata.TemplateModel;

public class BuilderGenerator extends AbstractJavaGenerator {
    
    public BuilderGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
    public String getTemplateName() {
    	return "builder";
    }

    @Override
    public String getPackage() {
        return EnumDCModule.from(getModuleName()).resolveCommonPackage(getCompany())+".entities.builder";
    }

	@Override
	public String getClassName() {
		return getEntityName()+"Builder";
	}
}
