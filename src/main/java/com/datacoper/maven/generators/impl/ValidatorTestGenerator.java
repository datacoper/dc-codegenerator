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
import com.datacoper.maven.util.DCProjectUtil;
import com.datacoper.maven.util.StringUtil;
import org.apache.maven.project.MavenProject;

/**
 *
 * @author alessandro
 */
public class ValidatorTestGenerator extends AbstractGenerator<TClass> {
    
    public ValidatorTestGenerator(MavenProject project, TClass data) {
        super(project, "validatorTest", data);
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
                .withClassName("Validador".concat(data.getClassName()).concat("Test"))
                .withSourceType(SourceType.JAVA_TEST)
                .build();
    }
}
