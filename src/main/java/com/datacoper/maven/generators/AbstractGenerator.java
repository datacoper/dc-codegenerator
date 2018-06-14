package com.datacoper.maven.generators;

import java.io.File;

import com.datacoper.freemarker.conf.ConfigurationFreeMarker;
import com.datacoper.freemarker.conf.TemplateFreeMarker;
import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.generators.impl.EnumScaffold;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.util.FileUtil;
import com.datacoper.maven.util.LogUtil;

public abstract class AbstractGenerator {

	private TemplateModel templateModel;
	
    public AbstractGenerator(TemplateModel templateModel) {
    	this.templateModel = templateModel;
    }
    
    public String getModuleName() {
    	return templateModel.getModuleName();
    }
    
    public String getEntityName() {
    	return templateModel.getEntityName();
    }
    
    public Company getCompany() {
    	return templateModel.getCompany();
    }
    
    public TemplateModel getTemplateModel() {
		return templateModel;
	}
    
	public void process() {
		
		templateModel.setPackag(getPackage());
		templateModel.setClassName(getClassName());
		
    	ConfigurationFreeMarker config = new ConfigurationFreeMarker();
        
    	TemplateFreeMarker templateFreeMarker = new TemplateFreeMarker(getTemplateName() + ".ftl", config);
    	
    	File finalJavaFile = getJavaFile(); 
        
    	FileUtil.createFolderIfNecessary(finalJavaFile.getParent());
    	
        LogUtil.info("generating class {0}", finalJavaFile);
        
        templateFreeMarker.add("model", templateModel);
        
        templateFreeMarker.generateTemplate(finalJavaFile, getCharsetName());
        
    }

	public File getJavaFile() {
		File sourceFolder = new File(new File(templateModel.getProjectParentFile(), templateModel.getModuleName()+getProject().getSuffix()), getProject().getSourceFolder().getSourceFolder());

        if(!sourceFolder.exists()) {
        	throw new RuntimeException("Source folder not exists: "+sourceFolder);
        }
        
        String packageName = getPackage();
        
        packageName = packageName.replace('.', File.separatorChar);
        
        File packageFolder = new File(sourceFolder, packageName);
        
        File finalJavaFile = new File(packageFolder, getClassName().concat(getFileExtension()));
		return finalJavaFile;
	}

    public abstract String getTemplateName();
    
    public final EnumProject getProject() {
    	return EnumScaffold.of(getClass());
    }
    
    public abstract String getPackage();
    
    public abstract String getClassName();
    
    public abstract String getFileExtension();
    
    public abstract String getCharsetName();
}
