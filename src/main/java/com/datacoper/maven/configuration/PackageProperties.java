/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.configuration;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.exception.DcRuntimeException;
import com.datacoper.maven.util.LinkedProperties;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alessandro.abegg
 */
public class PackageProperties {
    
    public static final String PROPERTIES_FILE_NAME = "package.properties";
    
    private static final Properties PROPERTIES = new LinkedProperties();
    
    public PackageProperties(CompanyOptions company) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
        
        try {
            PROPERTIES.load (inputStream);
            
            processProperties(company);
        } catch (IOException e) {
            throw new DcRuntimeException(e);
        }
    }
    
    public String getValue(String property) {
        return PROPERTIES.getProperty(property);
    }
    
    public String getValue(String property, String defaultValue) {
        return PROPERTIES.getProperty(property, defaultValue);
    }
    
    public void listProperties() {
        PROPERTIES.list(System.out);
    }

    private void processProperties(CompanyOptions company) {
        PROPERTIES.stringPropertyNames().forEach(propertyName -> {
            String value = PROPERTIES.getProperty(propertyName);
            
            value = processExternalProperties(value, propertyName, company);
            
            value = processProperties(value, propertyName);
            
            PROPERTIES.setProperty(propertyName, value);
        });
    }
    
    private String processProperties(String value, String propertyName) {
        Pattern compile = Pattern.compile("\\{([a-z].+)\\}");
        Matcher matcher = compile.matcher(value);
        
        while (matcher.find()) {
            String propertyValue = PROPERTIES.getProperty(matcher.group(1));
            
            value = matcher.replaceAll(propertyValue);
        }
        
        System.out.println(value);
        
        return value;
    }

    private String processExternalProperties(String value, String propertyName, CompanyOptions company) {       
        Pattern compile = Pattern.compile("\\[([a-z].+)\\]");
        Matcher matcher = compile.matcher(value);
        
        while (matcher.find()) {
            String property = selectValueForExternalProperties(matcher, company);
            
            value = matcher.replaceAll(property);
        }
        
        return value;
    }

    private String selectValueForExternalProperties(Matcher matcher, CompanyOptions company) {
        String property = "";
        
        switch (matcher.group(1)) {
            case "company" : property = company.getPackag(); break;
        }
        return property;
    }
    
    public static void main(String[] args) {
        new PackageProperties(CompanyOptions.ALFA).listProperties();
    }
}