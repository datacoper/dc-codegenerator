/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.util;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.enums.properties.EnumPackagingType;
import com.datacoper.maven.exception.DcRuntimeException;
import org.apache.maven.project.MavenProject;

import java.util.Arrays;

/**
 *
 * @author alessandro
 */
public abstract class DCProjectUtil {
    private DCProjectUtil() { }
    
    public static Class<?> loadEntityByName(MavenProject project, String entityName) {
        String moduleName = getModuleName(project);
        
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
        validatePackaging(enumDCProjectType.getPackagingType(), project);
        
        validateQualifierForProject(enumDCProjectType, project);
    }

    public static void validateQualifierForProject(EnumDCProjectType enumDCProjectType, MavenProject project) throws DcRuntimeException {
        final String qualifierRequired = enumDCProjectType.getQualifier();
        final String qualifierProject = DCProjectUtil.getQualifier(project);
        
        if (!qualifierRequired.equals(qualifierProject)) {
            throw new DcRuntimeException("The project qualifier does not match with ({0})", qualifierRequired);
        }
    }

    public static void validatePackaging(EnumPackagingType enumPackagingType, MavenProject project) throws DcRuntimeException {
        String packaging = enumPackagingType.getName();
        
        if (!project.getPackaging().equals(packaging)) {
            throw new DcRuntimeException("The project packaging does not match with ({0})", packaging);
        }
    }

    public static String getQualifier(MavenProject project) {
        String name = getModuleName(project);
        
        return project.getArtifactId().replaceAll(name, "");
    }
    
    public static boolean isProjectType(EnumDCProjectType projectType, MavenProject project) {
        return project.getPackaging().equals(projectType.getPackagingType().getName()) &&
                isTerminateWith(project, projectType.getQualifier());
    }

    public static String getModuleNameFromParent(MavenProject parentProject) {
        final String name = parentProject.getArtifactId();
        if (!isProjectType(EnumDCProjectType.PARENT, parentProject)) {
            throw new DcRuntimeException("The project {0} not is a project Parent. It does not have the suffix \"-Parent\".", name);
        }

        return name.substring(0, name.length() - 7);
    }
    
    /**
     * Retorna o nome do módulo extraído do artifactId do projeto maven.
     * @param project o projeto Maven.
     * @return o nome do módulo contido no projeto
     */
    public static String getModuleName(MavenProject project) {
        String name = project.getArtifactId();
        
        for (EnumDCProjectType enumDCProjectType : Arrays.asList(EnumDCProjectType.values())) {
            name = name.replace(enumDCProjectType.getQualifier(), "");
        }
        
        return name;
    }
    
    public static MavenProject getMavenProjectFromParent(EnumDCProjectType projectType, MavenProject parentProject) {
        return parentModuleName(parentProject, projectType.getQualifier());
    }

    private static boolean isTerminateWith(MavenProject project, String terminate) {
        String name = project.getArtifactId();

        return StringUtil.isTerminateWith(name, terminate);
    }
    
    private static MavenProject parentModuleName(MavenProject parentProject, String qualifier) {
        String moduleName = getModuleNameFromParent(parentProject);
        
        String projectName = moduleName.concat(qualifier);
        
        return validateAndStartModule(parentProject, projectName);
    }
    
    //Precisa tratar para pegar o module name atraves do pom, ja que os modulos podem estar em outro padrao de pasta
    private static MavenProject validateAndStartModule(MavenProject parentProject, String projectName) throws DcRuntimeException {
        if(!parentProject.getModules().contains(projectName)) {
            throw new DcRuntimeException("Module {0} is not located in parent project {1}", projectName, parentProject.getName());
        }
        
        String pathParent = parentProject.getBasedir().getPath();
        
        MavenProject mavenProject = MavenUtil.createNewMavenProject(pathParent.concat("/").concat(projectName));
        
        return mavenProject;
    }

	public static EnumDCProjectType getModuleType(MavenProject project) {
		String projectName = project.getName();
		
		for(EnumDCProjectType enumDCProjectType : EnumDCProjectType.values()) {
			String qualifier = enumDCProjectType.getQualifier();
			if (projectName.contains(qualifier)) {
				return enumDCProjectType;
			}
		}
		
		return null;
	}
}
