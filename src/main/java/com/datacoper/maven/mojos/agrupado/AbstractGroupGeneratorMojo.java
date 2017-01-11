/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.agrupado;

import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.generators.impl.ClassGroupGenerator;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.mojos.AbstractDCMojo;
import com.datacoper.maven.mojos.wizard.impl.datacoper.ClassDatacoperWizard;

/**
 *
 * @author Roberto Filho
 */
public abstract class AbstractGroupGeneratorMojo extends AbstractDCMojo {

    private EnumDCProjectType projectType;

    protected AbstractGroupGeneratorMojo(EnumDCProjectType projectType) {
        this.projectType = projectType;
    }

    @Override
    public void init() {
        TClass clazz = new ClassDatacoperWizard(getLog(), this).start();

        new ClassGroupGenerator(projectType,_project, clazz).generate();
    }

    @Override
    public String getMojoName() {
        return String.format("%s scaffold", projectType.name());
    }

    @Override
    public boolean isValidateTypeProjectToRun() {
        return true;
    }
}
