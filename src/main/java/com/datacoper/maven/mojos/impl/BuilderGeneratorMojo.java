/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.impl;

import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.exception.DcRuntimeException;
import com.datacoper.maven.generators.impl.BuilderGenerator;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.mojos.AbstractDCMojo;
import com.datacoper.maven.mojos.wizard.impl.datacoper.EntityNameWizzard;
import com.datacoper.maven.util.DCProjectUtil;
import com.datacoper.maven.util.ReflectionToModelUtil;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 *
 * @author alessandro
 */
@Mojo(name = "generateBuilder", requiresDependencyResolution = ResolutionScope.RUNTIME)
public class BuilderGeneratorMojo extends AbstractDCMojo {
    
    @Override
    public void init() {
        String entityName = new EntityNameWizzard().start();
        
        Class<?> clazz = DCProjectUtil.loadEntityByName(_project, entityName);
        
        TClass tClazz = ReflectionToModelUtil.loadClassToModel(clazz, _project);

        new BuilderGenerator(DCProjectUtil.getModuleName(_project), tClazz).generate();
    }

    @Override
    public String getMojoName() {
        return "";
    }

    @Override
    public void validateTypeProjectForExecution() {
        if (!DCProjectUtil.isType(_project, EnumDCProjectType.COMMON)) {
            throw new DcRuntimeException("The generator must be run from a common project");
        }
    }

    @Override
    public boolean isValidateTypeProjectToRun() {
        return true;
    }

}
