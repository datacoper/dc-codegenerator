package com.datacoper.maven.generators.impl;

import java.io.File;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.generators.AbstractGenerator;

public abstract class AbctractAngularGenerator extends AbstractGenerator {

	public AbctractAngularGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		super(projectParentFile, entityName, company, moduleName);
	}

	@Override
	public String getFileExtension() {
		return ".js";
	}
	
}
