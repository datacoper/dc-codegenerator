package com.datacoper.maven.generators;

import java.io.File;

import com.datacoper.freemaker.conf.ConfigurationFreeMarker;
import com.datacoper.freemaker.conf.TemplateFreeMarker;
import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.generators.impl.EnumScaffold;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.FileUtil;
import com.datacoper.maven.util.LogUtil;

public abstract class AbstractCRUDGenerator {

	private File projectParentFile;
	
	private String entityName;
	
	private Company company;
	
	private String moduleName;
	
    public AbstractCRUDGenerator(File projectParentFile, String entityName, Company company, String moduleName) {
		this.projectParentFile = projectParentFile;
    	this.entityName = entityName;
		this.company = company;
		this.moduleName = moduleName;		
	}
    
    public Company getCompany() {
		return company;
	}
    
    public String getModuleName() {
		return moduleName;
	}
    
    public String getEntityName() {
		return entityName;
	}

	public void process() {
        
		TemplateModel templateModel = createTemplateModel();
		
    	ConfigurationFreeMarker config = new ConfigurationFreeMarker();
        
    	TemplateFreeMarker templateFreeMarker = new TemplateFreeMarker(getTemplateName() + ".ftl", config);
    	
    	File finalJavaFile = getJavaFile(); 
        
    	FileUtil.createFolderIfNecessary(finalJavaFile.getParent());
    	
        LogUtil.info("generating class {0}", finalJavaFile);
        
        templateFreeMarker.add("class", templateModel);
        templateFreeMarker.generateTemplate(finalJavaFile);
        
    }

	private TemplateModel createTemplateModel() {
		
		TemplateModel templateModel = new TemplateModel(entityName, company, moduleName, getClassName(), getPackage());
		
		return templateModel;
	}

	public File getJavaFile() {
		File sourceFolder = new File(new File(projectParentFile, getModuleName()+getProject().getSuffix()), "src/main/java");

        if(!sourceFolder.exists()) {
        	throw new RuntimeException("Source folder not exists: "+sourceFolder);
        }
        
        String packageName = getPackage();
        
        packageName = packageName.replace('.', File.separatorChar);
        
        File packageFolder = new File(sourceFolder, packageName);
        
        File finalJavaFile = new File(packageFolder, getClassName().concat(".java"));
		return finalJavaFile;
	}

    public abstract String getTemplateName();
    
    public final EnumProject getProject() {
    	return EnumScaffold.of(getClass());
    }
    
    public abstract String getPackage();
    
    public abstract String getClassName();
    
}
