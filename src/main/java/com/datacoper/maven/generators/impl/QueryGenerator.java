package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.StringUtil;

public class QueryGenerator extends AbstractGenerator  {
    
    public QueryGenerator(TemplateModel templateModel) {
		super(templateModel);
	}

	@Override
    public String getTemplateName() {
    	return "query";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.server.consultas", getCompany().getPackageName(), getModuleName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return "Query"+getEntityName();
	}
}
