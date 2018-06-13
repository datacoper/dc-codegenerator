package com.datacoper.maven.enums.properties;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.util.StringUtil;

public enum EnumModules {
	
	AGRICOLA,
	AGRICOLACOOPERALFA,
	BUSINESSCORE,
	CAPITALSOCIAL,
	COMERCIAL,
	ESTOQUE,
	FATURAMENTO,
	FINANCEIRO,
	FISCAL,
	PRODUCAOINTEGRADA,
	PROGRAMASDOGOVERNO,
	SUINOS
	
	;
	
	public String resolveEntityType(Company company, String entityName) {
        return StringUtil.format("com.{0}.cooperate.{1}.common.entities.{2}", company.getPackageName(), name().toLowerCase(),entityName);
	}
	
	public static String[] toStringArray(){
		
		EnumModules[] values = values();
		String[] types = new String[values.length];
		
		for (int i = 0; i < types.length; i++) {
			types[i] = values[i].name();
		}
		
		return types;
	}
	
}
