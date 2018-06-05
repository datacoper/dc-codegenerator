package com.datacoper.maven.generators.impl;

<<<<<<< HEAD
import java.io.File;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.generators.AbstractCRUDGenerator;
import com.datacoper.maven.util.StringUtil;

public class QueryGenerator extends AbstractCRUDGenerator  {
=======
import org.apache.maven.project.MavenProject;

import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TClass;

/**
 *
 * @author alessandro
 */
public class QueryGenerator extends AbstractGenerator  {
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
    
    public QueryGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		super(projectParentFile, entityName, company, moduleName);
	}

	@Override
<<<<<<< HEAD
    public String getTemplateName() {
    	return "query";
    }

    @Override
    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.server.consultas", getCompany().getPackageName(), getModuleName().toLowerCase());
    }

	@Override
	public String getClassName() {
		return "Query"+getEntityName();
=======
	public EnumDCProjectType getProjectTypeForGenerate() {
		return EnumDCProjectType.SERVER;
	}

	@Override
	protected String getClassName(String classNameBasic) {
		return "Query".concat(classNameBasic);
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
	}
}
