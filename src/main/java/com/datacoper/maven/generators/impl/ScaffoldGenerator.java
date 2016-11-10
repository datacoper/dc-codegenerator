/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.generators.AbstractGroupGenerator;
import java.util.List;
import org.apache.maven.project.MavenProject;

/**
 *
 * @author alessandro
 */
public class ScaffoldGenerator extends AbstractGroupGenerator {
    
    public static final boolean IS_GENERATE_LOCAL = false;

    public ScaffoldGenerator(MavenProject project, TClass data) {
        super(getGenerators(project, data));
    }
    
    private static List<AbstractGenerator> getGenerators(MavenProject project, TClass data) {
        return EnumScaffold.getAllGeneratorsForProjectType(project, data);
    }
}