package com.datacoper.maven.enums;

import com.datacoper.maven.metadata.TemplateAttributeModel;

public enum EnumDCAnnotation {

	DCSEQUENCE {
		@Override
		public String getAnnotation(TemplateAttributeModel attributeModel) {
			return null;
		}
	},
	DCCONTEXTFIELD_FILIAL {
		@Override
		public String getAnnotation(TemplateAttributeModel attributeModel) {
			String sequenceName = attributeModel.getTemplateModel().getEntityName().toUpperCase();
			
			sequenceName += "_"+attributeModel.getColumnName();
			
			return "@com.datacoper.cooperate.arquitetura.common.persistence.entity.DCSequence(\""+sequenceName+"\")";
		}
	},
	DCCONTEXTFIELD_USUARIO {
		@Override
		public String getAnnotation(TemplateAttributeModel attributeModel) {
			return "@com.datacoper.cooperate.arquitetura.common.persistence.entity.DCContextField(\"USUARIO\")";
		}
	},
	DCCONTEXTFIELD_GRUPOEMPRESARIAL {
		@Override
		public String getAnnotation(TemplateAttributeModel attributeModel) {
			return "@com.datacoper.cooperate.arquitetura.common.persistence.entity.DCContextField(\"GRUPOEMPRESARIAL\")";
		}
	},
	DCCONTEXTFIELD_EMPRESA {
		@Override
		public String getAnnotation(TemplateAttributeModel attributeModel) {
			return "@com.datacoper.cooperate.arquitetura.common.persistence.entity.DCContextField(\"EMPRESA\")";
		}
	},
	DCCURRENTDATE {
		@Override
		public String getAnnotation(TemplateAttributeModel attributeModel) {
			return "@com.datacoper.cooperate.arquitetura.common.persistence.entity.DCCurrentDate";
		}
	},
	
	;

	public abstract String getAnnotation(TemplateAttributeModel attributeModel);
	
	public static String[] toStringArray(){
		
		EnumDCAnnotation[] values = values();
		String[] types = new String[values.length];
		
		for (int i = 0; i < types.length; i++) {
			types[i] = values[i].name();
		}
		
		return types;
	}

	public static EnumDCAnnotation from(String value) {
		if(value != null) {
			EnumDCAnnotation[] values = values();
			
			for (EnumDCAnnotation enumModule : values) {
				if(enumModule.name().toLowerCase().equals(value.toLowerCase())) {
					return enumModule;
				}
			}
		}
		return null;
	}
}
