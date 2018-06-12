package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractAngularGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class AngularControllerDetailGenerator extends AbstractAngularGenerator {

	public AngularControllerDetailGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
	public String getTemplateName() {
		return "angular.controller.detail.js";
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