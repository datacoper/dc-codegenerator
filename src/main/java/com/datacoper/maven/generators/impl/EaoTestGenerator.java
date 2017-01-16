/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.generators.SourceType;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.metadata.builder.TClassBuilder;
import com.datacoper.maven.util.StringUtil;

/**
 *
 * @author alessandro
 */
public class EaoTestGenerator extends AbstractGenerator<TClass> {
    
    public EaoTestGenerator(String project, TClass data) {
        super(project, "eaoTest", data);
    }

    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.server.eao", data.getCompany().getPackag(), getModuleToPackage());
    }
    
    @Override
    protected TClass prepareForGenerate(TClass clazz) {
        return new TClassBuilder(clazz)
                .withPackag(getPackage())
                .withClassName(data.getClassName().concat("EAOTest"))
                .withSourceType(SourceType.JAVA_TEST)
                .build();
    }
}
