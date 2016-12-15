package com.datacoper.maven.util;

import static org.junit.Assert.*;

import org.apache.maven.project.MavenProject;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class DCProjectUtilTest {

    private MavenProject project;

    @Before
    public void setUp() throws Exception {
        project = new MavenProject();
        project.setArtifactId("Faturamento-Parent");
    }

    @Test
    public void deveRetornarONomeDoModuloDoProjeto() {
        String modulo = DCProjectUtil.getName(project);
        
        assertThat(modulo, Matchers.is("Faturamento"));
    }

}
