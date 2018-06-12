package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class AngularMainServiceGenerator extends AbstractGenerator {

	public AngularMainServiceGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
	public String getTemplateName() {
		return "angular.main.service.js";
	}

	@Override
	public String getPackage() {
		return StringUtil.format("{0}.{1}", getModuleName().toLowerCase(), StringUtil.lowerFirstCharacter(getEntityName()));
	}

	@Override
	public String getClassName() {
		return StringUtil.lowerFirstCharacter(getEntityName())+".main.service.js";
	}

}
