package com.datacoper.maven.generators;

import com.datacoper.maven.metadata.TemplateModelDetail;
import com.datacoper.maven.util.StringUtil;

public abstract class AbstractAngularDetailGenerator extends AbstractGenerator {

	public AbstractAngularDetailGenerator(TemplateModelDetail templateModelDetail) {
		super(templateModelDetail);
	}

	@Override
	public String getFileExtension() {
		return ".js";
	}
	
	@Override
	public String getPackage() {
		TemplateModelDetail templateModelDetail = getTemplateModelDetail();
		return StringUtil.format("{0}.{1}.{2}", getModuleName().toLowerCase(), 
				StringUtil.lowerFirstCharacter(templateModelDetail.getEntityNameMaster()), 
				StringUtil.lowerFirstCharacter(templateModelDetail.getEntityName()));
	}
	
	@Override
	public String getCharsetName() {
    	return "UTF-8";
    }
	
	public TemplateModelDetail getTemplateModelDetail() {
		return (TemplateModelDetail) super.getTemplateModel();
	}
	
}
