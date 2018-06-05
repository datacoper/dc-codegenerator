package com.datacoper.maven.metadata;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * @author Roberto Filho
 * Created by filho on 1/11/17.
 */
public class TClassTest {

    @Test
    public void deveRetornarNomeDaClasseComPrimeiraLetraMaisucula() throws Exception {
        TClass teste = new TClassBuilder()
                .withClassName("teste")
                .withClassNameBasic("classeTeste")
                .build();

        assertThat(teste.getClassName(), equalTo("Teste"));
        assertThat(teste.getClassNameBasic(), equalTo("ClasseTeste"));
    }

}