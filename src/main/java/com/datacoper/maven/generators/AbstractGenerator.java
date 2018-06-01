package com.datacoper.maven.generators;

import java.io.File;

import com.datacoper.freemaker.conf.ConfigurationFreeMarker;
import com.datacoper.freemaker.conf.TemplateFreeMarker;
import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.FileUtil;
import com.datacoper.maven.util.LogUtil;

public abstract class AbstractGenerator {

    public void process(TemplateModel templateModel) {
        
    	templateModel.setPackag(getPackage(templateModel));
    	
    	ConfigurationFreeMarker config = new ConfigurationFreeMarker();
        
    	TemplateFreeMarker templateFreeMarker = new TemplateFreeMarker(getTemplateName() + ".ftl", config);
    	
    	File finalJavaFile = getJavaFile(templateModel); 
        
    	FileUtil.createFolderIfNecessary(finalJavaFile.getParent());
    	
        System.out.println("\n*****************\n");
        
        LogUtil.info("generating class {0}", finalJavaFile);
        
        templateFreeMarker.add("class", templateModel);
        templateFreeMarker.generateTemplate(finalJavaFile);
        
        LogUtil.info("\ngenerated class");
    }

	public File getJavaFile(TemplateModel templateModel) {
		File sourceFolder = new File(new File(templateModel.getProjectParentFile(), templateModel.getModuleBasic()+getProject().getSuffix()), "src/main/java");

        if(!sourceFolder.exists()) {
        	throw new RuntimeException("Source folder not exists: "+sourceFolder);
        }
        
        String packageName = getPackage(templateModel);
        
        packageName = packageName.replace('.', File.separatorChar);
        
        File packageFolder = new File(sourceFolder, packageName);
        
        File finalJavaFile = new File(packageFolder, templateModel.getClassName().concat(".java"));
		return finalJavaFile;
	}

	private String getPackage(TemplateModel templateModel) {
		return getPackage(templateModel.getEntityName(), templateModel.getCompany(), templateModel.getModuleBasic());
	}

    public abstract String getTemplateName();
    
    public abstract EnumProject getProject();
    
    public abstract String getPackage(String entityName, CompanyOptions companyOptions, String moduleName);
    
    public abstract String getClassName(String entityName);
    
}
