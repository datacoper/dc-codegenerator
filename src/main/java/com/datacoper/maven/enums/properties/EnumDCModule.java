package com.datacoper.maven.enums.properties;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.util.StringUtil;

public enum EnumDCModule {
	
	AGRICOLA("com.{0}.cooperate.agricola.common.entities.{1}", "agricola"),	
	BUSINESSCORE("com.{0}.cooperate.nucleo.entities.{1}", "nucleo"),
	CAPITALSOCIAL("com.{0}.cooperate.capitalsocial.common.entities.{1}", "capitalsocial"),
	COMERCIAL("com.{0}.cooperate.comercial.common.entities.{1}", "comercial"),
	ESTOQUE("com.{0}.cooperate.estoque.common.entities.{1}", "estoque"),
	FATURAMENTO("com.{0}.cooperate.faturamento.common.entities.{1}", "faturamento"),
	FINANCEIRO("com.{0}.cooperate.financeiro.common.entities.{1}", "financeiro"),
	FISCAL("com.{0}.cooperate.fiscal.common.entities.{1}", "fiscal"),
	PRODUCAOINTEGRADA("com.{0}.cooperate.producaointegrada.common.entities.{1}", "producaointegrada"),
	PROGRAMASDOGOVERNO("com.{0}.cooperate.programagoverno.common.entities.{1}", "programagoverno"),
	SUINOS("com.{0}.cooperate.producaointegrada.suinos.common.entities.{1}", "producaointegrada.suinos"),
	LEITE("com.{0}.cooperate.producaointegrada.leite.common.entities.{1}", "producaointegrada.leite"),
	INDUSTRIA("com.{0}.cooperate.industria.common.entities.{1}", "industria"),
	CONTABIL("com.{0}.cooperate.contabil.common.entities.{1}", "contabil"),
	INTEGRACOESSOFTWARETERCEIRO("com.{0}.cooperate.integracaosoftwareterceiro.common.entities.{1}", "integracaosoftwareterceiro"),
	INTEGRACOES("com.{0}.cooperate.integracoes.common.entities.{1}", "integracoes")
	;
	
	private String entityPackagePattern;
	private String modulePackageName;
	
	private EnumDCModule(String entityPackagePattern, String modulePackageName) {
		this.entityPackagePattern = entityPackagePattern;
		this.modulePackageName = modulePackageName;
	}

	public String getModulePackageName() {
		return modulePackageName;
	}
	
	public String resolveEntityType(Company company, String entityName) {
        return StringUtil.format(entityPackagePattern, company.getPackageName(), entityName);
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
