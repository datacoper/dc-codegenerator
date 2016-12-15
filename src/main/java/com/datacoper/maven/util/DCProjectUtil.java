/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.util;

import java.util.Arrays;

import org.apache.maven.project.MavenProject;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.enums.properties.EnumPackaging;
import com.datacoper.maven.exception.DcRuntimeException;

/**
 *
 * @author alessandro
 */
public abstract class DCProjectUtil {
    private DCProjectUtil() { }
    
    public static Class<?> loadEntityByName(MavenProject project, String entityName) {
        String moduleName = getName(project);
        
        for (CompanyOptions company : CompanyOptions.values()) {
            String className = StringUtil.format("com.{0}.cooperate.{1}.common.entities.{2}", company.getPackag(), moduleName.toLowerCase(), entityName);
            
            try {
                return ClassLoaderUtil.loadClass(className);
            } catch (Throwable e) {
                LogUtil.warn("class not found for {0}", className);
            }
        }
        
        throw new DcRuntimeException("Entity not initialized.");
    }
    
    public static boolean isType(MavenProject project, EnumDCProjectType enumDCProjectType) {
        try {
            validateTypeAndPackaging(project, enumDCProjectType);
        } catch (DcRuntimeException e) {
            return false;
        }
        
        return true;
    }
    
    public static void validateTypeAndPackaging(MavenProject project, EnumDCProjectType enumDCProjectType) {
        validatePackaging(enumDCProjectType.getPackaging(), project);
        
        validateQualifierForProject(enumDCProjectType, project);
    }

    public static void validateQualifierForProject(EnumDCProjectType enumDCProjectType, MavenProject project) throws DcRuntimeException {
        final String qualifierRequired = enumDCProjectType.getQualifier();
        final String qualifierProject = DCProjectUtil.getQualifier(project);
        
        if (!qualifierRequired.equals(qualifierProject)) {
            throw new DcRuntimeException("The project qualifier does not match with ({0})", qualifierRequired);
        }
    }

    public static void validatePackaging(EnumPackaging enumPackaging, MavenProject project) throws DcRuntimeException {
        String packaging = enumPackaging.getPackaging();
        
        if (!project.getPackaging().equals(packaging)) {
            throw new DcRuntimeException("The project packaging does not match with ({0})", packaging);
        }
    }

    public static String getQualifier(MavenProject project) {
        String name = getName(project);
        
        return project.getArtifactId().replaceAll(name, "");
    }
    
    public static boolean isProjectType(EnumDCProjectType projectType, MavenProject project) {
        return projectType.getPackaging().getPackaging().equals(project.getPackaging()) && isTerminateWith(project, projectType.getQualifier());
    }

    public static String getModuleNameThroughParent(MavenProject parentProjetct) {
        final String name = parentProjetct.getArtifactId();
        if (!isProjectType(EnumDCProjectType.PARENT, parentProjetct)) {
            throw new DcRuntimeException("The project {0} not is a project Parent", name);
        }

        return name.substring(0, name.length() - 7);
    }
    
    /**
     * Retorna o nome do módulo extraído do artifactId do projeto maven.
     * @param project o projeto Maven.
     * @return o nome do módulo contido no projeto
     */
    public static String getName(MavenProject project) {
        String name = project.getArtifactId();
        
        for (EnumDCProjectType enumDCProjectType : Arrays.asList(EnumDCProjectType.values())) {
            name = name.replace(enumDCProjectType.getQualifier(), "");
        }
        
        return name;
    }
    
    public static MavenProject getMavenProjectFromParent(EnumDCProjectType projectType, MavenProject parentProject) {
        return startModule(parentProject, projectType.getQualifier()); 
    }

    private static boolean isTerminateWith(MavenProject project, String terminate) {
        String name = project.getArtifactId();

        return StringUtil.isTerminateWith(name, terminate);
    }
    
    private static MavenProject startModule(MavenProject parentProjetct, String qualifier) {
        String moduleName = getModuleNameThroughParent(parentProjetct);
        
        moduleName = moduleName.concat(qualifier);
        
        return validateAndStartModule(parentProjetct, moduleName);
    }
    
    //Precisa tratar para pegar o module name atraves do pom, ja que os modulos podem estar em outro padrao de pasta
    private static MavenProject validateAndStartModule(MavenProject parentProjetct, String moduleName) throws DcRuntimeException {
        if(!parentProjetct.getModules().contains(moduleName)) {
            throw new DcRuntimeException("Module {0} is not located in parent project {0}", moduleName, parentProjetct.getName());
        }
        
        String pathParent = parentProjetct.getBasedir().getPath();
        
        MavenProject mavenProject = MavenUtil.startNewProject(pathParent.concat("/").concat(moduleName));
        
        return mavenProject;
    }
}
