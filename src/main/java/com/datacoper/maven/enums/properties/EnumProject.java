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
<<<<<<< HEAD:src/main/java/com/datacoper/maven/enums/properties/EnumProject.java
public enum EnumProject {
	COMMON("Common", JAR),
    CLIENT("Client", JAR),
    SERVER("EM", EJB),
    REST("RestAPI", JAR),
    REST_COMMON("RestAPICommon", WAR),
    WEB("Web", WAR),
    PARENT("-Parent", POM);
=======
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
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089:src/main/java/com/datacoper/maven/enums/properties/EnumDCProjectType.java
    
    private final String qualifier;
    
    private final String agrupador;
    
    private final EnumPackagingType packaging;
    
    private final EnumSourceType sourceType;

<<<<<<< HEAD:src/main/java/com/datacoper/maven/enums/properties/EnumProject.java
    private EnumProject(String qualifier, EnumPackaging packaging) {
=======
    private EnumDCProjectType(String qualifier, String agrupador, EnumPackagingType packaging, EnumSourceType sourceType) {
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089:src/main/java/com/datacoper/maven/enums/properties/EnumDCProjectType.java
        this.qualifier = qualifier;
        this.agrupador = agrupador;
        this.packaging = packaging;
        this.sourceType = sourceType;
    }

    public String getSuffix() {
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
