package com.datacoper.maven.util;

import com.datacoper.maven.generators.SourceType;
import org.apache.maven.model.Build;
import org.apache.maven.project.MavenProject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author Roberto Filho
 */
public class MavenUtilTest {

    private MavenProject project;
    private Build build;

    @Before
    public void setUp() {
        build = new Build();
        project = Mockito.mock(MavenProject.class);

        when(project.getBasedir()).thenReturn(new File("diretorioBase"));
        when(project.getArtifactId()).thenReturn("TestProject");
        when(project.getBuild()).thenReturn(build);
    }

    @Test
    public void deveRetornarOCaminhoParaGerarOsFontes() throws Exception {
        String pathRetornadoPeloMetodo = MavenUtil.getPathForPackage(project, "com.datacoper.teste", SourceType.JAVA);

        String pathEsperado = "diretorioBase.TestProject.src.main.java.com.datacoper.teste".replace(".", File.separator);

        assertThat(pathRetornadoPeloMetodo, is(pathEsperado));
    }

    @Test
    public void deveRetornarOCaminhoDoProjetoParent() {
        build.setSourceDirectory("diretorioSource");
        String pathThatShouldReturn = "diretorioBase.TestProject.diretorioSource.com.datacoper.teste".replace(".", File.separator);

        assertThat(MavenUtil.getPathForPackage(project, "com.datacoper.teste", SourceType.JAVA), is(pathThatShouldReturn));
    }

}