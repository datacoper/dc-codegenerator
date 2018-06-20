package com.datacoper.maven.enums;

import com.datacoper.cooperate.arquitetura.common.persistence.entities.DCContextField;
import com.datacoper.cooperate.arquitetura.common.persistence.entities.DCContextInfo;
import com.datacoper.cooperate.arquitetura.common.persistence.entities.DCCurrentDate;
import com.datacoper.cooperate.arquitetura.common.persistence.entities.DCSequence;
import com.datacoper.maven.metadata.TemplateAttributeModel;

public enum EnumDCAnnotation {

	DCSEQUENCE {
		@Override
		public String getAnnotation(TemplateAttributeModel attributeModel) {
			String sequenceName = attributeModel.getTemplateModel().getEntityName().toUpperCase();
			sequenceName += "_"+attributeModel.getColumnName();
			return "@"+DCSequence.class.getName()+"(\""+sequenceName+"\")";
		}
	},
	DCCONTEXTFIELD_FILIAL {
		@Override
		public String getAnnotation(TemplateAttributeModel attributeModel) {
			return "@"+DCContextInfo.class.getName()+"("+DCContextField.FILIAL.name()+")";
		}
	},
	DCCONTEXTFIELD_USUARIO {
		@Override
		public String getAnnotation(TemplateAttributeModel attributeModel) {
			return "@"+DCContextInfo.class.getName()+"("+DCContextField.USUARIO.name()+")";
		}
	},
	DCCONTEXTFIELD_GRUPOEMPRESARIAL {
		@Override
		public String getAnnotation(TemplateAttributeModel attributeModel) {
			return "@"+DCContextInfo.class.getName()+"("+DCContextField.GRUPOEMPRESARIAL.name()+")";
		}
	},
	DCCONTEXTFIELD_EMPRESA {
		@Override
		public String getAnnotation(TemplateAttributeModel attributeModel) {
			return "@"+DCContextInfo.class.getName()+"("+DCContextField.EMPRESA.name()+")";
		}
	},
	DCCURRENTDATE {
		@Override
		public String getAnnotation(TemplateAttributeModel attributeModel) {
			return "@"+DCCurrentDate.class.getName();
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
			
			for (EnumDCAnnotation enumDCAnnotation : values) {
				if(enumDCAnnotation.name().toLowerCase().equals(value.toLowerCase())) {
					return enumDCAnnotation;
				}
			}
		}
		return null;
	}
}
