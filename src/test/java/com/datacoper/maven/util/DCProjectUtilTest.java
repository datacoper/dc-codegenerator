package com.datacoper.maven.util;

import com.datacoper.maven.exception.DcRuntimeException;
import org.apache.maven.project.MavenProject;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DCProjectUtilTest {

    private MavenProject project;
    private MavenProject childProject;

    @Before
    public void setUp() throws Exception {
        project = new MavenProject();
        project.setArtifactId("Faturamento-Parent");
        project.setPackaging("pom");

        childProject = new MavenProject();
        childProject.setParent(project);

        childProject.setPackaging("jar");
        childProject.setName("FaturamentoChild");
        childProject.setArtifactId("FaturamentoChildProject");

        project.getModules().add("FaturamentoChild");
    }

    @Test
    public void deveRetornarONomeDoModuloDoProjeto() {
        String modulo = DCProjectUtil.getModuleName(project);
        
        assertThat(modulo, is("Faturamento"));
    }

    @Test(expected = DcRuntimeException.class)
    public void deveLancarExcecaoAoBuscarONomeDoParentAtravesDoFilho() {
        DCProjectUtil.getModuleNameFromParent(childProject);
    }

}
