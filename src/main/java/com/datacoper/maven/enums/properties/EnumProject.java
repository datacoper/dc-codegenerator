package com.datacoper.maven.enums.properties;

import static com.datacoper.maven.enums.properties.EnumPackagingType.EJB;
import static com.datacoper.maven.enums.properties.EnumPackagingType.JAR;
import static com.datacoper.maven.enums.properties.EnumPackagingType.POM;
import static com.datacoper.maven.enums.properties.EnumPackagingType.WAR;

public enum EnumProject {
	COMMON("Common", JAR),
    CLIENT("Client", JAR),
    SERVER("EM", EJB),
    REST("RestAPI", JAR),
    REST_COMMON("RestAPICommon", WAR),
    WEB("Web", WAR),
    PARENT("-Parent", POM);

    
    private final String qualifier;
    
    private final EnumPackagingType packaging;
    
    private EnumProject(String qualifier, EnumPackagingType packaging) {
        this.qualifier = qualifier;
        this.packaging = packaging;
    }

    public String getSuffix() {
        return qualifier;
    }
    
    public EnumPackagingType getPackagingType() {
        return packaging;
    }
}
