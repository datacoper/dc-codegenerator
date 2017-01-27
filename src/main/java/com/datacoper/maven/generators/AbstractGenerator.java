/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators;

import org.apache.maven.project.MavenProject;

import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.enums.properties.ModuleMapper;
import com.datacoper.maven.metadata.TAbstract;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.metadata.builder.TClassBuilder;
import com.datacoper.maven.util.DCProjectUtil;

/**
 *
 * @author alessandro
 * @param <T>
 */
public abstract class AbstractGenerator<T extends TAbstract> implements IGenerator {
    
    protected MavenProject project;
    
    protected T data;

    private String layoutFileName;
    
    public AbstractGenerator(MavenProject project, String layoutFileName, T data) {
        this.project = project;
        this.data = prepareForGeneration(project, data);
        this.layoutFileName = layoutFileName;
    }
    
    @Override
    public void generate() {
        SourceFileGenerator.generate(project, layoutFileName, prepareForGenerate(data));
    }
    
    protected T prepareForGenerate(T clazz) {
        return clazz;
    }

    @SuppressWarnings("unchecked")
	private T prepareForGeneration(MavenProject project, T data) {
        return (T) new TClassBuilder((TClass) data)
                .withModuleBasic(DCProjectUtil.getModuleName(project))
                .build();
    }
    
    protected String getModuleToPackage() {
        return ModuleMapper.from(data.getModuleBasic()).toLowerCase();
    }
    
    public abstract EnumDCProjectType getProjectTypeForGenerate();
}
