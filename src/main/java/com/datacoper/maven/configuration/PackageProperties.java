/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.exception.DcRuntimeException;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.util.LinkedProperties;

/**
 *
 * @author alessandro.abegg
 */
public class PackageProperties {
    
    public static final String PROPERTIES_FILE_NAME = "package.properties";
    
    private static final Properties PROPERTIES = new LinkedProperties();
    
    public PackageProperties(CompanyOptions company, String module, String entityName) {
        init(company, module, entityName);
    }

	private void init(CompanyOptions company, String module, String entityName) {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
        
        try {
            PROPERTIES.load(inputStream);
            
            Map<String, Object> externalProperties = loadExternalProperties(company, module, entityName);
            
            processProperties(externalProperties, module, entityName);
        } catch (IOException e) {
            throw new DcRuntimeException(e);
        }
	}

	private Map<String, Object> loadExternalProperties(CompanyOptions company, String module, String entityName) {
		Map<String, Object> externalProperties = new HashMap<>();
		externalProperties.put("company", company);
		externalProperties.put("module", module);
		externalProperties.put("entity", entityName);
		
		return externalProperties;
	}
    
    public String getValue(String property) {
        return PROPERTIES.getProperty(property);
    }
    
    public String getValue(String property, String defaultValue) {
        return PROPERTIES.getProperty(property, defaultValue);
    }
    
    public void getValue(AbstractGenerator<?> abstractGenerator) {
    	String simpleName = abstractGenerator.getClass().getSimpleName();
    	
    	int sizeWordGenerator = 9;
    	
    	String classForGenerate = simpleName.substring(0, simpleName.length() - sizeWordGenerator);
    	
    	//PROPERTIES.getProperty("default.".concat(module).classForGenerate);
	}
    
    public void listProperties() {
        PROPERTIES.list(System.out);
    }

    private void processProperties(Map<String, Object> externalProperties, String module, String entityName) {
        PROPERTIES.stringPropertyNames().forEach(propertyName -> {
            String value = PROPERTIES.getProperty(propertyName);
            
            value = processExternalProperties(value, propertyName, externalProperties);
            
            value = processProperties(value, propertyName);
            
            System.err.println(propertyName + " - " + value);
            
            PROPERTIES.setProperty(propertyName, value);
        });
    }
    
    private String processProperties(String value, String propertyName) {
        Pattern compile = Pattern.compile("\\{([a-z].*?)\\}");
        Matcher matcher = compile.matcher(value);
        
        StringBuffer sb = new StringBuffer();
        
        boolean isReturnSB = false;
        
        while (matcher.find()) {
            String propertyValue = PROPERTIES.getProperty(matcher.group(1));
            
            matcher.appendReplacement(sb, propertyValue);
            
            isReturnSB = true;
        }
        
        return isReturnSB ? matcher.appendTail(sb).toString() : value;
    }

    private String processExternalProperties(String value, String propertyName, Map<String, Object> externalProperties) {       
        Pattern compile = Pattern.compile("\\[([a-z].*?)\\]");
        Matcher matcher = compile.matcher(value);
        
        StringBuffer sb = new StringBuffer();
        
        boolean isReturnSB = false;
        
        while (matcher.find()) {
            String property = selectValueForExternalProperties(matcher, externalProperties);
            
            matcher.appendReplacement(sb, property);
            
            isReturnSB = true;
        }
        
        return isReturnSB ? matcher.appendTail(sb).toString() : value;
    }

    private String selectValueForExternalProperties(Matcher matcher, Map<String, Object> externalProperties) {
    	Object value = externalProperties.get(matcher.group(1));
    	
    	if (value instanceof CompanyOptions) { 
    		return ((CompanyOptions) value).getPackag();
    	} else {
    		return (String) value;
    	}
    }
}