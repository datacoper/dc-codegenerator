package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractAngularDetailGenerator;
import com.datacoper.maven.metadata.TemplateModelDetail;
import com.datacoper.maven.util.StringUtil;

public class AngularServiceDetailGenerator extends AbstractAngularDetailGenerator {

	public AngularServiceDetailGenerator(TemplateModelDetail templateModel) {
		super(templateModel);
	}

	@Override
	public String getTemplateName() {
		return "angular.main.service.js";
	}

	@Override
	public String getClassName() {
		return StringUtil.lowerFirstCharacter(getEntityName())+".main.service";
	}

}
