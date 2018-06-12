package com.datacoper.maven.generators;

import com.datacoper.maven.metadata.TemplateModel;

public abstract class AbstractJavaGenerator extends AbstractGenerator {

	public AbstractJavaGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
	public String getFileExtension() {
		return ".java";
	}
	
	@Override
	public String getCharsetName() {
    	return "ISO-8859-1";
    }
	
}
