package com.datacoper.maven.util;

import org.apache.maven.project.MavenProject;

import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.enums.properties.EnumPackaging;
import com.datacoper.maven.exception.DcRuntimeException;

public abstract class DCProjectUtil {
    private DCProjectUtil() { }
    
    public static boolean isType(MavenProject project, EnumProject enumDCProjectType) {
        try {
            validateTypeAndPackaging(project, enumDCProjectType);
        } catch (DcRuntimeException e) {
            return false;
        }
        
        return true;
    }
    
    public static void validateTypeAndPackaging(MavenProject project, EnumProject enumDCProjectType) {
        validatePackaging(enumDCProjectType.getPackaging(), project);
        
        validateQualifierForProject(enumDCProjectType, project);
    }

    public static void validateQualifierForProject(EnumProject enumDCProjectType, MavenProject project) throws DcRuntimeException {
        final String qualifierRequired = enumDCProjectType.getSuffix();
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
    
    public static boolean isProjectType(EnumProject projectType, MavenProject project) {
        return projectType.getPackaging().getPackaging().equals(project.getPackaging()) && isTerminateWith(project, projectType.getSuffix());
    }

    public static String getModuleNameThroughParent(MavenProject parentProjetct) {
        final String name = parentProjetct.getArtifactId();
        if (!isProjectType(EnumProject.PARENT, parentProjetct)) {
            throw new DcRuntimeException("The project {0} not is a project Parent", name);
        }

        return name.substring(0, name.length() - 7);
    }
    
    public static String getName(MavenProject project) {
        String name = project.getArtifactId();
        
        return name.replaceAll("RestAPI", "")
                .replaceAll("RestAPICommon", "")
                .replaceAll("RestAPICommon", "")
                .replaceAll("EM", "")
                .replaceAll("Common", "")
                .replaceAll("Client", "")
                .replaceAll("-Parent", "")
                .replaceAll("Web", "");
    }
    
    public static MavenProject getMavenProjectFromParent(EnumProject projectType, MavenProject parentProject) {
        return startModule(parentProject, projectType.getSuffix()); 
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
