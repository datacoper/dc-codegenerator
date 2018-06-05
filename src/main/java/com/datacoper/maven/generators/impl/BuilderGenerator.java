/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

<<<<<<< HEAD
import java.io.File;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.generators.AbstractCRUDGenerator;
import com.datacoper.maven.util.StringUtil;

public class BuilderGenerator extends AbstractCRUDGenerator {
=======
import org.apache.maven.project.MavenProject;

import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TClass;

/**
 *
 * @author alessandro
 */
public class BuilderGenerator extends AbstractGenerator {
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
    
    public BuilderGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		super(projectParentFile, entityName, company, moduleName);
	}

	@Override
<<<<<<< HEAD
    public String getTemplateName() {
    	return "builder";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.common.entities.builder", getCompany().getPackageName(), getModuleName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return getEntityName()+"Builder";
=======
	public EnumDCProjectType getProjectTypeForGenerate() {
		return EnumDCProjectType.COMMON;
	}

	@Override
	protected String getClassName(String classNameBasic) {
		return classNameBasic.concat("Builder");
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
	}
}
