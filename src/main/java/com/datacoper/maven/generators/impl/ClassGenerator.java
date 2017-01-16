package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TAbstract;

public class ClassGenerator extends AbstractGenerator {

    private ClassGenerator(String project, TAbstract data) {
        super(project, "class", data);
    }
     
    public static void generate(String project, TAbstract data) {
        new ClassGenerator(project, data).generate();
    }
}
