package com.datacoper.maven.enums;

public enum Company {
    DATACOPER("Datacoper", "datacoper"),
    ALFA("Agricola Cooperalfa" , "cooperalfa");
    
    private final String name;
    
    private final String packageName;
    
    
    private Company(String name, String packageName) {
		this.name = name;
		this.packageName = packageName;
	}

    public String getName() {
        return name;
    }
    
    public String getPackageName() {
		return packageName;
	}

}
