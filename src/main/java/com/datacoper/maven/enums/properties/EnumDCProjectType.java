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
    CLIENT("Client", JAR, EnumSourceType.JAVA),
    CLIENT_TEST("Client", JAR, EnumSourceType.JAVA_TEST),
    SERVER("EM", EJB, EnumSourceType.JAVA),
    SERVER_TEST("EM", EJB, EnumSourceType.JAVA_TEST),
    COMMON("Common", JAR, EnumSourceType.JAVA),
    COMMON_TEST("Common", JAR, EnumSourceType.JAVA_TEST),
    REST("RestAPI", JAR, EnumSourceType.JAVA),
    REST_TEST("RestAPI", JAR, EnumSourceType.JAVA_TEST),
    REST_COMMON("RestAPICommon", WAR, EnumSourceType.JAVA),
    REST_COMMON_TEST("RestAPICommon", WAR, EnumSourceType.JAVA_TEST),
    WEB("Web", WAR, EnumSourceType.JAVA),
    WEB_TEST("Web", WAR, EnumSourceType.JAVA_TEST),
    WEB_PAGES("Web", WAR, EnumSourceType.XHTML),
    PARENT("-Parent", POM, null);
    
    private final String qualifier;
    
    private final EnumPackagingType packaging;
    
    private final EnumSourceType sourceType;

    private EnumDCProjectType(String qualifier, EnumPackagingType packaging, EnumSourceType sourceType) {
        this.qualifier = qualifier;
        this.packaging = packaging;
        this.sourceType = sourceType;
    }

    public String getQualifier() {
        return qualifier;
    }

    public EnumPackagingType getPackagingType() {
        return packaging;
    }
    
    public EnumSourceType getSourceType() {
		return sourceType;
	}
}
