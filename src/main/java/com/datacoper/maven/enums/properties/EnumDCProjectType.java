/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.enums.properties;

import static com.datacoper.maven.enums.properties.EnumPackagingType.*;

/**
 *
 * @author alessandro.abegg
 */
public enum EnumDCProjectType {
    CLIENT("Client", JAR),
    SERVER("EM", EJB),
    COMMON("Common", JAR),
    REST("RestAPI", JAR),
    REST_COMMON("RestAPICommon", WAR),
    WEB("Web", WAR),
    PARENT("-Parent", POM);
    
    private final String qualifier;
    
    private final EnumPackagingType packaging;

    private EnumDCProjectType(String qualifier, EnumPackagingType packaging) {
        this.qualifier = qualifier;
        this.packaging = packaging;
    }

    public String getQualifier() {
        return qualifier;
    }

    public EnumPackagingType getPackagingType() {
        return packaging;
    }
}
