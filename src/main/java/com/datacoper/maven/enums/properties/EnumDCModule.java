package com.datacoper.maven.enums.properties;

import com.datacoper.maven.enums.options.Company;

public enum EnumDCModule {
	
	AGRICOLA("agricola"),	
	BUSINESSCORE("nucleo"),
	CAPITALSOCIAL("capitalsocial"),
	COMERCIAL("comercial"),
	ESTOQUE("estoque"),
	FATURAMENTO("faturamento"),
	FINANCEIRO("financeiro"),
	FISCAL("fiscal"),
	PRODUCAOINTEGRADA("producaointegrada"),
	PROGRAMASDOGOVERNO("programagoverno"),
	SUINOS("producaointegrada.suinos"),
	LEITE("producaointegrada.leite"),
	INDUSTRIA("industria"),
	CONTABIL("contabil"),
	INTEGRACOESSOFTWARETERCEIRO("integracaosoftwareterceiro"),
	INTEGRACOES("integracoes")
	;
	
	private String modulePackageName;
	
	private EnumDCModule(String modulePackageName) {
		this.modulePackageName = modulePackageName;
	}
	
	public String getModulePackageName() {
		return modulePackageName;
	}

	public String resolveCommonPackage(Company company) {
		
		String prefix = "com."+company.getPackageName()+".cooperate."+modulePackageName;
		
		//TODO so o BusinessCore e zuado :(
		if(this == EnumDCModule.BUSINESSCORE) {
			return prefix;
		}
		
		return prefix+"+common"; 
	}
	
	
	public static String[] toStringArray(){
		
		EnumDCModule[] values = values();
		String[] types = new String[values.length];
		
		for (int i = 0; i < types.length; i++) {
			types[i] = values[i].name();
		}
		
		return types;
	}

	public static EnumDCModule from(String value) {
		if(value != null) {
			EnumDCModule[] values = values();
			
			for (EnumDCModule enumModule : values) {
				if(enumModule.name().toLowerCase().equals(value.toLowerCase())) {
					return enumModule;
				}
			}
		}
		return null;
	}
}
