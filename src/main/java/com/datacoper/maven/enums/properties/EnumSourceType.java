package com.datacoper.maven.enums.properties;

public enum EnumSourceType {
	JAVA("Java", "src.main.java"),
	RESOURCES("Resource", "src.main.resources"),
	RESOURCES_TEST("Resource Tests", "src.test.resources"),
	JAVA_TEST("Java Tests", "src.test.java"),
	XHTML("Web Pages", "");
	
	private final String description;
	
	private final String defaultPackage;

	private EnumSourceType(String description, String defaultPackage) {
		this.description = description;
		this.defaultPackage = defaultPackage;
	}
	
	public String getDescription() {
		return description;
	}

	public String getDefaultPackage() {
		return defaultPackage;
	}
}
