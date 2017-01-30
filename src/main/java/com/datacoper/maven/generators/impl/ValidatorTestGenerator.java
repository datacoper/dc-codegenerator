/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

import org.apache.maven.project.MavenProject;

import com.datacoper.maven.annotations.GeneratorConfig;
import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TClass;

/**
 *
 * @author alessandro
 */
@GeneratorConfig(packag = "validator")
public class ValidatorTestGenerator extends AbstractGenerator {
    
    public ValidatorTestGenerator(MavenProject project, TClass data) {
        super(project, "validatorTest", data);
    }

	@Override
	public EnumDCProjectType getProjectTypeForGenerate() {
		return EnumDCProjectType.SERVER_TEST;
	}

	@Override
	protected String getClassName(String classNameBasic) {
		return "Validador".concat(classNameBasic).concat("Test");
	}
}
