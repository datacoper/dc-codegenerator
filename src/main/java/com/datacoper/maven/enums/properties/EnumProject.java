package com.datacoper.maven.enums.properties;

import static com.datacoper.maven.enums.properties.EnumPackagingType.EJB;
import static com.datacoper.maven.enums.properties.EnumPackagingType.JAR;
import static com.datacoper.maven.enums.properties.EnumPackagingType.POM;
import static com.datacoper.maven.enums.properties.EnumPackagingType.WAR;

public enum EnumProject {
	COMMON("Common", JAR, EnumSourceFolder.JAVA),
    CLIENT("Client", JAR, EnumSourceFolder.JAVA),
    SERVER("EM", EJB, EnumSourceFolder.JAVA),
    REST("RestAPI", JAR, EnumSourceFolder.JAVA),
    REST_COMMON("RestAPICommon", WAR, EnumSourceFolder.JAVA),
    WEB("Web", WAR, EnumSourceFolder.JAVA),
    PARENT("-Parent", POM, EnumSourceFolder.JAVA),
    ANGULAR("Angular", WAR, EnumSourceFolder.ANGULAR)
    
    ;
	
    private final String qualifier;
    
    private final EnumPackagingType packaging;
    
    private final EnumSourceFolder sourceFolder;
    
    private EnumProject(String qualifier, EnumPackagingType packaging, EnumSourceFolder sourceFolder) {
        this.qualifier = qualifier;
        this.packaging = packaging;
        this.sourceFolder = sourceFolder;
    }

    public String getSuffix() {
        return qualifier;
    }
    
    public EnumPackagingType getPackagingType() {
        return packaging;
    }
    
    public EnumSourceFolder getSourceFolder() {
		return sourceFolder;
	}
}
