package com.datacoper.maven.metadata;

import java.util.Collections;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.generators.SourceType;

public class TClass {
    
    private final SourceType sourceType;
    
    private  final CompanyOptions company;
    
    private final String moduleBasic;

    private final String packag;

    private final Set<String> imports;

    private final String className;
    
    private final String classNameBasic;

    private final String superClass;

    private final Set<String> implement;

    private final Set<TAttribute> attributes;

    private final Set<TAnnotation> annotations;
    
    public TClass(SourceType sourceType, CompanyOptions empresa, String packag, String className, String classNameBasic, String superClass, Set<String> imports, Set<String> implement, Set<TAttribute> attributes, Set<TAnnotation> annotations) {
        this(sourceType, empresa, "", packag, className, classNameBasic, superClass, imports, implement, attributes, annotations);
    }
    
    public TClass(SourceType sourceType, CompanyOptions empresa, String moduleBasic, String packag, String className, String classNameBasic, String superClass, Set<String> imports, Set<String> implement, Set<TAttribute> attributes, Set<TAnnotation> annotations) {
        this.sourceType = sourceType;
        this.company = empresa;
        this.moduleBasic = moduleBasic;
        this.packag = packag;
        this.className = StringUtils.capitalize(className);
        this.classNameBasic = StringUtils.capitalize(classNameBasic);
        this.superClass = superClass;
        this.imports = imports;
        this.attributes = attributes;
        this.annotations = annotations;
        this.implement = implement;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public String getModuleBasic() {
        return moduleBasic;
    }

    public CompanyOptions getCompany() {
        return company;
    }

    public String getPackage() {
        return packag;
    }

    public Set<String> getImports() {
        return Collections.unmodifiableSet(imports);
    }

    public String getClassName() {
        return className;
    }

    public String getClassNameBasic() {
        return classNameBasic;
    }

    public String getSuperClass() {
        return superClass;
    }

    public Set<String> getImplement() {
        return Collections.unmodifiableSet(implement);
    }

    public Set<TAttribute> getAttributes() {
        return Collections.unmodifiableSet(attributes);
    }

    public Set<TAnnotation> getAnnotations() {
        return Collections.unmodifiableSet(annotations);
    }
}
