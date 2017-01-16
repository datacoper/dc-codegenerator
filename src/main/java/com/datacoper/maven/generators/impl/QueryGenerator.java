/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.metadata.builder.TClassBuilder;
import com.datacoper.maven.util.StringUtil;

/**
 *
 * @author alessandro
 */
public class QueryGenerator extends AbstractGenerator<TClass>  {
    
    public QueryGenerator(String project, TClass data) {
        super(project, "query", data);
    }

    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.server.consultas", data.getCompany().getPackag(), getModuleToPackage());
    }
    
    @Override
    protected TClass prepareForGenerate(TClass clazz) {
        return new TClassBuilder(clazz)
                .withPackag(getPackage())
                .withClassName("Query".concat(data.getClassName()))
                .build();
    }
}
