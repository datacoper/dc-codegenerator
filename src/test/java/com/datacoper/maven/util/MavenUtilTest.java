package com.datacoper.maven.util;

import org.apache.maven.model.Build;
import org.apache.maven.project.MavenProject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.datacoper.maven.enums.properties.EnumSourceType;

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
    public void deveRetornarOCaminhoParaGerarOsFontesQuando() throws Exception {
        String packag = "com.datacoper.teste";
        String pathEsperado = "diretorioBase/src/test/java/".concat(packag).replace(".", File.separator);
        String pathRetornadoPeloMetodo = MavenUtil.getSourcePathForPackage(project, packag, EnumSourceType.JAVA_TEST);

        assertThat(pathRetornadoPeloMetodo, is(pathEsperado));
    }
}