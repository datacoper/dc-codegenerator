package com.datacoper.maven.metadata;

import java.math.BigDecimal;
import java.util.Date;

public enum EnumAttributeType {

	STRING(String.class),
	INTEGER(Integer.class),
	LONG(Long.class),
	BOOLEAN(Boolean.class),
	DATE(Date.class),
	BIGDECIMAL(BigDecimal.class),
	;
	
	private Class<?> type;

	private EnumAttributeType(Class<?> type) {
		this.type = type;
	}
	
	public Class<?> getType() {
		return type;
	}
	
	public static EnumAttributeType from(String type) {
		EnumAttributeType[] values = values();
		for (EnumAttributeType enumAttributeType : values) {
			if(enumAttributeType.type.getName().equals(type)) {
				return enumAttributeType;
			}
		}
		
		return null;
	}
	
	public static String[] toStringArray(){
		
		EnumAttributeType[] values = values();
		String[] types = new String[values.length];
		
		for (int i = 0; i < types.length; i++) {
			types[i] = values[i].type.getName();
		}
		
		return types;
	}
	
}
