package com.datacoper.maven.generators.impl;

import java.io.File;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.generators.AbstractGenerator;

public abstract class AbctractJavaGenerator extends AbstractGenerator {

	public AbctractJavaGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		super(projectParentFile, entityName, company, moduleName);
	}

	@Override
	public String getFileExtension() {
		return ".java";
	}
	
}
