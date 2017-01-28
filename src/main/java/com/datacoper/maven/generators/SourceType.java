/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators;

import org.apache.maven.project.MavenProject;

import com.datacoper.maven.util.SystemUtil;

public enum SourceType {
    
    JAVA("java"){
        @Override
        public String getDirectory(MavenProject mavenProject) {
            final String sourceDirectory = mavenProject.getBuild().getSourceDirectory();
            
            return sourceDirectory == null ? processDefaultDirectory(mavenProject) : sourceDirectory;
        }

		@Override
		public String getDefaultPackage() {
			return "src.main.java";
		}
    },
    JAVA_TEST("java"){
        @Override
        public String getDirectory(MavenProject mavenProject) {
            final String testSourceDirectory = mavenProject.getBuild().getTestSourceDirectory();
            
            return testSourceDirectory == null ? processDefaultDirectory(mavenProject) : testSourceDirectory;
        }

		@Override
		public String getDefaultPackage() {
			return "src.test.java";
		}
    },
    XHTML("xhtml") {
        @Override
        public String getDirectory(MavenProject mavenProject) {
            return processDefaultDirectory(mavenProject);
        }

		@Override
		public String getDefaultPackage() {
			return "src.main.webapp";
		}
    },
    
    ;    
    
    private final String fileExtension;

    private SourceType(String fileExtension) {
        this.fileExtension = fileExtension;
    }

        
    public String getFileExtension() {
        return fileExtension;
    }
    
    public abstract String getDirectory(MavenProject mavenProject);
    
    public abstract String getDefaultPackage();
    
    public String processDefaultDirectory(MavenProject mavenProject) {
    	String defaultPackage = this.getDefaultPackage();
    	
    	return mavenProject.getBasedir().getPath().concat(".").concat(defaultPackage).replaceAll("\\.", SystemUtil.getFileSeparator());
    }
}
