package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractAngularGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class AngularHtmlGenerator extends AbstractAngularGenerator {

	public AngularHtmlGenerator(TemplateModel templateModel) {
		super(templateModel);
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
	public String getClassName() {
		return StringUtil.lowerFirstCharacter(getEntityName());
	}

}
