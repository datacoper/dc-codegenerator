/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.util;

import com.datacoper.maven.exception.DcRuntimeException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.project.MavenProject;

/**
 *
 * @author alessandro
 */
public abstract class ClassLoaderUtil {
    
    private static ClassLoader classLoader;

    static Class<?> loadClass(String className) {
        try {
            return classLoader.loadClass(className);
        } catch (ClassNotFoundException ex) {
            throw new DcRuntimeException(ex);
        }
    }
    
    private ClassLoaderUtil() { }
    
    public static void clearCache() {
        classLoader = null;
    }
    
    public static ClassLoader getClassLoader() {       
        return classLoader;
    }
    
    public static ClassLoader loadClassLoader(MavenProject project) {
        try {
            List<String> elements = CollectionsUtil.concat(project.getRuntimeClasspathElements(), project.getTestClasspathElements());
            
            elements.forEach(item -> LogUtil.error("ALESSANDRO {0}", item));
            
            return initializeClassLoader(elements);

        } catch (DependencyResolutionRequiredException | MalformedURLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    
    public static void addToClassLoader(String classPath) throws MalformedURLException {
        initializeClassLoader(Arrays.asList(classPath));
    }

    private static ClassLoader initializeClassLoader(List<String> elements) throws MalformedURLException {
        URL[] runtimeUrls = convertPathToURI(elements);
        
        final ClassLoader currentContext = Thread.currentThread().getContextClassLoader();
        
        for (URL runtimeUrl : runtimeUrls) {
            LogUtil.error("ALESSANDRO {0}", runtimeUrl);
        }
        
        classLoader = new URLClassLoader(runtimeUrls, currentContext);
        
        return classLoader;
    }

    private static URL[] convertPathToURI(List<String> elements) throws MalformedURLException {
        URL[] runtimeUrls = new URL[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            String element = (String) elements.get(i);
            runtimeUrls[i] = new File(element).toURI().toURL();
        }
        return runtimeUrls;
    }
}
