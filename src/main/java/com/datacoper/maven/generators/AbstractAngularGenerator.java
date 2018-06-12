package com.datacoper.maven.generators;

import com.datacoper.maven.metadata.TemplateModel;

public abstract class AbstractAngularGenerator extends AbstractGenerator {

	public AbstractAngularGenerator(TemplateModel templateModel) {
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
