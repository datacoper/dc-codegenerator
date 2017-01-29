/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

import org.apache.maven.project.MavenProject;

import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TClass;


public class ListagemManagerGenerator extends AbstractGenerator{
    
    public ListagemManagerGenerator(MavenProject project, TClass tClass) {
        super(project, "listagemManager", tClass);
    }

	@Override
	public EnumDCProjectType getProjectTypeForGenerate() {
		return EnumDCProjectType.WEB;
	}

	@Override
	protected String getClassName(String classNameBasic) {
		return "Listagem".concat(classNameBasic).concat("Manager");
	}
    
}
