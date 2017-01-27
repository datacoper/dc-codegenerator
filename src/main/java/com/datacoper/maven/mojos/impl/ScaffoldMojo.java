/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.impl;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

import com.datacoper.maven.generators.ProcessGenerator;
import com.datacoper.maven.generators.impl.EnumGroupGenerators;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.mojos.AbstractDCMojo;
import com.datacoper.maven.mojos.wizard.impl.datacoper.ClassDatacoperWizard;

/**
 *
 * @author alessandro
 */
@Mojo(name = "scaffold", requiresDependencyResolution = ResolutionScope.RUNTIME)
public class ScaffoldMojo extends AbstractDCMojo {
    
    @Override
    public void init() {
        TClass clazz = new ClassDatacoperWizard(this).start();
        
        new ProcessGenerator(_project, clazz).process(EnumGroupGenerators.SCAFFOLD);
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
