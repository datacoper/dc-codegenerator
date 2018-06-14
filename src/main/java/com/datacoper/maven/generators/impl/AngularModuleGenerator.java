package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractAngularGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class AngularModuleGenerator extends AbstractAngularGenerator {

	public AngularModuleGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
	public String getTemplateName() {
		return "angular.module.js";
	}

	@Override
	public String getClassName() {
		return StringUtil.lowerFirstCharacter(getEntityName())+".module";
	}

}
