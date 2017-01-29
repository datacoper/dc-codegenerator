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
    CLIENT("Client", "client", JAR, EnumSourceType.JAVA),
    CLIENT_TEST("Client", "client", JAR, EnumSourceType.JAVA_TEST),
    SERVER("EM", "server", EJB, EnumSourceType.JAVA),
    SERVER_TEST("EM", "server", EJB, EnumSourceType.JAVA_TEST),
    COMMON("Common", "common", JAR, EnumSourceType.JAVA),
    COMMON_TEST("Common", "common", JAR, EnumSourceType.JAVA_TEST),
    REST("RestAPI", "restapi", WAR, EnumSourceType.JAVA),
    REST_TEST("RestAPI", "restapi", WAR, EnumSourceType.JAVA_TEST),
    REST_COMMON("RestAPICommon", "restapicommon", JAR, EnumSourceType.JAVA),
    REST_COMMON_TEST("RestAPICommon", "restapicommon", JAR, EnumSourceType.JAVA_TEST),
    WEB("Web", "client", WAR, EnumSourceType.JAVA),
    WEB_TEST("Web", "client", WAR, EnumSourceType.JAVA_TEST),
    WEB_PAGES("Web", "client", WAR, EnumSourceType.XHTML),
    PARENT("-Parent", "parent", POM, null);
    
    private final String qualifier;
    
    private final String agrupador;
    
    private final EnumPackagingType packaging;
    
    private final EnumSourceType sourceType;

    private EnumDCProjectType(String qualifier, String agrupador, EnumPackagingType packaging, EnumSourceType sourceType) {
        this.qualifier = qualifier;
        this.agrupador = agrupador;
        this.packaging = packaging;
        this.sourceType = sourceType;
    }

    public String getQualifier() {
        return qualifier;
    }
    
    public String getAgrupador() {
		return agrupador;
	}

    public EnumPackagingType getPackagingType() {
        return packaging;
    }
    
    public EnumSourceType getSourceType() {
		return sourceType;
	}
}
