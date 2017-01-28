/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.impl;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.mojos.AbstractDCMojo;

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
    public String getMojoName() {
        return "Entidade";
    }

	@Override
	public TClass getTClassWithWizard() {
		return null;
	}

	@Override
	public Class<? extends AbstractGenerator<TClass>>[] getGenerators() {
		return null;
	}
}
