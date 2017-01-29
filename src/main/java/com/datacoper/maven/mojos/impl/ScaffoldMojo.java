/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.impl;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

import com.datacoper.maven.generators.AbstractGenerator;
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
	public TClass getTClassWithWizard() {
		return new ClassDatacoperWizard(this).start();
	}
	
	@Override
	public Class<? extends AbstractGenerator>[] getGenerators() {
		return EnumGroupGenerators.SCAFFOLD.getGenerators();
	}

    @Override
    public String getMojoName() {                
        return "Scaffold";
    }
}
