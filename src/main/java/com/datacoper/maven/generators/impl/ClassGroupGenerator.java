/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

import java.util.List;

import com.datacoper.maven.util.DCProjectUtil;
import org.apache.maven.project.MavenProject;

import com.datacoper.maven.enums.properties.EnumDCProjectType;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.generators.AbstractGroupGenerator;
import com.datacoper.maven.generators.IGenerator;
import com.datacoper.maven.metadata.TClass;

/**
 * @author Roberto Filho
 */
public class ClassGroupGenerator implements IGenerator {

    private final AbstractGroupGenerator generator;

    public ClassGroupGenerator(EnumDCProjectType projectType, MavenProject project, TClass data) {
        // Cria os arquivos do novo projeto sendo gerado
        MavenProject newProject = DCProjectUtil.createMavenProjectFromParent(projectType, project);

        // Primeiro busca as classes do tipo de projeto
        List<AbstractGenerator<TClass>> generators = EnumScaffold.forProjectType(projectType, newProject, data);

        this.generator = new AbstractGroupGenerator(generators);
    }

    @Override
    public void generate() {
        generator.generate();
    }
}