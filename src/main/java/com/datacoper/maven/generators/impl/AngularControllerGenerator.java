package com.datacoper.maven.generators.impl;

import java.io.File;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.util.StringUtil;

public class AngularControllerGenerator extends AbctractAngularGenerator {

	public AngularControllerGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		super(projectParentFile, entityName, company, moduleName);
	}

	@Override
	public String getTemplateName() {
		return "angular.controller.js";
	}

	@Override
	public String getPackage() {
		return StringUtil.format("{0}.{1}", getModuleName().toLowerCase(), StringUtil.lowerFirstCharacter(getEntityName()));
	}

	@Override
	public String getClassName() {
		return StringUtil.lowerFirstCharacter(getEntityName())+".controller.js";
	}

}
