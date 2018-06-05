package com.datacoper.maven.enums.properties;

public enum EnumPackagingType {
    JAR("jar"),
    POM("pom"),
    EJB("ejb"),
    WAR("war"),
    EAR("ear");
    
    private final String packaging;

    private EnumPackagingType(String packag) {
        this.packaging = packag;
    }

    public String getName() {
        return packaging;
    }
}
