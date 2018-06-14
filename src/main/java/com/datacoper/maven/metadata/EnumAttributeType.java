package com.datacoper.maven.metadata;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import com.datacoper.Entity;

public enum EnumAttributeType {

	STRING(String.class),
	INTEGER(Integer.class),
	LONG(Long.class),
	BOOLEAN(Boolean.class),
	DATE(Date.class),
	TIMESTAMP(Timestamp.class),
	BIGDECIMAL(BigDecimal.class),
	ENTITY(Entity.class)
	
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
		
		throw new IllegalArgumentException("Invalid type of: "+EnumAttributeType.class.getName()+": "+type);
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
