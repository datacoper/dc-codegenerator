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

/**
 *
 * @author alessandro
 */
public class ListagemXHTMLGenerator extends AbstractGenerator {
    
    public ListagemXHTMLGenerator(MavenProject project, TClass data) {
        super(project, "listagemXHTML", data);
    }

	@Override
	public EnumDCProjectType getProjectTypeForGenerate() {
		return EnumDCProjectType.WEB_PAGES;
	}

	@Override
	protected String getClassName(String classNameBasic) {
		return "listagem".concat(classNameBasic);
	}
}
