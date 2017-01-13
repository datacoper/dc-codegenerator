package com.datacoper.maven.mojos.wizard.impl.datacoper;

import com.datacoper.maven.mojos.IMojo;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Roberto Filho
 */
public class ClassDatacoperWizardTest {

    private ClassDatacoperWizard classWizard;

    @Before
    public void setUp() throws Exception {
        // Monta o Mojo
        IMojo mojoMock = mock(IMojo.class);

        when(mojoMock.getEntityName()).thenReturn("EntidadeTeste");


        classWizard = new ClassDatacoperWizard(mojoMock);
    }

    @Test
    public void deveNaoPedirONomeDaEntidade() throws Exception {
        assertThat(classWizard.questionEntityName(), is(false));
    }
}