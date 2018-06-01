/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.enums.properties;

import static com.datacoper.maven.enums.properties.EnumPackaging.*;

/**
 *
 * @author alessandro.abegg
 */
public enum EnumProject {
	COMMON("Common", JAR),
    CLIENT("Client", JAR),
    SERVER("EM", EJB),
    REST("RestAPI", JAR),
    REST_COMMON("RestAPICommon", WAR),
    WEB("Web", WAR),
    PARENT("-Parent", POM);
    
    private final String qualifier;
    
    private final EnumPackaging packaging;

    private EnumProject(String qualifier, EnumPackaging packaging) {
        this.qualifier = qualifier;
        this.packaging = packaging;
    }

    public String getSuffix() {
        return qualifier;
    }

    public EnumPackaging getPackaging() {
        return packaging;
    }
}
