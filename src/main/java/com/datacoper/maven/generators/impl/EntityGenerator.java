package com.datacoper.maven.generators.impl;

<<<<<<< HEAD
import java.io.File;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.generators.AbstractCRUDGenerator;
import com.datacoper.maven.util.StringUtil;

public class EntityGenerator extends AbstractCRUDGenerator {

    public EntityGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		super(projectParentFile, entityName, company, moduleName);
	}

	@Override
    public String getTemplateName() {
    	return "entity";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.common.entities", getCompany().getPackageName(), getModuleName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return getEntityName();
=======
import org.apache.maven.project.MavenProject;

import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TClass;

/**
 *
 * @author alessandro
 */
public class EntityGenerator extends AbstractGenerator {
    
    public EntityGenerator(MavenProject project, TClass data) {
        super(project, "entity", data);
    }

	@Override
	public EnumDCProjectType getProjectTypeForGenerate() {
		return EnumDCProjectType.COMMON;
	}

	@Override
	protected String getClassName(String classNameBasic) {
		return classNameBasic;
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
	}
}
