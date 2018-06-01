package com.datacoper.maven.generators.impl;

import static com.datacoper.maven.enums.properties.EnumProject.COMMON;
import static com.datacoper.maven.enums.properties.EnumProject.REST;
import static com.datacoper.maven.enums.properties.EnumProject.REST_COMMON;
import static com.datacoper.maven.enums.properties.EnumProject.SERVER;

import java.util.ArrayList;
import java.util.List;

import com.datacoper.cooperate.arquitetura.common.beans.BeanUtil;
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
    RESOURCEGENERATOR(ResourceGenerator.class, REST_COMMON),
    RESOURCEIMPLGENERATOR(ResourceImplGenerator.class, REST);
    
    private final Class<? extends  AbstractGenerator> generator;
    
    private final EnumProject projectType;

    private EnumScaffold(Class<? extends AbstractGenerator> generator, EnumProject projectType) {
        this.generator = generator;
        this.projectType = projectType;
    }

    public AbstractGenerator getGenerator() {
        return BeanUtil.createInstance(generator);
    }

    public EnumProject getProjectType() {
        return projectType;
    }
    
    public static List<AbstractGenerator> getGenerators(EnumProject projectType) {
        List<AbstractGenerator> generators = new ArrayList<>();
        
        for (EnumScaffold value : values()) {
            if (value.getProjectType().equals(projectType)) {
            	generators.add(value.getGenerator());
            }
        }
        
        return generators;
    }
}
