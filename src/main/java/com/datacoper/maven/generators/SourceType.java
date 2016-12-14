/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators;

import org.apache.maven.project.MavenProject;

public enum SourceType {
    
    JAVA("java"){
        @Override
        public String getDirectory(MavenProject mavenProject) {
            final String sourceDirectory = mavenProject.getBuild().getSourceDirectory();
            
            return sourceDirectory == null ? "src.main.java" : sourceDirectory;
        }
    },
    JAVA_TEST("java"){
        @Override
        public String getDirectory(MavenProject mavenProject) {
            final String testSourceDirectory = mavenProject.getBuild().getTestSourceDirectory();
            
            return testSourceDirectory == null ? "src.test.java" : testSourceDirectory;
        }
    },
    XHTML("xhtml")
    {
        @Override
        public String getDirectory(MavenProject mavenProject) {
            return "src.main.webapp";
        }
    },
    
    ;    
    
    private final String fileExtension;

    private SourceType(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public abstract String getDirectory(MavenProject mavenProject);
        
    public String getFileExtension() {
        return fileExtension;
    }
}
