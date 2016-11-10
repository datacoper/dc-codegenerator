/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.impl;

import com.datacoper.maven.generators.impl.ScaffoldGenerator;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.mojos.AbstractDCMojo;
import com.datacoper.maven.mojos.wizard.impl.datacoper.ClassDatacoperWizard;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 *
 * @author alessandro
 */
@Mojo(name = "generateScaffold", requiresDependencyResolution = ResolutionScope.RUNTIME)
public class ScaffoldMojo extends AbstractDCMojo {
    
    @Override
    public void init() {
        TClass clazz = new ClassDatacoperWizard().start();
        
        new ScaffoldGenerator(_project, clazz).generate();
    }

    @Override
    public String getMojoName() {
        return "Scaffold";
    }

    @Override
    public boolean isValidateTypeProjectToRun() {
        return true;
    }

}
