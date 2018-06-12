package com.datacoper.maven.generators.impl;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TemplateModel;

public enum EnumScaffoldDetail {
    ENTITYGENERATOR(EntityGenerator.class, EnumProject.COMMON),
    BUILDERGENERATOR(BuilderGenerator.class, EnumProject.COMMON),    
    VALIDATORGENERATOR(ValidatorGenerator.class, EnumProject.SERVER),
    EAOGENERATOR(EaoGenerator.class, EnumProject.SERVER),
    EAOIMPLGENERATOR(EaoImplGenerator.class, EnumProject.SERVER),    
    DTOGENERATOR(DtoGenerator.class, EnumProject.REST_COMMON),
    SERVICEGENERATOR(ServiceDetailGenerator.class, EnumProject.COMMON),
    SERVICEIMPLGENERATOR(ServiceImplDetailGenerator.class, EnumProject.SERVER),
    RESOURCEGENERATOR(ResourceDetailGenerator.class, EnumProject.REST_COMMON),
    RESOURCEIMPLGENERATOR(ResourceImplDetailGenerator.class, EnumProject.REST),
	ANGULARCONTROLLERGENERATOR(AngularControllerDetailGenerator.class, EnumProject.ANGULAR), 
	ANGULARHTMLGENERATOR(AngularHtmlDetailGenerator.class, EnumProject.ANGULAR),
	ANGULARMAINSERVICEGENERATOR(AngularMainServiceDetailGenerator.class, EnumProject.ANGULAR),
	ANGULARMODULEGENERATOR(AngularModuleDetailGenerator.class, EnumProject.ANGULAR),
	ANGULARRESOURCEGENERATOR(AngularResourceDetailGenerator.class, EnumProject.ANGULAR),
	ANGULARROUTEGENERATOR(AngularRouteDetailGenerator.class, EnumProject.ANGULAR),
	ANGULARROUTEFACTORYGENERATOR(AngularRouteFactoryDetailGenerator.class, EnumProject.ANGULAR),
    
	;
    private final Class<? extends  AbstractGenerator> generator;
    
    private final EnumProject projectType;

    private EnumScaffoldDetail(Class<? extends AbstractGenerator> generator, EnumProject projectType) {
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
    	for (EnumScaffoldDetail value : values()) {
            if (value.generator.equals(generatorClass)) {
            	return value.projectType;
            }
        }
    	throw new IllegalArgumentException("Invalid generatorClass: "+generatorClass);
    }
    
    public EnumProject getProjectType() {
        return projectType;
    }
    
    public static List<AbstractGenerator> getGenerators(EnumProject projectType, TemplateModel templateModel) {
        List<AbstractGenerator> generators = new ArrayList<>();
        
        for (EnumScaffoldDetail value : values()) {
            if (value.getProjectType().equals(projectType)) {
            	generators.add(value.getGenerator(templateModel));
            }
        }
        
        return generators;
    }
}
