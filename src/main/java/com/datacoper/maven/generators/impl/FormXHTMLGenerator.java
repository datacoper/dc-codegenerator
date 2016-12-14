/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.metadata.builder.TClassBuilder;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.generators.SourceType;
import org.apache.maven.project.MavenProject;

/**
 *
 * @author alessandro
 */
public class FormXHTMLGenerator extends AbstractGenerator<TClass> {
    
    public FormXHTMLGenerator(MavenProject project, TClass data) {
        super(project, "formXHTML", data);
    }

    public String getPackage() {        
        return data.getClassNameBasic().toLowerCase();
    }
    
    @Override
    protected TClass prepareForGenerate(TClass clazz) {
        return new TClassBuilder(clazz)
                .withSourceType(SourceType.XHTML)
                .withPackag(getPackage())
                .withClassName("form".concat(data.getClassName()))
                .build();
    }
}
