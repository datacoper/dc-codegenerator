/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.metadata.builder.TClassBuilder;
import com.datacoper.maven.util.DCProjectUtil;
import com.datacoper.maven.util.StringUtil;

/**
 *
 * @author alessandro
 */
public class ValidatorGenerator extends AbstractGenerator<TClass> {
    
    public ValidatorGenerator(String project, TClass data) {
        super(project, "validator", data);
    }

    public String getPackage() {
        String name = data.getClassName().toLowerCase();
        String module = DCProjectUtil.getModuleName(project);
        
        return StringUtil.format("com.{0}.cooperate.{1}.server.{2}", data.getCompany().getPackag(), getModuleToPackage(), name);
    }
    
    @Override
    protected TClass prepareForGenerate(TClass clazz) {
        return new TClassBuilder(clazz)
                .withPackag(getPackage())
                .withClassName("Validador".concat(data.getClassName()))
                .build();
    }
}
