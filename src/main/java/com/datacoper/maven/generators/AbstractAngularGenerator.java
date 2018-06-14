package com.datacoper.maven.generators;

import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

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
	
	@Override
	public String getPackage() {
		return StringUtil.format("{0}.{1}", getModuleName().toLowerCase(), StringUtil.lowerFirstCharacter(getEntityName()));
	}
	
}
