/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

import com.datacoper.maven.enums.properties.EnumDCProjectType;
import static com.datacoper.maven.enums.properties.EnumDCProjectType.*;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.util.DCProjectUtil;
import com.datacoper.maven.util.LogUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.maven.project.MavenProject;

/**
 *
 * @author alessandro.abegg
 */
public enum EnumScaffold {
    ENTITYGENERATOR(EntityGenerator.class, COMMON),
    BUILDERGENERATOR(BuilderGenerator.class, COMMON),
    REMOTEGENERATOR(RemoteGenerator.class, COMMON),
    VOGENERATOR(VoGenerator.class, COMMON),
    EJBGENERATOR(EjbGenerator.class, SERVER),
    VALIDATORGENERATOR(ValidatorGenerator.class, SERVER),
    GERENCIADORGENERATOR(GerenciadorGenerator.class, SERVER),
    EAOGENERATOR(EaoGenerator.class, SERVER),
    EAOIMPLGENERATOR(EaoImplGenerator.class, SERVER),
    QUERYGENERATOR(QueryGenerator.class, SERVER),
    DTOGENERATOR(DtoGenerator.class, REST_COMMON),
    RESOURCEGENERATOR(ResourceGenerator.class, REST_COMMON),
    RESOURCEIMPLGENERATOR(ResourceImplGenerator.class, REST);
    
    private final Class<? extends  AbstractGenerator> generator;
    
    private final EnumDCProjectType projectType;

    private EnumScaffold(Class<? extends AbstractGenerator> generator, EnumDCProjectType projectType) {
        this.generator = generator;
        this.projectType = projectType;
    }

    public Class<? extends AbstractGenerator> getGenerator() {
        return generator;
    }

    public EnumDCProjectType getProjectType() {
        return projectType;
    }
    
    public static List<AbstractGenerator> getAllGeneratorsForProjectType(MavenProject parentProject, TClass data) {
        List<AbstractGenerator> list = new ArrayList<>();
        
        for (EnumDCProjectType value : Arrays.asList(COMMON, SERVER, REST_COMMON, REST)) {
            try {
                MavenProject project = DCProjectUtil.getMavenProjectFromParent(value, parentProject);
                list.addAll(getGenerators(value, project, data));
            } catch (Throwable e) {
                LogUtil.error(e.getMessage());
            }
            
        }
        
        return list;
    }
    
    public static List<AbstractGenerator> getGeneratorsForProjectType(EnumDCProjectType projectType, MavenProject project, TClass data) {
        return getGenerators(projectType, project, data);
    }
    
    private static List<AbstractGenerator> getGenerators(EnumDCProjectType projectType, MavenProject project, TClass data) {
        List<AbstractGenerator> list = new ArrayList<>();
        
        for (EnumScaffold value : values()) {
            if (value.getProjectType().equals(projectType)) {
                try {
                    AbstractGenerator newInstance = value.getGenerator().getConstructor(MavenProject.class, TClass.class).newInstance(project, data);
                    
                    list.add(newInstance);
                } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    LogUtil.error(e);
                }
            }
        }
        
        return list;
    }
}
