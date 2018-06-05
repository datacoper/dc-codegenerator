package com.datacoper.maven.metadata;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public enum EnumAttributeType {

	STRING(String.class),
	INTEGER(Integer.class),
	LONG(Long.class),
	BYTE(Byte.class),
	DATE(Date.class),
	TIMESTAMP(Timestamp.class),
	BIGDECIMAL(BigDecimal.class);
	
	private Class<?> type;

	private EnumAttributeType(Class<?> type) {
		this.type = type;
	}
	
	public Class<?> getType() {
		return type;
	}
	
	public static String[] types(){
		
		EnumAttributeType[] values = values();
		String[] types = new String[values.length];
		
		for (int i = 0; i < types.length; i++) {
			types[i] = values[i].type.getName();
		}
		
		return types;
	}
	
}
