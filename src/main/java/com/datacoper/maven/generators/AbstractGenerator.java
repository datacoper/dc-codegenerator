/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators;

import org.apache.maven.project.MavenProject;

import com.datacoper.maven.annotations.GeneratorConfig;
import com.datacoper.maven.configuration.PackageProperties;
import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.enums.properties.ModuleMapper;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.metadata.builder.TClassBuilder;
import com.datacoper.maven.util.DCProjectUtil;

/**
 *
 * @author alessandro
 * @param <T>
 */
public abstract class AbstractGenerator implements IGenerator {
    
    protected MavenProject project;
    
    protected TClass data;

    private String layoutFileName;
    
    public AbstractGenerator(MavenProject project, String layoutFileName, TClass data) {
        this.project = project;
        this.data = prepareForGeneration(project, data);
        this.layoutFileName = layoutFileName;
    }
    
    @Override
    public void generate() {
        SourceFileGenerator.generate(project, layoutFileName, prepareForGenerate(data));
    }
    
    protected TClass prepareForGenerate(TClass clazz) {
    	return new TClassBuilder(clazz)
		        .withPackag(getPackage())
		        .withClassName(getClassName(data.getClassNameBasic()))
		        .withSourceType(getProjectTypeForGenerate().getSourceType())
		        .build();
    }
    
    protected abstract String getClassName(String classNameBasic);

    protected String getPackage() {
    	PackageProperties properties = new PackageProperties(data.getCompany(), DCProjectUtil.getModuleName(project), data.getClassNameBasic());
    	
    	String moduleName = DCProjectUtil.getModuleName(project).toLowerCase();
		String agrupador = getProjectTypeForGenerate().getAgrupador();
		
		String classGenerator = this.getClass().isAnnotationPresent(GeneratorConfig.class) 
				? this.getClass().getAnnotation(GeneratorConfig.class).packag() 
			    : this.getClass().getSimpleName().replaceAll("Generator", "");
		
		return properties.getValue(moduleName, agrupador, classGenerator);
    }

	private TClass prepareForGeneration(MavenProject project, TClass data) {
        return new TClassBuilder(data)
                .withModuleBasic(DCProjectUtil.getModuleName(project))
                .build();
    }
    
    protected String getModuleToPackage() {
        return ModuleMapper.from(data.getModuleBasic()).toLowerCase();
    }
    
    public abstract EnumDCProjectType getProjectTypeForGenerate();
}
