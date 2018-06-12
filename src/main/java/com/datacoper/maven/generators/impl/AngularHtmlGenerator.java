package com.datacoper.maven.generators.impl;

import java.io.File;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.util.StringUtil;

public class AngularHtmlGenerator extends AbstractGenerator {

	public AngularHtmlGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		super(projectParentFile, entityName, company, moduleName);
	}

	@Override
	public String getTemplateName() {
		return "angular.html";
	}
	
	@Override
	public String getFileExtension() {
		return ".html";
	}

	@Override
	public String getPackage() {
		return StringUtil.format("{0}.{1}", getModuleName().toLowerCase(), StringUtil.lowerFirstCharacter(getEntityName()));
	}

	@Override
	public String getClassName() {
		return StringUtil.lowerFirstCharacter(getEntityName())+".html";
	}

}
