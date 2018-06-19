package com.datacoper.maven.generators.impl;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import com.datacoper.maven.enums.EnumProject;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TemplateModel;

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

    public AbstractGenerator getGenerator(TemplateModel templateModel) {
        try {
			Constructor<? extends AbstractGenerator> constructor = generator.getConstructor(TemplateModel.class);
			return constructor.newInstance(templateModel);
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
    	
    	return EnumScaffoldDetail.of(generatorClass);
    }
    
    public EnumProject getProjectType() {
        return projectType;
    }
    
    public static List<AbstractGenerator> getGenerators(EnumProject projectType, TemplateModel templateModel) {
        List<AbstractGenerator> generators = new ArrayList<>();
        
        for (EnumScaffold value : values()) {
            if (value.getProjectType().equals(projectType)) {
            	generators.add(value.getGenerator(templateModel));
            }
        }
        
        return generators;
    }
}
