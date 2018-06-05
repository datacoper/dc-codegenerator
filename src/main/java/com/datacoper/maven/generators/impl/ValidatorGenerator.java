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

public class ValidatorGenerator extends AbstractCRUDGenerator {
=======
import org.apache.maven.project.MavenProject;

import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TClass;

/**
 *
 * @author alessandro
 */
public class ValidatorGenerator extends AbstractGenerator {
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
    
    public ValidatorGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		super(projectParentFile, entityName, company, moduleName);
	}

	@Override
<<<<<<< HEAD
    public String getTemplateName() {
    	return "validator";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.server.{2}", getCompany().getPackageName(), getModuleName().toLowerCase(), getEntityName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return "Validador"+getEntityName();
=======
	public EnumDCProjectType getProjectTypeForGenerate() {
		return EnumDCProjectType.SERVER;
	}

	@Override
	protected String getClassName(String classNameBasic) {
		return "Validador".concat(classNameBasic);
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
	}
}
