package com.datacoper.maven.metadata;

import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.datacoper.maven.enums.options.CompanyOptions;

public class TemplateModel {
    
	private File projectParentFile;
	
	private CompanyOptions company = CompanyOptions.DATACOPER;
	
	private String entityName;
	
    private String moduleBasic;

    private String packag;

    private Set<String> imports = new HashSet<>();

    private String className;
    
    private String classNameBasic;

    private String superClass;

    private Set<String> implement = new HashSet<>();

    private Set<TemplateAttributeModel> attributes = new HashSet<>();

    private Set<TemplateAnnotationModel> annotations = new HashSet<>();
    
    public TemplateModel(File projectParentFile, String moduleBasic) {
		this.projectParentFile = projectParentFile;
		this.moduleBasic = moduleBasic;
	}
    
    public File getProjectParentFile() {
		return projectParentFile;
	}
    
	public CompanyOptions getCompany() {
		return company;
	}
    
    public String getModuleBasic() {
        return moduleBasic;
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

    public Set<TemplateAttributeModel> getAttributes() {
        return Collections.unmodifiableSet(attributes);
    }

    public Set<TemplateAnnotationModel> getAnnotations() {
        return Collections.unmodifiableSet(annotations);
    }

	public String getPackag() {
		return packag;
	}

	public void setPackag(String packag) {
		this.packag = packag;
	}

	public void setCompany(CompanyOptions company) {
		this.company = company;
	}

	public void setImports(Set<String> imports) {
		this.imports = imports;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setClassNameBasic(String classNameBasic) {
		this.classNameBasic = classNameBasic;
	}

	public void setSuperClass(String superClass) {
		this.superClass = superClass;
	}

	public void setImplement(Set<String> implement) {
		this.implement = implement;
	}

	public void setAttributes(Set<TemplateAttributeModel> attributes) {
		this.attributes = attributes;
	}

	public void setAnnotations(Set<TemplateAnnotationModel> annotations) {
		this.annotations = annotations;
	}
    
	public String getEntityName() {
		return entityName;
	}
	
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
}
