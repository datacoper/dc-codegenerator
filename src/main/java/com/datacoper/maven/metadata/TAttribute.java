package com.datacoper.maven.metadata;


import com.datacoper.maven.enums.options.BooleanOptions;
import com.datacoper.maven.enums.options.ModifierOptions;
import com.datacoper.maven.util.StringUtil;
import java.util.Collections;
import java.util.Set;

public class TAttribute {

    private final String importt;
    
    private final ModifierOptions encapsulation;

    private final BooleanOptions staticAttribute;
    
    private final BooleanOptions finalAttribute;
    
    private final String name;
    
    private final String alias;

    private final BooleanOptions generateGet;

    private final BooleanOptions generateSet;
    
    private final Set<TAnnotation> annotations;

    public TAttribute(String importt, ModifierOptions encapsulation, BooleanOptions staticAttribute, BooleanOptions finalAttribute, String name, String alias, BooleanOptions generateGet, BooleanOptions generateSet, Set<TAnnotation> annotations) {
        this.importt = importt;
        this.encapsulation = encapsulation;
        this.staticAttribute = staticAttribute;
        this.finalAttribute = finalAttribute;
        this.name = name;
        this.alias = alias;
        this.generateGet = generateGet;
        this.generateSet = generateSet;
        this.annotations = annotations;
    }

    public String getImport() {
        return importt;
    }
    
    public String getType() {
        return StringUtil.getLastString(importt, ".");
    }

    public ModifierOptions getEncapsulation() {
        return encapsulation;
    }

    public BooleanOptions isStaticAttribute() {
        return staticAttribute;
    }

    public BooleanOptions isFinalAttribute() {
        return finalAttribute;
    }

    public String getName() {
        return name;
    }
    
    public String getAlias() {
		return alias;
	}

    public BooleanOptions getGenerateGet() {
        return generateGet;
    }

    public BooleanOptions getGenerateSet() {
        return generateSet;
    }

    public Set<TAnnotation> getAnnotations() {
        return Collections.unmodifiableSet(annotations);
    }
}
