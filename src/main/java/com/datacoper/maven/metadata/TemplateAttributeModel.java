package com.datacoper.maven.metadata;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

import com.datacoper.maven.enums.EnumDCAnnotation;
import com.datacoper.maven.enums.EnumDCModule;

public class TemplateAttributeModel {

	private String columnName;
	
	private String name;

	private String type;
	
	private String typeSimpleName;
	
	private String typePackage;
	
	private String modulePackageName;
	
	private String label;

	private String mask;

	private int precision;

	private int scale;

	private boolean required;
	
	private boolean updatable;
	
	private EnumDCAnnotation enumAttributeOptions;

	private TemplateModel templateModel;
	
	public TemplateAttributeModel(TemplateModel templateModel,  String columnName, String name, String type, EnumDCModule moduleName, String label, EnumDCAnnotation enumAttributeOptions, String mask, int precision, int scale,
			boolean required, boolean updatable) {
		
		Objects.requireNonNull(templateModel);
		Objects.requireNonNull(columnName);
		Objects.requireNonNull(name);
		Objects.requireNonNull(type);
		Objects.requireNonNull(label);
		
		this.columnName = columnName;
		this.modulePackageName = moduleName != null ? moduleName.getModulePackageName() : ""; 
		this.name = name;
		this.label = label;
		this.enumAttributeOptions = enumAttributeOptions;
		this.mask = mask;
		this.precision = precision;
		this.scale = scale;
		this.required = required;
		this.updatable = updatable;
		
		this.type = type;
		
		int lastIndexOfPoint = type.lastIndexOf(".");
		
		this.typeSimpleName  = type.substring(lastIndexOfPoint+1, type.length());
		
		this.typePackage = type.substring(0, lastIndexOfPoint);
		
	}

	public TemplateModel getTemplateModel() {
		return templateModel;
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	public String getType() {
		return type;
	}
	
	public String getModulePackageName() {
		return modulePackageName;
	}
	
	public String getTypePackage() {
		return typePackage;
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

	public boolean isRequired() {
		return required;
	}
	
	public boolean isUpdatable() {
		return updatable;
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
				type.equals(Boolean.class.getName());
	}
	
	public boolean isEntity(){
		return typePackage.contains("entities");
	}
	
	public String getTypeSimpleName() {
		return typeSimpleName;
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
		
		if(isEntity()) {
			return "calculatedField";
		}
		
		return "";
	}
	
	
	public boolean hasDCAnnotation() {
		return enumAttributeOptions != null;
	}
	
	public String getDCAnnotation() {
		return enumAttributeOptions != null ? enumAttributeOptions.getAnnotation(this) : null;
	}
}
