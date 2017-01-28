/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators.impl;

import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.metadata.TClass;

/**
 *
 * @author alessandro.abegg
 */
public enum EnumGroupGenerators {
    SCAFFOLD(EntityGenerator.class,
    		BuilderGenerator.class, 
    		RemoteGenerator.class, 
    		VoGenerator.class, 
    		EjbGenerator.class, 
    		ValidatorGenerator.class,
    		ValidatorTestGenerator.class, 
    		GerenciadorGenerator.class, 
    		EaoGenerator.class, 
    		EaoTestGenerator.class, 
    		EaoImplGenerator.class, 
    		QueryGenerator.class, 
    		DtoGenerator.class, 
    		ResourceGenerator.class,
    		ResourceImplGenerator.class,
    		ListagemManagerGenerator.class,
    		FormManagerGenerator.class, 
    		ListagemXHTMLGenerator.class,
    		FormXHTMLGenerator.class
    		)
    ;
    
    private final Class<? extends  AbstractGenerator<TClass>>[] generators;

    @SafeVarargs
	private EnumGroupGenerators(Class<? extends AbstractGenerator<TClass>>... generators) {
        this.generators = generators;
    }
    
    public Class<? extends AbstractGenerator<TClass>>[] getGenerators() {
		return generators;
	}
}
