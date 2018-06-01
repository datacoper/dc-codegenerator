package com.datacoper.maven.enums.options;

public enum CompanyOptions {
    DATACOPER("Datacoper", "datacoper"),
    ALFA("Agricola Cooperalfa" , "cooperalfa");
    
    private final String name;
    
    private final String packageName;
    
    
    private CompanyOptions(String name, String packageName) {
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
