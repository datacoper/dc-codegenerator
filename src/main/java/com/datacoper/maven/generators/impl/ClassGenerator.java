package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TAbstract;
import org.apache.maven.project.MavenProject;

public class ClassGenerator extends AbstractGenerator {

    private ClassGenerator(MavenProject project, TAbstract data) {
        super(project, "class", data);
    }
     
    public static void generate(MavenProject project, TAbstract data) {
        new ClassGenerator(project, data).generate();
    }
}
