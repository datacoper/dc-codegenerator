/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.enums.properties;

/**
 *
 * @author aline.cardoso
 */
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
