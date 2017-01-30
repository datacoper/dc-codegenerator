/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.metadata;

import com.datacoper.maven.enums.options.BooleanOptions;
import com.datacoper.maven.enums.options.ModifierOptions;

import java.util.Set;

/**
 *
 * @author alessandro.abegg
 */
public class TAttributeBuilder {
    private String importt;
    
    private ModifierOptions encapsulation;

    private BooleanOptions staticAttribute;
    
    private BooleanOptions finalAttribute;
    
    private String name;
    
    private String alias;

    private BooleanOptions generateGet;

    private BooleanOptions generateSet;
    
    private Set<TAnnotation> annotations;
    
    public TAttributeBuilder() { }
    
    public TAttributeBuilder(TAttribute attribute) {
        this.importt = attribute.getImport();
        this.encapsulation = attribute.getEncapsulation();
        this.staticAttribute = attribute.isStaticAttribute();
        this.finalAttribute = attribute.isFinalAttribute();
        this.name = attribute.getName();
        this.generateGet = attribute.getGenerateGet();
        this.generateSet = attribute.getGenerateSet();
        this.annotations = attribute.getAnnotations();
        this.alias = attribute.getAlias();
    }
    
    public TAttribute build() {
        return new TAttribute(importt, encapsulation, staticAttribute, finalAttribute, name, alias, generateGet, generateSet, annotations);
    }
    
    public TAttributeBuilder withImport(String importt) {
        this.importt = importt;
        return this;
    }
    
    public TAttributeBuilder withEncapsulation(ModifierOptions encapsulation) {
        this.encapsulation = encapsulation;
        return this;
    }
    
    public TAttributeBuilder withStaticAttribute(BooleanOptions staticAttribute) {
        this.staticAttribute = staticAttribute;
        return this;
    }
    
    public TAttributeBuilder withFinalAttribute(BooleanOptions finalAttribute) {
        this.finalAttribute = finalAttribute;
        return this;
    }
    
    public TAttributeBuilder withName(String name) {
        this.name = name;
        return this;
    }
    
    public TAttributeBuilder withAlias(String alias) {
        this.alias = alias;
        return this;
    }
    
    public TAttributeBuilder withGenerateGet(BooleanOptions generateGet) {
        this.generateGet = generateGet;
        return this;
    }
    
    public TAttributeBuilder withGenerateSet(BooleanOptions generateSet) {
        this.generateSet = generateSet;
        return this;
    }
    
    public TAttributeBuilder withAnnotations(Set<TAnnotation> annotations) {
        this.annotations = annotations;
        return this;
    }
}
