package com.datacoper.maven.generators.impl;

<<<<<<< HEAD
import java.io.File;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.generators.AbstractCRUDGenerator;
import com.datacoper.maven.util.StringUtil;

public class VoGenerator extends AbstractCRUDGenerator {
=======
import org.apache.maven.project.MavenProject;

import com.datacoper.maven.annotations.GeneratorConfig;
import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TClass;

/**
 *
 * @author alessandro
 */
@GeneratorConfig(packag = "consultas")
public class VoGenerator extends AbstractGenerator {
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
    
    public VoGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		super(projectParentFile, entityName, company, moduleName);
	}

	@Override
<<<<<<< HEAD
    public String getTemplateName() {
    	return "vo";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.common.consultas", getCompany().getPackageName(), getModuleName().toLowerCase(), getEntityName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return getEntityName()+"VO";
=======
	public EnumDCProjectType getProjectTypeForGenerate() {
		return EnumDCProjectType.COMMON;
	}

	@Override
	protected String getClassName(String classNameBasic) {
		return classNameBasic.concat("VO");
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
	}
}
