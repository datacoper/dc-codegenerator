package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TemplateModel;

public abstract class AbctractJavaGenerator extends AbstractGenerator {

	public AbctractJavaGenerator(TemplateModel templateModel) {
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
