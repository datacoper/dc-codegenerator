package com.datacoper.maven.enums;

public enum EnumDCModule {
	
	AGRICOLA("Agricola", "agricola"),
	ARQUITETURA("Arquitetura","arquitetura"),
	BUSINESSCORE("BusinnesCore", "nucleo"),
	CAPITALSOCIAL("CapitalSocial", "capitalsocial"),
	COMERCIAL("Comercial", "comercial"),
	ESTOQUE("Estoque", "estoque"),
	FATURAMENTO("Faturamento","faturamento"),
	FINANCEIRO("Financeiro","financeiro"),
	FISCAL("Fiscal","fiscal"),
	PRODUCAOINTEGRADA("ProducaoIntegrada","producaointegrada"),
	PROGRAMASDOGOVERNO("ProgramaGoverno","programagoverno"),
	SUINOS("Suinos","producaointegrada.suinos"),
	LEITE("Leite","producaointegrada.leite"),
	INDUSTRIA("Industria","industria"),
	CONTABIL("Contabil","contabil"),
	INTEGRACOESSOFTWARETERCEIRO("IntegracaoSoftwareTerceiro","integracaosoftwareterceiro"),

	INTEGRACOESCOOPERALFA("IntegracoesCooperalfa","integracoescooperalfa"),
	INEGRACOESCOOPERALFAFATURAMENTO("IntegracoesCooperalfaFaturamento","integracoescooperalfafaturamento"),

	INTEGRACOES("IntegracoesEE","integracoes")
	;
	
	private String modulePackageName;
	
	private String moduleName;
	
	private EnumDCModule(String moduleName, String modulePackageName) {
		this.moduleName = moduleName;
		this.modulePackageName = modulePackageName;
	}
	
	public String getModuleName() {
		return moduleName;
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
		
		return prefix+".common"; 
	}
	
	
	public static String[] toStringArray(){
		
		EnumDCModule[] values = values();
		String[] types = new String[values.length];
		
		for (int i = 0; i < types.length; i++) {
			types[i] = values[i].getModuleName();
		}
		
		return types;
	}

	public static EnumDCModule from(String value) {
		if(value != null) {
			EnumDCModule[] values = values();
			
			value = value.toLowerCase();
			
			for (EnumDCModule enumModule : values) {
				if(enumModule.getModuleName().toLowerCase().equals(value)) {
					return enumModule;
				}
				
				if(enumModule.name().toLowerCase().equals(value)) {
					return enumModule;
				}
			}
		}
		return null;
	}
}
