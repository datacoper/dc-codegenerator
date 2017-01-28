/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.impl;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.generators.impl.BuilderGenerator;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.mojos.AbstractDCMojo;
import com.datacoper.maven.mojos.wizard.impl.datacoper.EntityNameWizzard;
import com.datacoper.maven.util.DCProjectUtil;
import com.datacoper.maven.util.ReflectionToModelUtil;

/**
 *
 * @author alessandro
 */
@Mojo(name = "generateBuilder", requiresDependencyResolution = ResolutionScope.RUNTIME)
public class BuilderGeneratorMojo extends AbstractDCMojo {

    @Override
    public String getMojoName() {
        return "";
    }

	@Override
	public TClass getTClassWithWizard() {
		String entityName = new EntityNameWizzard().start();
        
        Class<?> clazz = DCProjectUtil.loadEntityByName(_project, entityName);
        
        return ReflectionToModelUtil.loadClassToModel(clazz, _project);
	}

	@Override
	public Class<? extends AbstractGenerator<TClass>>[] getGenerators() {
		return convert(BuilderGenerator.class);
	}
}
