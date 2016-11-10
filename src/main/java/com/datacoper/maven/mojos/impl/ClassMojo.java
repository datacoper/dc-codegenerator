/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.impl;


import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

import com.datacoper.maven.generators.impl.ClassGenerator;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.mojos.AbstractDCMojo;
import com.datacoper.maven.mojos.wizard.impl.ClassWizard;
import com.datacoper.maven.util.BooleanUtil;

@Mojo(name = "generateClass", requiresDependencyResolution = ResolutionScope.RUNTIME)
public class ClassMojo extends AbstractDCMojo {

    @Parameter(property = "attributes", defaultValue = "")
    private String _parametroAtributos;

    @Parameter(property = "superclass", defaultValue = "")
    private String _superClass;

    @Parameter(property = "implements", defaultValue = "")
    private String _implement;

    @Parameter(property = "atributes", defaultValue = "")
    private String _attributes;

    @Parameter(property = "wizzard", defaultValue = "true")
    private String _wizzard;
    
    @Override
    public void validateTypeProjectForExecution() { }

    @Override
    public void init() {
        if (_completeEntityName.isEmpty()) {
            _wizzard = "true";
        }

        TClass clazz = null;//carregarEntity();

        if (BooleanUtil.toBoolean(_wizzard)) {
            clazz = new ClassWizard().start();
        }

        ClassGenerator.generate(_project, clazz);
    }

    @Override
    public String getMojoName() {
        return "Entidade";
    }

    @Override
    public boolean isValidateTypeProjectToRun() {
        return false;
    }
}
