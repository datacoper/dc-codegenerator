package com.datacoper.maven.generators.impl;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.generators.AbstractGenerator;

public enum EnumScaffold {
    ENTITYGENERATOR(EntityGenerator.class, EnumProject.COMMON),
    BUILDERGENERATOR(BuilderGenerator.class, EnumProject.COMMON),
    VOGENERATOR(VoGenerator.class, EnumProject.COMMON),
    VALIDATORGENERATOR(ValidatorGenerator.class, EnumProject.SERVER),
    EAOGENERATOR(EaoGenerator.class, EnumProject.SERVER),
    EAOIMPLGENERATOR(EaoImplGenerator.class, EnumProject.SERVER),
    QUERYGENERATOR(QueryGenerator.class, EnumProject.SERVER),
    DTOGENERATOR(DtoGenerator.class, EnumProject.REST_COMMON),
    SERVICEGENERATOR(ServiceGenerator.class, EnumProject.COMMON),
    SERVICEIMPLGENERATOR(ServiceImplGenerator.class, EnumProject.SERVER),
    RESOURCEGENERATOR(ResourceGenerator.class, EnumProject.REST_COMMON),
    RESOURCEIMPLGENERATOR(ResourceImplGenerator.class, EnumProject.REST),
	ANGULARCONTROLLERGENERATOR(AngularControllerGenerator.class, EnumProject.ANGULAR), 
	ANGULARHTMLGENERATOR(AngularHtmlGenerator.class, EnumProject.ANGULAR),
	ANGULARMAINSERVICEGENERATOR(AngularMainServiceGenerator.class, EnumProject.ANGULAR),
	ANGULARMODULEGENERATOR(AngularModuleGenerator.class, EnumProject.ANGULAR),
	ANGULARRESOURCEGENERATOR(AngularResourceGenerator.class, EnumProject.ANGULAR),
	ANGULARROUTEGENERATOR(AngularRouteGenerator.class, EnumProject.ANGULAR),
	ANGULARROUTEFACTORYGENERATOR(AngularRouteFactoryGenerator.class, EnumProject.ANGULAR),
    
	;
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
