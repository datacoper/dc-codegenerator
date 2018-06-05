package com.datacoper.maven.generators.impl;

import org.apache.maven.project.MavenProject;

import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TClass;

public class ClassGenerator extends AbstractGenerator {

    private ClassGenerator(MavenProject project, TClass data) {
        super(project, "class", data);
    }
     
    public static void generate(MavenProject project, TClass data) {
        new ClassGenerator(project, data).generate();
    }

	@Override
	public EnumDCProjectType getProjectTypeForGenerate() {
		return null;
	}

	@Override
	protected String getClassName(String classNameBasic) {
		return classNameBasic;
	}
}
