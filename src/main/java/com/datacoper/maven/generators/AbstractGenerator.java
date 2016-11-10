/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators;

import com.datacoper.maven.configuration.PackageProperties;
import com.datacoper.maven.enums.properties.ToFromModule;
import com.datacoper.maven.metadata.TAbstract;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.metadata.builder.TClassBuilder;
import com.datacoper.maven.util.DCProjectUtil;
import com.datacoper.maven.util.StringUtil;
import java.util.Arrays;
import java.util.List;
import org.apache.maven.project.MavenProject;

/**
 *
 * @author alessandro
 * @param <T>
 */
public abstract class AbstractGenerator<T extends TAbstract> implements IGenerator {
    
    protected MavenProject project;
    
    protected T data;
    
    protected String layout;
    
    public AbstractGenerator(MavenProject project, String layout, T data, AbstractGenerator... generators) {
        this(project, layout, data, Arrays.asList(generators));
    }
    
    public AbstractGenerator(MavenProject project, String layout, T data, List<AbstractGenerator> generators) {
        this.project = project;
        this.data = prepareForGenerate(project, data);
        this.layout = layout;
    }
    
    @Override
    public void generate() {
        GenericGenerator.generate(project, layout, prepareForGenerate(data));
    }
    
    protected T prepareForGenerate(T clazz) {
        return clazz;
    }

    private T prepareForGenerate(MavenProject project, T data) {
        return (T) new TClassBuilder((TClass) data)
                .withModuleBasic(DCProjectUtil.getName(project))
                .build();
    }
    
    protected String getPackage() {
        return PackageProperties.get().getValue(layout) StringUtil.format("com.{0}.cooperate.{1}.common.consultas", data.getCompany().getPackag(), getModuleToPackage());
    }
    
    protected String getModuleToPackage() {
        return ToFromModule.from(data.getModuleBasic());
    }
}
