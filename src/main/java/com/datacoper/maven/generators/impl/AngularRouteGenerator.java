package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractAngularGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class AngularRouteGenerator extends AbstractAngularGenerator {

	public AngularRouteGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
	public String getTemplateName() {
		return "angular.route.js";
	}

	@Override
	public String getClassName() {
		return StringUtil.lowerFirstCharacter(getEntityName())+".route";
	}

}
