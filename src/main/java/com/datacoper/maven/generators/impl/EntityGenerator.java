/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.metadata.builder.TClassBuilder;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.util.StringUtil;
import org.apache.maven.project.MavenProject;

/**
 *
 * @author alessandro
 */
public class EntityGenerator extends AbstractGenerator<TClass> {
    
    public EntityGenerator(MavenProject project, TClass data) {
        super(project, "entity", data);
    }

    public String getPackage(CompanyOptions company) {
        return StringUtil.format("com.{0}.cooperate.{1}.common.entities", company.getPackag(), getModuleToPackage());
    }

    @Override
    protected TClass prepareForGenerate(TClass clazz) {
        return new TClassBuilder(clazz)
                .withPackag(getPackage(data.getCompany()))
                .build();
    }

	@Override
	public EnumDCProjectType getProjectTypeForGenerate() {
		return EnumDCProjectType.COMMON;
	}
}
