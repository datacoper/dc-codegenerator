/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.metadata.builder.TClassBuilder;
import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.util.StringUtil;
import org.apache.maven.project.MavenProject;

/**
 *
 * @author alessandro
 */
public class RemoteGenerator extends AbstractGenerator<TClass> {
    
    public RemoteGenerator(MavenProject project, TClass data) {
        super(project, "remote", data);
    }

    public String getPackage() {
        return StringUtil.format("com.{0}.cooperate.{1}.common.remote", data.getCompany().getPackag(), getModuleToPackage());
    }
    
    @Override
    protected TClass prepareForGenerate(TClass clazz) {
        return new TClassBuilder(clazz)
                .withPackag(getPackage())
                .withClassName(data.getClassName().concat("Remote"))
                .build();
    }

	@Override
	public EnumDCProjectType getProjectTypeForGenerate() {
		return EnumDCProjectType.COMMON;
	}
}
