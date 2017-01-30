/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.metadata.builder;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.enums.properties.EnumSourceType;
import com.datacoper.maven.metadata.TAnnotation;
import com.datacoper.maven.metadata.TAttribute;
import com.datacoper.maven.metadata.TClass;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author alessandro
 */
public class TClassBuilder {
    
    private EnumSourceType sourceType;
    
    private CompanyOptions company;
    
    private String moduleBasic;
    
    private String packag;

    private Set<String> imports = new HashSet<>();

    private String className;
    
    private String classNameBasic;

    private String superClass;

    private Set<String> implement = new HashSet<>();

    private Set<TAttribute> attributes = new HashSet<>();

    private Set<TAnnotation> annotations = new HashSet<>();
    
    public TClassBuilder() { }
    
    public TClassBuilder(TClass clazz) {
        this.company = clazz.getCompany();
        this.moduleBasic = clazz.getModuleBasic();
        this.packag = clazz.getPackage();
        this.imports = clazz.getImports();
        this.className = clazz.getClassName();
        this.classNameBasic = clazz.getClassNameBasic();
        this.superClass = clazz.getSuperClass();
        this.implement = clazz.getImplement();
        this.attributes = clazz.getAttributes();
        this.annotations = clazz.getAnnotations();
        this.sourceType = clazz.getSourceType();
    }
    
    public TClassBuilder withSourceType(EnumSourceType sourceType) {
        this.sourceType = sourceType;
        
        return this;
    }
    
    public TClassBuilder withClassNameBasic(String classNameBasic) {
        this.classNameBasic = classNameBasic;
        
        return this;
    }
    
    public TClassBuilder withCompany(CompanyOptions company) {
        this.company = company;
        
        return this;
    }

    public TClassBuilder withModuleBasic(String moduleBasic) {
        this.moduleBasic = moduleBasic;
        
        return this;
    }

    public TClassBuilder withPackag(String packag) {
        this.packag = packag;
        
        return this;
    }

    public TClassBuilder withImports(Set<String> imports) {
        this.imports = imports;
        
        return this;
    }

    public TClassBuilder withClassName(String className) {
        this.className = className;
        
        return this;
    }
    
    public TClassBuilder withSuperClass(String superClass) {
        this.superClass = superClass;
        
        return this;
    }

    public TClassBuilder withImplement(Set<String> implement) {
        this.implement = implement;
        
        return this;
    }

    public TClassBuilder withAttributes(Set<TAttribute> attributes) {
        this.attributes = attributes;
        
        return this;
    }

    public TClassBuilder withAnnotations(Set<TAnnotation> annotations) {
        this.annotations = annotations;
        
        return this;
    }
    
    public TClass build() {
        return new TClass(sourceType, company, moduleBasic, packag, className, classNameBasic, superClass, imports, implement, attributes, annotations);
    }
}
