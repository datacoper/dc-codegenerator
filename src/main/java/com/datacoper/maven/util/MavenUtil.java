/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.util;

import com.datacoper.maven.exception.DcRuntimeException;
import com.datacoper.maven.generators.SourceType;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

/**
 *
 * @author alessandro
 */
public abstract class MavenUtil {

    private MavenUtil() { }
    
    public static String getPathForPackage(MavenProject project, String packag, SourceType sourceType) {
        String defaultPackage = sourceType.getDirectory(project);
        
        defaultPackage = ".".concat(defaultPackage).concat(".");
        
        final String pathBaseDir = project.getBasedir().getPath();
        
        defaultPackage = pathBaseDir.concat(".").concat(project.getArtifactId()).concat(defaultPackage);
        
        return defaultPackage.concat(packag).replace('.', File.separatorChar);
    }
    
    public static MavenProject createNewMavenProject(String projectPath) {
        return createNewMavenProject(new File(projectPath));
    }
    
    public static MavenProject createNewMavenProject(File folderProject) {
        try {
            File pomFile = getPomFile(folderProject);
            
            FileReader reader = new FileReader(pomFile);
            Model model = new MavenXpp3Reader().read(reader);
            model.setPomFile(pomFile);
            
            MavenProject project = new MavenProject(model);
            project.setFile(folderProject);
            
            return project;
        }catch(IOException | XmlPullParserException ex) {
            throw new DcRuntimeException(ex.getMessage());
        }
    }
    
    public static File getPomFile(File folderProject) {
        FileUtil.validateExistsFolder(folderProject);
        
        final String pathFolder = folderProject.getPath();
        
        File pomFile = new File(pathFolder.concat("/pom.xml"));
        
        FileUtil.validateExistsFile(pomFile);
        
        return pomFile;
    }
}
