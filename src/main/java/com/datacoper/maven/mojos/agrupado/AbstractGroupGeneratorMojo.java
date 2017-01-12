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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Roberto Filho
 */
public abstract class AbstractGroupGeneratorMojo extends AbstractDCMojo {

    private List<EnumDCProjectType> projectTypes;

    protected AbstractGroupGeneratorMojo(EnumDCProjectType... projectType) {
        this.projectTypes = Arrays.asList(projectType);
    }

    @Override
    public void init() {
        TClass clazz = new ClassDatacoperWizard(this).start();
        // Roda o generate para cada tipo de projeto.
        projectTypes.forEach(
            projectType -> new ClassGroupGenerator(projectType,_project, clazz).generate()
        );
    }

    @Override
    public String getMojoName() {
        return String.format("%s scaffold", projectTypes.stream().map(EnumDCProjectType::name).collect(Collectors.joining(",")));
    }

    @Override
    public boolean isValidateTypeProjectToRun() {
        return true;
    }
}
