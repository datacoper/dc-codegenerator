package com.datacoper.maven.metadata;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.util.StringUtil;
import java.util.Collections;
import java.util.Set;

public class TClass implements TAbstract {
    
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
    
    public TClass(CompanyOptions empresa, String packag, String className, String classNameBasic, String superClass, Set<String> imports, Set<String> implement, Set<TAttribute> attributes, Set<TAnnotation> annotations) {
        this(empresa, "", packag, className, classNameBasic, superClass, imports, implement, attributes, annotations);
    }
    
    public TClass(CompanyOptions empresa, String moduleBasic, String packag, String className, String classNameBasic, String superClass, Set<String> imports, Set<String> implement, Set<TAttribute> attributes, Set<TAnnotation> annotations) {
        this.company = empresa;
        this.moduleBasic = moduleBasic;
        this.packag = packag;
        this.className = StringUtil.upperFirstCharacter(className);
        this.classNameBasic = StringUtil.upperFirstCharacter(classNameBasic);
        this.superClass = superClass;
        this.imports = imports;
        this.attributes = attributes;
        this.annotations = annotations;
        this.implement = implement;
    }

    @Override
    public String getModuleBasic() {
        return moduleBasic;
    }

    @Override
    public CompanyOptions getCompany() {
        return company;
    }

    @Override
    public String getPackage() {
        return packag;
    }

    public Set<String> getImports() {
        return Collections.unmodifiableSet(imports);
    }

    @Override
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
