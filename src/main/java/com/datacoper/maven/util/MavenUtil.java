/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.util;

import com.datacoper.maven.exception.DcRuntimeException;
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
    
    public static String getPathForPackage(MavenProject project, String packag) {
        String defaultPackage = project.getBuild().getSourceDirectory();
        
        defaultPackage = ".".concat(defaultPackage != null ? defaultPackage : "src.main.java").concat(".");
        
        //defaultPackage = project.getBasedir().getPath().concat(".").concat(project.getArtifactId()).concat(defaultPackage);
        
        String path = defaultPackage.concat(packag).replace('.', File.separatorChar);
        
        return path;
    }
    
    public static MavenProject startNewProject(String pathProject) {
        return startNewProject(new File(pathProject));
    }
    
    public static MavenProject startNewProject(File folderProject) {
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
