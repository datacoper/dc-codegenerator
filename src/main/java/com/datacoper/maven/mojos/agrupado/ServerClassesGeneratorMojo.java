/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.agrupado;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.generators.impl.ClassGroupGenerator;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.mojos.AbstractDCMojo;
import com.datacoper.maven.mojos.wizard.impl.datacoper.ClassDatacoperWizard;

/**
 *
 * @author alessandro
 */
@Mojo(name = "server", requiresDependencyResolution = ResolutionScope.RUNTIME)
public class ServerClassesGeneratorMojo extends AbstractDCMojo {
    
    @Override
    public void init() {
        TClass clazz = new ClassDatacoperWizard(this).start();

        getLog().info("Generating classes for the [{0}] generator!");

        new ClassGroupGenerator(EnumDCProjectType.SERVER,_project, clazz).generate();
    }

    @Override
    public String getMojoName() {
        return "Server scaffold";
    }

    @Override
    public boolean isValidateTypeProjectToRun() {
        return true;
    }
}
