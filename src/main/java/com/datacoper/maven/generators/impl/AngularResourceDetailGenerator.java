package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractAngularDetailGenerator;
import com.datacoper.maven.metadata.TemplateModelDetail;
import com.datacoper.maven.util.StringUtil;

public class AngularResourceDetailGenerator extends AbstractAngularDetailGenerator {

	public AngularResourceDetailGenerator(TemplateModelDetail templateModel) {
		super(templateModel);
	}

	@Override
	public String getTemplateName() {
		return "angular.resource.detail.js";
	}

	@Override
	public String getClassName() {
		return StringUtil.lowerFirstCharacter(getEntityName())+".resource";
	}

}
