package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TemplateModel;

public abstract class AbctractAngularGenerator extends AbstractGenerator {

	public AbctractAngularGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
	public String getFileExtension() {
		return ".js";
	}
	
	@Override
	public String getCharsetName() {
    	return "UTF-8";
    }
	
}
