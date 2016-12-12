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
import org.apache.maven.project.MavenProject;


public class ListagemManagerGenerator extends AbstractGenerator<TClass>{
    
    public ListagemManagerGenerator(MavenProject project, TClass tClass) {
        super(project, "listagemManager", tClass);
    }
    
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.{2}", data.getCompany().getPackag(), getModuleToPackage(), data.getClassNameBasic()).toLowerCase();
    }
    
    @Override
    protected TClass prepareForGenerate(TClass clazz) {
        return new TClassBuilder(clazz)
                .withPackag(getPackage())
                .withClassName("Listagem".concat(data.getClassName()).concat("Manager"))                
                .build();
    }
    
}
