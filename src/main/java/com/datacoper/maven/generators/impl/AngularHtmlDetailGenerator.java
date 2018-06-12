package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class AngularHtmlDetailGenerator extends AbstractGenerator {

	public AngularHtmlDetailGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
	public String getTemplateName() {
		return "angular.detail.html";
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
