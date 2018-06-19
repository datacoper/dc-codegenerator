package com.datacoper.maven.enums;

public enum EnumSourceFolder {

	JAVA("src/main/java"),
	ANGULAR("src/main/webapp/app")
	
	;
	
	private String sourceFolder;

	private EnumSourceFolder(String sourceFolder) {
		this.sourceFolder = sourceFolder;
	}
	
	public String getSourceFolder() {
		return sourceFolder;
	}
	
}
