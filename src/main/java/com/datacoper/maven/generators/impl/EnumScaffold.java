package com.datacoper.maven.generators.impl;

import static com.datacoper.maven.enums.properties.EnumProject.COMMON;
import static com.datacoper.maven.enums.properties.EnumProject.REST;
import static com.datacoper.maven.enums.properties.EnumProject.REST_COMMON;
import static com.datacoper.maven.enums.properties.EnumProject.SERVER;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.generators.AbstractGenerator;

public enum EnumScaffold {
    ENTITYGENERATOR(EntityGenerator.class, COMMON),
    BUILDERGENERATOR(BuilderGenerator.class, COMMON),
    VOGENERATOR(VoGenerator.class, COMMON),
    VALIDATORGENERATOR(ValidatorGenerator.class, SERVER),
    EAOGENERATOR(EaoGenerator.class, SERVER),
    EAOIMPLGENERATOR(EaoImplGenerator.class, SERVER),
    QUERYGENERATOR(QueryGenerator.class, SERVER),
    DTOGENERATOR(DtoGenerator.class, REST_COMMON),
    SERVICEGENERATOR(ServiceGenerator.class, COMMON),
    SERVICEIMPLGENERATOR(ServiceImplGenerator.class, SERVER),
    RESOURCEGENERATOR(ResourceGenerator.class, REST_COMMON),
    RESOURCEIMPLGENERATOR(ResourceImplGenerator.class, REST);
    
    private final Class<? extends  AbstractGenerator> generator;
    
    private final EnumProject projectType;

    private EnumScaffold(Class<? extends AbstractGenerator> generator, EnumProject projectType) {
        this.generator = generator;
        this.projectType = projectType;
    }

    public AbstractGenerator getGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
        try {
			Constructor<? extends AbstractGenerator> constructor = generator.getConstructor(File.class, String.class, Company.class, String.class);
			return constructor.newInstance(projectParentFile, entityName, company, moduleName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }

    public static EnumProject of(Class<? extends AbstractGenerator> generatorClass) {
    	for (EnumScaffold value : values()) {
            if (value.generator.equals(generatorClass)) {
            	return value.projectType;
            }
        }
    	throw new IllegalArgumentException("Invalid generatorClass: "+generatorClass);
    }
    
    public EnumProject getProjectType() {
        return projectType;
    }
    
    public static List<AbstractGenerator> getGenerators(EnumProject projectType, File projectParentFile, String entityName, Company company, String moduleName) {
        List<AbstractGenerator> generators = new ArrayList<>();
        
        for (EnumScaffold value : values()) {
            if (value.getProjectType().equals(projectType)) {
            	generators.add(value.getGenerator(projectParentFile, entityName, company, moduleName));
            }
        }
        
        return generators;
    }
}
