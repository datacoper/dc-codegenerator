package com.datacoper.maven.metadata;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class TemplateAttributeModel {

	private String name;

	private String type;

	private String label;

	private String mask;

	private int precision;

	private int scale;

	private boolean nullable;
	
	private boolean required;

	public TemplateAttributeModel(String name, String type, String label, String mask, int precision, int scale,
			boolean nullable) {
		
		Objects.requireNonNull(name);
		Objects.requireNonNull(type);
		Objects.requireNonNull(label);
		
		this.name = name;
		this.type = type;
		this.label = label;
		this.mask = mask;
		this.precision = precision;
		this.scale = scale;
		this.nullable = nullable;
		this.required = !nullable;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getLabel() {
		return label;
	}

	public String getMask() {
		return mask;
	}

	public int getPrecision() {
		return precision;
	}

	public int getScale() {
		return scale;
	}

	public boolean isNullable() {
		return nullable;
	}
	
	public boolean isRequired() {
		return required;
	}
	
	public boolean isNumber() {
		return type.equals(Integer.class.getName()) ||
				type.equals(Long.class.getName()) ||
				type.equals(int.class.getName()) ||
				type.equals(long.class.getName());
	}
	
	public boolean isDate() {
		return type.equals(Date.class.getName()) ||
				type.equals(java.sql.Date.class.getName()) ||
				type.equals(Timestamp.class.getName());
	}
	
	public boolean isText() {
		return type.equals(String.class.getName()) ||
				type.equals(Character.class.getName());
	}
	
	public boolean isDecimal() {
		return type.equals(Double.class.getName()) ||
				type.equals(double.class.getName()) ||
				type.equals(BigDecimal.class.getName());
	}
	
	public boolean isBoolean() {
		return type.equals(boolean.class.getName()) ||
				type.equals(Boolean.class.getName()) ||
				type.equals(Byte.class.getName()) ||
				type.equals(byte.class.getName());
	}
	
	public String getFrontType() {
		if(isText()) {
			return "text";
		}
		if(isNumber() || isDecimal()) {
			return "number";
		}
		
		if(isDate()) {
			return "date";
		}
		
		if(isBoolean()) {
			return "boolean";
		}
		
		return "seletor";
	}
	
}
